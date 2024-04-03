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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BO\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003JU\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/CartRequestByCartId;", "", "items", "", "Lcom/talabat/darkstores/data/darkstores/model/CartProduct;", "vendorId", "", "targetAudience", "Lcom/talabat/darkstores/model/TargetAudienceType;", "globalEntityId", "deliveryFee", "", "minOrderValue", "chainId", "", "(Ljava/util/List;Ljava/lang/String;Lcom/talabat/darkstores/model/TargetAudienceType;Ljava/lang/String;FFI)V", "getChainId", "()I", "getDeliveryFee", "()F", "getGlobalEntityId", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMinOrderValue", "getTargetAudience", "()Lcom/talabat/darkstores/model/TargetAudienceType;", "getVendorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartRequestByCartId {
    private final int chainId;
    private final float deliveryFee;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final List<CartProduct> items;
    private final float minOrderValue;
    @NotNull
    private final TargetAudienceType targetAudience;
    @NotNull
    private final String vendorId;

    public CartRequestByCartId(@NotNull List<CartProduct> list, @NotNull @Json(name = "vendor_id") String str, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @NotNull @Json(name = "global_entity_id") String str2, @Json(name = "delivery_fee") float f11, @Json(name = "minimum_order_value") float f12, @Json(name = "chain_id") int i11) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(targetAudienceType, "targetAudience");
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        this.items = list;
        this.vendorId = str;
        this.targetAudience = targetAudienceType;
        this.globalEntityId = str2;
        this.deliveryFee = f11;
        this.minOrderValue = f12;
        this.chainId = i11;
    }

    public static /* synthetic */ CartRequestByCartId copy$default(CartRequestByCartId cartRequestByCartId, List<CartProduct> list, String str, TargetAudienceType targetAudienceType, String str2, float f11, float f12, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = cartRequestByCartId.items;
        }
        if ((i12 & 2) != 0) {
            str = cartRequestByCartId.vendorId;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            targetAudienceType = cartRequestByCartId.targetAudience;
        }
        TargetAudienceType targetAudienceType2 = targetAudienceType;
        if ((i12 & 8) != 0) {
            str2 = cartRequestByCartId.globalEntityId;
        }
        String str4 = str2;
        if ((i12 & 16) != 0) {
            f11 = cartRequestByCartId.deliveryFee;
        }
        float f13 = f11;
        if ((i12 & 32) != 0) {
            f12 = cartRequestByCartId.minOrderValue;
        }
        float f14 = f12;
        if ((i12 & 64) != 0) {
            i11 = cartRequestByCartId.chainId;
        }
        return cartRequestByCartId.copy(list, str3, targetAudienceType2, str4, f13, f14, i11);
    }

    @NotNull
    public final List<CartProduct> component1() {
        return this.items;
    }

    @NotNull
    public final String component2() {
        return this.vendorId;
    }

    @NotNull
    public final TargetAudienceType component3() {
        return this.targetAudience;
    }

    @NotNull
    public final String component4() {
        return this.globalEntityId;
    }

    public final float component5() {
        return this.deliveryFee;
    }

    public final float component6() {
        return this.minOrderValue;
    }

    public final int component7() {
        return this.chainId;
    }

    @NotNull
    public final CartRequestByCartId copy(@NotNull List<CartProduct> list, @NotNull @Json(name = "vendor_id") String str, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @NotNull @Json(name = "global_entity_id") String str2, @Json(name = "delivery_fee") float f11, @Json(name = "minimum_order_value") float f12, @Json(name = "chain_id") int i11) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(targetAudienceType, "targetAudience");
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        return new CartRequestByCartId(list, str, targetAudienceType, str2, f11, f12, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartRequestByCartId)) {
            return false;
        }
        CartRequestByCartId cartRequestByCartId = (CartRequestByCartId) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) cartRequestByCartId.items) && Intrinsics.areEqual((Object) this.vendorId, (Object) cartRequestByCartId.vendorId) && this.targetAudience == cartRequestByCartId.targetAudience && Intrinsics.areEqual((Object) this.globalEntityId, (Object) cartRequestByCartId.globalEntityId) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(cartRequestByCartId.deliveryFee)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(cartRequestByCartId.minOrderValue)) && this.chainId == cartRequestByCartId.chainId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @NotNull
    public final List<CartProduct> getItems() {
        return this.items;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final TargetAudienceType getTargetAudience() {
        return this.targetAudience;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        return (((((((((((this.items.hashCode() * 31) + this.vendorId.hashCode()) * 31) + this.targetAudience.hashCode()) * 31) + this.globalEntityId.hashCode()) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.chainId;
    }

    @NotNull
    public String toString() {
        List<CartProduct> list = this.items;
        String str = this.vendorId;
        TargetAudienceType targetAudienceType = this.targetAudience;
        String str2 = this.globalEntityId;
        float f11 = this.deliveryFee;
        float f12 = this.minOrderValue;
        int i11 = this.chainId;
        return "CartRequestByCartId(items=" + list + ", vendorId=" + str + ", targetAudience=" + targetAudienceType + ", globalEntityId=" + str2 + ", deliveryFee=" + f11 + ", minOrderValue=" + f12 + ", chainId=" + i11 + ")";
    }
}
