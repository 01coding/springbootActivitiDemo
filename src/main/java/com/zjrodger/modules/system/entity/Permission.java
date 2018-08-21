package com.zjrodger.modules.system.entity;

/**
 * @author zhangjian
 * @create 2018-08-21
 */
public class Permission {

    private Integer pid;

    private String pname;

    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
