package com.talabat.feature.darkstoresvendor.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013Jz\u0010&\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\t\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000b\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006-"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "", "vendorId", "", "vendorCode", "deliveryFee", "", "deliveryTime", "minimumOrderValue", "isTPro", "", "isVendorPro", "basketDeliveryFeeTiers", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "scheduleDeliveryDiscount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;Ljava/lang/Float;)V", "getBasketDeliveryFeeTiers", "()Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "getDeliveryFee", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDeliveryTime", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinimumOrderValue", "getScheduleDeliveryDiscount", "getVendorCode", "getVendorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;Ljava/lang/Float;)Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorResponse {
    @Nullable
    private final BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTiers;
    @Nullable
    private final Float deliveryFee;
    @Nullable
    private final String deliveryTime;
    @Nullable
    private final Boolean isTPro;
    @Nullable
    private final Boolean isVendorPro;
    @Nullable
    private final Float minimumOrderValue;
    @Nullable
    private final Float scheduleDeliveryDiscount;
    @Nullable
    private final String vendorCode;
    @Nullable
    private final String vendorId;

    public VendorResponse() {
        this((String) null, (String) null, (Float) null, (String) null, (Float) null, (Boolean) null, (Boolean) null, (BasketDeliveryFeeTierInfoResponse) null, (Float) null, 511, (DefaultConstructorMarker) null);
    }

    public VendorResponse(@Nullable @Json(name = "vendor_id") String str, @Nullable @Json(name = "vendor_code") String str2, @Nullable @Json(name = "delivery_fee") Float f11, @Nullable @Json(name = "delivery_time") String str3, @Nullable @Json(name = "minimum_order_value") Float f12, @Nullable @Json(name = "is_tpro") Boolean bool, @Nullable @Json(name = "is_vendor_pro") Boolean bool2, @Nullable @Json(name = "basket_tiers") BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse, @Nullable @Json(name = "scheduled_delivery_discount") Float f13) {
        this.vendorId = str;
        this.vendorCode = str2;
        this.deliveryFee = f11;
        this.deliveryTime = str3;
        this.minimumOrderValue = f12;
        this.isTPro = bool;
        this.isVendorPro = bool2;
        this.basketDeliveryFeeTiers = basketDeliveryFeeTierInfoResponse;
        this.scheduleDeliveryDiscount = f13;
    }

    public static /* synthetic */ VendorResponse copy$default(VendorResponse vendorResponse, String str, String str2, Float f11, String str3, Float f12, Boolean bool, Boolean bool2, BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse, Float f13, int i11, Object obj) {
        VendorResponse vendorResponse2 = vendorResponse;
        int i12 = i11;
        return vendorResponse.copy((i12 & 1) != 0 ? vendorResponse2.vendorId : str, (i12 & 2) != 0 ? vendorResponse2.vendorCode : str2, (i12 & 4) != 0 ? vendorResponse2.deliveryFee : f11, (i12 & 8) != 0 ? vendorResponse2.deliveryTime : str3, (i12 & 16) != 0 ? vendorResponse2.minimumOrderValue : f12, (i12 & 32) != 0 ? vendorResponse2.isTPro : bool, (i12 & 64) != 0 ? vendorResponse2.isVendorPro : bool2, (i12 & 128) != 0 ? vendorResponse2.basketDeliveryFeeTiers : basketDeliveryFeeTierInfoResponse, (i12 & 256) != 0 ? vendorResponse2.scheduleDeliveryDiscount : f13);
    }

    @Nullable
    public final String component1() {
        return this.vendorId;
    }

    @Nullable
    public final String component2() {
        return this.vendorCode;
    }

    @Nullable
    public final Float component3() {
        return this.deliveryFee;
    }

    @Nullable
    public final String component4() {
        return this.deliveryTime;
    }

    @Nullable
    public final Float component5() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final Boolean component6() {
        return this.isTPro;
    }

    @Nullable
    public final Boolean component7() {
        return this.isVendorPro;
    }

    @Nullable
    public final BasketDeliveryFeeTierInfoResponse component8() {
        return this.basketDeliveryFeeTiers;
    }

    @Nullable
    public final Float component9() {
        return this.scheduleDeliveryDiscount;
    }

    @NotNull
    public final VendorResponse copy(@Nullable @Json(name = "vendor_id") String str, @Nullable @Json(name = "vendor_code") String str2, @Nullable @Json(name = "delivery_fee") Float f11, @Nullable @Json(name = "delivery_time") String str3, @Nullable @Json(name = "minimum_order_value") Float f12, @Nullable @Json(name = "is_tpro") Boolean bool, @Nullable @Json(name = "is_vendor_pro") Boolean bool2, @Nullable @Json(name = "basket_tiers") BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse, @Nullable @Json(name = "scheduled_delivery_discount") Float f13) {
        return new VendorResponse(str, str2, f11, str3, f12, bool, bool2, basketDeliveryFeeTierInfoResponse, f13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorResponse)) {
            return false;
        }
        VendorResponse vendorResponse = (VendorResponse) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) vendorResponse.vendorId) && Intrinsics.areEqual((Object) this.vendorCode, (Object) vendorResponse.vendorCode) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) vendorResponse.deliveryFee) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) vendorResponse.deliveryTime) && Intrinsics.areEqual((Object) this.minimumOrderValue, (Object) vendorResponse.minimumOrderValue) && Intrinsics.areEqual((Object) this.isTPro, (Object) vendorResponse.isTPro) && Intrinsics.areEqual((Object) this.isVendorPro, (Object) vendorResponse.isVendorPro) && Intrinsics.areEqual((Object) this.basketDeliveryFeeTiers, (Object) vendorResponse.basketDeliveryFeeTiers) && Intrinsics.areEqual((Object) this.scheduleDeliveryDiscount, (Object) vendorResponse.scheduleDeliveryDiscount);
    }

    @Nullable
    public final BasketDeliveryFeeTierInfoResponse getBasketDeliveryFeeTiers() {
        return this.basketDeliveryFeeTiers;
    }

    @Nullable
    public final Float getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    @Nullable
    public final Float getMinimumOrderValue() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final Float getScheduleDeliveryDiscount() {
        return this.scheduleDeliveryDiscount;
    }

    @Nullable
    public final String getVendorCode() {
        return this.vendorCode;
    }

    @Nullable
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.vendorId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.deliveryFee;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str3 = this.deliveryTime;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f12 = this.minimumOrderValue;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Boolean bool = this.isTPro;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isVendorPro;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse = this.basketDeliveryFeeTiers;
        int hashCode8 = (hashCode7 + (basketDeliveryFeeTierInfoResponse == null ? 0 : basketDeliveryFeeTierInfoResponse.hashCode())) * 31;
        Float f13 = this.scheduleDeliveryDiscount;
        if (f13 != null) {
            i11 = f13.hashCode();
        }
        return hashCode8 + i11;
    }

    @Nullable
    public final Boolean isTPro() {
        return this.isTPro;
    }

    @Nullable
    public final Boolean isVendorPro() {
        return this.isVendorPro;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.vendorCode;
        Float f11 = this.deliveryFee;
        String str3 = this.deliveryTime;
        Float f12 = this.minimumOrderValue;
        Boolean bool = this.isTPro;
        Boolean bool2 = this.isVendorPro;
        BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse = this.basketDeliveryFeeTiers;
        Float f13 = this.scheduleDeliveryDiscount;
        return "VendorResponse(vendorId=" + str + ", vendorCode=" + str2 + ", deliveryFee=" + f11 + ", deliveryTime=" + str3 + ", minimumOrderValue=" + f12 + ", isTPro=" + bool + ", isVendorPro=" + bool2 + ", basketDeliveryFeeTiers=" + basketDeliveryFeeTierInfoResponse + ", scheduleDeliveryDiscount=" + f13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorResponse(java.lang.String r11, java.lang.String r12, java.lang.Float r13, java.lang.String r14, java.lang.Float r15, java.lang.Boolean r16, java.lang.Boolean r17, com.talabat.feature.darkstoresvendor.data.model.BasketDeliveryFeeTierInfoResponse r18, java.lang.Float r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresvendor.data.model.VendorResponse.<init>(java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Boolean, java.lang.Boolean, com.talabat.feature.darkstoresvendor.data.model.BasketDeliveryFeeTierInfoResponse, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
