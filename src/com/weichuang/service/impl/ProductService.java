package com.weichuang.service.impl;

import com.weichuang.dao.ProductDao;
import com.weichuang.pojo.Product;
import com.weichuang.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private ProductDao productDao;

    public ProductService(){
        productDao = new ProductDao();
    }
    /**
     * 获取商品列表
     * @return
     */
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    /**
     * 根据商品ID获取商品
     * @param pid
     * @return
     */
    @Override
    public Product getProductById(String pid) {
        return productDao.getProductById(pid);
    }

    /**
     * 根据商品ID删除商品
     * @param pid
     * @return
     */
    @Override
    public int deleteProductById(String pid) {
        return productDao.deleteProductById(pid);
    }
}
