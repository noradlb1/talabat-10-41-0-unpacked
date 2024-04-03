package com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel.mapper;

import com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus;
import com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel.CheckoutBinVoucherState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/presentation/viewmodel/mapper/CheckoutBinVoucherMapper;", "", "()V", "mapToCheckoutBinVoucherState", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState;", "orderBinNumberVoucherStatus", "Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/OrderBinNumberVoucherStatus;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutBinVoucherMapper {
    @NotNull
    public static final CheckoutBinVoucherMapper INSTANCE = new CheckoutBinVoucherMapper();

    private CheckoutBinVoucherMapper() {
    }

    @NotNull
    public final CheckoutBinVoucherState mapToCheckoutBinVoucherState(@NotNull OrderBinNumberVoucherStatus orderBinNumberVoucherStatus) {
        Intrinsics.checkNotNullParameter(orderBinNumberVoucherStatus, "orderBinNumberVoucherStatus");
        if (!orderBinNumberVoucherStatus.isEligibleForDiscount() || orderBinNumberVoucherStatus.getBinRequest() == null) {
            return CheckoutBinVoucherState.HideBinView.INSTANCE;
        }
        return new CheckoutBinVoucherState.FetchDiscountedCartPrice(orderBinNumberVoucherStatus.getBinRequest());
    }
}
