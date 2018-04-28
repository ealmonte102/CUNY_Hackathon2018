package com.qcconnect.vocalyze.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qcconnect.vocalyze.R;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {

    private SessionListPresenter presenter;

    public SessionAdapter(SessionListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.viewholder_session, parent, false);
        return new SessionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        presenter.onBindSessionRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    class SessionViewHolder extends RecyclerView.ViewHolder implements SessionRowView {
        private TextView userText;
        private TextView lastResponseText;

        public SessionViewHolder(View itemView) {
            super(itemView);
            userText = itemView.findViewById(R.id.text_session_user);
            lastResponseText = itemView.findViewById(R.id.text_last_response_text);
        }

        @Override
        public void setUserText(String username) {
            userText.setText(username);
        }

        @Override
        public void setRecentChatText(String recentChatText) {
            lastResponseText.setText(recentChatText);
        }
    }

    public interface SessionListPresenter {
        int getItemCount();

        void onBindSessionRowViewAtPosition(int position, SessionViewHolder rowView);

    }

    public interface SessionRowView {
        void setUserText(String username);

        void setRecentChatText(String recentChatText);
    }
}
