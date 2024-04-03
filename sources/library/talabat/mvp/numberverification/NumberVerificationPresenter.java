package library.talabat.mvp.numberverification;

import JsonModels.Request.MobileNumberVerifyRequest;
import JsonModels.Request.MobileVerification.CheckRequest;
import JsonModels.Request.MobileVerification.EditRequest;
import JsonModels.Request.MobileVerification.GetCodeRequest;
import JsonModels.parser.UniversalGson;
import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.QuickOrderInfo;
import datamodels.QuickOrderUserInfo;
import tracking.AppTracker;

@Instrumented
public class NumberVerificationPresenter implements NumberVerificationListener, INumberVerificationPresenter {
    private INumberVerificationInteractor iNumberVerificationInteractor;
    private boolean isFromAptimize;
    private boolean isQuickOrder;
    private NumberVerificationView numberVerificationView;
    private String quickOrderAddressScreen;

    public NumberVerificationPresenter(AppVersionProvider appVersionProvider, NumberVerificationView numberVerificationView2) {
        this.numberVerificationView = numberVerificationView2;
        this.iNumberVerificationInteractor = new NumberVerificationInteractor(appVersionProvider, this);
    }

    private void saveQuickOrderAddressData(QuickOrderInfo quickOrderInfo) {
        String str;
        SharedPreferences.Editor edit = this.numberVerificationView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        String str2 = "" + GlobalDataModel.SelectedAreaId;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) quickOrderInfo);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) quickOrderInfo);
        }
        edit.putString(str2, str);
        edit.apply();
    }

    private void saveQuickOrderUserData(QuickOrderInfo quickOrderInfo, String str) {
        String str2;
        String str3;
        QuickOrderUserInfo quickOrderUserInfo = new QuickOrderUserInfo();
        quickOrderUserInfo.firstName = quickOrderInfo.firstName;
        quickOrderUserInfo.lastName = quickOrderInfo.lastName;
        quickOrderUserInfo.mobileNumber = str;
        quickOrderUserInfo.phoneNumber = quickOrderInfo.address.phoneNumber;
        if (this.isFromAptimize) {
            QuickOrderUserInfo savedQuickOrderUserData = QuickOrderUserInfo.getSavedQuickOrderUserData(this.numberVerificationView.getContext());
            quickOrderUserInfo.email = savedQuickOrderUserData.email;
            quickOrderUserInfo.password = savedQuickOrderUserData.password;
        }
        SharedPreferences.Editor edit = this.numberVerificationView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        String str4 = "" + GlobalDataModel.quickOrderUserId;
        boolean z11 = gson instanceof Gson;
        if (!z11) {
            str2 = gson.toJson((Object) quickOrderUserInfo);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo);
        }
        edit.putString(str4, str2);
        String str5 = "Sales_Froce" + GlobalDataModel.SelectedCountryId;
        if (!z11) {
            str3 = gson.toJson((Object) quickOrderUserInfo);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo);
        }
        edit.putString(str5, str3);
        edit.putInt("lastquickordercountryID", GlobalDataModel.SelectedCountryId);
        edit.apply();
    }

    public void onDataError() {
        this.numberVerificationView.onDataError();
    }

    public void onDestroy() {
        this.numberVerificationView = null;
        INumberVerificationInteractor iNumberVerificationInteractor2 = this.iNumberVerificationInteractor;
        if (iNumberVerificationInteractor2 != null) {
            iNumberVerificationInteractor2.unregister();
        }
        this.iNumberVerificationInteractor = null;
    }

    public void onGetCodeForMobileNumberClicked(String str, int i11, String str2, String str3, String str4) {
        if (!TalabatUtils.isNullOrEmpty(str2) && str2.contains("+")) {
            str2 = str2.replace("+", "").replace(" ", "");
        }
        String str5 = str;
        int i12 = i11;
        this.iNumberVerificationInteractor.VerifyOptiongetCodeForMobileNumber(new GetCodeRequest(str5, i12, GlobalDataModel.SelectedCountryId, str2, str3, str4));
    }

    public void onMobileCheck(String str, String str2, String str3, boolean z11, int i11, String str4, String str5, String str6) {
        if (z11) {
            this.isQuickOrder = z11;
            this.quickOrderAddressScreen = str3;
        }
        if (!TalabatUtils.isNullOrEmpty(str4) && str4.contains("+")) {
            str4 = str4.replace("+", "").replace(" ", "");
        }
        this.iNumberVerificationInteractor.mobileCheck(new CheckRequest(GlobalDataModel.SelectedCountryId, str, str5, str6, str4), i11, str5, str6);
    }

    public void onMobileCheckVerified(boolean z11, String str, int i11, String str2, boolean z12) {
        Object obj;
        if (z11) {
            if (this.isQuickOrder) {
                if (i11 != 2) {
                    AppTracker.onVerificationSuccessful(this.numberVerificationView.getContext(), true);
                }
                Gson gson = UniversalGson.INSTANCE.gson;
                String str3 = this.quickOrderAddressScreen;
                if (str3 != null && !TalabatUtils.isNullOrEmpty(str3)) {
                    String str4 = this.quickOrderAddressScreen;
                    Class cls = QuickOrderInfo.class;
                    if (!(gson instanceof Gson)) {
                        obj = gson.fromJson(str4, cls);
                    } else {
                        obj = GsonInstrumentation.fromJson(gson, str4, cls);
                    }
                    QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
                    quickOrderInfo.address.mobileNumber = str;
                    saveQuickOrderAddressData(quickOrderInfo);
                    saveQuickOrderUserData(quickOrderInfo, str);
                }
            } else {
                AppTracker.onVerificationSuccessful(this.numberVerificationView.getContext(), false);
            }
            this.numberVerificationView.hideMobileNumberVerificationCodePopup(str, i11, true, z12, false);
            return;
        }
        this.numberVerificationView.onMobileVerificationCheckFailed(str2, i11);
    }

    public void onMobileNumberInCorrectGetCode(boolean z11, String str, int i11, String str2, boolean z12) {
        if (i11 == -4) {
            AppTracker.onNumberUpdationFailed(this.numberVerificationView.getContext());
        }
        this.numberVerificationView.onMobileNumberValidationFailedOnGetCode(str2, i11, str);
    }

    public void onMobileNumberVerified(boolean z11, String str, int i11, String str2, boolean z12, int i12) {
        if (z11) {
            AppTracker.onVerificationSuccessful(this.numberVerificationView.getContext(), true);
            this.numberVerificationView.hideMobileNumberVerificationCodePopup(str, i11, false, z12, false);
            return;
        }
        this.numberVerificationView.showMobileNumberVerificationCodePopup(str, i11, i12);
    }

    public void onMobileNumberVerifiedWithCode(boolean z11, String str, int i11, String str2, boolean z12, boolean z13) {
        if (z11) {
            AppTracker.onVerificationSuccessful(this.numberVerificationView.getContext(), false);
            this.numberVerificationView.hideMobileNumberVerificationCodePopup(str, i11, true, z12, z13);
            return;
        }
        AppTracker.onVerificationFailed(this.numberVerificationView.getContext());
        this.numberVerificationView.onMobileVerificationCheckFailed(str2, i11);
    }

    public void onNetworkError() {
        this.numberVerificationView.onNetworkError();
    }

    public void onNumberUpdated() {
        AppTracker.onNumberUpdationSuccessful(this.numberVerificationView.getContext());
    }

    public void onRedirectToLiveChatForMobileVerification(String str, String str2, String str3) {
        this.numberVerificationView.onRedirectToLiveChatForMobileVerification(str, str2, str3);
    }

    public void onServerError(VolleyError volleyError) {
        this.numberVerificationView.onServerError(volleyError);
    }

    public void onValidationErrorHandler(String str, int i11) {
        if (i11 == -4) {
            AppTracker.onNumberUpdationFailed(this.numberVerificationView.getContext());
        }
        this.numberVerificationView.onValidationError(str, i11);
    }

    public void setFromAptimize(boolean z11) {
        this.isFromAptimize = z11;
    }

    public void updateMobielNumbeVerifcationFailed(String str, int i11, String str2, String str3, String str4) {
        Object obj;
        if (this.isQuickOrder) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str5 = this.quickOrderAddressScreen;
            if (str5 != null && !TalabatUtils.isNullOrEmpty(str5)) {
                String str6 = this.quickOrderAddressScreen;
                Class cls = QuickOrderInfo.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str6, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str6, cls);
                }
                QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
                quickOrderInfo.address.mobileNumber = str;
                saveQuickOrderAddressData(quickOrderInfo);
                saveQuickOrderUserData(quickOrderInfo, str);
            }
        } else {
            Customer.getInstance().changeMobileNumberOfSelectedAddress(str);
        }
        this.numberVerificationView.updateMobielNumbeVerifcationFailed(str, i11, str2, true, str3, str4);
    }

    public void updateMobielNumbeVerifcationSucess(String str, int i11, String str2, boolean z11) {
        Object obj;
        if (this.isQuickOrder) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str3 = this.quickOrderAddressScreen;
            if (str3 != null && !TalabatUtils.isNullOrEmpty(str3)) {
                String str4 = this.quickOrderAddressScreen;
                Class cls = QuickOrderInfo.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str4, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str4, cls);
                }
                QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
                quickOrderInfo.address.mobileNumber = str;
                saveQuickOrderAddressData(quickOrderInfo);
                saveQuickOrderUserData(quickOrderInfo, str);
            }
        } else {
            Customer.getInstance().changeMobileNumberOfSelectedAddress(str);
        }
        AppTracker.onVerificationSuccessful(this.numberVerificationView.getContext(), z11);
        this.numberVerificationView.updateMobielNumbeVerifcationSuccess(str, i11, true, z11);
    }

    public void updateMobileNumberClicked(String str, String str2, String str3, String str4, String str5) {
        if (!TalabatUtils.isNullOrEmpty(str3) && str3.contains("+")) {
            str3 = str3.replace("+", "").replace(" ", "");
        }
        String str6 = str;
        String str7 = str2;
        this.iNumberVerificationInteractor.updateMobileNumber(new EditRequest(str6, str7, GlobalDataModel.SelectedCountryId, str4, str5, str3));
    }

    public void verifyMobileNumberWithCodeClicked(String str, String str2, String str3) {
        AppTracker.onVerifyClicked(this.numberVerificationView.getContext());
        if (!TalabatUtils.isNullOrEmpty(str) && str.contains("+")) {
            str = str.replace("+", "").replace(" ", "");
        }
        this.iNumberVerificationInteractor.verifyMobileNumberWithCode(new MobileNumberVerifyRequest(str2, str3, "" + GlobalDataModel.SelectedCountryId, str));
    }
}
