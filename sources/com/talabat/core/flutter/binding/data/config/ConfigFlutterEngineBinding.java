package com.talabat.core.flutter.binding.data.config;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.binding.data.DeeplinkFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.ActivityEngineBinding;
import com.talabat.core.flutter.binding.domain.config.IConfigFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/flutter/binding/data/config/ConfigFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/data/DeeplinkFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/ActivityEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/config/IConfigFlutterEngineBinding;", "deepLinkChannel", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationNativeDomain;", "globalChannel", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;", "featureFlagChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelFlutterDomain;", "experimentChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelFlutterDomain;", "observabilityChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;", "authenticationChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelFlutterDomain;", "(Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationNativeDomain;Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelFlutterDomain;)V", "init", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigFlutterEngineBinding extends DeeplinkFlutterEngineBinding implements ActivityEngineBinding, IConfigFlutterEngineBinding {
    @Inject
    public ConfigFlutterEngineBinding(@Nullable DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain, @Nullable GlobalChannelFlutterDomain globalChannelFlutterDomain, @Nullable FeatureFlagChannelFlutterDomain featureFlagChannelFlutterDomain, @Nullable ExperimentChannelFlutterDomain experimentChannelFlutterDomain, @Nullable ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, @Nullable AuthenticationChannelFlutterDomain authenticationChannelFlutterDomain) {
        super(CollectionsKt__CollectionsKt.listOf(deeplinkNavigationNativeDomain, globalChannelFlutterDomain, featureFlagChannelFlutterDomain, experimentChannelFlutterDomain, observabilityChannelFlutterDomain, authenticationChannelFlutterDomain));
    }

    public void init(@NotNull FlutterEngine flutterEngine, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        Intrinsics.checkNotNullParameter(activity, "activity");
        System.out.println("Log.info - ConfigFlutterEngineBinding init");
        for (PlatformChannel platformChannel : super.a()) {
            if (platformChannel != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
                platformChannel.onAttachWithActivity(binaryMessenger, activity, bundle);
            }
        }
    }

    public void init(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        for (PlatformChannel platformChannel : super.a()) {
            if (platformChannel != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
                platformChannel.onAttach(binaryMessenger);
            }
        }
    }
}
