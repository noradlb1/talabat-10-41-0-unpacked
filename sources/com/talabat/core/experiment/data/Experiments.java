package com.talabat.core.experiment.data;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001aC\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"withExperiment", "T", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "experimentSource", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)Ljava/lang/Object;", "withSafeExperiment", "logger", "Lkotlin/Function1;", "", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "com_talabat_core_experiment_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "Experiments")
public final class Experiments {
    @TalabatExperimentDsl
    @JvmOverloads
    public static final <T> T withExperiment(@NotNull FWFKey fWFKey, T t11) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return withExperiment$default(fWFKey, t11, (ITalabatExperiment) null, 4, (Object) null);
    }

    @TalabatExperimentDsl
    @JvmOverloads
    public static final <T> T withExperiment(@NotNull FWFKey fWFKey, T t11, @NotNull ITalabatExperiment iTalabatExperiment) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "experimentSource");
        if (t11 instanceof Double) {
            return Double.valueOf(ITalabatExperiment.DefaultImpls.getDoubleVariant$default(iTalabatExperiment, fWFKey, ((Number) t11).doubleValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null));
        } else if (t11 instanceof Integer) {
            return Integer.valueOf(ITalabatExperiment.DefaultImpls.getIntVariant$default(iTalabatExperiment, fWFKey, ((Number) t11).intValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null));
        } else if (t11 instanceof Boolean) {
            return Boolean.valueOf(ITalabatExperiment.DefaultImpls.getBooleanVariant$default(iTalabatExperiment, fWFKey, ((Boolean) t11).booleanValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null));
        } else if (t11 instanceof String) {
            return ITalabatExperiment.DefaultImpls.getStringVariant$default(iTalabatExperiment, fWFKey, (String) t11, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
        } else {
            throw new IllegalArgumentException("expected type not supported yet");
        }
    }

    public static /* synthetic */ Object withExperiment$default(FWFKey fWFKey, Object obj, ITalabatExperiment iTalabatExperiment, int i11, Object obj2) throws IllegalArgumentException {
        if ((i11 & 4) != 0) {
            iTalabatExperiment = TalabatExperiment.INSTANCE;
        }
        return withExperiment(fWFKey, obj, iTalabatExperiment);
    }

    @TalabatExperimentDsl
    @JvmOverloads
    public static final <T> T withSafeExperiment(@NotNull FWFKey fWFKey, T t11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return withSafeExperiment$default(fWFKey, t11, (ITalabatExperiment) null, (Function1) null, 12, (Object) null);
    }

    @TalabatExperimentDsl
    @JvmOverloads
    public static final <T> T withSafeExperiment(@NotNull FWFKey fWFKey, T t11, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "experimentSource");
        return withSafeExperiment$default(fWFKey, t11, iTalabatExperiment, (Function1) null, 8, (Object) null);
    }

    @TalabatExperimentDsl
    @JvmOverloads
    public static final <T> T withSafeExperiment(@NotNull FWFKey fWFKey, T t11, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull Function1<? super Throwable, Unit> function1) {
        T t12;
        T r82;
        T r83;
        T r84;
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "experimentSource");
        Intrinsics.checkNotNullParameter(function1, "logger");
        if (t11 instanceof Double) {
            try {
                Result.Companion companion = Result.Companion;
                t12 = Result.m6329constructorimpl(Double.valueOf(ITalabatExperiment.DefaultImpls.getDoubleVariant$default(iTalabatExperiment, fWFKey, ((Number) t11).doubleValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                t12 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r102 = Result.m6332exceptionOrNullimpl(t12);
            if (r102 != null) {
                function1.invoke(r102);
            }
            if (Result.m6335isFailureimpl(t12)) {
                return t11;
            }
        } else if (t11 instanceof Integer) {
            try {
                Result.Companion companion3 = Result.Companion;
                r84 = Result.m6329constructorimpl(Integer.valueOf(ITalabatExperiment.DefaultImpls.getIntVariant$default(iTalabatExperiment, fWFKey, ((Number) t11).intValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                r84 = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            Throwable r103 = Result.m6332exceptionOrNullimpl(t12);
            if (r103 != null) {
                function1.invoke(r103);
            }
            if (Result.m6335isFailureimpl(t12)) {
                return t11;
            }
        } else if (t11 instanceof Boolean) {
            try {
                Result.Companion companion5 = Result.Companion;
                r83 = Result.m6329constructorimpl(Boolean.valueOf(ITalabatExperiment.DefaultImpls.getBooleanVariant$default(iTalabatExperiment, fWFKey, ((Boolean) t11).booleanValue(), (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)));
            } catch (Throwable th4) {
                Result.Companion companion6 = Result.Companion;
                r83 = Result.m6329constructorimpl(ResultKt.createFailure(th4));
            }
            Throwable r104 = Result.m6332exceptionOrNullimpl(t12);
            if (r104 != null) {
                function1.invoke(r104);
            }
            if (Result.m6335isFailureimpl(t12)) {
                return t11;
            }
        } else if (t11 instanceof String) {
            try {
                Result.Companion companion7 = Result.Companion;
                r82 = Result.m6329constructorimpl(ITalabatExperiment.DefaultImpls.getStringVariant$default(iTalabatExperiment, fWFKey, (String) t11, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null));
            } catch (Throwable th5) {
                Result.Companion companion8 = Result.Companion;
                r82 = Result.m6329constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable r105 = Result.m6332exceptionOrNullimpl(t12);
            if (r105 != null) {
                function1.invoke(r105);
            }
            if (Result.m6335isFailureimpl(t12)) {
                return t11;
            }
        } else {
            function1.invoke(new IllegalArgumentException("expected type not supported yet"));
            return t11;
        }
        return t12;
    }

    public static /* synthetic */ Object withSafeExperiment$default(FWFKey fWFKey, Object obj, ITalabatExperiment iTalabatExperiment, Function1<Throwable, Unit> function1, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            iTalabatExperiment = TalabatExperiment.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            function1 = ExperimentIntegrationKt.getLogError();
        }
        return withSafeExperiment(fWFKey, obj, iTalabatExperiment, function1);
    }
}
