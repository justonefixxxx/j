package com.levelup.cr.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.08.13
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */


public class Node {

    private Node parent;
    private Object value;
    private String name;
    private List<Node> childs;
    private HashMap<String, Object> properties;
    private boolean isRoot = false;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public String getParentPath(){
        String parentPath = "";
        if (parent!=null){
            parentPath+= parent.getParentPath()+File.pathSeparator+parent.getName();
        }
        return parentPath;
    }
}
