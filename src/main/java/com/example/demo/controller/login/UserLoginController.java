package com.example.demo.controller.login;

import com.example.demo.common.annotation.BooleanAnnotation;
import com.example.demo.common.annotation.GetAnnotation;
import com.example.demo.common.annotation.PostAnnotation;
import com.example.demo.common.annotation.UserLoginToken;
import com.example.demo.common.enums.WeekEnum;
import com.example.demo.entity.user.User;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.JsonResponseValue;
import com.example.demo.utils.VerifyUtil;
import com.example.demo.utils.token.LoginTicketToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import static com.example.demo.utils.ConfigConstant.*;
import static com.example.demo.utils.WebUrlMappingConst.*;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    //引进redis的公用文件
    @Autowired
    private RedisTemplate redisTemplate;

    //logback
    static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    /**
     * 登录
     * **/
    @PostAnnotation(value = URL_USER_LOGIN)
    public JsonResponseValue userLogin(@RequestBody User user,HttpSession session){
        logger.info("进入登陆方法了！");

        JsonResponseValue jsonResponseValue = new JsonResponseValue();

        //HttpSession session=request.getSession();

        //判断验证码的，暂时不写了 功能实现了
        if(session.getAttribute("imageCode") == null){

        }

        String key = "usrId123";  //redis需要两个值key与value【这是我的key】

        //引进redis的配置方法
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        try {
            boolean hasKeys = redisTemplate.hasKey(key);

            //redis的key存在的话就从缓存中取
            if(hasKeys){       //【若是成功的话直接跳出；输出默认的“jsonResponseValue"】
                User users = operations.get(key);
                logger.info("==========从缓存中获得数据=========");
                logger.info(users.getName());
                logger.info("==============redis缓存获取成功啦！！！================");
                return jsonResponseValue;
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

        if(user != null){
            if(userLoginService.SelectByUserNameCount(user) != 0){
                LoginTicketToken loginTicketToken = new LoginTicketToken();
                //user.setId((long) 1);
                String token = loginTicketToken.addLoginToken(user);   //
                logger.info("进入登陆成功了！");
                jsonResponseValue.setCode(WeekEnum.SSUCCESSENUM.getValue());
                //jsonResponseValue.setCode(token);
                jsonResponseValue.setReason(WeekEnum.SSUCCESSENUM.getContent());
                jsonResponseValue.setSuccess(WeekEnum.SSUCCESSENUM.isRest());

                //redis刚进来插入缓存
                operations.set(key, user,5,TimeUnit.MINUTES);
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
                        jsonResponseValue.setSuccess(WeekEnum.NOTEXISTENUM.isRest());
                    }
                }else {
                    jsonResponseValue.setReason(WeekEnum.REPEATENUM.getContent() + "URL_USER_REGISTERED");
                    jsonResponseValue.setCode(DATA_FAIL_NULL_PRESENCE);
                    jsonResponseValue.setSuccess(WeekEnum.REPEATENUM.isRest());
                }
            }else {
                jsonResponseValue.setReason("传过来的值为null" + ";接口名称：URL_USER_REGISTERED");
                jsonResponseValue.setCode(DATA_FAIL_NULL_PRESENCE);
                jsonResponseValue.setSuccess(false);
            }
        }catch (Exception e){
            jsonResponseValue.setCode(WeekEnum.EXCPETIONENUM.getValue());
            jsonResponseValue.setReason(WeekEnum.EXCPETIONENUM.getContent() + "URL_USER_REGISTERED");
            jsonResponseValue.setSuccess(WeekEnum.EXCPETIONENUM.isRest());
        }

        return jsonResponseValue;
    }

    /**
     *
     *@Author 86151
     *@Date 2019/6/20 15:20
     *Description 忘记密码
     @Param user
     *return
     */
    @PostMapping(value = URL_USER_FORGETPASSWORD)
    public JsonResponseValue forGetPassword(User user){
        return null;
    }


    /**
     *@Author 86151
     *@Date 2019/7/1 15:06
     *Description 获取验证码
     @Param
     *return
     */
    @GetAnnotation(value = URL_USER_GET_CODE)
    public void getCode(HttpServletResponse response, HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();

        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片

        Object[] objects = VerifyUtil.createImage();

        //将验证码存入session里面
        session.setAttribute("imageCode",objects[0]);

        session.setMaxInactiveInterval(3600);   //设置成30分钟

        //将图片输出给浏览器
        BufferedImage bufferedImage = (BufferedImage) objects[1];
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        OutputStream os = response.getOutputStream();
        try {
            ImageIO.write(bufferedImage,"JPEG",os);
        }catch (Exception e){
            logger.info(String.valueOf(e.fillInStackTrace()));
        }


    }
}
