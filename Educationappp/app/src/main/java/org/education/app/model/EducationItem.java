package org.education.app.model;

public class EducationItem {
    private byte[] img;
    private String languageA;
    private String languageB;
    private String languageC;
    private byte[] soundA;
    private byte[] soundB;
    private byte[] soundC;

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

    public byte[] getSoundA() {
        return soundA;
    }

    public void setSoundA(byte[] soundA) {
        this.soundA = soundA;
    }

    public byte[] getSoundB() {
        return soundB;
    }

    public void setSoundB(byte[] soundB) {
        this.soundB = soundB;
    }

    public byte[] getSoundC() {
        return soundC;
    }

    public void setSoundC(byte[] soundC) {
        this.soundC = soundC;
    }
}
