package library.talabat.mvp.login;

import androidx.annotation.NonNull;
import com.android.volley.Response;
import datamodels.LoginRM;
import datamodels.RegistrationRM;
import datamodels.Token;
import io.reactivex.Single;
import library.talabat.mvp.IGlobalInteractor;

public interface ILoginInteractor extends IGlobalInteractor {
    public static final int ERROR_CODE_EMAIL = 2;
    public static final String ERROR_REASON_EMAIL_NOT_REGISTERED = "-4";

    void faceBookLogin(RegistrationRM registrationRM);

    Single<Token> faceBookLoginWithResult(RegistrationRM registrationRM);

    void getLogin(LoginRM loginRM);

    void googleLogin(RegistrationRM registrationRM);

    void handleAuthError();

    void handleLoginError(int i11, String str, String str2);

    Response.Listener<Token> onResultRecieved(@NonNull String str);

    void requestOtp(String str);
}
