package com.example.demo.controller;

import com.example.demo.entity.meun.Meun;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author:wisdom
 * effect:测试是否连接数据库成功
 * **/
@RestController
public class JdbcController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/jdbc")
    public List<Meun> getListMeun(ModelMap map){

        String sql  = "SELECT * FROM sys_meun";

        List<Meun> meuns = jdbcTemplate.query(sql, new RowMapper<Meun>() {
            Meun meun;

            @Override
            public Meun mapRow(ResultSet resultSet, int i) throws SQLException {
                meun = new Meun();
                meun.setMeunId(resultSet.getLong("meun_id"));
                meun.setMeunName(resultSet.getString("meun_name"));
                meun.setUrl(resultSet.getString("url"));
                meun.setType(resultSet.getString("type"));
                meun.setParentId(resultSet.getString("parent_id"));
                return meun;
            }
        });
        map.addAttribute("meuns",meuns);

        return meuns;
    }

}
