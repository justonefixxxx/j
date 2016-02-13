package com.levelup.cr.model;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/17/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class NodeProxy extends Node{

    @Override
    public Node getParent() {
        return super.getParent();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setParent(Node parent) {
        super.setParent(parent);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public List<Node> getChilds() {
        return super.getChilds();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setChilds(List<Node> childs) {
        super.setChilds(childs);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public HashMap<String, Object> getProperties() {
        return super.getProperties();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setProperties(HashMap<String, Object> properties) {
        super.setProperties(properties);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
