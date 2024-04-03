package com.talabat.wallet.ui.walletDashboard.model;

import com.talabat.wallet.ui.walletDashboard.model.OnboardingType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletOnboardingDisplayModel;", "", "()V", "onboardingType", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "getOnboardingType", "()Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "setOnboardingType", "(Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletOnboardingDisplayModel {
    @NotNull
    private OnboardingType onboardingType = OnboardingType.None.INSTANCE;

    @NotNull
    public final OnboardingType getOnboardingType() {
        return this.onboardingType;
    }

    public final void setOnboardingType(@NotNull OnboardingType onboardingType2) {
        Intrinsics.checkNotNullParameter(onboardingType2, "<set-?>");
        this.onboardingType = onboardingType2;
    }
}
