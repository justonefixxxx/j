package com.levelup.ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 5/17/13
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeFrame extends JFrame {
    private final JTree tree;
    private DefaultTreeModel model = getTreeModel();

    public TreeFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        tree = new JTree(model);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton addChild = new JButton("Add Child");
        JButton addSibling = new JButton("Add Sibling");

        buttonPanel.add(addChild);
        addChild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreePath selectedPath = tree.getSelectionPath();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("Child");
                model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath pathToRoot = new TreePath(nodes);

                tree.scrollPathToVisible(pathToRoot);
            }
        });
        buttonPanel.add(addSibling);
        addSibling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                int index = parent.getIndex(selectedNode)+1;
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("Sibling");
                model.insertNodeInto(newNode, parent, index);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private DefaultTreeModel getTreeModel(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        root.setUserObject("World");

        DefaultMutableTreeNode nortnAmerica = new DefaultMutableTreeNode("North America");
        DefaultMutableTreeNode southAmerica = new DefaultMutableTreeNode("South America");
        DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");

        root.add(nortnAmerica);
        root.add(southAmerica);
        root.add(europe);

        DefaultMutableTreeNode usa = new DefaultMutableTreeNode("USA");
        DefaultMutableTreeNode canada = new DefaultMutableTreeNode("Canada");

        nortnAmerica.add(usa);
        nortnAmerica.add(canada);

        DefaultMutableTreeNode arg = new DefaultMutableTreeNode("Argentina");
        DefaultMutableTreeNode brazil = new DefaultMutableTreeNode("Brazil");
        southAmerica.add(arg);
        southAmerica.add(brazil);

        DefaultMutableTreeNode ukr = new DefaultMutableTreeNode("Ukraine");
        DefaultMutableTreeNode rus = new DefaultMutableTreeNode("Russia");
        europe.add(ukr);
        europe.add(rus);



        DefaultTreeModel model = new DefaultTreeModel(root);
        return model;
    }
}
