package com.qcconnect.vocalyze.model;

import com.qcconnect.vocalyze.repo.MessageRepo;

import java.util.Date;

/**
 * Created by evanalmonte on 4/29/18.
 */

public class TestSessionStarter implements CounselSessionStarter {
    private String[] randomDoctors = {"Dr. Evan", "Dr. Bernice", "Dr. Asif", "Dr. Ricardo"};
    private MessageRepo messageRepo;
    private SelectedUserConvo selectedUserConvo = SelectedUserConvo.getInstance();

    public TestSessionStarter(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public boolean startSession() {
        selectedUserConvo.setSelectedSession(randomDoctors[(int) (Math.random() * randomDoctors.length)]);
        messageRepo.addNewChat(
                new Message(selectedUserConvo.getSelectedSession(),
                        "Hey qc-connect",
                        new Date(System.currentTimeMillis())));
        return true;
    }
}
