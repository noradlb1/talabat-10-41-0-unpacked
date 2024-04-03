package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpCardListFragment$observatory$1 extends FunctionReferenceImpl implements Function1<WalletCreditCardListDataItemWithTypeDisplayModel, Unit> {
    public WalletTopUpCardListFragment$observatory$1(Object obj) {
        super(1, obj, WalletTopUpCardListFragment.class, "updateView", "updateView(Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCreditCardListDataItemWithTypeDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCreditCardListDataItemWithTypeDisplayModel walletCreditCardListDataItemWithTypeDisplayModel) {
        ((WalletTopUpCardListFragment) this.receiver).updateView(walletCreditCardListDataItemWithTypeDisplayModel);
    }
}
