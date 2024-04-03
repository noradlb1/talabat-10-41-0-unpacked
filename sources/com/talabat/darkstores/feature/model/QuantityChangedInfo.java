package com.talabat.darkstores.feature.model;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\bHÆ\u0003J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/darkstores/feature/model/QuantityChangedInfo;", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "", "listPosition", "wasAdded", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Z)V", "getListPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getQuantity", "()I", "getWasAdded", "()Z", "component1", "component2", "component3", "component4", "copy", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Z)Lcom/talabat/darkstores/feature/model/QuantityChangedInfo;", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuantityChangedInfo {
    @Nullable
    private final Integer listPosition;
    @NotNull
    private final Product product;
    private final int quantity;
    private final boolean wasAdded;

    public QuantityChangedInfo(@NotNull Product product2, int i11, @Nullable Integer num, boolean z11) {
        Intrinsics.checkNotNullParameter(product2, "product");
        this.product = product2;
        this.quantity = i11;
        this.listPosition = num;
        this.wasAdded = z11;
    }

    public static /* synthetic */ QuantityChangedInfo copy$default(QuantityChangedInfo quantityChangedInfo, Product product2, int i11, Integer num, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            product2 = quantityChangedInfo.product;
        }
        if ((i12 & 2) != 0) {
            i11 = quantityChangedInfo.quantity;
        }
        if ((i12 & 4) != 0) {
            num = quantityChangedInfo.listPosition;
        }
        if ((i12 & 8) != 0) {
            z11 = quantityChangedInfo.wasAdded;
        }
        return quantityChangedInfo.copy(product2, i11, num, z11);
    }

    @NotNull
    public final Product component1() {
        return this.product;
    }

    public final int component2() {
        return this.quantity;
    }

    @Nullable
    public final Integer component3() {
        return this.listPosition;
    }

    public final boolean component4() {
        return this.wasAdded;
    }

    @NotNull
    public final QuantityChangedInfo copy(@NotNull Product product2, int i11, @Nullable Integer num, boolean z11) {
        Intrinsics.checkNotNullParameter(product2, "product");
        return new QuantityChangedInfo(product2, i11, num, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuantityChangedInfo)) {
            return false;
        }
        QuantityChangedInfo quantityChangedInfo = (QuantityChangedInfo) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) quantityChangedInfo.product) && this.quantity == quantityChangedInfo.quantity && Intrinsics.areEqual((Object) this.listPosition, (Object) quantityChangedInfo.listPosition) && this.wasAdded == quantityChangedInfo.wasAdded;
    }

    @Nullable
    public final Integer getListPosition() {
        return this.listPosition;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final boolean getWasAdded() {
        return this.wasAdded;
    }

    public int hashCode() {
        int hashCode = ((this.product.hashCode() * 31) + this.quantity) * 31;
        Integer num = this.listPosition;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        boolean z11 = this.wasAdded;
        if (z11) {
            z11 = true;
        }
        return hashCode2 + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        int i11 = this.quantity;
        Integer num = this.listPosition;
        boolean z11 = this.wasAdded;
        return "QuantityChangedInfo(product=" + product2 + ", quantity=" + i11 + ", listPosition=" + num + ", wasAdded=" + z11 + ")";
    }
}
