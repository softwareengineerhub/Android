package com.backend.api.repository;

import com.backend.api.model.details.Details;

import java.util.ArrayList;
import java.util.List;

public class LocalRepository {
    private static final List<Details> details = new ArrayList<>();
    private static String categoryName;

    public static List<Details> getCurrentDetails(){
        return details;
    }

    public static String getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        LocalRepository.categoryName = categoryName;
    }

    public static List<Details> getDetails() {
        return details;
    }

}
