package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.transactionslistheader.TransactionsListHeaderDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$2 extends FunctionReferenceImpl implements Function1<TransactionsListHeaderDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$2(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "updateTransactionsListHeader", "updateTransactionsListHeader(Lcom/talabat/wallet/ui/transactionslistheader/TransactionsListHeaderDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TransactionsListHeaderDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable TransactionsListHeaderDisplayModel transactionsListHeaderDisplayModel) {
        ((WalletDashboardFragment) this.receiver).updateTransactionsListHeader(transactionsListHeaderDisplayModel);
    }
}
