package com.qcconnect.vocalyze.session;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.qcconnect.vocalyze.R;
import com.qcconnect.vocalyze.repo.LocalMessageRepo;


/**
 * Created by evanalmonte on 4/28/18.
 */

public class ConversationActivity extends AppCompatActivity implements ConversationContract.View {

    private RecyclerView messageRecyclerView;
    private Button sendButton;
    private ConversationContract.Presenter presenter;
    private ConversationAdapter adapter;
    private EditText sendChatBoxText;
    private android.view.View.OnClickListener sendButtonOnClickListener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View view) {
            presenter.sendMessage(sendChatBoxText.getText().toString());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        messageRecyclerView = findViewById(R.id.reyclerview_messages);
        sendButton = findViewById(R.id.button_chatbox_send);
        sendChatBoxText = findViewById(R.id.edittext_chatbox);
        ConversationPresenter presenter = new ConversationPresenter(LocalMessageRepo.getInstance());
        this.presenter = presenter;
        adapter = new ConversationAdapter(presenter);
        messageRecyclerView.setAdapter(adapter);
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewAttached(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDetached();
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
}
