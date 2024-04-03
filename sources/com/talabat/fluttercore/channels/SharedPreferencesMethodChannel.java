package com.talabat.fluttercore.channels;

import JsonModels.parser.UniversalGson;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannelCallback;", "getDynamic", "", "arguments", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getString", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "setCallback", "channelCallback", "setDynamic", "setString", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SharedPreferencesMethodChannel implements MethodChannel.MethodCallHandler {
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
    @Nullable
    private SharedPreferencesMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannel$Companion;", "", "()V", "GET_DYNAMIC", "", "GET_STRING", "SET_DYNAMIC", "SET_STRING", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void getDynamic(Object obj, MethodChannel.Result result) {
        boolean z11;
        String str;
        String str2;
        Object obj2;
        try {
            Map map = (Map) obj;
            Object obj3 = map.get("key");
            if (obj3 != null) {
                String str3 = (String) obj3;
                if (str3.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    Object obj4 = map.get("defaultValue");
                    Object obj5 = map.get("sharedPreferencesNameAndroid");
                    if (obj5 instanceof String) {
                        str = (String) obj5;
                    } else {
                        str = null;
                    }
                    UniversalGson universalGson = UniversalGson.INSTANCE;
                    Gson gson = universalGson.gson;
                    if (!(gson instanceof Gson)) {
                        str2 = gson.toJson(obj4);
                    } else {
                        str2 = GsonInstrumentation.toJson(gson, obj4);
                    }
                    SharedPreferencesMethodChannelCallback sharedPreferencesMethodChannelCallback = this.callback;
                    if (sharedPreferencesMethodChannelCallback != null) {
                        String string = sharedPreferencesMethodChannelCallback.getString(str3, str2, str);
                        if (string != null) {
                            str2 = string;
                        }
                    }
                    if (str2 == null) {
                        result.success(obj4);
                        return;
                    }
                    Gson gson2 = universalGson.gson;
                    Class<Object> cls = Object.class;
                    if (!(gson2 instanceof Gson)) {
                        obj2 = gson2.fromJson(str2, cls);
                    } else {
                        obj2 = GsonInstrumentation.fromJson(gson2, str2, cls);
                    }
                    result.success(obj2);
                    return;
                }
                throw new IllegalArgumentException("key should never be empty");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = "key"
            java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0053 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x0053 }
            if (r1 != 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 != 0) goto L_0x0043
            java.lang.String r1 = "defaultValue"
            java.lang.Object r1 = r5.get(r1)     // Catch:{ Exception -> 0x0053 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0053 }
            r3 = 0
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0053 }
            goto L_0x0026
        L_0x0025:
            r1 = r3
        L_0x0026:
            java.lang.String r2 = "sharedPreferencesNameAndroid"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x0053 }
            boolean r2 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0033
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0053 }
        L_0x0033:
            com.talabat.fluttercore.channels.SharedPreferencesMethodChannelCallback r5 = r4.callback     // Catch:{ Exception -> 0x0053 }
            if (r5 == 0) goto L_0x003f
            java.lang.String r5 = r5.getString(r0, r1, r3)     // Catch:{ Exception -> 0x0053 }
            if (r5 != 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = r5
        L_0x003f:
            r6.success(r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x005f
        L_0x0043:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = "key should never be empty"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0053 }
            throw r5     // Catch:{ Exception -> 0x0053 }
        L_0x004b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0053 }
            throw r5     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r5 = move-exception
            java.lang.String r0 = "SharedPreferencesMethodChannel: Exception on getString"
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "1"
            r6.error(r1, r0, r5)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluttercore.channels.SharedPreferencesMethodChannel.getString(java.lang.Object, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private final void setDynamic(Object obj, MethodChannel.Result result) {
        boolean z11;
        String str;
        String str2;
        try {
            Map map = (Map) obj;
            Object obj2 = map.get("key");
            if (obj2 != null) {
                String str3 = (String) obj2;
                if (str3.length() == 0) {
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
                    Gson gson = UniversalGson.INSTANCE.gson;
                    if (!(gson instanceof Gson)) {
                        str2 = gson.toJson(obj3);
                    } else {
                        str2 = GsonInstrumentation.toJson(gson, obj3);
                    }
                    if (obj3 == null) {
                        SharedPreferencesMethodChannelCallback sharedPreferencesMethodChannelCallback = this.callback;
                        if (sharedPreferencesMethodChannelCallback != null) {
                            sharedPreferencesMethodChannelCallback.setString(str3, (String) null, str);
                        }
                    } else {
                        SharedPreferencesMethodChannelCallback sharedPreferencesMethodChannelCallback2 = this.callback;
                        if (sharedPreferencesMethodChannelCallback2 != null) {
                            sharedPreferencesMethodChannelCallback2.setString(str3, str2, str);
                        }
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
                    SharedPreferencesMethodChannelCallback sharedPreferencesMethodChannelCallback = this.callback;
                    if (sharedPreferencesMethodChannelCallback != null) {
                        sharedPreferencesMethodChannelCallback.setString(str2, str3, str);
                    }
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

    public final void setCallback(@Nullable SharedPreferencesMethodChannelCallback sharedPreferencesMethodChannelCallback) {
        this.callback = sharedPreferencesMethodChannelCallback;
    }
}
