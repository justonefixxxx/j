package com.levelup.jdbc;

import com.levelup.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/27/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
//@Service("dbService")
public class DBService implements ApplicationContextAware, InitializingBean, DisposableBean{

    private final static String USER_SELECT_QUERY = "SELECT id FROM USER";
    private JdbcTemplate jdbcTemplate;
    private ApplicationContext context;

    public DBService() {
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers(){
        List<User> result = null;
        try {
            result = jdbcTemplate.queryForList(USER_SELECT_QUERY,User.class);
        } catch (DataAccessException e){
            e.printStackTrace();
        }
        return result;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct Runned");
        System.out.println("JdbcTemplate = "+this.jdbcTemplate);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet Runned");
        System.out.println("JdbcTemplate = "+this.jdbcTemplate);
    }

    public void initBean() {
        System.out.println("Init-Method Runned");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy Runned");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy() Runned");
    }

    public void destroyBean(){
        System.out.println("Destroy-Method Runned");
    }
}
