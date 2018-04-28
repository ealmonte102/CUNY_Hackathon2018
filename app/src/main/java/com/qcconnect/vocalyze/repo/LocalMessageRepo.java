package com.qcconnect.vocalyze.repo;

import com.qcconnect.vocalyze.model.Message;
import com.qcconnect.vocalyze.model.Session;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Message> messageList5 = new ArrayList<>();
        List<Message> messageList6 = new ArrayList<>();
        List<Message> messageList7 = new ArrayList<>();
        List<Message> messageList8 = new ArrayList<>();
        List<Message> messageList9 = new ArrayList<>();

        messageList1.add(new Message("Obama", "I wish I was President!", getDate(1,1,2018)));
        messageList2.add(new Message("Logan Paul", "I can't sell dat merch.", getDate(1,1,2018)));
        messageList3.add(new Message("Ricardo", "BOI", getDate(1,1,2018)));
        messageList4.add(new Message("Asif", "BEET CONNNNNNNECT", getDate(1,1,2018)));
        messageList5.add(new Message("Bernice", "Olala", getDate(1,1,2018)));
        messageList6.add(new Message("Jack", "Not a hot dog", getDate(1,1,2018)));
        messageList7.add(new Message("Bit ConECT", "MM MM MM NO NO NO", getDate(1,1,2018)));
        messageList8.add(new Message("Evan", "HALAL", getDate(1,1,2018)));
        messageList9.add(new Message("Jake Paul", "Buy dat merch", getDate(1,1,2018)));
        messages.put("Obama", messageList1);
        messages.put("Logan Paul", messageList2);
        messages.put("Ricardo", messageList3);
        messages.put("Asif", messageList4);
        messages.put("Bernice", messageList5);
        messages.put("Jack", messageList6);
        messages.put("Bit ConECT", messageList7);
        messages.put("Evan", messageList8);
        messages.put("Jake Paul", messageList9);

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
        return null;
    }


    public static Date getDate(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }
}
