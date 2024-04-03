package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$1 extends FunctionReferenceImpl implements Function1<WalletBalanceDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$1(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "updateWalletBalance", "updateWalletBalance(Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletBalanceDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletBalanceDisplayModel walletBalanceDisplayModel) {
        ((WalletDashboardFragment) this.receiver).updateWalletBalance(walletBalanceDisplayModel);
    }
}
