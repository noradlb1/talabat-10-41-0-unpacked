package com.talabat.core.flutter.channels.data.apicallmocks;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallbackDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/flutter/channels/data/apicallmocks/ApiCallMocksMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallbackDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApiCallMocksMethodChannel implements MethodChannel.MethodCallHandler, ApiCallsMockChannelCallbackDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String localhostResponseForDELETECall = "localhostResponseForDELETECall";
    @NotNull
    private static final String localhostResponseForGETCall = "localhostResponseForGETCall";
    @NotNull
    private static final String localhostResponseForPOSTCall = "localhostResponseForPOSTCall";
    @NotNull
    private static final String localhostResponseForPUTCall = "localhostResponseForPUTCall";
    @Nullable
    private WeakReference<Activity> activity;
    @Nullable
    private Bundle arguments;
    @NotNull
    private final ApiCallsMockChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/data/apicallmocks/ApiCallMocksMethodChannel$Companion;", "", "()V", "localhostResponseForDELETECall", "", "localhostResponseForGETCall", "localhostResponseForPOSTCall", "localhostResponseForPUTCall", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ApiCallMocksMethodChannel(@NotNull ApiCallsMockChannelCallback apiCallsMockChannelCallback) {
        Intrinsics.checkNotNullParameter(apiCallsMockChannelCallback, "callback");
        this.callback = apiCallsMockChannelCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/localhostMock");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = new WeakReference<>(activity2);
        this.arguments = bundle;
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.activity = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = (String) methodCall.argument("url");
        if (str == null) {
            str = "";
        }
        String str2 = methodCall.method;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1521418338:
                    if (str2.equals(localhostResponseForDELETECall)) {
                        this.callback.handleRequest(str, result);
                        return;
                    }
                    return;
                case -1045045992:
                    if (str2.equals(localhostResponseForPUTCall)) {
                        this.callback.handleRequest(str, result);
                        return;
                    }
                    return;
                case -900710945:
                    if (str2.equals(localhostResponseForGETCall)) {
                        this.callback.handleRequest(str, result);
                        return;
                    }
                    return;
                case 919424339:
                    if (str2.equals(localhostResponseForPOSTCall)) {
                        this.callback.handleRequest(str, result);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
