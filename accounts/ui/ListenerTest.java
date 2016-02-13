package com.levelup.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 5/14/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListenerTest extends JFrame {

    final JButton button = new JButton("OK");
    final JButton buttonCancel = new JButton("Cancel");
    final MyListenerFactory factory = new MyListenerFactory();

    public ListenerTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        button.setSize(100,15);
        add(button);
        add(buttonCancel);


        button.addMouseListener(factory.getMouseListener());
        buttonCancel.addMouseListener(factory.getMouseListener());
        JTextField textField = new JTextField("Test");
        add(textField);
        textField.addKeyListener(factory.getKeyListener());
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        buttonCancel.removeMouseListener(factory.mouseListener);
    }

    private class MyListenerFactory {

        public final MouseListener mouseListener;
        public KeyListener keyListener;

        private MyListenerFactory() {
            mouseListener = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);    //To change body of overridden methods use File | Settings | File Templates.
                }
            };
        }

        public MouseListener getMouseListener(){

            return mouseListener;
        }

        public KeyListener getKeyListener(){

            keyListener =  new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);    //To change body of overridden methods use File | Settings | File Templates.
                }
            };
            return keyListener;
        }
    }

}
