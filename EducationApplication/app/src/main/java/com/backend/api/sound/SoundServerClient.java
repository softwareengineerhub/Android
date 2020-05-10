package com.backend.api.sound;

import com.backend.api.server.data.MessageData;
import com.sound.api.model.SoundDataRequest;
import com.sound.api.model.SoundDataResponse;

public interface SoundServerClient {

    public SoundDataResponse readData(SoundDataRequest soundDataRequest);
}
