package com.talabat.core.deeplink.data.handler.flutter.uiless;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fR*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/flutter/uiless/DeepLinkFlutterNavigationChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "callCanOpenDeeplink", "", "deeplink", "", "callback", "Lkotlin/Function1;", "", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "openDeeplink", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkFlutterNavigationChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String CAN_OPEN_DEEPLINK = "canOpenDeeplink";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String OPEN_DEEPLINK = "openDeeplink";
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/flutter/uiless/DeepLinkFlutterNavigationChannel$Companion;", "", "()V", "CAN_OPEN_DEEPLINK", "", "OPEN_DEEPLINK", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void callCanOpenDeeplink(@NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(function1, "callback");
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod(CAN_OPEN_DEEPLINK, str, new DeepLinkFlutterNavigationChannel$callCanOpenDeeplink$1(function1));
        }
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public final void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.DEEPLINK_NAVIGATION_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public final void openDeeplink(@NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(function1, "callback");
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod(OPEN_DEEPLINK, str, new DeepLinkFlutterNavigationChannel$openDeeplink$1(function1));
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
