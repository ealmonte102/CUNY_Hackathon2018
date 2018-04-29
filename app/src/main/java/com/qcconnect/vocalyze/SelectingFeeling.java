package com.qcconnect.vocalyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;



public class SelectingFeeling extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_feeling);

        String[] emotions = {"ANGRY", "BORED", "CONFLICTED", "CONFUSED", "CURIOUS", "DISGUSTED", "EMBARRASSED", "HEARTBROKEN", "LIFELESS", "LONELY", "LOST", "SAD", "SCARED", "SHOCKED", "TIRED"};
        ListAdapter emotionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emotions);
        ListView emotionListView =  findViewById(R.id.emotion_list);
        emotionListView.setAdapter(emotionAdapter);


        emotionListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String emotion = String.valueOf(adapterView.getItemAtPosition(position));

                        //
                        // add emotion to profile


                    }
                }
        );


    }


}
