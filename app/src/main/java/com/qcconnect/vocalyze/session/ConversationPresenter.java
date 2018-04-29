package com.qcconnect.vocalyze.session;

import android.util.Log;

import com.qcconnect.vocalyze.model.Message;
import com.qcconnect.vocalyze.model.SelectedUserConvo;
import com.qcconnect.vocalyze.repo.MessageRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class ConversationPresenter implements ConversationContract.Presenter, ConversationAdapter.ConversationListPresenter {

    List<Message> messages;
    private MessageRepo repo;
    private ConversationContract.View view;
    private DateFormat format = new SimpleDateFormat("MMM DD hh:mm a", Locale.getDefault());

    public ConversationPresenter(MessageRepo repo) {
        this.repo = repo;
        reloadSessions();
        Log.d("ConversationPresenter", String.valueOf(repo.getMessageForUser(SelectedUserConvo.getInstance().getSelectedSession())));
    }

    @Override
    public void onViewAttached(ConversationContract.View view) {
        this.view = view;
        reloadSessions();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void reloadSessions() {
        messages = repo.getMessageForUser(SelectedUserConvo.getInstance().getSelectedSession());
    }

    @Override
    public void sendMessage(String message) {
        view.showToastMessage("Adding message: " + message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public void onBindConversationRowViewAtPosition(int position, ConversationAdapter.ConversationRowView rowView) {
        Message message = messages.get(position);
        rowView.setUsername(message.sender);
        rowView.setMessageText(message.messageText);
        rowView.setTime(message.sender);
        rowView.setTime(format.format(new Date(message.getDate())));
    }

    @Override
    public Message getMessageAtPosition(int position) {
        return messages.get(position);
    }
}
