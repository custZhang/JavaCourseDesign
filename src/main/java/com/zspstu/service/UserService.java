package com.zspstu.service;

import com.zspstu.domain.User;


public interface UserService {

    int regist(User user);

    User findById(Integer uid);

    User login(String username,String password);

    int changeSize(int userUid,double newSize);

    boolean existUsername(String username);

    int findUid(String username);

}
