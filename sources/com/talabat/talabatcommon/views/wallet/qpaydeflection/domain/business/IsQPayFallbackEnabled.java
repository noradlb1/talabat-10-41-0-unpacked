package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayFallbackEnabled;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsQPayFallbackEnabled {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;

    public IsQPayFallbackEnabled(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return this.featureFlagRepo.getFeatureFlag((FWFKey) PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_FALLBACK_ENABLED, false, false, continuation);
    }
}
