package library.talabat.mvp.forgotpassword;

import JsonModels.Response.PasswordResponse;
import library.talabat.mvp.IGlobalListener;

public interface ForgotPasswordListener extends IGlobalListener {
    void onRequestPasswordSuccess(PasswordResponse passwordResponse);
}
