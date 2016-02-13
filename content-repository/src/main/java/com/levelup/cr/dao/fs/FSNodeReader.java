package com.levelup.cr.dao.fs;

import com.levelup.cr.model.Node;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/17/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSNodeReader extends FSAccessorAware {

    public Node readNode(String nodePath){
        return  readNode(nodePath,0);

    }

    public Node readNode(String nodePath, int nestedLevel){
        return  null;
    }


}
