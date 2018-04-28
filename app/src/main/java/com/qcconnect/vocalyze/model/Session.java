package com.qcconnect.vocalyze.model;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class Session {
    public final String userName;
    public final String recentMessage;

    public Session(String userName, String recentMessage) {
        this.userName = userName;
        this.recentMessage = recentMessage;
    }
}
