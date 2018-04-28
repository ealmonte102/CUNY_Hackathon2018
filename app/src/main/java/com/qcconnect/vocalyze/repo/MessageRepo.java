package com.qcconnect.vocalyze.repo;

import com.qcconnect.vocalyze.model.Message;
import com.qcconnect.vocalyze.model.Session;

import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface MessageRepo {
    List<Session> getAllSessions();
    List<Message> getMessageForUser(String username);
}
