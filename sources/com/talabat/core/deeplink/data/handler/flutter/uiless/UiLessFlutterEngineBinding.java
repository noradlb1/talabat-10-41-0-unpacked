package com.talabat.core.deeplink.data.handler.flutter.uiless;

import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0016J\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\"\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;", "Lio/flutter/embedding/engine/FlutterEngine$EngineLifecycleListener;", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "deepLinkChannel", "Lcom/talabat/core/deeplink/data/handler/flutter/uiless/DeepLinkFlutterNavigationChannel;", "globalChannel", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;", "observabilityChannel", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;", "secretsMethodCallHandler", "Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;", "trackingChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelFlutterDomain;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lio/flutter/embedding/engine/FlutterEngine;Lcom/talabat/core/deeplink/data/handler/flutter/uiless/DeepLinkFlutterNavigationChannel;Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelFlutterDomain;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "canOpenDeepLink", "", "deepLink", "", "callback", "Lkotlin/Function1;", "", "destroy", "init", "observeFlutterBehaviour", "explanation", "onEngineWillDestroy", "onPreEngineRestart", "openDeeplink", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UiLessFlutterEngineBinding implements FlutterEngine.EngineLifecycleListener {
    @NotNull
    private final DeepLinkFlutterNavigationChannel deepLinkChannel;
    @NotNull
    private final FlutterEngine flutterEngine;
    @Nullable
    private final GlobalChannelFlutterDomain globalChannel;
    @Nullable
    private final ObservabilityChannelFlutterDomain observabilityChannel;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @Nullable
    private final SecretsChannelFlutterDomain secretsMethodCallHandler;
    @Nullable
    private final TrackingChannelFlutterDomain trackingChannelFlutterDomain;

    @Inject
    public UiLessFlutterEngineBinding(@NotNull FlutterEngine flutterEngine2, @NotNull DeepLinkFlutterNavigationChannel deepLinkFlutterNavigationChannel, @Nullable GlobalChannelFlutterDomain globalChannelFlutterDomain, @Nullable ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, @Nullable SecretsChannelFlutterDomain secretsChannelFlutterDomain, @Nullable TrackingChannelFlutterDomain trackingChannelFlutterDomain2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(flutterEngine2, "flutterEngine");
        Intrinsics.checkNotNullParameter(deepLinkFlutterNavigationChannel, "deepLinkChannel");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.flutterEngine = flutterEngine2;
        this.deepLinkChannel = deepLinkFlutterNavigationChannel;
        this.globalChannel = globalChannelFlutterDomain;
        this.observabilityChannel = observabilityChannelFlutterDomain;
        this.secretsMethodCallHandler = secretsChannelFlutterDomain;
        this.trackingChannelFlutterDomain = trackingChannelFlutterDomain2;
        this.observabilityManager = iObservabilityManager;
    }

    private final void observeFlutterBehaviour(String str) {
        this.observabilityManager.trackUnExpectedScenario(str, MapsKt__MapsKt.mapOf(TuplesKt.to("instance_id", String.valueOf(System.identityHashCode(this))), TuplesKt.to("engine_id", String.valueOf(System.identityHashCode(this.flutterEngine)))));
    }

    public final void canOpenDeepLink(@NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deepLink");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.deepLinkChannel.callCanOpenDeeplink(str, function1);
    }

    public final void destroy() {
        observeFlutterBehaviour("ui_less_flutter_engine_destroy_invoked");
        this.flutterEngine.destroy();
        this.deepLinkChannel.onDetach();
        GlobalChannelFlutterDomain globalChannelFlutterDomain = this.globalChannel;
        if (globalChannelFlutterDomain != null) {
            globalChannelFlutterDomain.onDetach();
        }
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain = this.observabilityChannel;
        if (observabilityChannelFlutterDomain != null) {
            observabilityChannelFlutterDomain.onDetach();
        }
        SecretsChannelFlutterDomain secretsChannelFlutterDomain = this.secretsMethodCallHandler;
        if (secretsChannelFlutterDomain != null) {
            secretsChannelFlutterDomain.onDetach();
        }
        TrackingChannelFlutterDomain trackingChannelFlutterDomain2 = this.trackingChannelFlutterDomain;
        if (trackingChannelFlutterDomain2 != null) {
            trackingChannelFlutterDomain2.onDetach();
        }
    }

    public final void init() {
        this.flutterEngine.addEngineLifecycleListener(this);
        DeepLinkFlutterNavigationChannel deepLinkFlutterNavigationChannel = this.deepLinkChannel;
        BinaryMessenger binaryMessenger = this.flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        deepLinkFlutterNavigationChannel.onAttach(binaryMessenger);
        GlobalChannelFlutterDomain globalChannelFlutterDomain = this.globalChannel;
        if (globalChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger2 = this.flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "flutterEngine.dartExecutor.binaryMessenger");
            globalChannelFlutterDomain.onAttach(binaryMessenger2);
        }
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain = this.observabilityChannel;
        if (observabilityChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger3 = this.flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "flutterEngine.dartExecutor.binaryMessenger");
            observabilityChannelFlutterDomain.onAttach(binaryMessenger3);
        }
        SecretsChannelFlutterDomain secretsChannelFlutterDomain = this.secretsMethodCallHandler;
        if (secretsChannelFlutterDomain != null) {
            BinaryMessenger binaryMessenger4 = this.flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger4, "flutterEngine.dartExecutor.binaryMessenger");
            secretsChannelFlutterDomain.onAttach(binaryMessenger4);
        }
        TrackingChannelFlutterDomain trackingChannelFlutterDomain2 = this.trackingChannelFlutterDomain;
        if (trackingChannelFlutterDomain2 != null) {
            BinaryMessenger binaryMessenger5 = this.flutterEngine.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger5, "flutterEngine.dartExecutor.binaryMessenger");
            trackingChannelFlutterDomain2.onAttach(binaryMessenger5);
        }
    }

    public void onEngineWillDestroy() {
        observeFlutterBehaviour("ui_less_flutter_engine_will_destroy");
    }

    public void onPreEngineRestart() {
        observeFlutterBehaviour("ui_less_flutter_engine_will_restart");
    }

    public final void openDeeplink(@NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deepLink");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.deepLinkChannel.openDeeplink(str, function1);
    }
}
