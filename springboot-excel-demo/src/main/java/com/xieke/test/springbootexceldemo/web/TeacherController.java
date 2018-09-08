package com.xieke.test.springbootexceldemo.web;

import com.xieke.test.springbootexceldemo.pojo.Teacher;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private List<Teacher> initData() {
        List<Teacher> list = new ArrayList<>();
        int i = 0;
        while (i < 10) {
            i++;
            Teacher teacher = new Teacher();
            teacher.setNo("T000" + i);
            teacher.setAge(25);
            teacher.setEmail("5566456" + i + "@qq.com");
            teacher.setName("美女" + i);
            teacher.setPhone("1334525589" + (i-1));
            teacher.setSex("女");
            teacher.setType("实习教师");
            list.add(teacher);
        }
        return list;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/exportExcelDownload")
    public void exportExcelDownload(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("教师信息表");

        List<Teacher> teachers = initData();

        //设置要导出的文件的名字
        String fileName = "教师信息表" + new Date().getTime() + ".xls";

        String[] headers = {"编号", "姓名", "年龄", "性别", "手机", "邮箱", "类型"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        //在表中存放数据，放入到对应的列
        for (Teacher teacher : teachers) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(teacher.getNo());
            row1.createCell(1).setCellValue(teacher.getName());
            row1.createCell(2).setCellValue(teacher.getAge());
            row1.createCell(3).setCellValue(teacher.getSex());
            row1.createCell(4).setCellValue(teacher.getPhone());
            row1.createCell(5).setCellValue(teacher.getEmail());
            row1.createCell(6).setCellValue(teacher.getType());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @RequestMapping(value = "/importExcel")
    public @ResponseBody List<Teacher> importExcel() throws IOException {
        Resource resource = new ClassPathResource("excel/教师信息表1536385690446.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(resource.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);
        //表头行
        //HSSFRow row = sheet.getRow(0);
        //数据行
        List<Teacher> list = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            HSSFRow row1 = sheet.getRow(i);
            Teacher teacher = new Teacher();
            teacher.setNo(row1.getCell(0).getStringCellValue());
            teacher.setName(row1.getCell(1).getStringCellValue());
            teacher.setAge(new Double(row1.getCell(2).getNumericCellValue()).intValue());
            teacher.setSex(row1.getCell(3).getStringCellValue());
            teacher.setPhone(row1.getCell(4).getStringCellValue());
            teacher.setEmail(row1.getCell(5).getStringCellValue());
            teacher.setType(row1.getCell(6).getStringCellValue());
            list.add(teacher);
        }
        return list;
    }

    @PostMapping("/importEmp")
    public @ResponseBody List<Teacher> importEmp(@RequestParam("file") MultipartFile file) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);
        //表头行
        //HSSFRow row = sheet.getRow(0);
        //数据行
        List<Teacher> list = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            HSSFRow row1 = sheet.getRow(i);
            Teacher teacher = new Teacher();
            teacher.setNo(row1.getCell(0).getStringCellValue());
            teacher.setName(row1.getCell(1).getStringCellValue());
            teacher.setAge(new Double(row1.getCell(2).getNumericCellValue()).intValue());
            teacher.setSex(row1.getCell(3).getStringCellValue());
            teacher.setPhone(row1.getCell(4).getStringCellValue());
            teacher.setEmail(row1.getCell(5).getStringCellValue());
            teacher.setType(row1.getCell(6).getStringCellValue());
            list.add(teacher);
        }
        return list;
    }

}