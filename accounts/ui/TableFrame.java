package com.levelup.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 5/21/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TableFrame extends JFrame {
    final JTable table;
    final CustomTableModel model = new CustomTableModel();
    public TableFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        //table = new JTable(getData(),columnNames);
        table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        this.add(scrollPane);

        JButton button = new JButton("Change");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.setValueAt(123,0,1);
            }
        });
        panel.add(button);
        JButton buttonRefresh = new JButton("Refresh");
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.sort();
            }
        });
        panel.add(buttonRefresh);
        this.add(panel,BorderLayout.SOUTH);
    }

    private void init() {

    }


    private Object[][] getData(){
        return new Object[][]{{1,2,3},{4,5,6}};
    }

    private class CustomTableModel extends AbstractTableModel{
        private Integer[][] data = new Integer[][]{{1,2,3},
                                                   {4,5,6}};
        private String[] columnNames = new String[]{"Column 1","Column 2","Column 3"};

        @Override
        public int getRowCount() {
            return 2;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public int getColumnCount() {
            return 3;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 1){
                return data[rowIndex][columnIndex]+" Formatted" ;
            }
            return data[rowIndex][columnIndex];
        }

        public String getColumnName(int col) {
            return columnNames[col].toString();
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == 1){
                return true;
            }
            return super.isCellEditable(rowIndex, columnIndex);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = (Integer)aValue;
            this.fireTableDataChanged();
        }

        public void sort(){
            for (int i=0; i < 2; i++) {
            Arrays.sort(data[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            }
            this.fireTableDataChanged();
        }
    }



}
