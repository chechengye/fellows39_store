package com.weichuang.pojo;

import java.io.Serializable;

/**
 * 封装商品，建议实现序列号。redis缓存机制中，使用的实体类对象必须被序列化
 */
public class Product implements Serializable{
    /*
     * `pid` varchar(32) NOT NULL,
     `pname` varchar(50) DEFAULT NULL,
     `market_price` double DEFAULT NULL,
     `shop_price` double DEFAULT NULL,
     `pimage` varchar(200) DEFAULT NULL,
     `pdate` date DEFAULT NULL,
     `is_hot` int(11) DEFAULT NULL,
     `pdesc` varchar(255) DEFAULT NULL,
     `pflag` int(11) DEFAULT NULL,
     `cid` varchar(32) DEFAULT NULL,
     */
    private String pid;
    private String pname;
    private String marketPrice;
    private String shopPrice;
    private String pimage;
    private String pdesc;
    private int isHot;
    private String cid;
    private String pdate;
    private int pflag;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
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

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", marketPrice='" + marketPrice + '\'' +
                ", shopPrice='" + shopPrice + '\'' +
                ", pimage='" + pimage + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", isHot=" + isHot +
                ", cid='" + cid + '\'' +
                ", pdate='" + pdate + '\'' +
                ", pflag=" + pflag +
                '}';
    }
}
