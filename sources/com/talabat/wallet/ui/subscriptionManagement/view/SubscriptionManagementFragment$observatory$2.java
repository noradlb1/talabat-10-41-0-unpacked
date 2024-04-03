package com.talabat.wallet.ui.subscriptionManagement.view;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionManagementFragment$observatory$2 extends FunctionReferenceImpl implements Function1<WalletCardListDisplayModel, Unit> {
    public SubscriptionManagementFragment$observatory$2(Object obj) {
        super(1, obj, SubscriptionManagementFragment.class, "getWalletAddedCard", "getWalletAddedCard(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCardListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((SubscriptionManagementFragment) this.receiver).getWalletAddedCard(walletCardListDisplayModel);
    }
}
