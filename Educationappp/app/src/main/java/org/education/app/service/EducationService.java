package org.education.app.service;

import org.education.app.model.Category;
import org.education.app.model.EducationItem;

import java.util.List;

public interface EducationService {

    public List<Category> findAllCategories();

    public List<EducationItem> findAllEducationItems(String categoryTitle);

}
