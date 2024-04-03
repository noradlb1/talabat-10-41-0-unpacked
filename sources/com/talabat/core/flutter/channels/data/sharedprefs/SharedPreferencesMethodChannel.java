package com.talabat.core.flutter.channels.data.sharedprefs;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/talabat/core/flutter/channels/data/sharedprefs/SharedPreferencesMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "getDynamic", "", "arguments", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getString", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "setDynamic", "setString", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SharedPreferencesMethodChannel implements MethodChannel.MethodCallHandler, SharedPreferencesChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_DYNAMIC = "getDynamic";
    @NotNull
    private static final String GET_STRING = "getString";
    @NotNull
    private static final String SET_DYNAMIC = "setDynamic";
    @NotNull
    private static final String SET_STRING = "setString";
    @NotNull
    private final SharedPreferencesChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/data/sharedprefs/SharedPreferencesMethodChannel$Companion;", "", "()V", "GET_DYNAMIC", "", "GET_STRING", "SET_DYNAMIC", "SET_STRING", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SharedPreferencesMethodChannel(@NotNull SharedPreferencesChannelCallback sharedPreferencesChannelCallback) {
        Intrinsics.checkNotNullParameter(sharedPreferencesChannelCallback, "callback");
        this.callback = sharedPreferencesChannelCallback;
    }

    private final void getDynamic(Object obj, MethodChannel.Result result) {
        boolean z11;
        String str;
        try {
            Map map = (Map) obj;
            Object obj2 = map.get("key");
            if (obj2 != null) {
                String str2 = (String) obj2;
                if (str2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    Object obj3 = map.get("defaultValue");
                    Object obj4 = map.get("sharedPreferencesNameAndroid");
                    if (obj4 instanceof String) {
                        str = (String) obj4;
                    } else {
                        str = null;
                    }
                    String json = GsonInstrumentation.toJson(new Gson(), obj3);
                    String string = this.callback.getString(str2, json, str);
                    if (string != null) {
                        json = string;
                    }
                    if (json == null) {
                        result.success(obj3);
                    } else {
                        result.success(GsonInstrumentation.fromJson(new Gson(), json, Object.class));
                    }
                } else {
                    throw new IllegalArgumentException("key should never be empty");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } catch (Exception e11) {
            result.error("1", "SharedPreferencesMethodChannel: Exception on getDynamic", e11.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getString(java.lang.Object r5, io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0052 }
            java.lang.String r0 = "key"
            java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0052 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x0052 }
            if (r1 != 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 != 0) goto L_0x0042
            java.lang.String r1 = "defaultValue"
            java.lang.Object r1 = r5.get(r1)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0052 }
            r3 = 0
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0052 }
            goto L_0x0026
        L_0x0025:
            r1 = r3
        L_0x0026:
            java.lang.String r2 = "sharedPreferencesNameAndroid"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x0034
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0052 }
        L_0x0034:
            com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback r5 = r4.callback     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = r5.getString(r0, r1, r3)     // Catch:{ Exception -> 0x0052 }
            if (r5 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r5
        L_0x003e:
            r6.success(r1)     // Catch:{ Exception -> 0x0052 }
            goto L_0x005e
        L_0x0042:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0052 }
            java.lang.String r0 = "key should never be empty"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0052 }
            throw r5     // Catch:{ Exception -> 0x0052 }
        L_0x004a:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0052 }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0052 }
            throw r5     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            r5 = move-exception
            java.lang.String r0 = "SharedPreferencesMethodChannel: Exception on getString"
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "1"
            r6.error(r1, r0, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.sharedprefs.SharedPreferencesMethodChannel.getString(java.lang.Object, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private final void setDynamic(Object obj, MethodChannel.Result result) {
        boolean z11;
        String str;
        try {
            Map map = (Map) obj;
            Object obj2 = map.get("key");
            if (obj2 != null) {
                String str2 = (String) obj2;
                if (str2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    Object obj3 = map.get("value");
                    Object obj4 = map.get("sharedPreferencesNameAndroid");
                    if (obj4 instanceof String) {
                        str = (String) obj4;
                    } else {
                        str = null;
                    }
                    String json = GsonInstrumentation.toJson(new Gson(), obj3);
                    if (obj3 == null) {
                        this.callback.setString(str2, (String) null, str);
                    } else {
                        this.callback.setString(str2, json, str);
                    }
                    result.success((Object) null);
                    return;
                }
                throw new IllegalArgumentException("key should never be empty");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e11) {
            result.error("1", "SharedPreferencesMethodChannel: Exception on setDynamic", e11.toString());
        }
    }

    private final void setString(Object obj, MethodChannel.Result result) {
        boolean z11;
        String str;
        try {
            Map map = (Map) obj;
            Object obj2 = map.get("key");
            if (obj2 != null) {
                String str2 = (String) obj2;
                if (str2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    String str3 = (String) map.get("value");
                    Object obj3 = map.get("sharedPreferencesNameAndroid");
                    if (obj3 instanceof String) {
                        str = (String) obj3;
                    } else {
                        str = null;
                    }
                    this.callback.setString(str2, str3, str);
                    result.success((Object) null);
                    return;
                }
                throw new IllegalArgumentException("key should never be empty");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e11) {
            result.error("1", "SharedPreferencesMethodChannel: Exception on setString", e11.toString());
        }
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.NATIVE_SHARED_PREFERENCES_CHANNEL);
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
        if (str != null) {
            switch (str.hashCode()) {
                case -1133339639:
                    if (str.equals(GET_DYNAMIC)) {
                        Object obj = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj, "call.arguments");
                        getDynamic(obj, result);
                        return;
                    }
                    return;
                case 589412115:
                    if (str.equals(SET_STRING)) {
                        Object obj2 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj2, "call.arguments");
                        setString(obj2, result);
                        return;
                    }
                    return;
                case 803465597:
                    if (str.equals(SET_DYNAMIC)) {
                        Object obj3 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj3, "call.arguments");
                        setDynamic(obj3, result);
                        return;
                    }
                    return;
                case 804029191:
                    if (str.equals(GET_STRING)) {
                        Object obj4 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj4, "call.arguments");
                        getString(obj4, result);
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
