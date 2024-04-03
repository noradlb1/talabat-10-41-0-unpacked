package com.talabat.registration;

import library.talabat.mvp.IGlobalPresenter;

public interface IRegistrationPresenter extends IGlobalPresenter {

    public enum RegistrationType {
        EMAIL,
        MOBILE_NUMBER
    }

    boolean isAdvancedPasswordValidationEnabled();

    void onCreate(RegistrationType registrationType);

    void onGetOTPClick(String str);

    void onOtpFieldTextChanged(String str);

    void validateAndRegisterImprovedUX(RegistrationType registrationType);
}
