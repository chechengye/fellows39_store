package com.weichuang.service;

import com.weichuang.pojo.User;

public interface IUserService {
    User getUserByUserName(String userName);

    User login(String username, String password);
}
