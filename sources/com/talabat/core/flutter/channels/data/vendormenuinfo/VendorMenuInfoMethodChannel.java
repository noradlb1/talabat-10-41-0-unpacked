package com.talabat.core.flutter.channels.data.vendormenuinfo;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/flutter/channels/data/vendormenuinfo/VendorMenuInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuInfoMethodChannel implements MethodChannel.MethodCallHandler, VendorMenuInfoChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_VENDOR_MENU_INFO = "getVendorMenuInfo";
    @NotNull
    private static final String SHOW_VENDOR_BUSY_POPUP = "navigateToVendorBusyScreen";
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final VendorMenuInfoChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/data/vendormenuinfo/VendorMenuInfoMethodChannel$Companion;", "", "()V", "GET_VENDOR_MENU_INFO", "", "SHOW_VENDOR_BUSY_POPUP", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VendorMenuInfoMethodChannel(@NotNull VendorMenuInfoChannelCallback vendorMenuInfoChannelCallback) {
        Intrinsics.checkNotNullParameter(vendorMenuInfoChannelCallback, "callback");
        this.callback = vendorMenuInfoChannelCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/vendor-menu-info");
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
        this.activity = null;
        this.channel = null;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.app.Activity] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodCall r4, @org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r4.method
            java.lang.String r1 = "getVendorMenuInfo"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 0
            if (r1 == 0) goto L_0x002f
            com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback r4 = r3.callback
            java.lang.ref.WeakReference<android.app.Activity> r0 = r3.activity
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L_0x0027
            android.content.Intent r2 = r0.getIntent()
        L_0x0027:
            java.util.Map r4 = r4.getVendorMenuInfo(r2)
            r5.success(r4)
            goto L_0x0056
        L_0x002f:
            java.lang.String r1 = "navigateToVendorBusyScreen"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x004a
            com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback r5 = r3.callback
            java.lang.Object r4 = r4.arguments
            java.lang.ref.WeakReference<android.app.Activity> r0 = r3.activity
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r0.get()
            r2 = r0
            android.app.Activity r2 = (android.app.Activity) r2
        L_0x0046:
            r5.showVendorBusyPopup(r4, r2)
            goto L_0x0056
        L_0x004a:
            java.lang.Class<com.talabat.core.flutter.channels.data.vendor.VendorMethodChannel> r4 = com.talabat.core.flutter.channels.data.vendor.VendorMethodChannel.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            r4.getSimpleName()
            r5.notImplemented()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.vendormenuinfo.VendorMenuInfoMethodChannel.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
