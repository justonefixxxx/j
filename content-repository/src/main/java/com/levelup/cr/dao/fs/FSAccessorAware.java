package com.levelup.cr.dao.fs;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/17/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class FSAccessorAware implements ApplicationContextAware {

    protected FSNodeAccessor accessor;
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected FSNodeAccessor createFSNodeAccessor(String parentPath, String nodeName){
        FSNodeAccessor accessor = null;
        try {
            accessor = (FSNodeAccessor) applicationContext.getBean("fsNodeAccessor");
            accessor.setNodeName(nodeName);
            accessor.setPath(parentPath);
            accessor.init();
        } catch (NoSuchBeanDefinitionException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return accessor;
    }
}
