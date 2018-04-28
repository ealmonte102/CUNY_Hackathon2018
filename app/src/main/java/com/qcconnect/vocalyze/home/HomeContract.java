package com.qcconnect.vocalyze.home;

import com.qcconnect.vocalyze.base.BasePresenter;
import com.qcconnect.vocalyze.model.Session;

import java.util.List;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface HomeContract {
    interface HomeView {
        void navigateToProfile();
        void navigateToDiscussionBoard();
        void navigateToCounselorPage();
        void showToastMessage(String message);
    }

    interface HomePresenter extends BasePresenter<HomeView> {
        void reloadSessions();
        void connectWithCounselor();
        void goToDiscussionBoard();
        void goToProfile();
    }
}
