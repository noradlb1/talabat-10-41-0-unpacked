package com.talabat.core.flutter.channels.data.dynamictrackingcache;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/talabat/core/flutter/channels/data/dynamictrackingcache/DynamicTrackingCacheMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "(Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicTrackingCacheMethodChannel implements MethodChannel.MethodCallHandler, DynamicTrackingCacheFlutterDomain {
    @NotNull
    private final DynamicTrackingCacheCallback callback;
    @Nullable
    private MethodChannel channel;

    public DynamicTrackingCacheMethodChannel(@NotNull DynamicTrackingCacheCallback dynamicTrackingCacheCallback) {
        Intrinsics.checkNotNullParameter(dynamicTrackingCacheCallback, "callback");
        this.callback = dynamicTrackingCacheCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.DYNAMIC_TRACKING_CACHE_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity, "activity");
        DynamicTrackingCacheFlutterDomain.DefaultImpls.onAttachWithActivity(this, binaryMessenger, activity, bundle);
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 5125176) {
                if (hashCode != 1021908711) {
                    if (hashCode == 1208961888 && str.equals("checkCacheEvent")) {
                        String str2 = (String) methodCall.argument("cacheKey");
                        String str3 = (String) methodCall.argument("groupKey");
                        if (str2 == null || str3 == null) {
                            result.error("5", "checkCacheEvent requires a \"groupKey\" and a \"cacheKey\"", (Object) null);
                            return;
                        } else {
                            result.success(Boolean.valueOf(this.callback.checkCacheEvent(str3, str2)));
                            return;
                        }
                    }
                } else if (str.equals("resetCacheEvent")) {
                    String str4 = (String) methodCall.argument("resetWhen");
                    String str5 = (String) methodCall.argument("groupKey");
                    if (str4 == null || str5 == null) {
                        result.error("6", "resetCacheEvent requires a \"groupKey\" \"resetWhen\"", (Object) null);
                        return;
                    }
                    this.callback.resetCacheEvent(str5, str4);
                    result.success((Object) null);
                    return;
                }
            } else if (str.equals("cacheEvent")) {
                String str6 = (String) methodCall.argument("cacheKey");
                String str7 = (String) methodCall.argument("groupKey");
                List list = (List) methodCall.argument("resetWhen");
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                if (str6 == null || str7 == null) {
                    result.error(OnlineLocationService.SRC_DEFAULT, "cacheEvent requires a \"groupKey\" and a \"cacheKey\"", (Object) null);
                    return;
                }
                this.callback.cacheEvent(str7, str6, list);
                result.success((Object) null);
                return;
            }
        }
        result.notImplemented();
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
