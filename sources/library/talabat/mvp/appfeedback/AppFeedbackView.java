package library.talabat.mvp.appfeedback;

import com.talabat.helpers.Talabat;

public interface AppFeedbackView extends Talabat {
    public static final int VAL_EMAIL = 303;
    public static final int VAL_MOBILE = 302;
    public static final int VAL_RATING = 300;
    public static final int VAL_RATING_COMMENT = 301;

    String getAppVersion();

    String getDateAndTime();

    String getEmail();

    String getFeedbackMessage();

    float getFeedbackRating();

    String getMobileNumber();

    void onValidationError(int i11);

    void sendtoAddContactDetailsPage();

    void setMobilenumber(String str);

    void showFeedbackThankYouPopup();

    void showLoading();
}
