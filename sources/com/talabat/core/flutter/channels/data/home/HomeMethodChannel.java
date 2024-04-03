package com.talabat.core.flutter.channels.data.home;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/core/flutter/channels/data/home/HomeMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;)V", "arguments", "Landroid/os/Bundle;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "refreshHome", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMethodChannel implements MethodChannel.MethodCallHandler, HomeChannelFlutterDomain {
    @Nullable
    private Bundle arguments;
    @NotNull
    private final HomeChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    public HomeMethodChannel(@NotNull HomeChannelCallback homeChannelCallback) {
        Intrinsics.checkNotNullParameter(homeChannelCallback, "callback");
        this.callback = homeChannelCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.HOME_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity, "activity");
        HomeChannelFlutterDomain.DefaultImpls.onAttachWithActivity(this, binaryMessenger, activity, bundle);
        this.arguments = bundle;
        onAttach(binaryMessenger);
        this.callback.onAttached(activity, this, bundle);
    }

    public void onDetach() {
        this.callback.onDetached(this, this.arguments);
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str3 = methodCall.method;
        if (str3 != null) {
            switch (str3.hashCode()) {
                case -2117335699:
                    if (str3.equals("getCountryCode")) {
                        result.success(this.callback.getSelectedCountryCode());
                        return;
                    }
                    break;
                case -1653336991:
                    if (str3.equals("handleUpdateNavBar")) {
                        Boolean bool = (Boolean) methodCall.argument("shouldShowNavBar");
                        Boolean bool2 = (Boolean) methodCall.argument("shouldShowWhiteNavBar");
                        Map map = (Map) methodCall.argument("configurations");
                        if (map == null) {
                            map = MapsKt__MapsKt.emptyMap();
                        }
                        if (bool == null || bool2 == null) {
                            result.error(ExifInterface.GPS_MEASUREMENT_2D, "handleUpdateNavBar requires both \"shouldShowNavBar\" and \"shouldShowWhiteNavBar\"", (Object) null);
                            return;
                        }
                        this.callback.handleUpdateNavBar(bool.booleanValue(), bool2.booleanValue(), map);
                        result.success((Object) null);
                        return;
                    }
                    break;
                case -887327316:
                    if (str3.equals("handleUpdateVerticals")) {
                        List list = (List) methodCall.arguments();
                        if (list != null) {
                            this.callback.updateVerticals(list);
                            result.success((Object) null);
                            return;
                        }
                        result.error(ExifInterface.GPS_MEASUREMENT_3D, "handleUpdateVerticals requires \"verticals\"", (Object) null);
                        return;
                    }
                    break;
                case 5125176:
                    if (str3.equals("cacheEvent")) {
                        String str4 = (String) methodCall.argument("cacheKey");
                        List list2 = (List) methodCall.argument("resetWhen");
                        if (list2 == null) {
                            list2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        if (str4 != null) {
                            this.callback.cacheEvent(str4, list2);
                            result.success((Object) null);
                            return;
                        }
                        result.error(OnlineLocationService.SRC_DEFAULT, "cacheEvent requires \"cacheKey\"", (Object) null);
                        return;
                    }
                    break;
                case 411424849:
                    if (str3.equals("getAreaInfo")) {
                        result.success(this.callback.getAreaInfo());
                        return;
                    }
                    break;
                case 1021908711:
                    if (str3.equals("resetCacheEvent")) {
                        Object obj = methodCall.arguments;
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            this.callback.resetCacheEvent(str);
                            result.success((Object) null);
                            return;
                        }
                        result.error("6", "resetCacheEvent requires \"resetWhen\"", (Object) null);
                        return;
                    }
                    break;
                case 1208961888:
                    if (str3.equals("checkCacheEvent")) {
                        Object obj2 = methodCall.arguments;
                        if (obj2 instanceof String) {
                            str2 = (String) obj2;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            result.success(Boolean.valueOf(this.callback.checkCacheEvent(str2)));
                            return;
                        } else {
                            result.error("5", "checkCacheEvent requires \"cacheKey\"", (Object) null);
                            return;
                        }
                    }
                    break;
                case 1467416640:
                    if (str3.equals("handleClick")) {
                        String str5 = (String) methodCall.argument(NativeProtocol.WEB_DIALOG_ACTION);
                        Map map2 = (Map) methodCall.argument(TtmlNode.TAG_METADATA);
                        if (str5 == null || map2 == null) {
                            result.error("1", "handleClick requires both \"action\" and \"metadata\"", (Object) null);
                            return;
                        }
                        this.callback.handleClick(str5, map2);
                        result.success((Object) null);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public void refreshHome() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshHome", (Object) null, LoggedResult.INSTANCE);
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
