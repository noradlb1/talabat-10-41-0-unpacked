package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletSetDefaultCardDisplayModelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletCardManagementFragment$onViewCreated$4 extends FunctionReferenceImpl implements Function1<WalletSetDefaultCardDisplayModelState, Unit> {
    public WalletCardManagementFragment$onViewCreated$4(Object obj) {
        super(1, obj, WalletCardManagementFragment.class, "updateAdapterOnSetDefaultCard", "updateAdapterOnSetDefaultCard(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletSetDefaultCardDisplayModelState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletSetDefaultCardDisplayModelState walletSetDefaultCardDisplayModelState) {
        ((WalletCardManagementFragment) this.receiver).updateAdapterOnSetDefaultCard(walletSetDefaultCardDisplayModelState);
    }
}
