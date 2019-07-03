package com.example.demo.service.meun;

import com.example.demo.entity.meun.Meun;

import java.util.List;

public interface MeunService {

    /**
    * 获取所有的菜单
     *
    * **/
    List<Meun> getQueryAllMeuns();
}
