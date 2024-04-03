package com.talabat.wallet.checkoutbinvoucher.domain.entity;

import JsonModels.Request.BIN.BinRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/OrderBinNumberVoucherStatus;", "", "isEligibleForDiscount", "", "binRequest", "LJsonModels/Request/BIN/BinRequest;", "(ZLJsonModels/Request/BIN/BinRequest;)V", "getBinRequest", "()LJsonModels/Request/BIN/BinRequest;", "()Z", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderBinNumberVoucherStatus {
    @Nullable
    private final BinRequest binRequest;
    private final boolean isEligibleForDiscount;

    public OrderBinNumberVoucherStatus(boolean z11, @Nullable BinRequest binRequest2) {
        this.isEligibleForDiscount = z11;
        this.binRequest = binRequest2;
    }

    @Nullable
    public final BinRequest getBinRequest() {
        return this.binRequest;
    }

    public final boolean isEligibleForDiscount() {
        return this.isEligibleForDiscount;
    }
}
