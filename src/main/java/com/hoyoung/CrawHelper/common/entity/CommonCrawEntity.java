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
                '}';
    }
}
