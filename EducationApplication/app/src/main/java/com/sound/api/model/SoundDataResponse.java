/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sound.api.model;

import java.io.Serializable;

/**
 *
 * @author asusadmin
 */
public class SoundDataResponse implements Serializable {

    private byte[] data;

    private static final long serialVersionUID = 7L;

    public SoundDataResponse() {
    }

    public SoundDataResponse(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
