package com.qcconnect.vocalyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SelectingFeeling extends AppCompatActivity {

    private ListView emotionAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_feeling);
    }

    private void startActivity(Class<?> classname) {
        Intent intent = new Intent(getApplicationContext(), classname);
        startActivity(intent);
    }

}
