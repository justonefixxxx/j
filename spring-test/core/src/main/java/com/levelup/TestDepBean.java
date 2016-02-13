package com.levelup;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/27/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Component("testDepBean")
public class TestDepBean {

    public TestDepBean() {
    }

    public String sayName(){
        return "My name is " + getClass().getCanonicalName();
    }
}
