package library.talabat.mvp.login;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import library.talabat.mvp.IGlobalListener;
import library.talabat.mvp.RequestOtpListener;

public interface LoginListener extends IGlobalListener, RequestOtpListener {
    void onAccountComplianceFailed();

    void onCustomerInfoRecieved(CustomerAddressInfoJsonResult customerAddressInfoJsonResult);

    void onInvalidCredentialsForMobileLogin(String str);

    void onKurdishNamesBlocked(String str);

    void onLoginFailed(String str, String str2);

    void onLoginFailedBecauseOfTooManyRequests();

    void onLoginFailedWithAccessDeniedCase();

    void onLoginFailedWithTokenExchangeFailure();

    void onLoginSucess();

    void onRequestCompleted();

    void showEmailNotRegisteredError(String str, String str2);

    void showEmailPopup();
}
