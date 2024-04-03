package com.talabat.helpers;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ApplicationErrorReport;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.work.Configuration;
import braze_custom_view.factory.CustomIAViewWrapperFactory;
import braze_custom_view.factory.CustomInAppMessageViewFactory;
import brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.CustomInAppMessageManagerListener;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.apptimize.Apptimize;
import com.braze.Braze;
import com.braze.configuration.BrazeConfig;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManagerImpl;
import com.deliveryhero.performance.firebase.FirebasePerformanceProvider;
import com.designsystem.DSConfiguration;
import com.facebook.FacebookSdk;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.hms.framework.common.ContainerUtils;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.R;
import com.talabat.app.App;
import com.talabat.authentication.AuthenticationIntegrator;
import com.talabat.authentication.JwtTokenRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.bugreport.TalabatBugReportImpl;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.callback.TalabatApplicationLifeCycleCallback;
import com.talabat.components.gem.GemApplicationIntegrationKt;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwf.domain.config.IFWFManager;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserExperimentsKeys;
import com.talabat.core.hms.push.presentation.HmsPushService;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.network.TalabatNetworkModuleIntegrator;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import com.talabat.core.network.network.TalabatNetworkModuleSafetyIntegrator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.work.di.WorkCoreLibApi;
import com.talabat.cuisines.CuisinesIntegratorKt;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import com.talabat.firebase.TalabatFirebaseMessagingService;
import com.talabat.fluttercore.channels.LogoutEventCallback;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.integration.FunWithFlagsObservability;
import com.talabat.integration.FunWithFlagsTracking;
import com.talabat.integration.IntegrationsKt;
import com.talabat.lib.Integration;
import com.talabat.logger.CrashlyticsLogger;
import com.talabat.logout.LogoutHandler;
import com.talabat.messaging.MessagingServiceType;
import com.talabat.observability.ObservabilityManagerIntegrator;
import com.talabat.observability.RequestResponseObservabilityManager;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.observability.performance.PerformanceAttributesProvider;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.squads.discovery.AppLaunchTrackingManger;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.splash.core.di.ApplicationComponent;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.presentation.ui.SplashActivity;
import com.talabat.talabatcommon.exception.RxErrorHandlerKt;
import com.talabat.talabatcommon.ports.VendorMenuIntegratorKt;
import com.talabat.talabatcore.application.BaseApplication;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatremoteconfiguration.TalabatRemoteConfigurationKeys;
import com.talabat.userandlocation.choosecountry.ChooseCountryModuleIntegrator;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.CustomerInfo;
import io.flutter.embedding.engine.FlutterEngineCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tracking.AppTracker;
import tracking.TalabatAdjust;
import tracking.firebaseauth.TalabatFirebaseImpl;
import tracking.gtm.TalabatFirebaseWrapper;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;
import tracking.gtm.datalayerLogger.DatalayerModel;
import tracking.perseus.TalabatPerseus;
import xq.b;
import zr.s;
import zr.t;
import zr.u;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u0018J\b\u0010K\u001a\u000203H\u0002J\b\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020MH\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002J4\u0010Q\u001a\u00020M2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020S2\b\b\u0002\u0010V\u001a\u00020S2\b\b\u0002\u0010W\u001a\u000203H\u0003J\b\u0010X\u001a\u00020MH\u0003J\b\u0010Y\u001a\u00020MH\u0002J\u0006\u0010Z\u001a\u00020MJ!\u0010[\u001a\u0002H\\\"\u0004\b\u0000\u0010\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u0002H\\0^H\u0016¢\u0006\u0002\u0010_J\b\u0010`\u001a\u00020MH\u0002J\u0013\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bH\u0002¢\u0006\u0002\u0010dJ&\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\u0006\u0010k\u001a\u00020\u0018H\u0002J\b\u0010l\u001a\u00020SH\u0002J\b\u0010m\u001a\u00020nH\u0016J&\u0010o\u001a\u00020\u00182\u0006\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\u0006\u0010k\u001a\u00020\u0018H\u0002J\b\u0010p\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u0002032\b\u0010s\u001a\u0004\u0018\u00010tJ\b\u0010u\u001a\u00020MH\u0002J\b\u0010v\u001a\u00020MH\u0002J\b\u0010w\u001a\u00020MH\u0007J\u000e\u0010x\u001a\u00020M2\u0006\u0010y\u001a\u00020SJ\u0006\u0010z\u001a\u00020MJ\u0006\u0010{\u001a\u00020MJ\u0006\u0010|\u001a\u00020MJ\b\u0010}\u001a\u00020MH\u0002J\b\u0010~\u001a\u00020MH\u0002J\b\u0010\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\u0007\u0010\u0001\u001a\u00020MJ\t\u0010\u0001\u001a\u00020MH\u0016J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u000203H\u0002J\u0012\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020SH\u0002J\u0012\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020SH\u0002J'\u0010\u0001\u001a\u0002032\u0006\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\u0006\u0010k\u001a\u00020\u0018H\u0002J\t\u0010\u0001\u001a\u000203H\u0016J\t\u0010\u0001\u001a\u000203H\u0002J\t\u0010\u0001\u001a\u00020MH\u0016J\t\u0010\u0001\u001a\u00020MH\u0016J\t\u0010\u0001\u001a\u00020MH\u0016J\u0006\u00102\u001a\u00020MJ\u0013\u0010\u0001\u001a\u00020M2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010J\u001a\u00020\u0018J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\u0007\u0010\u0001\u001a\u00020MJ\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\u0013\u0010\u0001\u001a\u00020M2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010\u0001\u001a\u00020MH\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020&XD¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010C\u001a\u00020D8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006 \u0001"}, d2 = {"Lcom/talabat/helpers/TalabatApplication;", "Lcom/talabat/talabatcore/application/BaseApplication;", "Lcom/talabat/core/di/ApiContainer;", "Lcom/talabat/gem/integration/GemAccessor;", "Landroidx/work/Configuration$Provider;", "Lcom/talabat/fluttercore/channels/LogoutEventCallback;", "()V", "app", "Lcom/talabat/app/App;", "getApp", "()Lcom/talabat/app/App;", "appComponent", "Lcom/talabat/splash/core/di/ApplicationComponent;", "getAppComponent", "()Lcom/talabat/splash/core/di/ApplicationComponent;", "appComponent$delegate", "Lkotlin/Lazy;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "getConfigurationRemoteCoreLibApi", "()Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "setConfigurationRemoteCoreLibApi", "(Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;)V", "currentPausedActivity", "", "customerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "getCustomerInfoRepository", "()Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "setCustomerInfoRepository", "(Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;)V", "fWFManager", "Lcom/talabat/core/fwf/domain/config/IFWFManager;", "getFWFManager", "()Lcom/talabat/core/fwf/domain/config/IFWFManager;", "setFWFManager", "(Lcom/talabat/core/fwf/domain/config/IFWFManager;)V", "lastOpenedTime", "", "messagingServiceType", "Lcom/talabat/messaging/MessagingServiceType;", "getMessagingServiceType", "()Lcom/talabat/messaging/MessagingServiceType;", "setMessagingServiceType", "(Lcom/talabat/messaging/MessagingServiceType;)V", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "pauseBannerForNextScreen", "", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "getSplashPreferences", "()Lcom/talabat/splash/data/preferences/SplashPreferences;", "setSplashPreferences", "(Lcom/talabat/splash/data/preferences/SplashPreferences;)V", "thirtyMinutes", "trackedEventsPerRoute", "Lorg/json/JSONArray;", "voucherCampaignDeeplinkUseCase", "Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignDeeplinkUseCase;", "getVoucherCampaignDeeplinkUseCase", "()Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignDeeplinkUseCase;", "setVoucherCampaignDeeplinkUseCase", "(Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignDeeplinkUseCase;)V", "canCountAsAppOpen", "screenName", "checkIfLiveAutomation", "clearGoogleMapZoomCache", "", "createAdjust", "createCustomInAppMessageManagerListener", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/CustomInAppMessageManagerListener;", "createNotificationChannel", "id", "", "name", "description", "priority", "isNeedVibration", "createNotificationChannels", "disableApptimize", "forceUnregisterComponentCallbacks", "getFeature", "T", "key", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getFireBaseToken", "getFwfKeys", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "()[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getJwt", "singleThread", "Lkotlinx/coroutines/CoroutineDispatcher;", "jwtTokenRepository", "Lkotlin/Function0;", "Lcom/talabat/authentication/JwtTokenRepository;", "value", "getLastSelectedCountry", "getPerformanceTracker", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "getRefreshJwt", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "handleDeeplink", "uri", "Landroid/net/Uri;", "initAppBasicInfo", "initDataLayerLogger", "initGoogleClientId", "initialiseFunWithFlags", "lastSelectedCountry", "initialiseInstabug", "initialiseTalabatNetworkModuleIntegrator", "initialiseTalabatNetworkModuleSafetyIntegrator", "initializeBraze", "initializeFacebookSdk", "initializePerseus", "initializeTalabatVolley", "initializeVendorMenuFlutterIntegration", "initializeWithDependencyInjectionComplete", "injectMembers", "integrateBrazeWithAdjust", "isAutomation", "isChatApplicableCountry", "countryId", "isCountrySelectedByTheUser", "isJwtFeatureEnable", "isRobolectric", "isUserAuthenticationApiMigrationExperimentEnabled", "onCreate", "onLogout", "onLowMemory", "registerComponentCallbacks", "callback", "Landroid/content/ComponentCallbacks;", "registerFCMTokenToChatProvider", "registerHMSTokenToBraze", "setCurrentPausedActivity", "setTrackingAndObservability", "setupAuthenticationTokenIntegrator", "setupFwfIntegrator", "startAppTracking", "stopAppTracking", "subscribeToTheChangesInCustomerInfo", "subscribeToTheChangesInSelectedCountryId", "unregisterComponentCallbacks", "updateOnCountryChangedListener", "Companion", "ComponentCallbacksBehavioralAdjustmentToolIcs", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TalabatApplication extends BaseApplication implements ApiContainer, GemAccessor, Configuration.Provider, LogoutEventCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TALABAT_PERSEUS_ENTITY = "talabat";
    @NotNull
    private static final String TIME_EVENT_APP_CLASS = "TIME_EVENT_APP_CLASS";
    /* access modifiers changed from: private */
    @Nullable
    public static Context context;
    /* access modifiers changed from: private */
    @Nullable
    public static TalabatApplication instance;
    @JvmField
    public static boolean sIsInstrumentation;
    @NotNull
    private final App app;
    @NotNull
    private final Lazy appComponent$delegate;
    @Inject
    public MutableConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
    @NotNull
    private String currentPausedActivity = "";
    @Inject
    public CustomerInfoRepository customerInfoRepository;
    @Inject
    public IFWFManager fWFManager;
    private long lastOpenedTime;
    @Inject
    public MessagingServiceType messagingServiceType;
    @NotNull
    private final Lazy notificationManager$delegate;
    private boolean pauseBannerForNextScreen;
    @Inject
    public IScreenTracker screenTracker;
    @Inject
    public SplashPreferences splashPreferences;
    private final long thirtyMinutes = 1800000;
    /* access modifiers changed from: private */
    @NotNull
    public JSONArray trackedEventsPerRoute;
    @Inject
    public VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/helpers/TalabatApplication$Companion;", "", "()V", "TALABAT_PERSEUS_ENTITY", "", "TIME_EVENT_APP_CLASS", "<set-?>", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "Lcom/talabat/helpers/TalabatApplication;", "instance", "getInstance", "()Lcom/talabat/helpers/TalabatApplication;", "sIsInstrumentation", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Context getContext() {
            return TalabatApplication.context;
        }

        @Nullable
        public final synchronized TalabatApplication getInstance() {
            return TalabatApplication.instance;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/helpers/TalabatApplication$ComponentCallbacksBehavioralAdjustmentToolIcs;", "", "()V", "mCallbacks", "Ljava/util/WeakHashMap;", "Landroid/content/ComponentCallbacks;", "Landroid/app/ApplicationErrorReport$CrashInfo;", "mSuspended", "", "onComponentCallbacksRegistered", "", "callback", "onComponentCallbacksUnregistered", "unregisterAll", "context", "Landroid/content/Context;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @TargetApi(14)
    public static final class ComponentCallbacksBehavioralAdjustmentToolIcs {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static ComponentCallbacksBehavioralAdjustmentToolIcs INSTANCE = new ComponentCallbacksBehavioralAdjustmentToolIcs();
        @NotNull
        private final WeakHashMap<ComponentCallbacks, ApplicationErrorReport.CrashInfo> mCallbacks = new WeakHashMap<>();
        private boolean mSuspended;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/helpers/TalabatApplication$ComponentCallbacksBehavioralAdjustmentToolIcs$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/helpers/TalabatApplication$ComponentCallbacksBehavioralAdjustmentToolIcs;", "getINSTANCE$com_talabat_talabat_talabat", "()Lcom/talabat/helpers/TalabatApplication$ComponentCallbacksBehavioralAdjustmentToolIcs;", "setINSTANCE$com_talabat_talabat_talabat", "(Lcom/talabat/helpers/TalabatApplication$ComponentCallbacksBehavioralAdjustmentToolIcs;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ComponentCallbacksBehavioralAdjustmentToolIcs getINSTANCE$com_talabat_talabat_talabat() {
                return ComponentCallbacksBehavioralAdjustmentToolIcs.INSTANCE;
            }

            public final void setINSTANCE$com_talabat_talabat_talabat(@NotNull ComponentCallbacksBehavioralAdjustmentToolIcs componentCallbacksBehavioralAdjustmentToolIcs) {
                Intrinsics.checkNotNullParameter(componentCallbacksBehavioralAdjustmentToolIcs, "<set-?>");
                ComponentCallbacksBehavioralAdjustmentToolIcs.INSTANCE = componentCallbacksBehavioralAdjustmentToolIcs;
            }
        }

        public final void onComponentCallbacksRegistered(@NotNull ComponentCallbacks componentCallbacks) {
            Intrinsics.checkNotNullParameter(componentCallbacks, "callback");
            ApplicationErrorReport.CrashInfo crashInfo = new ApplicationErrorReport.CrashInfo(new Throwable("Callback registered here."));
            if (!this.mSuspended) {
                String name2 = componentCallbacks.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "callback.javaClass.name");
                if (StringsKt__StringsJVMKt.startsWith$default(name2, MobileAds.ERROR_DOMAIN, false, 2, (Object) null)) {
                    this.mCallbacks.put(componentCallbacks, crashInfo);
                }
            }
        }

        public final void onComponentCallbacksUnregistered(@NotNull ComponentCallbacks componentCallbacks) {
            Intrinsics.checkNotNullParameter(componentCallbacks, "callback");
            if (!this.mSuspended) {
                this.mCallbacks.remove(componentCallbacks);
            }
        }

        public final void unregisterAll(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mSuspended = true;
            for (Map.Entry<ComponentCallbacks, ApplicationErrorReport.CrashInfo> key : this.mCallbacks.entrySet()) {
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) key.getKey();
                if (componentCallbacks != null) {
                    try {
                        context.unregisterComponentCallbacks(componentCallbacks);
                    } catch (Exception unused) {
                    }
                }
            }
            this.mCallbacks.clear();
            this.mSuspended = false;
        }
    }

    public TalabatApplication() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.appComponent$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatApplication$appComponent$2(this));
        this.notificationManager$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatApplication$notificationManager$2(this));
        this.trackedEventsPerRoute = new JSONArray();
        this.app = new App(this);
    }

    /* access modifiers changed from: private */
    public final boolean checkIfLiveAutomation() {
        if (!sIsInstrumentation || !Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "prod")) {
            return false;
        }
        return true;
    }

    private final void clearGoogleMapZoomCache() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("google_bug_154855417", 0);
            if (!sharedPreferences.contains("fixed")) {
                File file = new File(getFilesDir(), "ZoomTables.data");
                File file2 = new File(getFilesDir(), "SavedClientParameters.data.cs");
                File filesDir = getFilesDir();
                String packageName = getPackageName();
                File file3 = new File(filesDir, "DATA_ServerControlledParametersManager.data.v1." + packageName);
                file.delete();
                file2.delete();
                file3.delete();
                sharedPreferences.edit().putBoolean("fixed", true).apply();
            }
        } catch (Exception unused) {
        }
    }

    private final void createAdjust() {
        String str;
        String str2;
        if (getMessagingServiceType() == MessagingServiceType.HUAWEI) {
            str = getResources().getString(R.string.adjust_app_token_huawei);
        } else {
            str = getResources().getString(R.string.adjust_app_token);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (messagingServiceType…just_app_token)\n        }");
        if (BuildConfigType.ThirdPartyToolsProductionMode()) {
            str2 = AdjustConfig.ENVIRONMENT_PRODUCTION;
        } else {
            str2 = AdjustConfig.ENVIRONMENT_SANDBOX;
        }
        AdjustConfig adjustConfig = new AdjustConfig(this, str, str2);
        adjustConfig.setAppSecret(1, 569470749, 2060165007, 309290968, 1047681169);
        adjustConfig.setOnAttributionChangedListener(new t(this));
        adjustConfig.setOnDeeplinkResponseListener(new u(this));
        integrateBrazeWithAdjust();
        Adjust.onCreate(adjustConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: createAdjust$lambda-7  reason: not valid java name */
    public static final void m10626createAdjust$lambda7(TalabatApplication talabatApplication, AdjustAttribution adjustAttribution) {
        Intrinsics.checkNotNullParameter(talabatApplication, "this$0");
        if (adjustAttribution != null) {
            String adjustAttribution2 = adjustAttribution.toString();
            Intrinsics.checkNotNullExpressionValue(adjustAttribution2, "attribution.toString()");
            if ((!StringsKt__StringsJVMKt.isBlank(adjustAttribution2)) && !Intrinsics.areEqual((Object) adjustAttribution.toString(), (Object) "N/A")) {
                GlobalDataModel.adjustAttribution = adjustAttribution;
                AppTracker.onAppInstalled(talabatApplication.getApplicationContext(), adjustAttribution);
                AppTracker.onAttributionChanged(talabatApplication.getApplicationContext());
                if (GlobalDataModel.isFirstTimeUser) {
                    GlobalDataModel.isFirstTimeUser = false;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createAdjust$lambda-8  reason: not valid java name */
    public static final boolean m10627createAdjust$lambda8(TalabatApplication talabatApplication, Uri uri) {
        Intrinsics.checkNotNullParameter(talabatApplication, "this$0");
        return talabatApplication.handleDeeplink(uri);
    }

    private final CustomInAppMessageManagerListener createCustomInAppMessageManagerListener() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(CustomInAppMessageManagerListener.Companion.initCustomIAMListener(context, ((FeatureFlagCoreLibApi) getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = null;
        }
        return (CustomInAppMessageManagerListener) obj;
    }

    @SuppressLint({"NewApi"})
    private final void createNotificationChannel(int i11, int i12, int i13, int i14, boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(getString(i11), getString(i12), i14);
            notificationChannel.setDescription(getString(i13));
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(getResources().getColor(R.color.ds_primary_100));
            notificationChannel.enableVibration(z11);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            getNotificationManager().createNotificationChannel(notificationChannel);
        }
    }

    public static /* synthetic */ void createNotificationChannel$default(TalabatApplication talabatApplication, int i11, int i12, int i13, int i14, boolean z11, int i15, Object obj) {
        if (obj == null) {
            if ((i15 & 8) != 0) {
                i14 = 3;
            }
            int i16 = i14;
            if ((i15 & 16) != 0) {
                z11 = false;
            }
            talabatApplication.createNotificationChannel(i11, i12, i13, i16, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNotificationChannel");
    }

    @SuppressLint({"NewApi"})
    private final void createNotificationChannels() {
        createNotificationChannel$default(this, R.string.prospect_channel_id, R.string.prospect_channel_name, R.string.prospect_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.lifecycle_engagement_channel_id, R.string.lifecycle_engagement_channel_name, R.string.lifecycle_engagement_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.churning_winback_channel_id, R.string.churning_winback_channel_name, R.string.churning_winback_channel_name_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.adhoc_restaurant_deals_channel_id, R.string.adhoc_restaurant_deals_channel_name, R.string.adhoc_restaurant_deals_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.adhoc_marketing_vouchers_channel_id, R.string.adhoc_marketing_vouchers_channel_name, R.string.adhoc_marketing_vouchers_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.abandonments_channel_id, R.string.abandonments_channel_name, R.string.abandonments_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.app_feature_updates_channel_id, R.string.app_feature_updates_channel_name, R.string.app_feature_updates_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel(R.string.transactional_channel_id, R.string.transactional_channel_name, R.string.transactional_channel_desc, 4, true);
        createNotificationChannel$default(this, R.string.talabatgo_channel_id, R.string.talabatgo_channel_name, R.string.talabatgo_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.brand_updates_channel_id, R.string.brand_updates_channel_name, R.string.brand_updates_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.general_channel_id, R.string.general_channel_name, R.string.general_channel_desc, 0, false, 24, (Object) null);
        createNotificationChannel$default(this, R.string.chat_channel_id, R.string.chat_channel_name, R.string.chat_channel_desc, 0, false, 24, (Object) null);
    }

    private final void disableApptimize() {
        if (((FeatureFlagCoreLibApi) getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.DISABLE_APPTIMIZE_SDK, false)) {
            Apptimize.disable();
        }
    }

    private final void getFireBaseToken() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        if (TalabatUtils.isNullOrEmpty(defaultSharedPreferences.getString(GlobalConstants.PrefsConstants.ADJUST_FIRE_BASE_TOKEN, ""))) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new s(edit));
        } else {
            Adjust.setPushToken(defaultSharedPreferences.getString(GlobalConstants.PrefsConstants.ADJUST_FIRE_BASE_TOKEN, ""), context);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getFireBaseToken$lambda-9  reason: not valid java name */
    public static final void m10628getFireBaseToken$lambda9(SharedPreferences.Editor editor, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful() && task.getResult() != null && !TalabatUtils.isNullOrEmpty((String) task.getResult())) {
            Adjust.setPushToken((String) task.getResult(), context);
            editor.putString(GlobalConstants.PrefsConstants.ADJUST_FIRE_BASE_TOKEN, (String) task.getResult());
            editor.apply();
        }
    }

    private final FWFKey[] getFwfKeys() {
        ArrayList arrayList = new ArrayList();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) TalabatFeatureFlagConstants.Companion.getFEATURE_KEYS());
        boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) TalabatExperimentConstants.Companion.getFWF_EXPERIMENT_KEYS());
        boolean unused3 = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) TalabatRemoteConfigurationKeys.INSTANCE.getREMOTE_CONFIGURATION_KEYS());
        List unused4 = CollectionsKt___CollectionsKt.distinct(arrayList);
        Object[] array = arrayList.toArray(new FWFKey[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (FWFKey[]) array;
    }

    /* access modifiers changed from: private */
    public final String getJwt(CoroutineDispatcher coroutineDispatcher, Function0<? extends JwtTokenRepository> function0, String str) {
        String str2;
        if (!isUserAuthenticationApiMigrationExperimentEnabled() || (str2 = (String) BuildersKt.runBlocking(coroutineDispatcher, new TalabatApplication$getJwt$1(function0, str, (Continuation<? super TalabatApplication$getJwt$1>) null))) == null) {
            return "";
        }
        return str2;
    }

    private final int getLastSelectedCountry() {
        SharedPreferences sharedPreferences;
        Country selectedCountry = ((ConfigurationLocalCoreLibApi) getFeature(ConfigurationLocalCoreLibApi.class)).getRepository().selectedCountry();
        if (selectedCountry != Country.UNDEFINED) {
            return selectedCountry.getCountryId();
        }
        Context context2 = context;
        if (context2 == null || (sharedPreferences = context2.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0)) == null) {
            return -1;
        }
        return sharedPreferences.getInt(GlobalConstants.PrefsConstants.COUNTRY_ID, -1);
    }

    private final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getRefreshJwt(CoroutineDispatcher coroutineDispatcher, Function0<? extends JwtTokenRepository> function0, String str) {
        String str2;
        if (!isUserAuthenticationApiMigrationExperimentEnabled() || (str2 = (String) BuildersKt.runBlocking(coroutineDispatcher, new TalabatApplication$getRefreshJwt$1(function0, str, (Continuation<? super TalabatApplication$getRefreshJwt$1>) null))) == null) {
            return "";
        }
        return str2;
    }

    private final void initAppBasicInfo() {
        GlobalConstants.Version = getResources().getString(R.string.app_version);
    }

    private final void initDataLayerLogger() {
        if (DatalayerModel.INSTANCE.isLoggingEnabled()) {
            new TalabatFirebaseImpl().signInWithEmailAndPassword();
        }
    }

    private final void initializeBraze() {
        String str;
        Braze.Companion companion = Braze.Companion;
        companion.configure(this, (BrazeConfig) null);
        CustomInAppMessageManagerListener createCustomInAppMessageManagerListener = createCustomInAppMessageManagerListener();
        BrazeInAppMessageManager.Companion companion2 = BrazeInAppMessageManager.Companion;
        companion2.getInstance().setCustomInAppMessageManagerListener(createCustomInAppMessageManagerListener);
        BrazeInAppMessageManager instance2 = companion2.getInstance();
        instance2.setCustomInAppMessageViewFactory(new CustomInAppMessageViewFactory());
        instance2.setCustomInAppMessageViewWrapperFactory(new CustomIAViewWrapperFactory());
        BrazeConfig.Builder builder = new BrazeConfig.Builder();
        if (getMessagingServiceType() == MessagingServiceType.HUAWEI) {
            str = getResources().getString(R.string.com_braze_api_key_huawei);
        } else {
            str = getResources().getString(R.string.com_braze_api_key_google);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (messagingServiceType…google)\n                }");
        builder.setApiKey(str);
        builder.setPushDeepLinkBackStackActivityEnabled(true);
        builder.setPushHtmlRenderingEnabled(true);
        builder.setPushDeepLinkBackStackActivityClass(SplashActivity.class);
        String string = getResources().getString(R.string.general_channel_name);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.general_channel_name)");
        builder.setDefaultNotificationChannelName(string);
        String string2 = getResources().getString(R.string.general_channel_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.general_channel_desc)");
        builder.setDefaultNotificationChannelDescription(string2);
        companion.configure(this, builder.build());
        registerActivityLifecycleCallbacks(new TalabatApplicationLifeCycleCallback());
    }

    private final void initializeFacebookSdk() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        FacebookSdk.sdkInitialize(applicationContext);
    }

    private final void initializePerseus() {
        TalabatPerseus.Companion companion = TalabatPerseus.Companion;
        companion.with(new TalabatApplication$initializePerseus$1(this));
        Country selectedCountry = ((ConfigurationLocalCoreLibApi) getFeature(ConfigurationLocalCoreLibApi.class)).getRepository().selectedCountry();
        companion.setObservability(((ObservabilityCoreLibApi) getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager());
        String appName = GlobalDataModel.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "getAppName()");
        String appPAckageID = GlobalDataModel.getAppPAckageID();
        Intrinsics.checkNotNullExpressionValue(appPAckageID, "getAppPAckageID()");
        String string = getResources().getString(R.string.app_version);
        Intrinsics.checkNotNullExpressionValue(string, "this.resources\n         …ata.R.string.app_version)");
        String baseUrlForPerseus = BASEURLS.getBaseUrlForPerseus();
        Intrinsics.checkNotNullExpressionValue(baseUrlForPerseus, "getBaseUrlForPerseus()");
        String uaIDForPerseus = GlobalDataModel.getUaIDForPerseus();
        Intrinsics.checkNotNullExpressionValue(uaIDForPerseus, "getUaIDForPerseus()");
        String str = GlobalDataModel.googleAdId;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String adid = Adjust.getAdid();
        if (adid != null) {
            str2 = adid;
        }
        companion.configurePerseus(appName, appPAckageID, "talabat", string, false, baseUrlForPerseus, uaIDForPerseus, str, str2, selectedCountry, "", ((DispatcherCoreLibApi) getFeature(DispatcherCoreLibApi.class)).getCoroutineDispatchersFactory(), this);
    }

    private final void initializeTalabatVolley() {
        TalabatVolley.initializeRequestQeue(this);
    }

    private final void initializeVendorMenuFlutterIntegration() {
        VendorMenuIntegratorKt.VendorMenuFlutterIntegration(TalabatApplication$initializeVendorMenuFlutterIntegration$1.INSTANCE);
    }

    private final void integrateBrazeWithAdjust() {
        LogManager.debug("Pass device ID of Braze to Adjust.");
        Braze.Companion companion = Braze.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        TalabatAdjust.integrateWithBraze(companion.getInstance(applicationContext).getDeviceId());
    }

    /* access modifiers changed from: private */
    public final boolean isAutomation() {
        return sIsInstrumentation;
    }

    /* access modifiers changed from: private */
    public final boolean isChatApplicableCountry(int i11) {
        if (!isCountrySelectedByTheUser(i11) || i11 == Country.KSA.getCountryId() || i11 == Country.LEBANON.getCountryId()) {
            return false;
        }
        return true;
    }

    private final boolean isCountrySelectedByTheUser(int i11) {
        return i11 != Country.UNDEFINED.getCountryId();
    }

    /* access modifiers changed from: private */
    public final boolean isJwtFeatureEnable(CoroutineDispatcher coroutineDispatcher, Function0<? extends JwtTokenRepository> function0, String str) {
        if (isUserAuthenticationApiMigrationExperimentEnabled()) {
            return false | ((Boolean) BuildersKt.runBlocking(coroutineDispatcher, new TalabatApplication$isJwtFeatureEnable$jwtFeatureEnabled$1(function0, str, (Continuation<? super TalabatApplication$isJwtFeatureEnable$jwtFeatureEnabled$1>) null))).booleanValue();
        }
        return false;
    }

    private final boolean isUserAuthenticationApiMigrationExperimentEnabled() {
        return !Intrinsics.areEqual((Object) ((ExperimentCoreLibApi) getFeature(ExperimentCoreLibApi.class)).getExperimentProvider().getStringVariant(UserExperimentsKeys.EXP_USER_AUTHENTICATION_API_MIGRATION, "Variation2", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control");
    }

    /* access modifiers changed from: private */
    public final void registerFCMTokenToChatProvider() {
        TalabatFirebaseMessagingService.Companion.getFCMToken(TalabatApplication$registerFCMTokenToChatProvider$1.INSTANCE, TalabatApplication$registerFCMTokenToChatProvider$2.INSTANCE);
    }

    private final void registerHMSTokenToBraze() {
        startService(new Intent(this, HmsPushService.class));
    }

    private final void setTrackingAndObservability() {
        OKHttpBuilder.INSTANCE.setTrackingAndObservability(new FunWithFlagsObservability(), new FunWithFlagsTracking((TalabatFirebaseWrapper) null, 1, (DefaultConstructorMarker) null), new RequestResponseObservabilityManager());
        TalabatVolley.setTrackingAndObservability(new FunWithFlagsObservability(), new FunWithFlagsTracking((TalabatFirebaseWrapper) null, 1, (DefaultConstructorMarker) null));
    }

    private final void setupAuthenticationTokenIntegrator() {
        TalabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1 talabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1 = new TalabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1(this);
        LoggedInHelper.INSTANCE.setTokenExists(new TalabatApplication$setupAuthenticationTokenIntegrator$1(this, talabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1));
        TalabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1 talabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1 = new TalabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1(this);
        TalabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1 talabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1 = new TalabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1(talabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1);
        CoroutineDispatcher single = ((DispatcherCoreLibApi) getFeature(DispatcherCoreLibApi.class)).getCoroutineDispatchersFactory().single();
        TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
        talabatNetworkModuleJWTTokenIntegrator.setJWTFeatureEnable(new TalabatApplication$setupAuthenticationTokenIntegrator$2$1(this, single, talabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1));
        talabatNetworkModuleJWTTokenIntegrator.setObtainAccessToken(new TalabatApplication$setupAuthenticationTokenIntegrator$2$2(this, single, talabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1));
        talabatNetworkModuleJWTTokenIntegrator.setRefreshAndObtainAccessToken(new TalabatApplication$setupAuthenticationTokenIntegrator$2$3(this, single, talabatApplication$setupAuthenticationTokenIntegrator$jwtTokenRepository$1));
        talabatNetworkModuleJWTTokenIntegrator.setGetAccessToken(new TalabatApplication$setupAuthenticationTokenIntegrator$2$4(talabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1));
        talabatNetworkModuleJWTTokenIntegrator.setGetDeviceToken(new TalabatApplication$setupAuthenticationTokenIntegrator$2$5(talabatNetworkModuleJWTTokenIntegrator, talabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1));
        talabatNetworkModuleJWTTokenIntegrator.setGetTokenType(new TalabatApplication$setupAuthenticationTokenIntegrator$2$6(talabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1));
        talabatNetworkModuleJWTTokenIntegrator.setTokenAvailable(new TalabatApplication$setupAuthenticationTokenIntegrator$2$7(talabatNetworkModuleJWTTokenIntegrator, talabatApplication$setupAuthenticationTokenIntegrator$tokenResult$1));
        talabatNetworkModuleJWTTokenIntegrator.setGlobalEntityId(new TalabatApplication$setupAuthenticationTokenIntegrator$2$8(this));
        AuthenticationIntegrator.INSTANCE.setOnLegacyTokenReceived(TalabatApplication$setupAuthenticationTokenIntegrator$3.INSTANCE);
    }

    private final void setupFwfIntegrator() {
        FunWithFlags funWithFlags = FunWithFlags.INSTANCE;
        funWithFlags.setAppVersionProvider(TalabatApplication$setupFwfIntegrator$1.INSTANCE);
        funWithFlags.setCountryThreeLetterCodeProvider(new TalabatApplication$setupFwfIntegrator$2(this));
        funWithFlags.setCustomerIdProvider(TalabatApplication$setupFwfIntegrator$3.INSTANCE);
        funWithFlags.setCustomerEmailProvider(TalabatApplication$setupFwfIntegrator$4.INSTANCE);
        funWithFlags.setLanguageProvider(TalabatApplication$setupFwfIntegrator$5.INSTANCE);
    }

    private final void stopAppTracking() {
        if (!isRobolectric()) {
            PerformanceTracker.INSTANCE.stopTrace("applicationClassInitialisation");
            TimeTrackerImplementation.stopTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_APP_CLASS, 0, 2, (Object) null);
            AppLaunchTrackingManger.INSTANCE.trackEvent("sdk_initialization_time", Calendar.getInstance().getTimeInMillis());
        }
    }

    private final void subscribeToTheChangesInCustomerInfo() {
        Customer.getInstance().getCustomerInfoSubject().subscribe(new TalabatApplication$subscribeToTheChangesInCustomerInfo$1());
    }

    private final void subscribeToTheChangesInSelectedCountryId() {
        GlobalDataModel.getSelectedCountryIdObservable().subscribe(new TalabatApplication$subscribeToTheChangesInSelectedCountryId$1(this));
    }

    private final void updateOnCountryChangedListener() {
        ChooseCountryModuleIntegrator.INSTANCE.setOnCountryChange(new TalabatApplication$updateOnCountryChangedListener$1(this));
    }

    public final boolean canCountAsAppOpen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        if (TalabatUtils.isNullOrEmpty(this.currentPausedActivity) || !Intrinsics.areEqual((Object) str, (Object) this.currentPausedActivity) || this.lastOpenedTime <= 0 || System.currentTimeMillis() - this.lastOpenedTime <= this.thirtyMinutes) {
            return false;
        }
        return true;
    }

    public final void forceUnregisterComponentCallbacks() {
        ComponentCallbacksBehavioralAdjustmentToolIcs.Companion.getINSTANCE$com_talabat_talabat_talabat().unregisterAll(this);
    }

    @NotNull
    public App getApp() {
        return this.app;
    }

    @NotNull
    public final ApplicationComponent getAppComponent() {
        return (ApplicationComponent) this.appComponent$delegate.getValue();
    }

    @NotNull
    public final MutableConfigurationRemoteCoreLibApi getConfigurationRemoteCoreLibApi() {
        MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi = this.configurationRemoteCoreLibApi;
        if (mutableConfigurationRemoteCoreLibApi != null) {
            return mutableConfigurationRemoteCoreLibApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationRemoteCoreLibApi");
        return null;
    }

    @NotNull
    public final CustomerInfoRepository getCustomerInfoRepository() {
        CustomerInfoRepository customerInfoRepository2 = this.customerInfoRepository;
        if (customerInfoRepository2 != null) {
            return customerInfoRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerInfoRepository");
        return null;
    }

    @NotNull
    public final IFWFManager getFWFManager() {
        IFWFManager iFWFManager = this.fWFManager;
        if (iFWFManager != null) {
            return iFWFManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fWFManager");
        return null;
    }

    public <T> T getFeature(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "key");
        return getApp().getFeature(cls);
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

    @NotNull
    public final MessagingServiceType getMessagingServiceType() {
        MessagingServiceType messagingServiceType2 = this.messagingServiceType;
        if (messagingServiceType2 != null) {
            return messagingServiceType2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("messagingServiceType");
        return null;
    }

    @NotNull
    public PerformanceTrackingManager getPerformanceTracker() {
        FirebasePerformanceProvider.initialize(this);
        return new PerformanceTrackingManagerImpl(CollectionsKt__CollectionsJVMKt.listOf(FirebasePerformanceProvider.getInstance()), new PerformanceAttributesProvider(), new PerformanceTrackingManager.Params(true));
    }

    @NotNull
    public IScreenTracker getScreenTracker() {
        IScreenTracker iScreenTracker = this.screenTracker;
        if (iScreenTracker != null) {
            return iScreenTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        return null;
    }

    @NotNull
    public final SplashPreferences getSplashPreferences() {
        SplashPreferences splashPreferences2 = this.splashPreferences;
        if (splashPreferences2 != null) {
            return splashPreferences2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("splashPreferences");
        return null;
    }

    @NotNull
    public final VoucherCampaignDeeplinkUseCase getVoucherCampaignDeeplinkUseCase() {
        VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase2 = this.voucherCampaignDeeplinkUseCase;
        if (voucherCampaignDeeplinkUseCase2 != null) {
            return voucherCampaignDeeplinkUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("voucherCampaignDeeplinkUseCase");
        return null;
    }

    @NotNull
    public Configuration getWorkManagerConfiguration() {
        Configuration workManagerConfiguration = ((WorkCoreLibApi) getFeature(WorkCoreLibApi.class)).getConfigurationProvider().getWorkManagerConfiguration();
        Intrinsics.checkNotNullExpressionValue(workManagerConfiguration, "getFeature(WorkCoreLibAp….workManagerConfiguration");
        return workManagerConfiguration;
    }

    public final boolean handleDeeplink(@Nullable Uri uri) {
        String[] strArr;
        String query;
        List split$default;
        if (uri == null || (query = uri.getQuery()) == null || (split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null)) == null) {
            strArr = null;
        } else {
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
        }
        if (getVoucherCampaignDeeplinkUseCase().invoke(strArr) || uri == null) {
            return false;
        }
        GlobalDataModel.ADJUST_DEEPLINK.DIFFERED_DEEPLINK = uri;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 == null) goto L_0x0013;
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initGoogleClientId() {
        /*
            r2 = this;
            java.lang.String r0 = com.talabat.helpers.GlobalDataModel.encryptedUserId
            if (r0 == 0) goto L_0x0013
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            if (r1 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 != 0) goto L_0x001b
        L_0x0013:
            android.content.Context r0 = r2.getApplicationContext()
            java.lang.String r0 = com.talabat.helpers.TalabatUtils.getTheFirstDeviceID(r0)
        L_0x001b:
            com.talabat.data.googleclientid.GoogleClientIdLocalStorage r1 = com.talabat.data.googleclientid.GoogleClientIdLocalStorage.INSTANCE
            r1.setGoogleClientId(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.TalabatApplication.initGoogleClientId():void");
    }

    public final void initialiseFunWithFlags(int i11) {
        String str;
        Integer num;
        if (!isRobolectric()) {
            CustomerInfo customerInfo = (CustomerInfo) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new TalabatApplication$initialiseFunWithFlags$customerInfo$1(this, (Continuation<? super TalabatApplication$initialiseFunWithFlags$customerInfo$1>) null), 1, (Object) null);
            if (i11 != -1) {
                ((MutableConfigurationLocalCoreLibApi) getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository().setSelectedCountry(i11);
            }
            IFWFManager fWFManager2 = getFWFManager();
            if (customerInfo != null) {
                str = customerInfo.email;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (customerInfo != null) {
                num = Integer.valueOf(customerInfo.f13850id);
            } else {
                num = null;
            }
            fWFManager2.initialize(str2, String.valueOf(num), TalabatPerseus.Companion.getMyClientId(getApplicationContext()), getFwfKeys(), new FunWithFlagsObservability(), new FunWithFlagsTracking((TalabatFirebaseWrapper) null, 1, (DefaultConstructorMarker) null), new TalabatApplication$initialiseFunWithFlags$1(this));
        }
    }

    public final void initialiseInstabug() {
        if (!isAutomation() && !isRobolectric()) {
            boolean z11 = true;
            CustomerInfo customerInfo = (CustomerInfo) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new TalabatApplication$initialiseInstabug$customerInfo$1(this, (Continuation<? super TalabatApplication$initialiseInstabug$customerInfo$1>) null), 1, (Object) null);
            if (customerInfo == null || !customerInfo.isTalabatEmail()) {
                z11 = false;
            }
            if (z11) {
                TalabatBugReportManager talabatBugReportManager = TalabatBugReportManager.INSTANCE;
                talabatBugReportManager.setTalabatBugReportManager(new TalabatBugReportImpl());
                talabatBugReportManager.initializeBugReporter(this);
            }
        }
    }

    public final void initialiseTalabatNetworkModuleIntegrator() {
        AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider();
        TalabatNetworkModuleIntegrator talabatNetworkModuleIntegrator = TalabatNetworkModuleIntegrator.INSTANCE;
        talabatNetworkModuleIntegrator.setGetMyClientId(new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$1(this));
        talabatNetworkModuleIntegrator.setGetMySessionId(TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$2.INSTANCE);
        talabatNetworkModuleIntegrator.setGetSelectedLanguage(TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$3.INSTANCE);
        talabatNetworkModuleIntegrator.setGetTokenType(TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$4.INSTANCE);
        talabatNetworkModuleIntegrator.setGetAccessToken(TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$5.INSTANCE);
        talabatNetworkModuleIntegrator.setGetVersion(new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$6(appVersionProvider));
        talabatNetworkModuleIntegrator.setTokenAvailable(TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$7.INSTANCE);
        talabatNetworkModuleIntegrator.setDeviceId(new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$8(this));
        talabatNetworkModuleIntegrator.setLogout(new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$9(this));
        talabatNetworkModuleIntegrator.setShouldStopUseOwinToken(new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$10(this));
    }

    public final void initialiseTalabatNetworkModuleSafetyIntegrator() {
        TalabatNetworkModuleSafetyIntegrator talabatNetworkModuleSafetyIntegrator = TalabatNetworkModuleSafetyIntegrator.INSTANCE;
        talabatNetworkModuleSafetyIntegrator.setAppPackageName(new TalabatApplication$initialiseTalabatNetworkModuleSafetyIntegrator$1$1(this));
        talabatNetworkModuleSafetyIntegrator.setAppInstallationPath(new TalabatApplication$initialiseTalabatNetworkModuleSafetyIntegrator$1$2(this));
    }

    public final void initializeWithDependencyInjectionComplete() {
        disableApptimize();
        updateOnCountryChangedListener();
        initializeBraze();
        createAdjust();
        getFireBaseToken();
        initializeFacebookSdk();
        if (getMessagingServiceType() == MessagingServiceType.HUAWEI) {
            registerHMSTokenToBraze();
        }
        registerFCMTokenToChatProvider();
        createNotificationChannels();
        LogManager.setRemoteLogger(new CrashlyticsLogger());
        subscribeToTheChangesInSelectedCountryId();
        subscribeToTheChangesInCustomerInfo();
        clearGoogleMapZoomCache();
    }

    public void injectMembers() {
        getAppComponent().inject(this);
        ApplicationComponent appComponent = getAppComponent();
        Cart instance2 = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "getInstance()");
        appComponent.inject(instance2);
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public boolean isRobolectric() {
        return false;
    }

    public void onCreate() {
        RxErrorHandlerKt.setRxErrorHandler();
        getApp().onCreate();
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest = SectionOfInterest.APP_START_TO_INTERACTIVE;
        PointOfInterest pointOfInterest = PointOfInterest.TOTAL_TIME;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest);
        SectionOfInterest sectionOfInterest2 = SectionOfInterest.TALABAT_APPLICATION;
        pointOfInterestReporter.startTraceLog(sectionOfInterest2, pointOfInterest);
        NfvObservabilityHandler.INSTANCE.initialize(this);
        Integration.setAppContext(this);
        AppLaunchTrackingManger.INSTANCE.setAppStartTime(Calendar.getInstance().getTimeInMillis());
        StrictModeHelperKt.enableStrictMode();
        ANRWatchdogHelperKt.enableANRWatchdog();
        super.onCreate();
        FirebaseApp.initializeApp(this);
        setupFwfIntegrator();
        initDataLayerLogger();
        setTrackingAndObservability();
        injectMembers();
        initializeTalabatVolley();
        ObservabilityManagerIntegrator observabilityManagerIntegrator = ObservabilityManagerIntegrator.INSTANCE;
        observabilityManagerIntegrator.setPerseusClientId(TalabatApplication$onCreate$1$1.INSTANCE);
        observabilityManagerIntegrator.setPerseusSessionId(TalabatApplication$onCreate$1$2.INSTANCE);
        AutomationTestingIntegrator automationTestingIntegrator = AutomationTestingIntegrator.INSTANCE;
        automationTestingIntegrator.setLiveAutomation(new TalabatApplication$onCreate$2$1(this));
        automationTestingIntegrator.setAutomationProcess(new TalabatApplication$onCreate$2$2(this));
        automationTestingIntegrator.setTrackedEvents(new TalabatApplication$onCreate$2$3(this));
        startAppTracking();
        context = getApplicationContext();
        instance = this;
        initGoogleClientId();
        initializePerseus();
        initialiseFunWithFlags(getLastSelectedCountry());
        initAppBasicInfo();
        pointOfInterestReporter.startTraceLog(sectionOfInterest2, PointOfInterest.BACKGROUND_INITIALIZATION);
        IntegrationsKt.initializeInBackground(this);
        GemApplicationIntegrationKt.initializeGemIntegration(this);
        initializeVendorMenuFlutterIntegration();
        setupAuthenticationTokenIntegrator();
        DSConfiguration.Companion.initialize$default(DSConfiguration.Companion, false, false, false, false, false, false, 63, (Object) null);
        CuisinesIntegratorKt.CuisinesIntegration(this, new TalabatApplication$onCreate$3(this));
        pointOfInterestReporter.endTraceLog(sectionOfInterest2, pointOfInterest);
        stopAppTracking();
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onLogout() {
        new LogoutHandler().onLogout(this, ((TokenCoreLibApi) getFeature(TokenCoreLibApi.class)).getTokenRepository());
        onGemSessionChanged();
    }

    public void onLowMemory() {
        super.onLowMemory();
        FlutterEngineCache.getInstance().clear();
    }

    public final void pauseBannerForNextScreen() {
        this.pauseBannerForNextScreen = true;
    }

    @TargetApi(14)
    public void registerComponentCallbacks(@NotNull ComponentCallbacks componentCallbacks) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "callback");
        super.registerComponentCallbacks(componentCallbacks);
        ComponentCallbacksBehavioralAdjustmentToolIcs.Companion.getINSTANCE$com_talabat_talabat_talabat().onComponentCallbacksRegistered(componentCallbacks);
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public final void setConfigurationRemoteCoreLibApi(@NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteCoreLibApi, "<set-?>");
        this.configurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi;
    }

    public final void setCurrentPausedActivity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.currentPausedActivity = str;
        this.lastOpenedTime = System.currentTimeMillis();
    }

    public final void setCustomerInfoRepository(@NotNull CustomerInfoRepository customerInfoRepository2) {
        Intrinsics.checkNotNullParameter(customerInfoRepository2, "<set-?>");
        this.customerInfoRepository = customerInfoRepository2;
    }

    public final void setFWFManager(@NotNull IFWFManager iFWFManager) {
        Intrinsics.checkNotNullParameter(iFWFManager, "<set-?>");
        this.fWFManager = iFWFManager;
    }

    public final void setMessagingServiceType(@NotNull MessagingServiceType messagingServiceType2) {
        Intrinsics.checkNotNullParameter(messagingServiceType2, "<set-?>");
        this.messagingServiceType = messagingServiceType2;
    }

    public void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public final void setSplashPreferences(@NotNull SplashPreferences splashPreferences2) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "<set-?>");
        this.splashPreferences = splashPreferences2;
    }

    public final void setVoucherCampaignDeeplinkUseCase(@NotNull VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase2) {
        Intrinsics.checkNotNullParameter(voucherCampaignDeeplinkUseCase2, "<set-?>");
        this.voucherCampaignDeeplinkUseCase = voucherCampaignDeeplinkUseCase2;
    }

    public final void startAppTracking() {
        if (!isRobolectric()) {
            TimeTrackerImplementation.startTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_APP_CLASS, 0, 2, (Object) null);
            getScreenTracker().initialize();
            PerformanceTracker performanceTracker = PerformanceTracker.INSTANCE;
            performanceTracker.setPerformanceTrackerImpl(getPerformanceTracker(), new TalabatApplication$startAppTracking$1(LogManager.INSTANCE));
            if (!getSplashPreferences().getIsFreshInstall()) {
                performanceTracker.listenToAppStartUp(this, "appStartToInteractive", "applicationClassInitialisation");
            }
        }
    }

    @TargetApi(14)
    public void unregisterComponentCallbacks(@NotNull ComponentCallbacks componentCallbacks) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "callback");
        ComponentCallbacksBehavioralAdjustmentToolIcs.Companion.getINSTANCE$com_talabat_talabat_talabat().onComponentCallbacksUnregistered(componentCallbacks);
        super.unregisterComponentCallbacks(componentCallbacks);
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
