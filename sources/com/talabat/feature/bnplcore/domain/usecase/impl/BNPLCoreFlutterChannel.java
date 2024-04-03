package com.talabat.feature.bnplcore.domain.usecase.impl;

import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/BNPLCoreFlutterChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "globalChannel", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;", "observabilityChannel", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;", "secretsMethodCallHandler", "Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;", "experimentChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelFlutterDomain;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "(Lio/flutter/embedding/engine/FlutterEngine;Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelFlutterDomain;Lio/flutter/plugin/common/MethodChannel;)V", "methodIsUserBNPLEligible", "", "isUserBNPLEligible", "", "callback", "Lkotlin/Function1;", "", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLCoreFlutterChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private final MethodChannel channel;
    @NotNull
    private final String methodIsUserBNPLEligible = "isUserBNPLEligible";

    public BNPLCoreFlutterChannel(@NotNull FlutterEngine flutterEngine, @Nullable GlobalChannelFlutterDomain globalChannelFlutterDomain, @Nullable ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, @Nullable SecretsChannelFlutterDomain secretsChannelFlutterDomain, @Nullable ExperimentChannelFlutterDomain experimentChannelFlutterDomain, @NotNull MethodChannel methodChannel) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        Intrinsics.checkNotNullParameter(methodChannel, "channel");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        if (globalChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
            globalChannelFlutterDomain.onAttach(binaryMessenger);
        }
        if (observabilityChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger2 = flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "flutterEngine.dartExecutor.binaryMessenger");
            observabilityChannelFlutterDomain.onAttach(binaryMessenger2);
        }
        if (secretsChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger3 = flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "flutterEngine.dartExecutor.binaryMessenger");
            secretsChannelFlutterDomain.onAttach(binaryMessenger3);
        }
        if (experimentChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger4 = flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger4, "flutterEngine.dartExecutor.binaryMessenger");
            experimentChannelFlutterDomain.onAttach(binaryMessenger4);
        }
    }

    public final void isUserBNPLEligible(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.channel.invokeMethod(this.methodIsUserBNPLEligible, (Object) null, new BNPLCoreFlutterChannel$isUserBNPLEligible$1(function1));
    }

    public final void onDetach() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
    }
}
