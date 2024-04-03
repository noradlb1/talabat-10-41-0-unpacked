package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "", "paymentMethod", "", "cardType", "", "card4Digits", "(ILjava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardType", "setCardType", "getPaymentMethod", "()I", "setPaymentMethod", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentWalletTransactionDisplayModel {
    @NotNull
    @ModelMapping({"card4Digits"})
    private String card4Digits;
    @NotNull
    @ModelMapping({"cardType"})
    private String cardType;
    @ModelMapping({"paymentMethod"})
    private int paymentMethod;

    public PaymentWalletTransactionDisplayModel() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public PaymentWalletTransactionDisplayModel(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "cardType");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        this.paymentMethod = i11;
        this.cardType = str;
        this.card4Digits = str2;
    }

    public static /* synthetic */ PaymentWalletTransactionDisplayModel copy$default(PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = paymentWalletTransactionDisplayModel.paymentMethod;
        }
        if ((i12 & 2) != 0) {
            str = paymentWalletTransactionDisplayModel.cardType;
        }
        if ((i12 & 4) != 0) {
            str2 = paymentWalletTransactionDisplayModel.card4Digits;
        }
        return paymentWalletTransactionDisplayModel.copy(i11, str, str2);
    }

    public final int component1() {
        return this.paymentMethod;
    }

    @NotNull
    public final String component2() {
        return this.cardType;
    }

    @NotNull
    public final String component3() {
        return this.card4Digits;
    }

    @NotNull
    public final PaymentWalletTransactionDisplayModel copy(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "cardType");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        return new PaymentWalletTransactionDisplayModel(i11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentWalletTransactionDisplayModel)) {
            return false;
        }
        PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = (PaymentWalletTransactionDisplayModel) obj;
        return this.paymentMethod == paymentWalletTransactionDisplayModel.paymentMethod && Intrinsics.areEqual((Object) this.cardType, (Object) paymentWalletTransactionDisplayModel.cardType) && Intrinsics.areEqual((Object) this.card4Digits, (Object) paymentWalletTransactionDisplayModel.card4Digits);
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    public int hashCode() {
        return (((this.paymentMethod * 31) + this.cardType.hashCode()) * 31) + this.card4Digits.hashCode();
    }

    public final void setCard4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.card4Digits = str;
    }

    public final void setCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardType = str;
    }

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.paymentMethod;
        String str = this.cardType;
        String str2 = this.card4Digits;
        return "PaymentWalletTransactionDisplayModel(paymentMethod=" + i11 + ", cardType=" + str + ", card4Digits=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentWalletTransactionDisplayModel(int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i12 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2);
    }
}
