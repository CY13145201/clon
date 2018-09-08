package com.xieke.test.springbootfiledownloaddemo.web;

import com.xieke.test.springbootfiledownloaddemo.util.FileDownloadUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileDownloadController {

    @RequestMapping(value = "/download1")
    public void download1(HttpServletResponse res) throws IOException {
        Resource resource = new ClassPathResource("file/1522420433786.jpg");
        File file = resource.getFile();
        FileDownloadUtils.download(res,file.getPath());
    }

    @RequestMapping(value = "/download2")
    public void download2(HttpServletResponse res) throws IOException {
        Resource resource = new ClassPathResource("file/权限管理系统.doc");
        File file = resource.getFile();
        FileDownloadUtils.download(res,file.getPath());
    }

}
