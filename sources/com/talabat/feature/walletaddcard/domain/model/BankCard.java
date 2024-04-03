package com.talabat.feature.walletaddcard.domain.model;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/walletaddcard/domain/model/BankCard;", "", "cardNumber", "", "expiryDate", "cvv", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardNumber", "()Ljava/lang/String;", "getCvv", "getExpiryDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_wallet-add-card_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BankCard {
    @NotNull
    private final String cardNumber;
    @NotNull
    private final String cvv;
    @NotNull
    private final String expiryDate;

    public BankCard(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "expiryDate");
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_CVV_KEY);
        this.cardNumber = str;
        this.expiryDate = str2;
        this.cvv = str3;
    }

    public static /* synthetic */ BankCard copy$default(BankCard bankCard, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bankCard.cardNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = bankCard.expiryDate;
        }
        if ((i11 & 4) != 0) {
            str3 = bankCard.cvv;
        }
        return bankCard.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.cardNumber;
    }

    @NotNull
    public final String component2() {
        return this.expiryDate;
    }

    @NotNull
    public final String component3() {
        return this.cvv;
    }

    @NotNull
    public final BankCard copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "expiryDate");
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_CVV_KEY);
        return new BankCard(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankCard)) {
            return false;
        }
        BankCard bankCard = (BankCard) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) bankCard.cardNumber) && Intrinsics.areEqual((Object) this.expiryDate, (Object) bankCard.expiryDate) && Intrinsics.areEqual((Object) this.cvv, (Object) bankCard.cvv);
    }

    @NotNull
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @NotNull
    public final String getCvv() {
        return this.cvv;
    }

    @NotNull
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public int hashCode() {
        return (((this.cardNumber.hashCode() * 31) + this.expiryDate.hashCode()) * 31) + this.cvv.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        String str2 = this.expiryDate;
        String str3 = this.cvv;
        return "BankCard(cardNumber=" + str + ", expiryDate=" + str2 + ", cvv=" + str3 + ")";
    }
}
