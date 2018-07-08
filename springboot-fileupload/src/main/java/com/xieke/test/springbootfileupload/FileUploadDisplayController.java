package com.xieke.test.springbootfileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 图片的上传与显示
 *
 * @author: jun hu
 * @date: 2018/6/26 9:28
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/file")
public class FileUploadDisplayController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadDisplayController.class);
    
    @Value("${fileUpload.uploadDir}")
    private String uploadDir;

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadDisplayController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    //显示图片 匹配路径如：localhost:8080/file/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png
    @GetMapping(value = "/{filename:.+}", produces={"image/jpeg","image/png","image/gif"})
    public Object getFile(@PathVariable String filename) {
        return resourceLoader.getResource("file:" + Paths.get(uploadDir, filename).toString());
    }

    @PostMapping("/upload")
    public Object handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
            log.info("[文件类型] - [{}]", file.getContentType());
            log.info("[文件名称] - [{}]", file.getOriginalFilename());
            log.info("[文件大小] - [{}]", file.getSize());
            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID().toString() + prefix;

            File folder = new File(uploadDir);
            //文件夹路径不存在
            if (!folder.exists() && !folder.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:[{}]", uploadDir);
                folder.mkdirs();
            } else {
                log.info("文件夹路径存在:[{}]", uploadDir);
            }

            Files.copy(file.getInputStream(), Paths.get(uploadDir, fileName));
            log.info("[存储文件名称] - [{}]", fileName);
            Map<String, String> result = new HashMap<>(16);
            result.put("contentType", file.getContentType());
            result.put("fileName", fileName);
            result.put("fileSize", file.getSize() + "");
            return result;
    }

}