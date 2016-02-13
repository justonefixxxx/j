package com.levelup.cr.service;

import com.levelup.cr.model.Node;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.08.13
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public interface NodeChanger {

    public void delete(Node node);
    public Node create();
    public void update(Node node);
}
