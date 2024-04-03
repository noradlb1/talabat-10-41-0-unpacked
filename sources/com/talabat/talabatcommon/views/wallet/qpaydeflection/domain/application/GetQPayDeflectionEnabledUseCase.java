package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.application;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/application/GetQPayDeflectionEnabledUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "flag", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQPayDeflectionEnabledUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final FWFKey flag;

    public GetQPayDeflectionEnabledUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull FWFKey fWFKey) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(fWFKey, "flag");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.flag = fWFKey;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return this.featureFlagRepo.getFeatureFlag(this.flag, false, false, continuation);
    }
}
