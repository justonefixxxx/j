package com.levelup.dao;

import com.levelup.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/8/13
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {

    User getUserById(Long id);
    User getUserNyName(String name);
    void saveUser(User user);
}
