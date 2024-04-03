package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.tracking.event.AppOpenedEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.TalabatAdjust;
import tracking.TalabatAppBoy;
import tracking.deeplink.DeepLinkParser;
import tracking.deeplink.DeepLinkResult;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJK\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020(¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\n*\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "", "context", "Landroid/content/Context;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/content/Context;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "OngGeoLocationClickedFromLanding", "", "locationAccuracy", "", "locationRequestSuccess", "Landroid/location/Location;", "geoLocationDialogStatus", "dialogStatus", "", "gpsStatus", "getCampaignParams", "", "deeplinkUri", "Landroid/net/Uri;", "getTalabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "isNewTrackingLibraryEnabled", "onAppLaunchTracking", "locationStatus", "uri", "onAppboyAppOpened", "onCountrySelected", "onGpsInfoReceived", "gpsAccuracy", "", "gpsMaximumWaitTime", "", "gpsWaitTime", "thresholdGpsAccuracy", "locationLat", "", "locationLon", "locationRequestType", "", "(Ljava/lang/Float;JJLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;I)V", "onOtherLocationClicked", "orDefault", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Tracking {
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    @Inject
    public Tracking(@NotNull Context context2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.context = context2;
        this.featureFlag = iTalabatFeatureFlag;
    }

    private final Map<String, Object> getCampaignParams(Uri uri) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (uri != null) {
            DeepLinkResult parse = DeepLinkParser.parse(uri.getQuery());
            linkedHashMap.put("source", orDefault(parse.source));
            linkedHashMap.put("campaign", orDefault(parse.campaign));
            linkedHashMap.put("medium", orDefault(parse.medium));
            linkedHashMap.put("gclid", orDefault(parse.getGclId()));
            linkedHashMap.put("deeplink", uri.toString());
        }
        return linkedHashMap;
    }

    private final TalabatTracker getTalabatTracker() {
        Context applicationContext = this.context.getApplicationContext();
        if (applicationContext != null) {
            return ((TrackingCoreLibApi) ((ApiContainer) applicationContext).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    private final boolean isNewTrackingLibraryEnabled() {
        return this.featureFlag.getFeatureFlag(PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION, false);
    }

    private final String orDefault(String str) {
        if (!(true ^ (str == null || str.length() == 0))) {
            str = null;
        }
        return str == null ? "N/A" : str;
    }

    public final void OngGeoLocationClickedFromLanding(@NotNull String str, @Nullable Location location) {
        Double d11;
        Intrinsics.checkNotNullParameter(str, "locationAccuracy");
        Context context2 = this.context;
        Double d12 = null;
        if (location != null) {
            d11 = Double.valueOf(location.getLatitude());
        } else {
            d11 = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        String sb3 = sb2.toString();
        if (location != null) {
            d12 = Double.valueOf(location.getLongitude());
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(d12);
        AppTracker.OngGeoLocationClickedFromLanding(context2, ScreenNames.LOCATION_WELCOME_SCREEN, ScreenNames.SCREEN_TYPE_LANDING, str, sb3, sb4.toString(), TalabatAdjust.getSelectedCountryIso());
    }

    public final void geoLocationDialogStatus(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "gpsStatus");
        Context context2 = this.context;
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        String locationPromptType = trackingUtils.getLocationPromptType();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z11);
        AppTracker.geolocationDialogueAccepted(context2, ScreenNames.LOCATION_WELCOME_SCREEN, locationPromptType, sb2.toString(), trackingUtils.getLocationPromptType(), str);
    }

    public final void onAppLaunchTracking(@NotNull String str, @Nullable Uri uri) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "locationStatus");
        String screenType = ScreenNames.getScreenType(ScreenNames.SPLASHSCREEN);
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(PlatformFeatureFlagsKeys.FWF_SDK_IN_DART_ENABLED, false);
        if (isNewTrackingLibraryEnabled()) {
            TalabatTracker talabatTracker = getTalabatTracker();
            Intrinsics.checkNotNullExpressionValue(screenType, "screenType");
            talabatTracker.track(new AppOpenedEvent(screenType, featureFlag2, 0, str, getCampaignParams(uri)));
        } else {
            Context context2 = this.context;
            String valueOf = String.valueOf(uri);
            if (uri != null) {
                str2 = uri.getQuery();
            } else {
                str2 = null;
            }
            AppTracker.appLaunch(context2, valueOf, str2, 0, screenType, featureFlag2, str);
        }
        this.featureFlag.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.ADD_OBSERVABILITY_TO_APP_LAUNCH, false, false, (Function1<? super Boolean, Unit>) new Tracking$onAppLaunchTracking$1(uri, featureFlag2, screenType));
    }

    public final void onAppboyAppOpened() {
        TalabatAppBoy.appOpened(this.context);
    }

    public final void onCountrySelected() {
        AppTracker.onCountrySelected(this.context);
    }

    public final void onGpsInfoReceived(@Nullable Float f11, long j11, long j12, @Nullable String str, @Nullable Double d11, @Nullable Double d12, int i11) {
        Context context2 = this.context;
        StringBuilder sb2 = new StringBuilder();
        Float f12 = f11;
        sb2.append(f11);
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        long j13 = j11;
        sb4.append(j11);
        String sb5 = sb4.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(j12);
        String sb7 = sb6.toString();
        String str2 = i11 == SplashDataUtils.INSTANCE.getLOCATION_ONLY_REQUEST() ? ScreenNames.SPLASHSCREEN : ScreenNames.LOCATION_WELCOME_SCREEN;
        String screenType = ScreenNames.getScreenType(ScreenNames.SPLASHSCREEN);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(d11);
        String sb9 = sb8.toString();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(d12);
        AppTracker.onGpsInfoReceived(context2, sb3, sb5, sb7, str, str2, screenType, sb9, sb10.toString());
    }

    public final void onOtherLocationClicked() {
        AppTracker.onOtherLocationClicked(this.context, ScreenNames.LOCATION_WELCOME_SCREEN, ScreenNames.SCREEN_TYPE_LANDING);
    }
}
