package com.levelup.model.user;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/29/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "User")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
