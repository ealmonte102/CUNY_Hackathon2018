package com.qcconnect.vocalyze.session;

import com.qcconnect.vocalyze.base.BasePresenter;

/**
 * Created by evanalmonte on 4/28/18.
 */

public interface ConversationContract {
    interface View {
        void navigateToProfile();
        void navigateToDiscussionBoard();
        void navigateToCounselorPage();
        void showToastMessage(String message);
    }

    interface Presenter extends BasePresenter<View> {
        void reloadSessions();
        void sendMessage(String message);
    }
}
