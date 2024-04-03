package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletCardManagementFragment$onViewCreated$1 extends FunctionReferenceImpl implements Function1<WalletCardListDisplayModel, Unit> {
    public WalletCardManagementFragment$onViewCreated$1(Object obj) {
        super(1, obj, WalletCardManagementFragment.class, "updateWalletCardListAdapter", "updateWalletCardListAdapter(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCardListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((WalletCardManagementFragment) this.receiver).updateWalletCardListAdapter(walletCardListDisplayModel);
    }
}
