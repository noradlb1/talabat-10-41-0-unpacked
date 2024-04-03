package com.talabat.darkstores.common.view;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/common/view/ProductState;", "", "quantity", "", "isRemove", "", "isSetUp", "(IZZ)V", "()Z", "getQuantity", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ProductState {
    private final boolean isRemove;
    private final boolean isSetUp;
    private final int quantity;

    public ProductState(int i11, boolean z11, boolean z12) {
        this.quantity = i11;
        this.isRemove = z11;
        this.isSetUp = z12;
    }

    public static /* synthetic */ ProductState copy$default(ProductState productState, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = productState.quantity;
        }
        if ((i12 & 2) != 0) {
            z11 = productState.isRemove;
        }
        if ((i12 & 4) != 0) {
            z12 = productState.isSetUp;
        }
        return productState.copy(i11, z11, z12);
    }

    public final int component1() {
        return this.quantity;
    }

    public final boolean component2() {
        return this.isRemove;
    }

    public final boolean component3() {
        return this.isSetUp;
    }

    @NotNull
    public final ProductState copy(int i11, boolean z11, boolean z12) {
        return new ProductState(i11, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductState)) {
            return false;
        }
        ProductState productState = (ProductState) obj;
        return this.quantity == productState.quantity && this.isRemove == productState.isRemove && this.isSetUp == productState.isSetUp;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        int i11 = this.quantity * 31;
        boolean z11 = this.isRemove;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isSetUp;
        if (!z13) {
            z12 = z13;
        }
        return i12 + (z12 ? 1 : 0);
    }

    public final boolean isRemove() {
        return this.isRemove;
    }

    public final boolean isSetUp() {
        return this.isSetUp;
    }

    @NotNull
    public String toString() {
        int i11 = this.quantity;
        boolean z11 = this.isRemove;
        boolean z12 = this.isSetUp;
        return "ProductState(quantity=" + i11 + ", isRemove=" + z11 + ", isSetUp=" + z12 + ")";
    }
}
