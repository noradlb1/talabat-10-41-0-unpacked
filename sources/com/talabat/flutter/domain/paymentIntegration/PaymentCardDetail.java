package com.talabat.flutter.domain.paymentIntegration;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/flutter/domain/paymentIntegration/PaymentCardDetail;", "", "paymentMethod", "", "cardTokenId", "", "card4Digits", "cardType", "cardExpiryDate", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "getCardExpiryDate", "getCardTokenId", "getCardType", "getPaymentMethod", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentCardDetail {
    @NotNull
    private final String card4Digits;
    @NotNull
    private final String cardExpiryDate;
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String cardType;
    private final int paymentMethod;

    public PaymentCardDetail(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        this.paymentMethod = i11;
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.cardExpiryDate = str4;
    }

    public static /* synthetic */ PaymentCardDetail copy$default(PaymentCardDetail paymentCardDetail, int i11, String str, String str2, String str3, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = paymentCardDetail.paymentMethod;
        }
        if ((i12 & 2) != 0) {
            str = paymentCardDetail.cardTokenId;
        }
        String str5 = str;
        if ((i12 & 4) != 0) {
            str2 = paymentCardDetail.card4Digits;
        }
        String str6 = str2;
        if ((i12 & 8) != 0) {
            str3 = paymentCardDetail.cardType;
        }
        String str7 = str3;
        if ((i12 & 16) != 0) {
            str4 = paymentCardDetail.cardExpiryDate;
        }
        return paymentCardDetail.copy(i11, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.paymentMethod;
    }

    @NotNull
    public final String component2() {
        return this.cardTokenId;
    }

    @NotNull
    public final String component3() {
        return this.card4Digits;
    }

    @NotNull
    public final String component4() {
        return this.cardType;
    }

    @NotNull
    public final String component5() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final PaymentCardDetail copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        return new PaymentCardDetail(i11, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentCardDetail)) {
            return false;
        }
        PaymentCardDetail paymentCardDetail = (PaymentCardDetail) obj;
        return this.paymentMethod == paymentCardDetail.paymentMethod && Intrinsics.areEqual((Object) this.cardTokenId, (Object) paymentCardDetail.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) paymentCardDetail.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) paymentCardDetail.cardType) && Intrinsics.areEqual((Object) this.cardExpiryDate, (Object) paymentCardDetail.cardExpiryDate);
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    public int hashCode() {
        return (((((((this.paymentMethod * 31) + this.cardTokenId.hashCode()) * 31) + this.card4Digits.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.cardExpiryDate.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.paymentMethod;
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        String str4 = this.cardExpiryDate;
        return "PaymentCardDetail(paymentMethod=" + i11 + ", cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", cardExpiryDate=" + str4 + ")";
    }
}
