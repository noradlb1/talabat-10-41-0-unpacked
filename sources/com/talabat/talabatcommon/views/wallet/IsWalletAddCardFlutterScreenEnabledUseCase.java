package com.talabat.talabatcommon.views.wallet;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;", "", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsWalletAddCardFlutterScreenEnabledUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    public IsWalletAddCardFlutterScreenEnabledUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public final boolean invoke() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_ANDROID_FLUTTER_WALLET_ADD_CARD_ENABLED, false, 2, (Object) null);
    }
}
