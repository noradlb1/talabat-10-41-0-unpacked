package com.talabat;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import buisnessmodels.Customer;
import com.designsystem.ds_input_field.DateInputField;
import com.google.android.gms.auth.api.credentials.Credential;
import com.materialedittext.MaterialEditText;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import com.talabat.di.auth.DaggerRegistrationScreenComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.helpers.AdjustIdProvider;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.SmartLockHelper;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.UnableToValidateDetailsDialogFactory;
import com.talabat.home.HomeScreenActivity;
import com.talabat.notifications.brazemigrator.BrazeGuestToLoggedUserMigrator;
import com.talabat.observability.ObservabilityManager;
import com.talabat.registration.IRegistrationPresenter;
import com.talabat.registration.RegistrationInteractor;
import com.talabat.registration.RegistrationPresenter;
import com.talabat.talabatcommon.utils.PrivacyPolicyConsentTextBuilder;
import com.talabat.talabatcommon.views.MobileNumberWithOTPView;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.compliance.blocked.ui.fragment.CannotProceedDialogFragment;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.compliance.verification.di.module.ComplianceVerificationDataModule;
import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl;
import com.talabat.userandlocation.login.ui.LoginOptionsBottomSheet;
import com.talabat.userandlocation.otp.data.impl.RequestOtpRepositoryImpl;
import com.talabat.userandlocation.otp.data.remote.api.OtpApi;
import com.talabat.userandlocation.otp.data.remote.impl.RequestOtpRemoteDataSourceImpl;
import datamodels.CustomerInfo;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.changepassword.PasswordValidator;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import library.talabat.mvp.registration.RegistrationView;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.GoogleAdvertisingIdClientHelper;
import tracking.ScreenNames;
import ue.oc;
import ue.pc;
import ue.qc;
import ue.rc;
import ue.sc;
import ue.tc;
import ue.uc;
import ue.vc;
import ue.wc;
import ue.xc;
import ue.yc;
import ue.zc;

public class RegistrationScreen extends TalabatBase implements RegistrationView {
    public static String EXTRA_REGISTRATION_TYPE = "extraRegistrationType";
    private static int FORGET_PASSWORD = 100;
    private static final String IS_REQUESTING = "is_requesting";
    private static final String IS_RESOLVING = "is_resolving";
    public static final String LOG_SMART = "SmartLock";
    private static final int RC_SAVE = 1;
    public static int REG_PASSWORD_LOCK = 4;
    private static final int REQUEST_CODE_LOGIN_BOTTOM_SHEET = 100;
    private boolean IsHomeRefreshCallBack;
    private String addressString;
    @Nullable
    private String afterLoginDeeplink;
    @Nullable
    private Intent afterLoginIntent;
    @Inject
    public AuthenticationRepository authenticationRepository;
    public BrazeGuestToLoggedUserMigrator brazeGuestToLoggedUserMigrator;
    private Button btn_submit;
    private MaterialEditText confirm_password;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    private MaterialEditText dateOfBirth;
    private DatePickerDialog dobDatePickerDialog;
    @Nullable
    private MobileNumberWithOTPView eTMobileNumber;
    @Nullable
    private MaterialEditText edtOtp;
    private MaterialEditText email;
    private MaterialEditText first_name;
    private String from = "";
    private RadioGroup gender;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54927i;
    private boolean isAddressFromCartOrderFlow;
    private boolean isFromMapFirstFlow;
    private boolean isGrlEnabled;
    private boolean isMapcompulsory;
    private boolean isNineCookiesTrackingEnabled;
    /* access modifiers changed from: private */
    public boolean isOrderFlow = false;
    private boolean isTalabatDeliveryAvailable;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f54928j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public LocationConfigurationRepository f54929k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public ITalabatFeatureFlag f54930l;
    private MaterialEditText last_name;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public SafetyAgent f54931m;
    private CheckBox mConsentCheck;
    private View mConsentTermsAndConditionContainer;
    private TextView mConsentTermsAndPrivacy;
    private Credential mCredential = null;
    private boolean mIsRequesting;
    private boolean mIsResolving;
    private View mNormalTermsAndConditionContainer;
    public SmartLockHelper mSmartLockHelper;
    private MaterialEditText mobile;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public IHelpCenterDeeplinkBuilder f54932n;
    /* access modifiers changed from: private */
    public NestedScrollView nScrollView;
    private CheckBox newsLetter;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public DeepLinkNavigator f54933o;
    @Inject
    public IObservabilityManager observabilityManager;
    private MaterialEditText password;
    /* access modifiers changed from: private */
    public TextView passwordError;
    /* access modifiers changed from: private */
    public TextView passwordHint;
    private TextView privacyTerms;
    @Inject
    public RegistrationObservabilityUseCase registrationObservabilityUseCase;
    /* access modifiers changed from: private */
    public IRegistrationPresenter registrationPresenter;
    private IRegistrationPresenter.RegistrationType registrationType;
    private TextView showHideTxt;
    private Switch sms;
    @Inject
    public TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;
    @Inject
    public TokenRepository tokenRepository;

    /* access modifiers changed from: private */
    public void clearEmailPasswordFld() {
        if (!TalabatUtils.isNullOrEmpty(this.password.getText().toString())) {
            this.password.setText("");
        }
        if (!TalabatUtils.isNullOrEmpty(this.confirm_password.getText().toString())) {
            this.confirm_password.setText("");
        }
    }

    private void clearMobileNumberField() {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.eTMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.setText("");
        }
    }

    private void clearPasswordField() {
        MaterialEditText materialEditText = this.password;
        if (materialEditText != null) {
            materialEditText.setText("");
        }
    }

    private void finishAndGoToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("is_home_refresh_call_back", this.IsHomeRefreshCallBack);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void focusMobileNumberField() {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.eTMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.requestFocus();
        }
    }

    private final void focusOnView() {
        this.nScrollView.post(new Runnable() {
            public void run() {
                RegistrationScreen.this.nScrollView.smoothScrollTo(0, 0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void hideKeyboard() {
        try {
            getWindow().setSoftInputMode(3);
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    private void increaseMarginOfNewsLetterConsent() {
        ViewGroup viewGroup = (ViewGroup) this.newsLetter.getParent();
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            marginLayoutParams.topMargin = (int) getContext().getResources().getDimension(R.dimen._70margin);
            viewGroup.setLayoutParams(marginLayoutParams);
        } catch (ClassCastException e11) {
            LogManager.logException(e11);
        }
    }

    private void increaseSubmitButtonMargin() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.btn_submit.getLayoutParams();
        marginLayoutParams.bottomMargin = (int) getContext().getResources().getDimension(R.dimen.xxxl);
        this.btn_submit.setLayoutParams(marginLayoutParams);
    }

    private boolean isComplianceConsentEnabledCountry() {
        Country selectedCountry = this.f54928j.selectedCountry();
        com.talabat.configuration.location.Country country = null;
        for (com.talabat.configuration.location.Country next : this.f54929k.countries()) {
            if (selectedCountry.getCountryId() == next.getCountry().getCountryId()) {
                country = next;
            }
        }
        if (country == null || !country.isComplianceEnabled()) {
            return false;
        }
        return true;
    }

    private boolean isSmartLockEnabled() {
        return this.f54930l.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_ANDROID_SMART_LOCK, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$onCreate$0() {
        return GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.dobDatePickerDialog.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(SimpleDateFormat simpleDateFormat, DatePicker datePicker, int i11, int i12, int i13) {
        Calendar instance = Calendar.getInstance();
        instance.set(i11, i12, i13);
        this.dateOfBirth.setText(simpleDateFormat.format(instance.getTime()));
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.dateOfBirth.getWindowToken(), 0);
        } catch (Exception e11) {
            trackCrash("RegistrationScreenKeyboardHide", e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        this.email.clearFocus();
        this.registrationPresenter.validateAndRegisterImprovedUX(this.registrationType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$readShowHidePassWordFWF$4(View view) {
        if (this.showHideTxt.getText().toString().equals(getResources().getString(R.string.login_password_show))) {
            this.password.setTransformationMethod((TransformationMethod) null);
            this.showHideTxt.setText(getResources().getString(R.string.login_password_hide));
        } else {
            this.password.setTransformationMethod(new PasswordTransformationMethod());
            this.showHideTxt.setText(getResources().getString(R.string.login_password_show));
        }
        Editable text = this.password.getText();
        if (text != null) {
            this.password.setSelection(text.length());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showAccountAlreadyExistForMobileNumber$10(DialogInterface dialogInterface, int i11) {
        focusMobileNumberField();
        clearMobileNumberField();
        clearPasswordField();
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showAccountAlreadyExistForMobileNumber$8(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        N();
        finish();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAlertDialog$7(DialogInterface dialogInterface, int i11) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showMobileNumberField$6() {
        this.registrationPresenter.onGetOTPClick(this.eTMobileNumber.getMobileNumber());
        return Unit.INSTANCE;
    }

    private void privacyAndTermsSpan(String str, TextView textView) {
        String string = getString(R.string.signup_privacy_policy);
        String string2 = getString(R.string.sign_up_and_to_the);
        String string3 = getString(R.string.terms_of_use);
        SpannableString spannableString = new SpannableString(str + " " + string + " " + string2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(spannableString);
        sb2.append(" ");
        sb2.append(string3);
        SpannableString spannableString2 = new SpannableString(sb2.toString());
        spannableString2.setSpan(Integer.valueOf(getResources().getColor(R.color.colorSecondary)), str.length(), spannableString.length() - string2.length(), 0);
        spannableString2.setSpan(Integer.valueOf(getResources().getColor(R.color.colorSecondary)), spannableString.length(), spannableString2.length(), 0);
        AnonymousClass9 r22 = new ClickableSpan() {
            public void onClick(View view) {
                RegistrationScreen registrationScreen = RegistrationScreen.this;
                registrationScreen.redirectToWebViewScreen(registrationScreen.termsAndConditionsConfigurationRepository.config().privacyPolicyUrl(), RegistrationScreen.this.getResources().getString(R.string.privacy_policy));
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(RegistrationScreen.this.getResources().getColor(R.color.colorSecondary));
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass10 r42 = new ClickableSpan() {
            public void onClick(View view) {
                RegistrationScreen registrationScreen = RegistrationScreen.this;
                registrationScreen.redirectToWebViewScreen(registrationScreen.termsAndConditionsConfigurationRepository.config().termsOfUseUrl(), RegistrationScreen.this.getResources().getString(R.string.about_us_terms_of_use));
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(RegistrationScreen.this.getResources().getColor(R.color.colorSecondary));
            }
        };
        spannableString2.setSpan(r22, str.length(), (spannableString.length() - string2.length()) - 1, 33);
        spannableString2.setSpan(r42, spannableString.length(), spannableString2.length(), 33);
        textView.setText(spannableString2);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void privacyAndTermsSpanWithChangedText(TextView textView) {
        textView.setText(PrivacyPolicyConsentTextBuilder.INSTANCE.createPrivacyPolicyConsentText(getContext(), this.termsAndConditionsConfigurationRepository.config()));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void readShowHidePassWordFWF() {
        this.showHideTxt.setVisibility(0);
        this.showHideTxt.setOnClickListener(new wc(this));
    }

    /* access modifiers changed from: private */
    public void redirectToWebViewScreen(String str, String str2) {
        Intent intent = new Intent(this, TWebViewScreen.class);
        intent.putExtra("url", str);
        intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, str2);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void resetPassword() {
        startActivityForResult(new Intent(this, ForgotPasswordScreen.class), FORGET_PASSWORD);
    }

    private void trackCrash(String str, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", exc.getMessage());
        ObservabilityManager.trackUnExpectedScenario(str, hashMap);
    }

    @VisibleForTesting
    public void N() {
        if (this.f54930l.getFeatureFlag(TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, false)) {
            new LoginOptionsBottomSheet(this, 100).show();
            return;
        }
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra("isOrderFlow", true);
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        intent.putExtra("isFromHomeScreenMap", this.isFromMapFirstFlow);
        startActivity(intent);
    }

    public void changeTitleToCreateYourAccount() {
        ((TextView) findViewById(R.id.txtTitle)).setText(R.string.create_your_account);
    }

    public void destroyPresenter() {
        this.registrationPresenter = null;
    }

    public void disableGetOtpLinkFor(int i11) {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.eTMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.disableGetOtpLinkFor((long) i11);
        }
    }

    public void disableSubmitButton() {
        this.btn_submit.setEnabled(false);
    }

    public void enableSubmitButton() {
        this.btn_submit.setEnabled(true);
    }

    public int getAreaId() {
        return 0;
    }

    public boolean getConsentCheckAvailable() {
        return this.mConsentTermsAndConditionContainer.getVisibility() == 0;
    }

    public boolean getConsentChecked() {
        return this.mConsentCheck.isChecked();
    }

    public Context getContext() {
        return this;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth.getText().toString().trim();
    }

    public String getEmail() {
        return this.email.getText().toString().trim();
    }

    public String getFirstName() {
        return this.first_name.getText().toString().trim();
    }

    public boolean getGender() {
        if ((this.gender.getCheckedRadioButtonId() == R.id.rbMale || this.gender.getCheckedRadioButtonId() == R.id.rbFemale) && this.gender.getCheckedRadioButtonId() != R.id.rbMale) {
            return false;
        }
        return true;
    }

    public String getLastName() {
        return this.last_name.getText().toString().trim();
    }

    public String getMobileNumber() {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.eTMobileNumber;
        return mobileNumberWithOTPView != null ? mobileNumberWithOTPView.getMobileNumber() : "";
    }

    public boolean getNewsLetter() {
        return this.newsLetter.isChecked();
    }

    public String getOtp() {
        Editable editable;
        MaterialEditText materialEditText = this.edtOtp;
        if (materialEditText != null) {
            editable = materialEditText.getText();
        } else {
            editable = null;
        }
        if (editable != null) {
            return editable.toString();
        }
        return "";
    }

    public String getPassWord() {
        return this.password.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.registrationPresenter;
    }

    public String getScreenName() {
        return ScreenNames.REGISTRATION;
    }

    public boolean getSms() {
        return this.sms.isChecked();
    }

    public void hideEmailField() {
        this.email.setVisibility(8);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1) {
            if (i12 != -1) {
                Log.e("SmartLock", "Credential Save Failed");
            }
            finishAndGoToHome();
        } else if (i11 == 100 && i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
            finishAndGoToHome();
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.isOrderFlow) {
            N();
        }
        hideKeyboard();
        finish();
    }

    public void onConsentValidationError() {
        Toast.makeText(this, getResources().getString(R.string.consent_validation_error), 1).show();
    }

    public void onCreate(Bundle bundle) {
        String str;
        IRegistrationPresenter.RegistrationType registrationType2;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        Class cls = AuthenticationCoreLibApi.class;
        DaggerRegistrationScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (SafetyCoreLibApi) apiContainer.getFeature(SafetyCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (AuthenticationCoreLibApi) apiContainer.getFeature(cls), (TokenCoreLibApi) apiContainer.getFeature(TokenCoreLibApi.class), (HelpCenterFeatureApi) apiContainer.getFeature(HelpCenterFeatureApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.registration_screen);
        this.brazeGuestToLoggedUserMigrator = new BrazeGuestToLoggedUserMigrator(getApplication());
        try {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            if (isSmartLockEnabled()) {
                this.mSmartLockHelper = new SmartLockHelper(this, REG_PASSWORD_LOCK);
            }
            if (getIntent().hasExtra("from")) {
                str = getIntent().getStringExtra("from");
            } else {
                str = "";
            }
            this.from = str;
            this.IsHomeRefreshCallBack = getIntent().getBooleanExtra("is_home_refresh_call_back", false);
            AppVersionProvider appVersionProvider = this.f54927i;
            AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
            CustomerAddressesRepository provideCustomerAddressesRepository = addressesDependencyProvider.provideCustomerAddressesRepository(this.f54930l);
            CustomerRepositoryImpl provideCustomerRepository = addressesDependencyProvider.provideCustomerRepository(this);
            LocationConfigurationRepository locationConfigurationRepository = this.f54929k;
            Scheduler io2 = Schedulers.io();
            Scheduler mainThread = AndroidSchedulers.mainThread();
            ITalabatFeatureFlag iTalabatFeatureFlag = this.f54930l;
            RequestOtpRepositoryImpl requestOtpRepositoryImpl = new RequestOtpRepositoryImpl(new RequestOtpRemoteDataSourceImpl((OtpApi) new TalabatAPIBuilder().createApi(OtpApi.class)), new DeviceIdProviderImpl(getContext()));
            VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl = new VerifyLoginPasswordUseCaseImpl(Dispatchers.getIO(), ((AuthenticationCoreLibApi) apiContainer.getFeature(cls)).getAuthenticationRepository(), (RefreshCustomerInformationUseCase) null);
            IObservabilityManager iObservabilityManager = this.observabilityManager;
            RegistrationObservabilityUseCase registrationObservabilityUseCase2 = this.registrationObservabilityUseCase;
            AuthenticationRepository authenticationRepository2 = this.authenticationRepository;
            TokenRepository tokenRepository2 = this.tokenRepository;
            LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            RequestOtpRepositoryImpl requestOtpRepositoryImpl2 = requestOtpRepositoryImpl;
            VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl2 = verifyLoginPasswordUseCaseImpl;
            IObservabilityManager iObservabilityManager2 = iObservabilityManager;
            RegistrationObservabilityUseCase registrationObservabilityUseCase3 = registrationObservabilityUseCase2;
            AuthenticationRepository authenticationRepository3 = authenticationRepository2;
            TokenRepository tokenRepository3 = tokenRepository2;
            this.registrationPresenter = new RegistrationPresenter(this, new RegistrationInteractor(appVersionProvider, provideCustomerAddressesRepository, provideCustomerRepository, locationConfigurationRepository2, io2, mainThread, iTalabatFeatureFlag2, requestOtpRepositoryImpl2, verifyLoginPasswordUseCaseImpl2, iObservabilityManager2, registrationObservabilityUseCase3, authenticationRepository3, tokenRepository3, this.f54930l, this.coroutineDispatchersFactory), this.f54928j, this.f54929k, this.f54930l, new AdjustIdProvider(), new oc(this), new rc(), new PasswordValidator());
            this.btn_submit = (Button) findViewById(R.id.btnSubmit);
            this.email = (MaterialEditText) findViewById(R.id.etRegEmail);
            this.password = (MaterialEditText) findViewById(R.id.etRegPassword);
            this.confirm_password = (MaterialEditText) findViewById(R.id.etRegConfirm);
            this.first_name = (MaterialEditText) findViewById(R.id.etRegFirstName);
            this.last_name = (MaterialEditText) findViewById(R.id.etRegLastName);
            this.mobile = (MaterialEditText) findViewById(R.id.etRegMobile);
            this.dateOfBirth = (MaterialEditText) findViewById(R.id.etdob);
            this.gender = (RadioGroup) findViewById(R.id.radioGroupGender);
            this.sms = (Switch) findViewById(R.id.switchSMS);
            this.newsLetter = (CheckBox) findViewById(R.id.switchNewsLetter);
            this.showHideTxt = (TextView) findViewById(R.id.show_hide_txt);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.date_container);
            this.nScrollView = (NestedScrollView) findViewById(R.id.scrollView);
            this.passwordHint = (TextView) findViewById(R.id.password_hint);
            this.passwordError = (TextView) findViewById(R.id.password_error);
            this.mConsentTermsAndConditionContainer = findViewById(R.id.consend_terms_condition_container);
            this.mNormalTermsAndConditionContainer = findViewById(R.id.normal_terms_and_condition_container);
            this.privacyTerms = (TextView) findViewById(R.id.privacy_policy);
            this.mConsentTermsAndPrivacy = (TextView) findViewById(R.id.consent_terms_privacy);
            this.mConsentCheck = (CheckBox) findViewById(R.id.terms_condition_consent_check);
            this.isOrderFlow = getIntent().getBooleanExtra("isOrderFlow", false);
            this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
            this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
            this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
            this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
            this.isGrlEnabled = getIntent().getBooleanExtra("isGlrEnabledRes", false);
            this.addressString = getIntent().getStringExtra("value");
            String stringExtra = getIntent().getStringExtra(GlobalConstants.ExtraNames.EMAIL_NOT_FOUND_REDIRECT);
            this.isFromMapFirstFlow = getIntent().getBooleanExtra("isFromHomeScreenMap", false);
            this.afterLoginIntent = (Intent) getIntent().getParcelableExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_INTENT);
            this.afterLoginDeeplink = getIntent().getStringExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_DEEPLINK);
            TalabatBugReportManager.INSTANCE.blockViewsRecording(this.password);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateInputField.DefaultDateFormat);
            Calendar instance = Calendar.getInstance();
            this.newsLetter.setChecked(true);
            Serializable serializableExtra = getIntent().getSerializableExtra(EXTRA_REGISTRATION_TYPE);
            if (serializableExtra != null) {
                registrationType2 = (IRegistrationPresenter.RegistrationType) serializableExtra;
            } else {
                registrationType2 = IRegistrationPresenter.RegistrationType.EMAIL;
            }
            this.registrationType = registrationType2;
            this.registrationPresenter.onCreate(registrationType2);
            frameLayout.setOnClickListener(new sc(this));
            this.password.setHint(getResources().getString(R.string.choose_password));
            this.password.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    RegistrationScreen.this.passwordHint.setVisibility(0);
                    RegistrationScreen.this.passwordError.setVisibility(8);
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
            if (this.registrationPresenter.isAdvancedPasswordValidationEnabled()) {
                this.passwordHint.setText(R.string.password_invalid_combined_rule);
            } else {
                this.passwordHint.setText(R.string.create_password_hint);
            }
            this.dobDatePickerDialog = new DatePickerDialog(this, new tc(this, simpleDateFormat), instance.get(1) - 5, instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            instance2.set(instance.get(1) - 5, instance.get(2), instance.get(5));
            Date time = instance2.getTime();
            Calendar instance3 = Calendar.getInstance();
            instance3.set(instance.get(1) - 100, instance.get(2), instance.get(5));
            Date time2 = instance3.getTime();
            long time3 = time.getTime();
            long time4 = time2.getTime();
            DatePicker datePicker = this.dobDatePickerDialog.getDatePicker();
            datePicker.setMaxDate(time3);
            datePicker.setMinDate(time4);
            datePicker.init(instance.get(1) - 5, instance.get(2), instance.get(5), (DatePicker.OnDateChangedListener) null);
            this.btn_submit.setOnClickListener(new uc(this));
            ((ImageButton) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (RegistrationScreen.this.isOrderFlow) {
                        RegistrationScreen.this.N();
                    }
                    RegistrationScreen.this.hideKeyboard();
                    RegistrationScreen.this.finish();
                }
            });
            readShowHidePassWordFWF();
            this.sms.setChecked(true);
            this.first_name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            this.last_name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                this.email.setText(stringExtra);
                this.password.requestFocus();
                this.password.performClick();
                getWindow().setSoftInputMode(4);
                return;
            }
            this.first_name.requestFocus();
        } catch (Exception e11) {
            trackCrash("RegistrationScreenOnCreateCrash", e11);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        MobileNumberWithOTPView mobileNumberWithOTPView = this.eTMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.destroy();
        }
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.password, this.eTMobileNumber);
    }

    public void onError() {
    }

    public void onLocalValidationSuccess() {
        startLodingPopup();
    }

    public void onRegisterFailedWithAccessDeniedMessage() {
        SmartLockHelper smartLockHelper;
        if (!(!isSmartLockEnabled() || this.mCredential == null || (smartLockHelper = this.mSmartLockHelper) == null)) {
            smartLockHelper.mIsResolving = false;
        }
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.login_registration_access_denied_title).setMessage((int) R.string.login_registration_access_denied_message).setPositiveButton((int) R.string.Close, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        RegistrationScreen.this.stopLodingPopup();
                    }
                }).show();
            }
            AppTracker.onRegistrationFailed(this, "normal", getString(R.string.login_registration_access_denied_message), getNewsLetter());
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void onRegistrationCompleted() {
        String str;
        Credential build;
        Toast.makeText(this, R.string.account_created_successfully, 1).show();
        String str2 = Customer.getInstance().getCustomerInfo().firstName + " " + Customer.getInstance().getCustomerInfo().lastName;
        this.brazeGuestToLoggedUserMigrator.migrateGuestToLoggedInUser(String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
        if (isSmartLockEnabled() && !TalabatUtils.isNullOrEmpty(getEmail()) && !TalabatUtils.isNullOrEmpty(getPassWord()) && (build = new Credential.Builder(getEmail()).setName(str2).setPassword(getPassWord()).build()) != null) {
            this.mSmartLockHelper.saveCredential(build);
        }
        if (Customer.getInstance().getCustomerInfo() != null) {
            FunWithFlags.updateCustomerInfo(Customer.getInstance().getCustomerInfo().email, Integer.toString(Customer.getInstance().getCustomerInfo().f13850id));
        }
        if (isComplianceConsentEnabledCountry()) {
            UserStatusDomainModule userStatusDomainModule = UserStatusDomainModule.INSTANCE;
            userStatusDomainModule.provideUserStatusRepository().setStatusIsNotAllowedToCheckFor(userStatusDomainModule.getDurationStatusCanBeCheckedAgain());
        }
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        SafetyAgent safetyAgent = this.f54931m;
        if (customerInfo != null) {
            str = String.valueOf(customerInfo.f13850id);
        } else {
            str = "";
        }
        safetyAgent.sendSafetyInformation(str, SafetyEventType.SIGNUP, new SafetyAppData(new AdjustIdProvider().get()));
        if (this.isOrderFlow) {
            Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "");
            addressFormActivityIntent.putExtra("noAreaChange", true);
            addressFormActivityIntent.putExtra("isOrderFlow", true);
            addressFormActivityIntent.putExtra("map_compulsory", this.isMapcompulsory);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
            addressFormActivityIntent.putExtra("isFromHomeScreenMap", this.isFromMapFirstFlow);
            if (this.isGrlEnabled) {
                addressFormActivityIntent.putExtra(GlobalConstants.INFOR_MAP.IS_TITLE_CORRECTION, true);
                addressFormActivityIntent.putExtra("value", this.addressString);
                addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            }
            addressFormActivityIntent.putExtras(getIntent().getExtras());
            if (this.isMapcompulsory || this.isOrderFlow) {
                addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", true);
                addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.IS_NEW_ADDRESS_FROM_REG, true);
            }
            startActivity(addressFormActivityIntent);
        } else if (this.from.equals(ScreenNames.HELP_CENTER_SCREEN)) {
            this.f54933o.navigateTo(this, this.f54932n.build("", ""), (Function0<Unit>) null);
        } else {
            Intent intent = this.afterLoginIntent;
            if (intent != null) {
                startActivity(intent);
            } else if (this.afterLoginDeeplink != null) {
                this.f54933o.navigateTo(getContext(), this.afterLoginDeeplink, (Function0<Unit>) null);
            } else if (getIntent().getBooleanExtra("isFromProgressiveLogin", false)) {
                setResult(-1);
            } else {
                Intent intent2 = new Intent(this, HomeScreenActivity.class);
                intent2.putExtra("is_home_refresh_call_back", this.IsHomeRefreshCallBack);
                intent2.setFlags(67108864);
                startActivity(intent2);
            }
        }
        finish();
    }

    public void onRegistrationFailed(String str, String str2, String str3) {
        stopLodingPopup();
        int i11 = 0;
        try {
            if (!TalabatUtils.isNullOrEmpty(str3)) {
                i11 = Integer.parseInt(str3);
            }
        } catch (Exception unused) {
        }
        if (i11 != -3) {
            try {
                if (!TalabatUtils.isNullOrEmpty(str2)) {
                    i11 = Integer.parseInt(str2);
                }
            } catch (Exception unused2) {
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            if (i11 == -1) {
                builder.setTitle((int) R.string.account_exist_reg_title);
                builder.setNeutralButton((CharSequence) getString(R.string.account_login).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                            RegistrationScreen.this.clearEmailPasswordFld();
                            RegistrationScreen.this.N();
                            RegistrationScreen.this.finish();
                        }
                    }
                });
                builder.setNegativeButton((CharSequence) getString(R.string.reset_password).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                            RegistrationScreen.this.clearEmailPasswordFld();
                            RegistrationScreen.this.resetPassword();
                            RegistrationScreen.this.finish();
                        }
                    }
                });
            }
            builder.setPositiveButton((CharSequence) getString(R.string.close).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    RegistrationScreen.this.clearEmailPasswordFld();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
            builder.setMessage((CharSequence) str);
            builder.show();
            this.email.requestFocus();
            this.email.hasFocus();
        } else if (!TalabatUtils.isNullOrEmpty(str)) {
            focusOnView();
            this.email.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.email.setError(str);
            this.email.requestFocus();
            Editable text = this.email.getText();
            if (text != null && text.length() > 0) {
                this.email.setSelection(text.length());
            }
        }
    }

    public void onResume() {
        super.onResume();
        pauseBannerForNextScreen();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(IS_RESOLVING, this.mIsResolving);
        bundle.putBoolean(IS_REQUESTING, this.mIsRequesting);
        super.onSaveInstanceState(bundle);
    }

    public void onValidationError(int i11) {
        MobileNumberWithOTPView mobileNumberWithOTPView;
        stopLodingPopup();
        int color = ContextCompat.getColor(this, R.color.edit_text_error);
        if (i11 == 1) {
            this.email.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.email.setError(getString(R.string.required));
        } else if (i11 == 5) {
            this.passwordHint.setVisibility(8);
            this.passwordError.setVisibility(0);
            this.passwordError.setText(getString(R.string.required));
        } else if (i11 == 2) {
            this.first_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.first_name.setError(getString(R.string.required));
        } else if (i11 == 103) {
            this.first_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.first_name.setError(getString(R.string.name_length_error));
            this.first_name.setText("");
            this.first_name.requestFocus();
        } else if (i11 == 3) {
            this.last_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.last_name.setError(getString(R.string.required));
        } else if (i11 == 103) {
            this.last_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.last_name.setError(getString(R.string.name_length_error));
            this.last_name.setText("");
            this.last_name.requestFocus();
        } else if (i11 == 101) {
            this.email.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.email.setError(getString(R.string.enter_email));
            this.email.requestFocus();
        } else if (i11 == 7) {
            this.mobile.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.mobile.setError(getString(R.string.required));
        } else if (i11 == 102) {
            this.passwordHint.setVisibility(8);
            this.passwordError.setVisibility(0);
            this.passwordError.setText(getString(R.string.enter_min_six_characters));
        } else if (i11 == 8) {
            this.dateOfBirth.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.dateOfBirth.setError(getString(R.string.required));
        } else if (i11 == 104 && (mobileNumberWithOTPView = this.eTMobileNumber) != null) {
            mobileNumberWithOTPView.setErrorColor(color);
            this.eTMobileNumber.setError(getString(R.string.required));
        } else if (i11 == 105) {
            this.passwordHint.setVisibility(8);
            this.passwordError.setVisibility(0);
            this.passwordError.setText(getString(R.string.password_invalid_combined_rule));
        }
    }

    public void setEmail(String str) {
        this.email.setText(str);
    }

    public void showAccountAlreadyExistForMobileNumber(String str) {
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((int) R.string.account_exist_reg_title).setNeutralButton((CharSequence) getString(R.string.account_login).toUpperCase(), (DialogInterface.OnClickListener) new xc(this)).setNegativeButton((CharSequence) getString(R.string.reset_password).toUpperCase(), (DialogInterface.OnClickListener) new yc()).setPositiveButton((CharSequence) getString(R.string.close).toUpperCase(), (DialogInterface.OnClickListener) new zc(this)).setMessage((CharSequence) str).show();
    }

    public void showAlertDialog(String str) {
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setMessage((CharSequence) str).setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new vc()).show();
    }

    public void showComplianceCannotCreateAccountDialog() {
        clearEmailPasswordFld();
        String string = getString(R.string.compliance_cannot_create_account_message);
        CannotProceedDialogFragment.newInstance(string).show(getSupportFragmentManager(), CannotProceedDialogFragment.class.getName());
        ComplianceVerificationDataModule.INSTANCE.provideComplianceVerificationTracker(this).trackUserBlocked(string);
    }

    public void showConsentSubtitle() {
        findViewById(R.id.txtSubTitle).setVisibility(0);
    }

    public void showCouldNotValidateDetailsDialog(String str) {
        UnableToValidateDetailsDialogFactory.createDialog(this, str, new qc()).show();
    }

    public void showDateOfBirthField() {
        findViewById(R.id.containerDateOfBirth).setVisibility(0);
        this.dateOfBirth.setHint(R.string.date_of_birth_hint);
    }

    public void showMobileNumberField(int i11, boolean z11) {
        MobileNumberWithOTPView mobileNumberWithOTPView = (MobileNumberWithOTPView) findViewById(R.id.eTMobileNumber);
        this.eTMobileNumber = mobileNumberWithOTPView;
        mobileNumberWithOTPView.setCountryCode(i11);
        this.eTMobileNumber.setVisibility(0);
        this.eTMobileNumber.setGetOTPLinkVisibility(z11);
        TalabatBugReportManager.INSTANCE.blockViewsRecording(this.eTMobileNumber);
        if (z11) {
            this.eTMobileNumber.setOTPClickListener(new pc(this));
        }
    }

    public void showNormalTermsAndCondition() {
        this.mNormalTermsAndConditionContainer.setVisibility(0);
        this.mConsentTermsAndConditionContainer.setVisibility(8);
        privacyAndTermsSpan(getString(R.string.by_creating_account_registration), this.privacyTerms);
        increaseMarginOfNewsLetterConsent();
    }

    public void showOTPField() {
        MaterialEditText materialEditText = (MaterialEditText) findViewById(R.id.edtOTP);
        this.edtOtp = materialEditText;
        materialEditText.setVisibility(0);
        this.edtOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                RegistrationScreen.this.registrationPresenter.onOtpFieldTextChanged(editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
    }

    public void showRegistrationConsentCheck() {
        this.mNormalTermsAndConditionContainer.setVisibility(8);
        this.mConsentTermsAndConditionContainer.setVisibility(0);
        privacyAndTermsSpan(getString(R.string.registration_consent_message), this.mConsentTermsAndPrivacy);
    }

    public void showRegistrationConsentCheckWithChangedText() {
        this.mNormalTermsAndConditionContainer.setVisibility(8);
        this.mConsentTermsAndConditionContainer.setVisibility(0);
        privacyAndTermsSpanWithChangedText(this.mConsentTermsAndPrivacy);
        increaseSubmitButtonMargin();
    }

    public void showSuccessOtpRequestDialog() {
        showAlertDialog(getString(R.string.request_otp_success_message));
    }
}
