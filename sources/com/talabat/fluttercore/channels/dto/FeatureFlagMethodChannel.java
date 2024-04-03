package com.talabat.fluttercore.channels.dto;

import androidx.core.app.NotificationCompat;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.channels.FeatureFlagMethodChannelCallback;
import com.talabat.fluttercore.mappers.FWFProjectNameMapper;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\b0\fH\u0002J@\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\b2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u0012H\u0002J(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\bH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/fluttercore/channels/dto/FeatureFlagMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "talabatObservability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "callback", "Lcom/talabat/fluttercore/channels/FeatureFlagMethodChannelCallback;", "getFeatureFlag", "", "", "", "arguments", "", "", "getFeatureFlags", "", "responseMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRemoteConfig", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "featureFlagMethodChannelCallback", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagMethodChannel implements MethodChannel.MethodCallHandler {
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
    @Nullable
    private FeatureFlagMethodChannelCallback callback;
    @NotNull
    private final IObservabilityManager talabatObservability;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/fluttercore/channels/dto/FeatureFlagMethodChannel$Companion;", "", "()V", "DEFAULT_VALUE", "", "FEATURE_FLAG_NAME", "GET_FEATURE_FLAG", "GET_REMOTE_CONFIG", "PROJECT", "REMOTE_CONFIG_NAME", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FeatureFlagMethodChannel(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "talabatObservability");
        this.talabatObservability = iObservabilityManager;
    }

    private final Map<String, Boolean> getFeatureFlag(List<? extends Map<String, ? extends Object>> list) {
        HashMap hashMap = new HashMap();
        for (Map featureFlags : list) {
            getFeatureFlags(featureFlags, hashMap);
        }
        return hashMap;
    }

    private final void getFeatureFlags(Map<String, ? extends Object> map, HashMap<String, Boolean> hashMap) {
        String str;
        String str2;
        boolean z11;
        Object obj = map.get(FEATURE_FLAG_NAME);
        Boolean bool = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            Object obj2 = map.get(PROJECT);
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = FWFProjectName.DEFAULT.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2);
            Object obj3 = map.get(DEFAULT_VALUE);
            if (obj3 instanceof Boolean) {
                bool = (Boolean) obj3;
            }
            if (bool != null) {
                z11 = bool.booleanValue();
            } else {
                z11 = false;
            }
            FWFKeyObject fWFKeyObject = new FWFKeyObject(str, fwfProjectFromProjectName);
            FeatureFlagMethodChannelCallback featureFlagMethodChannelCallback = this.callback;
            if (featureFlagMethodChannelCallback != null) {
                z11 = featureFlagMethodChannelCallback.getFeatureFlag(fWFKeyObject, z11);
            }
            hashMap.put(str, Boolean.valueOf(z11));
        }
    }

    private final Map<String, Object> getRemoteConfig(Map<String, ? extends Object> map) {
        String str;
        String str2;
        HashMap<String, Object> remoteConfig;
        HashMap hashMap = new HashMap();
        Object obj = map.get(REMOTE_CONFIG_NAME);
        HashMap<String, Object> hashMap2 = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            Object obj2 = map.get(PROJECT);
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = FWFProjectName.DEFAULT.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2);
            Object obj3 = map.get(DEFAULT_VALUE);
            if (obj3 instanceof Map) {
                hashMap2 = (Map) obj3;
            }
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>();
            }
            FWFKeyObject fWFKeyObject = new FWFKeyObject(str, fwfProjectFromProjectName);
            try {
                FeatureFlagMethodChannelCallback featureFlagMethodChannelCallback = this.callback;
                if (!(featureFlagMethodChannelCallback == null || (remoteConfig = featureFlagMethodChannelCallback.getRemoteConfig(fWFKeyObject, new HashMap(hashMap2))) == null)) {
                    hashMap2 = remoteConfig;
                }
            } catch (Exception e11) {
                IObservabilityManager iObservabilityManager = this.talabatObservability;
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("method", GET_REMOTE_CONFIG);
                pairArr[1] = TuplesKt.to("message", String.valueOf(e11.getMessage()));
                String localizedMessage = e11.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "N/A";
                }
                pairArr[2] = TuplesKt.to("localizedMessage", localizedMessage);
                iObservabilityManager.trackUnExpectedScenario("FeatureFlagMethodChannel", MapsKt__MapsKt.mapOf(pairArr));
            }
            hashMap.put(str, hashMap2);
        }
        return hashMap;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) GET_FEATURE_FLAG)) {
            Object obj = methodCall.arguments;
            if (obj != null) {
                result.success(getFeatureFlag((List) obj));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_REMOTE_CONFIG)) {
            Object obj2 = methodCall.arguments;
            if (obj2 != null) {
                result.success(getRemoteConfig((Map) obj2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        } else {
            result.notImplemented();
        }
    }

    public final void setCallback(@Nullable FeatureFlagMethodChannelCallback featureFlagMethodChannelCallback) {
        this.callback = featureFlagMethodChannelCallback;
    }
}
