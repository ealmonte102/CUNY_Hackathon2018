package com.qcconnect.vocalyze;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SelectingFeeling extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_feeling);

        RecyclerView emotionListView =  findViewById(R.id.emotion_list);
        emotionListView.setAdapter(new EmotionAdapter());
        emotionListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }


    public class EmotionAdapter extends RecyclerView.Adapter<EmotionAdapter.EmotionViewHolder> {
        String[] emotions = {"ANGRY", "BORED", "CONFLICTED", "CONFUSED", "CURIOUS", "DISGUSTED", "EMBARRASSED", "HAPPY", "HEARTBROKEN", "LIFELESS", "LONELY", "LOST", "SAD", "SCARED", "SHOCKED", "TIRED"};

        @Override
        public EmotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.emotion_list_item, parent, false);
            return new EmotionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(EmotionViewHolder holder, int position) {
            holder.textView.setText(emotions[position]);
        }

        @Override
        public int getItemCount() {
            return emotions.length;
        }


        class EmotionViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public EmotionViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.emotion_listitem);
            }
        }
//    }


    }
}
