package com.talabat.core.flutter.channels.data.navigation;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/core/flutter/channels/data/navigation/DeepLinkNativeNavigationChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationNativeDomain;", "fromNativeCallback", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkNativeNavigationChannel implements MethodChannel.MethodCallHandler, DeeplinkNavigationNativeDomain {
    @NotNull
    private static final String CAN_OPEN_DEEPLINK = "canOpenDeeplink";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String OPEN_DEEPLINK = "openDeeplink";
    @Nullable
    private WeakReference<Activity> activity;
    @Nullable
    private MethodChannel channel;
    /* access modifiers changed from: private */
    @NotNull
    public final DeeplinkNavigationChannelCallback fromNativeCallback;
    @NotNull
    private final CoroutineScope mainCoroutineScope;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/data/navigation/DeepLinkNativeNavigationChannel$Companion;", "", "()V", "CAN_OPEN_DEEPLINK", "", "OPEN_DEEPLINK", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DeepLinkNativeNavigationChannel(@NotNull DeeplinkNavigationChannelCallback deeplinkNavigationChannelCallback, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCallback, "fromNativeCallback");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        this.fromNativeCallback = deeplinkNavigationChannelCallback;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory.main());
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.DEEPLINK_NAVIGATION_CHANNEL);
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
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.activity = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v3, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodCall r11, @org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodChannel.Result r12) {
        /*
            r10 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r11.method
            java.lang.String r1 = "canOpenDeeplink"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            java.lang.String r2 = ""
            r3 = 0
            if (r1 == 0) goto L_0x0034
            java.lang.Object r11 = r11.arguments
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0020
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0021
        L_0x0020:
            r11 = r3
        L_0x0021:
            if (r11 != 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = r11
        L_0x0025:
            kotlinx.coroutines.CoroutineScope r4 = r10.mainCoroutineScope
            r5 = 0
            r6 = 0
            com.talabat.core.flutter.channels.data.navigation.DeepLinkNativeNavigationChannel$onMethodCall$1 r7 = new com.talabat.core.flutter.channels.data.navigation.DeepLinkNativeNavigationChannel$onMethodCall$1
            r7.<init>(r10, r2, r12, r3)
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            goto L_0x006f
        L_0x0034:
            java.lang.String r1 = "openDeeplink"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x006c
            java.lang.ref.WeakReference<android.app.Activity> r0 = r10.activity
            if (r0 == 0) goto L_0x0064
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L_0x0064
            java.lang.Object r11 = r11.arguments
            boolean r1 = r11 instanceof java.lang.String
            if (r1 == 0) goto L_0x0051
            r3 = r11
            java.lang.String r3 = (java.lang.String) r3
        L_0x0051:
            if (r3 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r3
        L_0x0055:
            com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback r11 = r10.fromNativeCallback
            boolean r11 = r11.onOpenDeeplink(r2, r0)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r12.success(r11)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0064:
            if (r3 != 0) goto L_0x006f
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r12.success(r11)
            goto L_0x006f
        L_0x006c:
            r12.notImplemented()
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.navigation.DeepLinkNativeNavigationChannel.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
