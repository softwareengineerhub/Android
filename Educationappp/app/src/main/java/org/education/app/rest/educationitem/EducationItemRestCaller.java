package org.education.app.rest.educationitem;

public interface EducationItemRestCaller {

    public byte[] requestForImage(String title, int position);

    public byte[] requestForSoundA(String title, int position);

    public byte[] requestForSoundB(String title, int position);

    public byte[] requestForSoundC(String title, int position);

    public String getEducationItemUrlSoundA(String categoryTitle, int position);

    public String getEducationItemUrlSoundB(String categoryTitle, int position);

    public String getEducationItemUrlSoundC(String categoryTitle, int position);
}
