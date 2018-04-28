package com.qcconnect.vocalyze.home;

import com.qcconnect.vocalyze.base.BasePresenter;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface HomeContract {
    interface HomeView {
        void navigateToProfile();
        void navigateToDiscussionBoard();
        void navigateToCounselorPage();

        void navigateToConversationPage();
        void showToastMessage(String message);
    }

    interface HomePresenter extends BasePresenter<HomeView> {
        void reloadSessions();
        void connectWithCounselor();
        void goToDiscussionBoard();
        void goToProfile();
    }
}
