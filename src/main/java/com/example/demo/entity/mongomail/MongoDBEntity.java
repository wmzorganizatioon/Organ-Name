package com.example.demo.entity.mongomail;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.*;

/**
 *@Author 86151
 *@date 2019/9/1 20:29
 *@description MongoDB与springboot配置所需要的实体类及操作！！！
 *return
 */
public class MongoDBEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *id:唯一标识
     */
    private Long id;

    /**
     *邮件编号
     */
    private Long mailNo;

    /**
     *邮件类型 如：Text表示纯文本、HTML等
     */
    private String mailType;

    /**
     *邮件发送人
     */
    private String fromAddress;

    /**
     *邮件接收人
     */
    private String toAddress;

    /**
     *cc邮件接收人
     */
    private String ccAddress;

    /**
     *bcc邮件接收人
     */
    private String bccAddress;

    /**
     *邮件标题
     */
    private String subject;

    /**
     *邮件内容
     */
    private String mailBody;

    /**
     *发送优先级 如：Normal表示普通
     */
    private String sendPriority;

    /**
     *处理状态 如：SendWait表示等待发送
     */
    private String sendStatus;

    /**
     *是否有附件
     */
    private boolean hasAttatchment;


    /**
     *客户端应用编号或名称  如：CRM、订单、财务、运营等
     */
    @Field("client_appid")
    private String clientAppId;

    /**
     *是否删除
     */
    @Field("has_delete")
    private boolean hasDelete;

    /**
     *发送次数
     */
    @Field("retry_count")
    private int retryCount;

    /**
     *创建时间
     */
    @Field("create_time")
    private Date createTime;

    /**
     *创建人
     */
    @Field("create_user")
    private String createUser;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMailNo() {
        return mailNo;
    }

    public void setMailNo(Long mailNo) {
        this.mailNo = mailNo;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(String bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getSendPriority() {
        return sendPriority;
    }

    public void setSendPriority(String sendPriority) {
        this.sendPriority = sendPriority;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public boolean isHasAttatchment() {
        return hasAttatchment;
    }

    public void setHasAttatchment(boolean hasAttatchment) {
        this.hasAttatchment = hasAttatchment;
    }


    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    public boolean isHasDelete() {
        return hasDelete;
    }

    public void setHasDelete(boolean hasDelete) {
        this.hasDelete = hasDelete;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "MongoDBEntity{" +
                "id=" + id +
                ", mailNo=" + mailNo +
                ", mailType='" + mailType + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", ccAddress='" + ccAddress + '\'' +
                ", bccAddress='" + bccAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", mailBody='" + mailBody + '\'' +
                ", sendPriority='" + sendPriority + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", hasAttatchment=" + hasAttatchment +
                ", clientAppId='" + clientAppId + '\'' +
                ", hasDelete=" + hasDelete +
                ", retryCount=" + retryCount +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
