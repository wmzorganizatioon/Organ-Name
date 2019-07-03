package com.example.demo.service.meun.impl;

import com.example.demo.dao.meun.MeunReposity;
import com.example.demo.entity.meun.Meun;
import com.example.demo.service.meun.MeunService;
import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author 86151
 *@date 2019/7/3 15:12
 *@description 菜单模块
 *return
 */
@Service
public class MeunServiceImpl implements MeunService {

    static final Logger logger = LoggerFactory.getLogger(MeunServiceImpl.class);

    @Autowired
    MeunReposity meunReposity;

    @Override
    public List<Meun> getQueryAllMeuns() {

        List<Meun> rootMeuns = null;    //①获取所有的数据

        List<Meun> menuList = new ArrayList<Meun>();  //②将结果存放在新的list里面
        try {
            rootMeuns = meunReposity.getQueryAllMeun();

            for (Meun meun : rootMeuns){      //③遍历先将所有的父级菜单拿出来
                if(StringUtils.isNullOrEmpty(meun.getParentId())){
                    menuList.add(meun);
                }
            }

            for (Meun m : menuList){     //④将所有的子级菜单在循环出来
               m.setChildMeuns(getChildMeuns(m.getMeunId(),rootMeuns));
            }

        } catch (Exception e) {
            logger.info(String.valueOf(e.fillInStackTrace()));
        }
        return menuList;
    }

    /**
     *@Author 86151
     *@Date 2019/7/3 16:34
     *Description 将子级菜单存储于此方法
     @Param
     *return
     */
    public List<Meun> getChildMeuns(Long id,List<Meun> rootMeuns){
        List<Meun> childList = new ArrayList<Meun>();

        try{
            for (Meun me:rootMeuns){
                if(me.getParentId() != null && !me.getMeunId().equals(id)){
                    if(me.getParentId().equals(String.valueOf(id))){
                        childList.add(me);
                    }
                }
            }

        }catch (Exception e){
            e.fillInStackTrace();
        }

        return childList;
    }
}
