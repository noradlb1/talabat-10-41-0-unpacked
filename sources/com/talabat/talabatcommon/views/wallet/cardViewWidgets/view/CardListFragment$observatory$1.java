package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CardListFragment$observatory$1 extends FunctionReferenceImpl implements Function1<WalletCardListDisplayModel, Unit> {
    public CardListFragment$observatory$1(Object obj) {
        super(1, obj, CardListFragment.class, WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST, "updateCardList(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCardListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((CardListFragment) this.receiver).updateCardList(walletCardListDisplayModel);
    }
}
