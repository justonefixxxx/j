package com.levelup.core.dao.extractor;

import com.levelup.model.Message;
import com.levelup.model.Topic;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/3/13
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TopicResultSetExtractor implements ResultSetExtractor<List<Topic>> {

    @Override
    public List<Topic> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Topic> result = new ArrayList<Topic>();
        Long prevTopicId=0L;
        while (rs.next()){
            Topic currentTopic = null;
            Message message = new Message();
            Long currentTopicId = rs.getLong("TOPIC_ID");
            if (prevTopicId != currentTopicId){
                if (currentTopic != null){
                    result.add(currentTopic);
                }
                currentTopic = new Topic();
                currentTopic.setId(currentTopicId);
                currentTopic.setName(rs.getString("TOPIC_NAME"));
            }
            message.setId(rs.getLong("MESSAGE_ID"));
            message.setTopicId(currentTopicId);
            message.setContent(rs.getString("CONTENT"));
            currentTopic.addMessage(message);
            prevTopicId = currentTopicId;
        }
        return result;
    }
}
