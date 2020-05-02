package com.backend.api.sound;

public class SoundApi {

    private static final String soundPath = "http://128.199.185.171:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";
    //private static final String soundPath = "http://134.209.244.234:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";

    public static String getUrl(String categoryName, String detailsName, String language) {
        return String.format(soundPath, categoryName, detailsName, language);
    }


}
