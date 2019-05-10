package com.example.demo.entity.meun;

import java.io.Serializable;

public class meun implements Serializable{
    private static final long serialVersionUID = 1L;

    private String meunName;

    private String parentId;

    private Long meunId;

    private String url;

    private String type;

    public String getMeunName() {
        return meunName;
    }

    public void setMeunName(String meunName) {
        this.meunName = meunName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getMeunId() {
        return meunId;
    }

    public void setMeunId(Long meunId) {
        this.meunId = meunId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "meun{" +
                "meunName='" + meunName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", meunId=" + meunId +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
