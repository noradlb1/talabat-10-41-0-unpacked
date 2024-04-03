package com.talabat.feature.darkstorescart.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartInfo;", "", "cartId", "", "globalVendorId", "vendorName", "branchId", "restaurantJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getCartId", "getGlobalVendorId", "getRestaurantJson", "getVendorName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Entity
public final class CartInfo {
    @NotNull
    private final String branchId;
    @NotNull
    @PrimaryKey
    private final String cartId;
    @NotNull
    private final String globalVendorId;
    @NotNull
    private final String restaurantJson;
    @NotNull
    private final String vendorName;

    public CartInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "globalVendorId");
        Intrinsics.checkNotNullParameter(str3, "vendorName");
        Intrinsics.checkNotNullParameter(str4, "branchId");
        Intrinsics.checkNotNullParameter(str5, "restaurantJson");
        this.cartId = str;
        this.globalVendorId = str2;
        this.vendorName = str3;
        this.branchId = str4;
        this.restaurantJson = str5;
    }

    public static /* synthetic */ CartInfo copy$default(CartInfo cartInfo, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartInfo.cartId;
        }
        if ((i11 & 2) != 0) {
            str2 = cartInfo.globalVendorId;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = cartInfo.vendorName;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = cartInfo.branchId;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = cartInfo.restaurantJson;
        }
        return cartInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.cartId;
    }

    @NotNull
    public final String component2() {
        return this.globalVendorId;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    @NotNull
    public final String component4() {
        return this.branchId;
    }

    @NotNull
    public final String component5() {
        return this.restaurantJson;
    }

    @NotNull
    public final CartInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "globalVendorId");
        Intrinsics.checkNotNullParameter(str3, "vendorName");
        Intrinsics.checkNotNullParameter(str4, "branchId");
        Intrinsics.checkNotNullParameter(str5, "restaurantJson");
        return new CartInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartInfo)) {
            return false;
        }
        CartInfo cartInfo = (CartInfo) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) cartInfo.cartId) && Intrinsics.areEqual((Object) this.globalVendorId, (Object) cartInfo.globalVendorId) && Intrinsics.areEqual((Object) this.vendorName, (Object) cartInfo.vendorName) && Intrinsics.areEqual((Object) this.branchId, (Object) cartInfo.branchId) && Intrinsics.areEqual((Object) this.restaurantJson, (Object) cartInfo.restaurantJson);
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getCartId() {
        return this.cartId;
    }

    @NotNull
    public final String getGlobalVendorId() {
        return this.globalVendorId;
    }

    @NotNull
    public final String getRestaurantJson() {
        return this.restaurantJson;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        return (((((((this.cartId.hashCode() * 31) + this.globalVendorId.hashCode()) * 31) + this.vendorName.hashCode()) * 31) + this.branchId.hashCode()) * 31) + this.restaurantJson.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cartId;
        String str2 = this.globalVendorId;
        String str3 = this.vendorName;
        String str4 = this.branchId;
        String str5 = this.restaurantJson;
        return "CartInfo(cartId=" + str + ", globalVendorId=" + str2 + ", vendorName=" + str3 + ", branchId=" + str4 + ", restaurantJson=" + str5 + ")";
    }
}
