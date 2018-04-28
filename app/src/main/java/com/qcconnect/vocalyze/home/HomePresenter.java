package com.qcconnect.vocalyze.home;

import com.qcconnect.vocalyze.model.SelectedUserConvo;
import com.qcconnect.vocalyze.model.Session;
import com.qcconnect.vocalyze.repo.MessageRepo;

import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class HomePresenter implements HomeContract.HomePresenter, SessionAdapter.SessionListPresenter {
    HomeContract.HomeView view;
    MessageRepo retriever;
    private List<Session> sessionList;

    public HomePresenter(MessageRepo retriever) {
        this.retriever = retriever;
        sessionList = retriever.getAllSessions();
    }

    @Override
    public void onViewAttached(HomeContract.HomeView view) {
        this.view = view;
    }

    @Override
    public void onViewDetached() {
        view = null;
    }

    @Override
    public void reloadSessions() {
        sessionList = retriever.getAllSessions();
    }

    @Override
    public void connectWithCounselor() {
        view.navigateToCounselorPage();
    }

    @Override
    public void goToDiscussionBoard() {
        view.navigateToDiscussionBoard();
    }

    @Override
    public void goToProfile() {
        view.navigateToProfile();
    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }

    @Override
    public void onBindSessionRowViewAtPosition(int position, SessionAdapter.SessionViewHolder rowView) {
        Session session = sessionList.get(position);
        rowView.setRecentChatText(session.recentMessage);
        rowView.setUserText(session.userName);
    }

    @Override
    public void openSession(int position) {
        SelectedUserConvo.getInstance().setSelectedSession(sessionList.get(position).userName);
        view.navigateToConversationPage();
    }
}
