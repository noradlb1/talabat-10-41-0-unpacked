package com.talabat.darkstores.feature.categories.subcategories;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesData;", "", "headlines", "", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "subcategoryItems", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "(Ljava/util/List;Ljava/util/List;)V", "getHeadlines", "()Ljava/util/List;", "getSubcategoryItems", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesData {
    @NotNull
    private final List<SubcategoryHeadline> headlines;
    @NotNull
    private final List<SubcategoryItem> subcategoryItems;

    public SubcategoriesData(@NotNull List<SubcategoryHeadline> list, @NotNull List<? extends SubcategoryItem> list2) {
        Intrinsics.checkNotNullParameter(list, "headlines");
        Intrinsics.checkNotNullParameter(list2, "subcategoryItems");
        this.headlines = list;
        this.subcategoryItems = list2;
    }

    public static /* synthetic */ SubcategoriesData copy$default(SubcategoriesData subcategoriesData, List<SubcategoryHeadline> list, List<SubcategoryItem> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = subcategoriesData.headlines;
        }
        if ((i11 & 2) != 0) {
            list2 = subcategoriesData.subcategoryItems;
        }
        return subcategoriesData.copy(list, list2);
    }

    @NotNull
    public final List<SubcategoryHeadline> component1() {
        return this.headlines;
    }

    @NotNull
    public final List<SubcategoryItem> component2() {
        return this.subcategoryItems;
    }

    @NotNull
    public final SubcategoriesData copy(@NotNull List<SubcategoryHeadline> list, @NotNull List<? extends SubcategoryItem> list2) {
        Intrinsics.checkNotNullParameter(list, "headlines");
        Intrinsics.checkNotNullParameter(list2, "subcategoryItems");
        return new SubcategoriesData(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubcategoriesData)) {
            return false;
        }
        SubcategoriesData subcategoriesData = (SubcategoriesData) obj;
        return Intrinsics.areEqual((Object) this.headlines, (Object) subcategoriesData.headlines) && Intrinsics.areEqual((Object) this.subcategoryItems, (Object) subcategoriesData.subcategoryItems);
    }

    @NotNull
    public final List<SubcategoryHeadline> getHeadlines() {
        return this.headlines;
    }

    @NotNull
    public final List<SubcategoryItem> getSubcategoryItems() {
        return this.subcategoryItems;
    }

    public int hashCode() {
        return (this.headlines.hashCode() * 31) + this.subcategoryItems.hashCode();
    }

    @NotNull
    public String toString() {
        List<SubcategoryHeadline> list = this.headlines;
        List<SubcategoryItem> list2 = this.subcategoryItems;
        return "SubcategoriesData(headlines=" + list + ", subcategoryItems=" + list2 + ")";
    }
}
