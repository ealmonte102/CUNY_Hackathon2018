package com.qcconnect.vocalyze.model;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class Session {
    private static final String CHAT_PREFIX_TEXT = "Chat with ";
    private String userName;
    private String recentMessage;

    public Session(String userName, String recentMessage) {
        this.userName = userName;
        this.recentMessage = recentMessage;
    }
}
