package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$3 extends FunctionReferenceImpl implements Function1<WalletTransactionListDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$3(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "updateWalletTransactionList", "updateWalletTransactionList(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTransactionListDisplayModel walletTransactionListDisplayModel) {
        ((WalletDashboardFragment) this.receiver).updateWalletTransactionList(walletTransactionListDisplayModel);
    }
}
