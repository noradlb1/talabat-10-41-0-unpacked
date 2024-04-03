package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionEmptyListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$4 extends FunctionReferenceImpl implements Function1<WalletTransactionEmptyListDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$4(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "showEmptyView", "showEmptyView(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionEmptyListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionEmptyListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTransactionEmptyListDisplayModel walletTransactionEmptyListDisplayModel) {
        ((WalletDashboardFragment) this.receiver).showEmptyView(walletTransactionEmptyListDisplayModel);
    }
}
