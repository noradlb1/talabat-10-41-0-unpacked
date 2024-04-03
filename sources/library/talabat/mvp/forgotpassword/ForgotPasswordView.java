package library.talabat.mvp.forgotpassword;

import JsonModels.Response.PasswordResponse;
import android.content.Context;
import com.talabat.helpers.Talabat;

public interface ForgotPasswordView extends Talabat {
    public static final int VAL_EMAIL_WRONG_PATTERN = 11;
    public static final int VAL_ENTER_EMAIL = 10;
    public static final int VAL_ENTER_MOBILE_NUMBER = 12;

    Context getContext();

    String getEmail();

    void hideEmailField();

    void loading();

    void onRequestPasswordSuccess(PasswordResponse passwordResponse);

    void onValidationError(int i11);

    void showMobileNumberField(int i11);
}
