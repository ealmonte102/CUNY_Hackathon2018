package com.qcconnect.vocalyze.home;

import com.qcconnect.vocalyze.model.CounselSessionStarter;
import com.qcconnect.vocalyze.model.SelectedUserConvo;
import com.qcconnect.vocalyze.model.Session;
import com.qcconnect.vocalyze.repo.MessageRepo;

import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public class HomePresenter implements HomeContract.HomePresenter, SessionAdapter.SessionListPresenter {
    private HomeContract.HomeView view;
    private MessageRepo retriever;
    private List<Session> sessionList;
    private CounselSessionStarter sessionStarter;

    public HomePresenter(MessageRepo retriever, CounselSessionStarter sessionStarter) {
        this.retriever = retriever;
        this.sessionStarter = sessionStarter;
        sessionList = retriever.getAllSessions();
    }

    @Override
    public void onViewAttached(HomeContract.HomeView view) {
        this.view = view;
        reloadSessions();
    }

    @Override
    public void onViewDetached() {
        view = null;
    }

    @Override
    public void reloadSessions() {
        sessionList = retriever.getAllSessions();
        view.reloadList();
    }

    @Override
    public void connectWithCounselor() {
        if (sessionStarter.startSession()) {
            view.navigateToCounselorPage();
        }
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
