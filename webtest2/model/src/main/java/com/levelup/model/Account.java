package com.levelup.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/22/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Account")
public class Account {
    private Long id;
    private String uuid;


    private Collection<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountId")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
