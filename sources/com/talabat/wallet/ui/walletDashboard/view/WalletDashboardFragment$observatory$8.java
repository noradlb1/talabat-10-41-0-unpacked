package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionDetailsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletDashboardFragment$observatory$8 extends FunctionReferenceImpl implements Function1<WalletTransactionDetailsDisplayModel, Unit> {
    public WalletDashboardFragment$observatory$8(Object obj) {
        super(1, obj, WalletDashboardFragment.class, "showTransactionDetails", "showTransactionDetails(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionDetailsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionDetailsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTransactionDetailsDisplayModel walletTransactionDetailsDisplayModel) {
        ((WalletDashboardFragment) this.receiver).showTransactionDetails(walletTransactionDetailsDisplayModel);
    }
}
