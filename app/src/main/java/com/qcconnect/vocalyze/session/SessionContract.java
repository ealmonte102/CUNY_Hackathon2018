package com.qcconnect.vocalyze.session;

import com.qcconnect.vocalyze.base.BasePresenter;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface SessionContract {
    interface SessionView {
        void navigateToProfile();
        void navigateToDiscussionBoard();
        void navigateToCounselorPage();
        void showToastMessage(String message);
    }

    interface HomePresenter extends BasePresenter<SessionView> {
        void reloadSessions();
        void sendMessage(String message);
    }
}
