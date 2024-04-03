package com.talabat.wallet.features.walletTransactionDetail.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;", "", "paymentMethod", "", "cardType", "", "card4Digits", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "getCardType", "getPaymentMethod", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailPaymentModel {
    @SerializedName("card4Digits")
    @Nullable
    private final String card4Digits;
    @SerializedName("cardType")
    @Nullable
    private final String cardType;
    @SerializedName("paymentMethod")
    @Nullable
    private final Integer paymentMethod;

    public WalletTransactionDetailPaymentModel(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.paymentMethod = num;
        this.cardType = str;
        this.card4Digits = str2;
    }

    public static /* synthetic */ WalletTransactionDetailPaymentModel copy$default(WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel, Integer num, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = walletTransactionDetailPaymentModel.paymentMethod;
        }
        if ((i11 & 2) != 0) {
            str = walletTransactionDetailPaymentModel.cardType;
        }
        if ((i11 & 4) != 0) {
            str2 = walletTransactionDetailPaymentModel.card4Digits;
        }
        return walletTransactionDetailPaymentModel.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.paymentMethod;
    }

    @Nullable
    public final String component2() {
        return this.cardType;
    }

    @Nullable
    public final String component3() {
        return this.card4Digits;
    }

    @NotNull
    public final WalletTransactionDetailPaymentModel copy(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        return new WalletTransactionDetailPaymentModel(num, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailPaymentModel)) {
            return false;
        }
        WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel = (WalletTransactionDetailPaymentModel) obj;
        return Intrinsics.areEqual((Object) this.paymentMethod, (Object) walletTransactionDetailPaymentModel.paymentMethod) && Intrinsics.areEqual((Object) this.cardType, (Object) walletTransactionDetailPaymentModel.cardType) && Intrinsics.areEqual((Object) this.card4Digits, (Object) walletTransactionDetailPaymentModel.card4Digits);
    }

    @Nullable
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final Integer getPaymentMethod() {
        return this.paymentMethod;
    }

    public int hashCode() {
        Integer num = this.paymentMethod;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.cardType;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.card4Digits;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.paymentMethod;
        String str = this.cardType;
        String str2 = this.card4Digits;
        return "WalletTransactionDetailPaymentModel(paymentMethod=" + num + ", cardType=" + str + ", card4Digits=" + str2 + ")";
    }
}
