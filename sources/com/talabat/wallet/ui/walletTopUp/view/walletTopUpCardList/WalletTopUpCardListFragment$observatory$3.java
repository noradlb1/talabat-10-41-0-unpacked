package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpCardListFragment$observatory$3 extends FunctionReferenceImpl implements Function1<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, Unit> {
    public WalletTopUpCardListFragment$observatory$3(Object obj) {
        super(1, obj, WalletTopUpCardListFragment.class, "updateAdapterCell", "updateAdapterCell(Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        ((WalletTopUpCardListFragment) this.receiver).updateAdapterCell(walletCardAdapterDisplayModel);
    }
}
