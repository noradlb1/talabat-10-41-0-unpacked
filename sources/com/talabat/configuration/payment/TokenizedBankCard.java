package com.talabat.configuration.payment;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J{\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006,"}, d2 = {"Lcom/talabat/configuration/payment/TokenizedBankCard;", "", "binMessage", "", "binNumber", "expiryMonth", "", "expiryYear", "holderName", "isBinDiscountValid", "", "isForceCvv", "isValid", "number", "token", "type", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinMessage", "()Ljava/lang/String;", "getBinNumber", "getExpiryMonth", "()I", "getExpiryYear", "getHolderName", "()Z", "getNumber", "getToken", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedBankCard {
    @Nullable
    private final String binMessage;
    @Nullable
    private final String binNumber;
    private final int expiryMonth;
    private final int expiryYear;
    @NotNull
    private final String holderName;
    private final boolean isBinDiscountValid;
    private final boolean isForceCvv;
    private final boolean isValid;
    @NotNull
    private final String number;
    @NotNull
    private final String token;
    @NotNull
    private final String type;

    public TokenizedBankCard(@Nullable String str, @Nullable String str2, int i11, int i12, @NotNull String str3, boolean z11, boolean z12, boolean z13, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str3, "holderName");
        Intrinsics.checkNotNullParameter(str4, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str5, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str6, "type");
        this.binMessage = str;
        this.binNumber = str2;
        this.expiryMonth = i11;
        this.expiryYear = i12;
        this.holderName = str3;
        this.isBinDiscountValid = z11;
        this.isForceCvv = z12;
        this.isValid = z13;
        this.number = str4;
        this.token = str5;
        this.type = str6;
    }

    public static /* synthetic */ TokenizedBankCard copy$default(TokenizedBankCard tokenizedBankCard, String str, String str2, int i11, int i12, String str3, boolean z11, boolean z12, boolean z13, String str4, String str5, String str6, int i13, Object obj) {
        TokenizedBankCard tokenizedBankCard2 = tokenizedBankCard;
        int i14 = i13;
        return tokenizedBankCard.copy((i14 & 1) != 0 ? tokenizedBankCard2.binMessage : str, (i14 & 2) != 0 ? tokenizedBankCard2.binNumber : str2, (i14 & 4) != 0 ? tokenizedBankCard2.expiryMonth : i11, (i14 & 8) != 0 ? tokenizedBankCard2.expiryYear : i12, (i14 & 16) != 0 ? tokenizedBankCard2.holderName : str3, (i14 & 32) != 0 ? tokenizedBankCard2.isBinDiscountValid : z11, (i14 & 64) != 0 ? tokenizedBankCard2.isForceCvv : z12, (i14 & 128) != 0 ? tokenizedBankCard2.isValid : z13, (i14 & 256) != 0 ? tokenizedBankCard2.number : str4, (i14 & 512) != 0 ? tokenizedBankCard2.token : str5, (i14 & 1024) != 0 ? tokenizedBankCard2.type : str6);
    }

    @Nullable
    public final String component1() {
        return this.binMessage;
    }

    @NotNull
    public final String component10() {
        return this.token;
    }

    @NotNull
    public final String component11() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.binNumber;
    }

    public final int component3() {
        return this.expiryMonth;
    }

    public final int component4() {
        return this.expiryYear;
    }

    @NotNull
    public final String component5() {
        return this.holderName;
    }

    public final boolean component6() {
        return this.isBinDiscountValid;
    }

    public final boolean component7() {
        return this.isForceCvv;
    }

    public final boolean component8() {
        return this.isValid;
    }

    @NotNull
    public final String component9() {
        return this.number;
    }

    @NotNull
    public final TokenizedBankCard copy(@Nullable String str, @Nullable String str2, int i11, int i12, @NotNull String str3, boolean z11, boolean z12, boolean z13, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "holderName");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, CardTokenizationPlugin.ARG_NUMBER_KEY);
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, LegacyTokenLocalDataSourceImpl.KEY);
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "type");
        return new TokenizedBankCard(str, str2, i11, i12, str7, z11, z12, z13, str8, str9, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenizedBankCard)) {
            return false;
        }
        TokenizedBankCard tokenizedBankCard = (TokenizedBankCard) obj;
        return Intrinsics.areEqual((Object) this.binMessage, (Object) tokenizedBankCard.binMessage) && Intrinsics.areEqual((Object) this.binNumber, (Object) tokenizedBankCard.binNumber) && this.expiryMonth == tokenizedBankCard.expiryMonth && this.expiryYear == tokenizedBankCard.expiryYear && Intrinsics.areEqual((Object) this.holderName, (Object) tokenizedBankCard.holderName) && this.isBinDiscountValid == tokenizedBankCard.isBinDiscountValid && this.isForceCvv == tokenizedBankCard.isForceCvv && this.isValid == tokenizedBankCard.isValid && Intrinsics.areEqual((Object) this.number, (Object) tokenizedBankCard.number) && Intrinsics.areEqual((Object) this.token, (Object) tokenizedBankCard.token) && Intrinsics.areEqual((Object) this.type, (Object) tokenizedBankCard.type);
    }

    @Nullable
    public final String getBinMessage() {
        return this.binMessage;
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    public final int getExpiryMonth() {
        return this.expiryMonth;
    }

    public final int getExpiryYear() {
        return this.expiryYear;
    }

    @NotNull
    public final String getHolderName() {
        return this.holderName;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.binMessage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.binNumber;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        int hashCode2 = (((((((hashCode + i11) * 31) + this.expiryMonth) * 31) + this.expiryYear) * 31) + this.holderName.hashCode()) * 31;
        boolean z11 = this.isBinDiscountValid;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isForceCvv;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isValid;
        if (!z14) {
            z12 = z14;
        }
        return ((((((i13 + (z12 ? 1 : 0)) * 31) + this.number.hashCode()) * 31) + this.token.hashCode()) * 31) + this.type.hashCode();
    }

    public final boolean isBinDiscountValid() {
        return this.isBinDiscountValid;
    }

    public final boolean isForceCvv() {
        return this.isForceCvv;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    @NotNull
    public String toString() {
        String str = this.binMessage;
        String str2 = this.binNumber;
        int i11 = this.expiryMonth;
        int i12 = this.expiryYear;
        String str3 = this.holderName;
        boolean z11 = this.isBinDiscountValid;
        boolean z12 = this.isForceCvv;
        boolean z13 = this.isValid;
        String str4 = this.number;
        String str5 = this.token;
        String str6 = this.type;
        return "TokenizedBankCard(binMessage=" + str + ", binNumber=" + str2 + ", expiryMonth=" + i11 + ", expiryYear=" + i12 + ", holderName=" + str3 + ", isBinDiscountValid=" + z11 + ", isForceCvv=" + z12 + ", isValid=" + z13 + ", number=" + str4 + ", token=" + str5 + ", type=" + str6 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenizedBankCard(String str, String str2, int i11, int i12, String str3, boolean z11, boolean z12, boolean z13, String str4, String str5, String str6, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, i11, i12, str3, (i13 & 32) != 0 ? false : z11, (i13 & 64) != 0 ? false : z12, z13, str4, str5, str6);
    }
}
