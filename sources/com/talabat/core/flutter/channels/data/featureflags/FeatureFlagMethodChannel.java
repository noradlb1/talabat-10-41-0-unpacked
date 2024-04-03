package com.talabat.core.flutter.channels.data.featureflags;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J.\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J.\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013`\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006$"}, d2 = {"Lcom/talabat/core/flutter/channels/data/featureflags/FeatureFlagMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "getFeatureFlagResult", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "arguments", "", "getRemoteConfigResult", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagMethodChannel implements MethodChannel.MethodCallHandler, FeatureFlagChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEFAULT_VALUE = "defaultValue";
    @NotNull
    private static final String FEATURE_FLAG_NAME = "featureFlagName";
    @NotNull
    private static final String GET_FEATURE_FLAG = "getFlags";
    @NotNull
    private static final String GET_REMOTE_CONFIG = "getRemoteConfig";
    @NotNull
    private static final String PROJECT = "project";
    @NotNull
    private static final String REMOTE_CONFIG_NAME = "remoteConfigName";
    @NotNull
    private final FeatureFlagChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/data/featureflags/FeatureFlagMethodChannel$Companion;", "", "()V", "DEFAULT_VALUE", "", "FEATURE_FLAG_NAME", "GET_FEATURE_FLAG", "GET_REMOTE_CONFIG", "PROJECT", "REMOTE_CONFIG_NAME", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FeatureFlagMethodChannel(@NotNull FeatureFlagChannelCallback featureFlagChannelCallback) {
        Intrinsics.checkNotNullParameter(featureFlagChannelCallback, "callback");
        this.callback = featureFlagChannelCallback;
    }

    private final HashMap<String, Boolean> getFeatureFlagResult(Object obj) {
        List<Map> list;
        String str;
        String str2;
        Boolean bool;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        if (obj instanceof List) {
            list = (List) obj;
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        for (Map map : list) {
            Object obj2 = map.get(FEATURE_FLAG_NAME);
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = null;
            }
            if (str != null) {
                Object obj3 = map.get(PROJECT);
                if (obj3 instanceof String) {
                    str2 = (String) obj3;
                } else {
                    str2 = null;
                }
                Object obj4 = map.get(DEFAULT_VALUE);
                if (obj4 instanceof Boolean) {
                    bool = (Boolean) obj4;
                } else {
                    bool = null;
                }
                hashMap.put(str, Boolean.valueOf(this.callback.getFeatureFlag(str, str2, bool)));
            }
        }
        Log.e("FeatureFlagMethodChannel", "getFeatureFlag: " + hashMap);
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.HashMap<java.lang.String, java.lang.Object> getRemoteConfigResult(java.lang.Object r6) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            boolean r1 = r6 instanceof java.util.Map
            r2 = 0
            if (r1 == 0) goto L_0x000d
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x000e
        L_0x000d:
            r6 = r2
        L_0x000e:
            if (r6 != 0) goto L_0x0014
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.emptyMap()
        L_0x0014:
            java.lang.String r1 = "remoteConfigName"
            java.lang.Object r1 = r6.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0021
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            if (r1 == 0) goto L_0x0048
            java.lang.String r3 = "project"
            java.lang.Object r3 = r6.get(r3)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L_0x0031
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0032
        L_0x0031:
            r3 = r2
        L_0x0032:
            java.lang.String r4 = "defaultValue"
            java.lang.Object r6 = r6.get(r4)
            boolean r4 = r6 instanceof java.util.Map
            if (r4 == 0) goto L_0x003f
            r2 = r6
            java.util.Map r2 = (java.util.Map) r2
        L_0x003f:
            com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback r6 = r5.callback
            java.lang.Object r6 = r6.getRemoteConfig(r1, r3, r2)
            r0.put(r1, r6)
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.featureflags.FeatureFlagMethodChannel.getRemoteConfigResult(java.lang.Object):java.util.HashMap");
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.FEATURE_FLAG_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity, "activity");
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
        if (Intrinsics.areEqual((Object) str, (Object) GET_FEATURE_FLAG)) {
            result.success(getFeatureFlagResult(methodCall.arguments));
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_REMOTE_CONFIG)) {
            result.success(getRemoteConfigResult(methodCall.arguments));
        } else {
            result.notImplemented();
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
