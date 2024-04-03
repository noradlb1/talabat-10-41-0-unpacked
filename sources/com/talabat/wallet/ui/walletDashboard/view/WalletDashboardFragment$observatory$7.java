package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$7 extends FunctionReferenceImpl implements Function1<WalletOnboardingDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$7(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "showOnBoarding", "showOnBoarding(Lcom/talabat/wallet/ui/walletDashboard/model/WalletOnboardingDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletOnboardingDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletOnboardingDisplayModel walletOnboardingDisplayModel) {
        ((WalletDashboardFragment) this.receiver).showOnBoarding(walletOnboardingDisplayModel);
    }
}
