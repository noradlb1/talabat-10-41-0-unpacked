package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "", "productIds", "", "", "categoryIds", "skuIds", "excludeCategories", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)V", "getCategoryIds", "()Ljava/util/List;", "getExcludeCategories", "()Z", "getProductIds", "getSkuIds", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Bounds {
    @NotNull
    private final List<String> categoryIds;
    private final boolean excludeCategories;
    @NotNull
    private final List<String> productIds;
    @NotNull
    private final List<String> skuIds;

    public Bounds() {
        this((List) null, (List) null, (List) null, false, 15, (DefaultConstructorMarker) null);
    }

    public Bounds(@NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(list2, "categoryIds");
        Intrinsics.checkNotNullParameter(list3, "skuIds");
        this.productIds = list;
        this.categoryIds = list2;
        this.skuIds = list3;
        this.excludeCategories = z11;
    }

    public static /* synthetic */ Bounds copy$default(Bounds bounds, List<String> list, List<String> list2, List<String> list3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = bounds.productIds;
        }
        if ((i11 & 2) != 0) {
            list2 = bounds.categoryIds;
        }
        if ((i11 & 4) != 0) {
            list3 = bounds.skuIds;
        }
        if ((i11 & 8) != 0) {
            z11 = bounds.excludeCategories;
        }
        return bounds.copy(list, list2, list3, z11);
    }

    @NotNull
    public final List<String> component1() {
        return this.productIds;
    }

    @NotNull
    public final List<String> component2() {
        return this.categoryIds;
    }

    @NotNull
    public final List<String> component3() {
        return this.skuIds;
    }

    public final boolean component4() {
        return this.excludeCategories;
    }

    @NotNull
    public final Bounds copy(@NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(list2, "categoryIds");
        Intrinsics.checkNotNullParameter(list3, "skuIds");
        return new Bounds(list, list2, list3, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bounds)) {
            return false;
        }
        Bounds bounds = (Bounds) obj;
        return Intrinsics.areEqual((Object) this.productIds, (Object) bounds.productIds) && Intrinsics.areEqual((Object) this.categoryIds, (Object) bounds.categoryIds) && Intrinsics.areEqual((Object) this.skuIds, (Object) bounds.skuIds) && this.excludeCategories == bounds.excludeCategories;
    }

    @NotNull
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    public final boolean getExcludeCategories() {
        return this.excludeCategories;
    }

    @NotNull
    public final List<String> getProductIds() {
        return this.productIds;
    }

    @NotNull
    public final List<String> getSkuIds() {
        return this.skuIds;
    }

    public int hashCode() {
        int hashCode = ((((this.productIds.hashCode() * 31) + this.categoryIds.hashCode()) * 31) + this.skuIds.hashCode()) * 31;
        boolean z11 = this.excludeCategories;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<String> list = this.productIds;
        List<String> list2 = this.categoryIds;
        List<String> list3 = this.skuIds;
        boolean z11 = this.excludeCategories;
        return "Bounds(productIds=" + list + ", categoryIds=" + list2 + ", skuIds=" + list3 + ", excludeCategories=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Bounds(List list, List list2, List list3, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i11 & 8) != 0 ? false : z11);
    }
}
