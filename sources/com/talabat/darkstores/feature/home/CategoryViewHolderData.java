package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.model.Category;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoryViewHolderData;", "", "topTwoCategories", "", "Lcom/talabat/darkstores/model/Category;", "categories", "(Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getTopTwoCategories", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryViewHolderData {
    @NotNull
    private final List<Category> categories;
    @NotNull
    private final List<Category> topTwoCategories;

    public CategoryViewHolderData(@NotNull List<Category> list, @NotNull List<Category> list2) {
        Intrinsics.checkNotNullParameter(list, "topTwoCategories");
        Intrinsics.checkNotNullParameter(list2, "categories");
        this.topTwoCategories = list;
        this.categories = list2;
    }

    public static /* synthetic */ CategoryViewHolderData copy$default(CategoryViewHolderData categoryViewHolderData, List<Category> list, List<Category> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = categoryViewHolderData.topTwoCategories;
        }
        if ((i11 & 2) != 0) {
            list2 = categoryViewHolderData.categories;
        }
        return categoryViewHolderData.copy(list, list2);
    }

    @NotNull
    public final List<Category> component1() {
        return this.topTwoCategories;
    }

    @NotNull
    public final List<Category> component2() {
        return this.categories;
    }

    @NotNull
    public final CategoryViewHolderData copy(@NotNull List<Category> list, @NotNull List<Category> list2) {
        Intrinsics.checkNotNullParameter(list, "topTwoCategories");
        Intrinsics.checkNotNullParameter(list2, "categories");
        return new CategoryViewHolderData(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryViewHolderData)) {
            return false;
        }
        CategoryViewHolderData categoryViewHolderData = (CategoryViewHolderData) obj;
        return Intrinsics.areEqual((Object) this.topTwoCategories, (Object) categoryViewHolderData.topTwoCategories) && Intrinsics.areEqual((Object) this.categories, (Object) categoryViewHolderData.categories);
    }

    @NotNull
    public final List<Category> getCategories() {
        return this.categories;
    }

    @NotNull
    public final List<Category> getTopTwoCategories() {
        return this.topTwoCategories;
    }

    public int hashCode() {
        return (this.topTwoCategories.hashCode() * 31) + this.categories.hashCode();
    }

    @NotNull
    public String toString() {
        List<Category> list = this.topTwoCategories;
        List<Category> list2 = this.categories;
        return "CategoryViewHolderData(topTwoCategories=" + list + ", categories=" + list2 + ")";
    }
}
