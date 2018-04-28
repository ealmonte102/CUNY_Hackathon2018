package com.qcconnect.vocalyze.session;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.qcconnect.vocalyze.R;


/**
 * Created by evanalmonte on 4/28/18.
 */

public class ConversationActivity extends AppCompatActivity implements ConversationContract.View {

    private RecyclerView messageRecyclerView;
    private Button sendButton;
    private ConversationContract.Presenter presenter;
    private EditText sendChatBoxText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        messageRecyclerView = findViewById(R.id.reyclerview_messages);
        sendButton = findViewById(R.id.button_chatbox_send);
        sendChatBoxText = findViewById(R.id.edittext_chatbox);
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void navigateToProfile() {

    }

    @Override
    public void navigateToDiscussionBoard() {

    }

    @Override
    public void navigateToCounselorPage() {

    }

    @Override
    public void showToastMessage(String message) {

    }

    private android.view.View.OnClickListener sendButtonOnClickListener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View view) {
            presenter.sendMessage(sendChatBoxText.getText().toString());
        }
    };
}
