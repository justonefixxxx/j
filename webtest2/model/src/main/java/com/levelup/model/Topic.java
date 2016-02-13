package com.levelup.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/18/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Topic")
public class Topic {

    private Long id;
    private String name;
    private List<Message> messages;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "topic")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        if (this.messages == null) {
            messages = new ArrayList<Message>();
        }
        messages.add(message);
    }
}
