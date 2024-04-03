package com.talabat.core.flutter.channels.impl.data.tracking;

import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8VX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tracking/TrackingChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "analyticsCallback", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "flutterMigrationTools", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "(Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;)V", "analyticsMethodCallHandler", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "getAnalyticsMethodCallHandler", "()Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "analyticsMethodCallHandler$delegate", "Lkotlin/Lazy;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingChannelCallbackImpl implements TrackingChannelCallback {
    /* access modifiers changed from: private */
    @NotNull
    public final AnalyticsMethodChannelCallback analyticsCallback;
    @NotNull
    private final Lazy analyticsMethodCallHandler$delegate;

    @Inject
    public TrackingChannelCallbackImpl(@NotNull AnalyticsMethodChannelCallback analyticsMethodChannelCallback, @NotNull FlutterMigrationTools flutterMigrationTools) {
        Intrinsics.checkNotNullParameter(analyticsMethodChannelCallback, "analyticsCallback");
        Intrinsics.checkNotNullParameter(flutterMigrationTools, "flutterMigrationTools");
        this.analyticsCallback = analyticsMethodChannelCallback;
        this.analyticsMethodCallHandler$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TrackingChannelCallbackImpl$analyticsMethodCallHandler$2(flutterMigrationTools, this));
    }

    @NotNull
    public AnalyticsMethodChannel getAnalyticsMethodCallHandler() {
        return (AnalyticsMethodChannel) this.analyticsMethodCallHandler$delegate.getValue();
    }
}
