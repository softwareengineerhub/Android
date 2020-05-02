package com.backend.api.server;

import com.backend.api.model.details.Details;
import com.backend.api.server.data.MessageData;

import java.util.List;

public class DetailsDao {
    private List<Details> lastVisited;
    private ServerClient serverClient;
    //private String host = "134.209.244.234";
    private String host = "128.199.185.171";

    private int port = 8083;

    public void cleanup(){
        lastVisited=null;
    }

    public List<Details> findAllDetails(String categoryName) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        serverClient = new ServerClientImpl(host, port);
        lastVisited =  (List<Details>) serverClient.readData(messageData);
        return  lastVisited;
    }

}
