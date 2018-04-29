package com.qcconnect.vocalyze;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;



public class SelectingFeeling extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_feeling);

        String[] emotions = {"ANGRY", "BORED", "CONFLICTED", "CONFUSED", "CURIOUS", "DISGUSTED", "EMBARRASSED", "HEARTBROKEN", "LIFELESS", "LONELY", "LOST", "SAD", "SCARED", "SHOCKED", "TIRED"};
        ListAdapter emotionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emotions);
        ListView emotionListView =  findViewById(R.id.emotion_list);
        emotionListView.setAdapter(emotionAdapter);




    }

    //private void startActivity(Class<?> classname) {
      //  Intent intent = new Intent(getApplicationContext(), classname);
        //startActivity(intent);
   // }

}
