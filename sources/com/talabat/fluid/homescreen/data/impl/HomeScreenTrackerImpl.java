package com.talabat.fluid.homescreen.data.impl;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pickup.data.events.valuePropBanner.ValuePropBannerClicked;
import com.talabat.feature.pickup.data.events.valuePropBanner.ValuePropBannerShown;
import com.talabat.feature.tmart.growth.data.tracking.TMartGrowthTracker;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TrackingHelperKt;
import tracking.gtm.ITalabatFirebase;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J.\u0010\u0013\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J*\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J,\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J.\u0010\u001f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010 \u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010!\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010\"\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J6\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J.\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010%\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u001a\u0010&\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002JW\u0010'\u001a\u00020\u00112\u001a\u0010(\u001a\u0016\u0012\b\u0012\u00060\u000fj\u0002`*\u0012\b\u0012\u00060\u000fj\u0002`+0)2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/JF\u00100\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u001a\u0010(\u001a\u0016\u0012\b\u0012\u00060\u000fj\u0002`*\u0012\b\u0012\u00060\u000fj\u0002`+0)2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.H\u0016J>\u00101\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u001a\u0010(\u001a\u0016\u0012\b\u0012\u00060\u000fj\u0002`*\u0012\b\u0012\u00060\u000fj\u0002`+0)2\u0006\u0010,\u001a\u00020\u000fH\u0016J6\u00102\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J.\u00103\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J6\u00104\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J.\u00105\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u00106\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u00107\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u00108\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J6\u00109\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J6\u0010:\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J.\u0010;\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010<\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J$\u0010=\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010=\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010>\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010?\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010@\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J6\u0010A\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J.\u0010B\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0014\u0010C\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\f\u0010D\u001a\u00020\u0011*\u00020\nH\u0002J\f\u0010E\u001a\u00020\u0011*\u00020\nH\u0002J \u0010F\u001a\u00020\u0011*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J \u0010G\u001a\u00020\u0011*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010H\u001a\u00020\u0011*\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\f\u0010I\u001a\u00020\u0011*\u00020\nH\u0002J*\u0010J\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010K\u001a\u00020\u000f2\b\b\u0002\u0010L\u001a\u00020\u000fH\u0002J\u000e\u0010M\u001a\u00020\u000f*\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/talabat/fluid/homescreen/data/impl/HomeScreenTrackerImpl;", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "context", "Landroid/content/Context;", "talabatFirebase", "Ltracking/gtm/ITalabatFirebase;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/content/Context;Ltracking/gtm/ITalabatFirebase;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "createBundleForBannerEvents", "Landroid/os/Bundle;", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "params", "", "", "onRewardsClicked", "", "userId", "onShorCutsClicked", "onShorCutsSwiped", "onShortCutsLoaded", "onVerticalCLicked", "shopName", "shopPoisson", "trackBannerClick", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "trackBannerLoad", "trackBannersEvent", "eventName", "trackEntryPointClicked", "trackGroceryCategoriesSwiped", "trackGroceryCategoryClicked", "trackHeroBannerClick", "trackHeroBannerEvent", "trackHeroBannerLoad", "trackHeroBannerShown", "trackOnRewardsClicked", "trackOrderStatusEvent", "chain", "Lkotlin/Pair;", "Lcom/talabat/fluid/homescreen/domain/tracking/ChainId;", "Lcom/talabat/fluid/homescreen/domain/tracking/ChainName;", "transactionId", "isPickupOrder", "", "(Lkotlin/Pair;Ljava/lang/String;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "trackOrderStatusWidgetClicked", "trackOrderStatusWidgetShown", "trackPastOrderEvent", "trackSecondaryBannerClicked", "trackSecondaryBannerEvent", "trackSecondaryBannerLoaded", "trackSecondaryBannerShown", "trackShopClicked", "trackShortCutsClicked", "trackShortCutsEvents", "trackSubscriptionBannerEvent", "trackSwimLaneItemClicked", "trackSwimLaneLoaded", "trackSwimLaneSwiped", "trackTProSubscriptionBannerClicked", "trackTProSubscriptionBannerLoaded", "trackVoucherCodeEntryClicked", "trackVoucherCodeEntryEvent", "trackVoucherCodeEntryLoaded", "applyLocationData", "applyPlatform", "applyScreenType", "applyShopSponsoringData", "applySwimLaneCommonData", "applyUserLogged", "applyUserTimeStamp", "getOrDefault", "key", "defVal", "orDefault", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenTrackerImpl implements HomeScreenTracker {
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFirebase talabatFirebase;
    @Nullable
    private final TalabatTracker talabatTracker;

    public HomeScreenTrackerImpl(@NotNull Context context2, @NotNull ITalabatFirebase iTalabatFirebase, @Nullable TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFirebase, "talabatFirebase");
        this.context = context2;
        this.talabatFirebase = iTalabatFirebase;
        this.talabatTracker = talabatTracker2;
    }

    public static /* synthetic */ String a(HomeScreenTrackerImpl homeScreenTrackerImpl, Map map, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "N/A";
        }
        return homeScreenTrackerImpl.getOrDefault(map, str, str2);
    }

    private final void applyLocationData(Bundle bundle, LocationDataFactory.LocationData locationData) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        String city = locationData.getCity();
        boolean z16 = true;
        if (city.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str = "N/A";
        if (z11) {
            city = str;
        }
        bundle.putString("locationCity", city);
        String area = locationData.getArea();
        if (area.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            area = str;
        }
        bundle.putString("locationArea", area);
        String country = locationData.getCountry();
        if (country.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            country = str;
        }
        bundle.putString("locationCountry", country);
        String latitude = locationData.getLatitude();
        if (latitude.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            latitude = str;
        }
        bundle.putString("locationLat", latitude);
        String longitude = locationData.getLongitude();
        if (longitude.length() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            longitude = str;
        }
        bundle.putString("locationLon", longitude);
        String address = locationData.getAddress();
        if (address.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            str = address;
        }
        bundle.putString("locationAddress", str);
    }

    private final void applyPlatform(Bundle bundle) {
        bundle.putString("platform", "Android");
    }

    private final void applyScreenType(Bundle bundle) {
        bundle.putString("screenType", "home");
        bundle.putString("screenName", "Home Screen");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r0 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r3 != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyShopSponsoringData(android.os.Bundle r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "sponsoredCategory"
            java.lang.String r1 = ""
            java.lang.String r0 = r6.getOrDefault(r8, r0, r1)
            java.lang.String r2 = "sponsoredType"
            java.lang.String r2 = r6.getOrDefault(r8, r2, r1)
            int r3 = r0.length()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0018
            r3 = r4
            goto L_0x0019
        L_0x0018:
            r3 = r5
        L_0x0019:
            if (r3 == 0) goto L_0x0027
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0023
            r3 = r4
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            if (r3 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r4 = r5
        L_0x0028:
            if (r4 != 0) goto L_0x002c
            r3 = r7
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            if (r3 == 0) goto L_0x004b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "True: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = "__"
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            if (r0 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            java.lang.String r0 = "false"
        L_0x004d:
            java.lang.String r2 = "shopSponsoring"
            r7.putString(r2, r0)
            java.lang.String r0 = "vendorSponsoringPlacement"
            java.lang.String r2 = "home:swimlane"
            r7.putString(r0, r2)
            java.lang.String r0 = "sponsoredToken"
            java.lang.String r8 = r6.getOrDefault(r8, r0, r1)
            java.lang.String r0 = "ncrRequestToken"
            r7.putString(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.applyShopSponsoringData(android.os.Bundle, java.util.Map):void");
    }

    private final void applySwimLaneCommonData(Bundle bundle, Map<String, String> map) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        String str = map.get("position");
        String str2 = "N/A";
        boolean z17 = true;
        String str3 = null;
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = str2;
            }
        } else {
            str = null;
        }
        bundle.putString("position", str);
        String str4 = map.get("swimlaneTitle");
        if (str4 != null) {
            if (str4.length() == 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                str4 = str2;
            }
        } else {
            str4 = null;
        }
        bundle.putString("swimlaneTitle", str4);
        String str5 = map.get("swimlaneTitleList");
        if (str5 != null) {
            if (str5.length() == 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                str5 = str2;
            }
        } else {
            str5 = null;
        }
        bundle.putString("swimlaneTitleList", str5);
        String str6 = map.get("swimlaneStrategyList");
        if (str6 != null) {
            if (str6.length() == 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                str6 = str2;
            }
        } else {
            str6 = null;
        }
        bundle.putString("swimlaneStrategyList", str6);
        String str7 = map.get("swimlaneStrategy");
        if (str7 != null) {
            if (str7.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                str7 = str2;
            }
        } else {
            str7 = null;
        }
        bundle.putString("swimlaneStrategy", str7);
        String str8 = map.get("swimlaneLength");
        if (str8 != null) {
            if (str8.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                str8 = str2;
            }
        } else {
            str8 = null;
        }
        bundle.putString("swimlaneLength", str8);
        String str9 = map.get("swimlaneRequestId");
        if (str9 != null) {
            if (str9.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                str2 = str9;
            }
            str3 = str2;
        }
        bundle.putString("swimlaneRequestId", str3);
    }

    private final void applyUserLogged(Bundle bundle, String str) {
        String str2;
        if (Intrinsics.areEqual((Object) orDefault(str), (Object) "N/A")) {
            str2 = "FALSE";
        } else {
            str2 = "TRUE";
        }
        bundle.putString("userLoggedIn", str2);
    }

    private final void applyUserTimeStamp(Bundle bundle) {
        bundle.putString("userTimeStamp", TrackingHelperKt.getUserTimestamp());
    }

    public static /* synthetic */ void b(HomeScreenTrackerImpl homeScreenTrackerImpl, Pair pair, String str, LocationDataFactory.LocationData locationData, String str2, String str3, Boolean bool, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            bool = null;
        }
        homeScreenTrackerImpl.trackOrderStatusEvent(pair, str, locationData, str2, str3, bool);
    }

    private final Bundle createBundleForBannerEvents(LocationDataFactory.LocationData locationData, Map<String, String> map) {
        Bundle bundle = new Bundle();
        applyScreenType(bundle);
        applyLocationData(bundle, locationData);
        bundle.putString("platform", "Android");
        Map<String, String> map2 = map;
        bundle.putString("chainName", a(this, map2, "chainName", (String) null, 2, (Object) null));
        bundle.putString("shopId", a(this, map2, "shopId", (String) null, 2, (Object) null));
        bundle.putString("shopPosition", a(this, map2, "position", (String) null, 2, (Object) null));
        bundle.putString("shopType", a(this, map2, "shopType", (String) null, 2, (Object) null));
        bundle.putString("deliveryProvider", a(this, map2, "deliveryProvider", (String) null, 2, (Object) null));
        bundle.putString("shopArea", a(this, map2, "shopArea", (String) null, 2, (Object) null));
        bundle.putString("shopMainCuisine", a(this, map2, "shopMainCuisine", (String) null, 2, (Object) null));
        bundle.putString("shopDeliveryTime", a(this, map2, "shopDeliveryTime", (String) null, 2, (Object) null));
        bundle.putString("shopStatus", a(this, map2, "shopStatus", (String) null, 2, (Object) null));
        bundle.putString("shopPaymentMethods", a(this, map2, "shopPaymentMethods", (String) null, 2, (Object) null));
        bundle.putString("shopCokeUpsell", a(this, map2, "shopCokeUpsell", (String) null, 2, (Object) null));
        bundle.putString("bannerZone", a(this, map2, "position", (String) null, 2, (Object) null));
        bundle.putString("shopName", a(this, map2, "shopName", (String) null, 2, (Object) null));
        bundle.putString("chainId", a(this, map2, "chainId", (String) null, 2, (Object) null));
        bundle.putString("bannerId", a(this, map2, "bannerId", (String) null, 2, (Object) null));
        bundle.putString("bannerName", a(this, map2, "bannerName", (String) null, 2, (Object) null));
        bundle.putString("shopClickOrigin", "banner");
        bundle.putString("vendorSponsoringPlacement", "home_screen:banner");
        return bundle;
    }

    private final String getOrDefault(Map<String, String> map, String str, String str2) {
        String str3 = map.get(str);
        if (str3 == null) {
            return str2;
        }
        if (!(str3.length() > 0)) {
            str3 = null;
        }
        return str3 == null ? str2 : str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r5 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onVerticalCLicked(java.lang.String r5, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            tracking.gtm.ITalabatFirebase r0 = r4.talabatFirebase
            android.content.Context r1 = r4.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r5 == 0) goto L_0x001a
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r5 = 0
        L_0x0018:
            if (r5 != 0) goto L_0x001c
        L_0x001a:
            java.lang.String r5 = "N/A"
        L_0x001c:
            java.lang.String r3 = "userId"
            r2.putString(r3, r5)
            java.lang.String r5 = "screenName"
            java.lang.String r3 = "Home Screen"
            r2.putString(r5, r3)
            r2.putString(r5, r3)
            java.lang.String r5 = "verticalName"
            r2.putString(r5, r7)
            java.lang.String r5 = "verticalPosition"
            r2.putString(r5, r8)
            r4.applyLocationData(r2, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.String r5 = "vertical_clicked"
            r0.dispatchEvent(r1, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.onVerticalCLicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.lang.String, java.lang.String):void");
    }

    private final String orDefault(String str) {
        if (!(true ^ (str == null || str.length() == 0))) {
            str = null;
        }
        return str == null ? "N/A" : str;
    }

    private final void trackBannersEvent(String str, LocationDataFactory.LocationData locationData, Map<String, String> map, IObservabilityManager iObservabilityManager) {
        String str2;
        Bundle createBundleForBannerEvents = createBundleForBannerEvents(locationData, map);
        this.talabatFirebase.dispatchEvent(this.context, str, createBundleForBannerEvents);
        HashMap hashMap = new HashMap();
        for (String next : createBundleForBannerEvents.keySet()) {
            Object obj = createBundleForBannerEvents.get(next);
            if (obj != null) {
                str2 = obj.toString();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(next, str2);
        }
        iObservabilityManager.trackAdExEvent(str, hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r13 == null) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackHeroBannerEvent(java.lang.String r12, java.lang.String r13, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r14, java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            r11 = this;
            tracking.gtm.ITalabatFirebase r0 = r11.talabatFirebase
            android.content.Context r1 = r11.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "N/A"
            if (r13 == 0) goto L_0x001c
            int r4 = r13.length()
            if (r4 <= 0) goto L_0x0015
            r4 = 1
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            if (r13 != 0) goto L_0x001d
        L_0x001c:
            r13 = r3
        L_0x001d:
            java.lang.String r4 = "userId"
            r2.putString(r4, r13)
            java.lang.String r7 = "shopType"
            r8 = 0
            r9 = 2
            r10 = 0
            r5 = r11
            r6 = r15
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "shopType"
            r2.putString(r4, r13)
            java.lang.String r7 = "shopId"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "shopId"
            r2.putString(r4, r13)
            java.lang.String r7 = "shopName"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "shopName"
            r2.putString(r4, r13)
            java.lang.String r7 = "chainId"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "chainId"
            r2.putString(r4, r13)
            java.lang.String r7 = "chainName"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "chainName"
            r2.putString(r4, r13)
            java.lang.String r7 = "campaign"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "campaign"
            r2.putString(r4, r13)
            java.lang.String r7 = "offerVoucherId"
            java.lang.String r13 = a(r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "offerVoucherId"
            r2.putString(r4, r13)
            java.lang.String r13 = "bannerId"
            java.lang.String r3 = r11.getOrDefault(r15, r13, r3)
            r2.putString(r13, r3)
            java.lang.String r13 = "tmart"
            java.lang.String r3 = "bannerName"
            java.lang.String r13 = r11.getOrDefault(r15, r3, r13)
            r2.putString(r3, r13)
            java.lang.String r6 = "bannerTotal"
            r7 = 0
            r8 = 2
            r9 = 0
            r4 = r11
            r5 = r15
            java.lang.String r13 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r3 = "bannerTotal"
            r2.putString(r3, r13)
            java.lang.String r6 = "bannerList"
            java.lang.String r13 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r3 = "bannerList"
            r2.putString(r3, r13)
            java.lang.String r6 = "bannerType"
            java.lang.String r13 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r3 = "bannerType"
            r2.putString(r3, r13)
            java.lang.String r6 = "bannerPosition"
            java.lang.String r13 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r15 = "bannerPosition"
            r2.putString(r15, r13)
            r11.applyScreenType(r2)
            r11.applyLocationData(r2, r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r12, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackHeroBannerEvent(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r5 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackOnRewardsClicked(java.lang.String r5, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r6) {
        /*
            r4 = this;
            tracking.gtm.ITalabatFirebase r0 = r4.talabatFirebase
            android.content.Context r1 = r4.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r5 == 0) goto L_0x001a
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r5 = 0
        L_0x0018:
            if (r5 != 0) goto L_0x001c
        L_0x001a:
            java.lang.String r5 = "N/A"
        L_0x001c:
            java.lang.String r3 = "userId"
            r2.putString(r3, r5)
            java.lang.String r5 = "navigationOption"
            java.lang.String r3 = "Rewards"
            r2.putString(r5, r3)
            java.lang.String r5 = "eventOrigin"
            java.lang.String r3 = "home"
            r2.putString(r5, r3)
            r4.applyScreenType(r2)
            r4.applyLocationData(r2, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.String r5 = "navigation_option_clicked"
            r0.dispatchEvent(r1, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackOnRewardsClicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData):void");
    }

    private final void trackOrderStatusEvent(Pair<String, String> pair, String str, LocationDataFactory.LocationData locationData, String str2, String str3, Boolean bool) {
        ITalabatFirebase iTalabatFirebase = this.talabatFirebase;
        Context context2 = this.context;
        Bundle bundle = new Bundle();
        applyScreenType(bundle);
        applyLocationData(bundle, locationData);
        bundle.putString("userId", orDefault(str2));
        bundle.putString("chainId", pair.component1());
        bundle.putString("chainName", pair.component2());
        bundle.putString("transactionId", str3);
        bundle.putString("eventOrigin", "home");
        if (bool != null) {
            bundle.putBoolean("orderPickup", bool.booleanValue());
        }
        Unit unit = Unit.INSTANCE;
        iTalabatFirebase.dispatchEvent(context2, str, bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r10 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackPastOrderEvent(java.lang.String r9, java.lang.String r10, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r11, java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            r8 = this;
            tracking.gtm.ITalabatFirebase r0 = r8.talabatFirebase
            android.content.Context r1 = r8.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r3 = 0
            r4 = 1
            r5 = 0
            java.lang.String r6 = "N/A"
            if (r10 == 0) goto L_0x001f
            int r7 = r10.length()
            if (r7 <= 0) goto L_0x0018
            r7 = r4
            goto L_0x0019
        L_0x0018:
            r7 = r5
        L_0x0019:
            if (r7 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r10 = r3
        L_0x001d:
            if (r10 != 0) goto L_0x0020
        L_0x001f:
            r10 = r6
        L_0x0020:
            java.lang.String r7 = "userId"
            r2.putString(r7, r10)
            r8.applyScreenType(r2)
            r8.applyLocationData(r2, r11)
            java.lang.String r10 = "swimlaneTotal"
            java.lang.Object r11 = r12.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0043
            int r7 = r11.length()
            if (r7 != 0) goto L_0x003e
            r7 = r4
            goto L_0x003f
        L_0x003e:
            r7 = r5
        L_0x003f:
            if (r7 == 0) goto L_0x0044
            r11 = r6
            goto L_0x0044
        L_0x0043:
            r11 = r3
        L_0x0044:
            r2.putString(r10, r11)
            java.lang.String r10 = "swimlaneTilesDisplayed"
            java.lang.Object r11 = r12.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x005e
            int r7 = r11.length()
            if (r7 != 0) goto L_0x0059
            r7 = r4
            goto L_0x005a
        L_0x0059:
            r7 = r5
        L_0x005a:
            if (r7 == 0) goto L_0x005f
            r11 = r6
            goto L_0x005f
        L_0x005e:
            r11 = r3
        L_0x005f:
            r2.putString(r10, r11)
            java.lang.String r10 = "shopsIds"
            java.lang.Object r11 = r12.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0079
            int r3 = r11.length()
            if (r3 != 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r4 = r5
        L_0x0074:
            if (r4 == 0) goto L_0x0078
            r3 = r6
            goto L_0x0079
        L_0x0078:
            r3 = r11
        L_0x0079:
            r2.putString(r10, r3)
            r8.applySwimLaneCommonData(r2, r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r9, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackPastOrderEvent(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r11 == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackSecondaryBannerEvent(java.lang.String r10, java.lang.String r11, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r9 = this;
            tracking.gtm.ITalabatFirebase r0 = r9.talabatFirebase
            android.content.Context r1 = r9.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r9.applyScreenType(r2)
            r9.applyLocationData(r2, r12)
            if (r11 == 0) goto L_0x0020
            int r12 = r11.length()
            if (r12 <= 0) goto L_0x0019
            r12 = 1
            goto L_0x001a
        L_0x0019:
            r12 = 0
        L_0x001a:
            if (r12 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r11 = 0
        L_0x001e:
            if (r11 != 0) goto L_0x0022
        L_0x0020:
            java.lang.String r11 = "N/A"
        L_0x0022:
            java.lang.String r12 = "userId"
            r2.putString(r12, r11)
            java.lang.String r5 = "bannerId"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r9
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "bannerId"
            r2.putString(r12, r11)
            java.lang.String r5 = "bannerPosition"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "bannerPosition"
            r2.putString(r12, r11)
            java.lang.String r5 = "bannerType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "bannerType"
            r2.putString(r12, r11)
            java.lang.String r5 = "bannerName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "bannerName"
            r2.putString(r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r10, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackSecondaryBannerEvent(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r9 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackShortCutsClicked(java.lang.String r9, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            r8 = this;
            tracking.gtm.ITalabatFirebase r0 = r8.talabatFirebase
            android.content.Context r1 = r8.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r3 = 0
            r4 = 1
            r5 = 0
            java.lang.String r6 = "N/A"
            if (r9 == 0) goto L_0x001f
            int r7 = r9.length()
            if (r7 <= 0) goto L_0x0018
            r7 = r4
            goto L_0x0019
        L_0x0018:
            r7 = r5
        L_0x0019:
            if (r7 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r9 = r3
        L_0x001d:
            if (r9 != 0) goto L_0x0020
        L_0x001f:
            r9 = r6
        L_0x0020:
            java.lang.String r7 = "userId"
            r2.putString(r7, r9)
            r8.applyScreenType(r2)
            r8.applyLocationData(r2, r10)
            java.lang.String r9 = "channel"
            java.lang.Object r10 = r11.get(r9)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0043
            int r7 = r10.length()
            if (r7 != 0) goto L_0x003e
            r7 = r4
            goto L_0x003f
        L_0x003e:
            r7 = r5
        L_0x003f:
            if (r7 == 0) goto L_0x0044
            r10 = r6
            goto L_0x0044
        L_0x0043:
            r10 = r3
        L_0x0044:
            r2.putString(r9, r10)
            java.lang.String r9 = "position"
            java.lang.Object r9 = r11.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x005e
            int r10 = r9.length()
            if (r10 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r4 = r5
        L_0x0059:
            if (r4 == 0) goto L_0x005d
            r3 = r6
            goto L_0x005e
        L_0x005d:
            r3 = r9
        L_0x005e:
            java.lang.String r9 = "channelPosition"
            r2.putString(r9, r3)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            java.lang.String r9 = "carousel_clicked"
            r0.dispatchEvent(r1, r9, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackShortCutsClicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r10 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackShortCutsEvents(java.lang.String r9, java.lang.String r10, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r11, java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            r8 = this;
            tracking.gtm.ITalabatFirebase r0 = r8.talabatFirebase
            android.content.Context r1 = r8.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r3 = 0
            r4 = 1
            r5 = 0
            java.lang.String r6 = "N/A"
            if (r10 == 0) goto L_0x001f
            int r7 = r10.length()
            if (r7 <= 0) goto L_0x0018
            r7 = r4
            goto L_0x0019
        L_0x0018:
            r7 = r5
        L_0x0019:
            if (r7 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r10 = r3
        L_0x001d:
            if (r10 != 0) goto L_0x0020
        L_0x001f:
            r10 = r6
        L_0x0020:
            java.lang.String r7 = "userId"
            r2.putString(r7, r10)
            r8.applyScreenType(r2)
            r8.applyLocationData(r2, r11)
            java.lang.String r10 = "collections_items"
            java.lang.Object r10 = r12.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0043
            int r11 = r10.length()
            if (r11 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = r5
        L_0x003e:
            if (r4 == 0) goto L_0x0042
            r3 = r6
            goto L_0x0043
        L_0x0042:
            r3 = r10
        L_0x0043:
            java.lang.String r10 = "channelIndex"
            r2.putString(r10, r3)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r9, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackShortCutsEvents(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r11 == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackSubscriptionBannerEvent(java.lang.String r10, java.lang.String r11, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r9 = this;
            tracking.gtm.ITalabatFirebase r0 = r9.talabatFirebase
            android.content.Context r1 = r9.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r9.applyScreenType(r2)
            r9.applyLocationData(r2, r12)
            if (r11 == 0) goto L_0x0020
            int r12 = r11.length()
            if (r12 <= 0) goto L_0x0019
            r12 = 1
            goto L_0x001a
        L_0x0019:
            r12 = 0
        L_0x001a:
            if (r12 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r11 = 0
        L_0x001e:
            if (r11 != 0) goto L_0x0022
        L_0x0020:
            java.lang.String r11 = "N/A"
        L_0x0022:
            java.lang.String r12 = "userId"
            r2.putString(r12, r11)
            java.lang.String r5 = "userPreferences"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r9
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "userPreferences"
            r2.putString(r12, r11)
            java.lang.String r5 = "bannerId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "bannerId"
            r2.putString(r12, r11)
            java.lang.String r11 = "tmart"
            java.lang.String r12 = "bannerName"
            java.lang.String r11 = r9.getOrDefault(r13, r12, r11)
            r2.putString(r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r10, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackSubscriptionBannerEvent(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r3 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackVoucherCodeEntryEvent(java.lang.String r6, java.lang.String r7, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            r5 = this;
            tracking.gtm.ITalabatFirebase r0 = r5.talabatFirebase
            android.content.Context r1 = r5.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r7 == 0) goto L_0x001b
            int r3 = r7.length()
            if (r3 <= 0) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 == 0) goto L_0x0018
            r3 = r7
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            if (r3 != 0) goto L_0x001d
        L_0x001b:
            java.lang.String r3 = "N/A"
        L_0x001d:
            java.lang.String r4 = "userId"
            r2.putString(r4, r3)
            r5.applyScreenType(r2)
            r5.applyUserLogged(r2, r7)
            r5.applyUserTimeStamp(r2)
            r5.applyLocationData(r2, r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            java.util.Set r7 = r9.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0039:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0055
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            r2.putString(r9, r8)
            goto L_0x0039
        L_0x0055:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r0.dispatchEvent(r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackVoucherCodeEntryEvent(java.lang.String, java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    public void onRewardsClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        trackOnRewardsClicked(str, locationData);
    }

    public void onShorCutsClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackShortCutsClicked(str, locationData, map);
    }

    public void onShorCutsSwiped(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackShortCutsEvents("carousel_swiped", str, locationData, map);
    }

    public void onShortCutsLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackShortCutsEvents("carousel_loaded", str, locationData, map);
    }

    public void trackBannerClick(@NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        trackBannersEvent(ValuePropBannerClicked.EVENT_NAME, locationData, map, iObservabilityManager);
    }

    public void trackBannerLoad(@NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        trackBannersEvent(ValuePropBannerShown.EVENT_NAME, locationData, map, iObservabilityManager);
    }

    public void trackEntryPointClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Map<String, String> map2 = map;
        onVerticalCLicked(str, locationData, a(this, map2, "shopName", (String) null, 2, (Object) null), a(this, map2, "position", (String) null, 2, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r11 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackGroceryCategoriesSwiped(@org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "locationData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            tracking.gtm.ITalabatFirebase r0 = r10.talabatFirebase
            android.content.Context r1 = r10.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r11 == 0) goto L_0x0024
            int r3 = r11.length()
            if (r3 <= 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r11 = 0
        L_0x0022:
            if (r11 != 0) goto L_0x0026
        L_0x0024:
            java.lang.String r11 = "N/A"
        L_0x0026:
            java.lang.String r3 = "userId"
            r2.putString(r3, r11)
            r10.applyScreenType(r2)
            r10.applyLocationData(r2, r12)
            r10.applyPlatform(r2)
            java.lang.String r6 = "shopId"
            r7 = 0
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r13
            java.lang.String r11 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = "shopId"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetName"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r10
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetName"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetType"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetPosition"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetPosition"
            r2.putString(r12, r11)
            java.lang.String r5 = "listingPageType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "listingPageType"
            r2.putString(r12, r11)
            java.lang.String r5 = "categoryId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "categoryId"
            r2.putString(r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            java.lang.String r11 = "widget_shown"
            r0.dispatchEvent(r1, r11, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackGroceryCategoriesSwiped(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r11 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackGroceryCategoryClicked(@org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "locationData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            tracking.gtm.ITalabatFirebase r0 = r10.talabatFirebase
            android.content.Context r1 = r10.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r11 == 0) goto L_0x0024
            int r3 = r11.length()
            if (r3 <= 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r11 = 0
        L_0x0022:
            if (r11 != 0) goto L_0x0026
        L_0x0024:
            java.lang.String r11 = "N/A"
        L_0x0026:
            java.lang.String r3 = "userId"
            r2.putString(r3, r11)
            r10.applyScreenType(r2)
            r10.applyLocationData(r2, r12)
            r10.applyPlatform(r2)
            java.lang.String r6 = "shopId"
            r7 = 0
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r13
            java.lang.String r11 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = "shopId"
            r2.putString(r12, r11)
            java.lang.String r5 = "eventOrigin"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r10
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "eventOrigin"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopClickOrigin"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopClickOrigin"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetName"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetType"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetPosition"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetPosition"
            r2.putString(r12, r11)
            java.lang.String r5 = "listingPageType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "listingPageType"
            r2.putString(r12, r11)
            java.lang.String r5 = "categoryId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "categoryId"
            r2.putString(r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            java.lang.String r11 = "category_details_loaded"
            r0.dispatchEvent(r1, r11, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackGroceryCategoryClicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    public void trackHeroBannerClick(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackHeroBannerEvent("hero_banner_clicked", str, locationData, map);
    }

    public void trackHeroBannerLoad(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackHeroBannerEvent(TMartGrowthTracker.UNCLAIMED_WIDGET_LOADED, str, locationData, map);
    }

    public void trackHeroBannerShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackHeroBannerEvent("hero_banner_shown", str, locationData, map);
    }

    public void trackOrderStatusWidgetClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Pair<String, String> pair, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(pair, "chain");
        Intrinsics.checkNotNullParameter(str2, "transactionId");
        trackOrderStatusEvent(pair, "order_tracking_widget_clicked", locationData, str, str2, Boolean.valueOf(z11));
    }

    public void trackOrderStatusWidgetShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Pair<String, String> pair, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(pair, "chain");
        Intrinsics.checkNotNullParameter(str2, "transactionId");
        b(this, pair, "order_tracking_widget_shown", locationData, str, str2, (Boolean) null, 32, (Object) null);
    }

    public void trackSecondaryBannerClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackSecondaryBannerEvent("banner_clicked", str, locationData, map);
    }

    public void trackSecondaryBannerLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackSecondaryBannerEvent("banner_loaded", str, locationData, map);
    }

    public void trackSecondaryBannerShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackSecondaryBannerEvent("banner_shown", str, locationData, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r11 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackShopClicked(@org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "locationData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            tracking.gtm.ITalabatFirebase r0 = r10.talabatFirebase
            android.content.Context r1 = r10.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r11 == 0) goto L_0x0024
            int r3 = r11.length()
            if (r3 <= 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r11 = 0
        L_0x0022:
            if (r11 != 0) goto L_0x0026
        L_0x0024:
            java.lang.String r11 = "N/A"
        L_0x0026:
            java.lang.String r3 = "userId"
            r2.putString(r3, r11)
            r10.applyScreenType(r2)
            r10.applyLocationData(r2, r12)
            r10.applyPlatform(r2)
            java.lang.String r6 = "shopType"
            r7 = 0
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r13
            java.lang.String r11 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = "shopType"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopId"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r10
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopId"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopName"
            r2.putString(r12, r11)
            java.lang.String r5 = "chainId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "chainId"
            r2.putString(r12, r11)
            java.lang.String r5 = "chainName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "chainName"
            r2.putString(r12, r11)
            java.lang.String r5 = "eventOrigin"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "eventOrigin"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopClickOrigin"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopClickOrigin"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetName"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetType"
            r2.putString(r12, r11)
            java.lang.String r5 = "widgetPosition"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "widgetPosition"
            r2.putString(r12, r11)
            java.lang.String r5 = "listingPageType"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "listingPageType"
            r2.putString(r12, r11)
            java.lang.String r5 = "categoryId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "categoryId"
            r2.putString(r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            java.lang.String r11 = "shop_clicked"
            r0.dispatchEvent(r1, r11, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackShopClicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r11 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackSwimLaneItemClicked(@org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r12, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "locationData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            tracking.gtm.ITalabatFirebase r0 = r10.talabatFirebase
            android.content.Context r1 = r10.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r11 == 0) goto L_0x0024
            int r3 = r11.length()
            if (r3 <= 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r11 = 0
        L_0x0022:
            if (r11 != 0) goto L_0x0026
        L_0x0024:
            java.lang.String r11 = "N/A"
        L_0x0026:
            java.lang.String r3 = "userId"
            r2.putString(r3, r11)
            r10.applyScreenType(r2)
            r10.applyLocationData(r2, r12)
            java.lang.String r6 = "shopType"
            r7 = 0
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r13
            java.lang.String r11 = a(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = "shopType"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopId"
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r10
            r4 = r13
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopId"
            r2.putString(r12, r11)
            java.lang.String r5 = "shopName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopName"
            r2.putString(r12, r11)
            java.lang.String r5 = "chainId"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "chainId"
            r2.putString(r12, r11)
            java.lang.String r5 = "chainName"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "chainName"
            r2.putString(r12, r11)
            java.lang.String r5 = "eventOrigin"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "eventOrigin"
            r2.putString(r12, r11)
            java.lang.String r11 = "shopClickOrigin"
            java.lang.String r12 = "swimlane"
            r2.putString(r11, r12)
            java.lang.String r5 = "position"
            java.lang.String r11 = a(r3, r4, r5, r6, r7, r8)
            java.lang.String r12 = "shopPosition"
            r2.putString(r12, r11)
            r10.applySwimLaneCommonData(r2, r13)
            r10.applyShopSponsoringData(r2, r13)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            java.lang.String r11 = "shop_clicked"
            r0.dispatchEvent(r1, r11, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackSwimLaneItemClicked(java.lang.String, com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    public void trackSwimLaneLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackPastOrderEvent("swimlane_loaded", str, locationData, map);
    }

    public void trackSwimLaneSwiped(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackPastOrderEvent("swimlane_swiped", str, locationData, map);
    }

    public void trackTProSubscriptionBannerClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackSubscriptionBannerEvent("subscription_banner_clicked", str, locationData, map);
    }

    public void trackTProSubscriptionBannerLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackSubscriptionBannerEvent("subscription_banner_loaded", str, locationData, map);
    }

    public void trackVoucherCodeEntryClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackVoucherCodeEntryEvent("add_code_clicked", str, locationData, map);
    }

    public void trackVoucherCodeEntryLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        trackVoucherCodeEntryEvent("add_code_loaded", str, locationData, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0168, code lost:
        if (r0 != null) goto L_0x016d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackSwimLaneSwiped(@org.jetbrains.annotations.NotNull com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory.LocationData r38, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r39) {
        /*
            r37 = this;
            r6 = r37
            r7 = r39
            java.lang.String r0 = "locationData"
            r1 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "sponsoredCategory"
            java.lang.String r2 = ""
            java.lang.String r8 = r6.getOrDefault(r7, r0, r2)
            java.lang.String r0 = "sponsoredType"
            java.lang.String r9 = r6.getOrDefault(r7, r0, r2)
            com.talabat.core.tracking.domain.TalabatTracker r10 = r6.talabatTracker
            if (r10 == 0) goto L_0x0193
            java.lang.String r0 = r38.getAddress()
            int r2 = r0.length()
            r12 = 0
            if (r2 != 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = r12
        L_0x0030:
            java.lang.String r3 = "N/A"
            if (r2 == 0) goto L_0x0036
            r14 = r3
            goto L_0x0037
        L_0x0036:
            r14 = r0
        L_0x0037:
            java.lang.String r0 = r38.getLatitude()
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x0043:
            r2 = r12
        L_0x0044:
            if (r2 == 0) goto L_0x0048
            r15 = r3
            goto L_0x0049
        L_0x0048:
            r15 = r0
        L_0x0049:
            java.lang.String r0 = r38.getLongitude()
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0055
            r2 = 1
            goto L_0x0056
        L_0x0055:
            r2 = r12
        L_0x0056:
            if (r2 == 0) goto L_0x005b
            r16 = r3
            goto L_0x005d
        L_0x005b:
            r16 = r0
        L_0x005d:
            java.lang.String r0 = r38.getCity()
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0069:
            r2 = r12
        L_0x006a:
            if (r2 == 0) goto L_0x006f
            r17 = r3
            goto L_0x0071
        L_0x006f:
            r17 = r0
        L_0x0071:
            java.lang.String r0 = r38.getArea()
            int r2 = r0.length()
            if (r2 != 0) goto L_0x007d
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = r12
        L_0x007e:
            if (r2 == 0) goto L_0x0083
            r18 = r3
            goto L_0x0085
        L_0x0083:
            r18 = r0
        L_0x0085:
            java.lang.String r0 = r38.getCountry()
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0091
            r1 = 1
            goto L_0x0092
        L_0x0091:
            r1 = r12
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r19 = r3
            goto L_0x0099
        L_0x0097:
            r19 = r0
        L_0x0099:
            tracking.events.ShopImpressionLoadedEvent$LocationAttributes r5 = new tracking.events.ShopImpressionLoadedEvent$LocationAttributes
            r13 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19)
            tracking.events.ShopImpressionLoadedEvent$ScreenAttributes r13 = new tracking.events.ShopImpressionLoadedEvent$ScreenAttributes
            java.lang.String r0 = "home"
            java.lang.String r1 = "Home Screen"
            r13.<init>(r0, r1)
            tracking.events.ShopImpressionLoadedEvent$SwimlaneAttributes r15 = new tracking.events.ShopImpressionLoadedEvent$SwimlaneAttributes
            java.lang.String r2 = "swimlaneTitle"
            r3 = 0
            r4 = 2
            r14 = 0
            r0 = r37
            r1 = r39
            r11 = r5
            r5 = r14
            java.lang.String r16 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneTitleList"
            r5 = 0
            java.lang.String r17 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneTotal"
            java.lang.String r18 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "position"
            java.lang.String r19 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneStrategy"
            java.lang.String r20 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneStrategyList"
            java.lang.String r21 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneTilesDisplayed"
            java.lang.String r22 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneLength"
            java.lang.String r23 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "swimlaneRequestId"
            java.lang.String r0 = a(r0, r1, r2, r3, r4, r5)
            r14 = r15
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            java.lang.String r2 = "chainId"
            r14 = 0
            r0 = r37
            r15 = r5
            r5 = r14
            java.lang.String r26 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "chainName"
            r5 = 0
            java.lang.String r27 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "shopType"
            java.lang.String r28 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "shopId"
            java.lang.String r29 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "shopName"
            java.lang.String r30 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r2 = "position"
            java.lang.String r31 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r32 = "home:swimlane"
            int r0 = r8.length()
            if (r0 != 0) goto L_0x0135
            r0 = 1
            goto L_0x0136
        L_0x0135:
            r0 = r12
        L_0x0136:
            if (r0 == 0) goto L_0x0146
            int r0 = r9.length()
            if (r0 != 0) goto L_0x0140
            r0 = 1
            goto L_0x0141
        L_0x0140:
            r0 = r12
        L_0x0141:
            if (r0 == 0) goto L_0x0146
            r24 = 1
            goto L_0x0148
        L_0x0146:
            r24 = r12
        L_0x0148:
            if (r24 != 0) goto L_0x014c
            r0 = r6
            goto L_0x014d
        L_0x014c:
            r0 = 0
        L_0x014d:
            if (r0 == 0) goto L_0x016b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "True: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = "__"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            java.lang.String r0 = "false"
        L_0x016d:
            r33 = r0
            java.lang.String r2 = "sponsoredToken"
            r3 = 0
            r4 = 2
            r5 = 0
            r0 = r37
            r1 = r39
            java.lang.String r34 = a(r0, r1, r2, r3, r4, r5)
            java.lang.String r35 = "swimlane"
            java.lang.String r2 = "eventOrigin"
            java.lang.String r36 = a(r0, r1, r2, r3, r4, r5)
            tracking.events.ShopImpressionLoadedEvent$ShopAttributes r0 = new tracking.events.ShopImpressionLoadedEvent$ShopAttributes
            r25 = r0
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            tracking.events.ShopImpressionLoadedEvent r1 = new tracking.events.ShopImpressionLoadedEvent
            r1.<init>(r11, r13, r15, r0)
            r10.track(r1)
        L_0x0193:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl.trackSwimLaneSwiped(com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData, java.util.Map):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenTrackerImpl(Context context2, ITalabatFirebase iTalabatFirebase, TalabatTracker talabatTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, iTalabatFirebase, (i11 & 4) != 0 ? null : talabatTracker2);
    }
}
