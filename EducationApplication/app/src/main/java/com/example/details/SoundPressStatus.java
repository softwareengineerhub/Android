package com.example.details;

public class SoundPressStatus {
    private static boolean pressed;

    public static synchronized boolean isPressed(){
        return pressed;
    }

    public static synchronized void setPressed(boolean pressedStatus){
        pressed = pressedStatus;
    }

}
