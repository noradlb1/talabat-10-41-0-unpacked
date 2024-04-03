package datamodels;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Ldatamodels/WalletCreditCard;", "Ljava/io/Serializable;", "cardNumber", "", "binNumber", "month", "year", "code", "holderName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "getCardNumber", "getCode", "getHolderName", "getMonth", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCard implements Serializable {
    @Nullable
    private final String binNumber;
    @Nullable
    private final String cardNumber;
    @Nullable
    private final String code;
    @Nullable
    private final String holderName;
    @Nullable
    private final String month;
    @Nullable
    private final String year;

    public WalletCreditCard(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.cardNumber = str;
        this.binNumber = str2;
        this.month = str3;
        this.year = str4;
        this.code = str5;
        this.holderName = str6;
    }

    public static /* synthetic */ WalletCreditCard copy$default(WalletCreditCard walletCreditCard, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletCreditCard.cardNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = walletCreditCard.binNumber;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = walletCreditCard.month;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = walletCreditCard.year;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = walletCreditCard.code;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = walletCreditCard.holderName;
        }
        return walletCreditCard.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.cardNumber;
    }

    @Nullable
    public final String component2() {
        return this.binNumber;
    }

    @Nullable
    public final String component3() {
        return this.month;
    }

    @Nullable
    public final String component4() {
        return this.year;
    }

    @Nullable
    public final String component5() {
        return this.code;
    }

    @Nullable
    public final String component6() {
        return this.holderName;
    }

    @NotNull
    public final WalletCreditCard copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new WalletCreditCard(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditCard)) {
            return false;
        }
        WalletCreditCard walletCreditCard = (WalletCreditCard) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) walletCreditCard.cardNumber) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCreditCard.binNumber) && Intrinsics.areEqual((Object) this.month, (Object) walletCreditCard.month) && Intrinsics.areEqual((Object) this.year, (Object) walletCreditCard.year) && Intrinsics.areEqual((Object) this.code, (Object) walletCreditCard.code) && Intrinsics.areEqual((Object) this.holderName, (Object) walletCreditCard.holderName);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getHolderName() {
        return this.holderName;
    }

    @Nullable
    public final String getMonth() {
        return this.month;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    public int hashCode() {
        String str = this.cardNumber;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.binNumber;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.month;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.year;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.code;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.holderName;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        String str2 = this.binNumber;
        String str3 = this.month;
        String str4 = this.year;
        String str5 = this.code;
        String str6 = this.holderName;
        return "WalletCreditCard(cardNumber=" + str + ", binNumber=" + str2 + ", month=" + str3 + ", year=" + str4 + ", code=" + str5 + ", holderName=" + str6 + ")";
    }
}
