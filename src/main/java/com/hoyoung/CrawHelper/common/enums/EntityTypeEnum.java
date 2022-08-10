package com.hoyoung.CrawHelper.common.enums;

/**
 * 下载格式枚举
 * @author Hoyoung
 */

public enum EntityTypeEnum {
    // 不知道写什么
    IMG("jpg","图片"),
    VIDEO("mp4","视频"),
    APK(".apk","安卓安装包文件"),
    IPA(".ipa","苹果安装包文件"),
    EXE(".exe","Windows安装包文件"),
    DMG(".dmg","Mac安装包文件"),
    MUSIC(".mp3","音乐"),
    UNKNOWN("","由服务器决定");

    private String suffix;
    private String desc;

    EntityTypeEnum(String suffix, String desc) {
        this.suffix = suffix;
        this.desc = desc;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
