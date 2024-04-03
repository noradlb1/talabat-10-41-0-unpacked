package com.talabat.darkstores.feature.cart.model;

import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/PostCartData;", "", "cartItems", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "deliveryFee", "", "minOrder", "enableBasketBasedDeliveryFee", "", "(Ljava/util/List;FFZ)V", "getCartItems", "()Ljava/util/List;", "getDeliveryFee", "()F", "getEnableBasketBasedDeliveryFee", "()Z", "getMinOrder", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PostCartData {
    @NotNull
    private final List<Product> cartItems;
    private final float deliveryFee;
    private final boolean enableBasketBasedDeliveryFee;
    private final float minOrder;

    public PostCartData(@NotNull List<Product> list, float f11, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        this.cartItems = list;
        this.deliveryFee = f11;
        this.minOrder = f12;
        this.enableBasketBasedDeliveryFee = z11;
    }

    public static /* synthetic */ PostCartData copy$default(PostCartData postCartData, List<Product> list, float f11, float f12, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = postCartData.cartItems;
        }
        if ((i11 & 2) != 0) {
            f11 = postCartData.deliveryFee;
        }
        if ((i11 & 4) != 0) {
            f12 = postCartData.minOrder;
        }
        if ((i11 & 8) != 0) {
            z11 = postCartData.enableBasketBasedDeliveryFee;
        }
        return postCartData.copy(list, f11, f12, z11);
    }

    @NotNull
    public final List<Product> component1() {
        return this.cartItems;
    }

    public final float component2() {
        return this.deliveryFee;
    }

    public final float component3() {
        return this.minOrder;
    }

    public final boolean component4() {
        return this.enableBasketBasedDeliveryFee;
    }

    @NotNull
    public final PostCartData copy(@NotNull List<Product> list, float f11, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        return new PostCartData(list, f11, f12, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostCartData)) {
            return false;
        }
        PostCartData postCartData = (PostCartData) obj;
        return Intrinsics.areEqual((Object) this.cartItems, (Object) postCartData.cartItems) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(postCartData.deliveryFee)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrder), (Object) Float.valueOf(postCartData.minOrder)) && this.enableBasketBasedDeliveryFee == postCartData.enableBasketBasedDeliveryFee;
    }

    @NotNull
    public final List<Product> getCartItems() {
        return this.cartItems;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    public final boolean getEnableBasketBasedDeliveryFee() {
        return this.enableBasketBasedDeliveryFee;
    }

    public final float getMinOrder() {
        return this.minOrder;
    }

    public int hashCode() {
        int hashCode = ((((this.cartItems.hashCode() * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + Float.floatToIntBits(this.minOrder)) * 31;
        boolean z11 = this.enableBasketBasedDeliveryFee;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<Product> list = this.cartItems;
        float f11 = this.deliveryFee;
        float f12 = this.minOrder;
        boolean z11 = this.enableBasketBasedDeliveryFee;
        return "PostCartData(cartItems=" + list + ", deliveryFee=" + f11 + ", minOrder=" + f12 + ", enableBasketBasedDeliveryFee=" + z11 + ")";
    }
}
