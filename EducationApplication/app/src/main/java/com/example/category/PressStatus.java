package com.example.category;

public class PressStatus {
    private static boolean pressed;

    public static synchronized boolean isPressed(){
        return pressed;
    }

    public static synchronized void setPressed(boolean pressedStatus){
        pressed = pressedStatus;
    }

}
