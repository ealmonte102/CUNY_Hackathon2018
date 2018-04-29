package com.qcconnect.vocalyze.model;

import java.util.Date;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class Message {
    public final String messageText;
    public final String sender;
    private final Date messageDate;

    public Message( String sender, String messageText, Date messageDate) {
        this.messageDate = messageDate;
        this.messageText = messageText;
        this.sender = sender;
    }

    public long getDate() {
        return messageDate.getTime();
    }

    public String toString() {
        return sender + ": " + messageText + " | " + messageDate;
    }
}
