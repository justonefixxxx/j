package com.levelup.cr.dao;

import com.levelup.cr.model.Node;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.08.13
 * Time: 20:01
 * To change this template use File | Settings | File Templates.
 */
public interface NodeWriter {

    public void writeNode(Node node);
    public void moveNode(Node current, Node destination);
}
