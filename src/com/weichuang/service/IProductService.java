package com.weichuang.service;

import com.weichuang.pojo.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProductList();

    Product getProductById(String pid);

    int deleteProductById(String pid);
}
