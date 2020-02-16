package com.weichuang.vo;

import com.weichuang.pojo.Product;

import java.util.List;

public class PageBean {
    private int currentPage;//当前页
    private int maxCount; //每页容纳的最大数量
    private int totalCount;//总数据数
    private int totalPages;//总页面数量
    private List<Product> productList; //每页装载的数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", maxCount=" + maxCount +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", productList=" + productList +
                '}';
    }
}
