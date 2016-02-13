package com.levelup.core;

import com.levelup.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/22/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public interface UserDAO {

    List<User> getAllUsers();
    void createUser(User user);
    int updateUser(User user);
    List<User> searchUser(String nameQuery);
}
