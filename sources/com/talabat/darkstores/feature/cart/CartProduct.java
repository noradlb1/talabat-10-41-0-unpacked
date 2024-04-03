package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartProduct;", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "isCampaignFulfilled", "", "isOOS", "showAlerts", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ZZZ)V", "()Z", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getShowAlerts", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartProduct {
    private final boolean isCampaignFulfilled;
    private final boolean isOOS;
    @NotNull
    private final Product product;
    private final boolean showAlerts;

    public CartProduct(@NotNull Product product2, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(product2, "product");
        this.product = product2;
        this.isCampaignFulfilled = z11;
        this.isOOS = z12;
        this.showAlerts = z13;
    }

    public static /* synthetic */ CartProduct copy$default(CartProduct cartProduct, Product product2, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            product2 = cartProduct.product;
        }
        if ((i11 & 2) != 0) {
            z11 = cartProduct.isCampaignFulfilled;
        }
        if ((i11 & 4) != 0) {
            z12 = cartProduct.isOOS;
        }
        if ((i11 & 8) != 0) {
            z13 = cartProduct.showAlerts;
        }
        return cartProduct.copy(product2, z11, z12, z13);
    }

    @NotNull
    public final Product component1() {
        return this.product;
    }

    public final boolean component2() {
        return this.isCampaignFulfilled;
    }

    public final boolean component3() {
        return this.isOOS;
    }

    public final boolean component4() {
        return this.showAlerts;
    }

    @NotNull
    public final CartProduct copy(@NotNull Product product2, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(product2, "product");
        return new CartProduct(product2, z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartProduct)) {
            return false;
        }
        CartProduct cartProduct = (CartProduct) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) cartProduct.product) && this.isCampaignFulfilled == cartProduct.isCampaignFulfilled && this.isOOS == cartProduct.isOOS && this.showAlerts == cartProduct.showAlerts;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    public final boolean getShowAlerts() {
        return this.showAlerts;
    }

    public int hashCode() {
        int hashCode = this.product.hashCode() * 31;
        boolean z11 = this.isCampaignFulfilled;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isOOS;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.showAlerts;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    public final boolean isCampaignFulfilled() {
        return this.isCampaignFulfilled;
    }

    public final boolean isOOS() {
        return this.isOOS;
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        boolean z11 = this.isCampaignFulfilled;
        boolean z12 = this.isOOS;
        boolean z13 = this.showAlerts;
        return "CartProduct(product=" + product2 + ", isCampaignFulfilled=" + z11 + ", isOOS=" + z12 + ", showAlerts=" + z13 + ")";
    }
}
