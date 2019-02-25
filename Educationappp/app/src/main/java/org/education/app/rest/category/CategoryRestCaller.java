package org.education.app.rest.category;

import org.education.app.model.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public interface CategoryRestCaller {

    public List<Category> requestAllCategories();
 
    public byte[] requestForImage(String categoryTitle);

}