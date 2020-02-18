package com.weichuang.service;

import com.weichuang.pojo.Product;
import com.weichuang.vo.Condition;
import com.weichuang.vo.PageBean;

import java.util.List;

public interface IProductService {

    List<Product> getProductList();

    Product getProductById(String pid);

    int deleteProductById(String pid);

    int saveProduct(Product product);

    int updateProductByPid(Product product);

    List<Product> getProductListByCondition(Condition condition);

    PageBean getPageBeanByCurrentPageAndMaxCount(String currentPage, int maxCount);

    List<Product> getProductListByWord(String word);
}
