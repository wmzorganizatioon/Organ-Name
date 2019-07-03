package com.example.demo.dao.meun;

import com.example.demo.entity.meun.Meun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeunReposity {

    //获取所有的菜单
    List<Meun> getQueryAllMeun();

}
