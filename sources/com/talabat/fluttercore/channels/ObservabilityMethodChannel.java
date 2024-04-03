package com.talabat.fluttercore.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "callback", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannelCallback;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "(Lcom/talabat/fluttercore/channels/ObservabilityMethodChannelCallback;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "validateObserveArgs", "", "observeMethodCall", "validateScreenTrackingParams", "screenTackingMethodCall", "validateUnexpectedScenarioArgs", "trackUnExpectedScenarioMethodCall", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String ATTRIBUTES_KEY = "attributes";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_NAME_KEY = "eventName";
    @NotNull
    private static final String EXPLANATION_KEY = "explanation";
    @NotNull
    private static final String FEATURE_NAME_KEY = "featureName";
    @NotNull
    private static final String OBSERVE_METHOD_CALL = "observe";
    @NotNull
    private static final String SCREEN_NAME = "screenName";
    @NotNull
    private static final String SCREEN_TYPE = "screenType";
    @NotNull
    private static final String START_TRACE_METHOD_CALL = "startTracing";
    @NotNull
    private static final String STOP_TRACE_METHOD_CALL = "endTracing";
    @NotNull
    private static final String TRACE = "traceId";
    @NotNull
    private static final String TRACK_UNEXPECTED_SCENARIO_METHOD_CALL = "trackUnexpectedScenario";
    @Nullable
    private ObservabilityMethodChannelCallback callback;
    @NotNull
    private final IScreenTracker screenTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel$Companion;", "", "()V", "ATTRIBUTES_KEY", "", "EVENT_NAME_KEY", "EXPLANATION_KEY", "FEATURE_NAME_KEY", "OBSERVE_METHOD_CALL", "SCREEN_NAME", "SCREEN_TYPE", "START_TRACE_METHOD_CALL", "STOP_TRACE_METHOD_CALL", "TRACE", "TRACK_UNEXPECTED_SCENARIO_METHOD_CALL", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ObservabilityMethodChannel(@Nullable ObservabilityMethodChannelCallback observabilityMethodChannelCallback, @NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "screenTracker");
        this.callback = observabilityMethodChannelCallback;
        this.screenTracker = iScreenTracker;
    }

    private final boolean validateObserveArgs(MethodCall methodCall) {
        Map map;
        Object obj = methodCall.arguments;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map != null && (map.get("eventName") instanceof String) && (map.get("featureName") instanceof String) && (map.get("attributes") instanceof Map)) {
            return true;
        }
        return false;
    }

    private final boolean validateScreenTrackingParams(MethodCall methodCall) {
        Map map;
        Object obj = methodCall.arguments;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map == null || !(map.get(TRACE) instanceof String) || !(map.get("screenName") instanceof String) || !(map.get("screenType") instanceof String)) {
            return false;
        }
        return true;
    }

    private final boolean validateUnexpectedScenarioArgs(MethodCall methodCall) {
        Map map;
        Object obj = methodCall.arguments;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map != null && (map.get(EXPLANATION_KEY) instanceof String) && (map.get("attributes") instanceof Map)) {
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
                case -1651322596:
                    if (str.equals(OBSERVE_METHOD_CALL)) {
                        Object obj = methodCall.arguments;
                        LogManager.debug(OBSERVE_METHOD_CALL + obj);
                        if (validateObserveArgs(methodCall)) {
                            Object obj2 = methodCall.arguments;
                            if (obj2 != null) {
                                Map map = (Map) obj2;
                                Object obj3 = map.get("attributes");
                                if (obj3 != null) {
                                    Map map2 = (Map) obj3;
                                    Object obj4 = map.get("eventName");
                                    if (obj4 != null) {
                                        String str2 = (String) obj4;
                                        Object obj5 = map.get("featureName");
                                        if (obj5 != null) {
                                            String str3 = (String) obj5;
                                            ObservabilityMethodChannelCallback observabilityMethodChannelCallback = this.callback;
                                            if (observabilityMethodChannelCallback != null) {
                                                observabilityMethodChannelCallback.observe(str2, str3, map2);
                                                return;
                                            }
                                            return;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                        }
                        LogManager.debug("Invalid arguments for observe");
                        return;
                    }
                    break;
                case -1201843712:
                    if (str.equals(START_TRACE_METHOD_CALL)) {
                        if (validateScreenTrackingParams(methodCall)) {
                            String str4 = (String) methodCall.argument(TRACE);
                            String str5 = (String) methodCall.argument("screenName");
                            String str6 = (String) methodCall.argument("screenType");
                            IScreenTracker iScreenTracker = this.screenTracker;
                            Intrinsics.checkNotNull(str4);
                            Intrinsics.checkNotNull(str5);
                            Intrinsics.checkNotNull(str6);
                            iScreenTracker.startTrace(new ScreenTrackerParams(str4, str5, str6));
                            return;
                        }
                        LogManager.debug("Invalid arguments for startTracing");
                        return;
                    }
                    break;
                case -839892121:
                    if (str.equals(STOP_TRACE_METHOD_CALL)) {
                        if (validateScreenTrackingParams(methodCall)) {
                            String str7 = (String) methodCall.argument(TRACE);
                            String str8 = (String) methodCall.argument("screenName");
                            String str9 = (String) methodCall.argument("screenType");
                            IScreenTracker iScreenTracker2 = this.screenTracker;
                            Intrinsics.checkNotNull(str7);
                            Intrinsics.checkNotNull(str8);
                            Intrinsics.checkNotNull(str9);
                            iScreenTracker2.stopTrace(new ScreenTrackerParams(str7, str8, str9));
                            return;
                        }
                        LogManager.debug("Invalid arguments for endTracing");
                        return;
                    }
                    break;
                case 1576973228:
                    if (str.equals(TRACK_UNEXPECTED_SCENARIO_METHOD_CALL)) {
                        Object obj6 = methodCall.arguments;
                        LogManager.debug(TRACK_UNEXPECTED_SCENARIO_METHOD_CALL + obj6);
                        if (validateUnexpectedScenarioArgs(methodCall)) {
                            Object obj7 = methodCall.arguments;
                            if (obj7 != null) {
                                Map map3 = (Map) obj7;
                                Object obj8 = map3.get("attributes");
                                if (obj8 != null) {
                                    Map map4 = (Map) obj8;
                                    Object obj9 = map3.get(EXPLANATION_KEY);
                                    if (obj9 != null) {
                                        String str10 = (String) obj9;
                                        ObservabilityMethodChannelCallback observabilityMethodChannelCallback2 = this.callback;
                                        if (observabilityMethodChannelCallback2 != null) {
                                            observabilityMethodChannelCallback2.trackUnexpectedScenario(str10, map4);
                                            return;
                                        }
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                        }
                        LogManager.debug("Invalid arguments for trackUnexpectedScenario");
                        return;
                    }
                    break;
            }
        }
        LogManager.debug("Not Implemented");
    }

    public final void setCallback(@Nullable ObservabilityMethodChannelCallback observabilityMethodChannelCallback) {
        this.callback = observabilityMethodChannelCallback;
    }
}
