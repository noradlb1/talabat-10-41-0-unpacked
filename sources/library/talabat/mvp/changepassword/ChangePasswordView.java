package library.talabat.mvp.changepassword;

import com.talabat.helpers.Talabat;

public interface ChangePasswordView extends Talabat {
    public static final int VAL_ENTER_NEW_PASSWORD = 31;
    public static final int VAL_ENTER_OLD_PASSWORD = 30;
    public static final int VAL_PASSWORD_CHARACTER_COUNT = 33;
    public static final int VAL_PASSWORD_MISMATCH = 34;
    public static final int VAL_PASSWORD_VALIDATION_FAILED = 35;
    public static final int VAL_RETYPE_PASSWORD = 32;

    void credentialUpdated(boolean z11);

    String getCurrentPassword();

    String getNewPassword();

    String getRetypedPassword();

    void onPasswordRequestFailed(String str);

    void onPasswordRequestSuccess(String str);

    void onValidationError(int i11);

    void onValidationSuccess();
}
