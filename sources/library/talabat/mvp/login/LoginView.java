package library.talabat.mvp.login;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.talabat.helpers.Talabat;

public interface LoginView extends Talabat {
    public static final int INVALID_EMAIL = 3;
    public static final int REG_MIN_CHARACTER_REQUIREMENT_FAILED = 102;
    public static final int VE_MOBILE_PASSWORD_LENGTH = 6;
    public static final int VE_PLEASE_ENTER_MOBILE = 4;
    public static final int VE_PLEASE_ENTER_MOBILE_OTP = 7;
    public static final int VE_PLEASE_ENTER_MOBILE_PASSWORD = 5;
    public static final int VE_PLEASE_ENTER_PASSWORD = 2;
    public static final int VE_PLEASE_ENTER_USERNAME = 1;

    public enum LoginMethodPriority {
        GOOGLE,
        FACEBOOK
    }

    void autoSignin(Credential credential);

    void disableGetOtpLinkFor(int i11);

    void disableLoginWithMobileButton();

    void displayLoginWithEmailOption();

    void displayLoginWithMobileOption();

    void displayLoginWithMobileScreen(int i11, boolean z11);

    void displayLoginWithSocialOption();

    void emailNotRegisteredPopup(String str);

    void enableLoginWithMobileButton();

    void finishAndGoToHomeScreen();

    void finishWithResultGoToAddressList();

    void finishWithResultOK();

    Context getContext();

    String getEmail();

    String getPassword();

    void instantiateViews(boolean z11);

    void loginSocialViewVisibility();

    void navigateToAAALogin();

    void onBackButtonPressed();

    void onCustomerInfoRecieved(CustomerAddressInfoJsonResult customerAddressInfoJsonResult);

    void onLoginFailed(String str);

    void onLoginFailedBecauseOfTooManyRequests();

    void onLoginFailedWithAccessDeniedMessage();

    void onLoginFailedWithTokenExchangeFailure();

    void onLoginSucess(int i11);

    void onValidationError(int i11);

    void saveSmartLockSucess();

    void showAlertDialog(String str);

    void showComplianceCannotCreateAccountDialog();

    void showCouldNotValidateDetailsDialog(String str);

    void showDSLoginMethods(LoginMethodPriority loginMethodPriority);

    void showEmailPopup();

    void showInvalidCredentialsForMobileLoginError(String str);

    void showLoginMethods(LoginMethodPriority loginMethodPriority);

    void showSuccessOtpRequestDialog();
}
