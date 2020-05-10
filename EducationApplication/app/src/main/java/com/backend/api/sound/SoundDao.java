package com.backend.api.sound;

import com.backend.api.config.ServerConfig;
import com.backend.api.model.details.Details;
import com.backend.api.server.ServerClientImpl;
import com.sound.api.model.SoundDataRequest;
import com.sound.api.model.SoundDataResponse;

import java.util.List;

public class SoundDao {
    private String host = ServerConfig.HOST;

    private int port = 8081;
    SoundServerClient soundServerClient = new SoundServerClientImpl(host, port);

    public byte[] getSoundData(String categoryName, String detailsName, String language) {
        long start = System.currentTimeMillis();
        SoundDataResponse soundDataResponse = soundServerClient.readData(new SoundDataRequest(categoryName, detailsName, language));
        System.out.println("####################"+(System.currentTimeMillis()-start));
        return soundDataResponse.getData();
    }
}
