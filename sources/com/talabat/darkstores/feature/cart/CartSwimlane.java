package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "", "swimlane", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "viewType", "Lcom/talabat/darkstores/feature/cart/CartSwimlaneViewType;", "(Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;Lcom/talabat/darkstores/feature/cart/CartSwimlaneViewType;)V", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProducts", "()Ljava/util/List;", "getSwimlane", "()Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "title", "", "getTitle", "()Ljava/lang/String;", "getViewType", "()Lcom/talabat/darkstores/feature/cart/CartSwimlaneViewType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSwimlane {
    @NotNull
    private final SwimlaneResponse swimlane;
    @NotNull
    private final CartSwimlaneViewType viewType;

    public CartSwimlane(@NotNull SwimlaneResponse swimlaneResponse, @NotNull CartSwimlaneViewType cartSwimlaneViewType) {
        Intrinsics.checkNotNullParameter(swimlaneResponse, "swimlane");
        Intrinsics.checkNotNullParameter(cartSwimlaneViewType, "viewType");
        this.swimlane = swimlaneResponse;
        this.viewType = cartSwimlaneViewType;
    }

    public static /* synthetic */ CartSwimlane copy$default(CartSwimlane cartSwimlane, SwimlaneResponse swimlaneResponse, CartSwimlaneViewType cartSwimlaneViewType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimlaneResponse = cartSwimlane.swimlane;
        }
        if ((i11 & 2) != 0) {
            cartSwimlaneViewType = cartSwimlane.viewType;
        }
        return cartSwimlane.copy(swimlaneResponse, cartSwimlaneViewType);
    }

    @NotNull
    public final SwimlaneResponse component1() {
        return this.swimlane;
    }

    @NotNull
    public final CartSwimlaneViewType component2() {
        return this.viewType;
    }

    @NotNull
    public final CartSwimlane copy(@NotNull SwimlaneResponse swimlaneResponse, @NotNull CartSwimlaneViewType cartSwimlaneViewType) {
        Intrinsics.checkNotNullParameter(swimlaneResponse, "swimlane");
        Intrinsics.checkNotNullParameter(cartSwimlaneViewType, "viewType");
        return new CartSwimlane(swimlaneResponse, cartSwimlaneViewType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartSwimlane)) {
            return false;
        }
        CartSwimlane cartSwimlane = (CartSwimlane) obj;
        return Intrinsics.areEqual((Object) this.swimlane, (Object) cartSwimlane.swimlane) && this.viewType == cartSwimlane.viewType;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.swimlane.getItems();
    }

    @NotNull
    public final SwimlaneResponse getSwimlane() {
        return this.swimlane;
    }

    @NotNull
    public final String getTitle() {
        return this.swimlane.getHeadline();
    }

    @NotNull
    public final CartSwimlaneViewType getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        return (this.swimlane.hashCode() * 31) + this.viewType.hashCode();
    }

    @NotNull
    public String toString() {
        SwimlaneResponse swimlaneResponse = this.swimlane;
        CartSwimlaneViewType cartSwimlaneViewType = this.viewType;
        return "CartSwimlane(swimlane=" + swimlaneResponse + ", viewType=" + cartSwimlaneViewType + ")";
    }
}
