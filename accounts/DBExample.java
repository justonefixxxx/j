package com.accounts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBExample {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?encoding=UTF-8";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    private List<Integer> columnTypes = new ArrayList<Integer>();


    public void test(){
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM User") ;
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i=1; i<=metaData.getColumnCount();i++){
                int type = metaData.getColumnType(i);
                String name = metaData.getColumnName(i);
                columnTypes.add(type);
            }
            while (resultSet.next()){
                String value;
                Integer intValue;
                for (int i=1; i<=metaData.getColumnCount();i++) {
                    int type = columnTypes.get(i-1);
                    if (type == Types.VARCHAR) {
                        value = resultSet.getString(i);
                        System.out.println(value+" ");
                    }
                    if (type == Types.INTEGER){
                        intValue = resultSet.getInt(i);
                        System.out.println(intValue+" ");
                    }
                }

            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return connection;
    }
}
