package org.education.app.repository.category;

import org.education.app.model.Category;
import java.util.List;

public interface CategoryRepository {

    public List<Category> findAll();
}
