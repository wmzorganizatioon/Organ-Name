package com.example.demo.service.export.impl;

import com.example.demo.dao.login.UserLoginRepository;
import com.example.demo.entity.user.User;
import com.example.demo.service.export.ExportDataService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *@Author 86151
 *@date 2019/7/4 21:41
 *@description 导出数据功能
 *return
 */
@Service
public class ExportDataServiceImpl implements ExportDataService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    //设置样式
    private CellStyle getColumnTopStyle(Workbook workbook) {
        CellStyle cellStyle=workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        //设置自动换行
        cellStyle.setWrapText(false);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    //写入excel
    @Override
    public void exportTest(List<User> list, HttpServletResponse response) throws IOException {
        File file = new File("用来测试的表.xlsx");

        //①设置表的样式
        Workbook workbook=new XSSFWorkbook();

        //②表格化布局
        CellStyle cellStyle = getColumnTopStyle(workbook);

        Sheet sheet = workbook.createSheet("用户表");  //③表格取名

        int index = 0;

        Row row = sheet.createRow(index++);

        //④设置第一行为题名
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("身份证号");

        //⑤把查询结果放入到对应的列

        for (User user :list){
            Row row1 = sheet.createRow(index++);
            row1.createCell(0).setCellValue(user.getName());
            row1.createCell(1).setCellValue(String.valueOf(user.getIdCard()));
        }

        for(int m=0;m<=sheet.getLastRowNum();m++){
            Row rowStyle=sheet.getRow(m);
            for(int n=0;n<rowStyle.getLastCellNum();n++){
                rowStyle.getCell(n).setCellStyle(cellStyle);
            }
        }

        //⑥响应的请求
        response.reset();
        response.setHeader("Content-Disposition","attachment;filename=\""+new String(file.getName().getBytes("utf-8"),"ISO8859-1")+"\"");
        response.setContentType("application/octet-stream;charset=UTF-8");

        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());

        workbook.write(outputStream);

        outputStream.flush();

        if(outputStream != null){
            outputStream.close();
        }

        if(workbook != null){
            workbook.close();
        }

    }

    /**
     *@Author 86151
     *@Date 2019/7/4 23:20
     *Description 查询出所有的数据
     @Param
     *return
     */
    @Override
    public List<User> listAllUser() {
        return userLoginRepository.queryAllUser();
    }
}
