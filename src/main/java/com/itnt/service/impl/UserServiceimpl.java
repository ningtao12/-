package com.itnt.service.impl;

import com.itnt.controller.Code;
import com.itnt.dao.UserDao;
import com.itnt.exception.SystemException;
import com.itnt.pojo.User;
import com.itnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public boolean save(User user) {
        return userDao.save(user)>0;
    }

    @Override
    public boolean delete(Integer id) {
        if(id<1) {
            throw new SystemException(Code.BUSINESS_ERR,"请您规范操作");
        }
        return userDao.delete(id)>0;

    }

    @Override
    public boolean update(User user) {
        return userDao.update(user)>0;

    }

    @Override
    public User getById(Integer id) {
        if(id<1) {
            throw new SystemException(Code.BUSINESS_ERR,"请您规范操作");
        }
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
