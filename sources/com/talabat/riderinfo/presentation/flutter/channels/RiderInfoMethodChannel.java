package com.talabat.riderinfo.presentation.flutter.channels;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.riderinfo.presentation.flutter.dto.RiderChatMethodCallArguments;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\fH\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/riderinfo/presentation/flutter/channels/RiderInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/riderinfo/presentation/flutter/channels/RiderInfoMethodChannelCallback;", "extractArgs", "T", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "key", "", "clazz", "Ljava/lang/Class;", "(Lio/flutter/plugin/common/MethodCall;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "handleOpenRiderChat", "", "onMethodCall", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderInfoMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String OPEN_RIDER_CHAT = "openRiderChat";
    @NotNull
    private static final String RIDER_CHAT_METHOD_ARGS = "riderChatMethodCallArgs";
    @NotNull
    public static final String RIDER_INFO_CHANNEL = "com.talabat.flutter/riderInfo";
    private RiderInfoMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/riderinfo/presentation/flutter/channels/RiderInfoMethodChannel$Companion;", "", "()V", "OPEN_RIDER_CHAT", "", "RIDER_CHAT_METHOD_ARGS", "RIDER_INFO_CHANNEL", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final <T> T extractArgs(MethodCall methodCall, String str, Class<T> cls) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Gson gson = GsonKt.getGson();
            Object obj2 = ((HashMap) obj).get(str);
            if (obj2 != null) {
                String str2 = (String) obj2;
                if (!(gson instanceof Gson)) {
                    return gson.fromJson(str2, cls);
                }
                return GsonInstrumentation.fromJson(gson, str2, cls);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
    }

    private final void handleOpenRiderChat(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        LogManager.debug("openRiderChat" + obj);
        RiderChatMethodCallArguments riderChatMethodCallArguments = (RiderChatMethodCallArguments) extractArgs(methodCall, RIDER_CHAT_METHOD_ARGS, RiderChatMethodCallArguments.class);
        LogManager.debug("riderChatMethodCallArgs: " + riderChatMethodCallArguments);
        RiderInfoMethodChannelCallback riderInfoMethodChannelCallback = this.callback;
        if (riderInfoMethodChannelCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            riderInfoMethodChannelCallback = null;
        }
        riderInfoMethodChannelCallback.openRiderChatScreen(riderChatMethodCallArguments);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "openRiderChat")) {
            handleOpenRiderChat(methodCall);
        }
    }

    public final void setCallback(@NotNull RiderInfoMethodChannelCallback riderInfoMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(riderInfoMethodChannelCallback, "callback");
        this.callback = riderInfoMethodChannelCallback;
    }
}
