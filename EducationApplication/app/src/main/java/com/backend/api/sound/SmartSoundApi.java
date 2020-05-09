package com.backend.api.sound;

import com.sound.api.model.SoundDataRequest;
import com.sound.api.model.SoundDataResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SmartSoundApi {

    private static final String soundPath = "http://128.199.185.171";
    //private static final String soundPath = "http://134.209.244.234:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";

    public static byte[] getSoundData(String categoryName, String detailsName, String language) {
        Socket socket = null;
        try {
            SoundDataRequest soundDataRequest = new SoundDataRequest(categoryName, detailsName, language);
            socket = new Socket(soundPath, 8081);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(soundDataRequest);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            SoundDataResponse soundDataResponse = (SoundDataResponse) in.readObject();
            return soundDataResponse.getData();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
