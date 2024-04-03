package com.talabat.feature.darkstorescartlist.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "", "cartId", "", "itemCount", "", "totalPrice", "", "globalVendorId", "restaurant", "Ldatamodels/Restaurant;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ldatamodels/Restaurant;)V", "getCartId", "()Ljava/lang/String;", "getGlobalVendorId", "getItemCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRestaurant", "()Ldatamodels/Restaurant;", "getTotalPrice", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ldatamodels/Restaurant;)Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfoResponse {
    @Nullable
    private final String cartId;
    @Nullable
    private final String globalVendorId;
    @Nullable
    private final Integer itemCount;
    @Nullable
    private final Restaurant restaurant;
    @Nullable
    private final Float totalPrice;

    public CartInfoResponse(@Nullable @Json(name = "cart_id") String str, @Nullable @Json(name = "item_count") Integer num, @Nullable @Json(name = "total_price") Float f11, @Nullable @Json(name = "global_vendor_id") String str2, @Nullable @Json(name = "vendor") Restaurant restaurant2) {
        this.cartId = str;
        this.itemCount = num;
        this.totalPrice = f11;
        this.globalVendorId = str2;
        this.restaurant = restaurant2;
    }

    public static /* synthetic */ CartInfoResponse copy$default(CartInfoResponse cartInfoResponse, String str, Integer num, Float f11, String str2, Restaurant restaurant2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartInfoResponse.cartId;
        }
        if ((i11 & 2) != 0) {
            num = cartInfoResponse.itemCount;
        }
        Integer num2 = num;
        if ((i11 & 4) != 0) {
            f11 = cartInfoResponse.totalPrice;
        }
        Float f12 = f11;
        if ((i11 & 8) != 0) {
            str2 = cartInfoResponse.globalVendorId;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            restaurant2 = cartInfoResponse.restaurant;
        }
        return cartInfoResponse.copy(str, num2, f12, str3, restaurant2);
    }

    @Nullable
    public final String component1() {
        return this.cartId;
    }

    @Nullable
    public final Integer component2() {
        return this.itemCount;
    }

    @Nullable
    public final Float component3() {
        return this.totalPrice;
    }

    @Nullable
    public final String component4() {
        return this.globalVendorId;
    }

    @Nullable
    public final Restaurant component5() {
        return this.restaurant;
    }

    @NotNull
    public final CartInfoResponse copy(@Nullable @Json(name = "cart_id") String str, @Nullable @Json(name = "item_count") Integer num, @Nullable @Json(name = "total_price") Float f11, @Nullable @Json(name = "global_vendor_id") String str2, @Nullable @Json(name = "vendor") Restaurant restaurant2) {
        return new CartInfoResponse(str, num, f11, str2, restaurant2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartInfoResponse)) {
            return false;
        }
        CartInfoResponse cartInfoResponse = (CartInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) cartInfoResponse.cartId) && Intrinsics.areEqual((Object) this.itemCount, (Object) cartInfoResponse.itemCount) && Intrinsics.areEqual((Object) this.totalPrice, (Object) cartInfoResponse.totalPrice) && Intrinsics.areEqual((Object) this.globalVendorId, (Object) cartInfoResponse.globalVendorId) && Intrinsics.areEqual((Object) this.restaurant, (Object) cartInfoResponse.restaurant);
    }

    @Nullable
    public final String getCartId() {
        return this.cartId;
    }

    @Nullable
    public final String getGlobalVendorId() {
        return this.globalVendorId;
    }

    @Nullable
    public final Integer getItemCount() {
        return this.itemCount;
    }

    @Nullable
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    @Nullable
    public final Float getTotalPrice() {
        return this.totalPrice;
    }

    public int hashCode() {
        String str = this.cartId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.itemCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f11 = this.totalPrice;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str2 = this.globalVendorId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            i11 = restaurant2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.cartId;
        Integer num = this.itemCount;
        Float f11 = this.totalPrice;
        String str2 = this.globalVendorId;
        Restaurant restaurant2 = this.restaurant;
        return "CartInfoResponse(cartId=" + str + ", itemCount=" + num + ", totalPrice=" + f11 + ", globalVendorId=" + str2 + ", restaurant=" + restaurant2 + ")";
    }
}
