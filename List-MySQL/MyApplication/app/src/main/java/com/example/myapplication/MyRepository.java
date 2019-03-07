package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyRepository {


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Double> getAll() {

        Connection c = null;
        try {
            Map<String, Double> map = new HashMap();
            c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM fruits");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                map.put(name, price);
            }
            return map;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        /*Map<String, Double> map = new HashMap();
        map.put("Apple", 10.0);
        map.put("Banana", 20.0);
        map.put("Peach", 30.0);*/
        //return map;
    }


    private Connection getConnection() throws SQLException {
        //return DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/R85NuqQGMg", "R85NuqQGMg", "BJJBRE094I");
        return DriverManager.getConnection("jdbc:mysql://45.61.159.32:3306/R85NuqQGMg", "R85NuqQGMg", "BJJBRE094I");
    }
}
