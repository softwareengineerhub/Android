package org.education.app;

import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.category.impl.CategoryRepositoryImpl;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isCorrect() {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(null);
        int size=categoryRepository.findAll().size();
        assertEquals(3, size);
    }

}