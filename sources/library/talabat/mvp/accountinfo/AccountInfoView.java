package library.talabat.mvp.accountinfo;

import android.content.Context;
import datamodels.CustomerInfo;
import library.talabat.mvp.registration.RegistrationView;

public interface AccountInfoView extends RegistrationView {
    public static final int FIRST_NAME_MINIMUM_CHARACTER = 23;
    public static final int LAST_NAME_MINIMUM_CHARACTER = 24;

    void buttonTextChange();

    Context getContext();

    String getMobileNumber();

    void hideEmailField();

    void onAccountUpdateFailed(String str);

    void onAccountUpdated(CustomerInfo customerInfo);

    void serverValidationFailed(int i11, String str);

    void setDateOfBirth(String str);

    void setEmail(String str);

    void setFirstName(String str);

    void setGender(boolean z11);

    void setLastName(String str);

    void setSubscription(boolean z11, boolean z12);

    void setView();

    void showGenderSelector(boolean z11);

    void showMobileNumber(int i11, String str);

    void switchEnabled(boolean z11);
}
