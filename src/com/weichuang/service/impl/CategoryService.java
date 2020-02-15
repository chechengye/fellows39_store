package com.weichuang.service.impl;

import com.weichuang.dao.CategoryDao;
import com.weichuang.pojo.Category;
import com.weichuang.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryDao categoryDao;

    public CategoryService(){
        categoryDao = new CategoryDao();
    }

    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
