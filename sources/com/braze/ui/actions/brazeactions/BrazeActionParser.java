package com.braze.ui.actions.brazeactions;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.appboy.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.ui.actions.brazeactions.steps.AddToCustomAttributeArrayStep;
import com.braze.ui.actions.brazeactions.steps.ContainerStep;
import com.braze.ui.actions.brazeactions.steps.IBrazeActionStep;
import com.braze.ui.actions.brazeactions.steps.LogCustomEventStep;
import com.braze.ui.actions.brazeactions.steps.NoOpStep;
import com.braze.ui.actions.brazeactions.steps.OpenLinkExternallyStep;
import com.braze.ui.actions.brazeactions.steps.OpenLinkInWebViewStep;
import com.braze.ui.actions.brazeactions.steps.RemoveFromCustomAttributeArrayStep;
import com.braze.ui.actions.brazeactions.steps.RequestPushPermissionStep;
import com.braze.ui.actions.brazeactions.steps.SetCustomUserAttributeStep;
import com.braze.ui.actions.brazeactions.steps.SetEmailSubscriptionStep;
import com.braze.ui.actions.brazeactions.steps.SetPushNotificationSubscriptionStep;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.NativeProtocol;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0019J\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b*\u00020\fH\u0000¢\u0006\u0002\b\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/braze/ui/actions/brazeactions/BrazeActionParser;", "", "()V", "BRAZE_ACTIONS_SCHEME", "", "BRAZE_ACTIONS_V1", "TYPE", "execute", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "channel", "Lcom/appboy/enums/Channel;", "getActionType", "Lcom/braze/ui/actions/brazeactions/BrazeActionParser$ActionType;", "data", "Lcom/braze/ui/actions/brazeactions/steps/StepData;", "getActionType$android_sdk_ui_release", "parse", "parse$android_sdk_ui_release", "parseEncodedActionToJson", "Lorg/json/JSONObject;", "action", "parseEncodedActionToJson$android_sdk_ui_release", "getBrazeActionVersionAndJson", "Lkotlin/Pair;", "getBrazeActionVersionAndJson$android_sdk_ui_release", "isBrazeActionUri", "", "ActionType", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeActionParser {
    @NotNull
    public static final String BRAZE_ACTIONS_SCHEME = "brazeActions";
    @NotNull
    private static final String BRAZE_ACTIONS_V1 = "v1";
    @NotNull
    public static final BrazeActionParser INSTANCE = new BrazeActionParser();
    @NotNull
    public static final String TYPE = "type";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/braze/ui/actions/brazeactions/BrazeActionParser$ActionType;", "", "key", "", "impl", "Lcom/braze/ui/actions/brazeactions/steps/IBrazeActionStep;", "(Ljava/lang/String;ILjava/lang/String;Lcom/braze/ui/actions/brazeactions/steps/IBrazeActionStep;)V", "getImpl", "()Lcom/braze/ui/actions/brazeactions/steps/IBrazeActionStep;", "getKey", "()Ljava/lang/String;", "CONTAINER", "LOG_CUSTOM_EVENT", "SET_CUSTOM_ATTRIBUTE", "REQUEST_PUSH_PERMISSION", "ADD_TO_SUBSCRIPTION_GROUP", "REMOVE_FROM_SUBSCRIPTION_GROUP", "ADD_TO_CUSTOM_ATTRIBUTE_ARRAY", "REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY", "SET_EMAIL_SUBSCRIPTION", "SET_PUSH_NOTIFICATION_SUBSCRIPTION", "OPEN_LINK_IN_WEBVIEW", "OPEN_LINK_EXTERNALLY", "INVALID", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ActionType {
        CONTAINER(TtmlNode.RUBY_CONTAINER, ContainerStep.INSTANCE),
        LOG_CUSTOM_EVENT("logCustomEvent", LogCustomEventStep.INSTANCE),
        SET_CUSTOM_ATTRIBUTE("setCustomUserAttribute", SetCustomUserAttributeStep.INSTANCE),
        REQUEST_PUSH_PERMISSION("requestPushPermission", RequestPushPermissionStep.INSTANCE),
        ADD_TO_SUBSCRIPTION_GROUP("addToSubscriptionGroup", r1),
        REMOVE_FROM_SUBSCRIPTION_GROUP("removeFromSubscriptionGroup", r1),
        ADD_TO_CUSTOM_ATTRIBUTE_ARRAY("addToCustomAttributeArray", AddToCustomAttributeArrayStep.INSTANCE),
        REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY("removeFromCustomAttributeArray", RemoveFromCustomAttributeArrayStep.INSTANCE),
        SET_EMAIL_SUBSCRIPTION("setEmailNotificationSubscriptionType", SetEmailSubscriptionStep.INSTANCE),
        SET_PUSH_NOTIFICATION_SUBSCRIPTION("setPushNotificationSubscriptionType", SetPushNotificationSubscriptionStep.INSTANCE),
        OPEN_LINK_IN_WEBVIEW("openLinkInWebview", OpenLinkInWebViewStep.INSTANCE),
        OPEN_LINK_EXTERNALLY("openLink", OpenLinkExternallyStep.INSTANCE),
        INVALID("", NoOpStep.INSTANCE);
        
        @NotNull
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        @NotNull
        public static final Map<String, ActionType> map = null;
        @NotNull
        private final IBrazeActionStep impl;
        @NotNull
        private final String key;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/braze/ui/actions/brazeactions/BrazeActionParser$ActionType$Companion;", "", "()V", "map", "", "", "Lcom/braze/ui/actions/brazeactions/BrazeActionParser$ActionType;", "fromValue", "value", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final ActionType fromValue(@Nullable String str) {
                Map access$getMap$cp = ActionType.map;
                if (str == null) {
                    str = "";
                }
                Object obj = access$getMap$cp.get(str);
                if (obj == null) {
                    obj = ActionType.INVALID;
                }
                return (ActionType) obj;
            }
        }

        /* access modifiers changed from: public */
        static {
            int i11;
            Companion = new Companion((DefaultConstructorMarker) null);
            ActionType[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(values.length), 16));
            int length = values.length;
            while (i11 < length) {
                ActionType actionType = values[i11];
                i11++;
                linkedHashMap.put(actionType.getKey(), actionType);
            }
            map = linkedHashMap;
        }

        private ActionType(String str, IBrazeActionStep iBrazeActionStep) {
            this.key = str;
            this.impl = iBrazeActionStep;
        }

        @JvmStatic
        @NotNull
        public static final ActionType fromValue(@Nullable String str) {
            return Companion.fromValue(str);
        }

        @NotNull
        public final IBrazeActionStep getImpl() {
            return this.impl;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    private BrazeActionParser() {
    }

    public static /* synthetic */ void execute$default(BrazeActionParser brazeActionParser, Context context, Uri uri, Channel channel, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            channel = Channel.UNKNOWN;
        }
        brazeActionParser.execute(context, uri, channel);
    }

    public final void execute(@NotNull Context context, @NotNull Uri uri, @NotNull Channel channel) {
        Context context2 = context;
        Uri uri2 = uri;
        Channel channel2 = channel;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActionParser$execute$1(channel2, uri), 6, (Object) null);
        try {
            Pair brazeActionVersionAndJson$android_sdk_ui_release = getBrazeActionVersionAndJson$android_sdk_ui_release(uri);
            if (brazeActionVersionAndJson$android_sdk_ui_release == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BrazeActionParser$execute$2.INSTANCE, 6, (Object) null);
                return;
            }
            String str = (String) brazeActionVersionAndJson$android_sdk_ui_release.component1();
            JSONObject jSONObject = (JSONObject) brazeActionVersionAndJson$android_sdk_ui_release.component2();
            if (!Intrinsics.areEqual((Object) str, (Object) BRAZE_ACTIONS_V1)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeActionParser$execute$3(str), 7, (Object) null);
                return;
            }
            parse$android_sdk_ui_release(context, new StepData(jSONObject, channel2));
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActionParser$execute$5(uri), 6, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazeActionParser$execute$4(uri), 4, (Object) null);
        }
    }

    public final /* synthetic */ ActionType getActionType$android_sdk_ui_release(StepData stepData) {
        Intrinsics.checkNotNullParameter(stepData, "data");
        ActionType fromValue = ActionType.Companion.fromValue(JsonUtils.getOptionalString(stepData.getSrcJson(), "type"));
        if (fromValue.getImpl().isValid(stepData)) {
            return fromValue;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeActionParser$getActionType$1(fromValue, stepData), 7, (Object) null);
        return ActionType.INVALID;
    }

    public final /* synthetic */ Pair getBrazeActionVersionAndJson$android_sdk_ui_release(Uri uri) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String host = uri.getHost();
        String lastPathSegment = uri.getLastPathSegment();
        if (host == null || lastPathSegment == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) uri, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeActionParser$getBrazeActionVersionAndJson$1(uri), 7, (Object) null);
            return null;
        }
        try {
            jSONObject = parseEncodedActionToJson$android_sdk_ui_release(lastPathSegment);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) uri, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazeActionParser$getBrazeActionVersionAndJson$json$1(lastPathSegment), 4, (Object) null);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return new Pair(host, jSONObject);
    }

    public final boolean isBrazeActionUri(@Nullable Uri uri) {
        return Intrinsics.areEqual((Object) uri == null ? null : uri.getScheme(), (Object) BRAZE_ACTIONS_SCHEME);
    }

    public final /* synthetic */ void parse$android_sdk_ui_release(Context context, StepData stepData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stepData, "data");
        try {
            ActionType actionType$android_sdk_ui_release = getActionType$android_sdk_ui_release(stepData);
            if (actionType$android_sdk_ui_release != ActionType.INVALID) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActionParser$parse$1(actionType$android_sdk_ui_release, stepData), 6, (Object) null);
                actionType$android_sdk_ui_release.getImpl().run(context, stepData);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazeActionParser$parse$2(stepData), 4, (Object) null);
        }
    }

    public final /* synthetic */ JSONObject parseEncodedActionToJson$android_sdk_ui_release(String str) {
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        byte[] decode = Base64.decode(str, 8);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(action, Base64.URL_SAFE)");
        int length = decode.length / 2;
        int[] iArr = new int[length];
        int i11 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, decode.length - 1, 2);
        if (progressionLastElement >= 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 2;
                iArr[i12 / 2] = (decode[i12] & 255) | ((decode[i12 + 1] & 255) << 8);
                if (i12 == progressionLastElement) {
                    break;
                }
                i12 = i13;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i11 < length) {
            int i14 = iArr[i11];
            i11++;
            if (i14 < 0 || i14 > 65535) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid Char code: ", Integer.valueOf(i14)));
            }
            sb2.append((char) i14);
        }
        return new JSONObject(sb2.toString());
    }
}
