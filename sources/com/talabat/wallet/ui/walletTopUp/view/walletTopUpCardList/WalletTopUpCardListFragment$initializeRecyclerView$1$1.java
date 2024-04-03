package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpCardListFragment$initializeRecyclerView$1$1 extends FunctionReferenceImpl implements Function1<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, Unit> {
    public WalletTopUpCardListFragment$initializeRecyclerView$1$1(Object obj) {
        super(1, obj, WalletTopUpCardListFragment.class, "creditCardItemClicked", "creditCardItemClicked(Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "p0");
        ((WalletTopUpCardListFragment) this.receiver).creditCardItemClicked(walletCardAdapterDisplayModel);
    }
}
