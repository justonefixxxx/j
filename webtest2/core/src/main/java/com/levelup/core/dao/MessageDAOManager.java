package com.levelup.core.dao;

import com.levelup.core.MessageDAO;
import com.levelup.core.dao.extractor.TopicResultSetExtractor;
import com.levelup.core.dao.mapper.MessageRowMapper;
import com.levelup.core.dao.mapper.TopicRowMapper;
import com.levelup.model.Message;
import com.levelup.model.Topic;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/18/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */

public class MessageDAOManager extends DatabaseManager implements MessageDAO{

    private static final String CREATE_TOPIC_QUERY = "INSERT INTO TOPIC(`name`) VALUES(:name)";
    private static final String CREATE_MESSAGE_QUERY = "INSERT INTO MESSAGE(`TOPIC_ID`,`USER_ID`,`content`) " +
            "VALUES(:topicId,:userId,:content)";
    private static final String SELECT_MESSAGES_BY_TOPIC_QUERY = "SELECT USER.ID as USER_ID, USER.NAME as USER_NAME, MESSAGE.CONTENT, " +
            "MESSAGE.ID as MESSAGE_ID, MESSAGE.TOPIC_ID " +
            "FROM MESSAGE JOIN USER ON (USER.ID=MESSAGE.USER_ID) " +
            "WHERE TOPIC_ID = ";

    private Connection connection;

    public void createTopic(String name){
        try {
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name",name);

            getNamedJdbcTemplate().update(CREATE_TOPIC_QUERY, paramMap);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void createMessage(Long topicId, Long userId, String content){
        try {
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("topicId",topicId);
            paramMap.put("userId",userId);
            paramMap.put("content",content);

            getNamedJdbcTemplate().update(CREATE_MESSAGE_QUERY, paramMap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Message> getAllMessages(Long topicId){
        List<Message> result = new ArrayList<Message>();
        try {
            result = getJdbcTemplate().query(SELECT_MESSAGES_BY_TOPIC_QUERY+topicId, new MessageRowMapper());

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Topic> getAllTopics(){
        List<Topic> result = new ArrayList<Topic>();
        try {
            result = getJdbcTemplate().query("SELECT * FROM TOPIC", new TopicResultSetExtractor());

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
