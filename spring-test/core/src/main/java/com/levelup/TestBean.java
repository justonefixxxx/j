package com.levelup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/27/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Component("testBean")
public class TestBean {

    private TestDepBean dependency;
    private String username;

    public TestBean() {
    }

    public TestBean(TestDepBean dependency) {
        this.dependency = dependency;
    }

    @Resource(name = "testDepBean")
    public void setDependency(TestDepBean dependency) {
        this.dependency = dependency;
    }

    @Resource(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String sayDependencyName(){
        return dependency.sayName();
    }
}
