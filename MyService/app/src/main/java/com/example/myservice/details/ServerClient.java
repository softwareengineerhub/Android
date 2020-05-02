package com.example.myservice.details;

import com.backend.api.server.data.MessageData;

public interface ServerClient {

    public Object readData(MessageData requestData);
}
