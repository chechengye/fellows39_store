package com.weichuang.service.impl;

import com.weichuang.dao.ProductDao;
import com.weichuang.pojo.Product;
import com.weichuang.service.IProductService;
import com.weichuang.utils.DateUtil;
import com.weichuang.vo.Condition;
import com.weichuang.vo.PageBean;

import java.util.List;
import java.util.UUID;

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

    /**
     * 添加商品操作
     * @param product
     * @return
     */
    @Override
    public int saveProduct(Product product) {
        //添加PID UUID.randomUUID()，获取一个不重复随机串 。包含- 共36位 包含四个 -
        System.out.println(UUID.randomUUID().toString());
        product.setPid(UUID.randomUUID().toString().replaceAll("-",""));
        //添加图片
        product.setPimage("products/1/c_0017.jpg");
        //添加日期
        product.setPdate(DateUtil.getCurrentDate());
        //添加标志
        product.setPflag(0);

        return productDao.saveProduct(product);
    }

    /**
     * 更新商品
     * @param product
     * @return
     */
    @Override
    public int updateProductByPid(Product product) {
        //设定更新日期
        product.setPdate(DateUtil.getCurrentDate());

        return productDao.updateProductByPid(product);
    }

    /**
     * 根据条件查询商品
     * @param condition
     * @return
     */
    @Override
    public List<Product> getProductListByCondition(Condition condition) {
        //判断传递过来的参数是否为空

        return productDao.getProductListByCondition(condition);
    }

    @Override
    public PageBean getPageBeanByCurrentPageAndMaxCount(String currentPage, int maxCount) {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(Integer.valueOf(currentPage));
        pageBean.setMaxCount(maxCount);
        int totalCount = productDao.getProductTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数 = 向上取整(数据库的数量 / 每页容纳的最大数量)
        pageBean.setTotalPages((int)Math.ceil(totalCount * 1.0 / maxCount));
        //limit 0 , 5  索引值 = (当前页 - 1) * 数量
        int index = (Integer.valueOf(currentPage) - 1) * maxCount;
        List<Product> productList = productDao.getProductListByIndexAndMaxCount(index , maxCount);
        pageBean.setProductList(productList);
        return pageBean;
    }

    /**
     * 根据关键字模糊查询商品
     * @param word
     * @return
     */
    @Override
    public List<Product> getProductListByWord(String word) {
        return productDao.getProductListByWord(word);
    }
}
