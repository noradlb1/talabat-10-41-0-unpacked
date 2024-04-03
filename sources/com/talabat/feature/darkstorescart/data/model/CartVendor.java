package com.talabat.feature.darkstorescart.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "", "globalId", "", "branchId", "name", "restaurantJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getGlobalId", "getName", "getRestaurantJson", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartVendor {
    @NotNull
    private final String branchId;
    @NotNull
    private final String globalId;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58490name;
    @NotNull
    private final String restaurantJson;

    public CartVendor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "restaurantJson");
        this.globalId = str;
        this.branchId = str2;
        this.f58490name = str3;
        this.restaurantJson = str4;
    }

    public static /* synthetic */ CartVendor copy$default(CartVendor cartVendor, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartVendor.globalId;
        }
        if ((i11 & 2) != 0) {
            str2 = cartVendor.branchId;
        }
        if ((i11 & 4) != 0) {
            str3 = cartVendor.f58490name;
        }
        if ((i11 & 8) != 0) {
            str4 = cartVendor.restaurantJson;
        }
        return cartVendor.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.globalId;
    }

    @NotNull
    public final String component2() {
        return this.branchId;
    }

    @NotNull
    public final String component3() {
        return this.f58490name;
    }

    @NotNull
    public final String component4() {
        return this.restaurantJson;
    }

    @NotNull
    public final CartVendor copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "restaurantJson");
        return new CartVendor(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartVendor)) {
            return false;
        }
        CartVendor cartVendor = (CartVendor) obj;
        return Intrinsics.areEqual((Object) this.globalId, (Object) cartVendor.globalId) && Intrinsics.areEqual((Object) this.branchId, (Object) cartVendor.branchId) && Intrinsics.areEqual((Object) this.f58490name, (Object) cartVendor.f58490name) && Intrinsics.areEqual((Object) this.restaurantJson, (Object) cartVendor.restaurantJson);
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getGlobalId() {
        return this.globalId;
    }

    @NotNull
    public final String getName() {
        return this.f58490name;
    }

    @NotNull
    public final String getRestaurantJson() {
        return this.restaurantJson;
    }

    public int hashCode() {
        return (((((this.globalId.hashCode() * 31) + this.branchId.hashCode()) * 31) + this.f58490name.hashCode()) * 31) + this.restaurantJson.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.globalId;
        String str2 = this.branchId;
        String str3 = this.f58490name;
        String str4 = this.restaurantJson;
        return "CartVendor(globalId=" + str + ", branchId=" + str2 + ", name=" + str3 + ", restaurantJson=" + str4 + ")";
    }
}
