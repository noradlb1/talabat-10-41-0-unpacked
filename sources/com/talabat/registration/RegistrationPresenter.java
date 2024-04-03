package com.talabat.registration;

import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.RegistrationStatus;
import com.talabat.registration.IRegistrationPresenter;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragmentKt;
import datamodels.RegistrationRM;
import datamodels.RegistrationType;
import javax.inject.Provider;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.changepassword.Validator;
import library.talabat.mvp.registration.RegistrationView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

public class RegistrationPresenter implements IRegistrationPresenter, IGlobalPresenter, RegistrationListener {
    private final Provider<String> adjustIdProvider;
    private final Provider<String> advertisingIdProvider;
    private ConfigurationLocalRepository configurationLocalRepository;
    private final Provider<Long> elapsedTimeProvider;
    private LocationConfigurationRepository locationConfigRepository;
    private long mLastClickTime = 0;
    private IRegistrationInteractor registrationInteractor;
    @Nullable
    private IRegistrationPresenter.RegistrationType registrationType = null;
    private RegistrationView registrationView;
    private final ITalabatFeatureFlag talabatFeatureFlag;
    private final Validator validator;

    public RegistrationPresenter(RegistrationView registrationView2, RegistrationInteractor registrationInteractor2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository, ITalabatFeatureFlag iTalabatFeatureFlag, Provider<String> provider, Provider<String> provider2, Provider<Long> provider3, Validator validator2) {
        this.registrationView = registrationView2;
        this.registrationInteractor = registrationInteractor2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.adjustIdProvider = provider;
        this.advertisingIdProvider = provider2;
        this.elapsedTimeProvider = provider3;
        this.validator = validator2;
    }

    private void enableMobileNumberRegistrationIfPossible() {
        if (this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_MOBILE_NUMBER_LOGIN, false)) {
            boolean isOTPForMobileNumberEnabled = isOTPForMobileNumberEnabled();
            this.registrationView.showMobileNumberField(GlobalConstants.IRAQ_COUNTRY_CODE, isOTPForMobileNumberEnabled);
            this.registrationView.hideEmailField();
            if (isOTPForMobileNumberEnabled) {
                this.registrationView.showOTPField();
            }
        }
    }

    @NotNull
    private String getLoginType() {
        IRegistrationPresenter.RegistrationType registrationType2 = this.registrationType;
        if (registrationType2 == null) {
            return "N/A";
        }
        if (registrationType2 == IRegistrationPresenter.RegistrationType.EMAIL) {
            return "normal";
        }
        if (registrationType2 == IRegistrationPresenter.RegistrationType.MOBILE_NUMBER) {
            return AppTracker.LOGIN_TYPE_MOBILE_STRING;
        }
        return "N/A";
    }

    private String getRegistrationFailErrorReason(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            return str2;
        }
        if (str.equals("-1")) {
            return "Email already exists";
        }
        if (str.equals("-3")) {
            return "Invalid Email Format";
        }
        return str2;
    }

    private boolean isComplianceConsentEnabledCountry() {
        Country selectedCountry = this.configurationLocalRepository.selectedCountry();
        com.talabat.configuration.location.Country country = null;
        for (com.talabat.configuration.location.Country next : this.locationConfigRepository.countries()) {
            if (selectedCountry.getCountryId() == next.getCountry().getCountryId()) {
                country = next;
            }
        }
        if (country == null || !country.isComplianceEnabled()) {
            return false;
        }
        return true;
    }

    private boolean isOTPForMobileNumberEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_OTP_FOR_MOBILE_REGISTRATION, false);
    }

    private void stopLoadingAndShowAlert(String str) {
        this.registrationView.stopLodingPopup();
        this.registrationView.showAlertDialog(str);
    }

    public void a(IRegistrationPresenter.RegistrationType registrationType2, String str, String str2, String str3, String str4, int i11, String str5, boolean z11, boolean z12, boolean z13, String str6, String str7) {
        this.registrationView.onLocalValidationSuccess();
        RegistrationRM registrationRM = new RegistrationRM();
        registrationRM.FirstName = str3;
        registrationRM.LastName = str4;
        registrationRM.AreaId = i11;
        registrationRM.Password = str5;
        registrationRM.BirthDate = str7;
        registrationRM.Gender = z11;
        registrationRM.subscribedToSMS = z12;
        registrationRM.subscribedToNewsletter = z13;
        registrationRM.UDID = str6;
        if (registrationType2 == IRegistrationPresenter.RegistrationType.MOBILE_NUMBER) {
            registrationRM.registrationType = RegistrationType.MOBILE_NUMBER;
            registrationRM.mobileNumber = str2;
            registrationRM.Username = str2;
            registrationRM.otp = this.registrationView.getOtp();
            registrationRM.mobileCountryCode = GlobalConstants.IRAQ_COUNTRY_CODE;
        } else if (registrationType2 == IRegistrationPresenter.RegistrationType.EMAIL) {
            registrationRM.Email = str;
            registrationRM.Username = str;
            registrationRM.registrationType = RegistrationType.EMAIL;
        }
        registrationRM.adjustId = this.adjustIdProvider.get();
        registrationRM.advertisingId = this.advertisingIdProvider.get();
        if (this.elapsedTimeProvider.get().longValue() - this.mLastClickTime >= PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
            this.mLastClickTime = this.elapsedTimeProvider.get().longValue();
            this.registrationInteractor.registerCustomer(this, this.registrationView.getContext(), registrationRM, 0);
        }
    }

    public boolean isAdvancedPasswordValidationEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_USE_COMPLEX_PASSWORD_RULE, false);
    }

    public void onAccountAlreadyExistForMobileNumber(String str) {
        this.registrationView.stopLodingPopup();
        this.registrationView.showAccountAlreadyExistForMobileNumber(str);
    }

    public void onAccountComplianceFailed() {
        this.registrationView.stopLodingPopup();
        this.registrationView.showComplianceCannotCreateAccountDialog();
    }

    public void onCreate(IRegistrationPresenter.RegistrationType registrationType2) {
        this.registrationType = registrationType2;
        AppTracker.onRegistrationStarted(this.registrationView.getContext(), getLoginType(), this.registrationView.getNewsLetter());
        showRegistrationConsent();
        if (isComplianceConsentEnabledCountry()) {
            this.registrationView.changeTitleToCreateYourAccount();
            this.registrationView.showConsentSubtitle();
            this.registrationView.showDateOfBirthField();
        }
        if (registrationType2 == IRegistrationPresenter.RegistrationType.MOBILE_NUMBER) {
            enableMobileNumberRegistrationIfPossible();
        }
    }

    public void onDataError() {
        this.registrationView.onDataError();
    }

    public void onDestroy() {
        this.registrationView = null;
        IRegistrationInteractor iRegistrationInteractor = this.registrationInteractor;
        if (iRegistrationInteractor != null) {
            iRegistrationInteractor.unregister();
        }
        this.registrationInteractor = null;
    }

    public void onFailedToRequestOtp(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onGetOTPClick(String str) {
        this.registrationView.startLodingPopup();
        this.registrationInteractor.requestOtp(str, this);
    }

    public void onKurdishNamesBlocked(String str) {
        this.registrationView.stopLodingPopup();
        this.registrationView.showCouldNotValidateDetailsDialog(str);
    }

    public void onMaxOtpRequestsReached(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onNetworkError() {
        this.registrationView.onNetworkError();
    }

    public void onOtpFieldTextChanged(String str) {
        if (str.length() > 0) {
            this.registrationView.enableSubmitButton();
        } else {
            this.registrationView.disableSubmitButton();
        }
    }

    public void onRegisterFailedWithAccessDeniedCase() {
        this.registrationView.onRegisterFailedWithAccessDeniedMessage();
    }

    public void onRegistrationCompleted() {
        ObservabilityManager.trackRegistration(RegistrationStatus.Success, "Registration Completed");
        this.registrationView.onRegistrationCompleted();
        AppTracker.onRegistrationSuccess(this.registrationView.getContext(), Customer.getInstance().getCustomerInfo(), getLoginType(), false, this.registrationView.getNewsLetter());
    }

    public void onRegistrationFailed(String str, String str2, String str3) {
        AppTracker.onRegistrationFailed(this.registrationView.getContext(), getLoginType(), getRegistrationFailErrorReason(str3, str), this.registrationView.getNewsLetter());
        this.registrationView.onRegistrationFailed(str, str2, str3);
    }

    public void onRequestOtpMobileNumberValidationError(String str) {
        stopLoadingAndShowAlert(str);
    }

    public void onRequestOtpSuccess(String str, int i11) {
        this.registrationView.stopLodingPopup();
        this.registrationView.disableSubmitButton();
        this.registrationView.showSuccessOtpRequestDialog();
        this.registrationView.disableGetOtpLinkFor(60);
    }

    public void onRequestOtpUnknownError() {
        this.registrationView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.registrationView.onServerError(volleyError);
    }

    public void showEmailPopup() {
    }

    public void showRegistrationConsent() {
        boolean isComplianceConsentEnabledCountry = isComplianceConsentEnabledCountry();
        if (!this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.REGISTRATION_CONSENT_CHECKBOX, false) && !isComplianceConsentEnabledCountry) {
            this.registrationView.showNormalTermsAndCondition();
        } else if (isComplianceConsentEnabledCountry) {
            this.registrationView.showRegistrationConsentCheckWithChangedText();
        } else {
            this.registrationView.showRegistrationConsentCheck();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateAndRegisterImprovedUX(com.talabat.registration.IRegistrationPresenter.RegistrationType r20) {
        /*
            r19 = this;
            r13 = r19
            r1 = r20
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r2 = r0.getEmail()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r3 = r0.getMobileNumber()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r4 = r0.getFirstName()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r5 = r0.getLastName()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            int r6 = r0.getAreaId()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r7 = r0.getPassWord()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            boolean r8 = r0.getGender()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            boolean r9 = r0.getSms()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            boolean r10 = r0.getNewsLetter()
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            android.content.Context r0 = r0.getContext()
            java.lang.String r11 = com.talabat.helpers.TalabatUtils.getDeviceId(r0)
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            java.lang.String r0 = r0.getDateOfBirth()
            boolean r12 = r19.isComplianceConsentEnabledCountry()
            java.lang.String r14 = ""
            r16 = 0
            if (r12 == 0) goto L_0x0092
            boolean r12 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r12 != 0) goto L_0x0085
            java.lang.String r12 = "/"
            java.lang.String[] r0 = r0.split(r12)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r18 = r11
            r17 = 1
            r11 = r0[r17]
            r15.append(r11)
            r15.append(r12)
            r11 = r0[r16]
            r15.append(r11)
            r15.append(r12)
            r11 = 2
            r0 = r0[r11]
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r12 = r0
            goto L_0x0095
        L_0x0085:
            r18 = r11
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 8
            r0.onValidationError(r11)
            r12 = r14
            r0 = r16
            goto L_0x0096
        L_0x0092:
            r18 = r11
            r12 = r14
        L_0x0095:
            r0 = 1
        L_0x0096:
            boolean r11 = r4.equals(r14)
            r15 = 25
            if (r11 == 0) goto L_0x00a7
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 2
            r0.onValidationError(r11)
        L_0x00a4:
            r0 = r16
            goto L_0x00b5
        L_0x00a7:
            int r11 = r4.length()
            if (r11 <= r15) goto L_0x00b5
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 103(0x67, float:1.44E-43)
            r0.onValidationError(r11)
            goto L_0x00a4
        L_0x00b5:
            boolean r11 = r5.equals(r14)
            if (r11 == 0) goto L_0x00c4
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 3
            r0.onValidationError(r11)
        L_0x00c1:
            r0 = r16
            goto L_0x00d2
        L_0x00c4:
            int r11 = r5.length()
            if (r11 <= r15) goto L_0x00d2
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 103(0x67, float:1.44E-43)
            r0.onValidationError(r11)
            goto L_0x00c1
        L_0x00d2:
            com.talabat.registration.IRegistrationPresenter$RegistrationType r11 = com.talabat.registration.IRegistrationPresenter.RegistrationType.EMAIL
            if (r1 != r11) goto L_0x00f3
            boolean r11 = r2.equals(r14)
            if (r11 == 0) goto L_0x00e5
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 1
            r0.onValidationError(r11)
        L_0x00e2:
            r0 = r16
            goto L_0x0105
        L_0x00e5:
            boolean r11 = com.talabat.helpers.TalabatUtils.isValidEmail(r2)
            if (r11 != 0) goto L_0x0105
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 101(0x65, float:1.42E-43)
            r0.onValidationError(r11)
            goto L_0x00e2
        L_0x00f3:
            com.talabat.registration.IRegistrationPresenter$RegistrationType r11 = com.talabat.registration.IRegistrationPresenter.RegistrationType.MOBILE_NUMBER
            if (r1 != r11) goto L_0x0105
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L_0x0105
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 104(0x68, float:1.46E-43)
            r0.onValidationError(r11)
            goto L_0x00e2
        L_0x0105:
            boolean r11 = r19.isAdvancedPasswordValidationEnabled()
            if (r11 == 0) goto L_0x011b
            library.talabat.mvp.changepassword.Validator r11 = r13.validator
            boolean r11 = r11.validate(r7)
            if (r11 != 0) goto L_0x0137
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 105(0x69, float:1.47E-43)
            r0.onValidationError(r11)
            goto L_0x0139
        L_0x011b:
            boolean r11 = r7.equals(r14)
            if (r11 == 0) goto L_0x0128
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 5
            r0.onValidationError(r11)
            goto L_0x0139
        L_0x0128:
            int r11 = r7.length()
            r14 = 6
            if (r11 >= r14) goto L_0x0137
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r11 = 102(0x66, float:1.43E-43)
            r0.onValidationError(r11)
            goto L_0x0139
        L_0x0137:
            r16 = r0
        L_0x0139:
            if (r16 == 0) goto L_0x015a
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            boolean r0 = r0.getConsentCheckAvailable()
            if (r0 == 0) goto L_0x0151
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            boolean r0 = r0.getConsentChecked()
            if (r0 != 0) goto L_0x0151
            library.talabat.mvp.registration.RegistrationView r0 = r13.registrationView
            r0.onConsentValidationError()
            goto L_0x015a
        L_0x0151:
            r0 = r19
            r1 = r20
            r11 = r18
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.registration.RegistrationPresenter.validateAndRegisterImprovedUX(com.talabat.registration.IRegistrationPresenter$RegistrationType):void");
    }
}
