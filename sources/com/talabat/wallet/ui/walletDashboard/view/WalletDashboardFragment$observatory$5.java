package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$5 extends FunctionReferenceImpl implements Function1<WalletDashBoardIconsDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$5(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "showEnabledIcons", "showEnabledIcons(Lcom/talabat/wallet/ui/walletDashboard/model/WalletDashBoardIconsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletDashBoardIconsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletDashBoardIconsDisplayModel walletDashBoardIconsDisplayModel) {
        ((WalletDashboardFragment) this.receiver).showEnabledIcons(walletDashBoardIconsDisplayModel);
    }
}
