package com.talabat.core.flutter.channels.data.experiment;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JH\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132(\u0010\u0003\u001a$\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u0002H\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/talabat/core/flutter/channels/data/experiment/ExperimentMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "extractArgsAndExecute", "", "T", "arguments", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Lkotlin/Function4;", "", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExperimentMethodChannel implements MethodChannel.MethodCallHandler, ExperimentChannelFlutterDomain {
    @NotNull
    private static final String ARGUMENT_KEY_DEFAULT_VALUE = "defaultValue";
    @NotNull
    private static final String ARGUMENT_KEY_EXPERIMENT_NAME = "experimentName";
    @NotNull
    private static final String ARGUMENT_KEY_STRATEGY = "strategy";
    @NotNull
    private static final String ARGUMENT_PROJECT_NAME = "project";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_BOOLEAN_VARIANT = "getBooleanVariant";
    @NotNull
    private static final String GET_DOUBLE_VARIANT = "getDoubleVariant";
    @NotNull
    private static final String GET_INT_VARIANT = "getIntVariant";
    @NotNull
    private static final String GET_STRING_VARIANT = "getStringVariant";
    /* access modifiers changed from: private */
    @NotNull
    public final ExperimentChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/experiment/ExperimentMethodChannel$Companion;", "", "()V", "ARGUMENT_KEY_DEFAULT_VALUE", "", "ARGUMENT_KEY_EXPERIMENT_NAME", "ARGUMENT_KEY_STRATEGY", "ARGUMENT_PROJECT_NAME", "GET_BOOLEAN_VARIANT", "GET_DOUBLE_VARIANT", "GET_INT_VARIANT", "GET_STRING_VARIANT", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ExperimentMethodChannel(@NotNull ExperimentChannelCallback experimentChannelCallback) {
        Intrinsics.checkNotNullParameter(experimentChannelCallback, "callback");
        this.callback = experimentChannelCallback;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> void extractArgsAndExecute(java.lang.Object r5, io.flutter.plugin.common.MethodChannel.Result r6, kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super T, ? super java.lang.String, kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x0009
        L_0x0008:
            r5 = r1
        L_0x0009:
            if (r5 != 0) goto L_0x000f
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.emptyMap()
        L_0x000f:
            java.lang.String r0 = "experimentName"
            java.lang.Object r0 = r5.get(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x001c
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            java.lang.String r2 = "defaultValue"
            java.lang.Object r2 = r5.get(r2)
            if (r0 == 0) goto L_0x0047
            if (r2 == 0) goto L_0x0047
            java.lang.String r6 = "project"
            java.lang.Object r6 = r5.get(r6)
            boolean r3 = r6 instanceof java.lang.String
            if (r3 == 0) goto L_0x0034
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0034:
            r6 = r1
        L_0x0035:
            java.lang.String r3 = "strategy"
            java.lang.Object r5 = r5.get(r3)
            boolean r3 = r5 instanceof java.lang.String
            if (r3 == 0) goto L_0x0043
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x0043:
            r7.invoke(r0, r6, r2, r1)
            goto L_0x0050
        L_0x0047:
            java.lang.String r5 = "Experiment name should not be null"
            java.lang.String r7 = ""
            java.lang.String r0 = "1"
            r6.error(r0, r5, r7)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.experiment.ExperimentMethodChannel.extractArgsAndExecute(java.lang.Object, io.flutter.plugin.common.MethodChannel$Result, kotlin.jvm.functions.Function4):void");
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.EXPERIMENT_CHANNEL);
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
                case -1714451405:
                    if (str.equals(GET_BOOLEAN_VARIANT)) {
                        Object obj = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj, "call.arguments");
                        extractArgsAndExecute(obj, result, new ExperimentMethodChannel$onMethodCall$2(this, result));
                        return;
                    }
                    break;
                case -918344770:
                    if (str.equals(GET_DOUBLE_VARIANT)) {
                        Object obj2 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj2, "call.arguments");
                        extractArgsAndExecute(obj2, result, new ExperimentMethodChannel$onMethodCall$3(this, result));
                        return;
                    }
                    break;
                case -788004994:
                    if (str.equals(GET_STRING_VARIANT)) {
                        Object obj3 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj3, "call.arguments");
                        extractArgsAndExecute(obj3, result, new ExperimentMethodChannel$onMethodCall$4(this, result));
                        return;
                    }
                    break;
                case 1495649676:
                    if (str.equals(GET_INT_VARIANT)) {
                        Object obj4 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj4, "call.arguments");
                        extractArgsAndExecute(obj4, result, new ExperimentMethodChannel$onMethodCall$1(this, result));
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
