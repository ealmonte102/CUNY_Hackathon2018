package com.qcconnect.vocalyze.model;

import java.util.Date;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class Message {
    public final String messageText;
    private final Date messageDate;
    public final String sender;

    public Message( String sender, String messageText, Date messageDate) {
        this.messageDate = messageDate;
        this.messageText = messageText;
        this.sender = sender;
    }

    public String getDate() {
        return messageDate.toString();
    }
}
