package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$initializeRecyclerView$1$1 extends FunctionReferenceImpl implements Function1<WalletTransactionListDataItemDisplayModel.TransactionDisplayModel, Unit> {
    public WalletDashboardFragment$initializeRecyclerView$1$1(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "transactionItemClicked", "transactionItemClicked(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "p0");
        ((WalletDashboardFragment) this.receiver).transactionItemClicked(transactionDisplayModel);
    }
}
