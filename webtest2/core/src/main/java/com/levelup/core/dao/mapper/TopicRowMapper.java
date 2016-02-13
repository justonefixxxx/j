package com.levelup.core.dao.mapper;

import com.levelup.model.Topic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/3/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TopicRowMapper implements RowMapper<Topic> {

    @Override
    public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topic topic = new Topic();
        topic.setId(rs.getLong("id"));
        topic.setName(rs.getString("name"));
        return topic;
    }
}
