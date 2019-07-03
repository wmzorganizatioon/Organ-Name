package com.example.demo.controller.meun;

import com.example.demo.common.annotation.PostAnnotation;
import com.example.demo.common.enums.WeekEnum;
import com.example.demo.entity.meun.Meun;
import com.example.demo.service.meun.MeunService;
import com.example.demo.utils.JsonDomainArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.utils.WebUrlMappingConst.URL_MEUN_GET_ALL_MEUNS;

@RestController
@RequestMapping(value = "meun")
public class GetMeunController {

    Logger logger = LoggerFactory.getLogger(GetMeunController.class);

    @Autowired
    MeunService meunService;

    @GetMapping("/getAllMeun")
    @ResponseBody
    public List<Meun> selectAllMeun(){
        return null;
    }

    @PostMapping("/getMeun")
    @CrossOrigin(value = "http://localhost:8099",maxAge = 1800,allowedHeaders = "*")
    public String selectMeun(){
        return "成功进入8091端口";
    }


    /**
     *@Author 86151
     *@Date 2019/7/3 14:41
     *Description 获取所有的菜单
     @Param
     *return
     */
    @GetMapping(value = URL_MEUN_GET_ALL_MEUNS)
    @ResponseBody
    public JsonDomainArray getSelectAllMeuns(){
        logger.info("成功进入获取菜单接口");

        JsonDomainArray jsonDomainArray = new JsonDomainArray();

        List<Meun> rootMeun = null;

        //获取原始数据
        try{
            rootMeun = meunService.getQueryAllMeuns();

            jsonDomainArray.setData(rootMeun);
            jsonDomainArray.setReason(WeekEnum.SSUCCESSENUM.getContent());
            jsonDomainArray.setSuccess(WeekEnum.SSUCCESSENUM.isRest());
            jsonDomainArray.setCode(WeekEnum.SSUCCESSENUM.getValue());

        }catch (Exception e){
            jsonDomainArray.setCode(WeekEnum.EXCPETIONENUM.getValue());
            jsonDomainArray.setSuccess(WeekEnum.NOTEXISTENUM.isRest());
            jsonDomainArray.setReason(WeekEnum.EXCPETIONENUM.getContent());
        }

        return jsonDomainArray;
    }
}
