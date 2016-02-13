package com.levelup.core.dao.mapper;

import com.levelup.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/3/13
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
