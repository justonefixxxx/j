package com.levelup.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 5/17/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListFrame extends JFrame {
    DefaultListModel model = getDataModel();
    private final JList list = new JList(model);

    public ListFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        initList();
    }

    private void initList(){
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                model.addElement("NEW");
            }
        });
        this.add(list);
    }


    private static DefaultListModel getDataModel(){
        DefaultListModel model = new DefaultListModel();
        model.addElement("Cat");
        model.addElement("Dog");
        model.addElement("Pig");

        return model;
    }


}
