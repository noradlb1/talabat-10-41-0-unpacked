package com.talabat.feature.tokenization.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;", "", "cardNumber", "", "cardHolderName", "cardExpiryMonth", "cardExpiryYear", "cardCvv", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardCvv", "()Ljava/lang/String;", "getCardExpiryMonth", "getCardExpiryYear", "getCardHolderName", "getCardNumber", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizationCard {
    @NotNull
    private final String cardCvv;
    @NotNull
    private final String cardExpiryMonth;
    @NotNull
    private final String cardExpiryYear;
    @NotNull
    private final String cardHolderName;
    @NotNull
    private final String cardNumber;

    public TokenizationCard(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "cardHolderName");
        Intrinsics.checkNotNullParameter(str3, "cardExpiryMonth");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryYear");
        Intrinsics.checkNotNullParameter(str5, "cardCvv");
        this.cardNumber = str;
        this.cardHolderName = str2;
        this.cardExpiryMonth = str3;
        this.cardExpiryYear = str4;
        this.cardCvv = str5;
    }

    public static /* synthetic */ TokenizationCard copy$default(TokenizationCard tokenizationCard, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tokenizationCard.cardNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = tokenizationCard.cardHolderName;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = tokenizationCard.cardExpiryMonth;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = tokenizationCard.cardExpiryYear;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = tokenizationCard.cardCvv;
        }
        return tokenizationCard.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.cardNumber;
    }

    @NotNull
    public final String component2() {
        return this.cardHolderName;
    }

    @NotNull
    public final String component3() {
        return this.cardExpiryMonth;
    }

    @NotNull
    public final String component4() {
        return this.cardExpiryYear;
    }

    @NotNull
    public final String component5() {
        return this.cardCvv;
    }

    @NotNull
    public final TokenizationCard copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "cardHolderName");
        Intrinsics.checkNotNullParameter(str3, "cardExpiryMonth");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryYear");
        Intrinsics.checkNotNullParameter(str5, "cardCvv");
        return new TokenizationCard(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenizationCard)) {
            return false;
        }
        TokenizationCard tokenizationCard = (TokenizationCard) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) tokenizationCard.cardNumber) && Intrinsics.areEqual((Object) this.cardHolderName, (Object) tokenizationCard.cardHolderName) && Intrinsics.areEqual((Object) this.cardExpiryMonth, (Object) tokenizationCard.cardExpiryMonth) && Intrinsics.areEqual((Object) this.cardExpiryYear, (Object) tokenizationCard.cardExpiryYear) && Intrinsics.areEqual((Object) this.cardCvv, (Object) tokenizationCard.cardCvv);
    }

    @NotNull
    public final String getCardCvv() {
        return this.cardCvv;
    }

    @NotNull
    public final String getCardExpiryMonth() {
        return this.cardExpiryMonth;
    }

    @NotNull
    public final String getCardExpiryYear() {
        return this.cardExpiryYear;
    }

    @NotNull
    public final String getCardHolderName() {
        return this.cardHolderName;
    }

    @NotNull
    public final String getCardNumber() {
        return this.cardNumber;
    }

    public int hashCode() {
        return (((((((this.cardNumber.hashCode() * 31) + this.cardHolderName.hashCode()) * 31) + this.cardExpiryMonth.hashCode()) * 31) + this.cardExpiryYear.hashCode()) * 31) + this.cardCvv.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        String str2 = this.cardHolderName;
        String str3 = this.cardExpiryMonth;
        String str4 = this.cardExpiryYear;
        String str5 = this.cardCvv;
        return "TokenizationCard(cardNumber=" + str + ", cardHolderName=" + str2 + ", cardExpiryMonth=" + str3 + ", cardExpiryYear=" + str4 + ", cardCvv=" + str5 + ")";
    }
}
