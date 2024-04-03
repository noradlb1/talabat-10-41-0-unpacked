package com.talabat.wallet.ui.walletTransactionDetail.view;

import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTransactionDetailFragment$factory$1 extends FunctionReferenceImpl implements Function0<WalletTransactionDetailViewModelImpl> {
    public WalletTransactionDetailFragment$factory$1(Object obj) {
        super(0, obj, WalletTransactionDetailFragment.class, "viewModelBuilder", "viewModelBuilder()Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelImpl;", 0);
    }

    @NotNull
    public final WalletTransactionDetailViewModelImpl invoke() {
        return ((WalletTransactionDetailFragment) this.receiver).viewModelBuilder();
    }
}
