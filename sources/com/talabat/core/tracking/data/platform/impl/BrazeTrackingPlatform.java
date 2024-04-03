package com.talabat.core.tracking.data.platform.impl;

import android.content.Context;
import com.talabat.braze.BrazeTracker;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/BrazeTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "context", "Landroid/content/Context;", "brazeTracker", "Lcom/talabat/braze/BrazeTracker;", "(Landroid/content/Context;Lcom/talabat/braze/BrazeTracker;)V", "track", "", "eventName", "", "attributes", "", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeTrackingPlatform implements TrackingPlatform {
    @NotNull
    private final BrazeTracker brazeTracker;
    @NotNull
    private final Context context;

    public BrazeTrackingPlatform(@NotNull Context context2, @NotNull BrazeTracker brazeTracker2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(brazeTracker2, "brazeTracker");
        this.context = context2;
        this.brazeTracker = brazeTracker2;
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        return TrackingPlatform.DefaultImpls.getCommonAttributes(this, str);
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.brazeTracker.logCustomEvent(str, map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeTrackingPlatform(Context context2, BrazeTracker brazeTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? BrazeTracker.INSTANCE.initialize(context2) : brazeTracker2);
    }
}
