package com.example.demo.controller.meun;

import com.example.demo.entity.meun.meun;
import com.example.demo.service.meun.meunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "meun")
public class GetMeunController {

    @GetMapping("/getAllMeun")
    @ResponseBody
    public List<meun> selectAllMeun(){
        return null;
    }

}
