package com.qcconnect.vocalyze.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.qcconnect.vocalyze.R;
import com.qcconnect.vocalyze.repo.LocalMessageRepo;

public class MainActivity extends AppCompatActivity {

    private RecyclerView sessionRecView;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new HomePresenter(new LocalMessageRepo());
        sessionRecView = findViewById(R.id.recview_session_list);
        sessionRecView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        sessionRecView.setAdapter(new SessionAdapter(presenter));
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            =  new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_discussion:
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };
}
