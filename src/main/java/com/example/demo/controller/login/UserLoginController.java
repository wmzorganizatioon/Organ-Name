package com.example.demo.controller.login;

import com.example.demo.entity.user.User;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.JsonResponseValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.utils.ConfigConstant.*;
import static com.example.demo.utils.WebUrlMappingConst.URL_USER_LOGIN;
import static com.example.demo.utils.WebUrlMappingConst.URL_USER_REGISTERED;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    /**
     * 登录
     * **/
    @PostMapping(value = URL_USER_LOGIN)
    public JsonResponseValue userLogin(@RequestBody User user){
        JsonResponseValue jsonResponseValue = new JsonResponseValue();
        if(user != null){
            if(userLoginService.SelectByUserNameCount(user) != 0){
                jsonResponseValue.setCode(DATA_SUCCESS_PRESENCE);
                jsonResponseValue.setReason("数据正确");
            }else {
                jsonResponseValue.setCode(DATA_FAIL_PRESENCE);
                jsonResponseValue.setReason("账号不存在，请先注册！！！");
                jsonResponseValue.setSuccess(false);
            }
        }else {
            jsonResponseValue.setCode(DATA_FAIL_NULL_PRESENCE);
            jsonResponseValue.setReason("账号密码不能为空！！！");
            jsonResponseValue.setSuccess(false);
        }

        return jsonResponseValue;
    }

    /**
     *@Author 86151
     *@Date 2019/6/18 9:12
     *Description 注册
     @Param
     *return
     */
    @PostMapping(value = URL_USER_REGISTERED)
    public JsonResponseValue userRegistered(@RequestBody User user){
        JsonResponseValue jsonResponseValue = new JsonResponseValue();
        //判断是否存在
        try{
            if(user != null){
                if(userLoginService.SelectByUserNameCount(user) == 0){
                    if(userLoginService.insertUser(user) != 0){
                        jsonResponseValue.setReason("注册成功");
                        jsonResponseValue.setCode(DATA_SUCCESS_PRESENCE);
                        jsonResponseValue.setSuccess(true);
                    }else {
                        jsonResponseValue.setReason("注册失败！" + ";接口名称：URL_USER_REGISTERED");
                        jsonResponseValue.setCode(DATA_FAIL_PRESENCE);
                        jsonResponseValue.setSuccess(false);
                    }
                }else {
                    jsonResponseValue.setReason("用户已存在!" + ";接口名称：URL_USER_REGISTERED");
                    jsonResponseValue.setCode(DATA_FAIL_NULL_PRESENCE);
                    jsonResponseValue.setSuccess(false);
                }
            }else {
                jsonResponseValue.setReason("传过来的值为null" + ";接口名称：URL_USER_REGISTERED");
                jsonResponseValue.setCode(DATA_FAIL_NULL_PRESENCE);
                jsonResponseValue.setSuccess(false);
            }
        }catch (Exception e){
            jsonResponseValue.setCode(DATA_FAIL_EXPENCTION);
            jsonResponseValue.setReason("注册接口异常;接口名称：" + "URL_USER_REGISTERED");
            jsonResponseValue.setSuccess(false);
        }

        return jsonResponseValue;
    }
}
