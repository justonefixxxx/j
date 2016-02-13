package com.levelup.cr.dao;

import com.levelup.cr.model.Node;

import java.util.List;



/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.08.13
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public interface NodeReader {

    public Node readNodeById(String id);

    public List<Node> readChilds(Node current);

    public Node readParent();
}
