package org.education.app.repository.educationitem;

import org.education.app.model.EducationItem;

import java.util.List;

public interface EduactionItemRepository {

    public List<EducationItem> findAll();

    public EducationItem findNext();

    public EducationItem findPrev();
}
