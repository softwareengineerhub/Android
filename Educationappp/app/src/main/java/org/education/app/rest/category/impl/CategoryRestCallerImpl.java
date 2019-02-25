package org.education.app.rest.category.impl;

import org.education.app.model.Category;
import org.education.app.rest.category.CategoryRestCaller;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CategoryRestCallerImpl implements CategoryRestCaller {
    private String READ_CATEGORY = "http://it-interview.org:8080/modile-service-application/ReadCategoryServlet";
    private String GET_CATEGORY_IMAGE = "http://it-interview.org:8080/modile-service-application/ReadCategoryImageServlet";

    @Override
    public List<Category> requestAllCategories() {
        BufferedReader reader = null;
        try {
            URL url = new URL(READ_CATEGORY);
            InputStream in = url.openStream();
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder responseContent = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            List<Category> categories = makeCategories(responseContent.toString());
            enrich(categories);
            return categories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public byte[] requestForImage(String categoryTitle) {
        BufferedInputStream buff = null;
        try {
            URL url = new URL(GET_CATEGORY_IMAGE + "?categoryTitle=" + categoryTitle);
            buff = new BufferedInputStream(url.openStream());
            int t = -1;
            List<Byte> bytes = new ArrayList();
            while ((t = buff.read()) != -1) {
                bytes.add((byte) t);
            }
            byte[] data = new byte[bytes.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = bytes.get(i);
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void enrich(List<Category> categories) {
        for (Category category : categories) {
            enrich(category);
        }
    }

    private void enrich(Category category) {
        byte[] data = requestForImage(category.getTitle());
        category.setImg(data);
    }

    private List<Category> makeCategories(String json) throws Exception {
        JSONObject root = new JSONObject(json);
        int size = Integer.parseInt(root.getString("size"));
        List<Category> categories = new ArrayList(size);
        JSONArray array = root.getJSONArray("data");
        JSONObject item = null;
        Category category = null;
        for (int i = 0; i < size; i++) {
            item = array.getJSONObject(i);
            category = new Category();
            category.setTitle(item.getString("title"));
            category.setLanguageA(item.getString("languageA"));
            category.setLanguageB(item.getString("languageB"));
            category.setLanguageC(item.getString("languageC"));
            categories.add(category);
        }
        return categories;
    }
}
