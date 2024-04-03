package com.talabat.core.flutter.channels.impl.data.tracking;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import com.talabat.fluttercore.tracking.event.BrazeAddToCartEvent;
import datamodels.Country;
import datamodels.CustomerInfo;
import datamodels.MostRecentOrderList;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAppBoy;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J,\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0013H\u0016J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tracking/AnalyticsMethodChannelCallbackImpl;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "context", "Landroid/content/Context;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/content/Context;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "logFlutterEvent", "", "eventName", "", "events", "", "", "track", "featureName", "attributes", "", "trackBasketEventWithBraze", "trackEvent", "event", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "trackOnGa", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsMethodChannelCallbackImpl implements AnalyticsMethodChannelCallback {
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public AnalyticsMethodChannelCallbackImpl(@NotNull @ApplicationContext Context context2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.context = context2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatTracker = talabatTracker2;
    }

    private final void trackBasketEventWithBraze(String str, Map<String, String> map) {
        if (!this.talabatFeatureFlag.getFeatureFlag(PlatformFeatureFlagsKeys.BRAZE_FLUTTER_SDK, false)) {
            trackEvent(new BrazeAddToCartEvent(TalabatAppBoy.EVENT_NAME_ADD_TO_BASKET, str, map));
        }
    }

    private final void trackOnGa(String str, Map<String, String> map, String str2) {
        String str3;
        if (Intrinsics.areEqual((Object) str, (Object) "helpcentre_link_clicked")) {
            MostRecentOrderList mostRecentOrderList = new MostRecentOrderList();
            mostRecentOrderList.encryptedOrderId = map.get("transactionId");
            TalabatGTM.Companion companion = TalabatGTM.Companion;
            Context context2 = this.context;
            String str4 = map.get("screenName");
            if (str4 == null) {
                str3 = str2;
            } else {
                str3 = str4;
            }
            companion.onHelpcentreLinkClicked(context2, mostRecentOrderList, "help_center", str3, str2, map.get("contactOption"));
        } else if (!Intrinsics.areEqual((Object) str, (Object) "screen_opened")) {
            TalabatGTM.Companion.logFlutterEvents(this.context, str, MapsKt__MapsKt.toMutableMap(map));
        } else if (Intrinsics.areEqual((Object) "help_center", (Object) str2)) {
            TalabatGTM.Companion companion2 = TalabatGTM.Companion;
            Context context3 = this.context;
            String str5 = map.get("screenName");
            if (str5 != null) {
                str2 = str5;
            }
            companion2.pushOpenScreenEvent(context3, str2, (Country) null, (CustomerInfo) null);
        } else {
            TalabatGTM.Companion.logFlutterEvents(this.context, str, MapsKt__MapsKt.toMutableMap(map));
        }
    }

    @Deprecated(message = "Use track method for new features.")
    public void logFlutterEvent(@NotNull String str, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "events");
        TalabatGTM.Companion.logFlutterEvents(this.context, str, map);
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        trackEvent(new AnalyticsMethodChannelCallbackImpl$track$event$1(str, str2, map));
        trackOnGa(str, map, str2);
        if (Intrinsics.areEqual((Object) str, (Object) "add_to_cart")) {
            trackBasketEventWithBraze(str2, map);
        }
    }

    public void trackEvent(@NotNull TalabatEvent talabatEvent) {
        Intrinsics.checkNotNullParameter(talabatEvent, "event");
        this.talabatTracker.track(talabatEvent);
    }
}
