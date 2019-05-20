package com.example.demo.controller.meun;

import com.example.demo.entity.meun.meun;
import com.example.demo.service.meun.meunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "meun")
public class GetMeunController {

    @GetMapping("/getAllMeun")
    @ResponseBody
    public List<meun> selectAllMeun(){
        return null;
    }

    @PostMapping("/getMeun")
    @CrossOrigin(value = "http://localhost:8099",maxAge = 1800,allowedHeaders = "*")
    public String selectMeun(){
        return "成功进入8091端口";
    }
}
