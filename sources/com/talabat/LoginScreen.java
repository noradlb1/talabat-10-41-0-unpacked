package com.talabat;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.adjust.sdk.Constants;
import com.designsystem.ds_branded_button.DSBaseBrandedButton;
import com.designsystem.ds_input_field.DateInputField;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.materialedittext.MaterialEditText;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.data.handler.bnpl.BNPLDashboardHandlerKt;
import com.talabat.core.deeplink.data.handler.login.FlutterLegacyLoginHandler;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.auth.DaggerLoginScreenComponent;
import com.talabat.di.auth.DaggerSocialLoginScreenComponent;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView;
import com.talabat.helpers.AdjustIdProvider;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.SmartLockHelper;
import com.talabat.helpers.TalabatApplication;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.helpers.UnableToValidateDetailsDialogFactory;
import com.talabat.home.HomeScreenActivity;
import com.talabat.login.FacebookLoginErrorView;
import com.talabat.login.FacebookLoginScreenDelegate;
import com.talabat.registration.IRegistrationPresenter;
import com.talabat.talabatcommon.views.MobileNumberWithOTPView;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.userandlocation.ComplianceVerificationActions;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.tracking.event.ul.users.LoginTracker;
import com.talabat.user.LoginDependencyProvider;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.status.domain.repository.IsUserRegisteredRepository;
import com.talabat.userandlocation.compliance.blocked.ui.fragment.CannotProceedDialogFragment;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.compliance.verification.di.module.ComplianceVerificationDataModule;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationResult;
import com.talabat.userandlocation.login.ui.activity.EmailLoginActivity;
import com.talabat.userandlocation.otp.data.impl.RequestOtpRepositoryImpl;
import com.talabat.userandlocation.otp.data.remote.api.OtpApi;
import com.talabat.userandlocation.otp.data.remote.impl.RequestOtpRemoteDataSourceImpl;
import datamodels.LoginRM;
import datamodels.RegistrationRM;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.login.ILoginPresenter;
import library.talabat.mvp.login.LoginInteractor;
import library.talabat.mvp.login.LoginPresenter;
import library.talabat.mvp.login.LoginPresenter2;
import library.talabat.mvp.login.LoginView;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import library.talabat.mvp.login.di.DependencyProvider;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.GoogleAdvertisingIdClientHelper;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import ue.aa;
import ue.ba;
import ue.ca;
import ue.da;
import ue.ea;
import ue.fa;
import ue.ga;
import ue.ha;
import ue.ia;
import ue.ja;
import ue.ka;
import ue.la;
import ue.ma;
import ue.na;
import ue.oa;
import ue.pa;
import ue.qa;
import ue.ra;
import ue.sa;
import ue.ta;
import ue.u9;
import ue.ua;
import ue.v9;
import ue.va;
import ue.w9;
import ue.wa;
import ue.x9;
import ue.xa;
import ue.y9;
import ue.ya;
import ue.z9;

public class LoginScreen extends TalabatBase implements LoginView, GoogleApiClient.OnConnectionFailedListener, FacebookLoginErrorView {
    private static final int FORGET_PASSWORD = 100;
    private static final String IS_REQUESTING = "is_requesting";
    private static final String IS_RESOLVING = "is_resolving";
    private static final int LOGIN_SMART_LOCK = 1;
    public static final int RC_AAA_EMAIL_LOGIN = 7;
    private static final int RC_COMPLIANCE_VERIFICATION_FOR_FACEBOOK = 5;
    private static final int RC_COMPLIANCE_VERIFICATION_FOR_GOOGLE = 6;
    private static final int RC_EXPRESS_CHECKOUT = 8;
    private static final int RC_READ = 3;
    private static final int RC_REDIRECT = 4;
    private static final int RC_SAVE = 1;
    private static final int RC_SIGN_IN = 9001;
    public static final int RESULT_GOTO_ADDRESS_LIST = 2;
    private boolean IsHomeRefreshCallBack;
    private String addressString;
    @Nullable
    private String afterLoginDeeplink;
    @Nullable
    private Intent afterLoginIntent;
    private ImageButton back;
    public boolean backPressed;
    private View btnContinueWithEmail;
    private Button btnLogin;
    @Nullable
    private Button btnLoginWithMobile;
    private TextView btnNewUser;
    private View btnfacebook;
    private CallbackManager callbackManager;
    @Nullable
    private MobileNumberWithOTPView edtMobileNumber;
    @Nullable
    private MaterialEditText edtMobilePassword;
    @Nullable
    private MaterialEditText edtOtp;
    /* access modifiers changed from: private */
    public MaterialEditText etpassword;
    /* access modifiers changed from: private */
    public MaterialEditText etusername;
    private Button expressCheckout;
    /* access modifiers changed from: private */
    @Nullable
    public AccessToken facebookAccessToken;
    /* access modifiers changed from: private */
    @Nullable
    public String facebookProviderId;
    /* access modifiers changed from: private */
    public String from = "";
    @Nullable
    private GoogleSignInAccount googleSignInAccount;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public FacebookLoginScreenDelegate f54287i;
    private boolean isFromMapFirstFlow;
    private boolean isFromQuickRegister;
    private boolean isGrlEnabled;
    private boolean isMapcompulsory;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isOrderFlow = false;
    private boolean isTalabatDeliveryAvailable;
    private IsUserRegisteredRepository isUserRegisteredRepository;
    private Disposable isUserRegisteredRepositoryDisposable = Disposables.empty();
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f54288j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public AuthenticationRepository f54289k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public ConfigurationLocalRepository f54290l;
    /* access modifiers changed from: private */
    public ILoginPresenter loginPresenter;
    private LoginPresenter2 loginPresenter2;
    private View loginWithGoogle;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public LocationConfigurationRepository f54291m;
    private Credential mCredential = null;
    private GoogleSignInClient mGoogleSignInClient;
    private boolean mIsRequesting;
    private boolean mIsResolving;
    private View mLoginWithSocialContainer;
    private View mMainLoginWithEmailContainer;
    private View mMainLoginWithMobileContainer;
    @Nullable
    private SmartLockHelper mSmartLockHelper;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public IObservabilityManager f54292n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatFeatureFlag f54293o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public LoginTracker f54294p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public ProCentralizationStatusWrapper f54295q;
    @IsGmsAvailable
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public boolean f54296r;
    private String redirectNavigation = null;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public CustomerRepository f54297s;
    private boolean showGuestCheckout = false;
    private TextView showHideTxt;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public TokenRepository f54298t;
    private TextView txtforgot;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public CoroutineDispatchersFactory f54299u;
    /* access modifiers changed from: private */
    @Nullable
    public IsUserRegisteredRepository.Status userAccountStatus;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public DeepLinkNavigator f54300v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public SafetyAgent f54301w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public ITalabatExperiment f54302x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public Navigator f54303y;

    /* renamed from: com.talabat.LoginScreen$16  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass16 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f54311a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.talabat.user.status.domain.repository.IsUserRegisteredRepository$Status[] r0 = com.talabat.user.status.domain.repository.IsUserRegisteredRepository.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54311a = r0
                com.talabat.user.status.domain.repository.IsUserRegisteredRepository$Status r1 = com.talabat.user.status.domain.repository.IsUserRegisteredRepository.Status.REGISTERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f54311a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.talabat.user.status.domain.repository.IsUserRegisteredRepository$Status r1 = com.talabat.user.status.domain.repository.IsUserRegisteredRepository.Status.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f54311a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.talabat.user.status.domain.repository.IsUserRegisteredRepository$Status r1 = com.talabat.user.status.domain.repository.IsUserRegisteredRepository.Status.INVALID_KEY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.LoginScreen.AnonymousClass16.<clinit>():void");
        }
    }

    private void backButtonNavigation() {
        if (this.from.equals(ScreenNames.SETTINGS_SCREEN)) {
            loadSettingsScreen();
        } else if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false) || this.isFromQuickRegister) {
            launchHomeScreen();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void checkIfUserIsAlreadyRegistered(@Nullable String str, String str2, IsUserRegisteredRepository.Provider provider, Consumer<IsUserRegisteredRepository.Status> consumer) {
        this.isUserRegisteredRepositoryDisposable = this.isUserRegisteredRepository.isUserRegistered(str, provider, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(consumer, new z9(consumer));
    }

    private void checkSmartLock() {
        SmartLockHelper smartLockHelper;
        if (isSmartLockEnabled() && this.mCredential != null && (smartLockHelper = this.mSmartLockHelper) != null) {
            smartLockHelper.mIsResolving = false;
        }
    }

    private void clearLoginWithMobileFields() {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.edtMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.setText("");
        }
        MaterialEditText materialEditText = this.edtMobilePassword;
        if (materialEditText != null) {
            materialEditText.setText("");
        }
        MaterialEditText materialEditText2 = this.edtOtp;
        if (materialEditText2 != null) {
            materialEditText2.setText("");
        }
    }

    @NotNull
    private RegistrationRM createRegistrationModel(String str, String str2, String str3, String str4, boolean z11, String str5, String str6, @Nullable String str7) {
        RegistrationRM registrationRM = new RegistrationRM();
        registrationRM.Email = str;
        registrationRM.FirstName = str2;
        registrationRM.LastName = str3;
        registrationRM.BirthDate = formatToServerTime(str4);
        registrationRM.ProviderKey = str6;
        registrationRM.subscribedToNewsletter = z11;
        registrationRM.token = str5;
        registrationRM.UDID = TalabatUtils.getDeviceId(this);
        registrationRM.facebookUserId = str7;
        return registrationRM;
    }

    /* access modifiers changed from: private */
    public void doFacebookLogin(@Nullable String str, AccessToken accessToken, String str2, String str3, String str4, String str5, boolean z11) {
        this.loginPresenter.faceBookLogin(createRegistrationModel(str2, str3, str4, str5, z11, accessToken.getToken(), accessToken.getUserId(), str), 1);
    }

    private void doGoogleLogin(boolean z11, String str, String str2, String str3, String str4, String str5, String str6) {
        this.loginPresenter.googleSignin(createRegistrationModel(str, str2, str3, str4, z11, str5, str6, (String) null), 0);
    }

    @NonNull
    private FacebookLoginScreenDelegate facebookLoginScreenDelegate() {
        FacebookLoginScreenDelegate facebookLoginScreenDelegate = this.f54287i;
        if (facebookLoginScreenDelegate != null) {
            return facebookLoginScreenDelegate;
        }
        throw new IllegalStateException("please use facebookLoginScreenDelegate only in the contextof isNewFacebookLogin == true");
    }

    private String formatToServerTime(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new SimpleDateFormat(DateInputField.DefaultDateFormat, Locale.getDefault()).parse(str));
        } catch (Exception e11) {
            LogManager.logException(e11);
            return str;
        }
    }

    private String getLoginType(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "unknown login type" : "mobile" : "smartlock" : "normal" : AccessToken.DEFAULT_GRAPH_DOMAIN : Constants.REFERRER_API_GOOGLE;
    }

    private void googleRevokeAccess() {
        this.mGoogleSignInClient.signOut().addOnCompleteListener((Activity) this, new OnCompleteListener<Void>() {
            public void onComplete(@NonNull Task<Void> task) {
            }
        });
    }

    private void handleExpressCheckoutVisibility() {
        if (this.showGuestCheckout) {
            this.expressCheckout.setVisibility(0);
        } else if (!this.f54293o.getFeatureFlag(OrderingFeatureFlagsKeys.IS_GUEST_USER_CHECKOUT_ENABLED, false)) {
            this.expressCheckout.setVisibility(8);
        } else if (this.from.equals("Cart Screen") || this.isOrderFlow) {
            this.expressCheckout.setVisibility(0);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            if (result != null) {
                if (isComplianceConsentEnabledCountry()) {
                    checkIfUserIsAlreadyRegistered((String) null, result.getIdToken(), IsUserRegisteredRepository.Provider.GOOGLE, new y9(this, result));
                } else {
                    doGoogleLogin(false, result.getEmail(), result.getGivenName(), result.getFamilyName(), "", result.getIdToken(), result.getId());
                }
            }
            startLodingPopup();
        } catch (ApiException e11) {
            Log.w("eeror", "signInResult:failed code=" + e11.getStatusCode());
            if (e11.getStatusCode() > 0 && e11.getStatusCode() == 8) {
                this.loginWithGoogle.performClick();
            }
        }
    }

    private void handleUserVerificationResultForFacebook(Intent intent) {
        if (this.facebookAccessToken == null) {
            LogManager.error((Throwable) null, "Cached AccessToken for Facebook was null!");
            return;
        }
        ComplianceUserVerificationResult complianceUserVerificationResult = (ComplianceUserVerificationResult) intent.getParcelableExtra("result");
        if (complianceUserVerificationResult != null) {
            doFacebookLogin(this.facebookProviderId, this.facebookAccessToken, complianceUserVerificationResult.getEmail(), complianceUserVerificationResult.getFirstName(), complianceUserVerificationResult.getLastName(), complianceUserVerificationResult.getDateOfBirth(), complianceUserVerificationResult.isPromotionsConsentChecked());
        } else {
            LogManager.error((Throwable) null, "User verification for compliance didn't return any data");
        }
        this.facebookAccessToken = null;
    }

    private void handleUserVerificationResultForGoogle(Intent intent) {
        if (this.googleSignInAccount == null) {
            LogManager.error((Throwable) null, "Cached GoogleSignInAccount was null!");
            return;
        }
        ComplianceUserVerificationResult complianceUserVerificationResult = (ComplianceUserVerificationResult) intent.getParcelableExtra("result");
        if (complianceUserVerificationResult != null) {
            doGoogleLogin(complianceUserVerificationResult.isPromotionsConsentChecked(), complianceUserVerificationResult.getEmail(), complianceUserVerificationResult.getFirstName(), complianceUserVerificationResult.getLastName(), complianceUserVerificationResult.getDateOfBirth(), this.googleSignInAccount.getIdToken(), this.googleSignInAccount.getId());
        } else {
            LogManager.error((Throwable) null, "User verification for compliance didn't return any data");
        }
        this.googleSignInAccount = null;
    }

    public static void hideKeyboardFrom(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void initializeOtpLoginViews(View view) {
        MaterialEditText materialEditText = (MaterialEditText) view.findViewById(R.id.edtOTP);
        this.edtOtp = materialEditText;
        materialEditText.setVisibility(0);
        this.edtOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                LoginScreen.this.loginPresenter.onOtpFieldTextChanged(editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        view.findViewById(R.id.mobilePasswordContainer).setVisibility(8);
        this.edtMobileNumber.setOTPClickListener(new ra(this));
    }

    private void initiateGoogleSignin() {
        this.mGoogleSignInClient = GoogleSignIn.getClient((Activity) this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(getResources().getString(R.string.google_server_id)).build());
    }

    /* access modifiers changed from: private */
    public boolean isComplianceConsentEnabledCountry() {
        Country selectedCountry = this.f54290l.selectedCountry();
        com.talabat.configuration.location.Country country = null;
        for (com.talabat.configuration.location.Country next : this.f54291m.countries()) {
            if (selectedCountry.getCountryId() == next.getCountry().getCountryId()) {
                country = next;
            }
        }
        if (country == null || !country.isComplianceEnabled()) {
            return false;
        }
        return true;
    }

    private boolean isFlutterGuestAddressFormScreenEnabled() {
        boolean equals = "redirect_back".equals(this.redirectNavigation);
        String stringVariant = this.f54302x.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_GUEST_ADDRESS_FORM_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF);
        if (!equals || !stringVariant.equals("Variation1")) {
            return false;
        }
        return true;
    }

    private boolean isFlutterLoginEmailEnabled() {
        return this.f54302x.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_LOGIN_EMAIL_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1");
    }

    private boolean isFlutterLoginMobileEnabled() {
        return this.f54302x.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_LOGIN_MOBILE_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1");
    }

    private boolean isLoginWithEmailShown() {
        View view = this.mMainLoginWithEmailContainer;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean isLoginWithMobileNumberShown() {
        return this.mMainLoginWithMobileContainer.getVisibility() == 0;
    }

    private boolean isNewFacebookLogin() {
        return this.f54293o.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_FACEBOOK_LOGIN_IN_OLD_SCREEN, false);
    }

    private boolean isSmartLockEnabled() {
        return this.f54293o.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_ANDROID_SMART_LOCK, false) && this.f54296r;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkIfUserIsAlreadyRegistered$9(Consumer consumer, Throwable th2) throws Exception {
        LogManager.logException(th2);
        consumer.accept(IsUserRegisteredRepository.Status.NOT_FOUND);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayLoginWithMobileOption$27(View view) {
        this.loginPresenter.onContinueWithMobileClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayLoginWithMobileScreen$19() {
        this.edtMobileNumber.requestLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayLoginWithMobileScreen$20(boolean z11, View view) {
        if (z11) {
            onLoginWithOtpClicked();
        } else {
            onLoginWithMobileClicked();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayLoginWithMobileScreen$22(View view) {
        regScreenReDirection(false, IRegistrationPresenter.RegistrationType.MOBILE_NUMBER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayLoginWithMobileScreen$23(View view) {
        resetPassword(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$facebookEmailNotAvailablePopup$11(DialogInterface dialogInterface, int i11) {
        stopLodingPopup();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initializeOtpLoginViews$24() {
        this.loginPresenter.onGetOtpClicked(this.edtMobileNumber.getMobileNumber());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$onCreate$1() {
        return GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        LogManager.info("ALOV LoginScreen: OnClickListenerForDsBrandedButton");
        this.loginPresenter.loginWithEmailClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3() {
        trackLoginClick(1);
        startLodingPopup();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(LoginInteractor loginInteractor, View view) {
        this.f54287i.onSetUpFacebookLoginButtons(this, this.loginPresenter, loginInteractor, LifecycleOwnerKt.getLifecycleScope(this), new w9(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        signinWithGoogle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (this.showHideTxt.getText().toString().equals(getResources().getString(R.string.login_password_show))) {
            this.etpassword.setTransformationMethod((TransformationMethod) null);
            this.showHideTxt.setText(getResources().getString(R.string.login_password_hide));
        } else {
            this.etpassword.setTransformationMethod(new PasswordTransformationMethod());
            this.showHideTxt.setText(getResources().getString(R.string.login_password_show));
        }
        MaterialEditText materialEditText = this.etpassword;
        materialEditText.setSelection(materialEditText.getText().length());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginFailedBecauseOfTooManyRequests$25(DialogInterface dialogInterface, int i11) {
        stopLodingPopup();
        if (!TextUtils.isEmpty(this.etpassword.getText())) {
            this.etpassword.setText("");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpFacebookLoginButtons$7(LoginButton loginButton, View view) {
        trackLoginClick(1);
        ((TalabatApplication) getApplication()).pauseBannerForNextScreen();
        loginButton.performClick();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAlertDialog$30(DialogInterface dialogInterface, int i11) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showInvalidCredentialsForMobileLoginError$28(DialogInterface dialogInterface, int i11) {
        regScreenReDirection(false, IRegistrationPresenter.RegistrationType.MOBILE_NUMBER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showInvalidCredentialsForMobileLoginError$29(DialogInterface dialogInterface, int i11) {
        clearLoginWithMobileFields();
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("is_home_refresh_call_back", this.IsHomeRefreshCallBack);
        startActivity(intent);
        finish();
    }

    private void loadSettingsScreen() {
        Intent intent = new Intent(this, SettingsScreen.class);
        intent.putExtra(TalabatBase.EXTRA_DISABLE_SIDEMENU, getIntent().getBooleanExtra(TalabatBase.EXTRA_DISABLE_SIDEMENU, false));
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void loginFailedPopup(String str) {
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.incorrect_email_password_title).setMessage((CharSequence) str).setNegativeButton((int) R.string.reset_password, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        LoginScreen.this.stopLodingPopup();
                        LoginScreen.this.resetPassword(false);
                    }
                }).setPositiveButton((int) R.string.incorrect_try_again, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        LoginScreen.this.stopLodingPopup();
                        if (LoginScreen.this.etpassword.getText().toString().length() > 0) {
                            LoginScreen.this.etpassword.setText("");
                        }
                    }
                }).show();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    private void moveToWalletTopupCardListScreen() {
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.Wallet.walletTopUpCardList"));
        finish();
    }

    private void navigateToDeeplink(String str) {
        this.f54300v.navigateTo(getContext(), str, (Function0<Unit>) null);
        finish();
    }

    private void navigateToFlutterRegistrationScreen(IRegistrationPresenter.RegistrationType registrationType) {
        if (registrationType == IRegistrationPresenter.RegistrationType.MOBILE_NUMBER) {
            this.f54303y.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData("authentication/registration/mobileNumber")), new ma());
        } else {
            this.f54303y.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData("authentication/registration/email")), new na());
        }
    }

    /* access modifiers changed from: private */
    public void navigateToGuestAddressFormScreen() {
        if (isFlutterGuestAddressFormScreenEnabled()) {
            SharedPreferencesManager.getInstance().setGuestAddressButtonTappedForFlutter(true);
            getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit().remove(GlobalConstants.PrefsConstants.FALLBACK_GUEST_ADDRESS).commit();
            finish();
            return;
        }
        Intent intent = new Intent(this, QuickOrderScreen.class);
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        intent.putExtra("isFromHomeScreenMap", this.isFromMapFirstFlow);
        intent.putExtra("redirect_navigation", this.redirectNavigation);
        startActivityForResult(intent, 8);
    }

    private void navigateToNativeRegistrationScreen(boolean z11, IRegistrationPresenter.RegistrationType registrationType) {
        Intent intent = new Intent(this, RegistrationScreen.class);
        intent.putExtra(RegistrationScreen.EXTRA_REGISTRATION_TYPE, registrationType);
        if (this.from.equals("Cart Screen")) {
            intent.putExtra("isOrderFlow", true);
            intent.putExtra("map_compulsory", this.isMapcompulsory);
            intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            intent.putExtra("is_home_refresh_call_back", this.IsHomeRefreshCallBack);
            if (this.isGrlEnabled) {
                intent.putExtra("value", this.addressString);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            }
            intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        }
        if (this.from.equals(ScreenNames.HELP_CENTER_SCREEN)) {
            intent.putExtra("from", ScreenNames.HELP_CENTER_SCREEN);
        }
        intent.putExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_INTENT, this.afterLoginIntent);
        intent.putExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_DEEPLINK, this.afterLoginDeeplink);
        if (z11) {
            intent.putExtra(GlobalConstants.ExtraNames.EMAIL_NOT_FOUND_REDIRECT, this.etusername.getText().toString());
            if (this.from.equals("Cart Screen")) {
                finish();
            }
            startActivity(intent);
            return;
        }
        startActivity(intent);
        finish();
    }

    private void navigateToPayLaterScreen() {
        this.f54300v.navigateTo(getContext(), BNPLDashboardHandlerKt.BNPL_PAYLATER_DEEPLINK, (Function0<Unit>) null);
        finish();
    }

    private void onLoginWithMobileClicked() {
        String str;
        String mobileNumber = this.edtMobileNumber.getMobileNumber();
        Editable text = this.edtMobilePassword.getText();
        if (text != null) {
            str = text.toString();
        } else {
            str = "";
        }
        this.loginPresenter.onLoginWithMobileClicked(mobileNumber, str);
    }

    private void onLoginWithOtpClicked() {
        Editable editable;
        String str;
        String mobileNumber = this.edtMobileNumber.getMobileNumber();
        MaterialEditText materialEditText = this.edtOtp;
        if (materialEditText != null) {
            editable = materialEditText.getText();
        } else {
            editable = null;
        }
        if (editable != null) {
            str = editable.toString();
        } else {
            str = "";
        }
        this.loginPresenter.onLoginWithOtpClicked(mobileNumber, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onMobilePasswordShowHideClick */
    public void lambda$displayLoginWithMobileScreen$21(TextView textView) {
        if (this.edtMobilePassword != null) {
            if (textView.getText().toString().equals(getResources().getString(R.string.login_password_show))) {
                this.edtMobilePassword.setTransformationMethod((TransformationMethod) null);
                textView.setText(getResources().getString(R.string.login_password_hide));
            } else {
                this.edtMobilePassword.setTransformationMethod(new PasswordTransformationMethod());
                textView.setText(getResources().getString(R.string.login_password_show));
            }
            MaterialEditText materialEditText = this.edtMobilePassword;
            materialEditText.setSelection(materialEditText.getText().length());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onUserStatusCheckForGoogle */
    public void lambda$handleSignInResult$13(GoogleSignInAccount googleSignInAccount2, IsUserRegisteredRepository.Status status) {
        int i11 = AnonymousClass16.f54311a[status.ordinal()];
        if (i11 == 1) {
            doGoogleLogin(false, googleSignInAccount2.getEmail(), googleSignInAccount2.getGivenName(), googleSignInAccount2.getFamilyName(), "", googleSignInAccount2.getIdToken(), googleSignInAccount2.getId());
        } else if (i11 == 2 || i11 == 3) {
            this.googleSignInAccount = googleSignInAccount2;
            verifyGoogleUserDetailsForCompliance(googleSignInAccount2.getEmail(), googleSignInAccount2.getGivenName(), googleSignInAccount2.getFamilyName());
        }
        this.userAccountStatus = status;
    }

    private void processRetrievedCredential(Credential credential, String str) {
        this.mCredential = credential;
        if (TalabatUtils.isNullOrEmpty(str)) {
            LoginRM loginRM = new LoginRM();
            loginRM.UserName = credential.getId();
            loginRM.Password = credential.getPassword();
            loginRM.GrantType = "password";
            loginRM.UDID = TalabatUtils.getDeviceId(this);
            if (!TalabatUtils.isNullOrEmpty(credential.getId())) {
                this.etusername.setText(credential.getId());
            }
            if (!TalabatUtils.isNullOrEmpty(credential.getPassword())) {
                this.etpassword.setText(credential.getPassword());
            }
            startLodingPopup();
            this.loginPresenter.loginFromSmartLock(loginRM, 3);
        }
    }

    /* access modifiers changed from: private */
    public void regScreenReDirection(boolean z11, IRegistrationPresenter.RegistrationType registrationType) {
        if (this.f54302x.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_REGISTRATION_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1")) {
            navigateToFlutterRegistrationScreen(registrationType);
        } else {
            navigateToNativeRegistrationScreen(z11, registrationType);
        }
    }

    private void removeContinueWithEmailBottomMargin() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.btnContinueWithEmail.getLayoutParams();
        marginLayoutParams.bottomMargin = 0;
        this.btnContinueWithEmail.setLayoutParams(marginLayoutParams);
    }

    private void resetLoginWithEmailInputAfterBackNavigation() {
        MaterialEditText materialEditText = this.etusername;
        if (materialEditText != null) {
            materialEditText.setText("");
        }
        MaterialEditText materialEditText2 = this.etpassword;
        if (materialEditText2 != null) {
            materialEditText2.setText("");
        }
    }

    /* access modifiers changed from: private */
    public void resetPassword(boolean z11) {
        FlutterScreen.FlutterScreenData flutterScreenData;
        if (this.f54302x.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_FORGOT_PASSWORD_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1")) {
            if (z11) {
                flutterScreenData = new FlutterScreen.FlutterScreenData("authentication/forgot_password/mobileNumber");
            } else {
                flutterScreenData = new FlutterScreen.FlutterScreenData("authentication/forgot_password/email");
            }
            this.f54303y.navigateTo(this, new FlutterScreen(flutterScreenData), new aa());
            return;
        }
        Intent intent = new Intent(this, ForgotPasswordScreen.class);
        intent.putExtra(ForgotPasswordScreen.EXTRA_FOR_MOBILE_NUMBER_LOGIN, z11);
        startActivityForResult(intent, 100);
    }

    private void saveSmartLockCredentials(int i11) {
        Credential build;
        if (i11 == 2) {
            String str = Customer.getInstance().getCustomerInfo().firstName + " " + Customer.getInstance().getCustomerInfo().lastName;
            if (!TalabatUtils.isNullOrEmpty(getEmail()) && !TalabatUtils.isNullOrEmpty(getPassword()) && (build = new Credential.Builder(getEmail()).setPassword(getPassword()).setName(str).build()) != null) {
                saveCredentials(build);
                return;
            }
            return;
        }
        screenRedirection();
    }

    private void screenRedirection() {
        Intent intent = this.afterLoginIntent;
        if (intent != null) {
            startActivity(intent);
            finish();
            return;
        }
        String str = this.afterLoginDeeplink;
        if (str != null) {
            navigateToDeeplink(str);
        } else if (this.from.equals("Cart Screen")) {
            this.loginPresenter2.onLoggedInFromCartScreen();
        } else if (this.from.equals(ScreenNames.ORDERS_LIST) || this.from.equals(ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT) || this.from.equals("Wallet Dashboard screen") || this.from.equals(ScreenNames.HELP_CENTER_SCREEN) || this.from.equals(ScreenNames.OFFERING_COLLECTION_SCREEN)) {
            setResult(-1);
            finish();
        } else if (this.from.equals("talabat.action.Wallet.walletTopUpCardList")) {
            setResult(EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode());
            moveToWalletTopupCardListScreen();
        } else if (this.from.equals("BNPL Dashboard Screen")) {
            navigateToPayLaterScreen();
        } else {
            this.loginPresenter2.onRedirectToHomeScreen();
        }
    }

    private void setDoNotCheckForComplianceInCheckout() {
        if (isComplianceConsentEnabledCountry()) {
            IsUserRegisteredRepository.Status status = this.userAccountStatus;
            if (status == IsUserRegisteredRepository.Status.NOT_FOUND || status == IsUserRegisteredRepository.Status.INVALID_KEY) {
                UserStatusDomainModule userStatusDomainModule = UserStatusDomainModule.INSTANCE;
                userStatusDomainModule.provideUserStatusRepository().setStatusIsNotAllowedToCheckFor(userStatusDomainModule.getDurationStatusCanBeCheckedAgain());
            }
        }
    }

    private void setLoginButtonsStub(int i11) {
        ViewStub viewStub = (ViewStub) findViewById(R.id.login_buttons_stub);
        viewStub.setLayoutResource(i11);
        viewStub.inflate();
    }

    private void setOnClickListenerForDsBrandedButton(View view, View.OnClickListener onClickListener) {
        if (view instanceof DSBaseBrandedButton) {
            LogManager.info("ALOV LoginScreen: setOnClickListenerForDsBrandedButton DS btn");
            ((DSBaseBrandedButton) view).setOnTap(new qa(onClickListener, view));
            return;
        }
        LogManager.info("ALOV LoginScreen: setOnClickListenerForDsBrandedButton NORMAL btn");
        view.setOnClickListener(onClickListener);
    }

    private void setUpFacebookLoginButtons() {
        LoginButton loginButton = (LoginButton) findViewById(R.id.authButton);
        setOnClickListenerForDsBrandedButton(this.btnfacebook, new sa(this, loginButton));
        ArrayList arrayList = new ArrayList();
        arrayList.add("public_profile");
        arrayList.add("email");
        loginButton.setReadPermissions((List<String>) arrayList);
        loginButton.registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() {
            public void onCancel() {
            }

            public void onError(FacebookException facebookException) {
                facebookException.toString();
            }

            public void onSuccess(LoginResult loginResult) {
                final AccessToken accessToken = loginResult.getAccessToken();
                GraphRequest newMeRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void lambda$onCompleted$0(String str, AccessToken accessToken, String str2, String str3, String str4, String str5, IsUserRegisteredRepository.Status status) throws Exception {
                        String str6;
                        String str7;
                        String str8;
                        int i11 = AnonymousClass16.f54311a[status.ordinal()];
                        String str9 = "";
                        if (i11 == 1) {
                            String str10 = str;
                            AccessToken accessToken2 = accessToken;
                            String str11 = str2;
                            LoginScreen loginScreen = LoginScreen.this;
                            if (!TalabatUtils.isNullOrEmpty(str3)) {
                                str6 = str3;
                            } else {
                                str6 = str4;
                            }
                            if (!TalabatUtils.isNullOrEmpty(str5)) {
                                str7 = str5;
                            } else {
                                str7 = str9;
                            }
                            loginScreen.doFacebookLogin(str, accessToken, str2, str6, str7, "", false);
                        } else if (i11 == 2 || i11 == 3) {
                            AccessToken accessToken3 = accessToken;
                            LoginScreen.this.facebookAccessToken = accessToken;
                            String str12 = str;
                            LoginScreen.this.facebookProviderId = str;
                            LoginScreen loginScreen2 = LoginScreen.this;
                            if (!TalabatUtils.isNullOrEmpty(str3)) {
                                str8 = str3;
                            } else {
                                str8 = str4;
                            }
                            if (!TalabatUtils.isNullOrEmpty(str5)) {
                                String str13 = str2;
                                str9 = str5;
                            } else {
                                String str14 = str2;
                            }
                            loginScreen2.verifyFacebookUserDetailsForCompliance(str2, str8, str9);
                        }
                        LoginScreen.this.userAccountStatus = status;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078 A[ADDED_TO_REGION] */
                    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onCompleted(org.json.JSONObject r19, com.facebook.GraphResponse r20) {
                        /*
                            r18 = this;
                            r9 = r18
                            r0 = r19
                            java.lang.String r1 = "id"
                            java.lang.String r2 = "last_name"
                            java.lang.String r3 = "first_name"
                            java.lang.String r4 = "name"
                            java.lang.String r5 = "email"
                            r6 = 0
                            boolean r7 = r0.has(r5)     // Catch:{ Exception -> 0x005d }
                            if (r7 == 0) goto L_0x001a
                            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x005d }
                            goto L_0x001b
                        L_0x001a:
                            r5 = r6
                        L_0x001b:
                            boolean r7 = r0.has(r4)     // Catch:{ Exception -> 0x0058 }
                            java.lang.String r8 = ""
                            if (r7 == 0) goto L_0x0028
                            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x0058 }
                            goto L_0x0029
                        L_0x0028:
                            r4 = r8
                        L_0x0029:
                            boolean r7 = r0.has(r3)     // Catch:{ Exception -> 0x0054 }
                            if (r7 == 0) goto L_0x0034
                            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0054 }
                            goto L_0x0035
                        L_0x0034:
                            r3 = r8
                        L_0x0035:
                            boolean r7 = r0.has(r2)     // Catch:{ Exception -> 0x0051 }
                            if (r7 == 0) goto L_0x0040
                            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0051 }
                            goto L_0x0041
                        L_0x0040:
                            r2 = r8
                        L_0x0041:
                            boolean r7 = r0.has(r1)     // Catch:{ Exception -> 0x004f }
                            if (r7 == 0) goto L_0x004d
                            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x004f }
                            r6 = r0
                            goto L_0x0065
                        L_0x004d:
                            r6 = r8
                            goto L_0x0065
                        L_0x004f:
                            r0 = move-exception
                            goto L_0x0062
                        L_0x0051:
                            r0 = move-exception
                            r2 = r6
                            goto L_0x0062
                        L_0x0054:
                            r0 = move-exception
                            r2 = r6
                            r3 = r2
                            goto L_0x0062
                        L_0x0058:
                            r0 = move-exception
                            r2 = r6
                            r3 = r2
                            r4 = r3
                            goto L_0x0062
                        L_0x005d:
                            r0 = move-exception
                            r2 = r6
                            r3 = r2
                            r4 = r3
                            r5 = r4
                        L_0x0062:
                            com.talabat.talabatcore.logger.LogManager.logException(r0)
                        L_0x0065:
                            r8 = r2
                            r14 = r4
                            r13 = r5
                            r0 = r6
                            r6 = r3
                            com.talabat.LoginScreen$7 r1 = com.talabat.LoginScreen.AnonymousClass7.this
                            com.talabat.LoginScreen r1 = com.talabat.LoginScreen.this
                            boolean r1 = r1.isComplianceConsentEnabledCountry()
                            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r13)
                            if (r2 == 0) goto L_0x0089
                            if (r1 != 0) goto L_0x0089
                            com.talabat.LoginScreen$7 r0 = com.talabat.LoginScreen.AnonymousClass7.this
                            com.talabat.LoginScreen r0 = com.talabat.LoginScreen.this
                            r0.facebookEmailNotAvailablePopup()
                            com.facebook.login.LoginManager r0 = com.facebook.login.LoginManager.getInstance()
                            r0.logOut()
                            return
                        L_0x0089:
                            if (r1 == 0) goto L_0x00a8
                            com.talabat.LoginScreen$7 r1 = com.talabat.LoginScreen.AnonymousClass7.this
                            com.talabat.LoginScreen r10 = com.talabat.LoginScreen.this
                            com.facebook.AccessToken r1 = r4
                            java.lang.String r11 = r1.getToken()
                            com.talabat.user.status.domain.repository.IsUserRegisteredRepository$Provider r12 = com.talabat.user.status.domain.repository.IsUserRegisteredRepository.Provider.FACEBOOK
                            com.facebook.AccessToken r4 = r4
                            com.talabat.p r15 = new com.talabat.p
                            r1 = r15
                            r2 = r18
                            r3 = r0
                            r5 = r13
                            r7 = r14
                            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                            r10.checkIfUserIsAlreadyRegistered(r0, r11, r12, r15)
                            goto L_0x00b8
                        L_0x00a8:
                            com.talabat.LoginScreen$7 r0 = com.talabat.LoginScreen.AnonymousClass7.this
                            com.talabat.LoginScreen r10 = com.talabat.LoginScreen.this
                            r11 = 0
                            com.facebook.AccessToken r12 = r4
                            java.lang.String r15 = ""
                            java.lang.String r16 = ""
                            r17 = 0
                            r10.doFacebookLogin(r11, r12, r13, r14, r15, r16, r17)
                        L_0x00b8:
                            com.facebook.login.LoginManager r0 = com.facebook.login.LoginManager.getInstance()
                            r0.logOut()
                            com.talabat.LoginScreen$7 r0 = com.talabat.LoginScreen.AnonymousClass7.this
                            com.talabat.LoginScreen r0 = com.talabat.LoginScreen.this
                            r0.startLodingPopup()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.talabat.LoginScreen.AnonymousClass7.AnonymousClass1.onCompleted(org.json.JSONObject, com.facebook.GraphResponse):void");
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putString("fields", "id,name,first_name,last_name,email");
                newMeRequest.setParameters(bundle);
                newMeRequest.executeAsync();
            }
        });
    }

    private void signinWithGoogle() {
        trackLoginClick(0);
        Intent signInIntent = this.mGoogleSignInClient.getSignInIntent();
        googleRevokeAccess();
        startActivityForResult(signInIntent, 9001);
    }

    private void trackLoginClick(int i11) {
        this.f54294p.trackLoginClick(this.from, getLoginType(i11), this.f54291m.config().getCountry());
    }

    private void trackLoginScreenOpened() {
        this.f54294p.trackLoginScreenOpened(this.from, this.f54291m.config().getCountry());
    }

    /* access modifiers changed from: private */
    public void verifyFacebookUserDetailsForCompliance(String str, String str2, String str3) {
        verifyUserDetailsForCompliance(5, str, str2, str3, "");
    }

    private void verifyGoogleUserDetailsForCompliance(String str, String str2, String str3) {
        verifyUserDetailsForCompliance(6, str, str2, str3, "");
    }

    private void verifyUserDetailsForCompliance(int i11, String str, String str2, String str3, String str4) {
        NavigatorModelForResult createOpenScreenModelForResult = ComplianceVerificationActions.INSTANCE.createOpenScreenModelForResult(i11);
        createOpenScreenModelForResult.setInit(new u9(str2, str3, str4, str));
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Activity) this, createOpenScreenModelForResult);
    }

    public void autoSignin(Credential credential) {
        String str;
        String str2;
        String str3 = "";
        if (credential != null) {
            if (credential.getId() == null || TalabatUtils.isNullOrEmpty(credential.getId())) {
                str2 = str3;
            } else {
                str2 = credential.getId();
            }
            if (credential.getPassword() != null && !TalabatUtils.isNullOrEmpty(credential.getPassword())) {
                str3 = credential.getPassword();
            }
            String str4 = str2;
            str = str3;
            str3 = str4;
        } else {
            str = str3;
        }
        if (!TalabatUtils.isNullOrEmpty(str3) && !TalabatUtils.isNullOrEmpty(str)) {
            this.mCredential = credential;
            this.etusername.setText(str3);
            this.etpassword.setText(str);
        }
    }

    public void destroyPresenter() {
        this.loginPresenter = null;
    }

    public void disableGetOtpLinkFor(int i11) {
        MobileNumberWithOTPView mobileNumberWithOTPView = this.edtMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.disableGetOtpLinkFor((long) i11);
        }
    }

    public void disableLoginWithMobileButton() {
        Button button = this.btnLoginWithMobile;
        if (button != null) {
            button.setEnabled(false);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.backPressed = true;
        } else if (action == 1) {
            this.backPressed = true;
        } else if (action == 3) {
            this.backPressed = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayLoginWithEmailOption() {
        LogManager.info("ALOV LoginScreen: displayLoginWithEmailOption");
        trackLoginClick(2);
        if (isFlutterLoginEmailEnabled()) {
            this.f54303y.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData("authentication/login/email")), new pa());
            return;
        }
        if (this.mSmartLockHelper == null && this.f54296r) {
            startLodingPopup();
            this.mSmartLockHelper = new SmartLockHelper(this, 1);
        }
        View view = this.mMainLoginWithEmailContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mLoginWithSocialContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void displayLoginWithMobileOption() {
        View findViewById = findViewById(R.id.btn_mobile);
        findViewById.setVisibility(0);
        setOnClickListenerForDsBrandedButton(findViewById, new oa(this));
    }

    public void displayLoginWithMobileScreen(int i11, boolean z11) {
        LogManager.info("ALOV LoginScreen: displayLoginWithMobileScreen");
        trackLoginClick(4);
        if (isFlutterLoginMobileEnabled()) {
            this.f54303y.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData("authentication/login/mobileNumber")), new ta());
            return;
        }
        View view = this.mMainLoginWithMobileContainer;
        view.setVisibility(0);
        MobileNumberWithOTPView mobileNumberWithOTPView = (MobileNumberWithOTPView) view.findViewById(R.id.eTMobileNumber);
        this.edtMobileNumber = mobileNumberWithOTPView;
        mobileNumberWithOTPView.setCountryCode(i11);
        this.edtMobileNumber.setGetOTPLinkVisibility(z11);
        view.post(new ua(this));
        if (z11) {
            initializeOtpLoginViews(view);
        } else {
            this.edtMobilePassword = (MaterialEditText) view.findViewById(R.id.eTPassword);
        }
        Button button = (Button) view.findViewById(R.id.btnLoginWithMobile);
        this.btnLoginWithMobile = button;
        button.setOnClickListener(new va(this, z11));
        view.findViewById(R.id.show_hide_txt).setOnClickListener(new wa(this));
        view.findViewById(R.id.txtCreateAccountWithMobile).setOnClickListener(new xa(this));
        view.findViewById(R.id.txtForgotMobilePassword).setOnClickListener(new ya(this));
        this.mMainLoginWithEmailContainer.setVisibility(8);
        this.mLoginWithSocialContainer.setVisibility(8);
        TalabatBugReportManager.INSTANCE.blockViewsRecording(this.edtMobileNumber, this.edtMobilePassword);
    }

    public void displayLoginWithSocialOption() {
        View view = this.mMainLoginWithEmailContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mLoginWithSocialContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.mMainLoginWithMobileContainer.setVisibility(8);
        resetLoginWithEmailInputAfterBackNavigation();
        clearLoginWithMobileFields();
        SmartLockHelper smartLockHelper = this.mSmartLockHelper;
        if (smartLockHelper != null) {
            smartLockHelper.disConnectFromAlreadyRunningApiClient(this);
        }
    }

    public void emailNotRegisteredPopup(String str) {
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.email_unregistered_title).setMessage((int) R.string.email_unregistered_msg).setNegativeButton((int) R.string.email_unregistered_retry, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        LoginScreen.this.stopLodingPopup();
                        AppTracker.onLoginEmailUnregistered(LoginScreen.this, "login_retry");
                        if (LoginScreen.this.etusername.getText().toString().length() > 0) {
                            LoginScreen.this.etusername.setText("");
                        }
                        if (LoginScreen.this.etpassword.getText().toString().length() > 0) {
                            LoginScreen.this.etpassword.setText("");
                        }
                        LoginScreen.this.etusername.requestFocus();
                        ((InputMethodManager) LoginScreen.this.getSystemService("input_method")).toggleSoftInput(2, 0);
                    }
                }).setPositiveButton((int) R.string.email_unregistered_create_account, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        AppTracker.onLoginEmailUnregistered(LoginScreen.this, "email_signup_redirected");
                        LoginScreen.this.stopLodingPopup();
                        LoginScreen.this.regScreenReDirection(true, IRegistrationPresenter.RegistrationType.EMAIL);
                    }
                }).show();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void enableLoginWithMobileButton() {
        Button button = this.btnLoginWithMobile;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    public void facebookEmailNotAvailablePopup() {
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.fb_email_not_avail_title).setMessage((int) R.string.fb_email_not_avail_msg).setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new ja(this)).show();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void finishAndGoToHomeScreen() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("is_home_refresh_call_back", this.IsHomeRefreshCallBack);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void finishWithResultGoToAddressList() {
        setResult(2);
        finish();
    }

    public void finishWithResultOK() {
        setResult(-1);
        finish();
    }

    public Context getContext() {
        return this;
    }

    public String getEmail() {
        return this.etusername.getText().toString();
    }

    public String getPassword() {
        return this.etpassword.getText().toString();
    }

    public IGlobalPresenter getPresenter() {
        return this.loginPresenter;
    }

    public String getScreenName() {
        return ScreenNames.LOGIN_SCREEN;
    }

    public void instantiateViews(boolean z11) {
        this.etusername = (MaterialEditText) findViewById(R.id.eTEmail);
        this.etpassword = (MaterialEditText) findViewById(R.id.eTPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.btnNewUser = (TextView) findViewById(R.id.txtCreateAccount);
        this.txtforgot = (TextView) findViewById(R.id.txtForgot);
        this.expressCheckout = (Button) findViewById(R.id.express_checkout);
        this.showHideTxt = (TextView) findViewById(R.id.show_hide_txt);
        this.mMainLoginWithEmailContainer = findViewById(R.id.ll_login_with_email_container);
        this.mMainLoginWithMobileContainer = findViewById(R.id.login_with_mobile);
        this.mLoginWithSocialContainer = findViewById(R.id.ll_login_social_container);
        this.btnContinueWithEmail = findViewById(R.id.btn_email);
        this.btnfacebook = findViewById(R.id.btn_facebook);
        this.loginWithGoogle = findViewById(R.id.btn_google);
        this.back = (ImageButton) findViewById(R.id.back);
        ((LoginLifecycleVoucherView) findViewById(R.id.lifeCycleVoucherLoginInfoView)).init(findViewById(R.id.defaultLoginInfoView));
        if (z11) {
            removeContinueWithEmailBottomMargin();
        }
        TalabatBugReportManager.INSTANCE.blockViewsRecording(this.etpassword);
    }

    public void loginSocialViewVisibility() {
        View view = this.mMainLoginWithEmailContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mLoginWithSocialContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public void navigateToAAALogin() {
        LogManager.info("ALOV LoginScreen: click on continue with Email");
        trackLoginClick(2);
        if (isFlutterLoginEmailEnabled()) {
            this.f54303y.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData("authentication/login/email")), new ba());
        } else {
            startActivityForResult(new Intent(this, EmailLoginActivity.class), 7);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        MobileNumberWithOTPView mobileNumberWithOTPView;
        super.onActivityResult(i11, i12, intent);
        String str = "";
        if (i11 == 100) {
            if (i12 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra(GlobalConstants.LOGIN.RESET_EMAIL);
                if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                    this.etusername.setText(stringExtra);
                } else {
                    String stringExtra2 = intent.getStringExtra(GlobalConstants.LOGIN.RESET_MOBILE);
                    if (!(stringExtra2 == null || stringExtra2.isEmpty() || (mobileNumberWithOTPView = this.edtMobileNumber) == null)) {
                        mobileNumberWithOTPView.setText(stringExtra2);
                    }
                }
            }
            this.etpassword.setText(str);
            this.etpassword.requestFocus();
        } else if (i11 == 9001) {
            handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
            pauseBannerForNextScreen();
        } else if (i11 == 3) {
            if (this.mSmartLockHelper == null) {
                return;
            }
            if (i12 == -1) {
                TextView textView = this.showHideTxt;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                this.backPressed = false;
                Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
                this.mSmartLockHelper.mIsResolving = false;
                if (credential != null) {
                    if (!TalabatUtils.isNullOrEmpty(credential.getAccountType())) {
                        str = credential.getAccountType();
                    }
                    processRetrievedCredential(credential, str);
                    return;
                }
                SmartLockHelper.mIsRequesting = true;
            } else if (i12 == 0) {
                SmartLockHelper.mIsRequesting = true;
            }
        } else if (i11 == 1) {
            screenRedirection();
        } else if (i11 == 4) {
            screenRedirection();
        } else if (i11 == 5) {
            if (i12 == 0) {
                stopLodingPopup();
            } else if (i12 == -1) {
                handleUserVerificationResultForFacebook(intent);
            }
        } else if (i11 == 6) {
            if (i12 == 0) {
                stopLodingPopup();
            } else if (i12 == -1) {
                handleUserVerificationResultForGoogle(intent);
            }
        } else if (i11 == 7) {
            if (i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
                screenRedirection();
            }
        } else if (i11 == 8) {
            boolean equals = "redirect_back".equals(this.redirectNavigation);
            if (i12 == -1 && equals) {
                finish();
            }
        } else if (!isNewFacebookLogin()) {
            this.callbackManager.onActivityResult(i11, i12, intent);
        }
    }

    public void onAuthError() {
    }

    public void onBackButtonPressed() {
        if (isLoginWithEmailShown() || isLoginWithMobileNumberShown()) {
            this.loginPresenter.redirectBackToSocialLoginPage();
        } else {
            backButtonNavigation();
        }
    }

    public void onBackPressed() {
        this.backPressed = true;
        hideKeyboardFrom(this, this.etusername);
        super.onBackPressed();
        if (this.from.equals(ScreenNames.SETTINGS_SCREEN) && !shouldDisableSideMenu()) {
            startActivity(new Intent(this, SettingsScreen.class));
            finish();
        } else if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            launchHomeScreen();
        } else if (this.isFromQuickRegister) {
            launchHomeScreen();
        } else {
            finish();
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                startIntentSenderForResult(connectionResult.getResolution().getIntentSender(), 9001, (Intent) null, 0, 0, 0);
            } catch (IntentSender.SendIntentException e11) {
                LogManager.logException(e11);
            }
        } else {
            GooglePlayServicesUtil.showErrorDialogFragment(connectionResult.getErrorCode(), this, 9001);
        }
        stopLodingPopup();
    }

    public void onCreate(Bundle bundle) {
        String str;
        int i11;
        Bundle bundle2 = bundle;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        Class cls = TokenCoreLibApi.class;
        Class cls2 = DispatcherCoreLibApi.class;
        DaggerLoginScreenComponent.factory().create((AuthenticationCoreLibApi) apiContainer.getFeature(AuthenticationCoreLibApi.class), (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (GmsBaseCoreLibApi) apiContainer.getFeature(GmsBaseCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (SafetyCoreLibApi) apiContainer.getFeature(SafetyCoreLibApi.class), (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), (TokenCoreLibApi) apiContainer.getFeature(cls), (DispatcherCoreLibApi) apiContainer.getFeature(cls2), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        if (isNewFacebookLogin()) {
            this.f54287i = DaggerSocialLoginScreenComponent.factory().create((DispatcherCoreLibApi) apiContainer.getFeature(cls2), (SocialLoginCoreLibApi) apiContainer.getFeature(SocialLoginCoreLibApi.class), (TokenCoreLibApi) apiContainer.getFeature(cls)).getFacebookLoginScreenDelegate();
            facebookLoginScreenDelegate().sdkInitialize();
        } else {
            FacebookSdk.sdkInitialize(this);
        }
        if (bundle2 != null) {
            this.mIsResolving = bundle2.getBoolean(IS_RESOLVING);
            this.mIsRequesting = bundle2.getBoolean(IS_REQUESTING);
        }
        this.callbackManager = CallbackManager.Factory.create();
        TalabatVolley.getRequestQueue(getApplicationContext());
        setContentView((int) R.layout.login_screen_social_promote);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.backPressed = false;
        if (getIntent().hasExtra("from")) {
            str = getIntent().getStringExtra("from");
        } else {
            str = "";
        }
        this.from = str;
        this.showGuestCheckout = getIntent().getBooleanExtra(FlutterLegacyLoginHandler.PARAM_SHOW_GUEST_CHECKOUT, false);
        this.redirectNavigation = getIntent().getStringExtra("redirect_navigation");
        this.isOrderFlow = getIntent().getBooleanExtra("isOrderFlow", false);
        this.isFromQuickRegister = getIntent().getBooleanExtra("fromQuickRegister", false);
        this.afterLoginIntent = (Intent) getIntent().getParcelableExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_INTENT);
        this.afterLoginDeeplink = getIntent().getStringExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_DEEPLINK);
        this.IsHomeRefreshCallBack = getIntent().getBooleanExtra("is_home_refresh_call_back", false);
        this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
        this.isGrlEnabled = getIntent().getBooleanExtra("isGlrEnabledRes", false);
        this.addressString = getIntent().getStringExtra("value");
        this.isFromMapFirstFlow = getIntent().getBooleanExtra("isFromHomeScreenMap", false);
        this.isUserRegisteredRepository = LoginDependencyProvider.INSTANCE.provideIsUserRegisteredRepository(this);
        AppVersionProvider appVersionProvider = this.f54288j;
        AuthenticationRepository authenticationRepository = this.f54289k;
        AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
        CustomerAddressesRepository provideCustomerAddressesRepository = addressesDependencyProvider.provideCustomerAddressesRepository(this.f54293o);
        CustomerRepositoryImpl provideCustomerRepository = addressesDependencyProvider.provideCustomerRepository(this);
        LocationConfigurationRepository locationConfigurationRepository = this.f54291m;
        Scheduler io2 = Schedulers.io();
        Scheduler mainThread = AndroidSchedulers.mainThread();
        IObservabilityManager iObservabilityManager = this.f54292n;
        ITalabatFeatureFlag iTalabatFeatureFlag = this.f54293o;
        RequestOtpRepositoryImpl requestOtpRepositoryImpl = new RequestOtpRepositoryImpl(new RequestOtpRemoteDataSourceImpl((OtpApi) new TalabatAPIBuilder().createApi(OtpApi.class)), new DeviceIdProviderImpl(getContext()));
        TokenRepository tokenRepository = this.f54298t;
        ProCentralizationStatusWrapper proCentralizationStatusWrapper = this.f54295q;
        LoginInteractor loginInteractor = r0;
        LoginInteractor loginInteractor2 = new LoginInteractor(this, appVersionProvider, authenticationRepository, provideCustomerAddressesRepository, provideCustomerRepository, locationConfigurationRepository, io2, mainThread, iObservabilityManager, iTalabatFeatureFlag, requestOtpRepositoryImpl, tokenRepository, proCentralizationStatusWrapper, this.f54299u);
        LoginPresenter loginPresenter3 = new LoginPresenter(this, loginInteractor, new ca(), this.f54293o, new AdjustIdProvider(), new da(this));
        this.loginPresenter = loginPresenter3;
        LoginInteractor loginInteractor3 = loginInteractor;
        loginInteractor3.setLoginListener(loginPresenter3);
        this.loginPresenter2 = DependencyProvider.INSTANCE.provideLoginPresenter2(this, this, this.f54297s);
        this.loginPresenter.setupViews(this.from);
        handleExpressCheckoutVisibility();
        if (!this.f54293o.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_GOOGLE_SIGN_IN, true) || !this.f54296r) {
            this.loginWithGoogle.setVisibility(8);
        } else {
            this.loginWithGoogle.setVisibility(0);
        }
        this.etusername.requestFocus();
        MaterialEditText materialEditText = this.etusername;
        if (TalabatUtils.isRTL()) {
            i11 = 5;
        } else {
            i11 = 3;
        }
        materialEditText.setGravity(i11);
        initiateGoogleSignin();
        this.expressCheckout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i11;
                if (Cart.getInstance() == null || Cart.getInstance().getCartItems() == null) {
                    i11 = 0;
                } else {
                    i11 = Cart.getInstance().getCartItems().size();
                }
                AppTracker.onExperssCheckoutClicked(LoginScreen.this, i11, AppTracker.getRestaurantId(Cart.getInstance().getRestaurant()), Cart.getInstance().getRestaurant());
                LoginScreen.this.navigateToGuestAddressFormScreen();
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginScreen loginScreen = LoginScreen.this;
                LoginScreen.hideKeyboardFrom(loginScreen, loginScreen.etusername);
                LoginScreen.this.loginPresenter.backButtonPressed();
            }
        });
        View view = this.btnContinueWithEmail;
        if (view != null) {
            setOnClickListenerForDsBrandedButton(view, new ea(this));
        }
        this.callbackManager = CallbackManager.Factory.create();
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginScreen.this.loginPresenter.login(2);
            }
        });
        this.btnNewUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginScreen.this.regScreenReDirection(false, IRegistrationPresenter.RegistrationType.EMAIL);
            }
        });
        this.txtforgot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginScreen loginScreen = LoginScreen.this;
                AppTracker.onPasswordResetSelection(loginScreen, loginScreen.from, ScreenNames.LOGIN_SCREEN, TrackingUtils.ResetPasswordOption.Clicked.getValue());
                LoginScreen.this.resetPassword(false);
            }
        });
        if (isNewFacebookLogin()) {
            setOnClickListenerForDsBrandedButton(this.btnfacebook, new ga(this, loginInteractor3));
        } else {
            setUpFacebookLoginButtons();
        }
        this.etpassword.setImeOptions(6);
        this.etpassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 6) {
                    return false;
                }
                LoginScreen.this.loginPresenter.login(2);
                return false;
            }
        });
        setOnClickListenerForDsBrandedButton(this.loginWithGoogle, new ha(this));
        this.showHideTxt.setOnClickListener(new ia(this));
        trackLoginScreenOpened();
    }

    public void onCustomerInfoRecieved(CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
    }

    public void onDestroy() {
        this.isUserRegisteredRepositoryDisposable.dispose();
        this.loginPresenter2.onDestroy();
        MobileNumberWithOTPView mobileNumberWithOTPView = this.edtMobileNumber;
        if (mobileNumberWithOTPView != null) {
            mobileNumberWithOTPView.destroy();
        }
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.edtMobileNumber, this.edtMobilePassword, this.etpassword);
        super.onDestroy();
    }

    public void onError() {
    }

    public void onLoginFailed(String str) {
        SmartLockHelper smartLockHelper;
        stopLodingPopup();
        if (str.equals("Login Failed")) {
            str = getString(R.string.login_failed);
        }
        if (!(!isSmartLockEnabled() || this.mCredential == null || (smartLockHelper = this.mSmartLockHelper) == null)) {
            smartLockHelper.mIsResolving = false;
        }
        loginFailedPopup(str);
    }

    public void onLoginFailedBecauseOfTooManyRequests() {
        checkSmartLock();
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.login_registration_access_denied_title).setMessage((int) R.string.too_many_request_error_title).setPositiveButton((int) R.string.Close, (DialogInterface.OnClickListener) new fa(this)).show();
            }
            AppTracker.onLogin(this, Customer.getInstance().getCustomerInfo(), 200, false, getString(R.string.too_many_request_error_title), getScreenName());
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void onLoginFailedWithAccessDeniedMessage() {
        checkSmartLock();
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.login_registration_access_denied_title).setMessage((int) R.string.login_registration_access_denied_message).setPositiveButton((int) R.string.Close, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        LoginScreen.this.stopLodingPopup();
                        if (LoginScreen.this.etpassword.getText().toString().length() > 0) {
                            LoginScreen.this.etpassword.setText("");
                        }
                    }
                }).show();
            }
            AppTracker.onLogin(this, Customer.getInstance().getCustomerInfo(), 200, false, getString(R.string.login_registration_access_denied_message), getScreenName());
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void onLoginFailedWithTokenExchangeFailure() {
        checkSmartLock();
        try {
            if (!isFinishing()) {
                new AlertDialog.Builder(this).setTitle((int) R.string.login_registration_token_failed_title).setMessage((int) R.string.login_registration_token_failed_message).setPositiveButton((int) R.string.Close, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        LoginScreen.this.stopLodingPopup();
                        if (LoginScreen.this.etpassword.getText().toString().length() > 0) {
                            LoginScreen.this.etpassword.setText("");
                        }
                    }
                }).show();
            }
            AppTracker.onLogin(this, Customer.getInstance().getCustomerInfo(), 200, false, getString(R.string.login_registration_token_failed_message), getScreenName());
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012b, code lost:
        if (r7.equals("Checkout Screen") == false) goto L_0x00c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLoginSucess(int r7) {
        /*
            r6 = this;
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r0 = r0.getCustomerInfo()
            if (r0 == 0) goto L_0x0025
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r0 = r0.getCustomerInfo()
            java.lang.String r0 = r0.email
            buisnessmodels.Customer r1 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r1 = r1.getCustomerInfo()
            int r1 = r1.f13850id
            java.lang.String r1 = java.lang.Integer.toString(r1)
            com.talabat.core.fwf.data.FunWithFlags.updateCustomerInfo(r0, r1)
        L_0x0025:
            com.talabat.notifications.brazemigrator.BrazeGuestToLoggedUserMigrator r0 = new com.talabat.notifications.brazemigrator.BrazeGuestToLoggedUserMigrator
            android.app.Application r1 = r6.getApplication()
            r0.<init>(r1)
            buisnessmodels.Customer r1 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r1 = r1.getCustomerInfo()
            int r1 = r1.f13850id
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.migrateGuestToLoggedInUser(r1)
            com.talabat.core.experiment.data.TalabatExperiment r0 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.experiment.domain.FWFAttributes r1 = com.talabat.core.experiment.domain.FWFAttributes.PILOT_TARGETING_ID
            buisnessmodels.Customer r2 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r2 = r2.getCustomerInfo()
            java.lang.String r2 = r2.email
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r3 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.APPTIMIZE
            r0.setAttribute(r1, r2, r3)
            android.content.Context r0 = r6.getApplicationContext()
            r1 = 2132018979(0x7f140723, float:1.967628E38)
            java.lang.String r1 = r6.getString(r1)
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r1 = 81
            r3 = 200(0xc8, float:2.8E-43)
            r0.setGravity(r1, r2, r3)
            r0.show()
            com.talabat.helpers.GlobalDataModel.DASHBOARDDATA.orderListReceived = r2
            r6.stopLodingPopup()
            r6.setDoNotCheckForComplianceInCheckout()
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r0 = r0.getCustomerInfo()
            com.talabat.core.safety.domain.SafetyAgent r1 = r6.f54301w
            if (r0 == 0) goto L_0x0087
            int r0 = r0.f13850id
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0089
        L_0x0087:
            java.lang.String r0 = ""
        L_0x0089:
            com.talabat.core.safety.domain.SafetyEventType r3 = com.talabat.core.safety.domain.SafetyEventType.LOGIN
            com.talabat.core.safety.domain.entities.SafetyAppData r4 = new com.talabat.core.safety.domain.entities.SafetyAppData
            com.talabat.helpers.AdjustIdProvider r5 = new com.talabat.helpers.AdjustIdProvider
            r5.<init>()
            java.lang.String r5 = r5.get()
            r4.<init>(r5)
            r1.sendSafetyInformation(r0, r3, r4)
            boolean r0 = r6.isSmartLockEnabled()
            if (r0 == 0) goto L_0x00a6
            r6.saveSmartLockCredentials(r7)
            return
        L_0x00a6:
            android.content.Intent r7 = r6.afterLoginIntent
            if (r7 == 0) goto L_0x00b2
            r6.startActivity(r7)
            r6.finish()
            goto L_0x014b
        L_0x00b2:
            java.lang.String r7 = r6.afterLoginDeeplink
            if (r7 == 0) goto L_0x00bb
            r6.navigateToDeeplink(r7)
            goto L_0x014b
        L_0x00bb:
            java.lang.String r7 = r6.from
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = -1
            switch(r0) {
                case -2034555770: goto L_0x0125;
                case -1228527216: goto L_0x011a;
                case -845688140: goto L_0x010f;
                case -800948884: goto L_0x0104;
                case -488915539: goto L_0x00f8;
                case -476948456: goto L_0x00ed;
                case -390281025: goto L_0x00e2;
                case 400972179: goto L_0x00d7;
                case 843415560: goto L_0x00cb;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            r2 = r1
            goto L_0x012e
        L_0x00cb:
            java.lang.String r0 = "Talabat Credit Options Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00d4
            goto L_0x00c8
        L_0x00d4:
            r2 = 8
            goto L_0x012e
        L_0x00d7:
            java.lang.String r0 = "Orders List Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00e0
            goto L_0x00c8
        L_0x00e0:
            r2 = 7
            goto L_0x012e
        L_0x00e2:
            java.lang.String r0 = "Wallet Dashboard screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00eb
            goto L_0x00c8
        L_0x00eb:
            r2 = 6
            goto L_0x012e
        L_0x00ed:
            java.lang.String r0 = "Help Center Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00f6
            goto L_0x00c8
        L_0x00f6:
            r2 = 5
            goto L_0x012e
        L_0x00f8:
            java.lang.String r0 = "talabat.action.Wallet.walletTopUpCardList"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0102
            goto L_0x00c8
        L_0x0102:
            r2 = 4
            goto L_0x012e
        L_0x0104:
            java.lang.String r0 = "Cart Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x010d
            goto L_0x00c8
        L_0x010d:
            r2 = 3
            goto L_0x012e
        L_0x010f:
            java.lang.String r0 = "Offering Collection Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0118
            goto L_0x00c8
        L_0x0118:
            r2 = 2
            goto L_0x012e
        L_0x011a:
            java.lang.String r0 = "BNPL Dashboard Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0123
            goto L_0x00c8
        L_0x0123:
            r2 = 1
            goto L_0x012e
        L_0x0125:
            java.lang.String r0 = "Checkout Screen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x012e
            goto L_0x00c8
        L_0x012e:
            switch(r2) {
                case 0: goto L_0x0145;
                case 1: goto L_0x0141;
                case 2: goto L_0x0145;
                case 3: goto L_0x013b;
                case 4: goto L_0x0137;
                case 5: goto L_0x0145;
                case 6: goto L_0x0145;
                case 7: goto L_0x0145;
                case 8: goto L_0x0145;
                default: goto L_0x0131;
            }
        L_0x0131:
            library.talabat.mvp.login.LoginPresenter2 r7 = r6.loginPresenter2
            r7.onRedirectToHomeScreen()
            goto L_0x014b
        L_0x0137:
            r6.moveToWalletTopupCardListScreen()
            goto L_0x014b
        L_0x013b:
            library.talabat.mvp.login.LoginPresenter2 r7 = r6.loginPresenter2
            r7.onLoggedInFromCartScreen()
            goto L_0x014b
        L_0x0141:
            r6.navigateToPayLaterScreen()
            goto L_0x014b
        L_0x0145:
            r6.setResult(r1)
            r6.finish()
        L_0x014b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.LoginScreen.onLoginSucess(int):void");
    }

    public void onResume() {
        super.onResume();
        if (isNewFacebookLogin()) {
            facebookLoginScreenDelegate().attachErrorView(this);
        }
        pauseBannerForNextScreen();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(IS_RESOLVING, this.mIsResolving);
        bundle.putBoolean(IS_REQUESTING, this.mIsRequesting);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onValidationError(int i11) {
        MaterialEditText materialEditText;
        MaterialEditText materialEditText2;
        MaterialEditText materialEditText3;
        MobileNumberWithOTPView mobileNumberWithOTPView;
        int color = ContextCompat.getColor(this, R.color.edit_text_error);
        if (i11 == 1) {
            if (TalabatUtils.isRTL()) {
                this.etusername.setGravity(5);
            } else {
                this.etusername.setGravity(3);
            }
            this.etusername.setErrorColor(color);
            this.etusername.setError(getString(R.string.required));
        } else if (i11 == 2) {
            this.etpassword.setErrorColor(color);
            this.etpassword.setError(getString(R.string.required));
        } else if (i11 == 3) {
            this.etusername.setErrorColor(color);
            this.etusername.setError(getString(R.string.enter_valid_email));
        } else if (i11 == 102) {
            this.etpassword.setErrorColor(color);
            this.etpassword.setError(getString(R.string.enter_min_six_characters));
        } else if (i11 == 4 && (mobileNumberWithOTPView = this.edtMobileNumber) != null) {
            mobileNumberWithOTPView.setErrorColor(color);
            this.edtMobileNumber.setError(getString(R.string.required));
        } else if (i11 == 5 && (materialEditText3 = this.edtMobilePassword) != null) {
            materialEditText3.setErrorColor(color);
            this.edtMobilePassword.setError(getString(R.string.required));
        } else if (i11 == 6 && (materialEditText2 = this.edtMobilePassword) != null) {
            materialEditText2.setErrorColor(color);
            this.edtMobilePassword.setError(getString(R.string.enter_min_six_characters));
        } else if (i11 == 7 && (materialEditText = this.edtOtp) != null) {
            materialEditText.setErrorColor(color);
            this.edtOtp.setError(getString(R.string.required));
        }
    }

    public void saveCredentials(Credential credential) {
        SmartLockHelper smartLockHelper = this.mSmartLockHelper;
        if (smartLockHelper != null) {
            smartLockHelper.saveCredential(credential);
        }
    }

    public void saveSmartLockSucess() {
        screenRedirection();
    }

    public void showAlertDialog(String str) {
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setMessage((CharSequence) str).setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new v9()).show();
    }

    public void showComplianceCannotCreateAccountDialog() {
        String string = getString(R.string.compliance_cannot_create_account_message);
        CannotProceedDialogFragment.newInstance(string).show(getSupportFragmentManager(), CannotProceedDialogFragment.class.getName());
        ComplianceVerificationDataModule.INSTANCE.provideComplianceVerificationTracker(this).trackUserBlocked(string);
    }

    public void showCouldNotValidateDetailsDialog(String str) {
        UnableToValidateDetailsDialogFactory.createDialog(this, str, new x9()).show();
    }

    public void showDSLoginMethods(LoginView.LoginMethodPriority loginMethodPriority) {
        int i11;
        if (loginMethodPriority == LoginView.LoginMethodPriority.FACEBOOK) {
            i11 = R.layout.login_methods_ds_facebook_priority;
        } else {
            i11 = R.layout.login_methods_ds_google_priority;
        }
        setLoginButtonsStub(i11);
    }

    public void showEmailPopup() {
    }

    public void showInvalidCredentialsForMobileLoginError(String str) {
        new AlertDialog.Builder(this).setTitle((int) R.string.incorrect_number_or_password).setMessage((CharSequence) str).setNegativeButton((int) R.string.email_unregistered_create_account, (DialogInterface.OnClickListener) new ka(this)).setPositiveButton((int) R.string.incorrect_try_again, (DialogInterface.OnClickListener) new la(this)).show();
    }

    public void showLoginMethods(LoginView.LoginMethodPriority loginMethodPriority) {
        int i11;
        if (loginMethodPriority == LoginView.LoginMethodPriority.FACEBOOK) {
            i11 = R.layout.login_methods_facebook_priority;
        } else {
            i11 = R.layout.login_method_button_container;
        }
        setLoginButtonsStub(i11);
    }

    public void showSuccessOtpRequestDialog() {
        showAlertDialog(getString(R.string.request_otp_success_message));
    }
}
