package com.talabat.feature.darkstores.vendorlanding.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "", "id", "", "imageUrls", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "name", "subCategories", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SubCategory;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getImageUrls", "()Ljava/util/List;", "getName", "getSubCategories", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryTree {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58418id;
    @NotNull
    private final List<ImageUrl> imageUrls;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58419name;
    @NotNull
    private final List<SubCategory> subCategories;

    public CategoryTree(@NotNull String str, @NotNull List<ImageUrl> list, @NotNull String str2, @NotNull List<SubCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list2, "subCategories");
        this.f58418id = str;
        this.imageUrls = list;
        this.f58419name = str2;
        this.subCategories = list2;
    }

    public static /* synthetic */ CategoryTree copy$default(CategoryTree categoryTree, String str, List<ImageUrl> list, String str2, List<SubCategory> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = categoryTree.f58418id;
        }
        if ((i11 & 2) != 0) {
            list = categoryTree.imageUrls;
        }
        if ((i11 & 4) != 0) {
            str2 = categoryTree.f58419name;
        }
        if ((i11 & 8) != 0) {
            list2 = categoryTree.subCategories;
        }
        return categoryTree.copy(str, list, str2, list2);
    }

    @NotNull
    public final String component1() {
        return this.f58418id;
    }

    @NotNull
    public final List<ImageUrl> component2() {
        return this.imageUrls;
    }

    @NotNull
    public final String component3() {
        return this.f58419name;
    }

    @NotNull
    public final List<SubCategory> component4() {
        return this.subCategories;
    }

    @NotNull
    public final CategoryTree copy(@NotNull String str, @NotNull List<ImageUrl> list, @NotNull String str2, @NotNull List<SubCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list2, "subCategories");
        return new CategoryTree(str, list, str2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryTree)) {
            return false;
        }
        CategoryTree categoryTree = (CategoryTree) obj;
        return Intrinsics.areEqual((Object) this.f58418id, (Object) categoryTree.f58418id) && Intrinsics.areEqual((Object) this.imageUrls, (Object) categoryTree.imageUrls) && Intrinsics.areEqual((Object) this.f58419name, (Object) categoryTree.f58419name) && Intrinsics.areEqual((Object) this.subCategories, (Object) categoryTree.subCategories);
    }

    @NotNull
    public final String getId() {
        return this.f58418id;
    }

    @NotNull
    public final List<ImageUrl> getImageUrls() {
        return this.imageUrls;
    }

    @NotNull
    public final String getName() {
        return this.f58419name;
    }

    @NotNull
    public final List<SubCategory> getSubCategories() {
        return this.subCategories;
    }

    public int hashCode() {
        return (((((this.f58418id.hashCode() * 31) + this.imageUrls.hashCode()) * 31) + this.f58419name.hashCode()) * 31) + this.subCategories.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f58418id;
        List<ImageUrl> list = this.imageUrls;
        String str2 = this.f58419name;
        List<SubCategory> list2 = this.subCategories;
        return "CategoryTree(id=" + str + ", imageUrls=" + list + ", name=" + str2 + ", subCategories=" + list2 + ")";
    }
}
