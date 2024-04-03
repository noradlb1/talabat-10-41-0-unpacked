package com.talabat.feature.darkstores.swimlanes.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductCharacteristics;", "", "ageLimit", "", "vatRate", "pieceBarcodes", "freshnessGuaranteeInDays", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgeLimit", "()Ljava/lang/String;", "getFreshnessGuaranteeInDays", "getPieceBarcodes", "getVatRate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductCharacteristics {
    @NotNull
    private final String ageLimit;
    @NotNull
    private final String freshnessGuaranteeInDays;
    @NotNull
    private final String pieceBarcodes;
    @NotNull
    private final String vatRate;

    public ProductCharacteristics(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "ageLimit");
        Intrinsics.checkNotNullParameter(str2, "vatRate");
        Intrinsics.checkNotNullParameter(str3, "pieceBarcodes");
        Intrinsics.checkNotNullParameter(str4, "freshnessGuaranteeInDays");
        this.ageLimit = str;
        this.vatRate = str2;
        this.pieceBarcodes = str3;
        this.freshnessGuaranteeInDays = str4;
    }

    public static /* synthetic */ ProductCharacteristics copy$default(ProductCharacteristics productCharacteristics, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productCharacteristics.ageLimit;
        }
        if ((i11 & 2) != 0) {
            str2 = productCharacteristics.vatRate;
        }
        if ((i11 & 4) != 0) {
            str3 = productCharacteristics.pieceBarcodes;
        }
        if ((i11 & 8) != 0) {
            str4 = productCharacteristics.freshnessGuaranteeInDays;
        }
        return productCharacteristics.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.ageLimit;
    }

    @NotNull
    public final String component2() {
        return this.vatRate;
    }

    @NotNull
    public final String component3() {
        return this.pieceBarcodes;
    }

    @NotNull
    public final String component4() {
        return this.freshnessGuaranteeInDays;
    }

    @NotNull
    public final ProductCharacteristics copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "ageLimit");
        Intrinsics.checkNotNullParameter(str2, "vatRate");
        Intrinsics.checkNotNullParameter(str3, "pieceBarcodes");
        Intrinsics.checkNotNullParameter(str4, "freshnessGuaranteeInDays");
        return new ProductCharacteristics(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductCharacteristics)) {
            return false;
        }
        ProductCharacteristics productCharacteristics = (ProductCharacteristics) obj;
        return Intrinsics.areEqual((Object) this.ageLimit, (Object) productCharacteristics.ageLimit) && Intrinsics.areEqual((Object) this.vatRate, (Object) productCharacteristics.vatRate) && Intrinsics.areEqual((Object) this.pieceBarcodes, (Object) productCharacteristics.pieceBarcodes) && Intrinsics.areEqual((Object) this.freshnessGuaranteeInDays, (Object) productCharacteristics.freshnessGuaranteeInDays);
    }

    @NotNull
    public final String getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final String getFreshnessGuaranteeInDays() {
        return this.freshnessGuaranteeInDays;
    }

    @NotNull
    public final String getPieceBarcodes() {
        return this.pieceBarcodes;
    }

    @NotNull
    public final String getVatRate() {
        return this.vatRate;
    }

    public int hashCode() {
        return (((((this.ageLimit.hashCode() * 31) + this.vatRate.hashCode()) * 31) + this.pieceBarcodes.hashCode()) * 31) + this.freshnessGuaranteeInDays.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.ageLimit;
        String str2 = this.vatRate;
        String str3 = this.pieceBarcodes;
        String str4 = this.freshnessGuaranteeInDays;
        return "ProductCharacteristics(ageLimit=" + str + ", vatRate=" + str2 + ", pieceBarcodes=" + str3 + ", freshnessGuaranteeInDays=" + str4 + ")";
    }
}
