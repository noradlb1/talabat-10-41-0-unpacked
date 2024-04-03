package com.talabat.darkstores.feature.cart.multibasket;

import com.talabat.darkstores.domain.model.ProductsHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/feature/cart/multibasket/Cart;", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "cartId", "", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Ljava/lang/String;Ljava/util/List;)V", "getCartId", "()Ljava/lang/String;", "getProducts", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "withProducts", "newProducts", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cart implements ProductsHolder<Cart> {
    @Nullable
    private final String cartId;
    @NotNull
    private final List<Product> products;

    public Cart(@Nullable String str, @NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "products");
        this.cartId = str;
        this.products = list;
    }

    public static /* synthetic */ Cart copy$default(Cart cart, String str, List<Product> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cart.cartId;
        }
        if ((i11 & 2) != 0) {
            list = cart.getProducts();
        }
        return cart.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.cartId;
    }

    @NotNull
    public final List<Product> component2() {
        return getProducts();
    }

    @NotNull
    public final Cart copy(@Nullable String str, @NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "products");
        return new Cart(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) cart.cartId) && Intrinsics.areEqual((Object) getProducts(), (Object) cart.getProducts());
    }

    @Nullable
    public final String getCartId() {
        return this.cartId;
    }

    @NotNull
    public List<Product> getProducts() {
        return this.products;
    }

    public int hashCode() {
        String str = this.cartId;
        return ((str == null ? 0 : str.hashCode()) * 31) + getProducts().hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cartId;
        List<Product> products2 = getProducts();
        return "Cart(cartId=" + str + ", products=" + products2 + ")";
    }

    @NotNull
    public Cart withProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "newProducts");
        return copy$default(this, (String) null, list, 1, (Object) null);
    }
}
