package com.talabat.core.flutter.channels.data.legacydeeplink;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import com.talabat.core.tracking.data.logger.LogManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/WeakReference;", "setActivity", "(Ljava/lang/ref/WeakReference;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyDeeplinkNavigationMethodChannel implements MethodChannel.MethodCallHandler, LegacyDeeplinkNavigationFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEEP_LINK = "deeplink";
    @NotNull
    public static final String OPEN_LEGACY_DEEPLINK = "openLegacyDeeplink";
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final LegacyDeeplinkNavigationChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel$Companion;", "", "()V", "DEEP_LINK", "", "OPEN_LEGACY_DEEPLINK", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LegacyDeeplinkNavigationMethodChannel(@NotNull LegacyDeeplinkNavigationChannelCallback legacyDeeplinkNavigationChannelCallback) {
        Intrinsics.checkNotNullParameter(legacyDeeplinkNavigationChannelCallback, "callback");
        this.callback = legacyDeeplinkNavigationChannelCallback;
    }

    @Nullable
    public final WeakReference<Activity> getActivity() {
        return this.activity;
    }

    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.LEGACY_DEEPLINK_NAVIGATION_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = new WeakReference<>(activity2);
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        this.activity = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Activity activity2;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) OPEN_LEGACY_DEEPLINK)) {
            Object obj = methodCall.arguments;
            if (obj != null) {
                HashMap hashMap = (HashMap) obj;
                if (hashMap.containsKey("deeplink")) {
                    Object obj2 = hashMap.get("deeplink");
                    if (obj2 != null) {
                        String str = (String) obj2;
                        WeakReference<Activity> weakReference = this.activity;
                        if (weakReference != null) {
                            activity2 = weakReference.get();
                        } else {
                            activity2 = null;
                        }
                        if (activity2 == null) {
                            LogManager.debug("openLegacyDeeplink activity is null");
                            result.notImplemented();
                        }
                        if (activity2 != null) {
                            this.callback.openLegacyDeeplink(str, activity2);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                result.success((Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        }
        LogManager.debug(Reflection.getOrCreateKotlinClass(LegacyDeeplinkNavigationFlutterDomain.class).getSimpleName() + " FlutterConstants.NOT_IMPLEMENTED_METHOD_CALL + call.arguments");
        result.notImplemented();
    }

    public final void setActivity(@Nullable WeakReference<Activity> weakReference) {
        this.activity = weakReference;
    }

    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
