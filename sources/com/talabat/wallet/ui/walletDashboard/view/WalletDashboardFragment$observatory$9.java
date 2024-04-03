package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletShowNextScreenDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$9 extends FunctionReferenceImpl implements Function1<WalletShowNextScreenDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$9(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "navigateToNextScreen", "navigateToNextScreen(Lcom/talabat/wallet/ui/walletDashboard/model/WalletShowNextScreenDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletShowNextScreenDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletShowNextScreenDisplayModel walletShowNextScreenDisplayModel) {
        ((WalletDashboardFragment) this.receiver).navigateToNextScreen(walletShowNextScreenDisplayModel);
    }
}
