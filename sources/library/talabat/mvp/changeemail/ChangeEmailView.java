package library.talabat.mvp.changeemail;

import com.talabat.helpers.Talabat;

public interface ChangeEmailView extends Talabat {
    public static final int VAL_EMAIL_MISMATCH = 23;
    public static final int VAL_EMAIL_PATTERN_ERROR = 24;
    public static final int VAL_ENTER_EMAIL = 20;
    public static final int VAL_ENTER_PASSWORD = 22;
    public static final int VAL_RETYPE_EMAIL = 21;

    void credentialUpdated(boolean z11);

    String getCurrentPassword();

    String getNewEmail();

    String getRetypedEmail();

    void onEmailRequestFailed(String str);

    void onEmailRequestSuccess(String str);

    void onValidationError(int i11);

    void onValidationSuccess();
}
