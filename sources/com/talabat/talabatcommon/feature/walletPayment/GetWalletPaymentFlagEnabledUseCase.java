package com.talabat.talabatcommon.feature.walletPayment;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/GetWalletPaymentFlagEnabledUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getSelectedCountryId", "Lkotlin/Function0;", "", "Lcom/talabat/talabatcommon/feature/walletCardManagement/di/module/SelectedCountryIdProvider;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function0;)V", "invoke", "", "flagName", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentFlagEnabledUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final Function0<Integer> getSelectedCountryId;

    public GetWalletPaymentFlagEnabledUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(function0, "getSelectedCountryId");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.getSelectedCountryId = function0;
    }

    public final boolean invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        return this.featureFlagRepo.getFeatureFlag(PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(this.getSelectedCountryId.invoke(), str), false);
    }
}
