package com.talabat.core.flutter.channels.data.config;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/core/flutter/channels/data/config/GlobalMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "observeError", "", "eventName", "", "reason", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalMethodChannel implements MethodChannel.MethodCallHandler, GlobalChannelFlutterDomain {
    @NotNull
    private static final String BACK_NAVIGATION_ACTION = "backNavigation";
    @NotNull
    private static final String CONFIGS_ACTION_METHOD_CALL = "configs";
    @NotNull
    private static final String CURRENT_ADDRESS_METHOD_CALL = "currentAddress";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ENVIRONMENT_ACTION_METHOD_CALL = "environment";
    @NotNull
    private static final String SET_BOTTOM_NAVIGATION_OFF = "setBottomNavigationOff";
    @NotNull
    private static final String SET_BOTTOM_NAVIGATION_ON = "setBottomNavigationOn";
    @NotNull
    private static final String SET_CUSTOMER_INFO = "setCustomerInfo";
    @NotNull
    private static final String SET_PAYMENT_CARDS = "setPaymentCards";
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final GlobalChannelCallback callback;
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/config/GlobalMethodChannel$Companion;", "", "()V", "BACK_NAVIGATION_ACTION", "", "CONFIGS_ACTION_METHOD_CALL", "CURRENT_ADDRESS_METHOD_CALL", "ENVIRONMENT_ACTION_METHOD_CALL", "SET_BOTTOM_NAVIGATION_OFF", "SET_BOTTOM_NAVIGATION_ON", "SET_CUSTOMER_INFO", "SET_PAYMENT_CARDS", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GlobalMethodChannel(@NotNull GlobalChannelCallback globalChannelCallback, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(globalChannelCallback, "callback");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.callback = globalChannelCallback;
        this.observabilityManager = iObservabilityManager;
    }

    private final void observeError(String str, String str2) {
        this.observabilityManager.track(str, "ULEvents", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("reason", str2)));
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        String str;
        Activity activity2;
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.CONFIG_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        GlobalChannelCallback globalChannelCallback = this.callback;
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference == null || (activity2 = weakReference.get()) == null) {
            str = null;
        } else {
            str = activity2.getLocalClassName();
        }
        globalChannelCallback.onAttach(str, System.identityHashCode(this));
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = new WeakReference<>(activity2);
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        String str;
        Activity activity2;
        GlobalChannelCallback globalChannelCallback = this.callback;
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference == null || (activity2 = weakReference.get()) == null) {
            str = null;
        } else {
            str = activity2.getLocalClassName();
        }
        globalChannelCallback.onDetach(str, System.identityHashCode(this));
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        this.activity = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.talabat.core.flutter.channels.domain.home.HomeChannelProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.app.Activity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.talabat.core.flutter.channels.domain.home.HomeChannelProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: com.talabat.home.HomeScreenActivity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodCall r5, @org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r5.method
            java.lang.Class<com.talabat.core.flutter.channels.data.config.GlobalMethodChannel> r1 = com.talabat.core.flutter.channels.data.config.GlobalMethodChannel.class
            if (r0 == 0) goto L_0x014e
            int r2 = r0.hashCode()
            r3 = 0
            switch(r2) {
                case -1593748850: goto L_0x012b;
                case -857684178: goto L_0x0104;
                case -240241061: goto L_0x00de;
                case -85904877: goto L_0x00b7;
                case 502778080: goto L_0x0092;
                case 951117169: goto L_0x006b;
                case 1557400635: goto L_0x0044;
                case 2013898367: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x014e
        L_0x001a:
            java.lang.String r2 = "setPaymentCards"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x014e
        L_0x0024:
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r0 = r4.callback     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r5 = r5.arguments     // Catch:{ Exception -> 0x0032 }
            r0.setPaymentCards(r5)     // Catch:{ Exception -> 0x0032 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0032 }
            r6.success(r5)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0155
        L_0x0032:
            r5 = move-exception
            java.lang.String r0 = "set_pay_cards_list_failed"
            java.lang.String r5 = r5.toString()
            r4.observeError(r0, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6.success(r5)
            goto L_0x0155
        L_0x0044:
            java.lang.String r5 = "currentAddress"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x004e
            goto L_0x014e
        L_0x004e:
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r0 = r4.callback
            java.util.Map r0 = r0.currentAddress()
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r1.getSimpleName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r0)
            r6.success(r0)
            goto L_0x0155
        L_0x006b:
            java.lang.String r5 = "configs"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0075
            goto L_0x014e
        L_0x0075:
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r0 = r4.callback
            java.util.Map r0 = r0.configs()
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r1.getSimpleName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r0)
            r6.success(r0)
            goto L_0x0155
        L_0x0092:
            java.lang.String r5 = "setBottomNavigationOn"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x009c
            goto L_0x014e
        L_0x009c:
            java.lang.ref.WeakReference<android.app.Activity> r5 = r4.activity
            if (r5 == 0) goto L_0x00a7
            java.lang.Object r5 = r5.get()
            android.app.Activity r5 = (android.app.Activity) r5
            goto L_0x00a8
        L_0x00a7:
            r5 = r3
        L_0x00a8:
            boolean r6 = r5 instanceof com.talabat.core.flutter.channels.domain.home.HomeChannelProvider
            if (r6 == 0) goto L_0x00af
            r3 = r5
            com.talabat.core.flutter.channels.domain.home.HomeChannelProvider r3 = (com.talabat.core.flutter.channels.domain.home.HomeChannelProvider) r3
        L_0x00af:
            if (r3 == 0) goto L_0x0155
            r5 = 1
            r3.showTabBarNavigation(r5)
            goto L_0x0155
        L_0x00b7:
            java.lang.String r5 = "environment"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x00c1
            goto L_0x014e
        L_0x00c1:
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r0 = r4.callback
            java.lang.String r0 = r0.environment()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            com.talabat.core.tracking.data.logger.LogManager.debug(r5)
            r6.success(r0)
            goto L_0x0155
        L_0x00de:
            java.lang.String r5 = "backNavigation"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x00e7
            goto L_0x014e
        L_0x00e7:
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r5.getSimpleName()
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r5 = r4.callback
            java.lang.ref.WeakReference<android.app.Activity> r0 = r4.activity
            if (r0 == 0) goto L_0x00fb
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
        L_0x00fb:
            r5.backNavigation(r3)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r6.success(r5)
            goto L_0x0155
        L_0x0104:
            java.lang.String r2 = "setCustomerInfo"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x010d
            goto L_0x014e
        L_0x010d:
            com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback r0 = r4.callback     // Catch:{ Exception -> 0x011a }
            java.lang.Object r5 = r5.arguments     // Catch:{ Exception -> 0x011a }
            r0.setCustomerInfo(r5)     // Catch:{ Exception -> 0x011a }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x011a }
            r6.success(r5)     // Catch:{ Exception -> 0x011a }
            goto L_0x0155
        L_0x011a:
            r5 = move-exception
            java.lang.String r0 = "set_customer_info_failed"
            java.lang.String r5 = r5.toString()
            r4.observeError(r0, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6.success(r5)
            goto L_0x0155
        L_0x012b:
            java.lang.String r5 = "setBottomNavigationOff"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0134
            goto L_0x014e
        L_0x0134:
            java.lang.ref.WeakReference<android.app.Activity> r5 = r4.activity
            if (r5 == 0) goto L_0x013f
            java.lang.Object r5 = r5.get()
            android.app.Activity r5 = (android.app.Activity) r5
            goto L_0x0140
        L_0x013f:
            r5 = r3
        L_0x0140:
            boolean r6 = r5 instanceof com.talabat.core.flutter.channels.domain.home.HomeChannelProvider
            if (r6 == 0) goto L_0x0147
            r3 = r5
            com.talabat.core.flutter.channels.domain.home.HomeChannelProvider r3 = (com.talabat.core.flutter.channels.domain.home.HomeChannelProvider) r3
        L_0x0147:
            if (r3 == 0) goto L_0x0155
            r5 = 0
            r3.showTabBarNavigation(r5)
            goto L_0x0155
        L_0x014e:
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r5.getSimpleName()
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.config.GlobalMethodChannel.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
