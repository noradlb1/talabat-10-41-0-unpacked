package com.talabat.gem.domain.usecases;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "Ljava/io/Serializable;", "currency", "", "addAmount", "saveAmount", "maximumTierReached", "", "discountPercentage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAddAmount", "()Ljava/lang/String;", "getCurrency", "getDiscountPercentage", "getMaximumTierReached", "()Z", "getSaveAmount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubTotalLineTwo implements Serializable {
    @NotNull
    private final String addAmount;
    @NotNull
    private final String currency;
    @Nullable
    private final String discountPercentage;
    private final boolean maximumTierReached;
    @NotNull
    private final String saveAmount;

    public SubTotalLineTwo(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "currency");
        Intrinsics.checkNotNullParameter(str2, "addAmount");
        Intrinsics.checkNotNullParameter(str3, "saveAmount");
        this.currency = str;
        this.addAmount = str2;
        this.saveAmount = str3;
        this.maximumTierReached = z11;
        this.discountPercentage = str4;
    }

    public static /* synthetic */ SubTotalLineTwo copy$default(SubTotalLineTwo subTotalLineTwo, String str, String str2, String str3, boolean z11, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subTotalLineTwo.currency;
        }
        if ((i11 & 2) != 0) {
            str2 = subTotalLineTwo.addAmount;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = subTotalLineTwo.saveAmount;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            z11 = subTotalLineTwo.maximumTierReached;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            str4 = subTotalLineTwo.discountPercentage;
        }
        return subTotalLineTwo.copy(str, str5, str6, z12, str4);
    }

    @NotNull
    public final String component1() {
        return this.currency;
    }

    @NotNull
    public final String component2() {
        return this.addAmount;
    }

    @NotNull
    public final String component3() {
        return this.saveAmount;
    }

    public final boolean component4() {
        return this.maximumTierReached;
    }

    @Nullable
    public final String component5() {
        return this.discountPercentage;
    }

    @NotNull
    public final SubTotalLineTwo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "currency");
        Intrinsics.checkNotNullParameter(str2, "addAmount");
        Intrinsics.checkNotNullParameter(str3, "saveAmount");
        return new SubTotalLineTwo(str, str2, str3, z11, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubTotalLineTwo)) {
            return false;
        }
        SubTotalLineTwo subTotalLineTwo = (SubTotalLineTwo) obj;
        return Intrinsics.areEqual((Object) this.currency, (Object) subTotalLineTwo.currency) && Intrinsics.areEqual((Object) this.addAmount, (Object) subTotalLineTwo.addAmount) && Intrinsics.areEqual((Object) this.saveAmount, (Object) subTotalLineTwo.saveAmount) && this.maximumTierReached == subTotalLineTwo.maximumTierReached && Intrinsics.areEqual((Object) this.discountPercentage, (Object) subTotalLineTwo.discountPercentage);
    }

    @NotNull
    public final String getAddAmount() {
        return this.addAmount;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    @Nullable
    public final String getDiscountPercentage() {
        return this.discountPercentage;
    }

    public final boolean getMaximumTierReached() {
        return this.maximumTierReached;
    }

    @NotNull
    public final String getSaveAmount() {
        return this.saveAmount;
    }

    public int hashCode() {
        int hashCode = ((((this.currency.hashCode() * 31) + this.addAmount.hashCode()) * 31) + this.saveAmount.hashCode()) * 31;
        boolean z11 = this.maximumTierReached;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        String str = this.discountPercentage;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.currency;
        String str2 = this.addAmount;
        String str3 = this.saveAmount;
        boolean z11 = this.maximumTierReached;
        String str4 = this.discountPercentage;
        return "SubTotalLineTwo(currency=" + str + ", addAmount=" + str2 + ", saveAmount=" + str3 + ", maximumTierReached=" + z11 + ", discountPercentage=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubTotalLineTwo(String str, String str2, String str3, boolean z11, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? null : str4);
    }
}
