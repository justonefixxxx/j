package com.levelup.cr.dao.fs;

import com.levelup.cr.model.Node;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/17/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class FSNodeSynchronizer extends FSAccessorAware{

    public boolean synchronizeNode(Node node){
        accessor = createFSNodeAccessor(node.getParentPath(),node.getName());
        if (accessor==null || !accessor.getInitialized()){
            return false;
        }
        writeProperties(node);
        writeNodeList(node);
        return true;
    }


    private void writeProperties(Node node){
        HashMap<String,Object> properties = node.getProperties();
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = properties.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = properties.get(key).toString();
            builder.append(key).append("=").append(value).append("\r\n");
        }
        writeToFile(accessor.getPropertiesFile(),builder.toString());
    }

    private void writeNodeList(Node node){
        StringBuilder builder = new StringBuilder();
        builder.append(node.getParent().getName()).append("=").append(node.getParentPath());
        for (Node n: node.getChilds()){
            builder.append(n.getName()).append("=").append(n.getParentPath()+File.pathSeparator+n.getName()).append("\r\n");
        }
        writeToFile(accessor.getNodelistFile(),builder.toString());
    }

    private void writeToFile(File file, String content) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print(content);
            writer.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }



}
