package com.talabat.wallet.ui.walletTransactionDetail.view;

import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDisplayModelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTransactionDetailFragment$onViewCreated$3 extends FunctionReferenceImpl implements Function1<WalletTransactionDisplayModelState, Unit> {
    public WalletTransactionDetailFragment$onViewCreated$3(Object obj) {
        super(1, obj, WalletTransactionDetailFragment.class, "updateTransactionDetailBody", "updateTransactionDetailBody(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionDisplayModelState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTransactionDisplayModelState walletTransactionDisplayModelState) {
        ((WalletTransactionDetailFragment) this.receiver).updateTransactionDetailBody(walletTransactionDisplayModelState);
    }
}
