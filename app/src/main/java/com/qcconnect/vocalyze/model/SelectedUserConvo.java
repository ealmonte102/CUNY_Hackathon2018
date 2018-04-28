package com.qcconnect.vocalyze.model;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class SelectedUserConvo {
    private static final SelectedUserConvo ourInstance = new SelectedUserConvo();
    private String sessionUsername;

    public static SelectedUserConvo getInstance() {
        return ourInstance;
    }

    private SelectedUserConvo() { }

    public void setSelectedSession(String sessionUsername) {
        this.sessionUsername = sessionUsername;
    }

    public String getSelectedSession() {
        return sessionUsername;
    }
}
