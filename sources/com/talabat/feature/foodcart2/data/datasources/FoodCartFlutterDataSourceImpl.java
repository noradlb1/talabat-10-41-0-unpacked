package com.talabat.feature.foodcart2.data.datasources;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.fwf.data.FwfTrackingConstantsKt;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.channels.ExperimentMethodChannel;
import com.talabat.fluttercore.channels.ExperimentMethodChannelCallback;
import com.talabat.fluttercore.channels.FeatureFlagMethodChannelCallback;
import com.talabat.fluttercore.channels.dto.FeatureFlagMethodChannel;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.engine.EngineProvider;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ7\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0010H\u0016J \u0010*\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016JP\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180,j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`-2\u0006\u0010.\u001a\u00020)2\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180,j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`-H\u0016J \u0010/\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J\u001a\u00104\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0019\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u00107J7\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u001a2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0=H@ø\u0001\u0000¢\u0006\u0002\u0010>R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSourceImpl;", "Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSource;", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/FeatureFlagMethodChannelCallback;", "engineProvider", "Lcom/talabat/fluttercore/engine/EngineProvider;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatObservability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/fluttercore/engine/EngineProvider;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "isTest", "", "talabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "addItem", "", "item", "", "", "", "branchId", "", "deliveryMode", "(Ljava/util/Map;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBooleanVariant", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "strategy", "Lcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;", "getDoubleVariant", "", "getFeatureFlag", "featureFlagKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "getIntVariant", "getRemoteConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "remoteConfigKey", "getStringVariant", "registerExperimentChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "registerFeatureFlagChannel", "setChannel", "setCurrentCartId", "cartId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuantity", "menuItemId", "specialRequest", "updatedQuantity", "choices", "", "(ILjava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_feature_foodcart2_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodCartFlutterDataSourceImpl implements FoodCartFlutterDataSource, ExperimentMethodChannelCallback, FeatureFlagMethodChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String cartIdKey = "cartId";
    @NotNull
    public static final String setCurrentCartId = "setCurrentCartId";
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final EngineProvider engineProvider;
    private boolean isTest;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final IObservabilityManager talabatObservability;
    @NotNull
    private final RemoteConfiguration talabatRemoteConfiguration = RemoteConfiguration.INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSourceImpl$Companion;", "", "()V", "cartIdKey", "", "setCurrentCartId", "com_talabat_feature_foodcart2_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FoodCartFlutterDataSourceImpl(@NotNull EngineProvider engineProvider2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(engineProvider2, "engineProvider");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "talabatObservability");
        this.engineProvider = engineProvider2;
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatObservability = iObservabilityManager;
    }

    private final void registerExperimentChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.EXPERIMENT_CHANNEL);
        ExperimentMethodChannel experimentMethodChannel = new ExperimentMethodChannel();
        experimentMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(experimentMethodChannel);
    }

    private final void registerFeatureFlagChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.FEATURE_FLAG_CHANNEL);
        FeatureFlagMethodChannel featureFlagMethodChannel = new FeatureFlagMethodChannel(this.talabatObservability);
        featureFlagMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(featureFlagMethodChannel);
    }

    public static /* synthetic */ void setChannel$default(FoodCartFlutterDataSourceImpl foodCartFlutterDataSourceImpl, MethodChannel methodChannel, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        foodCartFlutterDataSourceImpl.setChannel(methodChannel, z11);
    }

    @Nullable
    public Object addItem(@NotNull Map<String, ? extends Object> map, int i11, @NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        FlutterEngine provideFlutterEngine = this.engineProvider.provideFlutterEngine(TalabatFlutterEntryPoints.CART_GATEWAY.getValue());
        if (!this.isTest) {
            registerExperimentChannel(provideFlutterEngine);
            registerFeatureFlagChannel(provideFlutterEngine);
        }
        if (this.channel == null) {
            this.channel = new MethodChannel(provideFlutterEngine.getDartExecutor(), MethodChannels.CART_GATEWAY_CHANNEL);
        }
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("addItem", MapsKt__MapsKt.mapOf(TuplesKt.to("item", map), TuplesKt.to("branchId", Boxing.boxInt(i11)), TuplesKt.to("deliveryMode", str)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object clearCart(@NotNull Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        FlutterEngine provideFlutterEngine = this.engineProvider.provideFlutterEngine(TalabatFlutterEntryPoints.CART_GATEWAY.getValue());
        if (this.channel == null) {
            this.channel = new MethodChannel(provideFlutterEngine.getDartExecutor(), MethodChannels.CART_GATEWAY_CHANNEL);
        }
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("clearCart", (Object) null, new FoodCartFlutterDataSourceImpl$clearCart$2$1(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.talabatExperiment.getBooleanVariant(fWFKey, z11, talabatExperimentDataSourceStrategy);
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.talabatExperiment.getDoubleVariant(fWFKey, d11, talabatExperimentDataSourceStrategy);
    }

    public boolean getFeatureFlag(@NotNull FWFKeyObject fWFKeyObject, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKeyObject, FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_FEATURE_FLAG_KEY);
        return this.talabatFeatureFlag.getFeatureFlag(fWFKeyObject, z11);
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.talabatExperiment.getIntVariant(fWFKey, i11, talabatExperimentDataSourceStrategy);
    }

    @NotNull
    public HashMap<String, Object> getRemoteConfig(@NotNull FWFKeyObject fWFKeyObject, @NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(fWFKeyObject, "remoteConfigKey");
        Intrinsics.checkNotNullParameter(hashMap, "defaultValue");
        return (HashMap) this.talabatRemoteConfiguration.getRemoteConfiguration(fWFKeyObject, hashMap, new HashMap().getClass());
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.talabatExperiment.getStringVariant(fWFKey, str, talabatExperimentDataSourceStrategy);
    }

    @VisibleForTesting
    public final void setChannel(@NotNull MethodChannel methodChannel, boolean z11) {
        Intrinsics.checkNotNullParameter(methodChannel, "channel");
        this.channel = methodChannel;
        this.isTest = z11;
    }

    @Nullable
    public Object setCurrentCartId(int i11, @NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        FlutterEngine provideFlutterEngine = this.engineProvider.provideFlutterEngine(TalabatFlutterEntryPoints.CART_GATEWAY.getValue());
        if (!this.isTest) {
            registerExperimentChannel(provideFlutterEngine);
            registerFeatureFlagChannel(provideFlutterEngine);
        }
        if (this.channel == null) {
            this.channel = new MethodChannel(provideFlutterEngine.getDartExecutor(), MethodChannels.CART_GATEWAY_CHANNEL);
        }
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod(setCurrentCartId, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(cartIdKey, Boxing.boxInt(i11))), new FoodCartFlutterDataSourceImpl$setCurrentCartId$2$1(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object updateQuantity(int i11, @NotNull String str, int i12, @NotNull List<Integer> list, @NotNull Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        FlutterEngine provideFlutterEngine = this.engineProvider.provideFlutterEngine(TalabatFlutterEntryPoints.CART_GATEWAY.getValue());
        if (this.channel == null) {
            this.channel = new MethodChannel(provideFlutterEngine.getDartExecutor(), MethodChannels.CART_GATEWAY_CHANNEL);
        }
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("updateQuantity", MapsKt__MapsKt.mapOf(TuplesKt.to("menuItemId", Boxing.boxInt(i11)), TuplesKt.to("specialRequest", str), TuplesKt.to("choices", list), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, Boxing.boxInt(i12))), new FoodCartFlutterDataSourceImpl$updateQuantity$2$1(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }
}
