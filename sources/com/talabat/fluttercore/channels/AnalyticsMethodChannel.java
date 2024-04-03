package com.talabat.fluttercore.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.fluttercore.tracking.event.FlutterEvent;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.logger.LogManager;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "flutterMigrationTools", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "(Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;)V", "callback", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "extractEventFromCallArgs", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "call", "Lio/flutter/plugin/common/MethodCall;", "getDeeplinkQuery", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleLogEvent", "handleTrackEvent", "onMethodCall", "setCallback", "analyticsMethodChannelCallback", "validateTrackMethodCallArguments", "", "trackMethodCall", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_ATTRIBUTES_KEY = "attributes";
    @NotNull
    public static final String EVENT_NAME_KEY = "eventName";
    @NotNull
    public static final String EVENT_PLATFORMS_KEY = "platforms";
    @NotNull
    public static final String FEATURE_NAME_KEY = "featureName";
    @NotNull
    public static final String GET_DEEPLINK_QUERY_METHOD_CALL = "getDeeplinkQuery";
    @NotNull
    private static final String LOG_EVENT_METHOD_CALL = "logEvent";
    @NotNull
    private static final String NAME_KEY = "name";
    @NotNull
    private static final String PROPS_KEY = "props";
    @NotNull
    private static final String SET_USER_ID_METHOD_CALL = "setUserId";
    @NotNull
    private static final String SET_USER_PROPERTY_METHOD_CALL = "setUserProperty";
    @NotNull
    public static final String TRACK_METHOD_CALL_FLUTTER_EVENT = "trackEvent";
    @Nullable
    private AnalyticsMethodChannelCallback callback;
    @NotNull
    private final FlutterMigrationTools flutterMigrationTools;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel$Companion;", "", "()V", "EVENT_ATTRIBUTES_KEY", "", "EVENT_NAME_KEY", "EVENT_PLATFORMS_KEY", "FEATURE_NAME_KEY", "GET_DEEPLINK_QUERY_METHOD_CALL", "LOG_EVENT_METHOD_CALL", "NAME_KEY", "PROPS_KEY", "SET_USER_ID_METHOD_CALL", "SET_USER_PROPERTY_METHOD_CALL", "TRACK_METHOD_CALL_FLUTTER_EVENT", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsMethodChannel(@NotNull FlutterMigrationTools flutterMigrationTools2) {
        Intrinsics.checkNotNullParameter(flutterMigrationTools2, "flutterMigrationTools");
        this.flutterMigrationTools = flutterMigrationTools2;
    }

    private final TalabatEvent extractEventFromCallArgs(MethodCall methodCall) {
        List list;
        Object obj = methodCall.arguments;
        if (obj != null) {
            Map map = (Map) obj;
            Object obj2 = map.get("eventName");
            if (obj2 != null) {
                String str = (String) obj2;
                Object obj3 = map.get("featureName");
                if (obj3 != null) {
                    String str2 = (String) obj3;
                    Object obj4 = map.get(EVENT_ATTRIBUTES_KEY);
                    if (obj4 != null) {
                        Map map2 = (Map) obj4;
                        Object obj5 = map.get(EVENT_PLATFORMS_KEY);
                        if (obj5 instanceof List) {
                            list = (List) obj5;
                        } else {
                            list = null;
                        }
                        if (list == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        }
                        return new FlutterEvent(str, str2, this.flutterMigrationTools.addMigrationParameters(TRACK_METHOD_CALL_FLUTTER_EVENT, str, (Map<String, String>) map2), list);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
    }

    private final void getDeeplinkQuery(MethodChannel.Result result) {
        String deepLinksQuery = GlobalDataModel.getDeepLinksQuery();
        LogManager.debug("getDeeplinkQuery : " + deepLinksQuery);
        result.success(deepLinksQuery);
    }

    private final void handleLogEvent(MethodCall methodCall) {
        String str;
        Object obj = methodCall.arguments;
        LogManager.debug(LOG_EVENT_METHOD_CALL + obj);
        if (methodCall.hasArgument(PROPS_KEY)) {
            Object obj2 = methodCall.arguments;
            if (obj2 != null) {
                HashMap hashMap = (HashMap) obj2;
                Object obj3 = hashMap.get(PROPS_KEY);
                if (obj3 != null) {
                    HashMap hashMap2 = (HashMap) obj3;
                    if (hashMap.containsKey("name")) {
                        Object obj4 = hashMap.get("name");
                        if (obj4 != null) {
                            str = (String) obj4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        Object obj5 = hashMap.get("eventName");
                        if (obj5 != null) {
                            str = (String) obj5;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    this.flutterMigrationTools.addMigrationParameters(LOG_EVENT_METHOD_CALL, str, (Map<String, String>) hashMap2);
                    LogManager.debug("logEvent : " + hashMap);
                    AnalyticsMethodChannelCallback analyticsMethodChannelCallback = this.callback;
                    if (analyticsMethodChannelCallback != null) {
                        analyticsMethodChannelCallback.logFlutterEvent(str, hashMap2);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        }
    }

    private final void handleTrackEvent(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        LogManager.debug(TRACK_METHOD_CALL_FLUTTER_EVENT + obj);
        if (validateTrackMethodCallArguments(methodCall)) {
            TalabatEvent extractEventFromCallArgs = extractEventFromCallArgs(methodCall);
            AnalyticsMethodChannelCallback analyticsMethodChannelCallback = this.callback;
            if (analyticsMethodChannelCallback != null) {
                analyticsMethodChannelCallback.trackEvent(extractEventFromCallArgs);
                return;
            }
            return;
        }
        LogManager.debug("Invalid Arguments for trackEvent");
    }

    private final boolean validateTrackMethodCallArguments(MethodCall methodCall) {
        Map map;
        Object obj = methodCall.arguments;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map != null && (map.get("eventName") instanceof String) && (map.get("featureName") instanceof String) && (map.get(EVENT_ATTRIBUTES_KEY) instanceof Map)) {
            return true;
        }
        return false;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case 645367112:
                    if (str.equals(SET_USER_ID_METHOD_CALL)) {
                        Object obj = methodCall.arguments;
                        LogManager.debug(SET_USER_ID_METHOD_CALL + obj);
                        return;
                    }
                    break;
                case 776192066:
                    if (str.equals(SET_USER_PROPERTY_METHOD_CALL)) {
                        Object obj2 = methodCall.arguments;
                        LogManager.debug(SET_USER_PROPERTY_METHOD_CALL + obj2);
                        return;
                    }
                    break;
                case 778759628:
                    if (str.equals(GET_DEEPLINK_QUERY_METHOD_CALL)) {
                        getDeeplinkQuery(result);
                        return;
                    }
                    break;
                case 1135978511:
                    if (str.equals(TRACK_METHOD_CALL_FLUTTER_EVENT)) {
                        handleTrackEvent(methodCall);
                        return;
                    }
                    break;
                case 1989757366:
                    if (str.equals(LOG_EVENT_METHOD_CALL)) {
                        handleLogEvent(methodCall);
                        return;
                    }
                    break;
            }
        }
        LogManager.debug("Not Implemented");
    }

    public final void setCallback(@Nullable AnalyticsMethodChannelCallback analyticsMethodChannelCallback) {
        this.callback = analyticsMethodChannelCallback;
    }
}
