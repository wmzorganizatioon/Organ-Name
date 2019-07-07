package com.example.demo.dao.login;

import com.example.demo.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLoginRepository {

    Integer queryByUserNameCount(User user);

    /**
     *@Author 86151
     *@Date 2019/6/18 9:22
     *Description 注册
     @Param
     *return
     */
    Integer addUser(User user);

    /**
     *@Author 86151
     *@Date 2019/7/4 23:19
     *Description 查询出所有的用户，用于导出
     @Param
     *return
     */
    List<User> queryAllUser();

    /**
     *@Author 86151
     *@Date 2019/7/7 13:06
     *Description 根据id查询
     @Param
     *return
     */
    User selectUserById(Long id);
}
