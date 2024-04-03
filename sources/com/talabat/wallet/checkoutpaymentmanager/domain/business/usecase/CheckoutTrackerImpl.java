package com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.IAppTracker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J2\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/CheckoutTrackerImpl;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/CheckoutTracker;", "context", "Landroid/content/Context;", "appTracker", "Ltracking/IAppTracker;", "(Landroid/content/Context;Ltracking/IAppTracker;)V", "isSavedCardsDeflection", "", "checkoutPaymentUpdateResult", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "onCheckoutLoaded", "", "cart", "Lbuisnessmodels/Cart;", "defaultPaymentMethod", "", "isKNetFallbackShown", "isHideBNPLPaymentMethod", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutTrackerImpl implements CheckoutTracker {
    @NotNull
    private final IAppTracker appTracker;
    @NotNull
    private final Context context;

    public CheckoutTrackerImpl(@NotNull Context context2, @NotNull IAppTracker iAppTracker) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iAppTracker, "appTracker");
        this.context = context2;
        this.appTracker = iAppTracker;
    }

    @VisibleForTesting
    public final boolean isSavedCardsDeflection(@NotNull CheckoutPaymentUpdateResult checkoutPaymentUpdateResult) {
        Intrinsics.checkNotNullParameter(checkoutPaymentUpdateResult, "checkoutPaymentUpdateResult");
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.BenefitBinsInfo) {
            if (!((CheckoutPaymentUpdateResult.BenefitBinsInfo) checkoutPaymentUpdateResult).getBins().isEmpty()) {
                return true;
            }
        } else if ((checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.QPayBinsInfo) && !((CheckoutPaymentUpdateResult.QPayBinsInfo) checkoutPaymentUpdateResult).getBins().isEmpty()) {
            return true;
        }
        return false;
    }

    public void onCheckoutLoaded(@Nullable Cart cart, @NotNull String str, boolean z11, boolean z12, @NotNull CheckoutPaymentUpdateResult checkoutPaymentUpdateResult) {
        Intrinsics.checkNotNullParameter(str, "defaultPaymentMethod");
        Intrinsics.checkNotNullParameter(checkoutPaymentUpdateResult, "checkoutPaymentUpdateResult");
        if (cart != null) {
            this.appTracker.onPushBeginCheckoutEvent(this.context, cart, str, Boolean.valueOf(z11), Boolean.valueOf(z12), Boolean.valueOf(isSavedCardsDeflection(checkoutPaymentUpdateResult)));
        }
    }
}
