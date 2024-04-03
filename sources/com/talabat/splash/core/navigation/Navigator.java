package com.talabat.splash.core.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.talabat.R;
import com.talabat.adscreen.AdScreen;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.NoNetworkActivity;
import com.talabat.home.HomeScreenActivity;
import com.talabat.observability.squads.discovery.AppLaunchTrackingManger;
import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.domain.model.ScreenInfoWrapper;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.userandlocation.ChooseCountryActions;
import java.util.Calendar;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J1\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ1\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010 ¨\u0006\""}, d2 = {"Lcom/talabat/splash/core/navigation/Navigator;", "", "()V", "handleHomeScreenNavigation", "", "context", "Landroid/content/Context;", "screenInfoWrapper", "Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "isOnboardingExperimentEnabled", "", "(Landroid/content/Context;Lcom/talabat/splash/domain/model/ScreenInfoWrapper;Ljava/lang/Boolean;)V", "onForceUpdateRedirect", "activity", "Landroid/app/Activity;", "openAdScreen", "openChooseCountryScreen", "flowType", "", "shouldSelectLocationInHome", "(Landroid/content/Context;ILjava/lang/Boolean;Ljava/lang/Boolean;)V", "openHomeScreen", "openHomeScreenToHandleDeepLink", "uri", "Landroid/net/Uri;", "openNoNetworkActvity", "failure", "Lcom/talabat/splash/core/exception/Failure;", "screenRedirection", "welcomeIntent", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;ILjava/lang/Boolean;Ljava/lang/Boolean;)Landroid/content/Intent;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Navigator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HUAWEI_APPGALLERY_ACTION = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withid";
    @NotNull
    private static final String HUAWEI_APPGALLERY_APPID_KEY = "appId";
    @NotNull
    private static final String HUAWEI_APPGALLERY_APPID_VALUE = "C100450669";
    @NotNull
    private static final String HUAWEI_APPGALLERY_PACKAGE = "com.huawei.appmarket";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/splash/core/navigation/Navigator$Companion;", "", "()V", "HUAWEI_APPGALLERY_ACTION", "", "HUAWEI_APPGALLERY_APPID_KEY", "HUAWEI_APPGALLERY_APPID_VALUE", "HUAWEI_APPGALLERY_PACKAGE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleHomeScreenNavigation(Context context, ScreenInfoWrapper screenInfoWrapper, Boolean bool) {
        AppLaunchTrackingManger appLaunchTrackingManger = AppLaunchTrackingManger.INSTANCE;
        appLaunchTrackingManger.trackEvent("splash_screen_end_time", Calendar.getInstance().getTimeInMillis());
        appLaunchTrackingManger.setCanSendEvent(true);
        openHomeScreen(context, screenInfoWrapper.getScreenType().getFlowType(), screenInfoWrapper.getShouldForceLocationSelectLocationInHome(), bool);
    }

    private final void openChooseCountryScreen(Context context, int i11, Boolean bool, Boolean bool2) {
        Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
        NavigatorModel createOpenScreenModel = ChooseCountryActions.INSTANCE.createOpenScreenModel();
        createOpenScreenModel.setInit(new Navigator$openChooseCountryScreen$1$1(this, i11, bool, bool2));
        Unit unit = Unit.INSTANCE;
        companion.navigate(context, createOpenScreenModel);
    }

    /* access modifiers changed from: private */
    public final Intent welcomeIntent(Intent intent, int i11, Boolean bool, Boolean bool2) {
        Boolean bool3;
        intent.putExtra("fromSplash", true);
        intent.putExtra("isInitialSelection", true);
        intent.putExtra("isInitialSelection", true);
        intent.putExtra(GlobalConstants.ExtraNames.SHOULD_FORCE_LOCATION_IN_HOME, bool);
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        if (i11 == splashDataUtils.getNORMAL_WELCOME_SUCCESS_FLOW()) {
            Boolean bool4 = null;
            if (bool2 != null) {
                bool3 = Boolean.valueOf(!bool2.booleanValue());
            } else {
                bool3 = null;
            }
            intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_LOCATION_WELCOME, bool3);
            if (bool2 != null) {
                bool4 = Boolean.valueOf(!bool2.booleanValue());
            }
            intent.putExtra(GlobalConstants.ExtraNames.IS_LOAD_MAP_FROM_WELCOME, bool4);
        } else if (i11 == splashDataUtils.getNORMAL_WELCOME_DENY_FLOW()) {
            intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_LOCATION_WELCOME, true);
            intent.putExtra(GlobalConstants.ExtraNames.IS_LOAD_MAP_FROM_WELCOME, true);
            intent.putExtra("is_show_map_search", true);
        }
        return intent;
    }

    public final void onForceUpdateRedirect(@NotNull Activity activity) {
        boolean z11;
        Intrinsics.checkNotNullParameter(activity, "activity");
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer(activity);
        if (!((HmsBaseCoreLibApi) apiContainer.getFeature(HmsBaseCoreLibApi.class)).isHmsAvailable() || ((GmsBaseCoreLibApi) apiContainer.getFeature(GmsBaseCoreLibApi.class)).isGmsAvailable()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Intent intent = new Intent(HUAWEI_APPGALLERY_ACTION);
            intent.setPackage(HUAWEI_APPGALLERY_PACKAGE);
            intent.putExtra("appId", HUAWEI_APPGALLERY_APPID_VALUE);
            activity.startActivity(intent);
            return;
        }
        String string = activity.getResources().getString(R.string.update_app_name);
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + string)));
    }

    public final void openAdScreen(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent callingIntent = AdScreen.callingIntent(context);
        callingIntent.putExtra("from", ScreenNames.SPLASHSCREEN);
        context.startActivity(callingIntent);
    }

    public final void openHomeScreen(@NotNull Context context, int i11, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(welcomeIntent(HomeScreenActivity.Companion.callingIntent(context), i11, bool, bool2));
    }

    public final void openHomeScreenToHandleDeepLink(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent callingIntent = HomeScreenActivity.Companion.callingIntent(context);
        callingIntent.putExtra("deeplink", uri.toString());
        context.startActivity(callingIntent);
    }

    public final void openNoNetworkActvity(@NotNull Context context, @Nullable Failure failure) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent callingIntent = NoNetworkActivity.callingIntent(context);
        callingIntent.putExtra("errorCode", SplashDataUtils.INSTANCE.netWorkErrorCode(failure));
        callingIntent.putExtra("screenName", ScreenNames.SPLASHSCREEN);
        context.startActivity(callingIntent);
        ((Activity) context).finish();
    }

    public final void screenRedirection(@NotNull Context context, @Nullable ScreenInfoWrapper screenInfoWrapper, @Nullable Boolean bool) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (screenInfoWrapper != null) {
            str = screenInfoWrapper.getScreenName();
        } else {
            str = null;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 422993613) {
                if (hashCode != 1194802474) {
                    if (hashCode == 1768409865 && str.equals("Ad Screen")) {
                        openAdScreen(context);
                    }
                } else if (str.equals("Country Selection Screen")) {
                    openChooseCountryScreen(context, screenInfoWrapper.getScreenType().getFlowType(), screenInfoWrapper.getShouldForceLocationSelectLocationInHome(), bool);
                }
            } else if (str.equals("Home Screen")) {
                handleHomeScreenNavigation(context, screenInfoWrapper, bool);
            }
        }
        ((Activity) context).finish();
    }
}
