package com.talabat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.language.Language;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.design_system_gallery.DesignSystemGalleryActivity;
import com.talabat.di.DaggerSettingsScreenComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import com.talabat.feature.ulaccountinfo.domain.IAccountInfoFeatureFlag;
import com.talabat.feature.ulaccountinfo.presentation.AccountInfoFlutterActivity;
import com.talabat.firebase.TalabatFirebaseMessagingService;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.language_selector.LanguageSelectorDialog;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.userandlocation.ChooseCountryActions;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.user.ClearCachedUserDataUseCase;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.login.ui.LoginOptionsBottomSheet;
import datamodels.Country;
import datamodels.CustomerInfo;
import datamodels.RegistrationType;
import datamodels.SmsVerificationInstance;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.home.domain.EnableShowLocationSelectionInHomeScreenUseCase;
import library.talabat.mvp.home.domain.impl.EnableShowLocationSelectionInHomeScreenUseCaseImpl;
import library.talabat.mvp.settings.ISettingsPresenter;
import library.talabat.mvp.settings.SettingsPresenter;
import library.talabat.mvp.settings.SettingsView;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.fe;
import ue.ge;
import ue.he;
import xq.b;

public class SettingsScreen extends TalabatBase implements SettingsView, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, GemAccessor {
    public static final int COUNTRY_SELECTION_REQUEST = 1;
    private static final String EXTRA_SHOW_LANGUAGE_DIALOG = "showLanguageDialog";
    public static final String LOG_SMART = "SmartLock";
    private static final int REQUEST_CODE_LOGIN = 2;
    public static final int SAVED_CARD_LIST = 88;
    private View accountInfo;
    private TextView appversion;
    private View cardPaymentView;
    private View changeEmail;
    private View changePassword;
    private View country;
    private TextView countryName;
    private View countrySeperator;
    /* access modifiers changed from: private */
    public Customer customer;
    private TextView designSystemText;
    private View designSystemView;
    private final EnableShowLocationSelectionInHomeScreenUseCase enableShowLocationSelectionInHomeScreenUseCase = new EnableShowLocationSelectionInHomeScreenUseCaseImpl();
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public Moshi f55042i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f55043j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public MutableLocationConfigurationRepository f55044k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public MutableConfigurationLocalRepository f55045l;
    private View language;
    private TextView languageSelected;
    private View loggedInUser;
    private Button logout;
    private TextView logoutText;
    /* access modifiers changed from: private */
    public View logoutView;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public MutableConfigurationRemoteRepository f55046m;
    private GoogleApiClient mGoogleApiClient;
    private Toolbar mToolbar;
    private Boolean mapScreenRedirection;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public PaymentConfigurationRepository f55047n;
    private View nestedScrollview;
    private Switch notification;
    private View notificationView;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ISubscriptionsCustomerRepository f55048o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public GetProCentralizationStatusUseCase f55049p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public ITalabatFeatureFlag f55050q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public IAccountInfoFeatureFlag f55051r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public AuthenticationRepository f55052s;
    private View savedAddresses;
    /* access modifiers changed from: private */
    public ISettingsPresenter settingsPresenter;
    @VisibleForTesting

    /* renamed from: t  reason: collision with root package name */
    public ClearCachedUserDataUseCase f55053t;

    /* renamed from: u  reason: collision with root package name */
    public TokenRepository f55054u;

    private void cardPaymentViewAvailable() {
        boolean z11;
        Country selectedCountry = TalabatUtils.getSelectedCountry(this.f55045l, this.f55044k);
        if (selectedCountry != null) {
            z11 = selectedCountry.isTokenisationEnabledCountry;
        } else {
            z11 = false;
        }
        if ((GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.UAE.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.QATAR.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.KSA.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.KUWAIT.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.OMAN.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.BAHRAIN.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.EGYPT.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.IRAQ.getCountryId() && GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.JORDAN.getCountryId()) || !z11) {
            this.cardPaymentView.setVisibility(8);
        } else if (!Customer.getInstance().isLoggedIn(getContext())) {
            this.cardPaymentView.setVisibility(8);
        } else if (Customer.getInstance().isCreditCardsAvailable()) {
            this.cardPaymentView.setVisibility(0);
        } else {
            this.cardPaymentView.setVisibility(8);
        }
    }

    private void clearData() {
        GlobalDataModel.DASHBOARDDATA.orderInfo = null;
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        GlobalDataModel.DASHBOARDDATA.serverTime = null;
        GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail = false;
        TalabatExperiment.INSTANCE.setAttribute(FWFAttributes.PILOT_TARGETING_ID, "", TalabatExperimentDataSourceStrategy.APPTIMIZE);
    }

    /* access modifiers changed from: private */
    public void finishAndGoToHome(boolean z11) {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(GlobalConstants.ExtraNames.SHOULD_FORCE_LOCATION_IN_HOME, z11);
        startActivity(intent);
        finish();
    }

    private void handleShowLocationSelectionInHome() {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SELECT_ADDRESS_ON_HOME, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.enableShowLocationSelectionInHomeScreenUseCase.enableShowLocationSelectionInHomeScreen();
        }
    }

    private void inject() {
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerSettingsScreenComponent.factory().create((MutableConfigurationLocalCoreLibApi) apiContainer.getFeature(MutableConfigurationLocalCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class), (ParserCoreLibApi) apiContainer.getFeature(ParserCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (AccountInfoFeatureApi) apiContainer.getFeature(AccountInfoFeatureApi.class), (AuthenticationCoreLibApi) apiContainer.getFeature(AuthenticationCoreLibApi.class)).inject(this);
    }

    private boolean isUserRegisteredWithMobile() {
        CustomerInfo customerInfo = this.customer.getCustomerInfo();
        if (customerInfo == null || customerInfo.registrationType != RegistrationType.MOBILE_NUMBER) {
            return false;
        }
        return true;
    }

    private /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent(this, DesignSystemGalleryActivity.class));
    }

    private /* synthetic */ void lambda$onCreate$1(View view) {
        this.designSystemView.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        showLanguageSelectionDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        Navigator.Companion.navigate((Activity) this, ChooseCountryActions.INSTANCE.createOpenScreenModelForResult(1));
    }

    private void logOutOnConfirm(boolean z11, boolean z12) {
        clearData();
        N();
        AppTracker.onLogout(this);
        GlobalDataModel.resetUserLoyaltyEligibilityFlag();
        GlobalDataModel.encryptedUserId = "";
        Customer.clearToken(this);
        this.f55054u.clearTokens();
        Customer instance = Customer.getInstance();
        instance.isClearTokenisationCards();
        instance.resetBrandLocalAddress();
        instance.deselectCustomerAddress();
        this.f55053t.inValidateCachedUserData();
        Intent intent = new Intent(this, HomeScreenActivity.class);
        Cart instance2 = Cart.getInstance();
        intent.putExtra("is_home_refresh_call_back", true);
        instance2.clearCart(this);
        intent.setFlags(67108864);
        showLogOutToast(z12);
        if (z11) {
            instance2.clearCart(this);
        }
        if (instance2.hasItems()) {
            instance2.calculateDeliveryCharges();
        }
        unregisterTokenForChatPushNotifications();
        handleShowLocationSelectionInHome();
        resetComplianceStatusCheck();
        onGemSessionChanged();
        FunWithFlags.clearUserData();
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void logoutPopup() {
        new AlertDialog.Builder(this).setTitle((int) R.string.logout).setMessage((int) R.string.logging_out_confirmation).setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                SettingsScreen.this.settingsPresenter.logout(true);
            }
        }).setNegativeButton((int) R.string.f54880no, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void navigateToLoginScreen() {
        boolean shouldDisableSideMenu = shouldDisableSideMenu();
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra("from", ScreenNames.SETTINGS_SCREEN);
        intent.putExtra(TalabatBase.EXTRA_DISABLE_SIDEMENU, shouldDisableSideMenu);
        intent.setFlags(67108864);
        startActivity(intent);
        if (!shouldDisableSideMenu) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void navigateToWallet() {
        Navigator.Companion.navigate(getContext(), WalletNavigatorActions.Companion.createNavigationToAction(WalletNavigatorActions.OPEN_WALLET_NAVIGATE_TO_WALLET));
    }

    private void resetComplianceStatusCheck() {
        UserStatusDomainModule.INSTANCE.provideUserStatusRepository().resetUserStatusAllowedCheck();
    }

    private void setLanguageText() {
        if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
            this.languageSelected.setText(getResources().getString(R.string.arabic));
        } else if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_SORANI)) {
            this.languageSelected.setText(getResources().getString(R.string.kurdish_sorani));
        } else if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_BADINI)) {
            this.languageSelected.setText(getResources().getString(R.string.kurdish_badini));
        } else {
            this.languageSelected.setText(getResources().getString(R.string.english));
        }
    }

    private void setMargin() {
        try {
            ((LinearLayout.LayoutParams) this.nestedScrollview.getLayoutParams()).setMargins(0, 0, 0, 0);
        } catch (Exception unused) {
        }
    }

    private boolean shouldShowLanguageDialog() {
        return getIntent().getBooleanExtra(EXTRA_SHOW_LANGUAGE_DIALOG, false);
    }

    private void showLanguageSelectionDialog() {
        new LanguageSelectorDialog(this, R.style.CustomStyle, new fe(this));
    }

    private void showLogOutToast(boolean z11) {
        if (z11) {
            Toast.makeText(getApplicationContext(), getString(R.string.logged_out), 1).show();
        }
    }

    private void unregisterTokenForChatPushNotifications() {
        TalabatFirebaseMessagingService.Companion.unregisterToken();
    }

    public void N() {
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null && googleApiClient.isConnected()) {
            Auth.CredentialsApi.disableAutoSignIn(this.mGoogleApiClient);
        }
    }

    public void changeLanguage(final String str) {
        if (Cart.getInstance().hasItems()) {
            new AlertDialog.Builder(this).setTitle((int) R.string.change_language).setMessage((int) R.string.change_language_confirmation).setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    SmsVerificationInstance.resetInstance();
                    Cart.getInstance().clearCart(SettingsScreen.this);
                    SettingsScreen.this.startLodingPopup();
                    GlobalConstants.SettingSelection = "";
                    SettingsScreen.this.settingsPresenter.changeLanguage(SettingsScreen.this, str);
                }
            }).setNegativeButton((int) R.string.f54880no, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                }
            }).show();
            return;
        }
        startLodingPopup();
        GlobalConstants.SettingSelection = "";
        this.settingsPresenter.changeLanguage(this, str);
    }

    public void destroyPresenter() {
        this.settingsPresenter = null;
    }

    public Context getContext() {
        return this;
    }

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    public IGlobalPresenter getPresenter() {
        return this.settingsPresenter;
    }

    public String getScreenName() {
        return ScreenNames.SETTINGS_SCREEN;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1) {
            if (i12 == -1) {
                int intExtra = intent.getIntExtra("country", -1);
                this.mapScreenRedirection = Boolean.valueOf(intent.getBooleanExtra(GlobalConstants.ExtraNames.REDIRECT_LOCATION_COUNTRY_SELECTION, false));
                Iterator<com.talabat.configuration.location.Country> it = this.f55044k.countries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.talabat.configuration.location.Country next = it.next();
                    if (next.getCountry().getCountryId() == intExtra) {
                        this.countryName.setText(next.getCountry().getCountryName());
                        break;
                    }
                }
                this.settingsPresenter.onCountryChanged();
            }
            this.settingsPresenter.onCountryChanged();
        } else if (i11 == 88) {
            cardPaymentViewAvailable();
        } else if (i11 == 2 && i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
            finishAndGoToHome(true);
        } else if (i11 == 1003 && i12 == 2003) {
            this.settingsPresenter.logout(false);
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!shouldDisableSideMenu()) {
            effectiveNavigation();
        }
    }

    public void onChangeCountryCompleted() {
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        GlobalDataModel.DASHBOARDDATA.orderInfo = null;
        GlobalDataModel.DASHBOARDDATA.serverTime = null;
        GlobalDataModel.resetUserLoyaltyEligibilityFlag();
        resetComplianceStatusCheck();
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra(GlobalConstants.ExtraNames.REDIRECT_LOCATION_COUNTRY_SELECTION, this.mapScreenRedirection);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onConnected(@Nullable Bundle bundle) {
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public void onConnectionSuspended(int i11) {
    }

    public void onCreate(Bundle bundle) {
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.settings);
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).enableAutoManage(this, 0, this).addApi(Auth.CREDENTIALS_API).build();
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            notificationFeedCount(this);
            handleToolBarButton();
            this.accountInfo = findViewById(R.id.settings_account_info_view);
            this.savedAddresses = findViewById(R.id.settings_saved_addresses_view);
            this.cardPaymentView = findViewById(R.id.settings_card_payment_view);
            this.changeEmail = findViewById(R.id.settings_change_email_view);
            this.changePassword = findViewById(R.id.settings_change_password_view);
            this.language = findViewById(R.id.language_view);
            this.country = findViewById(R.id.country_view);
            this.countrySeperator = findViewById(R.id.country_seperator);
            this.notification = (Switch) findViewById(R.id.settings_notification_switch);
            this.countryName = (TextView) findViewById(R.id.settings_selected_country);
            this.languageSelected = (TextView) findViewById(R.id.settings_selected_language);
            this.loggedInUser = findViewById(R.id.settings_logged_in_user_view);
            this.logout = (Button) findViewById(R.id.settings_log_out);
            this.logoutView = findViewById(R.id.logout_view);
            this.logoutText = (TextView) findViewById(R.id.logout_text);
            this.designSystemView = findViewById(R.id.design_system_view);
            this.designSystemText = (TextView) findViewById(R.id.design_system_text);
            TextView textView = (TextView) findViewById(R.id.app_version_text);
            this.appversion = textView;
            textView.setText("v10.41.0");
            this.notificationView = findViewById(R.id.pushnotification_view);
            this.nestedScrollview = findViewById(R.id.scrollView1);
            this.customer = Customer.getInstance();
            MutableLocationConfigurationRepository mutableLocationConfigurationRepository = this.f55044k;
            Scheduler io2 = Schedulers.io();
            Scheduler mainThread = AndroidSchedulers.mainThread();
            AppInfoRemoteDataSourceImpl appInfoRemoteDataSourceImpl = new AppInfoRemoteDataSourceImpl((AppInfoApi) new TalabatAPIBuilder().createApi(AppInfoApi.class), this.f55046m, this.f55042i);
            AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
            this.settingsPresenter = new SettingsPresenter(this, mutableLocationConfigurationRepository, io2, mainThread, new AppInfoRepositoryImpl(appInfoRemoteDataSourceImpl, addressesDependencyProvider.provideCustomerAddressesRepository(this.f55050q), addressesDependencyProvider.provideCustomerRepository(this), new CustomerInfoRepositoryImpl(new CustomerInfoLocalDataSourceImpl(this), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), new ProCentralizationStatusWrapper(this.f55049p, this.f55048o)), this.f55045l, this.f55044k, this.f55047n, this.f55050q), this.f55045l, this.f55052s, this.f55050q);
            this.f55054u = ((TokenCoreLibApi) AndroidComponentsKt.apiContainer(getContext()).getFeature(TokenCoreLibApi.class)).getTokenRepository();
            this.f55053t = new ClearCachedUserDataUseCase();
            this.logoutText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SettingsScreen.this.logoutView.performClick();
                }
            });
            this.logoutView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SettingsScreen.this.customer.isLoggedIn(SettingsScreen.this.getContext())) {
                        SettingsScreen.this.logoutPopup();
                    } else if (SettingsScreen.this.f55050q.getFeatureFlag(TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, false)) {
                        new LoginOptionsBottomSheet(SettingsScreen.this, 2).show();
                    } else {
                        SettingsScreen.this.navigateToLoginScreen();
                    }
                }
            });
            this.designSystemView.setVisibility(8);
            this.designSystemText.setVisibility(8);
            this.notification.setChecked(this.settingsPresenter.getNotificationPreference());
            this.notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    SettingsScreen.this.settingsPresenter.saveNotificationPreference(z11);
                }
            });
            if (this.customer.isLoggedIn(getContext())) {
                this.logoutText.setText(getResources().getString(R.string.settings_logout));
                this.loggedInUser.setVisibility(0);
                this.notificationView.setVisibility(0);
                this.appversion.setVisibility(8);
                if (isUserRegisteredWithMobile()) {
                    this.changeEmail.setVisibility(8);
                }
            } else {
                this.logoutText.setText(getResources().getString(R.string.settings_login));
                this.loggedInUser.setVisibility(8);
                this.notificationView.setVisibility(0);
                this.appversion.setVisibility(8);
            }
            setLanguageText();
            setTitle(R.id.title, getString(R.string.title_activity_settings));
            this.countryName.setText(GlobalDataModel.SelectedCountryName);
            this.savedAddresses.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(SettingsScreen.this, AddressList.class);
                    intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, true);
                    SettingsScreen.this.startActivity(intent);
                }
            });
            this.changeEmail.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SettingsScreen.this.startActivity(new Intent(SettingsScreen.this, ChangeEmailScreen.class));
                }
            });
            this.changePassword.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SettingsScreen.this.startActivity(new Intent(SettingsScreen.this, ChangePasswordScreen.class));
                }
            });
            this.language.setOnClickListener(new ge(this));
            this.country.setVisibility(0);
            this.countrySeperator.setVisibility(0);
            this.countryName.setText(GlobalDataModel.SelectedCountryName);
            this.country.setOnClickListener(new he(this));
            this.logout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Customer.clearToken(SettingsScreen.this);
                    GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
                    GlobalDataModel.DASHBOARDDATA.orderInfo = null;
                    GlobalDataModel.DASHBOARDDATA.serverTime = null;
                    SettingsScreen.this.f55053t.inValidateCachedUserData();
                    SettingsScreen.this.finishAndGoToHome(false);
                }
            });
            this.accountInfo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SettingsScreen.this.f55051r.isAccountInfoEnabled()) {
                        SettingsScreen.this.startActivityForResult(new Intent(SettingsScreen.this, AccountInfoFlutterActivity.class), 1003);
                        return;
                    }
                    SettingsScreen.this.startActivity(new Intent(SettingsScreen.this, AccountInfoScreen.class));
                }
            });
            cardPaymentViewAvailable();
            this.cardPaymentView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SettingsScreen settingsScreen = SettingsScreen.this;
                    Country selectedCountry = TalabatUtils.getSelectedCountry(settingsScreen.f55045l, settingsScreen.f55044k);
                    boolean featureFlag = SettingsScreen.this.f55050q.getFeatureFlag(PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(Integer.valueOf(GlobalDataModel.SelectedCountryId), ""), false);
                    if (BuildConfig.IS_ALPHA.booleanValue()) {
                        SettingsScreen.this.navigateToWallet();
                    } else if (selectedCountry == null || !selectedCountry.enableTalabatPay || !featureFlag) {
                        SettingsScreen.this.startActivityForResult(new Intent(SettingsScreen.this, PayfortCardPaymentListScreen.class), 88);
                    } else {
                        SettingsScreen.this.navigateToWallet();
                    }
                }
            });
            setMargin();
            if (shouldShowLanguageDialog()) {
                showLanguageSelectionDialog();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onLogout(boolean z11) {
        boolean z12;
        if (!Cart.getInstance().hasItems() || !Cart.getInstance().getRestaurant().isGlrEnabled) {
            z12 = false;
        } else {
            z12 = true;
        }
        logOutOnConfirm(z12, z11);
    }

    public void onResume() {
        super.onResume();
    }

    public void onServerError(VolleyError volleyError) {
        super.onServerError(volleyError);
    }

    public void reloadViewForLocaleChange() {
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        GlobalDataModel.DASHBOARDDATA.orderInfo = null;
        GlobalDataModel.DASHBOARDDATA.serverTime = null;
        PreWarmedEngines preWarmedEngines = PreWarmedEngines.INSTANCE;
        preWarmedEngines.removeWarmedUpEngine(PreWarmedEngines.ENGINE_FOR_SEARCH);
        preWarmedEngines.removeWarmedUpEngine(PreWarmedEngines.ENGINE_FOR_HOME_OF_OFFERS);
        resetComplianceStatusCheck();
        FunWithFlags.setAppLanguage(Language.Companion.from(GlobalDataModel.SelectedLanguage).getLanguageCode());
        stopLodingPopup();
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
