package com.hoyoung.CrawHelper.common.entity;

import java.util.List;

/**
 * 通用实体对象
 * dlLink
 * @author Hoyoung
 */
public class CommonCrawEntity {
    public CommonCrawEntity() {
    }

    public CommonCrawEntity(List dlLinks) {
        this.dlLinks = dlLinks;
    }

    private List dlLinks;

    /**
     * 如果明确下载的文件格式，建议指定，以防下载服务器未指定文件后缀名
     */
    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List getDlLinks() {
        return dlLinks;
    }

    public void setDlLinks(List dlLinks) {
        this.dlLinks = dlLinks;
    }

    @Override
    public String toString() {
        return ", {" +
                "dlLinks=" + dlLinks +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
