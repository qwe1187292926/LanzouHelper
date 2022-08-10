package com.hoyoung.CrawHelper.common.entity;

/**
 * 小红书实体对象
 *
 * @author Hoyoung
 */
public class XHSCrawEntity extends CommonCrawEntity {
    private String username;
    private String signature;
    private String avatar;

    public XHSCrawEntity(String username, String signature, String avatar) {
        this.username = username;
        this.signature = signature;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
