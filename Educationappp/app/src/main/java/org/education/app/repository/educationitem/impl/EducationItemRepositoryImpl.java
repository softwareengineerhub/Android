package org.education.app.repository.educationitem.impl;

import org.education.app.model.EducationItem;
import org.education.app.repository.educationitem.EduactionItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EducationItemRepositoryImpl implements EduactionItemRepository {

    private DataSource datasource;

    public EducationItemRepositoryImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<EducationItem> findAll() {
        Connection c = null;
        try {
            List<EducationItem> list = new ArrayList();
            c = datasource.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM category");
            ResultSet rs = ps.executeQuery();
            EducationItem educationItem = null;
            while (rs.next()) {

                byte[] img = rs.getBytes("img");
                String languageA = rs.getString("languagea");
                String languageB = rs.getString("languageb");
                String languageC = rs.getString("languagec");
                byte[] soundA = rs.getBytes("sounda");
                byte[] soundB = rs.getBytes("soundb");
                byte[] soundC = rs.getBytes("soundc");

                educationItem = new EducationItem();
                educationItem.setImg(img);
                educationItem.setLanguageA(languageA);
                educationItem.setLanguageB(languageB);
                educationItem.setLanguageC(languageC);
                educationItem.setSoundA(soundA);
                educationItem.setSoundB(soundB);
                educationItem.setSoundC(soundC);
                list.add(educationItem);
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

    @Override
    public EducationItem findNext() {
        return null;
    }

    @Override
    public EducationItem findPrev() {
        return null;
    }
}
