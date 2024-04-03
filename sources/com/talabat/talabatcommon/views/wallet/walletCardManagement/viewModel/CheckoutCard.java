package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutCard;", "", "number", "", "name", "expiryMonth", "expiryYear", "cvv", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCvv", "()Ljava/lang/String;", "getExpiryMonth", "getExpiryYear", "getName", "getNumber", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutCard {
    @NotNull
    private final String cvv;
    @NotNull
    private final String expiryMonth;
    @NotNull
    private final String expiryYear;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f11958name;
    @NotNull
    private final String number;

    public CheckoutCard(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str4, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        Intrinsics.checkNotNullParameter(str5, CardTokenizationPlugin.ARG_CVV_KEY);
        this.number = str;
        this.f11958name = str2;
        this.expiryMonth = str3;
        this.expiryYear = str4;
        this.cvv = str5;
    }

    public static /* synthetic */ CheckoutCard copy$default(CheckoutCard checkoutCard, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = checkoutCard.number;
        }
        if ((i11 & 2) != 0) {
            str2 = checkoutCard.f11958name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = checkoutCard.expiryMonth;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = checkoutCard.expiryYear;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = checkoutCard.cvv;
        }
        return checkoutCard.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.number;
    }

    @NotNull
    public final String component2() {
        return this.f11958name;
    }

    @NotNull
    public final String component3() {
        return this.expiryMonth;
    }

    @NotNull
    public final String component4() {
        return this.expiryYear;
    }

    @NotNull
    public final String component5() {
        return this.cvv;
    }

    @NotNull
    public final CheckoutCard copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str4, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        Intrinsics.checkNotNullParameter(str5, CardTokenizationPlugin.ARG_CVV_KEY);
        return new CheckoutCard(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckoutCard)) {
            return false;
        }
        CheckoutCard checkoutCard = (CheckoutCard) obj;
        return Intrinsics.areEqual((Object) this.number, (Object) checkoutCard.number) && Intrinsics.areEqual((Object) this.f11958name, (Object) checkoutCard.f11958name) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) checkoutCard.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) checkoutCard.expiryYear) && Intrinsics.areEqual((Object) this.cvv, (Object) checkoutCard.cvv);
    }

    @NotNull
    public final String getCvv() {
        return this.cvv;
    }

    @NotNull
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @NotNull
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @NotNull
    public final String getName() {
        return this.f11958name;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    public int hashCode() {
        return (((((((this.number.hashCode() * 31) + this.f11958name.hashCode()) * 31) + this.expiryMonth.hashCode()) * 31) + this.expiryYear.hashCode()) * 31) + this.cvv.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.number;
        String str2 = this.f11958name;
        String str3 = this.expiryMonth;
        String str4 = this.expiryYear;
        String str5 = this.cvv;
        return "CheckoutCard(number=" + str + ", name=" + str2 + ", expiryMonth=" + str3 + ", expiryYear=" + str4 + ", cvv=" + str5 + ")";
    }
}
