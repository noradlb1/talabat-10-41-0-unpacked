package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemVoucherCodeRequestModel;", "", "brandId", "", "country", "", "areaId", "orderDeliveryMode", "(Ljava/lang/String;ILjava/lang/Integer;I)V", "getAreaId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrandId", "()Ljava/lang/String;", "getCountry", "()I", "getOrderDeliveryMode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/Integer;I)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemVoucherCodeRequestModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherCodeRequestModel {
    @Nullable
    private final Integer areaId;
    @Nullable
    private final String brandId;
    private final int country;
    private final int orderDeliveryMode;

    public RedeemVoucherCodeRequestModel(@Nullable String str, int i11, @Nullable Integer num, int i12) {
        this.brandId = str;
        this.country = i11;
        this.areaId = num;
        this.orderDeliveryMode = i12;
    }

    public static /* synthetic */ RedeemVoucherCodeRequestModel copy$default(RedeemVoucherCodeRequestModel redeemVoucherCodeRequestModel, String str, int i11, Integer num, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = redeemVoucherCodeRequestModel.brandId;
        }
        if ((i13 & 2) != 0) {
            i11 = redeemVoucherCodeRequestModel.country;
        }
        if ((i13 & 4) != 0) {
            num = redeemVoucherCodeRequestModel.areaId;
        }
        if ((i13 & 8) != 0) {
            i12 = redeemVoucherCodeRequestModel.orderDeliveryMode;
        }
        return redeemVoucherCodeRequestModel.copy(str, i11, num, i12);
    }

    @Nullable
    public final String component1() {
        return this.brandId;
    }

    public final int component2() {
        return this.country;
    }

    @Nullable
    public final Integer component3() {
        return this.areaId;
    }

    public final int component4() {
        return this.orderDeliveryMode;
    }

    @NotNull
    public final RedeemVoucherCodeRequestModel copy(@Nullable String str, int i11, @Nullable Integer num, int i12) {
        return new RedeemVoucherCodeRequestModel(str, i11, num, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemVoucherCodeRequestModel)) {
            return false;
        }
        RedeemVoucherCodeRequestModel redeemVoucherCodeRequestModel = (RedeemVoucherCodeRequestModel) obj;
        return Intrinsics.areEqual((Object) this.brandId, (Object) redeemVoucherCodeRequestModel.brandId) && this.country == redeemVoucherCodeRequestModel.country && Intrinsics.areEqual((Object) this.areaId, (Object) redeemVoucherCodeRequestModel.areaId) && this.orderDeliveryMode == redeemVoucherCodeRequestModel.orderDeliveryMode;
    }

    @Nullable
    public final Integer getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getBrandId() {
        return this.brandId;
    }

    public final int getCountry() {
        return this.country;
    }

    public final int getOrderDeliveryMode() {
        return this.orderDeliveryMode;
    }

    public int hashCode() {
        String str = this.brandId;
        int i11 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.country) * 31;
        Integer num = this.areaId;
        if (num != null) {
            i11 = num.hashCode();
        }
        return ((hashCode + i11) * 31) + this.orderDeliveryMode;
    }

    @NotNull
    public String toString() {
        String str = this.brandId;
        int i11 = this.country;
        Integer num = this.areaId;
        int i12 = this.orderDeliveryMode;
        return "RedeemVoucherCodeRequestModel(brandId=" + str + ", country=" + i11 + ", areaId=" + num + ", orderDeliveryMode=" + i12 + ")";
    }
}
