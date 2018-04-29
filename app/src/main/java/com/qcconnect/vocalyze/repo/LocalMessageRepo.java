package com.qcconnect.vocalyze.repo;

import com.qcconnect.vocalyze.model.Message;
import com.qcconnect.vocalyze.model.Session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class LocalMessageRepo implements MessageRepo {
    HashMap<String, List<Message>> messages = new HashMap<>();

    public LocalMessageRepo() {
        List<Message> messageList1 = new ArrayList<>();
        List<Message> messageList2 = new ArrayList<>();
        List<Message> messageList3 = new ArrayList<>();
        List<Message> messageList4 = new ArrayList<>();

        messageList1.add(new Message("Dr. Joe Shmoe", "How are you feeling today Jack?", getDate(1, 1, 2018)));
        messageList1.add(new Message("qcconnect", "Ehh. I woke up and couldn't get out of bed", getDate(1, 1, 2018)));
        messageList1.add(new Message("Dr. Joe Shmoe", "What was on your mind?", getDate(1, 1, 2018)));
        messageList1.add(new Message("qcconnect", "alot. I feel horrible.", getDate(1, 1, 2018)));

        messageList2.add(new Message("Dr. Kathleen Tanner", "Hey qcconnect", getDate(1, 1, 2018)));
        messageList2.add(new Message("qcconnect", "Hey Joe, I feel like a failure", getDate(1, 1, 2018)));
        messageList2.add(new Message("qcconnect", "I don't want to do anything", getDate(1, 1, 2018)));

        messageList3.add(new Message("qcconnect", "I'm angry at the world! I wish I didn't have to deal with anyone!", getDate(1, 1, 2018)));
        messageList3.add(new Message("Dr. Jeff Heffley", "What's on your mind Nicholas?", getDate(1, 1, 2018)));
        messageList3.add(new Message("qcconnect", "EVERYONE makes me angry! I don't want to deal with thme", getDate(1, 1, 2018)));

        messageList4.add(new Message("qcconnect", "BEET CONNNNNNNECT", getDate(1, 1, 2018)));
        messageList4.add(new Message("Dr. Carlos M.", "WASO WASO", getDate(1, 1, 2018)));
        messageList4.add(new Message("qcconnect", "NONNONO", getDate(1, 1, 2018)));
        messageList4.add(new Message("Dr. Carlos M.", "BEET CONNNNNNNECT", getDate(1, 1, 2018)));

        messages.put("Dr. Joe Shmoe", messageList1);
        messages.put("Dr. Kathleen Tanne", messageList2);
        messages.put("Dr. Jeff Heffley", messageList3);
        messages.put("Dr. Carlos M.", messageList4);

    }

    public static Date getDate(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    @Override
    public List<Session> getAllSessions() {
        List<Session> sessionList = new ArrayList<>();
        for(String key : messages.keySet()) {
            List<Message> session = messages.get(key);
            sessionList.add(new Session(key, session.get(session.size() - 1).messageText));
        }
        return sessionList;
    }

    @Override
    public List<Message> getMessageForUser(String username) {
        return messages.get(username);
    }
}
