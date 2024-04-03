package library.talabat.mvp.forgotpassword;

import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;

public interface IForgotPasswordInteractor extends IGlobalInteractor {
    void sendPasswordRequest(String str);

    void sendPasswordRequestForMobileNumber(@NotNull String str);
}
