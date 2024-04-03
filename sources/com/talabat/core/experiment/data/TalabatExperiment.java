package com.talabat.core.experiment.data;

import androidx.annotation.VisibleForTesting;
import com.talabat.apptimize.ApptimizeSdkWrapper;
import com.talabat.core.experiment.data.datasource.ApptimizeExperimentDataSource;
import com.talabat.core.experiment.data.datasource.FwfExperimentDataSource;
import com.talabat.core.experiment.data.datasource.IExperimentDataSource;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J<\u0010\n\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J<\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ<\u0010\u001a\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ<\u0010\u001d\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\b\u0010 \u001a\u00020\u0013H\u0007J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0016J \u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0004H\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/talabat/core/experiment/data/TalabatExperiment;", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "()V", "<set-?>", "Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "apptimize", "getApptimize$com_talabat_core_experiment_data_data", "()Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "fwf", "getFwf$com_talabat_core_experiment_data_data", "getBooleanVariant", "", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "strategy", "Lcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "getDoubleVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;DZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExperimentDataSourceStrategy", "getIntVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;IZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStringVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/String;ZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetExperimentDataSource", "setAttribute", "attribute", "Lcom/talabat/core/experiment/domain/FWFAttributes;", "attributeValue", "setExperimentDataSource", "experimentDataSource", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Inject [ITalabatExperiment] from [ExperimentCoreLibApi] and dont use this global singleton directly")
public final class TalabatExperiment implements ITalabatExperiment {
    @NotNull
    public static final TalabatExperiment INSTANCE = new TalabatExperiment();
    @NotNull
    private static IExperimentDataSource apptimize = new ApptimizeExperimentDataSource((ApptimizeSdkWrapper) null, 1, (DefaultConstructorMarker) null);
    @NotNull
    private static IExperimentDataSource fwf = new FwfExperimentDataSource((IFunWithFlags) null, 1, (DefaultConstructorMarker) null);

    private TalabatExperiment() {
    }

    private final IExperimentDataSource getExperimentDataSourceStrategy(TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        return talabatExperimentDataSourceStrategy == TalabatExperimentDataSourceStrategy.FWF ? fwf : apptimize;
    }

    @NotNull
    public final IExperimentDataSource getApptimize$com_talabat_core_experiment_data_data() {
        return apptimize;
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getBooleanVariant(fWFKey, z11);
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getDoubleVariant(fWFKey, d11);
    }

    @NotNull
    public final IExperimentDataSource getFwf$com_talabat_core_experiment_data_data() {
        return fwf;
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getIntVariant(fWFKey, i11);
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getStringVariant(fWFKey, str);
    }

    @VisibleForTesting
    public final void resetExperimentDataSource() {
        apptimize = new ApptimizeExperimentDataSource((ApptimizeSdkWrapper) null, 1, (DefaultConstructorMarker) null);
        fwf = new FwfExperimentDataSource((IFunWithFlags) null, 1, (DefaultConstructorMarker) null);
    }

    public void setAttribute(@NotNull FWFAttributes fWFAttributes, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFAttributes, "attribute");
        Intrinsics.checkNotNullParameter(str, "attributeValue");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).setAttribute(fWFAttributes.getKey(), str);
    }

    @VisibleForTesting
    public final void setExperimentDataSource(@NotNull IExperimentDataSource iExperimentDataSource) {
        Intrinsics.checkNotNullParameter(iExperimentDataSource, "experimentDataSource");
        apptimize = iExperimentDataSource;
        fwf = iExperimentDataSource;
    }

    @Nullable
    public Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Boolean> continuation) {
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getBooleanVariant(fWFKey, z11, z12, continuation);
    }

    @Nullable
    public Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Double> continuation) {
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getDoubleVariant(fWFKey, d11, z11, continuation);
    }

    @Nullable
    public Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Integer> continuation) {
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getIntVariant(fWFKey, i11, z11, continuation);
    }

    @Nullable
    public Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super String> continuation) {
        return getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getStringVariant(fWFKey, str, z11, continuation);
    }

    public void setAttribute(@NotNull FWFAttributes fWFAttributes, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fWFAttributes, "attribute");
        Intrinsics.checkNotNullParameter(str, "attributeValue");
        apptimize.setAttribute(fWFAttributes.getKey(), str);
        fwf.setAttribute(fWFAttributes.getKey(), str);
    }

    public void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Intrinsics.checkNotNullParameter(function1, "callback");
        getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getBooleanVariant(fWFKey, z11, z12, (Function1<? super Boolean, Unit>) new TalabatExperiment$getBooleanVariant$2(function1));
    }

    public void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Intrinsics.checkNotNullParameter(function1, "callback");
        getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getDoubleVariant(fWFKey, d11, z11, (Function1<? super Double, Unit>) new TalabatExperiment$getDoubleVariant$2(function1));
    }

    public void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Intrinsics.checkNotNullParameter(function1, "callback");
        getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getIntVariant(fWFKey, i11, z11, (Function1<? super Integer, Unit>) new TalabatExperiment$getIntVariant$2(function1));
    }

    public void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Intrinsics.checkNotNullParameter(function1, "callback");
        getExperimentDataSourceStrategy(talabatExperimentDataSourceStrategy).getStringVariant(fWFKey, str, z11, (Function1<? super String, Unit>) new TalabatExperiment$getStringVariant$2(function1));
    }
}
