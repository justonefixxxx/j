package com.levelup.core.dao;

import com.levelup.core.UserDAO;
import com.levelup.core.dao.mapper.UserRowMapper;
import com.levelup.model.Account;
import com.levelup.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/8/13
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDAO")
public class UserDAOManager extends DatabaseManager implements UserDAO{

    private final static String CREATE_USER_SQL = "INSERT INTO User(`name`,`role`) VALUES(:name,:role)";
    private final static String UPDATE_USER_SQL = "UPDATE User SET name=:name, role = :role WHERE id=:id";
    private final static String SEARCH_USER_SQL = "SELECT * FROM User WHERE name LIKE '%";
    private final static String GET_ALL_USER_SQL = "SELECT * FROM User";


    public List<User> getAllUsers(){
        List<User> result = new ArrayList<User>();
        try {
            result = getJdbcTemplate().query(GET_ALL_USER_SQL, new UserRowMapper());

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void createUser(User user){
        try {
            HashMap<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name", user.getName());
            paramMap.put("role", user.getRole());

            getNamedJdbcTemplate().update(CREATE_USER_SQL, paramMap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int updateUser(User user){
        try {
            HashMap<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name", user.getName());
            paramMap.put("role", user.getRole());
            paramMap.put("id", user.getId());

            getNamedJdbcTemplate().update(UPDATE_USER_SQL, paramMap);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public List<User> searchUser(String nameQuery){
        List<User> result = new ArrayList<User>();
        try {

            String query = SEARCH_USER_SQL+nameQuery+"%'";
            result = getJdbcTemplate().query(query, new UserRowMapper());
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
