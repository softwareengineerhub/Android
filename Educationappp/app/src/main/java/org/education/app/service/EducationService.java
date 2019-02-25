package org.education.app.service;

import org.education.app.model.Category;
import org.education.app.model.EducationItem;

import java.util.List;

public interface EducationService {

    public List<Category> findAllCategories();

    public List<EducationItem> findAllEducationItems(String categoryTitle);

    public byte[] getEducationItemImg(String categoryTitle, int position);

    public byte[] getEducationItemSoundA(String categoryTitle, int position);

    public byte[] getEducationItemSoundB(String categoryTitle, int position);

    public byte[] getEducationItemSoundC(String categoryTitle, int position);

    public String getEducationItemUrlSoundA(String categoryTitle, int position);

    public String getEducationItemUrlSoundB(String categoryTitle, int position);

    public String getEducationItemUrlSoundC(String categoryTitle, int position);

}
