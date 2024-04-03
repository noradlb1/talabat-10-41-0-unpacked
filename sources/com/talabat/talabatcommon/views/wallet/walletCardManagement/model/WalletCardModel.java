package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardModel;", "", "cardNumber", "", "binNumber", "month", "year", "cvv", "holderName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "getCardNumber", "getCvv", "getHolderName", "getMonth", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardModel {
    @NotNull
    private final String binNumber;
    @NotNull
    private final String cardNumber;
    @NotNull
    private final String cvv;
    @NotNull
    private final String holderName;
    @NotNull
    private final String month;
    @NotNull
    private final String year;

    public WalletCardModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "binNumber");
        Intrinsics.checkNotNullParameter(str3, "month");
        Intrinsics.checkNotNullParameter(str4, "year");
        Intrinsics.checkNotNullParameter(str5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(str6, "holderName");
        this.cardNumber = str;
        this.binNumber = str2;
        this.month = str3;
        this.year = str4;
        this.cvv = str5;
        this.holderName = str6;
    }

    public static /* synthetic */ WalletCardModel copy$default(WalletCardModel walletCardModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletCardModel.cardNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = walletCardModel.binNumber;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = walletCardModel.month;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = walletCardModel.year;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = walletCardModel.cvv;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = walletCardModel.holderName;
        }
        return walletCardModel.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.cardNumber;
    }

    @NotNull
    public final String component2() {
        return this.binNumber;
    }

    @NotNull
    public final String component3() {
        return this.month;
    }

    @NotNull
    public final String component4() {
        return this.year;
    }

    @NotNull
    public final String component5() {
        return this.cvv;
    }

    @NotNull
    public final String component6() {
        return this.holderName;
    }

    @NotNull
    public final WalletCardModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "binNumber");
        Intrinsics.checkNotNullParameter(str3, "month");
        Intrinsics.checkNotNullParameter(str4, "year");
        Intrinsics.checkNotNullParameter(str5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(str6, "holderName");
        return new WalletCardModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCardModel)) {
            return false;
        }
        WalletCardModel walletCardModel = (WalletCardModel) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) walletCardModel.cardNumber) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCardModel.binNumber) && Intrinsics.areEqual((Object) this.month, (Object) walletCardModel.month) && Intrinsics.areEqual((Object) this.year, (Object) walletCardModel.year) && Intrinsics.areEqual((Object) this.cvv, (Object) walletCardModel.cvv) && Intrinsics.areEqual((Object) this.holderName, (Object) walletCardModel.holderName);
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
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
    public final String getHolderName() {
        return this.holderName;
    }

    @NotNull
    public final String getMonth() {
        return this.month;
    }

    @NotNull
    public final String getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((((((this.cardNumber.hashCode() * 31) + this.binNumber.hashCode()) * 31) + this.month.hashCode()) * 31) + this.year.hashCode()) * 31) + this.cvv.hashCode()) * 31) + this.holderName.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        String str2 = this.binNumber;
        String str3 = this.month;
        String str4 = this.year;
        String str5 = this.cvv;
        String str6 = this.holderName;
        return "WalletCardModel(cardNumber=" + str + ", binNumber=" + str2 + ", month=" + str3 + ", year=" + str4 + ", cvv=" + str5 + ", holderName=" + str6 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCardModel(String str, String str2, String str3, String str4, String str5, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i11 & 32) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str6);
    }
}
