package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\u001c\u0010\u0002\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0015\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\u001e\b\u0002\u0010\u0002\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R'\u0010\u0002\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "", "cartProductsWithSummary", "Lkotlin/Pair;", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lcom/talabat/darkstores/feature/cart/CartSummary;", "Lcom/talabat/darkstores/feature/cart/CartProductsWithSummary;", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "enableCheckout", "", "isBasketDeliveryFreeTierEnabled", "isServiceFreeDescriptionFixEnabled", "(Lkotlin/Pair;Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;ZZZ)V", "getCartProductsWithSummary", "()Lkotlin/Pair;", "getEnableCheckout", "()Z", "getVendor", "()Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentData {
    @NotNull
    private final Pair<List<Product>, CartSummary> cartProductsWithSummary;
    private final boolean enableCheckout;
    private final boolean isBasketDeliveryFreeTierEnabled;
    private final boolean isServiceFreeDescriptionFixEnabled;
    @NotNull
    private final Vendor vendor;

    public CartFragmentData(@NotNull Pair<? extends List<Product>, CartSummary> pair, @NotNull Vendor vendor2, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(pair, "cartProductsWithSummary");
        Intrinsics.checkNotNullParameter(vendor2, "vendor");
        this.cartProductsWithSummary = pair;
        this.vendor = vendor2;
        this.enableCheckout = z11;
        this.isBasketDeliveryFreeTierEnabled = z12;
        this.isServiceFreeDescriptionFixEnabled = z13;
    }

    public static /* synthetic */ CartFragmentData copy$default(CartFragmentData cartFragmentData, Pair<List<Product>, CartSummary> pair, Vendor vendor2, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pair = cartFragmentData.cartProductsWithSummary;
        }
        if ((i11 & 2) != 0) {
            vendor2 = cartFragmentData.vendor;
        }
        Vendor vendor3 = vendor2;
        if ((i11 & 4) != 0) {
            z11 = cartFragmentData.enableCheckout;
        }
        boolean z14 = z11;
        if ((i11 & 8) != 0) {
            z12 = cartFragmentData.isBasketDeliveryFreeTierEnabled;
        }
        boolean z15 = z12;
        if ((i11 & 16) != 0) {
            z13 = cartFragmentData.isServiceFreeDescriptionFixEnabled;
        }
        return cartFragmentData.copy(pair, vendor3, z14, z15, z13);
    }

    @NotNull
    public final Pair<List<Product>, CartSummary> component1() {
        return this.cartProductsWithSummary;
    }

    @NotNull
    public final Vendor component2() {
        return this.vendor;
    }

    public final boolean component3() {
        return this.enableCheckout;
    }

    public final boolean component4() {
        return this.isBasketDeliveryFreeTierEnabled;
    }

    public final boolean component5() {
        return this.isServiceFreeDescriptionFixEnabled;
    }

    @NotNull
    public final CartFragmentData copy(@NotNull Pair<? extends List<Product>, CartSummary> pair, @NotNull Vendor vendor2, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(pair, "cartProductsWithSummary");
        Intrinsics.checkNotNullParameter(vendor2, "vendor");
        return new CartFragmentData(pair, vendor2, z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartFragmentData)) {
            return false;
        }
        CartFragmentData cartFragmentData = (CartFragmentData) obj;
        return Intrinsics.areEqual((Object) this.cartProductsWithSummary, (Object) cartFragmentData.cartProductsWithSummary) && Intrinsics.areEqual((Object) this.vendor, (Object) cartFragmentData.vendor) && this.enableCheckout == cartFragmentData.enableCheckout && this.isBasketDeliveryFreeTierEnabled == cartFragmentData.isBasketDeliveryFreeTierEnabled && this.isServiceFreeDescriptionFixEnabled == cartFragmentData.isServiceFreeDescriptionFixEnabled;
    }

    @NotNull
    public final Pair<List<Product>, CartSummary> getCartProductsWithSummary() {
        return this.cartProductsWithSummary;
    }

    public final boolean getEnableCheckout() {
        return this.enableCheckout;
    }

    @NotNull
    public final Vendor getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        int hashCode = ((this.cartProductsWithSummary.hashCode() * 31) + this.vendor.hashCode()) * 31;
        boolean z11 = this.enableCheckout;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isBasketDeliveryFreeTierEnabled;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isServiceFreeDescriptionFixEnabled;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    public final boolean isBasketDeliveryFreeTierEnabled() {
        return this.isBasketDeliveryFreeTierEnabled;
    }

    public final boolean isServiceFreeDescriptionFixEnabled() {
        return this.isServiceFreeDescriptionFixEnabled;
    }

    @NotNull
    public String toString() {
        Pair<List<Product>, CartSummary> pair = this.cartProductsWithSummary;
        Vendor vendor2 = this.vendor;
        boolean z11 = this.enableCheckout;
        boolean z12 = this.isBasketDeliveryFreeTierEnabled;
        boolean z13 = this.isServiceFreeDescriptionFixEnabled;
        return "CartFragmentData(cartProductsWithSummary=" + pair + ", vendor=" + vendor2 + ", enableCheckout=" + z11 + ", isBasketDeliveryFreeTierEnabled=" + z12 + ", isServiceFreeDescriptionFixEnabled=" + z13 + ")";
    }
}
