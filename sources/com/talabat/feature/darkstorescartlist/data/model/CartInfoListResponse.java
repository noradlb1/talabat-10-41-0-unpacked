package com.talabat.feature.darkstorescartlist.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoListResponse;", "", "carts", "", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "(Ljava/util/List;)V", "getCarts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfoListResponse {
    @NotNull
    private final List<CartInfoResponse> carts;

    public CartInfoListResponse(@NotNull @Json(name = "carts") List<CartInfoResponse> list) {
        Intrinsics.checkNotNullParameter(list, "carts");
        this.carts = list;
    }

    public static /* synthetic */ CartInfoListResponse copy$default(CartInfoListResponse cartInfoListResponse, List<CartInfoResponse> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = cartInfoListResponse.carts;
        }
        return cartInfoListResponse.copy(list);
    }

    @NotNull
    public final List<CartInfoResponse> component1() {
        return this.carts;
    }

    @NotNull
    public final CartInfoListResponse copy(@NotNull @Json(name = "carts") List<CartInfoResponse> list) {
        Intrinsics.checkNotNullParameter(list, "carts");
        return new CartInfoListResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CartInfoListResponse) && Intrinsics.areEqual((Object) this.carts, (Object) ((CartInfoListResponse) obj).carts);
    }

    @NotNull
    public final List<CartInfoResponse> getCarts() {
        return this.carts;
    }

    public int hashCode() {
        return this.carts.hashCode();
    }

    @NotNull
    public String toString() {
        List<CartInfoResponse> list = this.carts;
        return "CartInfoListResponse(carts=" + list + ")";
    }
}
