package org.education.app.model;

public class Category {
    private String title;
    private byte[] img;
    private String languageA;
    private String languageB;
    private String languageC;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getLanguageA() {
        return languageA;
    }

    public void setLanguageA(String languageA) {
        this.languageA = languageA;
    }

    public String getLanguageB() {
        return languageB;
    }

    public void setLanguageB(String languageB) {
        this.languageB = languageB;
    }

    public String getLanguageC() {
        return languageC;
    }

    public void setLanguageC(String languageC) {
        this.languageC = languageC;
    }
}
