package com.talabat.darkstores.feature.cart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartSectionHeader;", "", "cartSectionType", "Lcom/talabat/darkstores/feature/cart/CartSectionType;", "(Lcom/talabat/darkstores/feature/cart/CartSectionType;)V", "getCartSectionType", "()Lcom/talabat/darkstores/feature/cart/CartSectionType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSectionHeader {
    @NotNull
    private final CartSectionType cartSectionType;

    public CartSectionHeader(@NotNull CartSectionType cartSectionType2) {
        Intrinsics.checkNotNullParameter(cartSectionType2, "cartSectionType");
        this.cartSectionType = cartSectionType2;
    }

    public static /* synthetic */ CartSectionHeader copy$default(CartSectionHeader cartSectionHeader, CartSectionType cartSectionType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cartSectionType2 = cartSectionHeader.cartSectionType;
        }
        return cartSectionHeader.copy(cartSectionType2);
    }

    @NotNull
    public final CartSectionType component1() {
        return this.cartSectionType;
    }

    @NotNull
    public final CartSectionHeader copy(@NotNull CartSectionType cartSectionType2) {
        Intrinsics.checkNotNullParameter(cartSectionType2, "cartSectionType");
        return new CartSectionHeader(cartSectionType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CartSectionHeader) && this.cartSectionType == ((CartSectionHeader) obj).cartSectionType;
    }

    @NotNull
    public final CartSectionType getCartSectionType() {
        return this.cartSectionType;
    }

    public int hashCode() {
        return this.cartSectionType.hashCode();
    }

    @NotNull
    public String toString() {
        CartSectionType cartSectionType2 = this.cartSectionType;
        return "CartSectionHeader(cartSectionType=" + cartSectionType2 + ")";
    }
}
