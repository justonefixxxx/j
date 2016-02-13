package com.levelup.service.impl;

import com.levelup.dao.UserDAO;
import com.levelup.model.User;
import com.levelup.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/8/13
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDAO")
    private UserDAO userDAO;

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User getUserNyName(String name) {
        return userDAO.getUserNyName(name);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
