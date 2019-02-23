package org.education.app.config;

import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.category.impl.CategoryRepositoryImpl;
import org.education.app.repository.datasource.EduactionDataSource;
import org.education.app.repository.educationitem.EduactionItemRepository;
import org.education.app.repository.educationitem.impl.EducationItemRepositoryImpl;
import org.education.app.service.EducationService;
import org.education.app.service.impl.EduactionServiceImpl;

import javax.sql.DataSource;

public class ApplicationConfig {

    private DataSource dataSource;
    private CategoryRepository categoryRepository;
    private EduactionItemRepository eduactionItemRepository;
    private EducationService educationService;
    private static ApplicationConfig instance = new ApplicationConfig();

    private ApplicationConfig() {
        dataSource = new EduactionDataSource();
        categoryRepository = new CategoryRepositoryImpl(dataSource);
        eduactionItemRepository = new EducationItemRepositoryImpl(dataSource);
        educationService = new EduactionServiceImpl(categoryRepository, eduactionItemRepository);
    }

    public EducationService getEducationService() {
        return educationService;
    }

    public static ApplicationConfig getInstance() {
        return instance;
    }
}
