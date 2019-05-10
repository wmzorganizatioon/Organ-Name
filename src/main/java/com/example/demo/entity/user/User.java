package com.example.demo.entity.user;

import java.io.Serializable;

public class User implements Serializable{

    /**
     * @id
     * **/
    private Long id;

    /**
     * @name:姓名
     * **/
    private String name;

    /**
     * @Email：邮箱
     * **/
    private String Email;

    /**
     * @phone：电话号码
     * **/
    private String phone;

    /**
     * @password：密码
     * **/
    private String password;

    /**
     * @idCard：身份证
     * **/
    private Long idCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", idCard=" + idCard +
                '}';
    }
}
