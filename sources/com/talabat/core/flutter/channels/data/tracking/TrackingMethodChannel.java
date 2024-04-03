package com.talabat.core.flutter.channels.data.tracking;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/data/tracking/TrackingMethodChannel;", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;)V", "analyticsChannel", "Lio/flutter/plugin/common/MethodChannel;", "getAnalyticsChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setAnalyticsChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onDetach", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingMethodChannel implements TrackingChannelFlutterDomain {
    @Nullable
    private MethodChannel analyticsChannel;
    @NotNull
    private final TrackingChannelCallback callback;

    public TrackingMethodChannel(@NotNull TrackingChannelCallback trackingChannelCallback) {
        Intrinsics.checkNotNullParameter(trackingChannelCallback, "callback");
        this.callback = trackingChannelCallback;
    }

    @Nullable
    public final MethodChannel getAnalyticsChannel() {
        return this.analyticsChannel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.ANALYTICS_CHANNEL);
        this.analyticsChannel = methodChannel;
        methodChannel.setMethodCallHandler(this.callback.getAnalyticsMethodCallHandler());
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        TrackingChannelFlutterDomain.DefaultImpls.onAttachWithActivity(this, binaryMessenger, activity, bundle);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.analyticsChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.analyticsChannel = null;
    }

    public final void setAnalyticsChannel(@Nullable MethodChannel methodChannel) {
        this.analyticsChannel = methodChannel;
    }
}
