package com.zspstu.service.impl;

import com.zspstu.dao.UserDao;
import com.zspstu.domain.User;
import com.zspstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int regist(User user) {
        return userDao.save(user);
    }

    public User findById(Integer uid) {
        return userDao.findById(uid);
    }

    @Override
    public User login(String username,String password) {
        return userDao.login(username,username,password);
    }

    @Override
    public int changeSize(int userUid, double newSize) {
        return userDao.updateSize(userUid,newSize);
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }

    @Override
    public int findUid(String username) {
        return userDao.findUid(username);
    }
}
