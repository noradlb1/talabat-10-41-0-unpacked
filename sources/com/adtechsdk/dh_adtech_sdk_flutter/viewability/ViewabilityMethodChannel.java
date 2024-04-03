package com.adtechsdk.dh_adtech_sdk_flutter.viewability;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/ViewabilityMethodChannel;", "", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "viewableChannel", "Lio/flutter/plugin/common/MethodChannel;", "logError", "", "message", "", "data", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewabilityMethodChannel {
    @NotNull
    private final MethodChannel viewableChannel;

    public ViewabilityMethodChannel(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "messenger");
        this.viewableChannel = new MethodChannel(binaryMessenger, "com.adtechsdk.dh_adtech_sdk_flutter/viewability");
    }

    public final void logError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "data");
        this.viewableChannel.invokeMethod("logError", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to("data", str2)));
    }
}
