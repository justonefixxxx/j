package com.levelup.dao.impl;

import com.levelup.dao.UserDAO;
import com.levelup.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/8/13
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUserById(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserNyName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
