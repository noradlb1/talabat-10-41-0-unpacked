package library.talabat.mvp.forgotpassword;

import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;

public interface IForgotPasswordPresenter extends IGlobalPresenter {
    void onCreate(boolean z11);

    void validateAndRequest(@NotNull String str);
}
