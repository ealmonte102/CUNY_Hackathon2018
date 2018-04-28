package com.qcconnect.vocalyze.session;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {


    @Override
    public ConversationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ConversationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder {

        public ConversationViewHolder(View itemView) {
            super(itemView);
        }
    }

}
