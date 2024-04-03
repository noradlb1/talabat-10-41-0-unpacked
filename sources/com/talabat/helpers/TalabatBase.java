package com.talabat.helpers;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import com.adjust.sdk.Adjust;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.appboy.events.FeedUpdatedEvent;
import com.apptimize.Apptimize;
import com.apptimize.ApptimizeTestInfo;
import com.braze.Braze;
import com.braze.events.IEventSubscriber;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import com.talabat.AboutUsScreen;
import com.talabat.AccountInfoScreen;
import com.talabat.AddAddressScreen2;
import com.talabat.AddressList;
import com.talabat.BrandingScreen;
import com.talabat.BuildConfig;
import com.talabat.CartScreen;
import com.talabat.CheckOutScreen;
import com.talabat.DeepLinkWebViewScreen;
import com.talabat.GemDialogSwitcher;
import com.talabat.GemFooterCartView;
import com.talabat.GiftVoucherList;
import com.talabat.GroceryMenuScreen;
import com.talabat.ItemChoiceScreen;
import com.talabat.LandingScreen;
import com.talabat.LiveTrackingOnWebView;
import com.talabat.LoginScreen;
import com.talabat.MapsActivity;
import com.talabat.OffersListScreen;
import com.talabat.OrderDetailsScreen;
import com.talabat.OrderListScreen;
import com.talabat.PaymentWebViewScreen;
import com.talabat.PurchaseTalabatCredit;
import com.talabat.QuickFindRestaurantScreen;
import com.talabat.R;
import com.talabat.RateMyOrderScreen;
import com.talabat.RedeemTalabatVoucher;
import com.talabat.RestaurantMenuScreenR;
import com.talabat.SettingsScreen;
import com.talabat.TWebViewScreen;
import com.talabat.TalabatCreditStatementListScreenRefactor;
import com.talabat.TalabatCreditStatementScreen;
import com.talabat.adscreen.AdScreen;
import com.talabat.appboy.Notifications;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.subscription.SubscriptionFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageRemoteConfigurationsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.core.navigation.domain.screen.voucherlist.VouchersListDeeplinkBuilder;
import com.talabat.core.navigation.domain.screen.wallet.CobrandedCreditCardFlutterScreenKt;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.feature.referafriend.domain.models.RafRemoteConfig;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import com.talabat.flutter.CollectionFlutterActivity;
import com.talabat.flutter.HomeOfOffersFlutterFragment;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpcenter.di.HelpCenterFactory;
import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.tracking.event.ScreenOpenedEvent;
import com.talabat.helpers.tracking.event.ScreenOpenedEventModel;
import com.talabat.home.HomeScreenActivity;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;
import com.talabat.sidemenu.ISideMenuPresenter;
import com.talabat.sidemenu.SideMenuFactory;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.sidemenu.SideMenuPresenter;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;
import com.talabat.sidemenu.SideMenuResource;
import com.talabat.sidemenu.SideMenuView;
import com.talabat.sidemenu.SidemenuExpandableListItem;
import com.talabat.splash.presentation.ui.SplashActivity;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.home.HomeNavigationActions;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import com.talabat.talabatnavigation.userandlocation.ChooseCountryActions;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.tracking.event.AppOpenedEvent;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.login.ui.LoginOptionsBottomSheet;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardActivity;
import datamodels.City;
import datamodels.Country;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.QuickFilter;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import j$.util.Map;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import library.talabat.SharedPreferencesManager;
import library.talabat.gemengine.GemView;
import library.talabat.gemengine.NotificationHandler;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.home.VoucherStateDomainModel;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.deeplink.DeepLinkPresenter;
import tracking.deeplink.DeeplinkListener;
import tracking.deeplink.IDeepLinkPresenter;
import tracking.observability.di.VendorInfoAPIObservabilityProvider;
import xq.b;
import zr.a0;
import zr.b0;
import zr.c0;
import zr.w;
import zr.x;
import zr.y;
import zr.z;

@Instrumented
public abstract class TalabatBase extends AppCompatActivity implements Talabat, INetworkError, SideMenuView, DeeplinkListener, IInAppMessageManagerListener, NotificationHandler, NoInternetConnection, TraceFieldInterface {
    public static Map<String, String> ApptimizeTestPaticipatedMap = new HashMap();
    public static Map<String, String> ApptimizeTestSelectedMap = new HashMap();
    private static final int CANCEL_NOTIFICATION_TIME = 29900;
    private static final int CREDITSTATEMENT = 51;
    public static final String ENTRY_POINT_DEEP_LINK = "deep_link";
    public static final String ENTRY_POINT_SIDE_MENU = "side_menu";
    public static final String EXTRA_DISABLE_SIDEMENU = "disableSideMenu";
    protected static final int LOGIN_BOTTOM_SHEET_REQUEST_CODE = 2021;
    protected static final int LOGIN_REQUEST_CODE = 2020;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    public static final String SHOP_CLICK_DEEP_LINK = "deeplink";
    public static final String VARIATION_RAF_EXPERIMENT_ENABLED = "Variation1";
    public static boolean isAppWentToBg = false;
    public static boolean isBackPressed = false;
    public static boolean isWindowFocused = false;
    public static Map<String, String> stroeTestInfoMap = new HashMap();
    public Trace _nr_trace;
    private AppVersionProvider appVersionProvider = null;
    ArrayList<ApptimizeTestInfo> apptimizeArrayList;
    @Nullable
    Intent cachedAfterLoginIntent = null;
    private CityToOldCityMapper cityToOldCityMapper;
    private ConfigurationLocalRepository configurationLocalRepository = null;
    private CountryToOldCountryMapper countryToOldCountryMapper;
    Map<String, String> currentApptimizeTestInfoMap = new HashMap();
    private CustomerRepository customerRepository;
    private IDeepLinkPresenter deepLinkPresenter;
    private CustomDialog dialog;
    private boolean isDisableBrandMenu;
    private boolean isDisableSideMenu;
    private boolean isNoNetworkActivityShown;
    private LocationConfigurationRepository locationConfigRepository = null;
    /* access modifiers changed from: private */
    public DrawerLayout mDrawerLayout;
    private IEventSubscriber<FeedUpdatedEvent> mFeedUpdatedSubscriber;
    private GemDialogSwitcher mGemDialogSwitcher;
    private ImageButton menu;
    private Navigator navigator;
    private NonCancelableDialog nonCancelableDialog;
    TextView notificationBubble;
    private boolean running;
    private ArrayList<SideMenuHeader> sideMenuHeaders;
    /* access modifiers changed from: private */
    public ISideMenuPresenter sideMenuPresenter;
    SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter;
    private ITalabatFeatureFlag talabatFeatureFlag = null;
    private Boolean unreadChatMessagesActive = Boolean.FALSE;
    private int unreadChatMessagesCounter = 0;
    private VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase = null;

    public interface CartButtonClicked {
        void onCartButtonClicked();
    }

    public TalabatBase() {
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.customerRepository = null;
    }

    private void applicationWillEnterForeground() {
        if (isAppWentToBg) {
            isAppWentToBg = false;
        }
    }

    private boolean canShowSubscriptionList() {
        if (!this.talabatFeatureFlag.getFeatureFlag(SubscriptionFeatureFlagConstants.INSTANCE.getSubscriptionFeatureFwfKey(Integer.valueOf(GlobalDataModel.SelectedCountryId), SubscriptionFeatureFlagConstants.SUBSCRIPTION_LIST), false) || !isUserLoggedIn() || !isTProUser()) {
            return false;
        }
        return true;
    }

    @NotNull
    private DeepLinkPresenter createDeepLinkPresenter() {
        ApiContainer apiContainer = (ApiContainer) getApplication();
        MutableConfigurationLocalRepository mutableRepository = ((MutableConfigurationLocalCoreLibApi) apiContainer.getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository();
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository = ((MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class)).getMutableLocationConfigurationRepository();
        PaymentConfigurationRepository paymentConfigurationRepository = ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)).getPaymentConfigurationRepository();
        IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
        CustomerAddressesRepository provideCustomerAddressesRepository = addressesDependencyProvider.provideCustomerAddressesRepository(this.talabatFeatureFlag);
        CustomerRepositoryImpl provideCustomerRepository = addressesDependencyProvider.provideCustomerRepository(this);
        SharedPreferencesManager instance = SharedPreferencesManager.getInstance(this);
        Scheduler io2 = Schedulers.io();
        Scheduler mainThread = AndroidSchedulers.mainThread();
        SharedPreferences preferences = getPreferences(0);
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        return new DeepLinkPresenter(this, provideCustomerAddressesRepository, provideCustomerRepository, mutableLocationConfigurationRepository, instance, io2, mainThread, preferences, mutableRepository, paymentConfigurationRepository, iTalabatFeatureFlag, appVersionProvider2, this.voucherCampaignDeeplinkUseCase, VendorInfoAPIObservabilityProvider.INSTANCE.provideVendorInfoAPIObservability(observabilityManager, appVersionProvider2), observabilityManager);
    }

    private Class<? extends TalabatBase> getCurrentRunningActivity() {
        if (this instanceof FlutterAddressFormActivity) {
            return FlutterAddressFormActivity.class;
        }
        if (this instanceof AddAddressScreen2) {
            return AddAddressScreen2.class;
        }
        if (this instanceof AddressList) {
            return AddressList.class;
        }
        if (this instanceof CartScreen) {
            return CartScreen.class;
        }
        if (this instanceof CheckOutScreen) {
            return CheckOutScreen.class;
        }
        if (this instanceof CheckoutTokenScreen) {
            return CheckoutTokenScreen.class;
        }
        if (this instanceof ItemChoiceScreen) {
            return ItemChoiceScreen.class;
        }
        if (this instanceof MapsActivity) {
            return MapsActivity.class;
        }
        if (this instanceof PaymentWebViewScreen) {
            return PaymentWebViewScreen.class;
        }
        if (this instanceof RestaurantMenuScreenR) {
            return RestaurantMenuScreenR.class;
        }
        if (this instanceof RestaurantsListScreenRefactor) {
            return RestaurantsListScreenRefactor.class;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public DeepLinkNavigator getDeeplinkTalabatNavigator() {
        return ((DeepLinkCoreLibApi) ((ApiContainer) getApplication()).getFeature(DeepLinkCoreLibApi.class)).getDeepLinkNavigator();
    }

    private String getQueryString(String str) {
        try {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                return split[1];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private ITalabatFeatureFlag getTalabatFeatureFlag() {
        return ((FeatureFlagCoreLibApi) ((ApiContainer) getApplication()).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }

    private TalabatTracker getTalabatTracker() {
        return ((TrackingCoreLibApi) ((ApiContainer) getApplication()).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }

    private void insertCurrentApptimizeTest(ArrayList<ApptimizeTestInfo> arrayList) {
        try {
            if (!this.currentApptimizeTestInfoMap.isEmpty()) {
                this.currentApptimizeTestInfoMap.clear();
            }
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ApptimizeTestInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ApptimizeTestInfo next = it.next();
                    this.currentApptimizeTestInfoMap.put(next.getTestName(), next.getEnrolledVariantName());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isApplicationBroughtToBackground(android.app.Activity r8) {
        /*
            r7 = this;
            r0 = 1
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r8.getSystemService(r1)     // Catch:{  }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{  }
            if (r1 == 0) goto L_0x0048
            java.util.List r1 = r1.getAppTasks()     // Catch:{  }
            boolean r2 = r1.isEmpty()     // Catch:{  }
            if (r2 != 0) goto L_0x0048
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{  }
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1     // Catch:{  }
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()     // Catch:{  }
            android.content.ComponentName r1 = r1.topActivity     // Catch:{  }
            android.content.pm.PackageManager r3 = r8.getPackageManager()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x0048 }
            android.content.pm.PackageInfo r8 = r3.getPackageInfo(r8, r0)     // Catch:{ Exception -> 0x0048 }
            android.content.pm.ActivityInfo[] r8 = r8.activities     // Catch:{ Exception -> 0x0048 }
            int r3 = r8.length     // Catch:{ Exception -> 0x0048 }
            r4 = r2
        L_0x0034:
            if (r4 >= r3) goto L_0x0048
            r5 = r8[r4]     // Catch:{ Exception -> 0x0048 }
            java.lang.String r6 = r1.getClassName()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = r5.name     // Catch:{ Exception -> 0x0048 }
            boolean r5 = r6.equals(r5)     // Catch:{ Exception -> 0x0048 }
            if (r5 == 0) goto L_0x0045
            return r2
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x0034
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.TalabatBase.isApplicationBroughtToBackground(android.app.Activity):boolean");
    }

    private Boolean isBnplDashboardFlutterEnabled() {
        return Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_ANDROID_FLUTTER_BNPL_DASHBOARD_ENABLED, false));
    }

    private Boolean isDeeplinkNavigationEnabled() {
        return Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_COLLECTION_DEEP_LINK_NAVIGATION, false));
    }

    private Boolean isFlutterOrderDetailsEnabled() {
        return Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_SHOW_NEW_FLUTTER_ORDER_DETAILS, false));
    }

    private Boolean isNewTrackingLibraryEnabled() {
        return Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION, true));
    }

    private Boolean isReferAFriendExperimentEnabled() {
        boolean z11;
        String stringVariant = TalabatExperiment.INSTANCE.getStringVariant(HomePageExperimentsKeys.REFER_A_FRIEND_CONFIG, "Control", TalabatExperimentDataSourceStrategy.FWF);
        if (stringVariant == null || !stringVariant.equals("Variation1")) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    private Boolean isReferAFriendFlagEnabled() {
        boolean z11;
        if (((RafRemoteConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(HomePageRemoteConfigurationsKeys.INCENTIVES_REFER_A_FRIEND_CONFIG, new RafRemoteConfig(), RafRemoteConfig.class)).getSenderVoucherValue() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    private boolean isShowCreditLoading() {
        if (getScreenName().equals("Wallet Dashboard screen") || getScreenName().equals(ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT)) {
            return false;
        }
        return true;
    }

    private boolean isTProUser() {
        return this.customerRepository.isTPro();
    }

    private boolean isTalabatProdApplication() {
        return getApplication() instanceof TalabatApplication;
    }

    private Boolean isWalletDashboardFlutterEnabled() {
        return Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(EcosystemsFeatureFlagsKeys.IS_FLUTTER_WALLET_DASHBOARD_ENABLED, false));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleToolBarButton$6(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$redirectToLoginScreen$3(Intent intent, String str, boolean z11, Boolean bool) {
        openLoginScreen(bool.booleanValue(), intent, str, z11);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupHelpCenter$0(UnreadChatMessages unreadChatMessages) {
        int i11;
        this.unreadChatMessagesCounter = unreadChatMessages.getUnreadMessageCount();
        this.unreadChatMessagesActive = Boolean.valueOf(unreadChatMessages.isActive());
        updateNotificationBubble();
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            if (Boolean.TRUE.equals(this.unreadChatMessagesActive)) {
                i11 = this.unreadChatMessagesCounter;
            } else {
                i11 = -1;
            }
            sideMenuRecyclerViewAdapter2.updateUnreadMessagesCount(i11);
        }
    }

    private void navigateToVoucherList(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11) {
        getDeeplinkTalabatNavigator().navigateTo(this, new VouchersListDeeplinkBuilder().build(str, str2, str3, z11, true), (Function0<Unit>) null);
    }

    private void openFlutterWalletDashboard() {
        this.navigator.navigateTo(this, new FlutterScreen(new FlutterScreen.FlutterScreenData(CobrandedCreditCardFlutterScreenKt.PARAM_SOURCE_VALUE)), new c0());
    }

    private void openNonSubscribedTDineScreen() {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_TDINE_ONBOARD_SCREEN_REVAMP, true, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(TLifeNavigationActions.FLUTTER_ONBOARDING_ACTIVITY));
        } else {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.talabat.life.on.boarding"));
        }
    }

    private void openPickupScreen() {
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, HomeNavigationActions.INSTANCE.createNavigationModelToPickupScreen());
    }

    private void redirectNoNetworkActivity(int i11) {
        if (!this.isNoNetworkActivityShown) {
            Intent intent = new Intent(this, NoNetworkActivity.class);
            intent.putExtra("errorCode", i11);
            intent.putExtra("screenName", getScreenName());
            startActivity(intent);
            this.isNoNetworkActivityShown = true;
            finish();
        }
    }

    private void redirectToLoginScreen(@Nullable Intent intent, @Nullable String str, boolean z11) {
        onWebRequestCompleted();
        this.talabatFeatureFlag.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, false, true, (Function1<? super Boolean, Unit>) new x(this, intent, str, z11));
    }

    private Boolean referAFriendIsEnabled() {
        return Boolean.valueOf(isReferAFriendFlagEnabled().booleanValue() || isReferAFriendExperimentEnabled().booleanValue());
    }

    private void removeSideMenuHeaderItem(String str) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.sideMenuHeaders.size(); i12++) {
            if (this.sideMenuHeaders.get(i12).getRef().equalsIgnoreCase(str)) {
                i11 = i12;
            }
        }
        if (i11 != -1) {
            this.sideMenuHeaders.remove(i11);
        }
    }

    private void serverErrorMsg(int i11) {
        String str;
        if (i11 == GlobalConstants.serverErrorCode.GEO_BLOCK_ERROR_CODE) {
            str = getResources().getString(R.string.geo_block_error_msg);
        } else if (i11 == GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE) {
            str = getResources().getString(R.string.too_many_request_error_title);
        } else {
            str = getResources().getString(R.string.server_error_msg);
        }
        Toast.makeText(this, str, 1).show();
    }

    private void showBanner() {
        Intent intent = new Intent(this, AdScreen.class);
        intent.putExtra(DownloadService.KEY_FOREGROUND, true);
        startActivity(intent);
    }

    private void showHelpCenterScreen(String str, String str2, String str3) {
        HelpCenterNavigator.navigateToHelpCenter(this, str2, BuildConfig.VERSION_NAME, str, str3);
    }

    /* access modifiers changed from: private */
    public void talabatCreditBal() {
        Customer instance;
        Country datamodelsSelectedCountry = TalabatUtils.getDatamodelsSelectedCountry(((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository().selectedCountry(), this.locationConfigRepository);
        if (datamodelsSelectedCountry != null && datamodelsSelectedCountry.enableTalabtCredit) {
            Customer instance2 = Customer.getInstance();
            if (instance2 != null && instance2.isLoggedIn(getContext()) && datamodelsSelectedCountry.f13845id > 0) {
                GlobalDataModel.APPBOYNOTIFICATION.mLastCreditLoadTime = SystemClock.elapsedRealtime();
                this.sideMenuPresenter.onLoadTalabatCreditBalance();
            }
        } else if (GlobalDataModel.FunWithFlag.TalabatCreditRevampEnabled && !getScreenName().equals(ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT) && (instance = Customer.getInstance()) != null && datamodelsSelectedCountry != null && datamodelsSelectedCountry.f13845id > 0 && instance.isLoggedIn(getContext())) {
            GlobalDataModel.APPBOYNOTIFICATION.mLastCreditLoadTime = SystemClock.elapsedRealtime();
            this.sideMenuPresenter.onLoadTalabatCreditBalance();
        }
    }

    private void trackAppLaunch() {
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(PlatformFeatureFlagsKeys.FWF_SDK_IN_DART_ENABLED, false);
        if (isNewTrackingLibraryEnabled().booleanValue()) {
            getTalabatTracker().track(new AppOpenedEvent(ScreenNames.getScreenType(getScreenName()), featureFlag, 0, "N/A"));
            return;
        }
        AppTracker.appLaunch(this, "", "", 0, ScreenNames.getScreenType(getScreenName()), featureFlag, "N/A");
    }

    private void trackScreenOpenedOldWay() {
        if (this.locationConfigRepository.countries().isEmpty()) {
            AppTracker.onPageOpen(this, getScreenName(), (Country) null, Customer.getInstance().getCustomerInfo());
        } else {
            AppTracker.onPageOpen(this, getScreenName(), TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository), Customer.getInstance().getCustomerInfo());
        }
    }

    /* access modifiers changed from: private */
    public void updateNotificationBubble() {
        boolean z11;
        if (this.notificationBubble != null) {
            boolean z12 = true;
            int i11 = 0;
            if (getScreenName().equalsIgnoreCase(ScreenNames.NOTIFICATIONS) || !GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail || GlobalDataModel.APPBOYNOTIFICATION.notificationCount <= 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            if (!this.unreadChatMessagesActive.booleanValue() || this.unreadChatMessagesCounter <= 0) {
                z12 = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z12);
            TextView textView = this.notificationBubble;
            if (!valueOf.booleanValue() && !valueOf2.booleanValue()) {
                i11 = 8;
            }
            textView.setVisibility(i11);
        }
    }

    public void ApptimizeDataTracking(ArrayList<ApptimizeTestInfo> arrayList) {
        String str;
        try {
            insertCurrentApptimizeTest(arrayList);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ApptimizeTestInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ApptimizeTestInfo next = it.next();
                    if (!stroeTestInfoMap.containsKey(next.getTestName())) {
                        stroeTestInfoMap.put(next.getTestName(), next.getEnrolledVariantName());
                        ApptimizeTestSelectedMap.put(next.getTestName(), next.getEnrolledVariantName());
                    } else {
                        String str2 = "NA";
                        if (!TalabatUtils.isNullOrEmpty(this.currentApptimizeTestInfoMap.get(next.getTestName()))) {
                            str = this.currentApptimizeTestInfoMap.get(next.getTestName());
                        } else {
                            str = str2;
                        }
                        if (!TalabatUtils.isNullOrEmpty(stroeTestInfoMap.get(next.getTestName()))) {
                            str2 = stroeTestInfoMap.get(next.getTestName());
                        }
                        if (!str.equals(str2)) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                Map.EL.replace(stroeTestInfoMap, next.getTestName(), str);
                                Map.EL.replace(ApptimizeTestSelectedMap, next.getTestName(), str);
                            } else {
                                stroeTestInfoMap.remove(next.getTestName());
                                stroeTestInfoMap.put(next.getTestName(), str);
                                ApptimizeTestSelectedMap.remove(next.getTestName());
                                ApptimizeTestSelectedMap.put(next.getTestName(), str);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[SYNTHETIC, Splitter:B:17:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[Catch:{ Exception -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ApptimizeParticipatedDataTracking(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.util.ArrayList<com.apptimize.ApptimizeTestInfo> r0 = r5.apptimizeArrayList     // Catch:{ Exception -> 0x00bf }
            if (r0 == 0) goto L_0x0035
            int r0 = r0.size()     // Catch:{ Exception -> 0x00bf }
            if (r0 <= 0) goto L_0x0035
            java.util.ArrayList<com.apptimize.ApptimizeTestInfo> r0 = r5.apptimizeArrayList     // Catch:{ Exception -> 0x00bf }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00bf }
        L_0x0010:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00bf }
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00bf }
            com.apptimize.ApptimizeTestInfo r1 = (com.apptimize.ApptimizeTestInfo) r1     // Catch:{ Exception -> 0x00bf }
            java.lang.String r2 = r1.getTestName()     // Catch:{ Exception -> 0x00bf }
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r2)     // Catch:{ Exception -> 0x00bf }
            if (r2 != 0) goto L_0x0010
            java.lang.String r2 = r1.getTestName()     // Catch:{ Exception -> 0x00bf }
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x00bf }
            if (r2 == 0) goto L_0x0010
            java.lang.Long r0 = r1.getTestId()     // Catch:{ Exception -> 0x00bf }
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            java.util.Map<java.lang.String, java.lang.String> r1 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            boolean r1 = r1.containsKey(r6)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0064
            android.content.Context r1 = r5.getContext()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = r5.getScreenName()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = tracking.ScreenNames.getScreenType(r3)     // Catch:{ Exception -> 0x00bf }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf }
            r4.<init>()     // Catch:{ Exception -> 0x00bf }
            r4.append(r0)     // Catch:{ Exception -> 0x00bf }
            r4.append(r2)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00bf }
            tracking.AppTracker.onExperimentRunForApptimize(r1, r3, r0, r7)     // Catch:{ Exception -> 0x00bf }
            java.util.Map<java.lang.String, java.lang.String> r0 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x00bf }
            goto L_0x00bf
        L_0x0064:
            boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r7)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = "NA"
            if (r1 != 0) goto L_0x006e
            r1 = r7
            goto L_0x006f
        L_0x006e:
            r1 = r3
        L_0x006f:
            java.util.Map<java.lang.String, java.lang.String> r4 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00bf }
            boolean r4 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r4)     // Catch:{ Exception -> 0x00bf }
            if (r4 != 0) goto L_0x0085
            java.util.Map<java.lang.String, java.lang.String> r3 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00bf }
        L_0x0085:
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x00bf }
            if (r1 != 0) goto L_0x00bf
            android.content.Context r1 = r5.getContext()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = r5.getScreenName()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r3 = tracking.ScreenNames.getScreenType(r3)     // Catch:{ Exception -> 0x00bf }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf }
            r4.<init>()     // Catch:{ Exception -> 0x00bf }
            r4.append(r0)     // Catch:{ Exception -> 0x00bf }
            r4.append(r2)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00bf }
            tracking.AppTracker.onExperimentRunForApptimize(r1, r3, r0, r7)     // Catch:{ Exception -> 0x00bf }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00bf }
            r1 = 24
            if (r0 < r1) goto L_0x00b5
            java.util.Map<java.lang.String, java.lang.String> r0 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            j$.util.Map.EL.replace(r0, r6, r7)     // Catch:{ Exception -> 0x00bf }
            goto L_0x00bf
        L_0x00b5:
            java.util.Map<java.lang.String, java.lang.String> r0 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            r0.remove(r6)     // Catch:{ Exception -> 0x00bf }
            java.util.Map<java.lang.String, java.lang.String> r0 = ApptimizeTestPaticipatedMap     // Catch:{ Exception -> 0x00bf }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.TalabatBase.ApptimizeParticipatedDataTracking(java.lang.String, java.lang.String):void");
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public void afterInAppMessageViewClosed(IInAppMessage iInAppMessage) {
    }

    public void afterInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
    }

    public void applicationdidenterbackground() {
        if (!isWindowFocused) {
            isAppWentToBg = true;
        }
    }

    public void backToRestaurantMenuPage(Dialog dialog2, GemDialogSwitcher gemDialogSwitcher, String str) {
        Dialog dialog3;
        dialog2.dismiss();
        finish();
        if (!(gemDialogSwitcher == null || (dialog3 = gemDialogSwitcher.dialog) == null)) {
            dialog3.dismiss();
        }
        Intent intent = new Intent();
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        if (restaurant != null) {
            if (restaurant.shopType == 1) {
                intent = new Intent(this, GroceryMenuScreen.class);
            } else {
                intent = new Intent(this, RestaurantMenuScreenR.class);
            }
        }
        intent.addFlags(67108864);
        if (!str.isEmpty()) {
            intent.putExtra("from", "Checkout Screen");
        }
        startActivity(intent);
    }

    public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage iInAppMessage) {
        return null;
    }

    public void beforeInAppMessageViewClosed(View view, IInAppMessage iInAppMessage) {
    }

    public void beforeInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
    }

    public boolean canHandleAppLink(Uri uri) {
        return false;
    }

    public void deepLinkRecived(Context context, Uri uri) {
        this.deepLinkPresenter = createDeepLinkPresenter();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        String query = uri.getQuery();
        if (scheme != null) {
            try {
                if (TalabatUtils.isNullOrEmpty(scheme)) {
                    return;
                }
                if (scheme.startsWith("talabatweb")) {
                    if (uri.getHost() != null && !TalabatUtils.isNullOrEmpty(uri.getHost())) {
                        IDeepLinkPresenter iDeepLinkPresenter = this.deepLinkPresenter;
                        iDeepLinkPresenter.talabatWebReceived("https://" + uri.getHost() + path + TypeDescription.Generic.OfWildcardType.SYMBOL + uri.getQuery());
                    }
                } else if (scheme.startsWith("talabat")) {
                    this.deepLinkPresenter.deepLinkRecived(query);
                } else {
                    this.deepLinkPresenter.appLinkRecived(uri, context);
                }
            } catch (Exception unused) {
                this.deepLinkPresenter.deepLinkRecived("talabat://?");
            }
        }
    }

    public void deleteNotification() {
        ((NotificationManager) getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(9999);
    }

    public abstract void destroyPresenter();

    public void disableBrandMenu(boolean z11) {
        this.isDisableBrandMenu = z11;
    }

    public void disableSideMenu(boolean z11) {
        this.isDisableSideMenu = z11;
    }

    public void effectiveNavigation() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        if (NavUtils.shouldUpRecreateTask(this, intent)) {
            TaskStackBuilder.from(this).addNextIntent(intent).startActivities();
            finish();
        } else {
            NavUtils.navigateUpTo(this, intent);
        }
        GlobalConstants.SettingSelection = "";
    }

    public void exitAnimation() {
        ActivityCompat.finishAfterTransition(this);
    }

    public Context getContext() {
        return this;
    }

    public IDeepLinkPresenter getDeepLinkPresenter() {
        if (this.deepLinkPresenter == null) {
            this.deepLinkPresenter = createDeepLinkPresenter();
        }
        return this.deepLinkPresenter;
    }

    public abstract IGlobalPresenter getPresenter();

    public abstract String getScreenName();

    @VisibleForTesting
    public List<SideMenuHeader> getSideMenuHeaders() {
        return this.sideMenuHeaders;
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void handleToolBarButton() {
        if (shouldDisableSideMenu()) {
            ((DrawerLayout) findViewById(R.id.drawer_layout)).setDrawerLockMode(1);
            ImageButton imageButton = (ImageButton) findViewById(R.id.sidemenu_button);
            imageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_m_back_black, getTheme()));
            imageButton.setOnClickListener(new b0(this));
            return;
        }
        setMenu(R.id.sidemenu_button, new SideMenuPresenter(this, ((ConfigurationLocalCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository()), false, (View) null);
    }

    public void hideBnplOverdueNotification() {
    }

    public void hideGemFooter(GemFooterCartView gemFooterCartView) {
        if (gemFooterCartView != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(gemFooterCartView);
            beginTransaction.commit();
        }
    }

    public final boolean isInternetOn() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                GlobalConstants.networkConnectionType = "WIFI";
                return true;
            } else if (activeNetworkInfo.getType() == 0) {
                GlobalConstants.networkConnectionType = "Mobile Data";
                return true;
            }
        }
        return false;
    }

    public boolean isScreenViewEventValid(String str) {
        if (str == null || str.isEmpty() || (str.equals("Home Screen") && GlobalDataModel.isSearchActive)) {
            return false;
        }
        return true;
    }

    public boolean isUserLoggedIn() {
        Customer instance = Customer.getInstance();
        if (instance == null || !instance.isLoggedIn(getContext())) {
            return false;
        }
        return true;
    }

    public boolean isValidContext(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public void notificationFeedCount(Context context) {
        if (!GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail) {
            final Braze instance = Braze.getInstance(context);
            instance.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
            AnonymousClass7 r02 = new IEventSubscriber<FeedUpdatedEvent>() {
                public void trigger(final FeedUpdatedEvent feedUpdatedEvent) {
                    TalabatBase.this.runOnUiThread(new Runnable() {
                        public void run() {
                            boolean z11;
                            if (!GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail) {
                                if (!TalabatBase.this.getScreenName().equalsIgnoreCase(ScreenNames.NOTIFICATIONS)) {
                                    if (feedUpdatedEvent.getUnreadCardCount() > 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail = z11;
                                    if (z11) {
                                        GlobalDataModel.APPBOYNOTIFICATION.notificationCount = feedUpdatedEvent.getUnreadCardCount();
                                    }
                                    TalabatBase.this.updateNotificationBubble();
                                }
                                Log.e("unread cards", "" + feedUpdatedEvent.getUnreadCardCount());
                                if (feedUpdatedEvent.isFromOfflineStorage() && (feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() + 60) * 1000 < System.currentTimeMillis()) {
                                    instance.requestFeedRefresh();
                                }
                            }
                        }
                    });
                }
            };
            this.mFeedUpdatedSubscriber = r02;
            instance.subscribeToFeedUpdates(r02);
            instance.requestFeedRefreshFromCache();
        }
    }

    public void onALRedirectToDeepLinkWebviewScreen(String str) {
        onWebRequestCompleted();
        startActivity(new Intent(this, DeepLinkWebViewScreen.class).putExtra("isresetpassword", true).putExtra("url", str));
        finish();
    }

    public void onALRedirectToGroceryMenu() {
        onWebRequestCompleted();
        GlobalDataModel.ShopClickOrigin = "deeplink";
        startActivity(new Intent(this, GroceryMenuScreen.class).putExtra(GlobalConstants.ExtraNames.ISFROMAPPLINK, true));
        finish();
    }

    public void onALRedirectToRestauranListScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMAPPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onALRedirectToRestauranMenu() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, RestaurantMenuScreenR.class);
        GlobalDataModel.ShopClickOrigin = "deeplink";
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMAPPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onALRedirectToRestaurantSearchScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, QuickFindRestaurantScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMAPPLINK, true);
        startActivity(intent);
        finish();
    }

    @Deprecated
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        Intent intent2;
        super.onActivityResult(i11, i12, intent);
        if (i11 == LOGIN_BOTTOM_SHEET_REQUEST_CODE && i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode() && (intent2 = this.cachedAfterLoginIntent) != null) {
            startActivity(intent2);
        }
    }

    public void onBackPressed() {
        isBackPressed = true;
        super.onBackPressed();
    }

    public void onConnectionRetry() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("TalabatBase");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TalabatBase#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TalabatBase#onCreate", (ArrayList<String>) null);
        }
        Class cls = ConfigurationRemoteCoreLibApi.class;
        this.appVersionProvider = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getAppVersionProvider();
        this.navigator = ((NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class)).getNavigator();
        this.configurationLocalRepository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        this.locationConfigRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getLocationConfigurationRepository();
        this.talabatFeatureFlag = ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
        this.voucherCampaignDeeplinkUseCase = ((CampaignMigratorFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(CampaignMigratorFeatureApi.class)).getVoucherCampaignDeeplinkUseCase();
        this.customerRepository = ((CustomerCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(CustomerCoreLibApi.class)).getRepository();
        super.onCreate(bundle);
        FirebaseApp.initializeApp(this);
        if (isTalabatProdApplication() && !(this instanceof SplashActivity)) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        if (bundle != null && this.locationConfigRepository.countries().isEmpty() && (getScreenName() == null || !getScreenName().equals(ScreenNames.SPLASHSCREEN))) {
            Log.e("splash restart", "from the talabat base");
            Intent intent = new Intent(this, LandingScreen.class);
            intent.addFlags(268468224);
            startActivity(intent);
            finish();
        }
        this.isNoNetworkActivityShown = false;
        if (Apptimize.getTestInfo() != null) {
            if (Apptimize.getTestInfo().values() != null && Apptimize.getTestInfo().values().size() > 0 && !getScreenName().equals(ScreenNames.SCREEN_TYPE_LANDING)) {
                ArrayList<ApptimizeTestInfo> arrayList = new ArrayList<>(Apptimize.getTestInfo().values());
                this.apptimizeArrayList = arrayList;
                ApptimizeDataTracking(arrayList);
            }
            Apptimize.setOnExperimentRunListener(new Apptimize.OnExperimentRunListener() {
                public void onExperimentRun(String str, String str2, boolean z11) {
                    if (!TalabatUtils.isNullOrEmpty(str) && !TalabatUtils.isNullOrEmpty(str2)) {
                        TalabatBase.this.ApptimizeParticipatedDataTracking(str, str2);
                    }
                }
            });
        }
        setupHelpCenter();
        TraceMachine.exitMethod();
    }

    public void onCreditBalanceRefresh() {
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.stopCreditLoading();
            this.sideMenuRecyclerViewAdapter.notifyDataSetChanged();
            return;
        }
        setSideMenu();
    }

    public void onDLForceRedirectToHomeScreenWithQatar(boolean z11, @NonNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository) {
        onWebRequestCompleted();
        Country country = new Country();
        for (com.talabat.configuration.location.Country next : this.locationConfigRepository.countries()) {
            if (next.getCountry().getCountryId() == com.talabat.configuration.country.Country.QATAR.getCountryId()) {
                country = this.countryToOldCountryMapper.apply(next);
            }
        }
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        GlobalDataModel.SelectedCityId = 0;
        GlobalDataModel.SelectedCityName = "";
        mutableConfigurationLocalRepository.setSelectedCountry(country.f13845id);
        GlobalDataModel.SelectedCountryName = country.f13846name;
        GlobalDataModel.areas = null;
        GlobalDataModel.cuisines = null;
        GlobalDataModel.filterEngine = null;
        Context context = getContext();
        String name2 = GlobalConstants.PrefsConstants.getNAME();
        getContext();
        SharedPreferences.Editor edit = context.getSharedPreferences(name2, 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, country.f13845id);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, country.f13846name);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
        GlobalDataModel.AD.countryChanged();
        if (!z11) {
            Cart.getInstance().clearCart(this);
        }
        startActivity(new Intent(this, HomeScreenActivity.class));
        finish();
    }

    public void onDLRedirectTLifeOfferPage(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("vendorID", str);
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY, bundle));
        finish();
    }

    public void onDLRedirectTLifeVendorsList(boolean z11, boolean z12) {
        if (z11) {
            if (z12) {
                com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDORS_ACTIVITY));
            } else {
                openNonSubscribedTDineScreen();
            }
            stopLodingPopup();
            return;
        }
        Intent intent = new Intent(this, HomeScreenActivity.class);
        if (this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_TLIFE_WIDGET, false) && Customer.getInstance().isLoggedIn(getContext())) {
            intent.putExtra("tdine", true);
        }
        startActivity(intent);
        finish();
    }

    public void onDLRedirectTLoyaltyDashboardScreen() {
        GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity(this, LoyaltyDashboardScreen.RewardsCatalogueOrigin.CRM);
        finish();
    }

    public void onDLRedirectToAccountInfoScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, AccountInfoScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToAddressListScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, AddressList.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToCartScreen() {
        TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        onWebRequestCompleted();
        GlobalDataModel.POLYGON_TRACKING.polygonEvents = null;
        Intent intent = new Intent(this, CartScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToDarkstores(Restaurant restaurant, int i11, String str, String str2, String str3, DarkstoresTrackingData darkstoresTrackingData) {
        DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurant, i11, str, true, false, false, DarkstoresDelegate.DSClickOrigin.ORIGIN_HOME, str2, str3, "N/A", "N/A", darkstoresTrackingData);
        onWebRequestCompleted();
    }

    public void onDLRedirectToGiftVoucherScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, GiftVoucherList.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToGroceryHomeScreen(@Nullable Bundle bundle) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(1);
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, SdSquadActions.Companion.createNavigatorModelForGroceryHomeScreen(1, GlobalConstants.VerticalTypes.GROCERY, arrayList, bundle));
        finish();
    }

    public void onDLRedirectToHomeScreen() {
        onWebRequestCompleted();
        startActivity(new Intent(this, HomeScreenActivity.class));
        finish();
    }

    public void onDLRedirectToHomeScreenThenListing(boolean z11) {
        onWebRequestCompleted();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.putExtra(RestaurantsListScreenRefactor.EXTRA_IS_FROM_HOME_COLLECTION, z11);
        startActivity(intent);
    }

    public void onDLRedirectToHomeScreenWithVoucherDetailsBottomSheet(String str, String str2, String str3) {
        onWebRequestCompleted();
        NavigatorModel createNavigationModelToVoucherDetailsBottomSheet = HomeNavigationActions.INSTANCE.createNavigationModelToVoucherDetailsBottomSheet(str, str2, str3);
        Intent intent = new Intent(createNavigationModelToVoucherDetailsBottomSheet.getAction());
        intent.putExtras(createNavigationModelToVoucherDetailsBottomSheet.getOptions());
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToLiveChatScreen(String str) {
        onWebRequestCompleted();
    }

    public void onDLRedirectToLoginScreen(@Nullable Intent intent, boolean z11) {
        redirectToLoginScreen(intent, (String) null, z11);
    }

    public void onDLRedirectToLoginScreenWithDeeplink(@Nullable String str, boolean z11) {
        redirectToLoginScreen((Intent) null, str, z11);
    }

    public void onDLRedirectToNewRestaurantScreen() {
        onWebRequestCompleted();
    }

    public void onDLRedirectToNotificationScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, Notifications.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToOffersScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, OffersListScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToOrderDetailsScreen(final OrderDetails orderDetails) {
        final String str;
        onWebRequestCompleted();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) orderDetails);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) orderDetails);
        }
        if (isFlutterOrderDetailsEnabled().booleanValue()) {
            final String str2 = "talabat://?s=order-details&order_id=" + orderDetails.getOrderTransactionID() + "&country_iso=" + TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository).code;
            getDeeplinkTalabatNavigator().canHandleDeepLink(str2, new Continuation() {
                @NonNull
                public CoroutineContext getContext() {
                    return Dispatchers.getMain();
                }

                public void resumeWith(@NonNull Object obj) {
                    if (!(obj instanceof Boolean)) {
                        return;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        TalabatBase.this.getDeeplinkTalabatNavigator().navigateTo(TalabatBase.this, str2, (Function0<Unit>) null);
                    } else {
                        TalabatBase.this.openLegacyOrderDetails(str, orderDetails);
                    }
                }
            });
        } else {
            openLegacyOrderDetails(str, orderDetails);
        }
        finish();
    }

    public void onDLRedirectToOrderTrackingWebview(String str) {
        Intent intent = new Intent(this, LiveTrackingOnWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, getString(R.string.track_order));
        intent.putExtra("fromThankyouPage", false);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToOrdersListScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, OrderListScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        intent.putExtra(EXTRA_DISABLE_SIDEMENU, this.isDisableSideMenu);
        startActivity(intent);
        if (!this.isDisableSideMenu) {
            finish();
        }
    }

    public void onDLRedirectToPurchaseTalabatCreditScreen() {
        onWebRequestCompleted();
        Class<PurchaseTalabatCredit> cls = PurchaseTalabatCredit.class;
        new Intent(this, cls).putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(new Intent(this, cls));
        finish();
    }

    public void onDLRedirectToRateOrderScreen(RateOrderReq rateOrderReq) {
        String str;
        onWebRequestCompleted();
        Intent intent = new Intent(this, RateMyOrderScreen.class);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) rateOrderReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) rateOrderReq);
        }
        intent.putExtra("value", str);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
    }

    public void onDLRedirectToRedeemVoucherScreen(String str) {
        onWebRequestCompleted();
        Intent intent = new Intent(this, RedeemTalabatVoucher.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        intent.putExtra("value", str);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToReorderScreen() {
        onWebRequestCompleted();
    }

    public void onDLRedirectToRestauranListScreen() {
        onWebRequestCompleted();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToRestauransQuickFilterListScreen(QuickFilter quickFilter) {
        Intent intent = new Intent(this, QuickFilterRestaurantsActivity.class);
        intent.putExtra("ARG_QUICK_FILTER", quickFilter);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToRestaurantScreen(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr, int i11, String str) {
        if (restaurant != null) {
            onWebRequestCompleted();
            Intent intent = new Intent(this, BrandingScreen.class);
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            int[] iArr = new int[deliveryAreaArr.length];
            for (int i12 = 0; i12 < deliveryAreaArr.length; i12++) {
                iArr[i12] = deliveryAreaArr[i12].getId();
            }
            GlobalDataModel.SELECTED.restaurant.delAreas = iArr;
            GlobalDataModel.restaurantDeliveryAreas = deliveryAreaArr;
            intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            intent.putExtra(GlobalConstants.ExtraNames.MIGRATED_TYPE, i11);
            intent.putExtra(GlobalConstants.ExtraNames.MIGRATED_INFO, str);
            boolean z11 = this.isDisableBrandMenu;
            if (z11) {
                intent.putExtra(GlobalConstants.BRAND_DEEP_LINK_NAVIGATION.DISABLE_SIDEMENU, z11);
            }
            intent.putExtra(GlobalConstants.ExtraNames.AREA_CHOOSED, false);
            startActivity(intent);
            if (!this.isDisableBrandMenu) {
                finish();
                return;
            }
            return;
        }
        onDLRedirectToHomeScreen();
    }

    public void onDLRedirectToRestaurantSearchScreen(String str) {
        onWebRequestCompleted();
        Intent intent = new Intent(this, QuickFindRestaurantScreen.class);
        intent.putExtra("value", str);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectToSelectCountryScreen() {
        onWebRequestCompleted();
        NavigatorModel createOpenScreenModel = ChooseCountryActions.INSTANCE.createOpenScreenModel();
        createOpenScreenModel.setInit(new y());
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, createOpenScreenModel);
        finish();
    }

    public void onDLRedirectToSettingsScreen() {
        startActivity(new Intent(this, SettingsScreen.class));
    }

    public void onDLRedirectToTalabatCreditStatementScreen() {
        Customer instance = Customer.getInstance();
        Class<LoginScreen> cls = LoginScreen.class;
        if (instance == null) {
            Intent intent = new Intent(this, cls);
            intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            intent.putExtra("from", ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT);
            startActivityForResult(intent, 51);
        } else if (!instance.isLoggedIn(getContext())) {
            Intent intent2 = new Intent(this, cls);
            intent2.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            intent2.putExtra("from", ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT);
            startActivityForResult(intent2, 51);
        } else if (GlobalDataModel.FunWithFlag.TalabatCreditRevampEnabled) {
            Intent intent3 = new Intent(this, TalabatCreditStatementListScreenRefactor.class);
            intent3.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            startActivity(intent3);
        } else {
            Intent intent4 = new Intent(this, TalabatCreditStatementScreen.class);
            intent4.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            startActivity(intent4);
        }
    }

    public void onDLRedirectToWebview(String str, boolean z11) {
        Intent intent = new Intent(this, DeepLinkWebViewScreen.class);
        intent.putExtra("url", str);
        intent.putExtra("isWebViewRedirection", z11);
        startActivity(intent);
        finish();
    }

    public void onDLRedirectVoucherWalletScreen(String str, String str2, String str3, boolean z11) {
        if (GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.KSA.getCountryId()) {
            navigateToVoucherList(str, str2, str3, z11);
        }
    }

    public void onDLSaveArea(int i11, String str) {
        GlobalDataModel.SelectedAreaId = i11;
        GlobalDataModel.SelectedAreaName = str;
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.apply();
    }

    public void onDLSaveCity(int i11, String str) {
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = str;
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
        edit.apply();
    }

    public void onDLSaveCountry(@NonNull Country country, @NonNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository) {
        mutableConfigurationLocalRepository.setSelectedCountry(country.f13845id);
        GlobalDataModel.SelectedCountryName = country.f13846name;
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, country.f13845id);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, country.f13846name);
        edit.apply();
    }

    public void onDataError() {
        stopLodingPopup();
        stopNonCancelableLoading();
    }

    public void onDeepLinkNavigateToBNPLDashboard() {
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createBNPLDashboardDeepLinkNavigation(isUserLoggedIn(), isBnplDashboardFlutterEnabled().booleanValue()));
        finish();
    }

    public void onDeepLinkNavigateToCollectionScreen(String str, String str2) {
        onWebRequestCompleted();
        try {
            if (isDeeplinkNavigationEnabled().booleanValue()) {
                String str3 = "talabat://?s=/vendor-list-collection&deeplink=" + str;
                if (!str2.isEmpty()) {
                    str3 = str3 + "&from=" + str2;
                }
                getDeeplinkTalabatNavigator().navigateTo(this, str3, (Function0<Unit>) null);
                return;
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
        Intent intent = new Intent(this, CollectionFlutterActivity.class);
        intent.putExtra("deeplink", str);
        intent.putExtra("channel", "home_channel");
        intent.putExtra("from", str2);
        startActivity(intent);
    }

    public void onDeepLinkNavigateToGemComponent(String str) {
        onWebRequestCompleted();
        GlobalDataModel.ShopClickOrigin = "deeplink";
        b.j(this, str);
    }

    public void onDeepLinkNavigateToGlobalHelpCenter(String str, String str2) {
        showHelpCenterScreen("deep_link", str, str2);
        finish();
    }

    public void onDeepLinkNavigateToHomeOfOffers() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra(HomeOfOffersFlutterFragment.HOME_OF_OFFERS_DEEP_LINK, true);
        intent.addFlags(268468224);
        startActivity(intent);
    }

    public void onDeepLinkNavigateToPickupScreen() {
        openPickupScreen();
        stopLodingPopup();
        finish();
    }

    public void onDeepLinkNavigateToSubscriptionScreen() {
        if (canShowSubscriptionList()) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(WalletNavigatorActions.OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN));
        } else {
            startActivity(new Intent(this, HomeScreenActivity.class));
        }
        finish();
    }

    public void onDeepLinkNavigateToTproBenefits() {
        stopLodingPopup();
        if (!isTProUser()) {
            TproNavigatorActionsKt.navigateToBenefitsActivity(this);
        }
    }

    public void onDeepLinkNavigateToWalletDashBoard() {
        if (!isWalletDashboardFlutterEnabled().booleanValue() || !this.customerRepository.isLoggedIn()) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createNavigationToWalletDashBoard());
            finish();
            return;
        }
        openFlutterWalletDashboard();
    }

    public void onDestroy() {
        try {
            super.onDestroy();
            IGlobalPresenter presenter = getPresenter();
            if (isTalabatProdApplication()) {
                ((TalabatApplication) getApplicationContext()).forceUnregisterComponentCallbacks();
            }
            if (presenter != null) {
                presenter.onDestroy();
                destroyPresenter();
            }
        } catch (Throwable th2) {
            LogManager.logException(th2);
        }
    }

    public void onEmptyMenuReceived(String str) {
        stopLodingPopup();
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = getString(R.string.the_restaurant);
        }
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setMessage((CharSequence) getResources().getString(R.string.restaurant_has_no_menu).replace("###", str)).setCancelable(false).setNeutralButton((CharSequence) getString(R.string.ok_btn), (DialogInterface.OnClickListener) new a0()).show();
    }

    public boolean onInAppMessageButtonClicked(@NonNull IInAppMessage iInAppMessage, @NonNull MessageButton messageButton) {
        if (messageButton.getUri() == null) {
            return false;
        }
        startLodingPopup();
        getDeepLinkPresenter().deepLinkRecived(messageButton.getUri().getQuery());
        getDeepLinkPresenter().redirectToDeepLink();
        disableBrandMenu(true);
        return false;
    }

    public /* synthetic */ boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton, InAppMessageCloser inAppMessageCloser) {
        return c4.b.g(this, iInAppMessage, messageButton, inAppMessageCloser);
    }

    public boolean onInAppMessageClicked(@NonNull IInAppMessage iInAppMessage) {
        if (iInAppMessage.getUri() == null) {
            return false;
        }
        startLodingPopup();
        getDeepLinkPresenter().deepLinkRecived(iInAppMessage.getUri().getQuery());
        getDeepLinkPresenter().redirectToDeepLink();
        disableBrandMenu(true);
        return false;
    }

    public /* synthetic */ boolean onInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        return c4.b.i(this, iInAppMessage, inAppMessageCloser);
    }

    public void onInAppMessageDismissed(IInAppMessage iInAppMessage) {
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
            finish();
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onNetworkError() {
        if (!getScreenName().equals(ScreenNames.SPLASHSCREEN)) {
            CustomDialog customDialog = this.dialog;
            if (customDialog != null && customDialog.isShowing()) {
                this.dialog.dismiss();
            }
            stopNonCancelableLoading();
            showConnectionError(GlobalConstants.isNetworkDialogShowing);
        }
    }

    public void onPause() {
        if (isTalabatProdApplication()) {
            ((TalabatApplication) getApplicationContext()).forceUnregisterComponentCallbacks();
            super.onPause();
            ((TalabatApplication) getApplication()).setCurrentPausedActivity(getScreenName());
        }
        Adjust.onPause();
    }

    public void onRedirectToLoginScreen() {
        stopLodingPopup();
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false);
        intent.putExtra("from", "Checkout Screen");
        startActivityForResult(intent, LOGIN_REQUEST_CODE);
    }

    public void onResume() {
        super.onResume();
        if (isTalabatProdApplication()) {
            GlobalDataModel.IsChatStarted = false;
            if (((TalabatApplication) getApplication()).canCountAsAppOpen(getScreenName())) {
                trackAppLaunch();
            }
            trackScreenOpened();
            refreshCartCount();
        }
        Adjust.onResume();
    }

    public void onRiderChatRedirection(String str) {
        Intent intent = new Intent(this, RiderChatDeepLinkActivity.class);
        intent.putExtra(RiderChatDeepLinkActivity.ORDER_ID_KEY, str);
        startActivity(intent);
    }

    public void onServerError(VolleyError volleyError) {
        int i11;
        NetworkResponse networkResponse;
        stopLodingPopup();
        stopNonCancelableLoading();
        if (volleyError == null || (networkResponse = volleyError.networkResponse) == null) {
            i11 = 500;
        } else {
            i11 = networkResponse.statusCode;
        }
        if (getScreenName().equals(ScreenNames.SPLASHSCREEN)) {
            redirectNoNetworkActivity(i11);
        } else {
            serverErrorMsg(i11);
        }
    }

    public void onShakeImage(@AnyRes int i11) {
        ((ImageView) findViewById(i11)).setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
    }

    public void onSideMenuLinkNavigation(String str, String str2) {
        if (str2.startsWith(CobrandedCreditCardFlutterScreenKt.TALABAT_DEEPLINK_PREFIX)) {
            startLodingPopup();
            getDeepLinkPresenter().deepLinkRecived(getQueryString(str2));
            getDeepLinkPresenter().redirectToDeepLink();
            disableBrandMenu(true);
            return;
        }
        Intent intent = new Intent(this, TWebViewScreen.class);
        intent.putExtra("titile", str);
        intent.putExtra("url", str2);
        startActivity(intent);
    }

    public void onSideMenuNavigation(String str) {
        AppTracker.onSideMenuOptionSelected(this, str);
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(3)) {
                this.mDrawerLayout.closeDrawer(3);
            } else {
                this.mDrawerLayout.closeDrawer(5);
            }
        }
        if (str.equals(getScreenName())) {
            pauseBannerForNextScreen();
        }
        Class<HomeScreenActivity> cls = HomeScreenActivity.class;
        if (str.equals("Home Screen")) {
            Intent intent = new Intent(this, cls);
            intent.addFlags(268435456);
            startActivity(intent);
        } else if (str.equals(ScreenNames.LIVE_SUPPORT)) {
            showHelpCenterScreen("side_menu", "", "");
        } else if (str.equals(ScreenNames.QUICKFINDRESTAURANTS)) {
            startActivity(new Intent(this, QuickFindRestaurantScreen.class));
        } else if (str.equals(ScreenNames.ADDRESS_LIST)) {
            startActivity(new Intent(this, AddressList.class));
        } else if (str.equals(ScreenNames.LOGOUT)) {
            Customer.clearToken(this);
            startActivity(new Intent(this, cls));
        } else if (str.equals(ScreenNames.SETTINGS_SCREEN)) {
            startActivity(new Intent(this, SettingsScreen.class));
        } else if (str.equals(ScreenNames.ORDERS_LIST)) {
            startActivity(new Intent(this, OrderListScreen.class));
        } else if (str.equals(ScreenNames.PROMOTIONS)) {
            startActivity(new Intent(this, OffersListScreen.class));
        } else if (str.equals(ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT) || str.equals("Wallet Dashboard screen")) {
            if (isWalletDashboardFlutterEnabled().booleanValue()) {
                openFlutterWalletDashboard();
            } else {
                startActivity(new Intent(this, WalletDashboardActivity.class));
            }
        } else if (str.equals(ScreenNames.NOTIFICATIONS)) {
            startActivity(new Intent(this, Notifications.class));
        } else if (str.equals(ScreenNames.ABOUT_SCREEN)) {
            startActivity(new Intent(this, AboutUsScreen.class));
        } else if (str.equals("rewards")) {
            GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity(this, LoyaltyDashboardScreen.RewardsCatalogueOrigin.CRM);
        } else if (str.equals(ScreenNames.VOUCHERS_LIST)) {
            navigateToVoucherList((String) null, (String) null, (String) null, false);
        } else if (str.equals(ScreenNames.WALLET_SUBSCRIPTION_SETTINGS)) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(WalletNavigatorActions.OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN));
        } else if (str.equals("share")) {
            shareContent(1);
        } else if (str.equals(ScreenNames.PAY_LATER_DASHBOARD)) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createNavigationToBNPLDashboard("side_menu", isBnplDashboardFlutterEnabled().booleanValue()));
        }
        if (str.equals(getScreenName())) {
            finish();
        }
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (isTalabatProdApplication()) {
            isInternetOn();
            this.running = true;
            applicationWillEnterForeground();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().deleteNotification();
                GEMEngine.getInstance().setNotificationHandlerListener(this);
            }
        }
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        applicationdidenterbackground();
        this.running = false;
        if (GEMEngine.getInstance() != null && isApplicationBroughtToBackground(this)) {
            GEMEngine.getInstance().setNotificationHandlerListener(this);
        }
    }

    public void onWebRequestCompleted() {
        stopLodingPopup();
    }

    public void onWindowFocusChanged(boolean z11) {
        isWindowFocused = z11;
        if (isBackPressed && !z11) {
            isBackPressed = false;
            isWindowFocused = true;
        }
        super.onWindowFocusChanged(z11);
    }

    /* access modifiers changed from: package-private */
    public void openLegacyOrderDetails(String str, OrderDetails orderDetails) {
        Intent intent = new Intent(this, OrderDetailsScreen.class);
        intent.putExtra("value", str);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        intent.putExtra("statusBoolean", orderDetails.status);
        startActivity(intent);
    }

    @VisibleForTesting
    public void openLoginScreen(boolean z11, Intent intent, String str, boolean z12) {
        if (z11) {
            this.cachedAfterLoginIntent = intent;
            new LoginOptionsBottomSheet(this, LOGIN_BOTTOM_SHEET_REQUEST_CODE).show();
            return;
        }
        Intent intent2 = new Intent(this, LoginScreen.class);
        intent2.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        if (z12) {
            intent2.putExtra("from", "Home Screen");
            intent2.putExtra("is_home_refresh_call_back", true);
        }
        if (intent != null) {
            intent2.putExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_INTENT, intent);
        }
        if (str != null) {
            intent2.putExtra(GlobalConstants.ExtraNames.AFTER_LOGIN_DEEPLINK, str);
        }
        startActivity(intent2);
        finish();
    }

    public void pauseBannerForNextScreen() {
        if (isTalabatProdApplication()) {
            ((TalabatApplication) getApplication()).pauseBannerForNextScreen();
        }
    }

    public void refreshCartCount() {
    }

    public void removeDisabledSideMenuItems() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() || !isUserLoggedIn()) {
            removeSideMenuHeaderItem(ScreenNames.VOUCHERS_LIST);
        }
        if (!canShowSubscriptionList()) {
            removeSideMenuHeaderItem("Subscriptions");
        }
        if (!referAFriendIsEnabled().booleanValue() || !isUserLoggedIn()) {
            removeSideMenuHeaderItem(SideMenuResource.REF_REFER_A_FRIEND);
        }
        if (!this.talabatFeatureFlag.getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_BNPL_DASHBOARD_ENABLED, false) || !isUserLoggedIn()) {
            removeSideMenuHeaderItem("paylater");
        }
    }

    public void restaurantChanged() {
        GlobalDataModel.restaurantDeliveryAreas = null;
        GlobalDataModel.JSON.menuItemsResponseModel = null;
    }

    public void setBackButton(@AnyRes int i11) {
        ((ImageButton) findViewById(i11)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TalabatBase.this.getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
                    TalabatBase.this.startActivity(new Intent(TalabatBase.this, HomeScreenActivity.class));
                }
                TalabatBase.this.finish();
            }
        });
    }

    public void setCartButton(@AnyRes int i11, final CartButtonClicked cartButtonClicked) {
        findViewById(i11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppTracker.onCartClicked(TalabatBase.this, "header");
                cartButtonClicked.onCartButtonClicked();
            }
        });
        refreshCartCount();
    }

    public void setCartVisibility(@AnyRes int i11) {
        View findViewById = findViewById(i11);
        if (Cart.getInstance().hasItems()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void setMenu(@AnyRes int i11, final ISideMenuPresenter iSideMenuPresenter, final boolean z11, View view) {
        this.sideMenuPresenter = iSideMenuPresenter;
        iSideMenuPresenter.setSideMenu();
        if (view != null) {
            this.mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
            this.menu = (ImageButton) view.findViewById(i11);
            this.notificationBubble = (TextView) view.findViewById(R.id.notification_buble);
        } else {
            this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            this.menu = (ImageButton) findViewById(i11);
            this.notificationBubble = (TextView) findViewById(R.id.notification_buble);
        }
        updateNotificationBubble();
        this.menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (z11 || GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail) {
                    TalabatBase.this.updateNotificationBubble();
                    iSideMenuPresenter.setSideMenu();
                }
                TalabatBase talabatBase = TalabatBase.this;
                AppTracker.onSideMenuButtonClicked(talabatBase, talabatBase.getScreenName());
                try {
                    if (TalabatUtils.isRTL()) {
                        TalabatBase.this.mDrawerLayout.openDrawer(5);
                    } else {
                        TalabatBase.this.mDrawerLayout.openDrawer(3);
                    }
                } catch (Exception unused) {
                    TalabatBase.this.mDrawerLayout.openDrawer(3);
                }
                TalabatBase.this.talabatCreditBal();
                iSideMenuPresenter.onLoadUserActiveVouchersCount();
            }
        });
    }

    public void setSideMenu() {
        int i11;
        this.sideMenuHeaders = SideMenuFactory.createSideMenuItems(GlobalDataModel.JSON.sideMenuSection, GlobalDataModel.JSON.sideMenuSectionLinks, this, this.configurationLocalRepository.selectedCountry());
        removeDisabledSideMenuItems();
        ArrayList<SidemenuExpandableListItem> menuExpandableList = SideMenuFactory.getMenuExpandableList(this.sideMenuHeaders);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_slidemenu);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.side_menu_white));
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = new SideMenuRecyclerViewAdapter(this.configurationLocalRepository, this.locationConfigRepository, new SideMenuRecyclerViewAdapter.SidemenuClicked() {
            public void onClick(String str) {
                TalabatBase.this.sideMenuPresenter.onSidemenuItemClicked(str);
            }

            public void onLinkClicked(String str, String str2) {
                if (TalabatBase.this.mDrawerLayout.isDrawerOpen(3)) {
                    TalabatBase.this.mDrawerLayout.closeDrawer(3);
                } else {
                    TalabatBase.this.mDrawerLayout.closeDrawer(5);
                }
                TalabatBase.this.sideMenuPresenter.onSidemenuLinkClicked(str, str2);
            }

            public void scrollFocus(int i11) {
                linearLayoutManager.scrollToPosition(i11);
            }
        }, menuExpandableList, isShowCreditLoading(), false, false, ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository().selectedCountry(), ((FeatureFlagCoreLibApi) ((ApiContainer) getApplication()).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag(), ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager());
        this.sideMenuRecyclerViewAdapter = sideMenuRecyclerViewAdapter2;
        recyclerView.setAdapter(sideMenuRecyclerViewAdapter2);
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter3 = this.sideMenuRecyclerViewAdapter;
        if (Boolean.TRUE.equals(this.unreadChatMessagesActive)) {
            i11 = this.unreadChatMessagesCounter;
        } else {
            i11 = -1;
        }
        sideMenuRecyclerViewAdapter3.updateUnreadMessagesCount(i11);
    }

    @VisibleForTesting
    public void setSideMenuHeaders(SideMenuHeader sideMenuHeader) {
        ArrayList<SideMenuHeader> arrayList = new ArrayList<>();
        this.sideMenuHeaders = arrayList;
        arrayList.add(sideMenuHeader);
    }

    public void setTitle(@AnyRes int i11, String str) {
        ((TextView) findViewById(i11)).setText(str);
    }

    public void setToolbarPadding(Toolbar toolbar) {
        toolbar.setPadding(0, 0, 0, 0);
    }

    public void setToolbarPaddingWithStatusBar(Toolbar toolbar) {
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
    }

    public void setupHelpCenter() {
        HelpCenterFactory.createUnreadMessagesLiveData(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), BuildConfig.VERSION_NAME).observe(this, new w(this));
        try {
            HelpCenterFactory.setDeepLinkPresenter(getDeepLinkPresenter());
        } catch (Exception unused) {
        }
    }

    public void shareContent(int i11) {
        pauseBannerForNextScreen();
        if (i11 == 1) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, getResources().getString(R.string.share_app_subject));
            intent.putExtra("android.intent.extra.TEXT", getResources().getString(R.string.share_app_url));
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.share_app_dialog_title)));
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.SEND");
        intent2.setType(MimeTypes.IMAGE_JPEG);
        intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(getFilesDir(), "splash_01")));
        intent2.putExtra("android.intent.extra.TEXT", getResources().getString(R.string.share_app_url));
        startActivity(Intent.createChooser(intent2, getResources().getString(R.string.share_app_dialog_title)));
    }

    public boolean shouldDisableSideMenu() {
        return getIntent().getBooleanExtra(EXTRA_DISABLE_SIDEMENU, true);
    }

    public void showBNPLOption() {
    }

    public void showBnplOverdueNotification(double d11) {
    }

    public void showConnectionError(boolean z11) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        NoNetworkDialogFragment noNetworkDialogFragment = new NoNetworkDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("screenName", getScreenName());
        noNetworkDialogFragment.setArguments(bundle);
        if (!z11 && !isFinishing() && this.running) {
            noNetworkDialogFragment.show(supportFragmentManager, "networkdialogfragment");
            GlobalConstants.isNetworkDialogShowing = true;
        }
    }

    public void showDarkstoresErrorMessage() {
        Toast.makeText(this, R.string.darkstores_not_found_message, 1).show();
    }

    public void showGemTimeOutDialog(GemDialogSwitcher gemDialogSwitcher, GemFooterCartView gemFooterCartView, OnGemAlertDialogClickListener onGemAlertDialogClickListener, Context context) {
        GlobalDataModel.GEMCONSTANTS.isGemFlow = false;
        GlobalDataModel.GEMCONSTANTS.isGemForthankyou = false;
        GlobalDataModel.GEMCONSTANTS.isAdDisableGem = false;
        GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice = 0.0f;
        if (this.mGemDialogSwitcher == null) {
            this.mGemDialogSwitcher = new GemDialogSwitcher((Activity) context, onGemAlertDialogClickListener, getScreenName());
        }
        AppTracker.onJokerTimeOut(this, ScreenNames.getScreenType(getScreenName()));
        this.mGemDialogSwitcher.showGemDialog(2, false);
        if (gemFooterCartView != null) {
            hideGemFooter(gemFooterCartView);
        }
    }

    public void showHideGemFooter(GemFooterCartView gemFooterCartView, GemView gemView, boolean z11) {
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            hideGemFooter(gemFooterCartView);
        } else if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().startListening(gemView, z11);
        }
    }

    public void showNonCancelableProgress() {
        try {
            if (this.nonCancelableDialog == null && !isFinishing()) {
                this.nonCancelableDialog = new NonCancelableDialog(this);
            }
            this.nonCancelableDialog.show();
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void showNotification(int i11) {
        NotificationCompat.Builder builder;
        if (getCurrentRunningActivity() != null) {
            Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
            intent.setData(new Uri.Builder().query("s=b").scheme(CobrandedCreditCardFlutterScreenKt.TALABAT_DEEPLINK_PREFIX).build());
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
            NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("3000", "Talabat", 2);
                notificationChannel.setDescription("Gem");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16776961);
                notificationManager.createNotificationChannel(notificationChannel);
                builder = new NotificationCompat.Builder((Context) this, "3000");
            } else {
                builder = new NotificationCompat.Builder(this);
            }
            notificationManager.notify(9999, builder.setContentTitle(getResources().getString(R.string.gem_notification_title)).setContentText(getResources().getString(R.string.gem_order_notification).replace("#", String.format(Locale.US, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i11 / 60)}))).setSound(RingtoneManager.getDefaultUri(2)).setSmallIcon((int) R.mipmap.ic_launcher).setAutoCancel(true).setContentIntent(activity).build());
            new Handler().postDelayed(new z(notificationManager), 29900);
        }
    }

    public void startLodingPopup() {
        try {
            if (this.dialog == null && !isFinishing()) {
                this.dialog = new CustomDialog(this);
            }
            this.dialog.show();
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void stopLodingPopup() {
        try {
            CustomDialog customDialog = this.dialog;
            if (customDialog != null && customDialog.isShowing() && !isFinishing() && !isDestroyed()) {
                this.dialog.dismiss();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void stopNonCancelableLoading() {
        stopLodingPopup();
        try {
            NonCancelableDialog nonCancelableDialog2 = this.nonCancelableDialog;
            if (nonCancelableDialog2 != null && nonCancelableDialog2.isShowing() && !isFinishing() && !isDestroyed()) {
                this.nonCancelableDialog.dismiss();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void trackScreenOpened() {
        if (!isNewTrackingLibraryEnabled().booleanValue() || !isScreenViewEventValid(getScreenName())) {
            trackScreenOpenedOldWay();
        } else if (Customer.getInstance().getCustomerInfo() != null) {
            TalabatTracker talabatTracker = getTalabatTracker();
            String screenName = getScreenName();
            float f11 = Customer.getInstance().getCustomerInfo().talabatCredit;
            talabatTracker.track(new ScreenOpenedEvent(new ScreenOpenedEventModel(screenName, f11, "" + Cart.getInstance().getCartSubTotal(), Cart.getInstance().hasItems(), Customer.getInstance().isLoggedIn(getContext()))));
        }
    }

    public void updateRafVoucherLabel(String str) {
    }

    public void updateVoucherCounter(@Nullable VoucherStateDomainModel voucherStateDomainModel) {
        if (this.sideMenuRecyclerViewAdapter == null) {
            setSideMenu();
        }
        this.sideMenuRecyclerViewAdapter.stopCreditLoading();
        this.sideMenuRecyclerViewAdapter.updateUSerActiveVoucherCount(voucherStateDomainModel);
    }
}
