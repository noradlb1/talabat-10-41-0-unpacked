package com.talabat.core.experiment.data.datasource;

import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ4\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0016J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J4\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0016J)\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J4\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0016H\u0016J)\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J4\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/experiment/data/datasource/FwfExperimentDataSource;", "Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "funWithFlags", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "(Lcom/talabat/core/fwf/domain/IFunWithFlags;)V", "getBooleanVariant", "", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "getDoubleVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;DZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStringVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAttribute", "attributeKey", "attributeValue", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FwfExperimentDataSource implements IExperimentDataSource {
    @NotNull
    private final IFunWithFlags funWithFlags;

    public FwfExperimentDataSource() {
        this((IFunWithFlags) null, 1, (DefaultConstructorMarker) null);
    }

    public FwfExperimentDataSource(@NotNull IFunWithFlags iFunWithFlags) {
        Intrinsics.checkNotNullParameter(iFunWithFlags, "funWithFlags");
        this.funWithFlags = iFunWithFlags;
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Object variation = this.funWithFlags.getVariation(fWFKey, Boolean.valueOf(z11));
        Boolean bool = variation instanceof Boolean ? (Boolean) variation : null;
        return bool != null ? bool.booleanValue() : z11;
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return d11;
    }

    public void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(Double.valueOf(d11));
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Object variation = this.funWithFlags.getVariation(fWFKey, Integer.valueOf(i11));
        Integer num = variation instanceof Integer ? (Integer) variation : null;
        return num != null ? num.intValue() : i11;
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Object variation = this.funWithFlags.getVariation(fWFKey, str);
        String str2 = variation instanceof String ? (String) variation : null;
        return str2 == null ? str : str2;
    }

    public void setAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attributeKey");
        Intrinsics.checkNotNullParameter(str2, "attributeValue");
        FunWithFlags.setAttribute(str, str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FwfExperimentDataSource(IFunWithFlags iFunWithFlags, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? FunWithFlags.INSTANCE : iFunWithFlags);
    }

    @Nullable
    public Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        safeContinuation.resumeWith(Result.m6329constructorimpl(Boxing.boxDouble(d11)));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.funWithFlags.getVariation(fWFKey, str, z11, new FwfExperimentDataSource$getStringVariant$1(function1, str));
    }

    @Nullable
    public Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.funWithFlags.getVariation(fWFKey, str, z11, new FwfExperimentDataSource$getStringVariant$3$1(safeContinuation, str));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.funWithFlags.getVariation(fWFKey, Boolean.valueOf(z11), z12, new FwfExperimentDataSource$getBooleanVariant$1(function1, z11));
    }

    public void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.funWithFlags.getVariation(fWFKey, Integer.valueOf(i11), z11, new FwfExperimentDataSource$getIntVariant$1(function1, i11));
    }

    @Nullable
    public Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.funWithFlags.getVariation(fWFKey, Boxing.boxBoolean(z11), z12, new FwfExperimentDataSource$getBooleanVariant$3$1(safeContinuation, z11));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.funWithFlags.getVariation(fWFKey, Boxing.boxInt(i11), z11, new FwfExperimentDataSource$getIntVariant$3$1(safeContinuation, i11));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
