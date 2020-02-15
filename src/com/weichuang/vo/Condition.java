package com.weichuang.vo;

import java.io.Serializable;

public class Condition implements Serializable{
    private String pname;
    private int isHot;
    private String cid;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "pname='" + pname + '\'' +
                ", isHot='" + isHot + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
