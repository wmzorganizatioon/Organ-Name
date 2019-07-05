package com.example.demo.controller.export;

import com.example.demo.entity.user.User;
import com.example.demo.service.export.ExportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *@Author 86151
 *@date 2019/7/4 23:08
 *@description 导出文件功能
 *return
 */
@Controller
public class ExportDataController {

    @Autowired
    ExportDataService exportDataService;

    @GetMapping("/export")
    public void exportTests(HttpServletResponse response) {

        try {
            List<User> list = exportDataService.listAllUser();
            exportDataService.exportTest(list, response);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

}
