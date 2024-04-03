package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionDetailFragment$observatory$4 extends FunctionReferenceImpl implements Function1<WalletCardListDisplayModel, Unit> {
    public SubscriptionDetailFragment$observatory$4(Object obj) {
        super(1, obj, SubscriptionDetailFragment.class, "getWalletAddedCard", "getWalletAddedCard(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCardListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((SubscriptionDetailFragment) this.receiver).getWalletAddedCard(walletCardListDisplayModel);
    }
}
