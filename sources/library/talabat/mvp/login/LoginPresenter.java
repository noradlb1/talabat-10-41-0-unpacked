package library.talabat.mvp.login;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.country.Country;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.network.testutils.TalabatIdlingResource;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CustomerInfo;
import datamodels.LoginRM;
import datamodels.RegistrationRM;
import datamodels.RegistrationType;
import javax.inject.Provider;
import library.talabat.mvp.login.LoginView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.TalabatAppBoy;

@Deprecated
public class LoginPresenter implements ILoginPresenter, LoginListener {
    public static final String MOBILE_VALIDATION_ERROR = "-20";
    private final Provider<String> adjustIdProvider;
    private final Provider<String> advertisingIdProvider;
    private final ITalabatFeatureFlag featureFlag;
    private String launchScreenName = "";
    private ILoginInteractor loginInteractor;
    @Nullable
    private LoginType loginType = null;
    private LoginView loginView;
    private final Provider<Integer> selectedCountryIdProvider;
    private int smartLoginType;

    /* renamed from: library.talabat.mvp.login.LoginPresenter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                library.talabat.mvp.login.LoginPresenter$LoginType[] r0 = library.talabat.mvp.login.LoginPresenter.LoginType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType = r0
                library.talabat.mvp.login.LoginPresenter$LoginType r1 = library.talabat.mvp.login.LoginPresenter.LoginType.FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType     // Catch:{ NoSuchFieldError -> 0x001d }
                library.talabat.mvp.login.LoginPresenter$LoginType r1 = library.talabat.mvp.login.LoginPresenter.LoginType.GOOGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType     // Catch:{ NoSuchFieldError -> 0x0028 }
                library.talabat.mvp.login.LoginPresenter$LoginType r1 = library.talabat.mvp.login.LoginPresenter.LoginType.SMART_LOCK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType     // Catch:{ NoSuchFieldError -> 0x0033 }
                library.talabat.mvp.login.LoginPresenter$LoginType r1 = library.talabat.mvp.login.LoginPresenter.LoginType.MOBILE_NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType     // Catch:{ NoSuchFieldError -> 0x003e }
                library.talabat.mvp.login.LoginPresenter$LoginType r1 = library.talabat.mvp.login.LoginPresenter.LoginType.EMAIL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.LoginPresenter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LoginType {
        FACEBOOK,
        GOOGLE,
        SMART_LOCK,
        EMAIL,
        MOBILE_NUMBER
    }

    public LoginPresenter(LoginView loginView2, ILoginInteractor iLoginInteractor, Provider<Integer> provider, ITalabatFeatureFlag iTalabatFeatureFlag, Provider<String> provider2, Provider<String> provider3) {
        this.loginView = loginView2;
        this.loginInteractor = iLoginInteractor;
        this.selectedCountryIdProvider = provider;
        this.featureFlag = iTalabatFeatureFlag;
        this.adjustIdProvider = provider2;
        this.advertisingIdProvider = provider3;
    }

    private void brazeRegistrationCheck() {
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null && customerInfo.isANewCustomer()) {
            brazeUserRegister(customerInfo);
        }
    }

    private void brazeUserRegister(CustomerInfo customerInfo) {
        if (this.loginType != null) {
            TalabatAppBoy.registrationFinishedTalabat(this.loginView.getContext(), customerInfo, this.loginType.toString().toLowerCase());
        }
    }

    @NotNull
    private LoginRM createMobileLoginRequest(String str, @Nullable String str2, @Nullable String str3) {
        LoginRM loginRM = new LoginRM();
        loginRM.UserName = str;
        loginRM.mobileCountryCode = GlobalConstants.IRAQ_COUNTRY_CODE;
        if (str2 != null) {
            loginRM.Password = str2;
        }
        if (str3 != null) {
            loginRM.otp = str3;
        }
        loginRM.UDID = TalabatUtils.getDeviceId(this.loginView.getContext());
        loginRM.GrantType = "password";
        loginRM.registrationType = RegistrationType.MOBILE_NUMBER;
        setAdjustAndAdvertisementIdTo(loginRM);
        return loginRM;
    }

    private boolean enableMobileNumberLogin() {
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_MOBILE_NUMBER_LOGIN, false);
        if (featureFlag2) {
            this.loginView.displayLoginWithMobileOption();
        }
        return featureFlag2;
    }

    private String getLoginFailErrorReason(String str, String str2) {
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            str2.equals("-5");
            if (str2.equals(ILoginInteractor.ERROR_REASON_EMAIL_NOT_REGISTERED)) {
                return "User not available";
            }
            if (str2.equals("-3")) {
                return "Password Incorrect";
            }
            if (str2.equals("-2")) {
                return "Account Locked";
            }
            if (str2.equals("-1")) {
                return "Login Blocked";
            }
            return "Login failed:" + str;
        } else if (!TalabatUtils.isNullOrEmpty(str)) {
            return str;
        } else {
            return "";
        }
    }

    private int getLoginProvider() {
        LoginType loginType2 = this.loginType;
        if (loginType2 == null) {
            return 200;
        }
        int i11 = AnonymousClass1.$SwitchMap$library$talabat$mvp$login$LoginPresenter$LoginType[loginType2.ordinal()];
        if (i11 == 1) {
            return 100;
        }
        if (i11 == 2) {
            return 300;
        }
        if (i11 == 3) {
            return 400;
        }
        if (i11 != 4) {
            return 200;
        }
        return 500;
    }

    private void setAdjustAndAdvertisementIdTo(LoginRM loginRM) {
        loginRM.adjustId = this.adjustIdProvider.get();
        loginRM.advertisingId = this.advertisingIdProvider.get();
    }

    private void showLoginMethods() {
        boolean z11;
        LoginView.LoginMethodPriority loginMethodPriority;
        if (this.selectedCountryIdProvider.get().intValue() == Country.IRAQ.getCountryId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.PRIORITISE_FACEBOOK_LOGIN, false);
        boolean featureFlag3 = this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.DESIGN_SYSTEM_LOGIN_SCREEN_ADOPTION, true);
        if (!z11 || !featureFlag2) {
            loginMethodPriority = LoginView.LoginMethodPriority.GOOGLE;
        } else {
            loginMethodPriority = LoginView.LoginMethodPriority.FACEBOOK;
        }
        if (featureFlag3) {
            this.loginView.showDSLoginMethods(loginMethodPriority);
        } else {
            this.loginView.showLoginMethods(loginMethodPriority);
        }
    }

    private void stopLoadingAndShowAlert(String str) {
        this.loginView.stopLodingPopup();
        this.loginView.showAlertDialog(str);
    }

    private boolean validateMobileNumberLoginAndShowErrors(String str, String str2) {
        boolean z11;
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.loginView.onValidationError(4);
            z11 = false;
        } else {
            z11 = true;
        }
        if (TalabatUtils.isNullOrEmpty(str2)) {
            this.loginView.onValidationError(5);
            return false;
        } else if (str2.length() >= 6) {
            return z11;
        } else {
            this.loginView.onValidationError(6);
            return false;
        }
    }

    private boolean validateMobileNumberOtpLoginAndShowErrors(String str, String str2) {
        boolean z11;
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.loginView.onValidationError(4);
            z11 = false;
        } else {
            z11 = true;
        }
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            return z11;
        }
        this.loginView.onValidationError(7);
        return false;
    }

    public void backButtonPressed() {
        this.loginView.onBackButtonPressed();
    }

    public void faceBookLogin(RegistrationRM registrationRM, int i11) {
        setUpFacebookLogin(registrationRM, i11);
        this.loginInteractor.faceBookLogin(registrationRM);
    }

    public void googleSignin(RegistrationRM registrationRM, int i11) {
        setAdjustAndAdvertisementIdTo(registrationRM);
        this.loginType = LoginType.GOOGLE;
        this.smartLoginType = i11;
        this.loginInteractor.googleLogin(registrationRM);
    }

    public void login(int i11) {
        this.smartLoginType = i11;
        this.loginType = LoginType.EMAIL;
        LoginRM loginRM = new LoginRM();
        loginRM.UserName = this.loginView.getEmail();
        loginRM.Password = this.loginView.getPassword();
        loginRM.UDID = TalabatUtils.getDeviceId(this.loginView.getContext());
        loginRM.GrantType = "password";
        setAdjustAndAdvertisementIdTo(loginRM);
        boolean z11 = false;
        boolean z12 = true;
        if (TalabatUtils.isNullOrEmpty(loginRM.UserName)) {
            this.loginView.onValidationError(1);
            z12 = false;
        }
        if (TalabatUtils.isNullOrEmpty(loginRM.Password)) {
            this.loginView.onValidationError(2);
        } else if (loginRM.Password.length() < 6) {
            this.loginView.onValidationError(102);
        } else {
            z11 = z12;
        }
        if (!z11) {
            return;
        }
        if (!TalabatUtils.isValidEmail(loginRM.UserName)) {
            this.loginView.onValidationError(3);
            return;
        }
        this.loginView.startLodingPopup();
        TalabatIdlingResource.busy("Login");
        this.loginInteractor.getLogin(loginRM);
    }

    public void loginFromSmartLock(LoginRM loginRM, int i11) {
        setAdjustAndAdvertisementIdTo(loginRM);
        this.loginType = LoginType.SMART_LOCK;
        this.smartLoginType = i11;
        this.loginInteractor.getLogin(loginRM);
    }

    public void loginWithEmailClicked() {
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_AAA_EMAIL_LOGIN_IN_OLD_SCREEN, false);
        LogManager.info("ALOV LoginPresenter: loginWithEmailClicked " + featureFlag2);
        if (featureFlag2) {
            this.loginView.navigateToAAALogin();
        } else {
            this.loginView.displayLoginWithEmailOption();
        }
    }

    public void onAccountComplianceFailed() {
        this.loginView.stopLodingPopup();
        this.loginView.showComplianceCannotCreateAccountDialog();
    }

    public void onContinueWithMobileClicked() {
        this.loginView.displayLoginWithMobileScreen(GlobalConstants.IRAQ_COUNTRY_CODE, this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_OTP_FOR_MOBILE_LOGIN, false));
    }

    public void onCustomerInfoRecieved(CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        this.loginView.stopLodingPopup();
        this.loginView.onCustomerInfoRecieved(customerAddressInfoJsonResult);
    }

    public void onDataError() {
        this.loginView.onDataError();
    }

    public void onDestroy() {
        this.loginView = null;
        ILoginInteractor iLoginInteractor = this.loginInteractor;
        if (iLoginInteractor != null) {
            iLoginInteractor.unregister();
        }
        this.loginInteractor = null;
    }

    public void onFailedToRequestOtp(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onGetOtpClicked(String str) {
        this.loginView.startLodingPopup();
        this.loginInteractor.requestOtp(str);
    }

    public void onInvalidCredentialsForMobileLogin(String str) {
        this.loginView.stopLodingPopup();
        this.loginView.showInvalidCredentialsForMobileLoginError(str);
    }

    public void onKurdishNamesBlocked(String str) {
        this.loginView.stopLodingPopup();
        this.loginView.showCouldNotValidateDetailsDialog(str);
    }

    public void onLoginFailed(String str, String str2) {
        this.loginView.stopLodingPopup();
        if (this.loginType != LoginType.MOBILE_NUMBER || !str2.equals(MOBILE_VALIDATION_ERROR)) {
            this.loginView.onLoginFailed(str);
        } else {
            this.loginView.showAlertDialog(str);
        }
        AppTracker.onLogin(this.loginView.getContext(), Customer.getInstance().getCustomerInfo(), getLoginProvider(), false, getLoginFailErrorReason(str, str2), this.launchScreenName);
    }

    public void onLoginFailedBecauseOfTooManyRequests() {
        this.loginView.stopLodingPopup();
        this.loginView.onLoginFailedBecauseOfTooManyRequests();
    }

    public void onLoginFailedWithAccessDeniedCase() {
        this.loginView.stopLodingPopup();
        this.loginView.onLoginFailedWithAccessDeniedMessage();
    }

    public void onLoginFailedWithTokenExchangeFailure() {
        this.loginView.stopLodingPopup();
        this.loginView.onLoginFailedWithTokenExchangeFailure();
    }

    public void onLoginSucess() {
        this.loginView.stopLodingPopup();
        this.loginView.onLoginSucess(this.smartLoginType);
    }

    public void onLoginWithMobileClicked(String str, String str2) {
        if (validateMobileNumberLoginAndShowErrors(str, str2)) {
            this.loginType = LoginType.MOBILE_NUMBER;
            LoginRM createMobileLoginRequest = createMobileLoginRequest(str, str2, (String) null);
            this.loginView.startLodingPopup();
            this.loginInteractor.getLogin(createMobileLoginRequest);
        }
    }

    public void onLoginWithOtpClicked(String str, String str2) {
        this.loginType = LoginType.MOBILE_NUMBER;
        if (validateMobileNumberOtpLoginAndShowErrors(str, str2)) {
            LoginRM createMobileLoginRequest = createMobileLoginRequest(str, (String) null, str2);
            this.loginView.startLodingPopup();
            this.loginInteractor.getLogin(createMobileLoginRequest);
        }
    }

    public void onMaxOtpRequestsReached(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onNetworkError() {
        this.loginView.onNetworkError();
    }

    public void onOtpFieldTextChanged(String str) {
        if (str.length() > 0) {
            this.loginView.enableLoginWithMobileButton();
        } else {
            this.loginView.disableLoginWithMobileButton();
        }
    }

    public void onRequestCompleted() {
        this.loginView.stopLodingPopup();
        TalabatIdlingResource.idle("Login");
        this.loginView.onLoginSucess(this.smartLoginType);
        brazeRegistrationCheck();
        AppTracker.onLogin(this.loginView.getContext(), Customer.getInstance().getCustomerInfo(), getLoginProvider(), true, getLoginFailErrorReason("", ""), this.launchScreenName);
    }

    public void onRequestOtpMobileNumberValidationError(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onRequestOtpSuccess(String str, int i11) {
        this.loginView.stopLodingPopup();
        this.loginView.showSuccessOtpRequestDialog();
        this.loginView.disableLoginWithMobileButton();
        this.loginView.disableGetOtpLinkFor(60);
    }

    public void onRequestOtpUnknownError() {
        this.loginView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.loginView.onServerError(volleyError);
    }

    public void redirectBackToSocialLoginPage() {
        this.loginView.displayLoginWithSocialOption();
    }

    public void setLoginType(LoginType loginType2) {
        this.loginType = loginType2;
    }

    public void setUpFacebookLogin(RegistrationRM registrationRM, int i11) {
        setAdjustAndAdvertisementIdTo(registrationRM);
        this.loginType = LoginType.FACEBOOK;
        this.smartLoginType = i11;
    }

    public void setupViews(String str) {
        this.launchScreenName = str;
        this.loginView.loginSocialViewVisibility();
        showLoginMethods();
        this.loginView.instantiateViews(enableMobileNumberLogin());
    }

    public void showEmailNotRegisteredError(String str, String str2) {
        this.loginView.emailNotRegisteredPopup(str2);
        AppTracker.onLogin(this.loginView.getContext(), Customer.getInstance().getCustomerInfo(), getLoginProvider(), false, getLoginFailErrorReason(str, str2), this.launchScreenName);
    }

    public void showEmailPopup() {
        this.loginView.showEmailPopup();
    }

    private void setAdjustAndAdvertisementIdTo(RegistrationRM registrationRM) {
        registrationRM.adjustId = this.adjustIdProvider.get();
        registrationRM.advertisingId = this.advertisingIdProvider.get();
    }
}
