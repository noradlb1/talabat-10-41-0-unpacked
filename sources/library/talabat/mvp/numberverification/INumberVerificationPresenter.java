package library.talabat.mvp.numberverification;

import library.talabat.mvp.IGlobalPresenter;

public interface INumberVerificationPresenter extends IGlobalPresenter {
    void onGetCodeForMobileNumberClicked(String str, int i11, String str2, String str3, String str4);

    void onMobileCheck(String str, String str2, String str3, boolean z11, int i11, String str4, String str5, String str6);

    void onRedirectToLiveChatForMobileVerification(String str, String str2, String str3);

    void setFromAptimize(boolean z11);

    void updateMobileNumberClicked(String str, String str2, String str3, String str4, String str5);

    void verifyMobileNumberWithCodeClicked(String str, String str2, String str3);
}
