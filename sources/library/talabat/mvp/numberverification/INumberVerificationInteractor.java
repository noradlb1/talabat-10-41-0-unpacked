package library.talabat.mvp.numberverification;

import JsonModels.Request.MobileNumberVerifyRequest;
import JsonModels.Request.MobileVerification.CheckRequest;
import JsonModels.Request.MobileVerification.EditRequest;
import JsonModels.Request.MobileVerification.GetCodeRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface INumberVerificationInteractor extends IGlobalInteractor {
    void VerifyOptiongetCodeForMobileNumber(GetCodeRequest getCodeRequest);

    void mobileCheck(CheckRequest checkRequest, int i11, String str, String str2);

    void updateMobileNumber(EditRequest editRequest);

    void verifyMobileNumberWithCode(MobileNumberVerifyRequest mobileNumberVerifyRequest);
}
