package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailPaymentViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionRefundView$paymentViewModel$2 extends Lambda implements Function0<WalletTransactionDetailPaymentViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionRefundView f12836g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionRefundView$paymentViewModel$2(WalletTransactionRefundView walletTransactionRefundView) {
        super(0);
        this.f12836g = walletTransactionRefundView;
    }

    @NotNull
    public final WalletTransactionDetailPaymentViewModel invoke() {
        return this.f12836g.setupPaymentViewModel();
    }
}
