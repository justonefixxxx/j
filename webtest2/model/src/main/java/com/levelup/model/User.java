package com.levelup.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/8/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "User")
public class User {


    private Long id;


    private String name;
    private String role;

    public User() {
    }

    public User(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

}
