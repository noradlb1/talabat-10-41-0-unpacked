package com.talabat.core.featureflag.data.datasource.impl;

import com.talabat.core.featureflag.data.datasource.IFeatureFlagDataSource;
import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ4\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/featureflag/data/datasource/impl/FwfFeatureFlagDataSource;", "Lcom/talabat/core/featureflag/data/datasource/IFeatureFlagDataSource;", "funWithFlags", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "(Lcom/talabat/core/fwf/domain/IFunWithFlags;)V", "getFeatureFlag", "", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "com_talabat_core_feature-flag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FwfFeatureFlagDataSource implements IFeatureFlagDataSource {
    @NotNull
    private final IFunWithFlags funWithFlags;

    @Inject
    public FwfFeatureFlagDataSource(@NotNull IFunWithFlags iFunWithFlags) {
        Intrinsics.checkNotNullParameter(iFunWithFlags, "funWithFlags");
        this.funWithFlags = iFunWithFlags;
    }

    @Nullable
    public Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.funWithFlags.getVariation(fWFKey, Boxing.boxBoolean(z11), z12, new FwfFeatureFlagDataSource$getFeatureFlag$2$1(safeContinuation, z11));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.funWithFlags.getVariation(fWFKey, Boolean.valueOf(z11), z12, new FwfFeatureFlagDataSource$getFeatureFlag$3(function1, z11));
    }

    public boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Object variation = this.funWithFlags.getVariation(fWFKey, Boolean.valueOf(z11));
        Boolean bool = variation instanceof Boolean ? (Boolean) variation : null;
        return bool != null ? bool.booleanValue() : z11;
    }
}
