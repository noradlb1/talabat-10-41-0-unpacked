package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/ApplyPromoCodeRequestModel;", "", "customerVoucherId", "", "brandId", "areaId", "", "orderDeliveryMode", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAreaId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrandId", "()Ljava/lang/String;", "getCustomerVoucherId", "getOrderDeliveryMode", "getVerticalId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/ApplyPromoCodeRequestModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyPromoCodeRequestModel {
    @Nullable
    private final Integer areaId;
    @Nullable
    private final String brandId;
    @Nullable
    private final String customerVoucherId;
    @Nullable
    private final Integer orderDeliveryMode;
    @Nullable
    private final Integer verticalId;

    public ApplyPromoCodeRequestModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.customerVoucherId = str;
        this.brandId = str2;
        this.areaId = num;
        this.orderDeliveryMode = num2;
        this.verticalId = num3;
    }

    public static /* synthetic */ ApplyPromoCodeRequestModel copy$default(ApplyPromoCodeRequestModel applyPromoCodeRequestModel, String str, String str2, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = applyPromoCodeRequestModel.customerVoucherId;
        }
        if ((i11 & 2) != 0) {
            str2 = applyPromoCodeRequestModel.brandId;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            num = applyPromoCodeRequestModel.areaId;
        }
        Integer num4 = num;
        if ((i11 & 8) != 0) {
            num2 = applyPromoCodeRequestModel.orderDeliveryMode;
        }
        Integer num5 = num2;
        if ((i11 & 16) != 0) {
            num3 = applyPromoCodeRequestModel.verticalId;
        }
        return applyPromoCodeRequestModel.copy(str, str3, num4, num5, num3);
    }

    @Nullable
    public final String component1() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String component2() {
        return this.brandId;
    }

    @Nullable
    public final Integer component3() {
        return this.areaId;
    }

    @Nullable
    public final Integer component4() {
        return this.orderDeliveryMode;
    }

    @Nullable
    public final Integer component5() {
        return this.verticalId;
    }

    @NotNull
    public final ApplyPromoCodeRequestModel copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new ApplyPromoCodeRequestModel(str, str2, num, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplyPromoCodeRequestModel)) {
            return false;
        }
        ApplyPromoCodeRequestModel applyPromoCodeRequestModel = (ApplyPromoCodeRequestModel) obj;
        return Intrinsics.areEqual((Object) this.customerVoucherId, (Object) applyPromoCodeRequestModel.customerVoucherId) && Intrinsics.areEqual((Object) this.brandId, (Object) applyPromoCodeRequestModel.brandId) && Intrinsics.areEqual((Object) this.areaId, (Object) applyPromoCodeRequestModel.areaId) && Intrinsics.areEqual((Object) this.orderDeliveryMode, (Object) applyPromoCodeRequestModel.orderDeliveryMode) && Intrinsics.areEqual((Object) this.verticalId, (Object) applyPromoCodeRequestModel.verticalId);
    }

    @Nullable
    public final Integer getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getBrandId() {
        return this.brandId;
    }

    @Nullable
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @Nullable
    public final Integer getOrderDeliveryMode() {
        return this.orderDeliveryMode;
    }

    @Nullable
    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        String str = this.customerVoucherId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.brandId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.areaId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.orderDeliveryMode;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.verticalId;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.customerVoucherId;
        String str2 = this.brandId;
        Integer num = this.areaId;
        Integer num2 = this.orderDeliveryMode;
        Integer num3 = this.verticalId;
        return "ApplyPromoCodeRequestModel(customerVoucherId=" + str + ", brandId=" + str2 + ", areaId=" + num + ", orderDeliveryMode=" + num2 + ", verticalId=" + num3 + ")";
    }
}
