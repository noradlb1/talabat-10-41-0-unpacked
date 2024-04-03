package com.talabat.dh_chat;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.contract.configuration.CustomerChatConfigurationBuilder;
import com.deliveryhero.contract.configuration.UserRegistrationData;
import com.deliveryhero.contract.model.ChatPushData;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.contract.model.TokenType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.contract.model.UserType;
import com.deliveryhero.customerchat.CustomerChatModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.dh_chat.utils.JSONExtentionsKt;
import com.talabat.dh_chat.utils.MappersKt;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u000e2\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\b\u0001\u0010\u001b\u001a\u00020\u0017H\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\u000e2\b\b\u0001\u0010 \u001a\u00020!2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001d\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b$J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/dh_chat/DhChatPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "()V", "applicationContext", "Landroid/content/Context;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "chatSdk", "Lcom/deliveryhero/customerchat/CustomerChatModule;", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "configureChat", "", "args", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "isChatModuleMessage", "isChatOpen", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onCancel", "arguments", "onDetachedFromEngine", "binding", "onListen", "events", "Lio/flutter/plugin/common/EventChannel$EventSink;", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "parseMessage", "registerPush", "registerPush$dh_chat_release", "startChat", "unregisterPush", "dh_chat_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DhChatPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, EventChannel.StreamHandler {
    @Nullable
    private Context applicationContext;
    @Nullable
    private MethodChannel channel;
    @Nullable
    private CustomerChatModule chatSdk;
    @Nullable
    private EventChannel eventChannel;

    private final void configureChat(Object obj, MethodChannel.Result result) {
        try {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("country");
            String string2 = jSONObject.getString("pushNotificationsTokenType");
            String string3 = jSONObject.getString("dhEnvironment");
            String string4 = jSONObject.getString("globalEntityID");
            Intrinsics.checkNotNullExpressionValue(string2, "pushNotificationsTokenType");
            TokenType valueOf = TokenType.valueOf(string2);
            UserType userType = UserType.CUSTOMER;
            Intrinsics.checkNotNullExpressionValue(string3, "dhEnvironment");
            DhEnvironment valueOf2 = DhEnvironment.valueOf(string3);
            Intrinsics.checkNotNullExpressionValue(string, "country");
            Intrinsics.checkNotNullExpressionValue(string4, "globalEntityID");
            ClientConfig clientConfig = new ClientConfig(string, string4, userType, valueOf, valueOf2);
            JSONObject jSONObject2 = jSONObject.getJSONObject("userInfo");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "arguments.getJSONObject(\"userInfo\")");
            UserInfo parseUserInfo = MappersKt.parseUserInfo(jSONObject2);
            JSONObject jSONObject3 = jSONObject.getJSONObject("deliveryInfo");
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "arguments.getJSONObject(\"deliveryInfo\")");
            DeliveryInfo parseDeliveryInfo = MappersKt.parseDeliveryInfo(jSONObject3);
            String string5 = jSONObject.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            Translations parseTranslations = MappersKt.parseTranslations(jSONObject.optJSONObject("translations"));
            UserRegistrationData userRegistrationData = new UserRegistrationData(parseUserInfo, DhChatPlugin$configureChat$userRegistrationData$1.INSTANCE, DhChatPlugin$configureChat$userRegistrationData$2.INSTANCE);
            CustomerChatConfigurationBuilder customerChatConfigurationBuilder = new CustomerChatConfigurationBuilder();
            Intrinsics.checkNotNullExpressionValue(string5, RemoteMessageConst.Notification.CHANNEL_ID);
            CustomerChatConfigurationBuilder translations = customerChatConfigurationBuilder.channelId(string5).userRegistrationData(userRegistrationData).clientConfig(clientConfig).deliveryInfo(parseDeliveryInfo).stackFromEnd(true).translations(parseTranslations);
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                customerChatModule.setConfiguration(translations);
            }
            result.success((Object) null);
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    private final void isChatModuleMessage(Object obj, MethodChannel.Result result) {
        Boolean bool;
        try {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            Map<String, Object> map = JSONExtentionsKt.toMap((JSONObject) obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
            for (T next : map.entrySet()) {
                linkedHashMap.put(((Map.Entry) next).getKey(), ((Map.Entry) next).toString());
            }
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                bool = Boolean.valueOf(customerChatModule.isChatModuleMessage(linkedHashMap));
            } else {
                bool = null;
            }
            result.success(bool);
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    private final void isChatOpen(MethodChannel.Result result) {
        Boolean bool;
        try {
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                bool = Boolean.valueOf(customerChatModule.isChatOpen());
            } else {
                bool = null;
            }
            result.success(bool);
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    private final void parseMessage(Object obj, MethodChannel.Result result) {
        Map<String, String> map;
        ChatPushData parseMessage;
        try {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            Map<String, Object> map2 = JSONExtentionsKt.toMap((JSONObject) obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map2.size()));
            for (T next : map2.entrySet()) {
                linkedHashMap.put(((Map.Entry) next).getKey(), ((Map.Entry) next).toString());
            }
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule == null || (parseMessage = customerChatModule.parseMessage(linkedHashMap)) == null) {
                map = null;
            } else {
                map = JSONExtentionsKt.toMap(parseMessage);
            }
            result.success(map);
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    private final void startChat(Object obj, MethodChannel.Result result) {
        try {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = jSONObject.getJSONObject("deliveryInfo");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "arguments.getJSONObject(\"deliveryInfo\")");
            DeliveryInfo parseDeliveryInfo = MappersKt.parseDeliveryInfo(jSONObject2);
            String string = jSONObject.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                Context context = this.applicationContext;
                Intrinsics.checkNotNull(context);
                Intrinsics.checkNotNullExpressionValue(string, RemoteMessageConst.Notification.CHANNEL_ID);
                CustomerChatModule.startChat$default(customerChatModule, context, string, parseDeliveryInfo, (Function1) null, 8, (Object) null);
            }
            result.success((Object) null);
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    private final void unregisterPush(MethodChannel.Result result) {
        try {
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                customerChatModule.unregisterPush(new DhChatPlugin$unregisterPush$1(result), new DhChatPlugin$unregisterPush$2(result));
            }
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext2 = flutterPluginBinding.getApplicationContext();
        this.applicationContext = applicationContext2;
        CustomerChatModule.Companion companion = CustomerChatModule.Companion;
        Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        this.chatSdk = companion.getInstance((Application) applicationContext2);
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "dh_chat_method_channel", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        EventChannel eventChannel2 = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "dh_chat_events_channel");
        this.eventChannel = eventChannel2;
        eventChannel2.setStreamHandler(this);
    }

    public void onCancel(@Nullable Object obj) {
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.applicationContext = null;
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        EventChannel eventChannel2 = this.eventChannel;
        if (eventChannel2 != null) {
            eventChannel2.setStreamHandler((EventChannel.StreamHandler) null);
        }
        this.eventChannel = null;
        CustomerChatModule customerChatModule = this.chatSdk;
        if (customerChatModule != null) {
            customerChatModule.disconnect();
        }
        this.chatSdk = null;
    }

    public void onListen(@Nullable Object obj, @Nullable EventChannel.EventSink eventSink) {
        try {
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                customerChatModule.registerEvents(new DhChatPlugin$onListen$1(eventSink));
            }
        } catch (Exception e11) {
            if (eventSink != null) {
                eventSink.error("error", e11.getMessage(), (Object) null);
            }
        }
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        Object obj = methodCall.arguments;
        if (str != null) {
            switch (str.hashCode()) {
                case -2129802534:
                    if (str.equals("startChat")) {
                        Intrinsics.checkNotNullExpressionValue(obj, StepData.ARGS);
                        startChat(obj, result);
                        return;
                    }
                    break;
                case -1707849635:
                    if (str.equals("registerPush")) {
                        Intrinsics.checkNotNullExpressionValue(obj, StepData.ARGS);
                        registerPush$dh_chat_release(obj, result);
                        return;
                    }
                    break;
                case -1010000428:
                    if (str.equals("parseMessage")) {
                        Intrinsics.checkNotNullExpressionValue(obj, StepData.ARGS);
                        parseMessage(obj, result);
                        return;
                    }
                    break;
                case -738994311:
                    if (str.equals("isChatModuleMessage")) {
                        Intrinsics.checkNotNullExpressionValue(obj, StepData.ARGS);
                        isChatModuleMessage(obj, result);
                        return;
                    }
                    break;
                case 643983628:
                    if (str.equals("isChatOpen")) {
                        isChatOpen(result);
                        return;
                    }
                    break;
                case 1356740982:
                    if (str.equals("unregisterPush")) {
                        unregisterPush(result);
                        return;
                    }
                    break;
                case 1934985054:
                    if (str.equals("configureChat")) {
                        Intrinsics.checkNotNullExpressionValue(obj, StepData.ARGS);
                        configureChat(obj, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void registerPush$dh_chat_release(@NotNull Object obj, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(obj, StepData.ARGS);
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            String str = (String) obj;
            CustomerChatModule customerChatModule = this.chatSdk;
            if (customerChatModule != null) {
                customerChatModule.registerToken(str, new DhChatPlugin$registerPush$1(result), new DhChatPlugin$registerPush$2(result));
            }
        } catch (Exception e11) {
            result.error("error", e11.getMessage(), (Object) null);
        }
    }
}
