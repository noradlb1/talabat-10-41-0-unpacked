package library.talabat.mvp.numberverification;

import library.talabat.mvp.IGlobalListener;

public interface NumberVerificationListener extends IGlobalListener {
    void onMobileCheckVerified(boolean z11, String str, int i11, String str2, boolean z12);

    void onMobileNumberInCorrectGetCode(boolean z11, String str, int i11, String str2, boolean z12);

    void onMobileNumberVerified(boolean z11, String str, int i11, String str2, boolean z12, int i12);

    void onMobileNumberVerifiedWithCode(boolean z11, String str, int i11, String str2, boolean z12, boolean z13);

    void onNumberUpdated();

    void onValidationErrorHandler(String str, int i11);

    void updateMobielNumbeVerifcationFailed(String str, int i11, String str2, String str3, String str4);

    void updateMobielNumbeVerifcationSucess(String str, int i11, String str2, boolean z11);
}
