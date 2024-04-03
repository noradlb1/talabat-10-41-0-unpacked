package com.talabat.core.flutter.binding.domain;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "", "flutterEngineProvider", "Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "registeredFlutterBindingModules", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "observabilityChannel", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;", "secretsMethodCallHandler", "Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;", "trackingChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelFlutterDomain;", "(Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;Ljava/util/Set;Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelFlutterDomain;)V", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "destroy", "", "forceDestroyFlutterEngine", "", "init", "deeplink", "", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "com_talabat_core_flutter-binding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkEngineBindingRegistry {
    private FlutterEngine flutterEngine;
    @NotNull
    private final IFlutterEngineProvider flutterEngineProvider;
    @Nullable
    private final ObservabilityChannelFlutterDomain observabilityChannel;
    @NotNull
    private final Set<EngineBinding> registeredFlutterBindingModules;
    @Nullable
    private final SecretsChannelFlutterDomain secretsMethodCallHandler;
    @Nullable
    private final TrackingChannelFlutterDomain trackingChannelFlutterDomain;

    @Inject
    public DeeplinkEngineBindingRegistry(@NotNull IFlutterEngineProvider iFlutterEngineProvider, @NotNull Set<? extends EngineBinding> set, @Nullable ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, @Nullable SecretsChannelFlutterDomain secretsChannelFlutterDomain, @Nullable TrackingChannelFlutterDomain trackingChannelFlutterDomain2) {
        Intrinsics.checkNotNullParameter(iFlutterEngineProvider, "flutterEngineProvider");
        Intrinsics.checkNotNullParameter(set, "registeredFlutterBindingModules");
        this.flutterEngineProvider = iFlutterEngineProvider;
        this.registeredFlutterBindingModules = set;
        this.observabilityChannel = observabilityChannelFlutterDomain;
        this.secretsMethodCallHandler = secretsChannelFlutterDomain;
        this.trackingChannelFlutterDomain = trackingChannelFlutterDomain2;
    }

    public static /* synthetic */ void destroy$default(DeeplinkEngineBindingRegistry deeplinkEngineBindingRegistry, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        deeplinkEngineBindingRegistry.destroy(z11);
    }

    public static /* synthetic */ FlutterEngine init$default(DeeplinkEngineBindingRegistry deeplinkEngineBindingRegistry, String str, Activity activity, Bundle bundle, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        return deeplinkEngineBindingRegistry.init(str, activity, bundle);
    }

    public final void destroy(boolean z11) {
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
        for (EngineBinding destroy : this.registeredFlutterBindingModules) {
            destroy.destroy();
        }
        if (z11) {
            FlutterEngine flutterEngine2 = this.flutterEngine;
            if (flutterEngine2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                flutterEngine2 = null;
            }
            flutterEngine2.destroy();
        }
    }

    @NotNull
    public final FlutterEngine init(@NotNull String str, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.flutterEngine = this.flutterEngineProvider.provideDeepLinkEngine(str);
        Iterator<T> it = this.registeredFlutterBindingModules.iterator();
        while (true) {
            FlutterEngine flutterEngine2 = null;
            if (!it.hasNext()) {
                break;
            }
            EngineBinding engineBinding = (EngineBinding) it.next();
            if (engineBinding instanceof ActivityEngineBinding) {
                ActivityEngineBinding activityEngineBinding = (ActivityEngineBinding) engineBinding;
                FlutterEngine flutterEngine3 = this.flutterEngine;
                if (flutterEngine3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                } else {
                    flutterEngine2 = flutterEngine3;
                }
                activityEngineBinding.init(flutterEngine2, activity, bundle);
            } else {
                FlutterEngine flutterEngine4 = this.flutterEngine;
                if (flutterEngine4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                } else {
                    flutterEngine2 = flutterEngine4;
                }
                engineBinding.init(flutterEngine2);
            }
        }
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain = this.observabilityChannel;
        if (observabilityChannelFlutterDomain != null) {
            FlutterEngine flutterEngine5 = this.flutterEngine;
            if (flutterEngine5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                flutterEngine5 = null;
            }
            BinaryMessenger binaryMessenger = flutterEngine5.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
            observabilityChannelFlutterDomain.onAttach(binaryMessenger);
        }
        SecretsChannelFlutterDomain secretsChannelFlutterDomain = this.secretsMethodCallHandler;
        if (secretsChannelFlutterDomain != null) {
            FlutterEngine flutterEngine6 = this.flutterEngine;
            if (flutterEngine6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                flutterEngine6 = null;
            }
            BinaryMessenger binaryMessenger2 = flutterEngine6.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "flutterEngine.dartExecutor.binaryMessenger");
            secretsChannelFlutterDomain.onAttach(binaryMessenger2);
        }
        TrackingChannelFlutterDomain trackingChannelFlutterDomain2 = this.trackingChannelFlutterDomain;
        if (trackingChannelFlutterDomain2 != null) {
            FlutterEngine flutterEngine7 = this.flutterEngine;
            if (flutterEngine7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
                flutterEngine7 = null;
            }
            BinaryMessenger binaryMessenger3 = flutterEngine7.getDartExecutor().getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "flutterEngine.dartExecutor.binaryMessenger");
            trackingChannelFlutterDomain2.onAttach(binaryMessenger3);
        }
        FlutterEngine flutterEngine8 = this.flutterEngine;
        if (flutterEngine8 != null) {
            return flutterEngine8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flutterEngine");
        return null;
    }
}
