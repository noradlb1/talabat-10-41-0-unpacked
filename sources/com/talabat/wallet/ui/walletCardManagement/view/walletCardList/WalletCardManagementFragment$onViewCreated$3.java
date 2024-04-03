package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletDeleteCardDisplayModelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletCardManagementFragment$onViewCreated$3 extends FunctionReferenceImpl implements Function1<WalletDeleteCardDisplayModelState, Unit> {
    public WalletCardManagementFragment$onViewCreated$3(Object obj) {
        super(1, obj, WalletCardManagementFragment.class, "updateAdapterOnDelete", "updateAdapterOnDelete(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletDeleteCardDisplayModelState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletDeleteCardDisplayModelState walletDeleteCardDisplayModelState) {
        ((WalletCardManagementFragment) this.receiver).updateAdapterOnDelete(walletDeleteCardDisplayModelState);
    }
}
