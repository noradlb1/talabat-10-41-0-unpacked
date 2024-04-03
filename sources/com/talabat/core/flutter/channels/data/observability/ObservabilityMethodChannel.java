package com.talabat.core.flutter.channels.data.observability;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/core/flutter/channels/data/observability/ObservabilityMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "handleObserve", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleStartTrace", "handleStopTrace", "handleTrackUnexpectedScenario", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityMethodChannel implements MethodChannel.MethodCallHandler, ObservabilityChannelFlutterDomain {
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
    @NotNull
    private final ObservabilityChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/observability/ObservabilityMethodChannel$Companion;", "", "()V", "ATTRIBUTES_KEY", "", "EVENT_NAME_KEY", "EXPLANATION_KEY", "FEATURE_NAME_KEY", "OBSERVE_METHOD_CALL", "SCREEN_NAME", "SCREEN_TYPE", "START_TRACE_METHOD_CALL", "STOP_TRACE_METHOD_CALL", "TRACE", "TRACK_UNEXPECTED_SCENARIO_METHOD_CALL", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ObservabilityMethodChannel(@NotNull ObservabilityChannelCallback observabilityChannelCallback) {
        Intrinsics.checkNotNullParameter(observabilityChannelCallback, "callback");
        this.callback = observabilityChannelCallback;
    }

    private final void handleObserve(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Map map = (Map) obj;
            Map map2 = (Map) map.get("attributes");
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("featureName");
            if (map2 == null || str2 == null || str == null) {
                result.error("1", "Invalid arguments", "The attributes, eventName and featureName should not be null");
                return;
            }
            this.callback.observe(str, str2, map2);
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final void handleStartTrace(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Map map = (Map) obj;
            String str = (String) map.get(TRACE);
            String str2 = (String) map.get("screenName");
            String str3 = (String) map.get("screenType");
            if (str == null || str2 == null || str3 == null) {
                result.error("1", "Invalid arguments", "The trace, screenName and screenType should not be null");
                return;
            }
            this.callback.startTracing(str, str2, str3);
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final void handleStopTrace(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Map map = (Map) obj;
            String str = (String) map.get(TRACE);
            String str2 = (String) map.get("screenName");
            String str3 = (String) map.get("screenType");
            if (str == null || str2 == null || str3 == null) {
                result.error("1", "Invalid arguments", "The trace, screenName and screenType should not be null");
                return;
            }
            this.callback.endTracing(str, str2, str3);
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final void handleTrackUnexpectedScenario(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Map map = (Map) obj;
            Map map2 = (Map) map.get("attributes");
            String str = (String) map.get(EXPLANATION_KEY);
            if (map2 == null || str == null) {
                result.error("1", "Invalid arguments", "The attributes and explanation should not be null");
                return;
            }
            this.callback.trackUnexpectedScenario(map2, str);
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.OBSERVABILITY_CHANNEL);
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
                case -1651322596:
                    if (str.equals(OBSERVE_METHOD_CALL)) {
                        handleObserve(methodCall, result);
                        return;
                    }
                    break;
                case -1201843712:
                    if (str.equals(START_TRACE_METHOD_CALL)) {
                        handleStartTrace(methodCall, result);
                        return;
                    }
                    break;
                case -839892121:
                    if (str.equals(STOP_TRACE_METHOD_CALL)) {
                        handleStopTrace(methodCall, result);
                        return;
                    }
                    break;
                case 1576973228:
                    if (str.equals(TRACK_UNEXPECTED_SCENARIO_METHOD_CALL)) {
                        handleTrackUnexpectedScenario(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
