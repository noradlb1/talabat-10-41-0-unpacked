package com.talabat.darkstores.feature.tracking.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/ShopDetails;", "", "categories", "", "Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsCategory;", "swimlanes", "Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsSwimlane;", "(Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getSwimlanes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopDetails {
    @NotNull
    private final List<ShopDetailsCategory> categories;
    @NotNull
    private final List<ShopDetailsSwimlane> swimlanes;

    public ShopDetails(@NotNull List<ShopDetailsCategory> list, @NotNull List<ShopDetailsSwimlane> list2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(list2, "swimlanes");
        this.categories = list;
        this.swimlanes = list2;
    }

    public static /* synthetic */ ShopDetails copy$default(ShopDetails shopDetails, List<ShopDetailsCategory> list, List<ShopDetailsSwimlane> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = shopDetails.categories;
        }
        if ((i11 & 2) != 0) {
            list2 = shopDetails.swimlanes;
        }
        return shopDetails.copy(list, list2);
    }

    @NotNull
    public final List<ShopDetailsCategory> component1() {
        return this.categories;
    }

    @NotNull
    public final List<ShopDetailsSwimlane> component2() {
        return this.swimlanes;
    }

    @NotNull
    public final ShopDetails copy(@NotNull List<ShopDetailsCategory> list, @NotNull List<ShopDetailsSwimlane> list2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(list2, "swimlanes");
        return new ShopDetails(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDetails)) {
            return false;
        }
        ShopDetails shopDetails = (ShopDetails) obj;
        return Intrinsics.areEqual((Object) this.categories, (Object) shopDetails.categories) && Intrinsics.areEqual((Object) this.swimlanes, (Object) shopDetails.swimlanes);
    }

    @NotNull
    public final List<ShopDetailsCategory> getCategories() {
        return this.categories;
    }

    @NotNull
    public final List<ShopDetailsSwimlane> getSwimlanes() {
        return this.swimlanes;
    }

    public int hashCode() {
        return (this.categories.hashCode() * 31) + this.swimlanes.hashCode();
    }

    @NotNull
    public String toString() {
        List<ShopDetailsCategory> list = this.categories;
        List<ShopDetailsSwimlane> list2 = this.swimlanes;
        return "ShopDetails(categories=" + list + ", swimlanes=" + list2 + ")";
    }
}
