package com.talabat.gem.domain.usecases;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/gem/domain/usecases/SubTotalLineOne;", "Ljava/io/Serializable;", "currency", "", "subTotal", "strikeThrough", "", "subTotalAfterDiscountColor", "subTotalAfterDiscount", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "getStrikeThrough", "()Z", "getSubTotal", "getSubTotalAfterDiscount", "getSubTotalAfterDiscountColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubTotalLineOne implements Serializable {
    @NotNull
    private final String currency;
    private final boolean strikeThrough;
    @NotNull
    private final String subTotal;
    @Nullable
    private final String subTotalAfterDiscount;
    @Nullable
    private final String subTotalAfterDiscountColor;

    public SubTotalLineOne(@NotNull String str, @NotNull String str2, boolean z11, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "currency");
        Intrinsics.checkNotNullParameter(str2, "subTotal");
        this.currency = str;
        this.subTotal = str2;
        this.strikeThrough = z11;
        this.subTotalAfterDiscountColor = str3;
        this.subTotalAfterDiscount = str4;
    }

    public static /* synthetic */ SubTotalLineOne copy$default(SubTotalLineOne subTotalLineOne, String str, String str2, boolean z11, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subTotalLineOne.currency;
        }
        if ((i11 & 2) != 0) {
            str2 = subTotalLineOne.subTotal;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            z11 = subTotalLineOne.strikeThrough;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            str3 = subTotalLineOne.subTotalAfterDiscountColor;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = subTotalLineOne.subTotalAfterDiscount;
        }
        return subTotalLineOne.copy(str, str5, z12, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.currency;
    }

    @NotNull
    public final String component2() {
        return this.subTotal;
    }

    public final boolean component3() {
        return this.strikeThrough;
    }

    @Nullable
    public final String component4() {
        return this.subTotalAfterDiscountColor;
    }

    @Nullable
    public final String component5() {
        return this.subTotalAfterDiscount;
    }

    @NotNull
    public final SubTotalLineOne copy(@NotNull String str, @NotNull String str2, boolean z11, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "currency");
        Intrinsics.checkNotNullParameter(str2, "subTotal");
        return new SubTotalLineOne(str, str2, z11, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubTotalLineOne)) {
            return false;
        }
        SubTotalLineOne subTotalLineOne = (SubTotalLineOne) obj;
        return Intrinsics.areEqual((Object) this.currency, (Object) subTotalLineOne.currency) && Intrinsics.areEqual((Object) this.subTotal, (Object) subTotalLineOne.subTotal) && this.strikeThrough == subTotalLineOne.strikeThrough && Intrinsics.areEqual((Object) this.subTotalAfterDiscountColor, (Object) subTotalLineOne.subTotalAfterDiscountColor) && Intrinsics.areEqual((Object) this.subTotalAfterDiscount, (Object) subTotalLineOne.subTotalAfterDiscount);
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    public final boolean getStrikeThrough() {
        return this.strikeThrough;
    }

    @NotNull
    public final String getSubTotal() {
        return this.subTotal;
    }

    @Nullable
    public final String getSubTotalAfterDiscount() {
        return this.subTotalAfterDiscount;
    }

    @Nullable
    public final String getSubTotalAfterDiscountColor() {
        return this.subTotalAfterDiscountColor;
    }

    public int hashCode() {
        int hashCode = ((this.currency.hashCode() * 31) + this.subTotal.hashCode()) * 31;
        boolean z11 = this.strikeThrough;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        String str = this.subTotalAfterDiscountColor;
        int i12 = 0;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subTotalAfterDiscount;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return hashCode2 + i12;
    }

    @NotNull
    public String toString() {
        String str = this.currency;
        String str2 = this.subTotal;
        boolean z11 = this.strikeThrough;
        String str3 = this.subTotalAfterDiscountColor;
        String str4 = this.subTotalAfterDiscount;
        return "SubTotalLineOne(currency=" + str + ", subTotal=" + str2 + ", strikeThrough=" + z11 + ", subTotalAfterDiscountColor=" + str3 + ", subTotalAfterDiscount=" + str4 + ")";
    }
}
