package com.talabat.darkstores.feature.tracking.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsCategory;", "", "name", "", "id", "imageUrl", "subcategories", "", "Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsSubCategory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getImageUrl", "getName", "getSubcategories", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopDetailsCategory {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56629id;
    @Nullable
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56630name;
    @Nullable
    private final List<ShopDetailsSubCategory> subcategories;

    public ShopDetailsCategory(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<ShopDetailsSubCategory> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.f56630name = str;
        this.f56629id = str2;
        this.imageUrl = str3;
        this.subcategories = list;
    }

    public static /* synthetic */ ShopDetailsCategory copy$default(ShopDetailsCategory shopDetailsCategory, String str, String str2, String str3, List<ShopDetailsSubCategory> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shopDetailsCategory.f56630name;
        }
        if ((i11 & 2) != 0) {
            str2 = shopDetailsCategory.f56629id;
        }
        if ((i11 & 4) != 0) {
            str3 = shopDetailsCategory.imageUrl;
        }
        if ((i11 & 8) != 0) {
            list = shopDetailsCategory.subcategories;
        }
        return shopDetailsCategory.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.f56630name;
    }

    @NotNull
    public final String component2() {
        return this.f56629id;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @Nullable
    public final List<ShopDetailsSubCategory> component4() {
        return this.subcategories;
    }

    @NotNull
    public final ShopDetailsCategory copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<ShopDetailsSubCategory> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new ShopDetailsCategory(str, str2, str3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDetailsCategory)) {
            return false;
        }
        ShopDetailsCategory shopDetailsCategory = (ShopDetailsCategory) obj;
        return Intrinsics.areEqual((Object) this.f56630name, (Object) shopDetailsCategory.f56630name) && Intrinsics.areEqual((Object) this.f56629id, (Object) shopDetailsCategory.f56629id) && Intrinsics.areEqual((Object) this.imageUrl, (Object) shopDetailsCategory.imageUrl) && Intrinsics.areEqual((Object) this.subcategories, (Object) shopDetailsCategory.subcategories);
    }

    @NotNull
    public final String getId() {
        return this.f56629id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f56630name;
    }

    @Nullable
    public final List<ShopDetailsSubCategory> getSubcategories() {
        return this.subcategories;
    }

    public int hashCode() {
        int hashCode = ((this.f56630name.hashCode() * 31) + this.f56629id.hashCode()) * 31;
        String str = this.imageUrl;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ShopDetailsSubCategory> list = this.subcategories;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f56630name;
        String str2 = this.f56629id;
        String str3 = this.imageUrl;
        List<ShopDetailsSubCategory> list = this.subcategories;
        return "ShopDetailsCategory(name=" + str + ", id=" + str2 + ", imageUrl=" + str3 + ", subcategories=" + list + ")";
    }
}
