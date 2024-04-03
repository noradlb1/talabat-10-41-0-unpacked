package com.talabat.wallet.ui.walletTransactionDetail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;", "", "paymentDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "restaurantDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;", "refundDisplay", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;", "headerInfo", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getHeaderInfo", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "setHeaderInfo", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getPaymentDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "setPaymentDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;)V", "getRefundDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;", "setRefundDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;)V", "getRestaurantDisplay", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;", "setRestaurantDisplay", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefundWalletTransactionTypeDisplayModel {
    @NotNull
    private WalletTransactionDetailHeaderDisplayModel headerInfo;
    @NotNull
    private PaymentWalletTransactionDisplayModel paymentDisplay;
    @NotNull
    private RefundWalletTransactionDisplayModel refundDisplay;
    @NotNull
    private RestaurantWalletTransactionDisplayModel restaurantDisplay;

    public RefundWalletTransactionTypeDisplayModel() {
        this((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, (WalletTransactionDetailHeaderDisplayModel) null, 15, (DefaultConstructorMarker) null);
    }

    public RefundWalletTransactionTypeDisplayModel(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, @NotNull RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, @NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "paymentDisplay");
        Intrinsics.checkNotNullParameter(restaurantWalletTransactionDisplayModel, "restaurantDisplay");
        Intrinsics.checkNotNullParameter(refundWalletTransactionDisplayModel, "refundDisplay");
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        this.paymentDisplay = paymentWalletTransactionDisplayModel;
        this.restaurantDisplay = restaurantWalletTransactionDisplayModel;
        this.refundDisplay = refundWalletTransactionDisplayModel;
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
    }

    public static /* synthetic */ RefundWalletTransactionTypeDisplayModel copy$default(RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel, PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentWalletTransactionDisplayModel = refundWalletTransactionTypeDisplayModel.paymentDisplay;
        }
        if ((i11 & 2) != 0) {
            restaurantWalletTransactionDisplayModel = refundWalletTransactionTypeDisplayModel.restaurantDisplay;
        }
        if ((i11 & 4) != 0) {
            refundWalletTransactionDisplayModel = refundWalletTransactionTypeDisplayModel.refundDisplay;
        }
        if ((i11 & 8) != 0) {
            walletTransactionDetailHeaderDisplayModel = refundWalletTransactionTypeDisplayModel.headerInfo;
        }
        return refundWalletTransactionTypeDisplayModel.copy(paymentWalletTransactionDisplayModel, restaurantWalletTransactionDisplayModel, refundWalletTransactionDisplayModel, walletTransactionDetailHeaderDisplayModel);
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
    public final WalletTransactionDetailHeaderDisplayModel component4() {
        return this.headerInfo;
    }

    @NotNull
    public final RefundWalletTransactionTypeDisplayModel copy(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, @NotNull RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, @NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "paymentDisplay");
        Intrinsics.checkNotNullParameter(restaurantWalletTransactionDisplayModel, "restaurantDisplay");
        Intrinsics.checkNotNullParameter(refundWalletTransactionDisplayModel, "refundDisplay");
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        return new RefundWalletTransactionTypeDisplayModel(paymentWalletTransactionDisplayModel, restaurantWalletTransactionDisplayModel, refundWalletTransactionDisplayModel, walletTransactionDetailHeaderDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefundWalletTransactionTypeDisplayModel)) {
            return false;
        }
        RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel = (RefundWalletTransactionTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.paymentDisplay, (Object) refundWalletTransactionTypeDisplayModel.paymentDisplay) && Intrinsics.areEqual((Object) this.restaurantDisplay, (Object) refundWalletTransactionTypeDisplayModel.restaurantDisplay) && Intrinsics.areEqual((Object) this.refundDisplay, (Object) refundWalletTransactionTypeDisplayModel.refundDisplay) && Intrinsics.areEqual((Object) this.headerInfo, (Object) refundWalletTransactionTypeDisplayModel.headerInfo);
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel getHeaderInfo() {
        return this.headerInfo;
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
        return (((((this.paymentDisplay.hashCode() * 31) + this.restaurantDisplay.hashCode()) * 31) + this.refundDisplay.hashCode()) * 31) + this.headerInfo.hashCode();
    }

    public final void setHeaderInfo(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "<set-?>");
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
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
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.headerInfo;
        return "RefundWalletTransactionTypeDisplayModel(paymentDisplay=" + paymentWalletTransactionDisplayModel + ", restaurantDisplay=" + restaurantWalletTransactionDisplayModel + ", refundDisplay=" + refundWalletTransactionDisplayModel + ", headerInfo=" + walletTransactionDetailHeaderDisplayModel + ")";
    }

    public /* synthetic */ RefundWalletTransactionTypeDisplayModel(PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel;
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel2;
        PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel2 = (i11 & 1) != 0 ? new PaymentWalletTransactionDisplayModel(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : paymentWalletTransactionDisplayModel;
        RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel2 = (i11 & 2) != 0 ? new RestaurantWalletTransactionDisplayModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : restaurantWalletTransactionDisplayModel;
        RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel2 = (i11 & 4) != 0 ? new RefundWalletTransactionDisplayModel((String) null, 0, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null) : refundWalletTransactionDisplayModel;
        if ((i11 & 8) != 0) {
            walletTransactionDetailHeaderDisplayModel2 = new WalletTransactionDetailHeaderDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null);
            refundWalletTransactionTypeDisplayModel = this;
        } else {
            refundWalletTransactionTypeDisplayModel = this;
            walletTransactionDetailHeaderDisplayModel2 = walletTransactionDetailHeaderDisplayModel;
        }
        new RefundWalletTransactionTypeDisplayModel(paymentWalletTransactionDisplayModel2, restaurantWalletTransactionDisplayModel2, refundWalletTransactionDisplayModel2, walletTransactionDetailHeaderDisplayModel2);
    }
}
