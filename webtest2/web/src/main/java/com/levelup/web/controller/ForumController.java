package com.levelup.web.controller;

import com.levelup.core.dao.MessageDAOManager;
import com.levelup.model.Message;
import com.levelup.model.Topic;


import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/20/13
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */


public class ForumController implements Serializable{


    private MessageDAOManager messageDAOManager;

    private List<Topic> topics;

    private List<Message> messages;

    public List<Topic> getTopics() {
        topics = messageDAOManager.getAllTopics();
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Message> findMessages(String topicId) {
        messages = messageDAOManager.getAllMessages(Long.parseLong(topicId));
        return messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
