package com.talabat.registration;

import android.content.Context;
import datamodels.RegistrationRM;
import library.talabat.mvp.IGlobalInteractor;

public interface IRegistrationInteractor extends IGlobalInteractor {
    void registerCustomer(RegistrationListener registrationListener, Context context, RegistrationRM registrationRM, int i11);

    void requestOtp(String str, RegistrationListener registrationListener);
}
