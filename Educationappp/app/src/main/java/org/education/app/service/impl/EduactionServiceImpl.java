package org.education.app.service.impl;

import org.education.app.model.Category;
import org.education.app.model.EducationItem;
import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.educationitem.EduactionItemRepository;
import org.education.app.rest.category.CategoryRestCaller;
import org.education.app.rest.category.impl.CategoryRestCallerImpl;
import org.education.app.rest.educationitem.EducationItemRestCaller;
import org.education.app.rest.educationitem.impl.EducationItemRestCallerImpl;
import org.education.app.service.EducationService;

import java.util.ArrayList;
import java.util.List;

public class EduactionServiceImpl implements EducationService {

    private CategoryRepository categoryRepository;
    private EduactionItemRepository eduactionItemRepository;
    private CategoryRestCaller categoryRestCaller;
    private EducationItemRestCaller educationItemRestCaller;

    public EduactionServiceImpl(CategoryRepository categoryRepository, EduactionItemRepository eduactionItemRepository) {
        this.categoryRepository = categoryRepository;
        this.eduactionItemRepository = eduactionItemRepository;
        categoryRestCaller = new CategoryRestCallerImpl();
        educationItemRestCaller = new EducationItemRestCallerImpl();
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRestCaller.requestAllCategories();
    }

    @Override
    public List<EducationItem> findAllEducationItems(String categoryTitle) {
        return eduactionItemRepository.findAll();
    }

    @Override
    public byte[] getEducationItemImg(String categoryTitle, int position) {
        return educationItemRestCaller.requestForImage(categoryTitle, position);
    }

    @Override
    public byte[] getEducationItemSoundA(String categoryTitle, int position) {
        return educationItemRestCaller.requestForSoundA(categoryTitle, position);
    }

    @Override
    public byte[] getEducationItemSoundB(String categoryTitle, int position) {
        return educationItemRestCaller.requestForSoundB(categoryTitle, position);
    }

    @Override
    public byte[] getEducationItemSoundC(String categoryTitle, int position) {
        return educationItemRestCaller.requestForSoundC(categoryTitle, position);
    }

    @Override
    public String getEducationItemUrlSoundA(String categoryTitle, int position) {
        return educationItemRestCaller.getEducationItemUrlSoundA(categoryTitle, position);
    }

    @Override
    public String getEducationItemUrlSoundB(String categoryTitle, int position) {
        return educationItemRestCaller.getEducationItemUrlSoundA(categoryTitle, position);
    }

    @Override
    public String getEducationItemUrlSoundC(String categoryTitle, int position) {
        return educationItemRestCaller.getEducationItemUrlSoundA(categoryTitle, position);
    }

    private List<Category> categories() {
        List<Category> list = new ArrayList<>();
        Category c1 = new Category();
        c1.setLanguageA("A1");
        c1.setLanguageB("B1");
        c1.setLanguageC("C1");
        c1.setTitle("Title1");

        Category c2 = new Category();
        c2.setLanguageA("A2");
        c2.setLanguageB("B2");
        c2.setLanguageC("C2");
        c2.setTitle("Title2");

        Category c3 = new Category();
        c3.setLanguageA("A3");
        c3.setLanguageB("B3");
        c3.setLanguageC("C3");
        c3.setTitle("Title3");

        list.add(c1);
        list.add(c2);
        list.add(c3);
        return list;
    }

}
