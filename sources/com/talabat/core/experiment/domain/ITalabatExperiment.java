package com.talabat.core.experiment.domain;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ<\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J1\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J<\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00122\b\b\u0002\u0010\u0007\u001a\u00020\bH&J1\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J<\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\b\b\u0002\u0010\u0007\u001a\u00020\bH&J1\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J<\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "", "getBooleanVariant", "", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "strategy", "Lcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "getDoubleVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;DZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;IZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStringVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/String;ZLcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAttribute", "attribute", "Lcom/talabat/core/experiment/domain/FWFAttributes;", "attributeValue", "com_talabat_core_experiment_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITalabatExperiment {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static Object getBooleanVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Boolean> continuation) {
            return Boxing.boxBoolean(z11);
        }

        public static /* synthetic */ boolean getBooleanVariant$default(ITalabatExperiment iTalabatExperiment, FWFKey fWFKey, boolean z11, TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
                }
                return iTalabatExperiment.getBooleanVariant(fWFKey, z11, talabatExperimentDataSourceStrategy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanVariant");
        }

        @Nullable
        public static Object getDoubleVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Double> continuation) {
            return Boxing.boxDouble(d11);
        }

        public static /* synthetic */ double getDoubleVariant$default(ITalabatExperiment iTalabatExperiment, FWFKey fWFKey, double d11, TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
                }
                return iTalabatExperiment.getDoubleVariant(fWFKey, d11, talabatExperimentDataSourceStrategy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDoubleVariant");
        }

        @Nullable
        public static Object getIntVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Integer> continuation) {
            return Boxing.boxInt(i11);
        }

        public static /* synthetic */ int getIntVariant$default(ITalabatExperiment iTalabatExperiment, FWFKey fWFKey, int i11, TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 4) != 0) {
                    talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
                }
                return iTalabatExperiment.getIntVariant(fWFKey, i11, talabatExperimentDataSourceStrategy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntVariant");
        }

        @Nullable
        public static Object getStringVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super String> continuation) {
            return str;
        }

        public static void getStringVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(str, "defaultValue");
            Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(str);
        }

        public static /* synthetic */ String getStringVariant$default(ITalabatExperiment iTalabatExperiment, FWFKey fWFKey, String str, TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
                }
                return iTalabatExperiment.getStringVariant(fWFKey, str, talabatExperimentDataSourceStrategy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringVariant");
        }

        public static void setAttribute(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFAttributes fWFAttributes, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fWFAttributes, "attribute");
            Intrinsics.checkNotNullParameter(str, "attributeValue");
        }

        public static void setAttribute(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFAttributes fWFAttributes, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
            Intrinsics.checkNotNullParameter(fWFAttributes, "attribute");
            Intrinsics.checkNotNullParameter(str, "attributeValue");
            Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        }

        public static void getBooleanVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Boolean.valueOf(z11));
        }

        public static void getDoubleVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Double.valueOf(d11));
        }

        public static void getIntVariant(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Integer.valueOf(i11));
        }
    }

    @Nullable
    Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Boolean> continuation);

    void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Boolean, Unit> function1);

    boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy);

    double getDoubleVariant(@NotNull FWFKey fWFKey, double d11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy);

    @Nullable
    Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Double> continuation);

    void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Double, Unit> function1);

    int getIntVariant(@NotNull FWFKey fWFKey, int i11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy);

    @Nullable
    Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super Integer> continuation);

    void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super Integer, Unit> function1);

    @Nullable
    Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Continuation<? super String> continuation);

    @NotNull
    String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy);

    void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy, @NotNull Function1<? super String, Unit> function1);

    void setAttribute(@NotNull FWFAttributes fWFAttributes, @NotNull String str);

    void setAttribute(@NotNull FWFAttributes fWFAttributes, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy);
}
