package com.talabat.wallet.features.walletTransactionList;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/IsFlutterTopUpScreenEnabledUseCase;", "", "talabatFeatureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsFlutterTopUpScreenEnabledUseCase {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlagRepo;

    public IsFlutterTopUpScreenEnabledUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlagRepo");
        this.talabatFeatureFlagRepo = iTalabatFeatureFlag;
    }

    public final boolean invoke() {
        return this.talabatFeatureFlagRepo.getFeatureFlag(EcosystemsFeatureFlagsKeys.IS_TOP_UP_FLUTTER_ENABLED, false);
    }
}
