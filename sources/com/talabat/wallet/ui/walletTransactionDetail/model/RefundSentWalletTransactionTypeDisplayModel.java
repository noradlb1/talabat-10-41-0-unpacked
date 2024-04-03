package com.talabat.wallet.ui.walletTransactionDetail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;", "", "paymentDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "restaurantDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;", "refundDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;)V", "getPaymentDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "setPaymentDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;)V", "getRefundDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;", "setRefundDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;)V", "getRestaurantDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;", "setRestaurantDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefundSentWalletTransactionTypeDisplayModel {
    @NotNull
    private PaymentWalletTransactionDisplayModel paymentDisplay;
    @NotNull
    private RefundWalletTransactionDisplayModel refundDisplay;
    @NotNull
    private RestaurantWalletTransactionDisplayModel restaurantDisplay;

    public RefundSentWalletTransactionTypeDisplayModel() {
        this((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, 7, (DefaultConstructorMarker) null);
    }

    public RefundSentWalletTransactionTypeDisplayModel(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, @NotNull RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "paymentDisplay");
        Intrinsics.checkNotNullParameter(restaurantWalletTransactionDisplayModel, "restaurantDisplay");
        Intrinsics.checkNotNullParameter(refundWalletTransactionDisplayModel, "refundDisplay");
        this.paymentDisplay = paymentWalletTransactionDisplayModel;
        this.restaurantDisplay = restaurantWalletTransactionDisplayModel;
        this.refundDisplay = refundWalletTransactionDisplayModel;
    }

    public static /* synthetic */ RefundSentWalletTransactionTypeDisplayModel copy$default(RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel, PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentWalletTransactionDisplayModel = refundSentWalletTransactionTypeDisplayModel.paymentDisplay;
        }
        if ((i11 & 2) != 0) {
            restaurantWalletTransactionDisplayModel = refundSentWalletTransactionTypeDisplayModel.restaurantDisplay;
        }
        if ((i11 & 4) != 0) {
            refundWalletTransactionDisplayModel = refundSentWalletTransactionTypeDisplayModel.refundDisplay;
        }
        return refundSentWalletTransactionTypeDisplayModel.copy(paymentWalletTransactionDisplayModel, restaurantWalletTransactionDisplayModel, refundWalletTransactionDisplayModel);
    }

    @NotNull
    public final PaymentWalletTransactionDisplayModel component1() {
        return this.paymentDisplay;
    }

    @NotNull
    public final RestaurantWalletTransactionDisplayModel component2() {
        return this.restaurantDisplay;
    }

    @NotNull
    public final RefundWalletTransactionDisplayModel component3() {
        return this.refundDisplay;
    }

    @NotNull
    public final RefundSentWalletTransactionTypeDisplayModel copy(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, @NotNull RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "paymentDisplay");
        Intrinsics.checkNotNullParameter(restaurantWalletTransactionDisplayModel, "restaurantDisplay");
        Intrinsics.checkNotNullParameter(refundWalletTransactionDisplayModel, "refundDisplay");
        return new RefundSentWalletTransactionTypeDisplayModel(paymentWalletTransactionDisplayModel, restaurantWalletTransactionDisplayModel, refundWalletTransactionDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefundSentWalletTransactionTypeDisplayModel)) {
            return false;
        }
        RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel = (RefundSentWalletTransactionTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.paymentDisplay, (Object) refundSentWalletTransactionTypeDisplayModel.paymentDisplay) && Intrinsics.areEqual((Object) this.restaurantDisplay, (Object) refundSentWalletTransactionTypeDisplayModel.restaurantDisplay) && Intrinsics.areEqual((Object) this.refundDisplay, (Object) refundSentWalletTransactionTypeDisplayModel.refundDisplay);
    }

    @NotNull
    public final PaymentWalletTransactionDisplayModel getPaymentDisplay() {
        return this.paymentDisplay;
    }

    @NotNull
    public final RefundWalletTransactionDisplayModel getRefundDisplay() {
        return this.refundDisplay;
    }

    @NotNull
    public final RestaurantWalletTransactionDisplayModel getRestaurantDisplay() {
        return this.restaurantDisplay;
    }

    public int hashCode() {
        return (((this.paymentDisplay.hashCode() * 31) + this.restaurantDisplay.hashCode()) * 31) + this.refundDisplay.hashCode();
    }

    public final void setPaymentDisplay(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "<set-?>");
        this.paymentDisplay = paymentWalletTransactionDisplayModel;
    }

    public final void setRefundDisplay(@NotNull RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(refundWalletTransactionDisplayModel, "<set-?>");
        this.refundDisplay = refundWalletTransactionDisplayModel;
    }

    public final void setRestaurantDisplay(@NotNull RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(restaurantWalletTransactionDisplayModel, "<set-?>");
        this.restaurantDisplay = restaurantWalletTransactionDisplayModel;
    }

    @NotNull
    public String toString() {
        PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = this.paymentDisplay;
        RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel = this.restaurantDisplay;
        RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel = this.refundDisplay;
        return "RefundSentWalletTransactionTypeDisplayModel(paymentDisplay=" + paymentWalletTransactionDisplayModel + ", restaurantDisplay=" + restaurantWalletTransactionDisplayModel + ", refundDisplay=" + refundWalletTransactionDisplayModel + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RefundSentWalletTransactionTypeDisplayModel(PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new PaymentWalletTransactionDisplayModel(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : paymentWalletTransactionDisplayModel, (i11 & 2) != 0 ? new RestaurantWalletTransactionDisplayModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : restaurantWalletTransactionDisplayModel, (i11 & 4) != 0 ? new RefundWalletTransactionDisplayModel((String) null, 0, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null) : refundWalletTransactionDisplayModel);
    }
}
