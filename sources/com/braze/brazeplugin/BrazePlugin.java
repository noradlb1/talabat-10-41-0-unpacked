package com.braze.brazeplugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.appboy.enums.Month;
import com.appboy.enums.NotificationSubscriptionType;
import com.appboy.models.cards.Card;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import r3.a;
import r3.b;
import r3.c;
import r3.d;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001a2\b\b\u0001\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020%H\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J/\u0010/\u001a\u00020\u001a*\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001a02H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/braze/brazeplugin/BrazePlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "context", "Landroid/content/Context;", "flutterCachedConfiguration", "Lcom/braze/brazeplugin/FlutterCachedConfiguration;", "convertToBrazeProperties", "Lcom/braze/models/outgoing/BrazeProperties;", "arguments", "", "", "getMonth", "Lcom/appboy/enums/Month;", "month", "", "getSubscriptionType", "Lcom/appboy/enums/NotificationSubscriptionType;", "type", "handleSdkAuthenticationError", "", "errorEvent", "Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "initPlugin", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachedToActivity", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "runOnUser", "Lcom/braze/Braze;", "block", "Lkotlin/Function1;", "Lcom/braze/BrazeUser;", "Lkotlin/ParameterName;", "name", "user", "Companion", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BrazePlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazePlugin.class);
    /* access modifiers changed from: private */
    @NotNull
    public static List<BrazePlugin> activePlugins = new ArrayList();
    /* access modifiers changed from: private */
    @Nullable
    public Activity activity;
    /* access modifiers changed from: private */
    public MethodChannel channel;
    private Context context;
    private FlutterCachedConfiguration flutterCachedConfiguration;

    @Instrumented
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/braze/brazeplugin/BrazePlugin$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "activePlugins", "", "Lcom/braze/brazeplugin/BrazePlugin;", "getActivePlugins", "()Ljava/util/List;", "setActivePlugins", "(Ljava/util/List;)V", "processContentCards", "", "contentCardList", "", "Lcom/appboy/models/cards/Card;", "processInAppMessage", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: processContentCards$lambda-1  reason: not valid java name */
        public static final void m9197processContentCards$lambda1(BrazePlugin brazePlugin, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(brazePlugin, "$plugin");
            Intrinsics.checkNotNullParameter(hashMap, "$contentCardMap");
            MethodChannel access$getChannel$p = brazePlugin.channel;
            if (access$getChannel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                access$getChannel$p = null;
            }
            access$getChannel$p.invokeMethod("handleBrazeContentCards", hashMap);
        }

        /* access modifiers changed from: private */
        /* renamed from: processInAppMessage$lambda-0  reason: not valid java name */
        public static final void m9198processInAppMessage$lambda0(BrazePlugin brazePlugin, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(brazePlugin, "$plugin");
            Intrinsics.checkNotNullParameter(hashMap, "$inAppMessageMap");
            MethodChannel access$getChannel$p = brazePlugin.channel;
            if (access$getChannel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                access$getChannel$p = null;
            }
            access$getChannel$p.invokeMethod("handleBrazeInAppMessage", hashMap);
        }

        @NotNull
        public final List<BrazePlugin> getActivePlugins() {
            return BrazePlugin.activePlugins;
        }

        @NotNull
        public final String getTAG() {
            return BrazePlugin.TAG;
        }

        @JvmStatic
        public final void processContentCards(@NotNull List<? extends Card> list) {
            String str;
            Intrinsics.checkNotNullParameter(list, "contentCardList");
            if (getActivePlugins().isEmpty()) {
                BrazeLogger.w$default(getTAG(), "There are no active Braze Plugins. Not calling 'handleBrazeContentCards'.", (Throwable) null, false, 12, (Object) null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Card forJsonPut : list) {
                JSONObject forJsonPut2 = forJsonPut.forJsonPut();
                if (!(forJsonPut2 instanceof JSONObject)) {
                    str = forJsonPut2.toString();
                } else {
                    str = JSONObjectInstrumentation.toString(forJsonPut2);
                }
                arrayList.add(str);
            }
            HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("contentCards", arrayList));
            for (BrazePlugin next : getActivePlugins()) {
                Activity access$getActivity$p = next.activity;
                if (access$getActivity$p != null) {
                    access$getActivity$p.runOnUiThread(new c(next, hashMapOf));
                }
            }
        }

        @JvmStatic
        public final void processInAppMessage(@NotNull IInAppMessage iInAppMessage) {
            String str;
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            if (getActivePlugins().isEmpty()) {
                BrazeLogger.w$default(getTAG(), "There are no active Braze Plugins. Not calling 'handleBrazeInAppMessage'.", (Throwable) null, false, 12, (Object) null);
                return;
            }
            Pair[] pairArr = new Pair[1];
            JSONObject jSONObject = (JSONObject) iInAppMessage.forJsonPut();
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            pairArr[0] = TuplesKt.to("inAppMessage", str);
            HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
            for (BrazePlugin next : getActivePlugins()) {
                Activity access$getActivity$p = next.activity;
                if (access$getActivity$p != null) {
                    access$getActivity$p.runOnUiThread(new d(next, hashMapOf));
                }
            }
        }

        public final void setActivePlugins(@NotNull List<BrazePlugin> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            BrazePlugin.activePlugins = list;
        }
    }

    private final BrazeProperties convertToBrazeProperties(Map<String, ?> map) {
        if (map == null) {
            return new BrazeProperties();
        }
        return new BrazeProperties(new JSONObject((Map<?, ?>) map));
    }

    private final Month getMonth(int i11) {
        Month month = Month.Companion.getMonth(i11 - 1);
        if (month != null) {
            return month;
        }
        BrazeLogger.w$default(TAG, "Invalid `null` month. Defaulting to January.", (Throwable) null, false, 12, (Object) null);
        return Month.JANUARY;
    }

    private final NotificationSubscriptionType getSubscriptionType(String str) {
        String obj = StringsKt__StringsKt.trim((CharSequence) str).toString();
        int hashCode = obj.hashCode();
        if (hashCode != -938807766) {
            if (hashCode != 655408273) {
                if (hashCode == 1559119849 && obj.equals("SubscriptionType.opted_in")) {
                    return NotificationSubscriptionType.OPTED_IN;
                }
            } else if (obj.equals("SubscriptionType.subscribed")) {
                return NotificationSubscriptionType.SUBSCRIBED;
            }
        } else if (obj.equals("SubscriptionType.unsubscribed")) {
            return NotificationSubscriptionType.UNSUBSCRIBED;
        }
        return null;
    }

    private final void handleSdkAuthenticationError(BrazeSdkAuthenticationErrorEvent brazeSdkAuthenticationErrorEvent) {
        if (activePlugins.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazePlugin$handleSdkAuthenticationError$1.INSTANCE, 6, (Object) null);
            return;
        }
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sdkAuthenticationError", JSONObjectInstrumentation.toString(new JSONObject(MapsKt__MapsKt.hashMapOf(TuplesKt.to(Constant.PARAM_ERROR_CODE, String.valueOf(brazeSdkAuthenticationErrorEvent.getErrorCode())), TuplesKt.to("reason", brazeSdkAuthenticationErrorEvent.getErrorReason()), TuplesKt.to("userId", brazeSdkAuthenticationErrorEvent.getUserId())).toString()))));
        for (BrazePlugin next : activePlugins) {
            Activity activity2 = next.activity;
            if (activity2 != null) {
                activity2.runOnUiThread(new b(next, hashMapOf));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSdkAuthenticationError$lambda-2  reason: not valid java name */
    public static final void m9195handleSdkAuthenticationError$lambda2(BrazePlugin brazePlugin, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(brazePlugin, "$plugin");
        Intrinsics.checkNotNullParameter(hashMap, "$sdkAuthenticationErrorMap");
        MethodChannel methodChannel = brazePlugin.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.invokeMethod("handleSdkAuthenticationError", hashMap);
    }

    private final void initPlugin(Context context2, BinaryMessenger binaryMessenger) {
        this.flutterCachedConfiguration = new FlutterCachedConfiguration(context2, false);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "braze_plugin");
        methodChannel.setMethodCallHandler(this);
        this.context = context2;
        this.channel = methodChannel;
        activePlugins.add(this);
        Braze.Companion.getInstance(context2).subscribeToSdkAuthenticationFailures(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-0  reason: not valid java name */
    public static final void m9196initPlugin$lambda0(BrazePlugin brazePlugin, BrazeSdkAuthenticationErrorEvent brazeSdkAuthenticationErrorEvent) {
        Intrinsics.checkNotNullParameter(brazePlugin, "this$0");
        Intrinsics.checkNotNullParameter(brazeSdkAuthenticationErrorEvent, "message");
        brazePlugin.handleSdkAuthenticationError(brazeSdkAuthenticationErrorEvent);
    }

    @JvmStatic
    public static final void processContentCards(@NotNull List<? extends Card> list) {
        Companion.processContentCards(list);
    }

    @JvmStatic
    public static final void processInAppMessage(@NotNull IInAppMessage iInAppMessage) {
        Companion.processInAppMessage(iInAppMessage);
    }

    private final void runOnUser(Braze braze, Function1<? super BrazeUser, Unit> function1) {
        braze.getCurrentUser(new BrazePlugin$runOnUser$1(function1));
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Application application;
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.activity = activityPluginBinding.getActivity();
        IntegrationInitializer integrationInitializer = IntegrationInitializer.INSTANCE;
        if (integrationInitializer.isUninitialized()) {
            FlutterCachedConfiguration flutterCachedConfiguration2 = this.flutterCachedConfiguration;
            FlutterCachedConfiguration flutterCachedConfiguration3 = null;
            if (flutterCachedConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterCachedConfiguration");
                flutterCachedConfiguration2 = null;
            }
            if (flutterCachedConfiguration2.isAutomaticInitializationEnabled()) {
                BrazeLogger.i$default(TAG, "Running Flutter BrazePlugin automatic initialization", (Throwable) null, false, 12, (Object) null);
                Activity activity2 = this.activity;
                if (activity2 != null && (application = activity2.getApplication()) != null) {
                    FlutterCachedConfiguration flutterCachedConfiguration4 = this.flutterCachedConfiguration;
                    if (flutterCachedConfiguration4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flutterCachedConfiguration");
                    } else {
                        flutterCachedConfiguration3 = flutterCachedConfiguration4;
                    }
                    integrationInitializer.initializePlugin$braze_plugin_release(application, flutterCachedConfiguration3);
                }
            }
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterPluginBinding.binaryMessenger");
        initPlugin(applicationContext, binaryMessenger);
    }

    public void onDetachedFromActivity() {
        this.activity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        activePlugins.remove(this);
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:475:0x0918, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:628:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodCall r24, @org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodChannel.Result r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = r2.method     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0aea
            int r5 = r4.hashCode()     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "properties"
            java.lang.String r8 = "type"
            java.lang.String r9 = "groupId"
            java.lang.String r10 = "sdkAuthSignature"
            java.lang.String r11 = "inAppMessageString"
            java.lang.String r12 = ""
            java.lang.String r13 = "contentCardString"
            java.lang.String r6 = "value"
            java.lang.String r14 = "key"
            java.lang.String r16 = "context"
            r15 = 0
            switch(r5) {
                case -2131879013: goto L_0x0aa9;
                case -1981695516: goto L_0x0a70;
                case -1618914254: goto L_0x0a56;
                case -1448662595: goto L_0x0a2a;
                case -1284111084: goto L_0x09e2;
                case -1263769041: goto L_0x099b;
                case -1227761272: goto L_0x0973;
                case -1146185036: goto L_0x0939;
                case -1058498415: goto L_0x091c;
                case -1056030027: goto L_0x090e;
                case -1043223038: goto L_0x08ed;
                case -991721531: goto L_0x08bb;
                case -811628443: goto L_0x0853;
                case -792744658: goto L_0x0825;
                case -760422984: goto L_0x0805;
                case -721841540: goto L_0x07c3;
                case -703008304: goto L_0x0777;
                case -631666761: goto L_0x075b;
                case -614455072: goto L_0x0704;
                case -510261241: goto L_0x06a4;
                case -363470636: goto L_0x0677;
                case -239206893: goto L_0x064f;
                case -208022518: goto L_0x060c;
                case 30334285: goto L_0x05c0;
                case 130003172: goto L_0x0590;
                case 195984819: goto L_0x0545;
                case 231885251: goto L_0x04bc;
                case 375730650: goto L_0x048f;
                case 529720515: goto L_0x0462;
                case 584576454: goto L_0x0402;
                case 689992853: goto L_0x03d5;
                case 716673560: goto L_0x03a9;
                case 925882743: goto L_0x0385;
                case 1032158840: goto L_0x0359;
                case 1075477796: goto L_0x0339;
                case 1206161350: goto L_0x02ff;
                case 1287516916: goto L_0x0298;
                case 1299921207: goto L_0x025e;
                case 1391332442: goto L_0x0231;
                case 1415563057: goto L_0x01e6;
                case 1482968510: goto L_0x01a4;
                case 1496090584: goto L_0x0141;
                case 1502615916: goto L_0x0114;
                case 1562169122: goto L_0x00e6;
                case 1672223513: goto L_0x00b9;
                case 1681133837: goto L_0x0076;
                case 2022160988: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0aea
        L_0x0033:
            java.lang.String r5 = "removeFromCustomAttributeArray"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x003d
            goto L_0x0aea
        L_0x003d:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0069
            if (r5 != 0) goto L_0x004e
            goto L_0x0069
        L_0x004e:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0058
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0059
        L_0x0058:
            r15 = r7
        L_0x0059:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$3 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$3     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0069:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `removeFromCustomAttributeArray`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0076:
            java.lang.String r5 = "setStringCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0080
            goto L_0x0aea
        L_0x0080:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x00ac
            if (r5 != 0) goto L_0x0091
            goto L_0x00ac
        L_0x0091:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x009c
        L_0x009b:
            r15 = r7
        L_0x009c:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$4 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$4     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x00ac:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `setStringCustomUserAttribute`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x00b9:
            java.lang.String r5 = "setFirstName"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x00c3
            goto L_0x0aea
        L_0x00c3:
            java.lang.String r4 = "firstName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x00d5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x00d6
        L_0x00d5:
            r15 = r6
        L_0x00d6:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$16 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$16     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x00e6:
            java.lang.String r5 = "logContentCardClicked"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x00f0
            goto L_0x0aea
        L_0x00f0:
            java.lang.Object r4 = r2.argument(r13)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0110
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0102
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0103
        L_0x0102:
            r15 = r6
        L_0x0103:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.appboy.models.cards.Card r4 = r5.deserializeContentCard((java.lang.String) r4)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0110
            r4.logClick()     // Catch:{ Exception -> 0x0af0 }
        L_0x0110:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0114:
            java.lang.String r5 = "setHomeCity"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x011e
            goto L_0x0aea
        L_0x011e:
            java.lang.String r4 = "homeCity"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0130
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0131
        L_0x0130:
            r15 = r6
        L_0x0131:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$23 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$23     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0141:
            java.lang.String r5 = "setDateOfBirth"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x014b
            goto L_0x0aea
        L_0x014b:
            java.lang.String r4 = "year"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x015b
            r5 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0af0 }
        L_0x015b:
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "month"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x016e
            r6 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x016e:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0af0 }
            com.appboy.enums.Month r5 = r1.getMonth(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "day"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0185
            r7 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0af0 }
        L_0x0185:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r7 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r8 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r8 != 0) goto L_0x0193
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0194
        L_0x0193:
            r15 = r8
        L_0x0194:
            com.braze.Braze r7 = r7.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$18 r8 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$18     // Catch:{ Exception -> 0x0af0 }
            r8.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r7, r8)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x01a4:
            java.lang.String r5 = "setPushNotificationSubscriptionType"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x01ae
            goto L_0x0aea
        L_0x01ae:
            java.lang.Object r4 = r2.argument(r8)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r12 = r4
        L_0x01b8:
            com.appboy.enums.NotificationSubscriptionType r4 = r1.getSubscriptionType(r12)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x01cb
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "Unexpected null type in `setPushNotificationSubscriptionType`."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.braze.support.BrazeLogger.w$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x01cb:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x01d5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x01d6
        L_0x01d5:
            r15 = r6
        L_0x01d6:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$11 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$11     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x01e6:
            java.lang.String r5 = "incrementCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x01f0
            goto L_0x0aea
        L_0x01f0:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0203
            r6 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x0203:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0216
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "Unexpected null key in `incrementCustomUserAttribute`."
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            com.braze.support.BrazeLogger.w$default(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0216:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0220
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0221
        L_0x0220:
            r15 = r7
        L_0x0221:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$8 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$8     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0231:
            java.lang.String r5 = "setEmail"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x023b
            goto L_0x0aea
        L_0x023b:
            java.lang.String r4 = "email"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x024d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x024e
        L_0x024d:
            r15 = r6
        L_0x024e:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$19 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$19     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x025e:
            java.lang.String r5 = "unsetCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0268
            goto L_0x0aea
        L_0x0268:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x027d
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "Unexpected null key in `unsetCustomUserAttribute`."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.braze.support.BrazeLogger.w$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x027d:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0287
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0288
        L_0x0287:
            r15 = r6
        L_0x0288:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$10 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$10     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0298:
            java.lang.String r5 = "setLocationCustomAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x02a2
            goto L_0x0aea
        L_0x02a2:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = "lat"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x02b9
            r7 = 0
            java.lang.Double r4 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0af0 }
        L_0x02b9:
            double r7 = r4.doubleValue()     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = "long"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x02cd
            r9 = 0
            java.lang.Double r4 = java.lang.Double.valueOf(r9)     // Catch:{ Exception -> 0x0af0 }
        L_0x02cd:
            double r9 = r4.doubleValue()     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x02e3
            java.lang.String r17 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r18 = "Unexpected null key in `setLocationCustomAttribute`."
            r19 = 0
            r20 = 0
            r21 = 12
            r22 = 0
            com.braze.support.BrazeLogger.w$default(r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x02e3:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x02ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x02ee
        L_0x02ed:
            r15 = r5
        L_0x02ee:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$15 r11 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$15     // Catch:{ Exception -> 0x0af0 }
            r5 = r11
            r5.<init>(r6, r7, r9)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r4, r11)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x02ff:
            java.lang.String r5 = "addToSubscriptionGroup"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0309
            goto L_0x0aea
        L_0x0309:
            java.lang.Object r4 = r2.argument(r9)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x031e
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "Unexpected null groupId in `addToSubscriptionGroup`."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.braze.support.BrazeLogger.w$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x031e:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0328
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0329
        L_0x0328:
            r15 = r6
        L_0x0329:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$13 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$13     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0339:
            java.lang.String r5 = "requestLocationInitialization"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0343
            goto L_0x0aea
        L_0x0343:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x034d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x034e
        L_0x034d:
            r15 = r5
        L_0x034e:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r4.requestLocationInitialization()     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0359:
            java.lang.String r5 = "logInAppMessageImpression"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0363
            goto L_0x0aea
        L_0x0363:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x036d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x036e
        L_0x036d:
            r15 = r5
        L_0x036e:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r11)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.inappmessage.IInAppMessage r4 = r4.deserializeInAppMessageString(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0381
            r4.logImpression()     // Catch:{ Exception -> 0x0af0 }
        L_0x0381:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0385:
            java.lang.String r5 = "getInstallTrackingId"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x038f
            goto L_0x0aea
        L_0x038f:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0399
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x039a
        L_0x0399:
            r15 = r5
        L_0x039a:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = r4.getDeviceId()     // Catch:{ Exception -> 0x0af0 }
            r3.success(r4)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x03a9:
            java.lang.String r5 = "logInAppMessageClicked"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x03b3
            goto L_0x0aea
        L_0x03b3:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x03bd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x03be
        L_0x03bd:
            r15 = r5
        L_0x03be:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r11)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.inappmessage.IInAppMessage r4 = r4.deserializeInAppMessageString(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x03d1
            r4.logClick()     // Catch:{ Exception -> 0x0af0 }
        L_0x03d1:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x03d5:
            java.lang.String r5 = "setPhoneNumber"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x03df
            goto L_0x0aea
        L_0x03df:
            java.lang.String r4 = "phoneNumber"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x03f1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x03f2
        L_0x03f1:
            r15 = r6
        L_0x03f2:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$24 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$24     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0402:
            java.lang.String r5 = "logInAppMessageButtonClicked"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x040c
            goto L_0x0aea
        L_0x040c:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0416
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0417
        L_0x0416:
            r15 = r5
        L_0x0417:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r11)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.inappmessage.IInAppMessage r4 = r4.deserializeInAppMessageString(r5)     // Catch:{ Exception -> 0x0af0 }
            boolean r5 = r4 instanceof com.braze.models.inappmessage.IInAppMessageImmersive     // Catch:{ Exception -> 0x0af0 }
            if (r5 == 0) goto L_0x045e
            java.lang.String r5 = "buttonId"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0438
            r6 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x0438:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0af0 }
            r6 = r4
            com.braze.models.inappmessage.IInAppMessageImmersive r6 = (com.braze.models.inappmessage.IInAppMessageImmersive) r6     // Catch:{ Exception -> 0x0af0 }
            java.util.List r6 = r6.getMessageButtons()     // Catch:{ Exception -> 0x0af0 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0af0 }
        L_0x0447:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0af0 }
            if (r7 == 0) goto L_0x045e
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.inappmessage.MessageButton r7 = (com.braze.models.inappmessage.MessageButton) r7     // Catch:{ Exception -> 0x0af0 }
            int r8 = r7.getId()     // Catch:{ Exception -> 0x0af0 }
            if (r8 != r5) goto L_0x0447
            com.braze.models.inappmessage.IInAppMessageImmersive r4 = (com.braze.models.inappmessage.IInAppMessageImmersive) r4     // Catch:{ Exception -> 0x0af0 }
            r4.logButtonClick(r7)     // Catch:{ Exception -> 0x0af0 }
        L_0x045e:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0462:
            java.lang.String r5 = "setLastName"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x046c
            goto L_0x0aea
        L_0x046c:
            java.lang.String r4 = "lastName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x047e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x047f
        L_0x047e:
            r15 = r6
        L_0x047f:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$17 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$17     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x048f:
            java.lang.String r5 = "setLanguage"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0499
            goto L_0x0aea
        L_0x0499:
            java.lang.String r4 = "language"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x04ab
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x04ac
        L_0x04ab:
            r15 = r6
        L_0x04ac:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$21 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$21     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x04bc:
            java.lang.String r5 = "setGender"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x04c6
            goto L_0x0aea
        L_0x04c6:
            java.lang.String r4 = "gender"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x04e6
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = r4.toUpperCase(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x04e5
            goto L_0x04e6
        L_0x04e5:
            r12 = r4
        L_0x04e6:
            java.lang.String r4 = "F"
            r5 = 2
            r6 = 0
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x04f3
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.FEMALE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0529
        L_0x04f3:
            java.lang.String r4 = "M"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x04fe
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.MALE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0529
        L_0x04fe:
            java.lang.String r4 = "N"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0509
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.NOT_APPLICABLE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0529
        L_0x0509:
            java.lang.String r4 = "O"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0514
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.OTHER     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0529
        L_0x0514:
            java.lang.String r4 = "P"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x051f
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.PREFER_NOT_TO_SAY     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0529
        L_0x051f:
            java.lang.String r4 = "U"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r4, r6, r5, r15)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0544
            com.appboy.enums.Gender r4 = com.appboy.enums.Gender.UNKNOWN     // Catch:{ Exception -> 0x0af0 }
        L_0x0529:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0533
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0534
        L_0x0533:
            r15 = r6
        L_0x0534:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$20 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$20     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0544:
            return
        L_0x0545:
            java.lang.String r5 = "setIntCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x054f
            goto L_0x0aea
        L_0x054f:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0562
            r6 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x0562:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0575
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "Unexpected null key in `setIntCustomUserAttribute`."
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            com.braze.support.BrazeLogger.w$default(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0575:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x057f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0580
        L_0x057f:
            r15 = r7
        L_0x0580:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$7 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$7     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0590:
            java.lang.String r5 = "logContentCardDismissed"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x059a
            goto L_0x0aea
        L_0x059a:
            java.lang.Object r4 = r2.argument(r13)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x05bc
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x05ac
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x05ad
        L_0x05ac:
            r15 = r6
        L_0x05ad:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.appboy.models.cards.Card r4 = r5.deserializeContentCard((java.lang.String) r4)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x05b8
            goto L_0x05bc
        L_0x05b8:
            r5 = 1
            r4.setDismissed(r5)     // Catch:{ Exception -> 0x0af0 }
        L_0x05bc:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x05c0:
            java.lang.String r5 = "setDoubleCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x05ca
            goto L_0x0aea
        L_0x05ca:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x05de
            r6 = 0
            java.lang.Double r5 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x05de:
            double r5 = r5.doubleValue()     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x05f1
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r8 = "Unexpected null key in `setDoubleCustomUserAttribute`"
            r9 = 0
            r10 = 0
            r11 = 12
            r12 = 0
            com.braze.support.BrazeLogger.w$default(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x05f1:
            com.braze.Braze$Companion r7 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r8 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r8 != 0) goto L_0x05fb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x05fc
        L_0x05fb:
            r15 = r8
        L_0x05fc:
            com.braze.Braze r7 = r7.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$5 r8 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$5     // Catch:{ Exception -> 0x0af0 }
            r8.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r7, r8)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x060c:
            java.lang.String r5 = "addToCustomAttributeArray"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0616
            goto L_0x0aea
        L_0x0616:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0642
            if (r5 != 0) goto L_0x0627
            goto L_0x0642
        L_0x0627:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0631
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0632
        L_0x0631:
            r15 = r7
        L_0x0632:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$2 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$2     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0642:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `addToCustomAttributeArray`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x064f:
            java.lang.String r5 = "registerAndroidPushToken"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0659
            goto L_0x0aea
        L_0x0659:
            java.lang.String r4 = "pushToken"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x066b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x066c
        L_0x066b:
            r15 = r6
        L_0x066c:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r5.setRegisteredPushToken(r4)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0677:
            java.lang.String r5 = "setCountry"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0681
            goto L_0x0aea
        L_0x0681:
            java.lang.String r4 = "country"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0693
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0694
        L_0x0693:
            r15 = r6
        L_0x0694:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$22 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$22     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x06a4:
            java.lang.String r5 = "setAttributionData"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x06ae
            goto L_0x0aea
        L_0x06ae:
            java.lang.String r4 = "network"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "campaign"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "adGroup"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "creative"
            java.lang.Object r7 = r2.argument(r7)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x06f7
            if (r5 == 0) goto L_0x06f7
            if (r6 == 0) goto L_0x06f7
            if (r7 != 0) goto L_0x06d7
            goto L_0x06f7
        L_0x06d7:
            com.appboy.models.outgoing.AttributionData r8 = new com.appboy.models.outgoing.AttributionData     // Catch:{ Exception -> 0x0af0 }
            r8.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x06e6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x06e7
        L_0x06e6:
            r15 = r5
        L_0x06e7:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$25 r5 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$25     // Catch:{ Exception -> 0x0af0 }
            r5.<init>(r8)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x06f7:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `setAttributionData`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0704:
            java.lang.String r5 = "setLastKnownLocation"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x070e
            goto L_0x0aea
        L_0x070e:
            java.lang.String r4 = "latitude"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "longitude"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "accuracy"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r6 = (java.lang.Double) r6     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "altitude"
            java.lang.Object r7 = r2.argument(r7)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r7 = (java.lang.Double) r7     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x074e
            if (r5 != 0) goto L_0x0733
            goto L_0x074e
        L_0x0733:
            com.braze.Braze$Companion r8 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r9 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r9 != 0) goto L_0x073d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x073e
        L_0x073d:
            r15 = r9
        L_0x073e:
            com.braze.Braze r8 = r8.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$26 r9 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$26     // Catch:{ Exception -> 0x0af0 }
            r9.<init>(r4, r5, r7, r6)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r8, r9)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x074e:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `setLastKnownLocation`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x075b:
            java.lang.String r5 = "enableSDK"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0765
            goto L_0x0aea
        L_0x0765:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x076f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0770
        L_0x076f:
            r15 = r5
        L_0x0770:
            r4.enableSdk(r15)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0777:
            java.lang.String r5 = "setDateCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0781
            goto L_0x0aea
        L_0x0781:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0794
            r6 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0af0 }
        L_0x0794:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0af0 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x07a8
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r8 = "Unexpected null key in `setDateCustomUserAttribute`."
            r9 = 0
            r10 = 0
            r11 = 12
            r12 = 0
            com.braze.support.BrazeLogger.w$default(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x07a8:
            com.braze.Braze$Companion r7 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r8 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r8 != 0) goto L_0x07b2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x07b3
        L_0x07b2:
            r15 = r8
        L_0x07b3:
            com.braze.Braze r7 = r7.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$6 r8 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$6     // Catch:{ Exception -> 0x0af0 }
            r8.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r7, r8)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x07c3:
            java.lang.String r5 = "setEmailNotificationSubscriptionType"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x07cd
            goto L_0x0aea
        L_0x07cd:
            java.lang.Object r4 = r2.argument(r8)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x07d6
            goto L_0x07d7
        L_0x07d6:
            r12 = r4
        L_0x07d7:
            com.appboy.enums.NotificationSubscriptionType r4 = r1.getSubscriptionType(r12)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x07ea
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "Unexpected null type in `setEmailNotificationSubscriptionType`."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.braze.support.BrazeLogger.w$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x07ea:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x07f4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x07f5
        L_0x07f4:
            r15 = r6
        L_0x07f5:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$12 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$12     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0805:
            java.lang.String r5 = "requestImmediateDataFlush"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x080f
            goto L_0x0aea
        L_0x080f:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0819
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x081a
        L_0x0819:
            r15 = r5
        L_0x081a:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r4.requestImmediateDataFlush()     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0825:
            java.lang.String r5 = "logContentCardImpression"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x082f
            goto L_0x0aea
        L_0x082f:
            java.lang.Object r4 = r2.argument(r13)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x084f
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0841
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0842
        L_0x0841:
            r15 = r6
        L_0x0842:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.appboy.models.cards.Card r4 = r5.deserializeContentCard((java.lang.String) r4)     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x084f
            r4.logImpression()     // Catch:{ Exception -> 0x0af0 }
        L_0x084f:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0853:
            java.lang.String r5 = "logPurchase"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x085d
            goto L_0x0aea
        L_0x085d:
            java.lang.String r4 = "productId"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            r9 = r4
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = "currencyCode"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            r10 = r4
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = "price"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x087f
            r5 = 0
            java.lang.Double r4 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0af0 }
        L_0x087f:
            double r4 = r4.doubleValue()     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "quantity"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0892
            r8 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0af0 }
        L_0x0892:
            int r12 = r6.intValue()     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r6 = r2.argument(r7)     // Catch:{ Exception -> 0x0af0 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.outgoing.BrazeProperties r13 = r1.convertToBrazeProperties(r6)     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x08aa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x08ab
        L_0x08aa:
            r15 = r7
        L_0x08ab:
            com.braze.Braze r8 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            java.math.BigDecimal r11 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0af0 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r8.logPurchase(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x08bb:
            java.lang.String r5 = "logCustomEvent"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x08c5
            goto L_0x0aea
        L_0x08c5:
            java.lang.String r4 = "eventName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r7)     // Catch:{ Exception -> 0x0af0 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0af0 }
            com.braze.models.outgoing.BrazeProperties r5 = r1.convertToBrazeProperties(r5)     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x08e1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x08e2
        L_0x08e1:
            r15 = r7
        L_0x08e2:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r6.logCustomEvent(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x08ed:
            java.lang.String r5 = "requestContentCardsRefresh"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x08f7
            goto L_0x0aea
        L_0x08f7:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0901
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0902
        L_0x0901:
            r15 = r5
        L_0x0902:
            com.braze.Braze r4 = r4.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r5 = 0
            r4.requestContentCardsRefresh(r5)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x090e:
            java.lang.String r5 = "setSdkAuthenticationDelegate"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0918
            goto L_0x0aea
        L_0x0918:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x091c:
            java.lang.String r5 = "wipeData"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0927
            goto L_0x0aea
        L_0x0927:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0931
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0932
        L_0x0931:
            r15 = r5
        L_0x0932:
            r4.wipeData(r15)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0939:
            java.lang.String r5 = "removeFromSubscriptionGroup"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0943
            goto L_0x0aea
        L_0x0943:
            java.lang.Object r4 = r2.argument(r9)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0958
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r6 = "Unexpected null groupId in `removeFromSubscriptionGroup`."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.braze.support.BrazeLogger.w$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0958:
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0962
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0963
        L_0x0962:
            r15 = r6
        L_0x0963:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$14 r6 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$14     // Catch:{ Exception -> 0x0af0 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0973:
            java.lang.String r5 = "setSdkAuthenticationSignature"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x097d
            goto L_0x0aea
        L_0x097d:
            java.lang.Object r4 = r2.argument(r10)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0997
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x098f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0990
        L_0x098f:
            r15 = r6
        L_0x0990:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r5.setSdkAuthenticationSignature(r4)     // Catch:{ Exception -> 0x0af0 }
        L_0x0997:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x099b:
            java.lang.String r5 = "addAlias"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x09a5
            goto L_0x0aea
        L_0x09a5:
            java.lang.String r4 = "aliasName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "aliasLabel"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x09d5
            if (r5 != 0) goto L_0x09ba
            goto L_0x09d5
        L_0x09ba:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x09c4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x09c5
        L_0x09c4:
            r15 = r7
        L_0x09c5:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$1 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$1     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x09d5:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = "Unexpected null parameter(s) in `addAlias`."
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.braze.support.BrazeLogger.w$default(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x09e2:
            java.lang.String r5 = "setBoolCustomUserAttribute"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x09ec
            goto L_0x0aea
        L_0x09ec:
            java.lang.Object r4 = r2.argument(r14)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r6)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x09fc
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0af0 }
        L_0x09fc:
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0a0f
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r7 = "Unexpected null key in `setBoolCustomUserAttribute`."
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            com.braze.support.BrazeLogger.w$default(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0af0 }
            return
        L_0x0a0f:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0a19
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0a1a
        L_0x0a19:
            r15 = r7
        L_0x0a1a:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            com.braze.brazeplugin.BrazePlugin$onMethodCall$9 r7 = new com.braze.brazeplugin.BrazePlugin$onMethodCall$9     // Catch:{ Exception -> 0x0af0 }
            r7.<init>(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            r1.runOnUser(r6, r7)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0a2a:
            java.lang.String r5 = "launchContentCards"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0a34
            goto L_0x0aea
        L_0x0a34:
            android.app.Activity r4 = r1.activity     // Catch:{ Exception -> 0x0af0 }
            if (r4 == 0) goto L_0x0a52
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0af0 }
            android.app.Activity r5 = r1.activity     // Catch:{ Exception -> 0x0af0 }
            java.lang.Class<com.braze.ui.activities.ContentCardsActivity> r6 = com.braze.ui.activities.ContentCardsActivity.class
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0af0 }
            r5 = 872415232(0x34000000, float:1.1920929E-7)
            r4.setFlags(r5)     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0a4e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0a4f
        L_0x0a4e:
            r15 = r5
        L_0x0a4f:
            r15.startActivity(r4)     // Catch:{ Exception -> 0x0af0 }
        L_0x0a52:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0a56:
            java.lang.String r5 = "disableSDK"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0a60
            goto L_0x0aea
        L_0x0a60:
            com.braze.Braze$Companion r4 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r5 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0a6a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0a6b
        L_0x0a6a:
            r15 = r5
        L_0x0a6b:
            r4.disableSdk(r15)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0918
        L_0x0a70:
            java.lang.String r5 = "setGoogleAdvertisingId"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0a7a
            goto L_0x0aea
        L_0x0a7a:
            java.lang.String r4 = "id"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0a85
            return
        L_0x0a85:
            java.lang.String r5 = "adTrackingEnabled"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0af0 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0a90
            return
        L_0x0a90:
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0af0 }
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0a9e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0a9f
        L_0x0a9e:
            r15 = r7
        L_0x0a9f:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r6.setGoogleAdvertisingId(r4, r5)     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0aa9:
            java.lang.String r5 = "changeUser"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0af0 }
            if (r4 != 0) goto L_0x0ab2
            goto L_0x0aea
        L_0x0ab2:
            java.lang.String r4 = "userId"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0af0 }
            java.lang.Object r5 = r2.argument(r10)     // Catch:{ Exception -> 0x0af0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0af0 }
            if (r5 != 0) goto L_0x0ad5
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r6 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r6 != 0) goto L_0x0acc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0acd
        L_0x0acc:
            r15 = r6
        L_0x0acd:
            com.braze.Braze r5 = r5.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r5.changeUser(r4)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0ae7
        L_0x0ad5:
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion     // Catch:{ Exception -> 0x0af0 }
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0af0 }
            if (r7 != 0) goto L_0x0adf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0ae0
        L_0x0adf:
            r15 = r7
        L_0x0ae0:
            com.braze.Braze r6 = r6.getInstance(r15)     // Catch:{ Exception -> 0x0af0 }
            r6.changeUser(r4, r5)     // Catch:{ Exception -> 0x0af0 }
        L_0x0ae7:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0aea:
            r25.notImplemented()     // Catch:{ Exception -> 0x0af0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0af0 }
            goto L_0x0af9
        L_0x0af0:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "Exception encountered"
            java.lang.String r2 = r2.method
            r3.error(r5, r2, r4)
        L_0x0af9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.brazeplugin.BrazePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        onAttachedToActivity(activityPluginBinding);
    }
}
