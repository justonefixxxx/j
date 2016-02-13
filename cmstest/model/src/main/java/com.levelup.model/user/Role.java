package com.levelup.model.user;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/29/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Role")
public class Role {

    private Long id;
    private String roleName;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
