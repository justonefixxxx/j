package com.levelup.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 5/17/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComboBoxFrame extends JFrame {
    private final JComboBox comboBox = new JComboBox();
    private DefaultComboBoxModel model;

    public ComboBoxFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        model = getComboBoxModel();
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        comboBox.setModel(model);
        panel.add(comboBox);
        comboBox.setPreferredSize(new Dimension(100, 23));
        comboBox.setEditable(true);
        comboBox.setSelectedIndex(1);
        JTextField tf = (JTextField) comboBox.getEditor().getEditorComponent();
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = ((JTextField)e.getSource()).getText();
                System.out.println(value);
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String value = ((JTextField)e.getSource()).getText();
                System.out.println(value);
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String value = (String) ((JComboBox) e.getSource()).getSelectedItem();
                String value = (String) ((JComboBox) e.getSource()).getEditor().getItem();
                System.out.println(value);
            }
        });


        comboBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String value = (String) ((JComboBox) e.getSource()).getEditor().getItem();
                System.out.println(value);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = (String) ((JComboBox) e.getSource()).getSelectedItem();
                System.out.println(value);
            }
        });

    }

    private DefaultComboBoxModel getComboBoxModel(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Cat");
        model.addElement("Dog");
        model.addElement("Pig");

        return model;
    }
}
