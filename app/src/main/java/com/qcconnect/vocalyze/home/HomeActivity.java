package com.qcconnect.vocalyze.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qcconnect.vocalyze.R;
import com.qcconnect.vocalyze.model.TestSessionStarter;
import com.qcconnect.vocalyze.repo.LocalMessageRepo;
import com.qcconnect.vocalyze.session.ConversationActivity;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeView {

    private RecyclerView sessionRecView;
    private HomePresenter presenter;
    private Button startConvoButton;
    private SessionAdapter sessionAdapter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return false;
                case R.id.navigation_discussion:
                    presenter.goToDiscussionBoard();
                    return false;
                case R.id.navigation_profile:
                    presenter.goToProfile();
                    return false;
            }
            return false;
        }
    };
    private View.OnClickListener buttonConvoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.connectWithCounselor();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startConvoButton = findViewById(R.id.button_start_convo);
        LocalMessageRepo messageRepo = LocalMessageRepo.getInstance();
        presenter = new HomePresenter(messageRepo, new TestSessionStarter(messageRepo));
        sessionRecView = findViewById(R.id.recview_session_list);
        sessionRecView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        sessionAdapter = new SessionAdapter(presenter);
        sessionRecView.setAdapter(sessionAdapter);
        startConvoButton.setOnClickListener(buttonConvoClickListener);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewAttached(this);
    }

    @Override
    public void navigateToProfile() {
        Toast.makeText(
                getApplicationContext(), "Navigate To Profile not implemented.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDiscussionBoard() {
        Toast.makeText(
                getApplicationContext(), "Navigate To Discussion Board not implemented.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToCounselorPage() {
        navigateToConversationPage();
    }

    @Override
    public void navigateToConversationPage() {
        startActivity(ConversationActivity.class);
    }

    @Override
    public void reloadList() {
        sessionAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void startActivity(Class<?> classname) {
        Intent intent = new Intent(getApplicationContext(), classname);
        startActivity(intent);
    }
}
