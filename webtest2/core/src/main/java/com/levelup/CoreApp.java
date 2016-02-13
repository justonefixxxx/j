package com.levelup;

import com.levelup.core.MessageDAO;
import com.levelup.model.Topic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class CoreApp
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-core-config.xml");
        MessageDAO messageDAO = (MessageDAO) context.getBean("messageDAO");
        List<Topic>  topics = messageDAO.getAllTopics();
    }
}
