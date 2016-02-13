package com.levelup.model;


import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/18/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Message")
public class Message {
    private Long id;
    private String content;

    private Topic topic;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "topicId")
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Transient
    public Long getTopicId() {
        return topic.getId();
    }

    @Transient
    public void setTopicId(Long topicId) {

    }
}
