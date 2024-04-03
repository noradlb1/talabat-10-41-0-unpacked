package com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel;

import JsonModels.Request.BIN.BinRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState;", "", "()V", "FetchDiscountedCartPrice", "HideBinView", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState$HideBinView;", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState$FetchDiscountedCartPrice;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CheckoutBinVoucherState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState$FetchDiscountedCartPrice;", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState;", "binRequest", "LJsonModels/Request/BIN/BinRequest;", "(LJsonModels/Request/BIN/BinRequest;)V", "getBinRequest", "()LJsonModels/Request/BIN/BinRequest;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FetchDiscountedCartPrice extends CheckoutBinVoucherState {
        @NotNull
        private final BinRequest binRequest;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FetchDiscountedCartPrice(@NotNull BinRequest binRequest2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(binRequest2, "binRequest");
            this.binRequest = binRequest2;
        }

        @NotNull
        public final BinRequest getBinRequest() {
            return this.binRequest;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState$HideBinView;", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideBinView extends CheckoutBinVoucherState {
        @NotNull
        public static final HideBinView INSTANCE = new HideBinView();

        private HideBinView() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CheckoutBinVoucherState() {
    }

    public /* synthetic */ CheckoutBinVoucherState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
