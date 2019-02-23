package org.education.app.service.impl;

import org.education.app.model.Category;
import org.education.app.model.EducationItem;
import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.educationitem.EduactionItemRepository;
import org.education.app.service.EducationService;

import java.util.ArrayList;
import java.util.List;

public class EduactionServiceImpl implements EducationService {
    private CategoryRepository categoryRepository;
    private EduactionItemRepository eduactionItemRepository;

    public EduactionServiceImpl(CategoryRepository categoryRepository, EduactionItemRepository eduactionItemRepository) {
        this.categoryRepository = categoryRepository;
        this.eduactionItemRepository = eduactionItemRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        //return  categories();
        return categoryRepository.findAll();
    }




    @Override
    public List<EducationItem> findAllEducationItems(String categoryTitle) {
        return eduactionItemRepository.findAll();
    }


    private List<Category> categories(){
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
