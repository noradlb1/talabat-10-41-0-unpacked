package com.talabat.core.flutter.channels.data.qcommerce;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/flutter/channels/data/qcommerce/QCommerceMethodChannel;", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelFlutterDomain;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "callback", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "navigateToCheckout", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceMethodChannel implements QCommerceChannelFlutterDomain, MethodChannel.MethodCallHandler {
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final QCommerceChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    public QCommerceMethodChannel(@NotNull QCommerceChannelCallback qCommerceChannelCallback) {
        Intrinsics.checkNotNullParameter(qCommerceChannelCallback, "callback");
        this.callback = qCommerceChannelCallback;
    }

    private final void navigateToCheckout(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity2;
        try {
            Map map = (Map) methodCall.argument("vendor");
            Map map2 = (Map) methodCall.argument("cart");
            String str = (String) methodCall.argument("specialRequest");
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            ArrayList arrayList = new ArrayList();
            if (map == null) {
                arrayList.add("vendorMap");
            }
            if (map2 == null) {
                arrayList.add("cartMap");
            }
            if (activity2 == null) {
                arrayList.add("activity");
            }
            if (arrayList.isEmpty()) {
                QCommerceChannelCallback qCommerceChannelCallback = this.callback;
                Intrinsics.checkNotNull(activity2);
                Intrinsics.checkNotNull(map);
                Intrinsics.checkNotNull(map2);
                qCommerceChannelCallback.navigateToCheckout(activity2, map, map2, str);
                result.success((Object) null);
                return;
            }
            throw new NullPointerException("Null arguments: " + arrayList);
        } catch (Exception e11) {
            result.error(e11.getClass().getSimpleName(), e11.getMessage(), e11);
        }
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.QCOMMERCE_CHECKOUT_CHANNEL);
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
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "openCheckout")) {
            navigateToCheckout(methodCall, result);
        } else {
            result.notImplemented();
        }
    }
}
