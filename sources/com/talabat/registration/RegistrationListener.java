package com.talabat.registration;

import library.talabat.mvp.IGlobalListener;
import library.talabat.mvp.RequestOtpListener;

public interface RegistrationListener extends IGlobalListener, RequestOtpListener {
    void onAccountAlreadyExistForMobileNumber(String str);

    void onAccountComplianceFailed();

    void onKurdishNamesBlocked(String str);

    void onRegisterFailedWithAccessDeniedCase();

    void onRegistrationCompleted();

    void onRegistrationFailed(String str, String str2, String str3);

    void showEmailPopup();
}
