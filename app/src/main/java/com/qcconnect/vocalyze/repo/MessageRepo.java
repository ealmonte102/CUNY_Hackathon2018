package com.qcconnect.vocalyze.repo;

import com.qcconnect.vocalyze.model.Session;

import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface SessionRepository {
    List<Session> getSessions();
    void addMessage(Message message)
}
