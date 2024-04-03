package com.talabat.core.flutter.channels.impl.data.tracking;

import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TrackingChannelCallbackImpl$analyticsMethodCallHandler$2 extends Lambda implements Function0<AnalyticsMethodChannel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FlutterMigrationTools f55934g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TrackingChannelCallbackImpl f55935h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrackingChannelCallbackImpl$analyticsMethodCallHandler$2(FlutterMigrationTools flutterMigrationTools, TrackingChannelCallbackImpl trackingChannelCallbackImpl) {
        super(0);
        this.f55934g = flutterMigrationTools;
        this.f55935h = trackingChannelCallbackImpl;
    }

    @NotNull
    public final AnalyticsMethodChannel invoke() {
        AnalyticsMethodChannel analyticsMethodChannel = new AnalyticsMethodChannel(this.f55934g);
        analyticsMethodChannel.setCallback(this.f55935h.analyticsCallback);
        return analyticsMethodChannel;
    }
}
