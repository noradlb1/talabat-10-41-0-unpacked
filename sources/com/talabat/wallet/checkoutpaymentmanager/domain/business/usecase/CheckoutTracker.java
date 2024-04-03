package com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase;

import buisnessmodels.Cart;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/CheckoutTracker;", "", "onCheckoutLoaded", "", "cart", "Lbuisnessmodels/Cart;", "defaultPaymentMethod", "", "isKNetFallbackShown", "", "isHideBNPLPaymentMethod", "checkoutPaymentUpdateResult", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CheckoutTracker {
    void onCheckoutLoaded(@Nullable Cart cart, @NotNull String str, boolean z11, boolean z12, @NotNull CheckoutPaymentUpdateResult checkoutPaymentUpdateResult);
}
