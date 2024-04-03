package com.talabat.darkstores.data.darkstores.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.darkstores.model.TargetAudienceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\f\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u0017\u001a\u00020\t¢\u0006\u0002\u0010\u0018J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0013HÆ\u0003J\t\u00101\u001a\u00020\u0013HÆ\u0003J\t\u00102\u001a\u00020\u0016HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0010HÆ\u0003J\u0001\u0010<\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00062\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00162\b\b\u0003\u0010\u0017\u001a\u00020\tHÆ\u0001J\u0013\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0016HÖ\u0001J\t\u0010@\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006A"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/CartRequestByVendorId;", "", "items", "", "Lcom/talabat/darkstores/data/darkstores/model/CartProduct;", "globalVendorId", "", "locale", "autoAdd", "", "platformVendorId", "latitude", "", "longitude", "deliveryType", "targetAudience", "Lcom/talabat/darkstores/model/TargetAudienceType;", "globalEntityId", "deliveryFee", "", "minOrderValue", "chainId", "", "enableBasketBasedDeliveryFee", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;DDLjava/lang/String;Lcom/talabat/darkstores/model/TargetAudienceType;Ljava/lang/String;FFIZ)V", "getAutoAdd", "()Z", "getChainId", "()I", "getDeliveryFee", "()F", "getDeliveryType", "()Ljava/lang/String;", "getEnableBasketBasedDeliveryFee", "getGlobalEntityId", "getGlobalVendorId", "getItems", "()Ljava/util/List;", "getLatitude", "()D", "getLocale", "getLongitude", "getMinOrderValue", "getPlatformVendorId", "getTargetAudience", "()Lcom/talabat/darkstores/model/TargetAudienceType;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartRequestByVendorId {
    private final boolean autoAdd;
    private final int chainId;
    private final float deliveryFee;
    @NotNull
    private final String deliveryType;
    private final boolean enableBasketBasedDeliveryFee;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final String globalVendorId;
    @NotNull
    private final List<CartProduct> items;
    private final double latitude;
    @NotNull
    private final String locale;
    private final double longitude;
    private final float minOrderValue;
    @NotNull
    private final String platformVendorId;
    @NotNull
    private final TargetAudienceType targetAudience;

    public CartRequestByVendorId(@NotNull @Json(name = "items") List<CartProduct> list, @NotNull @Json(name = "global_vendor_id") String str, @NotNull @Json(name = "locale") String str2, @Json(name = "auto_add") boolean z11, @NotNull @Json(name = "platform_vendor_id") String str3, @Json(name = "lat") double d11, @Json(name = "lon") double d12, @NotNull @Json(name = "delivery_type") String str4, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @NotNull @Json(name = "global_entity_id") String str5, @Json(name = "delivery_fee") float f11, @Json(name = "minimum_order_value") float f12, @Json(name = "chain_id") int i11, @Json(name = "enableBasketBasedDeliveryFee") boolean z12) {
        String str6 = str4;
        TargetAudienceType targetAudienceType2 = targetAudienceType;
        String str7 = str5;
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Intrinsics.checkNotNullParameter(str3, "platformVendorId");
        Intrinsics.checkNotNullParameter(str6, "deliveryType");
        Intrinsics.checkNotNullParameter(targetAudienceType2, "targetAudience");
        Intrinsics.checkNotNullParameter(str7, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        this.items = list;
        this.globalVendorId = str;
        this.locale = str2;
        this.autoAdd = z11;
        this.platformVendorId = str3;
        this.latitude = d11;
        this.longitude = d12;
        this.deliveryType = str6;
        this.targetAudience = targetAudienceType2;
        this.globalEntityId = str7;
        this.deliveryFee = f11;
        this.minOrderValue = f12;
        this.chainId = i11;
        this.enableBasketBasedDeliveryFee = z12;
    }

    public static /* synthetic */ CartRequestByVendorId copy$default(CartRequestByVendorId cartRequestByVendorId, List list, String str, String str2, boolean z11, String str3, double d11, double d12, String str4, TargetAudienceType targetAudienceType, String str5, float f11, float f12, int i11, boolean z12, int i12, Object obj) {
        CartRequestByVendorId cartRequestByVendorId2 = cartRequestByVendorId;
        int i13 = i12;
        return cartRequestByVendorId.copy((i13 & 1) != 0 ? cartRequestByVendorId2.items : list, (i13 & 2) != 0 ? cartRequestByVendorId2.globalVendorId : str, (i13 & 4) != 0 ? cartRequestByVendorId2.locale : str2, (i13 & 8) != 0 ? cartRequestByVendorId2.autoAdd : z11, (i13 & 16) != 0 ? cartRequestByVendorId2.platformVendorId : str3, (i13 & 32) != 0 ? cartRequestByVendorId2.latitude : d11, (i13 & 64) != 0 ? cartRequestByVendorId2.longitude : d12, (i13 & 128) != 0 ? cartRequestByVendorId2.deliveryType : str4, (i13 & 256) != 0 ? cartRequestByVendorId2.targetAudience : targetAudienceType, (i13 & 512) != 0 ? cartRequestByVendorId2.globalEntityId : str5, (i13 & 1024) != 0 ? cartRequestByVendorId2.deliveryFee : f11, (i13 & 2048) != 0 ? cartRequestByVendorId2.minOrderValue : f12, (i13 & 4096) != 0 ? cartRequestByVendorId2.chainId : i11, (i13 & 8192) != 0 ? cartRequestByVendorId2.enableBasketBasedDeliveryFee : z12);
    }

    @NotNull
    public final List<CartProduct> component1() {
        return this.items;
    }

    @NotNull
    public final String component10() {
        return this.globalEntityId;
    }

    public final float component11() {
        return this.deliveryFee;
    }

    public final float component12() {
        return this.minOrderValue;
    }

    public final int component13() {
        return this.chainId;
    }

    public final boolean component14() {
        return this.enableBasketBasedDeliveryFee;
    }

    @NotNull
    public final String component2() {
        return this.globalVendorId;
    }

    @NotNull
    public final String component3() {
        return this.locale;
    }

    public final boolean component4() {
        return this.autoAdd;
    }

    @NotNull
    public final String component5() {
        return this.platformVendorId;
    }

    public final double component6() {
        return this.latitude;
    }

    public final double component7() {
        return this.longitude;
    }

    @NotNull
    public final String component8() {
        return this.deliveryType;
    }

    @NotNull
    public final TargetAudienceType component9() {
        return this.targetAudience;
    }

    @NotNull
    public final CartRequestByVendorId copy(@NotNull @Json(name = "items") List<CartProduct> list, @NotNull @Json(name = "global_vendor_id") String str, @NotNull @Json(name = "locale") String str2, @Json(name = "auto_add") boolean z11, @NotNull @Json(name = "platform_vendor_id") String str3, @Json(name = "lat") double d11, @Json(name = "lon") double d12, @NotNull @Json(name = "delivery_type") String str4, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @NotNull @Json(name = "global_entity_id") String str5, @Json(name = "delivery_fee") float f11, @Json(name = "minimum_order_value") float f12, @Json(name = "chain_id") int i11, @Json(name = "enableBasketBasedDeliveryFee") boolean z12) {
        List<CartProduct> list2 = list;
        Intrinsics.checkNotNullParameter(list2, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Intrinsics.checkNotNullParameter(str3, "platformVendorId");
        Intrinsics.checkNotNullParameter(str4, "deliveryType");
        Intrinsics.checkNotNullParameter(targetAudienceType, "targetAudience");
        Intrinsics.checkNotNullParameter(str5, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        return new CartRequestByVendorId(list2, str, str2, z11, str3, d11, d12, str4, targetAudienceType, str5, f11, f12, i11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartRequestByVendorId)) {
            return false;
        }
        CartRequestByVendorId cartRequestByVendorId = (CartRequestByVendorId) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) cartRequestByVendorId.items) && Intrinsics.areEqual((Object) this.globalVendorId, (Object) cartRequestByVendorId.globalVendorId) && Intrinsics.areEqual((Object) this.locale, (Object) cartRequestByVendorId.locale) && this.autoAdd == cartRequestByVendorId.autoAdd && Intrinsics.areEqual((Object) this.platformVendorId, (Object) cartRequestByVendorId.platformVendorId) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(cartRequestByVendorId.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(cartRequestByVendorId.longitude)) && Intrinsics.areEqual((Object) this.deliveryType, (Object) cartRequestByVendorId.deliveryType) && this.targetAudience == cartRequestByVendorId.targetAudience && Intrinsics.areEqual((Object) this.globalEntityId, (Object) cartRequestByVendorId.globalEntityId) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(cartRequestByVendorId.deliveryFee)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(cartRequestByVendorId.minOrderValue)) && this.chainId == cartRequestByVendorId.chainId && this.enableBasketBasedDeliveryFee == cartRequestByVendorId.enableBasketBasedDeliveryFee;
    }

    public final boolean getAutoAdd() {
        return this.autoAdd;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final String getDeliveryType() {
        return this.deliveryType;
    }

    public final boolean getEnableBasketBasedDeliveryFee() {
        return this.enableBasketBasedDeliveryFee;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @NotNull
    public final String getGlobalVendorId() {
        return this.globalVendorId;
    }

    @NotNull
    public final List<CartProduct> getItems() {
        return this.items;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final String getPlatformVendorId() {
        return this.platformVendorId;
    }

    @NotNull
    public final TargetAudienceType getTargetAudience() {
        return this.targetAudience;
    }

    public int hashCode() {
        int hashCode = ((((this.items.hashCode() * 31) + this.globalVendorId.hashCode()) * 31) + this.locale.hashCode()) * 31;
        boolean z11 = this.autoAdd;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((((((((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.platformVendorId.hashCode()) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.deliveryType.hashCode()) * 31) + this.targetAudience.hashCode()) * 31) + this.globalEntityId.hashCode()) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.chainId) * 31;
        boolean z13 = this.enableBasketBasedDeliveryFee;
        if (!z13) {
            z12 = z13;
        }
        return hashCode2 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<CartProduct> list = this.items;
        String str = this.globalVendorId;
        String str2 = this.locale;
        boolean z11 = this.autoAdd;
        String str3 = this.platformVendorId;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str4 = this.deliveryType;
        TargetAudienceType targetAudienceType = this.targetAudience;
        String str5 = this.globalEntityId;
        float f11 = this.deliveryFee;
        float f12 = this.minOrderValue;
        int i11 = this.chainId;
        boolean z12 = this.enableBasketBasedDeliveryFee;
        return "CartRequestByVendorId(items=" + list + ", globalVendorId=" + str + ", locale=" + str2 + ", autoAdd=" + z11 + ", platformVendorId=" + str3 + ", latitude=" + d11 + ", longitude=" + d12 + ", deliveryType=" + str4 + ", targetAudience=" + targetAudienceType + ", globalEntityId=" + str5 + ", deliveryFee=" + f11 + ", minOrderValue=" + f12 + ", chainId=" + i11 + ", enableBasketBasedDeliveryFee=" + z12 + ")";
    }
}
