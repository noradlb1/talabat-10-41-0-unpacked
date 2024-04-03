package library.talabat.mvp.login;

import datamodels.LoginRM;
import datamodels.RegistrationRM;
import library.talabat.mvp.IGlobalPresenter;

@Deprecated
public interface ILoginPresenter extends IGlobalPresenter {
    void backButtonPressed();

    @Deprecated
    void faceBookLogin(RegistrationRM registrationRM, int i11);

    void googleSignin(RegistrationRM registrationRM, int i11);

    void login(int i11);

    void loginFromSmartLock(LoginRM loginRM, int i11);

    void loginWithEmailClicked();

    void onContinueWithMobileClicked();

    void onGetOtpClicked(String str);

    void onLoginWithMobileClicked(String str, String str2);

    void onLoginWithOtpClicked(String str, String str2);

    void onOtpFieldTextChanged(String str);

    void redirectBackToSocialLoginPage();

    void setUpFacebookLogin(RegistrationRM registrationRM, int i11);

    void setupViews(String str);
}
