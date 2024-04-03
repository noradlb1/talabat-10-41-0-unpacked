package com.talabat.wallet.ui.walletTransactionDetail.view;

import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTransactionDetailFragment$onViewCreated$4 extends FunctionReferenceImpl implements Function1<WalletTransactionDetailHeaderDisplayModel, Unit> {
    public WalletTransactionDetailFragment$onViewCreated$4(Object obj) {
        super(1, obj, WalletTransactionDetailFragment.class, "updateTransactionDetailHeader", "updateTransactionDetailHeader(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionDetailHeaderDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        ((WalletTransactionDetailFragment) this.receiver).updateTransactionDetailHeader(walletTransactionDetailHeaderDisplayModel);
    }
}
