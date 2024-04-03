package com.talabat.splash.presentation.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.adjust.sdk.Adjust;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.PermissionManager;
import com.talabat.helpers.PermissionManagerKt;
import com.talabat.helpers.SetAppBrandPrefValues;
import com.talabat.helpers.TalabatBase;
import com.talabat.integration.OnAppStartupCompleteListener;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.EventType;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.squads.discovery.AppLaunchTrackingManger;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.splash.core.di.ApplicationComponent;
import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.extension.Event;
import com.talabat.splash.core.extension.LifeCycleKt;
import com.talabat.splash.core.navigation.Navigator;
import com.talabat.splash.domain.model.SplashCampaignType;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.splash.presentation.ui.displaymodel.Campaign;
import com.talabat.splash.presentation.ui.displaymodel.Content;
import com.talabat.splash.presentation.ui.displaymodel.SplashContentDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import tracking.gtm.datalayerLogger.DatalayerLogger;
import xu.f;
import xu.g;
import xu.h;
import xu.i;
import xu.j;
import xu.k;

@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010:\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\u0018\u0010>\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\u0018\u0010?\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\b\u0010@\u001a\u000207H\u0002J\u0010\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J \u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u00020=H\u0002J:\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020=2\u0006\u0010R\u001a\u00020=2\u0006\u0010M\u001a\u00020J2\u0006\u0010S\u001a\u00020=2\b\b\u0002\u0010N\u001a\u00020=H\u0002J\u0012\u0010T\u001a\u0002072\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0012\u0010W\u001a\u00020=2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020=H\u0002J\b\u0010[\u001a\u000207H\u0016J\u0006\u0010\\\u001a\u000207J\b\u0010]\u001a\u000207H\u0002J\b\u0010^\u001a\u000207H\u0002J\b\u0010_\u001a\u000207H\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u000207H\u0002J\b\u0010c\u001a\u00020 H\u0016J\b\u0010d\u001a\u000207H\u0002J\u0010\u0010e\u001a\u00020 2\u0006\u0010f\u001a\u00020JH\u0002J\u0016\u0010g\u001a\u0002072\u0006\u0010h\u001a\u00020=2\u0006\u0010i\u001a\u00020jJ\u0010\u0010k\u001a\u0002072\u0006\u0010i\u001a\u00020jH\u0002J\u0012\u0010l\u001a\u0002072\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\b\u0010o\u001a\u000207H\u0002J\b\u0010p\u001a\u000207H\u0002J\b\u0010q\u001a\u000207H\u0002J\b\u0010r\u001a\u000207H\u0002J\u0018\u0010s\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\u0010\u0010t\u001a\u0002072\b\u0010U\u001a\u0004\u0018\u00010VJ\u0016\u0010u\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<J \u0010v\u001a\u0002072\u0016\u0010w\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010y\u0012\u0004\u0012\u00020=\u0018\u00010xH\u0002J\b\u0010z\u001a\u000207H\u0016J\u0010\u0010{\u001a\u0002072\u0006\u0010|\u001a\u00020}H\u0016J\b\u0010~\u001a\u000207H\u0016J\b\u0010\u001a\u000207H\u0016J\u0015\u0010\u0001\u001a\u0002072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u000207H\u0016J\t\u0010\u0001\u001a\u000207H\u0016J\u0019\u0010\u0001\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\t\u0010\u0001\u001a\u000207H\u0002J\u0012\u0010\u0001\u001a\u0002072\t\u0010\u0001\u001a\u0004\u0018\u00010YJ\t\u0010\u0001\u001a\u000207H\u0002J\t\u0010\u0001\u001a\u000207H\u0002J\u0010\u0010\u0001\u001a\u0002072\u0007\u0010\u0001\u001a\u00020 J\u0015\u0010\u0001\u001a\u0002072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u001b\u0010\u0001\u001a\u0002072\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010<H\u0002J\u0019\u0010\u0001\u001a\u0002072\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\t\u0010\u0001\u001a\u000207H\u0002J\u001b\u0010\u0001\u001a\u0002072\u0010\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010<H\u0002J&\u0010\u0001\u001a\u0002072\u001b\u0010\u0001\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0x\u0018\u00010<H\u0002J\u0014\u0010\u0001\u001a\u0002072\t\u0010\u0001\u001a\u0004\u0018\u00010YH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020#8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006\u0001"}, d2 = {"Lcom/talabat/splash/presentation/ui/SplashActivity;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/integration/OnAppStartupCompleteListener;", "()V", "appComponent", "Lcom/talabat/splash/core/di/ApplicationComponent;", "getAppComponent", "()Lcom/talabat/splash/core/di/ApplicationComponent;", "appComponent$delegate", "Lkotlin/Lazy;", "dataLayerLogger", "Ltracking/gtm/datalayerLogger/DatalayerLogger;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator$com_talabat_talabat_talabat", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator$com_talabat_talabat_talabat", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "navigator", "Lcom/talabat/splash/core/navigation/Navigator;", "getNavigator$com_talabat_talabat_talabat", "()Lcom/talabat/splash/core/navigation/Navigator;", "setNavigator$com_talabat_talabat_talabat", "(Lcom/talabat/splash/core/navigation/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager$com_talabat_talabat_talabat", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager$com_talabat_talabat_talabat", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "presentationUtils", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "getPresentationUtils$com_talabat_talabat_talabat", "()Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "setPresentationUtils$com_talabat_talabat_talabat", "(Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;)V", "splashActivityViewModel", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModel;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag$com_talabat_talabat_talabat", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag$com_talabat_talabat_talabat", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "animateSplashImageView", "", "imageView", "Landroid/view/View;", "appAuthenticationTokenLoaded", "event", "Lcom/talabat/splash/core/extension/Event;", "", "appBasicInfoLoaded", "appPrefLoaded", "applyBundledSplash", "applyDynamicCampaign", "campaign", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign$Available;", "applyDynamicSplash", "dynamicContent", "Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic;", "asPixel", "", "value", "", "attachLocationFragment", "locationRequestType", "containerId", "isOnboardingExperiementEnabled", "attachVideoFragment", "path", "isOverLay", "isRepeat", "isSplashVideo", "callAppinfoAPI", "redirectionFlow", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "canHandleAppLink", "data", "Landroid/net/Uri;", "clearOwinTokenIfExists", "destroyPresenter", "getAppLaunchWithGpsLocationStatus", "getAppPreferences", "getAuthenticationToken", "getDeepLinkUseCase", "getPresenter", "Llibrary/talabat/mvp/IGlobalPresenter;", "getRedirectionFlowType", "getScreenName", "getSplashPhaseOne", "getVideoPath", "splashUIType", "handleCampaignLogic", "withCampaign", "campaignType", "Lcom/talabat/splash/domain/model/SplashCampaignType;", "handleCampaignVisibility", "handleFailure", "failure", "Lcom/talabat/splash/core/exception/Failure;", "iniThirdPartSDK", "initObserver", "initializeApplicationConfiguration", "isFetchCurrentLocExistingUsers", "isFetchCurrentLocReturningLoc", "loadAppInfoWithScreenRedirection", "loadScreenDeepLinkRedirection", "loadScreenRedirection", "screenRedirectionData", "Lkotlin/Pair;", "Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "onAppStartupComplete", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onAuthError", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onResume", "onboardingEventLoaded", "preWarmCollectionsFlutterEngine", "sendNewRelicTrackingForDeeplink", "uri", "setAdjustAttribution", "setAppLanguage", "setLocationStatusforTracking", "locationStauts", "showDynamicSplash", "splashContentDisplayModel", "Lcom/talabat/splash/presentation/ui/displaymodel/SplashContentDisplayModel;", "showForceUpdate", "showLoadingAfterLocationWelcome", "showQatarNationalTeam", "splashViewPhaseImageOrVideo", "splashPhaseOne", "Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;", "splashViewPhaseWelcome", "stopAppStartToInteractiveTrackingForDeepLink", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashActivity extends TalabatBase implements OnAppStartupCompleteListener {
    private static final long ANIMATION_DURATION = 400;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FIREBASE_PROJECT_PATH_DEBUG = "talabat-7ce28.firebaseapp.com";
    @NotNull
    private static final String TIME_EVENT_SPLASH_SCREEN = "TIME_EVENT_SPLASH_SCREEN";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy appComponent$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new SplashActivity$appComponent$2(this));
    private DatalayerLogger dataLayerLogger;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    @NotNull
    private ActivityResultLauncher<String> permissionLauncher = PermissionManagerKt.notificationPermissionLauncher(this);
    @Inject
    public PresentationUtils presentationUtils;
    private SplashActivitySharedViewModel splashActivityViewModel;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/splash/presentation/ui/SplashActivity$Companion;", "", "()V", "ANIMATION_DURATION", "", "FIREBASE_PROJECT_PATH_DEBUG", "", "TIME_EVENT_SPLASH_SCREEN", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SplashCampaignType.values().length];
            iArr[SplashCampaignType.QATAR_NATIONAL_TEAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void animateSplashImageView(View view) {
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setDuration(400);
    }

    /* access modifiers changed from: private */
    public final void appAuthenticationTokenLoaded(Event<Boolean> event) {
        initializeApplicationConfiguration();
    }

    /* access modifiers changed from: private */
    public final void appBasicInfoLoaded(Event<Boolean> event) {
        getAppPreferences();
    }

    /* access modifiers changed from: private */
    public final void appPrefLoaded(Event<Boolean> event) {
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest = SectionOfInterest.SPLASH_ACTIVITY;
        PointOfInterest pointOfInterest = PointOfInterest.APP_PREF_LOADED;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest);
        iniThirdPartSDK();
        setAppLanguage();
        getSplashPhaseOne();
        isFetchCurrentLocExistingUsers();
        getDeepLinkUseCase();
        getRedirectionFlowType();
        setAdjustAttribution();
        preWarmCollectionsFlutterEngine();
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
    }

    private final void applyBundledSplash() {
        ((FrameLayout) _$_findCachedViewById(R.id.splashVideoContainer)).setVisibility(8);
        ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.imageView_splash_static)).setVisibility(0);
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.lottieAnimationFinished();
    }

    private final void applyDynamicCampaign(Campaign.Available available) {
        ((LinearLayout) _$_findCachedViewById(R.id.expo_logo_container)).setVisibility(0);
        int i11 = R.id.splashText;
        ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatTextView) _$_findCachedViewById(i11)).setText(available.getTitle());
        if (available.getImageWidth() > 0 && available.getImageHeight() > 0) {
            int i12 = R.id.campaignImage;
            ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i12)).getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = (int) asPixel(available.getImageWidth());
                layoutParams2.height = (int) asPixel(available.getImageHeight());
                ((ImageView) _$_findCachedViewById(i12)).setLayoutParams(layoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        }
        ((ImageView) _$_findCachedViewById(R.id.campaignImage)).setImageURI(Uri.parse(available.getLocalImagePath()));
    }

    private final void applyDynamicSplash(Content.Dynamic dynamic) {
        if (dynamic.getResourceType() == Content.Dynamic.ResourceType.VIDEO) {
            ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(4);
            ((ImageView) _$_findCachedViewById(R.id.imageView_splash_static)).setVisibility(8);
            ((FrameLayout) _$_findCachedViewById(R.id.splashVideoContainer)).setVisibility(0);
            y(this, dynamic.getLocalResourcePath(), false, false, R.id.splashVideoContainer, true, false, 32, (Object) null);
            return;
        }
        ((FrameLayout) _$_findCachedViewById(R.id.splashVideoContainer)).setVisibility(8);
        ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(0);
        int i11 = R.id.imageView_splash_static;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i11)).getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        ((ImageView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams);
        ((ImageView) _$_findCachedViewById(i11)).setImageURI(Uri.parse(dynamic.getLocalResourcePath()));
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.lottieAnimationFinished();
    }

    private final float asPixel(int i11) {
        return TypedValue.applyDimension(1, (float) i11, getResources().getDisplayMetrics());
    }

    private final void attachLocationFragment(int i11, int i12, boolean z11) {
        getSupportFragmentManager().beginTransaction().add(i12, (Fragment) LocationFetchFragment.Companion.newInstance(i11, z11)).commit();
    }

    private final void attachVideoFragment(String str, boolean z11, boolean z12, int i11, boolean z13, boolean z14) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).add(i11, (Fragment) WelcomeVideoFragment.Companion.newInstance(str, z11, z12, z13, z14)).commit();
    }

    private final void callAppinfoAPI(SplashRedirectionWrapper splashRedirectionWrapper) {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.loadAppInfo(splashRedirectionWrapper);
    }

    private final boolean clearOwinTokenIfExists() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        return splashActivitySharedViewModel.clearOwinTokenIfExists();
    }

    private final ApplicationComponent getAppComponent() {
        return (ApplicationComponent) this.appComponent$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getAppLaunchWithGpsLocationStatus$lambda-11  reason: not valid java name */
    public static final void m10917getAppLaunchWithGpsLocationStatus$lambda11(SplashActivity splashActivity, GpsStatus gpsStatus) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        if (gpsStatus instanceof GpsStatus.Enabled) {
            SplashActivitySharedViewModel splashActivitySharedViewModel = splashActivity.splashActivityViewModel;
            if (splashActivitySharedViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
                splashActivitySharedViewModel = null;
            }
            splashActivitySharedViewModel.getLocationPerMissionStatus().observe(splashActivity, new k(splashActivity));
        } else if (gpsStatus instanceof GpsStatus.GpsDenyFailure) {
            splashActivity.setLocationStatusforTracking(TrackingUtils.TrackingGpsStatus.Disabled.getValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getAppLaunchWithGpsLocationStatus$lambda-11$lambda-10  reason: not valid java name */
    public static final void m10918getAppLaunchWithGpsLocationStatus$lambda11$lambda10(SplashActivity splashActivity, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        if (permissionStatus instanceof PermissionStatus.Granted) {
            splashActivity.setLocationStatusforTracking(TrackingUtils.TrackingGpsStatus.Enabled.getValue());
        } else if (permissionStatus instanceof PermissionStatus.Denied) {
            splashActivity.setLocationStatusforTracking(TrackingUtils.TrackingGpsStatus.PermissionDenied.getValue());
        }
    }

    private final void getAppPreferences() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getAppPreferences();
    }

    private final void getAuthenticationToken() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getAuthenticationToken();
    }

    private final void getDeepLinkUseCase() {
        int i11;
        Uri data = getIntent().getData();
        if (data == null && GlobalDataModel.ADJUST_DEEPLINK.DIFFERED_DEEPLINK == null) {
            i11 = 0;
        } else {
            i11 = SplashDataUtils.INSTANCE.getDIFFERED_DEEP_LINK();
        }
        Uri uri = GlobalDataModel.ADJUST_DEEPLINK.DIFFERED_DEEPLINK;
        if (uri != null) {
            data = uri;
        }
        if (data != null) {
            Adjust.appWillOpenUrl(data, this);
            deepLinkRecived(this, data);
            SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
            if (splashActivitySharedViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
                splashActivitySharedViewModel = null;
            }
            splashActivitySharedViewModel.deepLinkReceived(i11, data);
        }
    }

    private final void getRedirectionFlowType() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getReDirectionFlowType();
    }

    private final void getSplashPhaseOne() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getSplashPhaseOne();
    }

    private final String getVideoPath(int i11) {
        getPackageName();
        if (i11 == SplashDataUtils.INSTANCE.getSPLASH_UI_SPECIAL_OCCASION_VIDEO()) {
            String packageName = getPackageName();
            return "android.resource://" + packageName + "/2131951644";
        }
        String packageName2 = getPackageName();
        return "android.resource://" + packageName2 + "/2131951639";
    }

    private final void handleCampaignVisibility(SplashCampaignType splashCampaignType) {
        if (WhenMappings.$EnumSwitchMapping$0[splashCampaignType.ordinal()] == 1) {
            showQatarNationalTeam();
        }
    }

    /* access modifiers changed from: private */
    public final void handleFailure(Failure failure) {
        getNavigator$com_talabat_talabat_talabat().openNoNetworkActvity(this, failure);
    }

    private final void iniThirdPartSDK() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.iniThirdPartSDK();
    }

    private final void initObserver() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = (SplashActivitySharedViewModel) new ViewModelProvider((ViewModelStoreOwner) this, getViewModelFactory()).get(SplashActivitySharedViewModel.class);
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMGetAuthenticationToken(), new SplashActivity$initObserver$1$1(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMAppBasicInfoConfig(), new SplashActivity$initObserver$1$2(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMAppPrefConfig(), new SplashActivity$initObserver$1$3(this));
        LifeCycleKt.observe(this, splashActivitySharedViewModel.getMFetchCurrentLocationExistingUsers(), new SplashActivity$initObserver$1$4(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMSplashViewPhaseWithImageOrVideo(), new SplashActivity$initObserver$1$5(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMSplashViewPhaseWithWelcome(), new SplashActivity$initObserver$1$6(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMSplashReDirection(), new SplashActivity$initObserver$1$7(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getScreenInfoWrapperLiveData(), new SplashActivity$initObserver$1$8(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMDeepLinkScreenRedirection(), new SplashActivity$initObserver$1$9(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMAppForceUpdateRedirection(), new SplashActivity$initObserver$1$10(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getMShowLoadingAppInfo(), new SplashActivity$initObserver$1$11(this));
        LifeCycleKt.observeAndRemove(this, splashActivitySharedViewModel.getDynamicSplashContent(), new SplashActivity$initObserver$1$12(this));
        LifeCycleKt.failure(this, splashActivitySharedViewModel.getFailure(), new SplashActivity$initObserver$1$13(this));
        this.splashActivityViewModel = splashActivitySharedViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getShowNotificationPermission().observe(this, new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initObserver$lambda-1  reason: not valid java name */
    public static final void m10919initObserver$lambda1(SplashActivity splashActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        if (!bool.booleanValue()) {
            PermissionManager.INSTANCE.requestPermission(splashActivity.permissionLauncher, "android.permission.POST_NOTIFICATIONS");
        }
    }

    private final void initializeApplicationConfiguration() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.initAppConfig();
    }

    private final void isFetchCurrentLocExistingUsers() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getCurrentLocationExistingUsers();
    }

    /* access modifiers changed from: private */
    public final void isFetchCurrentLocReturningLoc(Event<Boolean> event) {
        PointOfInterestReporter.INSTANCE.startTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.CURRENT_LOC_RETURN);
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getGpsStatus().observe(this, new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: isFetchCurrentLocReturningLoc$lambda-5  reason: not valid java name */
    public static final void m10920isFetchCurrentLocReturningLoc$lambda5(SplashActivity splashActivity, GpsStatus gpsStatus) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        if (gpsStatus instanceof GpsStatus.Enabled) {
            SplashActivitySharedViewModel splashActivitySharedViewModel = splashActivity.splashActivityViewModel;
            if (splashActivitySharedViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
                splashActivitySharedViewModel = null;
            }
            splashActivitySharedViewModel.getLocationPerMissionStatus().observe(splashActivity, new h(splashActivity));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: isFetchCurrentLocReturningLoc$lambda-5$lambda-4  reason: not valid java name */
    public static final void m10921isFetchCurrentLocReturningLoc$lambda5$lambda4(SplashActivity splashActivity, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        SplashActivitySharedViewModel splashActivitySharedViewModel = splashActivity.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getLocationData(SplashDataUtils.INSTANCE.getLOCATION_ONLY_REQUEST()).observe(splashActivity, new i());
    }

    /* access modifiers changed from: private */
    /* renamed from: isFetchCurrentLocReturningLoc$lambda-5$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10922isFetchCurrentLocReturningLoc$lambda5$lambda4$lambda3(CurrentLocationWrapper currentLocationWrapper) {
        PointOfInterestReporter.INSTANCE.endTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.CURRENT_LOC_RETURN);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r0 != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadScreenRedirection(kotlin.Pair<com.talabat.splash.domain.model.ScreenInfoWrapper, java.lang.Boolean> r9) {
        /*
            r8 = this;
            int r0 = com.talabat.R.id.avi_loading
            android.view.View r0 = r8._$_findCachedViewById(r0)
            com.wang.avi.AVLoadingIndicatorView r0 = (com.wang.avi.AVLoadingIndicatorView) r0
            r1 = 4
            r0.setVisibility(r1)
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x002c
            java.lang.Object r2 = r9.getFirst()
            com.talabat.splash.domain.model.ScreenInfoWrapper r2 = (com.talabat.splash.domain.model.ScreenInfoWrapper) r2
            if (r2 == 0) goto L_0x002c
            com.talabat.splash.domain.model.SplashRedirectionWrapper r2 = r2.getScreenType()
            if (r2 == 0) goto L_0x002c
            int r2 = r2.getFlowType()
            com.talabat.splash.domain.model.SplashDataUtils r3 = com.talabat.splash.domain.model.SplashDataUtils.INSTANCE
            int r3 = r3.getNORMAL_WELCOME_FLOW()
            if (r2 != r3) goto L_0x002c
            r2 = r0
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            if (r2 != 0) goto L_0x0070
            if (r9 == 0) goto L_0x004d
            java.lang.Object r2 = r9.getFirst()
            com.talabat.splash.domain.model.ScreenInfoWrapper r2 = (com.talabat.splash.domain.model.ScreenInfoWrapper) r2
            if (r2 == 0) goto L_0x004d
            com.talabat.splash.domain.model.SplashRedirectionWrapper r2 = r2.getScreenType()
            if (r2 == 0) goto L_0x004d
            int r2 = r2.getFlowType()
            com.talabat.splash.domain.model.SplashDataUtils r3 = com.talabat.splash.domain.model.SplashDataUtils.INSTANCE
            int r3 = r3.getNORMAL_WELCOME_SUCCESS_FLOW()
            if (r2 != r3) goto L_0x004d
            r2 = r0
            goto L_0x004e
        L_0x004d:
            r2 = r1
        L_0x004e:
            if (r2 != 0) goto L_0x0070
            if (r9 == 0) goto L_0x006d
            java.lang.Object r2 = r9.getFirst()
            com.talabat.splash.domain.model.ScreenInfoWrapper r2 = (com.talabat.splash.domain.model.ScreenInfoWrapper) r2
            if (r2 == 0) goto L_0x006d
            com.talabat.splash.domain.model.SplashRedirectionWrapper r2 = r2.getScreenType()
            if (r2 == 0) goto L_0x006d
            int r2 = r2.getFlowType()
            com.talabat.splash.domain.model.SplashDataUtils r3 = com.talabat.splash.domain.model.SplashDataUtils.INSTANCE
            int r3 = r3.getNORMAL_WELCOME_DENY_FLOW()
            if (r2 != r3) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r0 = r1
        L_0x006e:
            if (r0 == 0) goto L_0x007c
        L_0x0070:
            r8.stopLodingPopup()
            com.talabat.observability.localTracer.PointOfInterestReporter r0 = com.talabat.observability.localTracer.PointOfInterestReporter.INSTANCE
            com.talabat.observability.localTracer.SectionOfInterest r1 = com.talabat.observability.localTracer.SectionOfInterest.SPLASH_ACTIVITY
            com.talabat.observability.localTracer.PointOfInterest r2 = com.talabat.observability.localTracer.PointOfInterest.LOAD_SCREEN_REDIRECTION
            r0.endTraceLog(r1, r2)
        L_0x007c:
            com.talabat.observability.localTracer.PointOfInterestReporter r0 = com.talabat.observability.localTracer.PointOfInterestReporter.INSTANCE
            com.talabat.observability.localTracer.SectionOfInterest r1 = com.talabat.observability.localTracer.SectionOfInterest.SPLASH_ACTIVITY
            com.talabat.observability.localTracer.PointOfInterest r2 = com.talabat.observability.localTracer.PointOfInterest.TOTAL_TIME
            r0.endTraceLog(r1, r2)
            com.talabat.observability.performance.PerformanceTracker r0 = com.talabat.observability.performance.PerformanceTracker.INSTANCE
            java.lang.String r1 = "splashScreenTrace"
            r0.stopTrace(r1)
            com.talabat.observability.tracker.TimeTrackerImplementation r2 = com.talabat.observability.tracker.TimeTrackerKt.getTimeTracker()
            java.lang.String r3 = "TIME_EVENT_SPLASH_SCREEN"
            r4 = 0
            r6 = 2
            r7 = 0
            com.talabat.observability.tracker.TimeTrackerImplementation.stopTracking$default(r2, r3, r4, r6, r7)
            com.talabat.splash.core.navigation.Navigator r0 = r8.getNavigator$com_talabat_talabat_talabat()
            r1 = 0
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r2 = r9.getFirst()
            com.talabat.splash.domain.model.ScreenInfoWrapper r2 = (com.talabat.splash.domain.model.ScreenInfoWrapper) r2
            goto L_0x00a8
        L_0x00a7:
            r2 = r1
        L_0x00a8:
            if (r9 == 0) goto L_0x00b1
            java.lang.Object r9 = r9.getSecond()
            r1 = r9
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x00b1:
            r0.screenRedirection(r8, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.presentation.ui.SplashActivity.loadScreenRedirection(kotlin.Pair):void");
    }

    private final void onboardingEventLoaded(Event<Boolean> event) {
        getAppPreferences();
    }

    private final void preWarmCollectionsFlutterEngine() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        if (splashActivitySharedViewModel.shouldPreWarmCollectionsFlutterEngine()) {
            PreWarmedEngines preWarmedEngines = PreWarmedEngines.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            preWarmedEngines.getWarmedUpEngine(context, PreWarmedEngines.ENGINE_FOR_VENDOR_COLLECTIONS);
        }
    }

    private final void setAdjustAttribution() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.setAdjustAttribution();
    }

    private final void setAppLanguage() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.setAppLanguage();
    }

    /* access modifiers changed from: private */
    public final void showDynamicSplash(SplashContentDisplayModel splashContentDisplayModel) {
        SplashCampaignType splashCampaignType;
        if (splashContentDisplayModel != null) {
            Content configuration = splashContentDisplayModel.getConfiguration();
            if (Intrinsics.areEqual((Object) configuration, (Object) Content.Bundled.INSTANCE)) {
                applyBundledSplash();
            } else if (configuration instanceof Content.Dynamic) {
                applyDynamicSplash((Content.Dynamic) splashContentDisplayModel.getConfiguration());
            }
            Campaign campaign = splashContentDisplayModel.getCampaign();
            if (campaign instanceof Campaign.Available) {
                applyDynamicCampaign((Campaign.Available) campaign);
            } else if (Intrinsics.areEqual((Object) campaign, (Object) Campaign.Unavailable.INSTANCE)) {
                SplashPhaseOneViewEntity legacy = splashContentDisplayModel.getLegacy();
                if (legacy != null) {
                    splashCampaignType = legacy.getCampaignType();
                } else {
                    splashCampaignType = null;
                }
                if (splashCampaignType != null) {
                    handleCampaignLogic(legacy.getShowCampaignLogo(), splashCampaignType);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showForceUpdate(Event<String> event) {
        String contentIfNotHandledOrReturnNull;
        if (event != null && (contentIfNotHandledOrReturnNull = event.getContentIfNotHandledOrReturnNull()) != null) {
            PresentationUtils presentationUtils$com_talabat_talabat_talabat = getPresentationUtils$com_talabat_talabat_talabat();
            String string = getString(R.string.update_Title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…on.R.string.update_Title)");
            presentationUtils$com_talabat_talabat_talabat.onForceUpdatePopup(this, string, contentIfNotHandledOrReturnNull, new SplashActivity$showForceUpdate$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showLoadingAfterLocationWelcome(Event<Boolean> event) {
        startLodingPopup();
    }

    private final void showQatarNationalTeam() {
        int i11 = R.id.splashText;
        ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatTextView) _$_findCachedViewById(i11)).setText(getString(R.string.qatar_splash_content));
        ((ImageView) _$_findCachedViewById(R.id.campaignImage)).setImageResource(R.drawable.qatar_splash_campagin);
    }

    /* access modifiers changed from: private */
    public final void splashViewPhaseImageOrVideo(Event<SplashPhaseOneViewEntity> event) {
        boolean z11;
        SplashCampaignType splashCampaignType;
        int i11;
        SplashPhaseOneViewEntity contentIfNotHandledOrReturnNull;
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest = SectionOfInterest.SPLASH_ACTIVITY;
        PointOfInterest pointOfInterest = PointOfInterest.PHASE_IMAGE_VIDEO;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest);
        SplashActivitySharedViewModel splashActivitySharedViewModel = null;
        if (event == null || (contentIfNotHandledOrReturnNull = event.getContentIfNotHandledOrReturnNull()) == null) {
            i11 = 0;
            z11 = false;
            splashCampaignType = null;
        } else {
            i11 = contentIfNotHandledOrReturnNull.getSplashUIType();
            boolean showCampaignLogo = contentIfNotHandledOrReturnNull.getShowCampaignLogo();
            splashCampaignType = contentIfNotHandledOrReturnNull.getCampaignType();
            z11 = showCampaignLogo;
        }
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        if (i11 == splashDataUtils.getSPLASH_UI_NORMAL_VIDEO() || i11 == splashDataUtils.getSPLASH_UI_SPECIAL_OCCASION_VIDEO()) {
            ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(4);
            ((ImageView) _$_findCachedViewById(R.id.imageView_splash_static)).setVisibility(8);
            ((FrameLayout) _$_findCachedViewById(R.id.splashVideoContainer)).setVisibility(0);
            y(this, getVideoPath(i11), false, false, R.id.splashVideoContainer, true, false, 32, (Object) null);
        } else {
            ((FrameLayout) _$_findCachedViewById(R.id.splashVideoContainer)).setVisibility(8);
            ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.imageView_splash_static)).setVisibility(0);
            SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivityViewModel;
            if (splashActivitySharedViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            } else {
                splashActivitySharedViewModel = splashActivitySharedViewModel2;
            }
            splashActivitySharedViewModel.lottieAnimationFinished();
        }
        if (splashCampaignType != null) {
            handleCampaignLogic(z11, splashCampaignType);
        }
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
    }

    /* access modifiers changed from: private */
    public final void splashViewPhaseWelcome(Event<Pair<Boolean, Boolean>> event) {
        Pair contentIfNotHandledOrReturnNull;
        if (event != null && (contentIfNotHandledOrReturnNull = event.getContentIfNotHandledOrReturnNull()) != null) {
            _$_findCachedViewById(R.id.splashMainViewContainer).setVisibility(8);
            int i11 = R.id.splashWelcomeViewContainer;
            View _$_findCachedViewById = _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "splashWelcomeViewContainer");
            animateSplashImageView(_$_findCachedViewById);
            _$_findCachedViewById(i11).setVisibility(0);
            String packageName = getPackageName();
            attachVideoFragment("android.resource://" + packageName + "/2131951648", false, true, R.id.welcomeVideoFragContainer, true, ((Boolean) contentIfNotHandledOrReturnNull.getSecond()).booleanValue());
            attachLocationFragment(0, R.id.locationFrgContainer, ((Boolean) contentIfNotHandledOrReturnNull.getSecond()).booleanValue());
            AppLaunchTrackingManger.INSTANCE.setFirstRun(true);
        }
    }

    /* access modifiers changed from: private */
    public final void stopAppStartToInteractiveTrackingForDeepLink(Uri uri) {
        String str;
        if (uri != null) {
            str = uri.getQueryParameter("s");
        } else {
            str = null;
        }
        if (str != null) {
            String queryParameter = uri.getQueryParameter("s");
            if (queryParameter == null || queryParameter.hashCode() != 104 || !queryParameter.equals("h")) {
                PerformanceTracker.INSTANCE.cancelTrace("appStartToInteractive");
            }
        }
    }

    public static /* synthetic */ void y(SplashActivity splashActivity, String str, boolean z11, boolean z12, int i11, boolean z13, boolean z14, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            z14 = false;
        }
        splashActivity.attachVideoFragment(str, z11, z12, i11, z13, z14);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public boolean canHandleAppLink(@Nullable Uri uri) {
        if (uri != null) {
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new SplashActivity$canHandleAppLink$1$1(this, uri, (Continuation<? super SplashActivity$canHandleAppLink$1$1>) null), 1, (Object) null)).booleanValue();
        }
        return false;
    }

    public void destroyPresenter() {
    }

    public final void getAppLaunchWithGpsLocationStatus() {
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.getGpsStatus().observe(this, new f(this));
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator$com_talabat_talabat_talabat() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final Navigator getNavigator$com_talabat_talabat_talabat() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager$com_talabat_talabat_talabat() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final PresentationUtils getPresentationUtils$com_talabat_talabat_talabat() {
        PresentationUtils presentationUtils2 = this.presentationUtils;
        if (presentationUtils2 != null) {
            return presentationUtils2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presentationUtils");
        return null;
    }

    @Nullable
    public IGlobalPresenter getPresenter() {
        return null;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.SPLASHSCREEN;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag$com_talabat_talabat_talabat() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public final void handleCampaignLogic(boolean z11, @NotNull SplashCampaignType splashCampaignType) {
        Intrinsics.checkNotNullParameter(splashCampaignType, "campaignType");
        if (z11) {
            ((LinearLayout) _$_findCachedViewById(R.id.expo_logo_container)).setVisibility(0);
            handleCampaignVisibility(splashCampaignType);
            return;
        }
        ((LinearLayout) _$_findCachedViewById(R.id.expo_logo_container)).setVisibility(8);
    }

    public final void loadAppInfoWithScreenRedirection(@Nullable SplashRedirectionWrapper splashRedirectionWrapper) {
        PointOfInterestReporter.INSTANCE.startTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.APP_INFO_CALL);
        callAppinfoAPI(splashRedirectionWrapper);
    }

    public final void loadScreenDeepLinkRedirection(@Nullable Event<Boolean> event) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivity$loadScreenDeepLinkRedirection$1(this, (Continuation<? super SplashActivity$loadScreenDeepLinkRedirection$1>) null), 3, (Object) null);
    }

    public void onAppStartupComplete() {
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        pointOfInterestReporter.endTraceLog(SectionOfInterest.TALABAT_APPLICATION, PointOfInterest.BACKGROUND_INITIALIZATION);
        SectionOfInterest sectionOfInterest = SectionOfInterest.SPLASH_ACTIVITY;
        PointOfInterest pointOfInterest = PointOfInterest.APP_COMPONENT_INJECT;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest);
        getAppComponent().inject(this);
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
        PointOfInterest pointOfInterest2 = PointOfInterest.INIT_OBSERVER;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest2);
        pointOfInterestReporter.startTraceLog(sectionOfInterest, PointOfInterest.LOAD_SCREEN_REDIRECTION);
        initObserver();
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest2);
        clearOwinTokenIfExists();
        getAuthenticationToken();
        PointOfInterest pointOfInterest3 = PointOfInterest.GPS_STATUS_LOCATION;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest3);
        getAppLaunchWithGpsLocationStatus();
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest3);
    }

    public void onAttachFragment(@NotNull Fragment fragment) {
        SplashActivitySharedViewModelInjectable splashActivitySharedViewModelInjectable;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.onAttachFragment(fragment);
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel != null) {
            if (fragment instanceof SplashActivitySharedViewModelInjectable) {
                splashActivitySharedViewModelInjectable = (SplashActivitySharedViewModelInjectable) fragment;
            } else {
                splashActivitySharedViewModelInjectable = null;
            }
            if (splashActivitySharedViewModelInjectable != null) {
                if (splashActivitySharedViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
                    splashActivitySharedViewModel = null;
                }
                splashActivitySharedViewModelInjectable.inject(splashActivitySharedViewModel);
            }
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        PointOfInterestReporter.INSTANCE.startTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.TOTAL_TIME);
        super.onCreate(bundle);
        PerformanceTracker.INSTANCE.startTrace("splashScreenTrace");
        TimeTrackerImplementation.startTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_SPLASH_SCREEN, 0, 2, (Object) null);
        setContentView((int) R.layout.activity_splash);
        GlobalConstants.Version = getResources().getString(R.string.app_version);
        SetAppBrandPrefValues.INSTANCE.setUserTokenIfLoggedIn(getContext());
        ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.avi_loading)).setVisibility(4);
        AppLaunchTrackingManger.INSTANCE.trackEvent("splash_screen_start_time", Calendar.getInstance().getTimeInMillis());
    }

    public void onError() {
    }

    public void onResume() {
        super.onResume();
        TimeTrackerImplementation.stopTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_SPLASH_SCREEN, 0, 2, (Object) null);
    }

    public final void sendNewRelicTrackingForDeeplink(@Nullable Uri uri) {
        boolean z11;
        if (uri != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "deepLinkUri.toString()");
            if (uri2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                String name2 = EventType.Deeplink.name();
                Pair[] pairArr = new Pair[3];
                String scheme = uri.getScheme();
                if (scheme == null) {
                    scheme = StringUtils.empty(StringCompanionObject.INSTANCE);
                }
                pairArr[0] = TuplesKt.to("deeplink_scheme", scheme);
                String path = uri.getPath();
                if (path == null) {
                    path = StringUtils.empty(StringCompanionObject.INSTANCE);
                }
                pairArr[1] = TuplesKt.to("deeplink_path", path);
                String query = uri.getQuery();
                if (query == null) {
                    query = StringUtils.empty(StringCompanionObject.INSTANCE);
                }
                pairArr[2] = TuplesKt.to("deeplink_query", query);
                ObservabilityManager.trackEvent(uri2, name2, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
            }
        }
    }

    public final void setDeepLinkNavigator$com_talabat_talabat_talabat(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setLocationStatusforTracking(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locationStauts");
        SplashActivitySharedViewModel splashActivitySharedViewModel = this.splashActivityViewModel;
        if (splashActivitySharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityViewModel");
            splashActivitySharedViewModel = null;
        }
        splashActivitySharedViewModel.trackAppLaunchWithLocationStatus(str);
    }

    public final void setNavigator$com_talabat_talabat_talabat(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager$com_talabat_talabat_talabat(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setPresentationUtils$com_talabat_talabat_talabat(@NotNull PresentationUtils presentationUtils2) {
        Intrinsics.checkNotNullParameter(presentationUtils2, "<set-?>");
        this.presentationUtils = presentationUtils2;
    }

    public final void setTalabatFeatureFlag$com_talabat_talabat_talabat(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
