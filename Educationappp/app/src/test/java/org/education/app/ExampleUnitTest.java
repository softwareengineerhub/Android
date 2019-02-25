package org.education.app;

import org.education.app.repository.category.CategoryRepository;
import org.education.app.repository.category.impl.CategoryRepositoryImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    /*@Test
    public void isCorrect() {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(null);
        int size=categoryRepository.findAll().size();
        assertEquals(4, size);
    }*/

    @Test
    public void isCorrect() throws Exception {
        //CategoryRepository categoryRepository = new CategoryRepositoryImpl(null);
        //int size=categoryRepository.findAll().size();
        //assertEquals(4, size);
        URL url = new URL("http://it-interview.org:8080/modile-service-application/ReadCategoryServlet");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String res=readContentAsString(connection);
        assertNotNull(res);
    }



    private String readContentAsString(HttpURLConnection c) {
        InputStream in = null;
        try {
            in = c.getInputStream();
            byte[] data = new byte[in.available()];
            System.out.println("@@@@data.size="+data.length);
            in.read(data);
            return new String(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}