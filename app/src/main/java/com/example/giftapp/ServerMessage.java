package com.example.giftapp;

public class ServerMessage {
    private String text;

    public String getText() {
        return text;
    }


    /**
     * a toString method written for debugging.
     * @return
     */
    @Override
    public String toString() {
        return "ServerMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}
