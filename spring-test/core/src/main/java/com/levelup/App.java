package com.levelup;

import com.levelup.jdbc.DBService;
import com.levelup.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-core-config.xml");
        context.refresh();
        DBService testBean = (DBService) context.getBean("dbService");

        context.destroy();
        //List<User> users = testBean.getAllUsers();
        //System.out.println(users.size());
    }
}
