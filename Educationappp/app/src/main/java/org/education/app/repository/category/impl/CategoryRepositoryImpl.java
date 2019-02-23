package org.education.app.repository.category.impl;

import org.education.app.model.Category;
import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.datasource.EduactionDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CategoryRepositoryImpl implements CategoryRepository {
    //private DataSource datasource;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://45.61.159.32:3306/R85NuqQGMg", "R85NuqQGMg", "BJJBRE094I");
    }


    public CategoryRepositoryImpl(DataSource datasource) {
       // this.datasource = datasource;
    }

    @Override
    public List<Category> findAll() {
        Connection c = null;
        try {
            List<Category> list = new ArrayList();
            c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM category");
            ResultSet rs = ps.executeQuery();
            Category category = null;
            while (rs.next()) {
                String title = rs.getString("title");
                String languageA = rs.getString("languagea");
                String languageB = rs.getString("languageb");
                String languageC = rs.getString("languagec");
                byte[] img = rs.getBytes("img");
                category = new Category();
                category.setTitle(title);
                if (img!=null && img.length>0) {
                    category.setImg(img);
                }
                category.setLanguageA(languageA);
                category.setLanguageB(languageB);
                category.setLanguageC(languageC);
                list.add(category);
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
