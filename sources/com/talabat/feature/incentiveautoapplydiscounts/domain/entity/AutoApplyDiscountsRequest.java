package com.talabat.feature.incentiveautoapplydiscounts.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;", "", "countryId", "", "areaId", "brandId", "branchId", "subTotalAmount", "", "orderDeliveryMode", "(IIIIDI)V", "getAreaId", "()I", "getBranchId", "getBrandId", "getCountryId", "getOrderDeliveryMode", "getSubTotalAmount", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_incentive-auto-apply-discounts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoApplyDiscountsRequest {
    private final int areaId;
    private final int branchId;
    private final int brandId;
    private final int countryId;
    private final int orderDeliveryMode;
    private final double subTotalAmount;

    public AutoApplyDiscountsRequest(int i11, int i12, int i13, int i14, double d11, int i15) {
        this.countryId = i11;
        this.areaId = i12;
        this.brandId = i13;
        this.branchId = i14;
        this.subTotalAmount = d11;
        this.orderDeliveryMode = i15;
    }

    public static /* synthetic */ AutoApplyDiscountsRequest copy$default(AutoApplyDiscountsRequest autoApplyDiscountsRequest, int i11, int i12, int i13, int i14, double d11, int i15, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i11 = autoApplyDiscountsRequest.countryId;
        }
        if ((i16 & 2) != 0) {
            i12 = autoApplyDiscountsRequest.areaId;
        }
        int i17 = i12;
        if ((i16 & 4) != 0) {
            i13 = autoApplyDiscountsRequest.brandId;
        }
        int i18 = i13;
        if ((i16 & 8) != 0) {
            i14 = autoApplyDiscountsRequest.branchId;
        }
        int i19 = i14;
        if ((i16 & 16) != 0) {
            d11 = autoApplyDiscountsRequest.subTotalAmount;
        }
        double d12 = d11;
        if ((i16 & 32) != 0) {
            i15 = autoApplyDiscountsRequest.orderDeliveryMode;
        }
        return autoApplyDiscountsRequest.copy(i11, i17, i18, i19, d12, i15);
    }

    public final int component1() {
        return this.countryId;
    }

    public final int component2() {
        return this.areaId;
    }

    public final int component3() {
        return this.brandId;
    }

    public final int component4() {
        return this.branchId;
    }

    public final double component5() {
        return this.subTotalAmount;
    }

    public final int component6() {
        return this.orderDeliveryMode;
    }

    @NotNull
    public final AutoApplyDiscountsRequest copy(int i11, int i12, int i13, int i14, double d11, int i15) {
        return new AutoApplyDiscountsRequest(i11, i12, i13, i14, d11, i15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoApplyDiscountsRequest)) {
            return false;
        }
        AutoApplyDiscountsRequest autoApplyDiscountsRequest = (AutoApplyDiscountsRequest) obj;
        return this.countryId == autoApplyDiscountsRequest.countryId && this.areaId == autoApplyDiscountsRequest.areaId && this.brandId == autoApplyDiscountsRequest.brandId && this.branchId == autoApplyDiscountsRequest.branchId && Intrinsics.areEqual((Object) Double.valueOf(this.subTotalAmount), (Object) Double.valueOf(autoApplyDiscountsRequest.subTotalAmount)) && this.orderDeliveryMode == autoApplyDiscountsRequest.orderDeliveryMode;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getBrandId() {
        return this.brandId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public final int getOrderDeliveryMode() {
        return this.orderDeliveryMode;
    }

    public final double getSubTotalAmount() {
        return this.subTotalAmount;
    }

    public int hashCode() {
        return (((((((((this.countryId * 31) + this.areaId) * 31) + this.brandId) * 31) + this.branchId) * 31) + Double.doubleToLongBits(this.subTotalAmount)) * 31) + this.orderDeliveryMode;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        int i12 = this.areaId;
        int i13 = this.brandId;
        int i14 = this.branchId;
        double d11 = this.subTotalAmount;
        int i15 = this.orderDeliveryMode;
        return "AutoApplyDiscountsRequest(countryId=" + i11 + ", areaId=" + i12 + ", brandId=" + i13 + ", branchId=" + i14 + ", subTotalAmount=" + d11 + ", orderDeliveryMode=" + i15 + ")";
    }
}
