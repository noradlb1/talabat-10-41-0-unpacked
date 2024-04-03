package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.visa.checkout.PurchaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductSwimlanes;", "", "items", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "requestId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getRequestId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductSwimlanes {
    @NotNull
    private final List<Item> items;
    @NotNull
    private final String requestId;

    public ProductSwimlanes(@NotNull List<Item> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        this.items = list;
        this.requestId = str;
    }

    public static /* synthetic */ ProductSwimlanes copy$default(ProductSwimlanes productSwimlanes, List<Item> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = productSwimlanes.items;
        }
        if ((i11 & 2) != 0) {
            str = productSwimlanes.requestId;
        }
        return productSwimlanes.copy(list, str);
    }

    @NotNull
    public final List<Item> component1() {
        return this.items;
    }

    @NotNull
    public final String component2() {
        return this.requestId;
    }

    @NotNull
    public final ProductSwimlanes copy(@NotNull List<Item> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        return new ProductSwimlanes(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductSwimlanes)) {
            return false;
        }
        ProductSwimlanes productSwimlanes = (ProductSwimlanes) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) productSwimlanes.items) && Intrinsics.areEqual((Object) this.requestId, (Object) productSwimlanes.requestId);
    }

    @NotNull
    public final List<Item> getItems() {
        return this.items;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.requestId.hashCode();
    }

    @NotNull
    public String toString() {
        List<Item> list = this.items;
        String str = this.requestId;
        return "ProductSwimlanes(items=" + list + ", requestId=" + str + ")";
    }
}
