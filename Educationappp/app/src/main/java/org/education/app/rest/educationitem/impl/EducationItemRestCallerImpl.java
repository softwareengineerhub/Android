package org.education.app.rest.educationitem.impl;

import org.education.app.rest.educationitem.EducationItemRestCaller;

import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EducationItemRestCallerImpl implements EducationItemRestCaller {
    private String GET_EDUCATION_ITEM_IMAGE = "http://it-interview.org:8080/modile-service-application/ReadEducationItemImg";
    private String GET_EDUCATION_ITEM_SOUND = "http://it-interview.org:8080/modile-service-application/ReadEducationItemSound";

    @Override
    public byte[] requestForImage(String categoryTitle, int position) {
        try {
            String parameters = String.format("?categoryTitle=%s&position=%s", categoryTitle, position);
            URL url = new URL(GET_EDUCATION_ITEM_IMAGE + parameters);
            System.out.println(url);
            return makeCall(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] requestForSoundA(String title, int position) {
        try {
            String parameters = String.format("?title=%s&position=%s&soundType=A", title, position);
            URL url = new URL(GET_EDUCATION_ITEM_SOUND + parameters);
            return makeCall(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] requestForSoundB(String title, int position) {
        try {
            String parameters = String.format("?title=%s&position=%s&soundType=B", title, position);
            URL url = new URL(GET_EDUCATION_ITEM_SOUND + parameters);
            return makeCall(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] requestForSoundC(String title, int position) {
        try {
            String parameters = String.format("?title=%s&position=%s&soundType=C", title, position);
            URL url = new URL(GET_EDUCATION_ITEM_SOUND + parameters);
            return makeCall(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getEducationItemUrlSoundA(String categoryTitle, int position) {
        return String.format("%s?categoryTitle=%s&position=%s&soundType=langA", GET_EDUCATION_ITEM_SOUND, categoryTitle, position);
    }

    @Override
    public String getEducationItemUrlSoundB(String categoryTitle, int position) {
        return String.format("%s?categoryTitle=%s&position=%s&soundType=langB",GET_EDUCATION_ITEM_SOUND, categoryTitle, position);
    }

    @Override
    public String getEducationItemUrlSoundC(String categoryTitle, int position) {
        return String.format("%s?categoryTitle=%s&position=%s&soundType=langC", GET_EDUCATION_ITEM_SOUND, categoryTitle, position);
    }


    private byte[] makeCall(URL url) {
        BufferedInputStream buff = null;
        try {
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
        }
    }


}
