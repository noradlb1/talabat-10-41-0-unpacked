package com.talabat.feature.darkstorescartlist.domain.model;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/model/CartInfo;", "", "cartId", "", "itemCount", "", "totalPrice", "", "globalVendorId", "restaurant", "Ldatamodels/Restaurant;", "(Ljava/lang/String;IFLjava/lang/String;Ldatamodels/Restaurant;)V", "getCartId", "()Ljava/lang/String;", "getGlobalVendorId", "getItemCount", "()I", "getRestaurant", "()Ldatamodels/Restaurant;", "getTotalPrice", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfo {
    @NotNull
    private final String cartId;
    @NotNull
    private final String globalVendorId;
    private final int itemCount;
    @NotNull
    private final Restaurant restaurant;
    private final float totalPrice;

    public CartInfo(@NotNull String str, int i11, float f11, @NotNull String str2, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "globalVendorId");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        this.cartId = str;
        this.itemCount = i11;
        this.totalPrice = f11;
        this.globalVendorId = str2;
        this.restaurant = restaurant2;
    }

    public static /* synthetic */ CartInfo copy$default(CartInfo cartInfo, String str, int i11, float f11, String str2, Restaurant restaurant2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = cartInfo.cartId;
        }
        if ((i12 & 2) != 0) {
            i11 = cartInfo.itemCount;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            f11 = cartInfo.totalPrice;
        }
        float f12 = f11;
        if ((i12 & 8) != 0) {
            str2 = cartInfo.globalVendorId;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            restaurant2 = cartInfo.restaurant;
        }
        return cartInfo.copy(str, i13, f12, str3, restaurant2);
    }

    @NotNull
    public final String component1() {
        return this.cartId;
    }

    public final int component2() {
        return this.itemCount;
    }

    public final float component3() {
        return this.totalPrice;
    }

    @NotNull
    public final String component4() {
        return this.globalVendorId;
    }

    @NotNull
    public final Restaurant component5() {
        return this.restaurant;
    }

    @NotNull
    public final CartInfo copy(@NotNull String str, int i11, float f11, @NotNull String str2, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "globalVendorId");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        return new CartInfo(str, i11, f11, str2, restaurant2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartInfo)) {
            return false;
        }
        CartInfo cartInfo = (CartInfo) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) cartInfo.cartId) && this.itemCount == cartInfo.itemCount && Intrinsics.areEqual((Object) Float.valueOf(this.totalPrice), (Object) Float.valueOf(cartInfo.totalPrice)) && Intrinsics.areEqual((Object) this.globalVendorId, (Object) cartInfo.globalVendorId) && Intrinsics.areEqual((Object) this.restaurant, (Object) cartInfo.restaurant);
    }

    @NotNull
    public final String getCartId() {
        return this.cartId;
    }

    @NotNull
    public final String getGlobalVendorId() {
        return this.globalVendorId;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    @NotNull
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    public final float getTotalPrice() {
        return this.totalPrice;
    }

    public int hashCode() {
        return (((((((this.cartId.hashCode() * 31) + this.itemCount) * 31) + Float.floatToIntBits(this.totalPrice)) * 31) + this.globalVendorId.hashCode()) * 31) + this.restaurant.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cartId;
        int i11 = this.itemCount;
        float f11 = this.totalPrice;
        String str2 = this.globalVendorId;
        Restaurant restaurant2 = this.restaurant;
        return "CartInfo(cartId=" + str + ", itemCount=" + i11 + ", totalPrice=" + f11 + ", globalVendorId=" + str2 + ", restaurant=" + restaurant2 + ")";
    }
}
