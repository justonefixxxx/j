package com.levelup.core.dao.mapper;


import com.levelup.model.Message;
import com.levelup.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/3/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageRowMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setId(rs.getLong("MESSAGE_ID"));
        message.setTopicId(rs.getLong("TOPIC_ID"));
        message.setContent(rs.getString("CONTENT"));

        return message;
    }
}
