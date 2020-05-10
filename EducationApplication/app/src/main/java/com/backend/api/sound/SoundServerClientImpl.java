package com.backend.api.sound;

import com.sound.api.model.SoundDataRequest;
import com.sound.api.model.SoundDataResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SoundServerClientImpl implements SoundServerClient {

    private String host;
    private int port;
    private Socket socket;

    public SoundServerClientImpl(String host, int port) {
        try {
            this.host = host;
            this.port = port;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public SoundDataResponse readData(SoundDataRequest soundDataRequest) {
        try {
            socket = new Socket(InetAddress.getByName(host), port);
            //socket = new Socket(InetAddress.getByName("128.199.185.171"), 8081);
            //socket.setSoTimeout(10);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(soundDataRequest);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return (SoundDataResponse) in.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            close();
        }
    }


    public void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
