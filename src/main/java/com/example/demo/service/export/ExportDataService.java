package com.example.demo.service.export;

import com.example.demo.entity.user.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ExportDataService {

    void exportTest(List<User> list, HttpServletResponse response) throws IOException;

    List<User> listAllUser();
}
