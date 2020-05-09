/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sound.api.model;

import java.io.Serializable;

/**
 *
 * @author asusadmin
 */
public class SoundDataRequest implements Serializable {

    private String categoryName;
    private String detailsName;
    private String language;

    private static final long serialVersionUID = 7L;

    public SoundDataRequest() {
    }

    public SoundDataRequest(String categoryName, String detailsName, String language) {
        this.categoryName = categoryName;
        this.detailsName = detailsName;
        this.language = language;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "SoundDataRequest{" + "categoryName=" + categoryName + ", detailsName=" + detailsName + ", language=" + language + '}';
    }



}
