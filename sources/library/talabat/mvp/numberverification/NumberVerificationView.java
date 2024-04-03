package library.talabat.mvp.numberverification;

import android.content.Context;
import com.talabat.helpers.Talabat;

public interface NumberVerificationView extends Talabat {
    Context getContext();

    void hideMobileNumberVerificationCodePopup(String str, int i11, boolean z11, boolean z12, boolean z13);

    void onMobileNumberValidationFailedOnGetCode(String str, int i11, String str2);

    void onMobileVerificationCheckFailed(String str, int i11);

    void onRedirectToLiveChatForMobileVerification(String str, String str2, String str3);

    void onValidationError(String str, int i11);

    void setCountryCode();

    void showMobileNumberVerificationCodePopup(String str, int i11, int i12);

    void updateMobielNumbeVerifcationFailed(String str, int i11, String str2, boolean z11, String str3, String str4);

    void updateMobielNumbeVerifcationSuccess(String str, int i11, boolean z11, boolean z12);
}
