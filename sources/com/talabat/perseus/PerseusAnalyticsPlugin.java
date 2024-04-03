package com.talabat.perseus;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.perseus.config.PerseusConfigProvider;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import j$.util.Map;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u001b\u001a\u00020\t2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/perseus/PerseusAnalyticsPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "applicationContext", "Landroid/content/Context;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "configurePerseus", "", "arguments", "", "", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getPerseusClientId", "getPerseusHitMatchId", "getPerseusSessionId", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "sendPerseusEvent", "attributes", "perseus_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusAnalyticsPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private Context applicationContext;
    private MethodChannel channel;

    private final void configurePerseus(Map<String, ? extends Object> map, Context context, MethodChannel.Result result) {
        try {
            String valueOf = String.valueOf(map.get("appId"));
            String valueOf2 = String.valueOf(map.get(AnalyticsAttribute.APP_NAME_ATTRIBUTE));
            String valueOf3 = String.valueOf(map.get("appVersionName"));
            String valueOf4 = String.valueOf(map.get("baseUrl"));
            String valueOf5 = String.valueOf(map.get(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID));
            Object obj = map.get("debuggable");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            PerseusFacade.configurePerseus(new PerseusConfigProvider(valueOf, valueOf2, valueOf3, valueOf4, ((Boolean) obj).booleanValue(), String.valueOf(map.get("entity")), valueOf5, String.valueOf(map.get("uaId"))).create(String.valueOf(map.get("adjustId")), String.valueOf(map.get(ConstantsKt.GOOGLE_AD_ID)), String.valueOf(map.get("countryCode")), String.valueOf(map.get("userId"))), context);
            result.success((Object) null);
        } catch (Exception e11) {
            result.error("initializationError", e11.getMessage(), ExceptionsKt__ExceptionsKt.stackTraceToString(e11));
        }
    }

    private final void getPerseusClientId(MethodChannel.Result result) {
        try {
            result.success(PerseusFacade.getPerseusClientId());
        } catch (UninitializedException unused) {
            result.error("uninitializedError", "Perseus SDK is not configured", "Perseus SDK should be configured before getting clientId");
        } catch (Throwable th2) {
            result.error("unknownError", th2.getMessage(), ExceptionsKt__ExceptionsKt.stackTraceToString(th2));
        }
    }

    private final void getPerseusHitMatchId(MethodChannel.Result result) {
        try {
            result.success(PerseusFacade.generatePerseusHitMatchId());
        } catch (UninitializedException unused) {
            result.error("uninitializedError", "Perseus SDK is not configured", "Perseus SDK should be configured before getting hitMatchId");
        } catch (Throwable th2) {
            result.error("unknownError", th2.getMessage(), ExceptionsKt__ExceptionsKt.stackTraceToString(th2));
        }
    }

    private final void getPerseusSessionId(MethodChannel.Result result) {
        try {
            result.success(PerseusFacade.getPerseusSessionId());
        } catch (UninitializedException unused) {
            result.error("uninitializedError", "Perseus SDK is not configured", "Perseus SDK should be configured before getting sessionId");
        } catch (Throwable th2) {
            result.error("unknownError", th2.getMessage(), ExceptionsKt__ExceptionsKt.stackTraceToString(th2));
        }
    }

    private final void sendPerseusEvent(Map<String, String> map, MethodChannel.Result result) {
        try {
            if (!PerseusFacade.isSdkInitialized()) {
                result.error("uninitializedError", "Perseus SDK is not configured", "Perseus needs to be initialized before sending event");
            }
            Map mutableMap = MapsKt__MapsKt.toMutableMap(map);
            mutableMap.remove("method_channel_event_name");
            PerseusFacade.sendEvent((String) Map.EL.getOrDefault(mutableMap, "method_channel_event_name", "N/A"), mutableMap);
            result.success((Object) null);
        } catch (Exception e11) {
            result.error("sendEventError", e11.getMessage(), ExceptionsKt__ExceptionsKt.stackTraceToString(e11));
        }
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "perseus_analytics");
        Context applicationContext2 = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "flutterPluginBinding.applicationContext");
        this.applicationContext = applicationContext2;
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1551391069:
                    if (str.equals("getHitMatchId")) {
                        getPerseusHitMatchId(result);
                        return;
                    }
                    break;
                case -1308658756:
                    if (str.equals("getClientId")) {
                        getPerseusClientId(result);
                        return;
                    }
                    break;
                case -137378029:
                    if (str.equals("perseusPushEvent")) {
                        Object obj = methodCall.arguments;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                        sendPerseusEvent((java.util.Map) obj, result);
                        return;
                    }
                    break;
                case 598192027:
                    if (str.equals("getSessionId")) {
                        getPerseusSessionId(result);
                        return;
                    }
                    break;
                case 966193479:
                    if (str.equals("configurePerseus")) {
                        Object obj2 = methodCall.arguments;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                        java.util.Map map = (java.util.Map) obj2;
                        Context context = this.applicationContext;
                        if (context == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                            context = null;
                        }
                        configurePerseus(map, context, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
