package com.levelup.core;

import com.levelup.model.Message;
import com.levelup.model.Topic;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/22/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MessageDAO {

    void createTopic(String name);
    void createMessage(Long topicId, Long userId, String content);
    List<Message> getAllMessages(Long topicId);
    List<Topic> getAllTopics();
}
