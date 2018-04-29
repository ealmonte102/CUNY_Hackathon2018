package com.qcconnect.vocalyze.session;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qcconnect.vocalyze.R;
import com.qcconnect.vocalyze.model.Message;
import com.qcconnect.vocalyze.model.SelectedUserConvo;


/**
 * Created by evanalmonte on 4/28/18.
 */

public class ConversationAdapter extends RecyclerView.Adapter {
    String otherUser = SelectedUserConvo.getInstance().getSelectedSession();
    private ConversationListPresenter presenter;

    public ConversationAdapter(ConversationListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        MessageType type = MessageType.values()[viewType];
        switch (type) {
            case RECEIVED:
                itemView = inflater.inflate(R.layout.list_item_recieved_message, parent, false);
                return new RecievedMessageViewHolder(itemView);
            case SENT:
                itemView = inflater.inflate(R.layout.list_item_sent_message, parent, false);
                return new SentMessageViewHolder(itemView);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = presenter.getMessageAtPosition(position);
        if (message.sender.equals(otherUser)) {
            return MessageType.RECEIVED.ordinal();
        } else {
            return MessageType.SENT.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        presenter.onBindConversationRowViewAtPosition(position, (ConversationRowView) holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    public enum MessageType {
        RECEIVED, SENT
    }

    interface ConversationRowView {
        void setUsername(String username);

        void setTime(String time);

        void setMessageText(String message);
    }

    interface ConversationListPresenter {
        int getItemCount();

        void onBindConversationRowViewAtPosition(int position, ConversationRowView rowView);

        Message getMessageAtPosition(int position);
    }

    class RecievedMessageViewHolder extends RecyclerView.ViewHolder implements ConversationRowView {
        private TextView usernameText;
        private TextView timeText;
        private TextView messageText;

        public RecievedMessageViewHolder(View itemView) {
            super(itemView);
            usernameText = itemView.findViewById(R.id.text_message_name);
            timeText = itemView.findViewById(R.id.text_message_time);
            messageText = itemView.findViewById(R.id.text_message_body);
        }

        @Override
        public void setUsername(String username) {
            usernameText.setText(username);
        }

        @Override
        public void setTime(String time) {
            timeText.setText(time);
        }

        @Override
        public void setMessageText(String messageText) {
            this.messageText.setText(messageText);
        }
    }

    class SentMessageViewHolder extends RecyclerView.ViewHolder implements ConversationRowView {
        private TextView timeText;
        private TextView messageText;

        public SentMessageViewHolder(View itemView) {
            super(itemView);
            timeText = itemView.findViewById(R.id.text_message_time);
            messageText = itemView.findViewById(R.id.text_message_body);
        }

        @Override
        public void setUsername(String username) {
            /*
            Intentionally left empty
             */
        }

        @Override
        public void setTime(String time) {
            timeText.setText(time);
        }

        @Override
        public void setMessageText(String message) {
            messageText.setText(message);
        }
    }

}
