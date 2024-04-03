package com.talabat.darkstores.feature.tracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsSubCategory;", "", "name", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopDetailsSubCategory {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56631id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56632name;

    public ShopDetailsSubCategory(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.f56632name = str;
        this.f56631id = str2;
    }

    public static /* synthetic */ ShopDetailsSubCategory copy$default(ShopDetailsSubCategory shopDetailsSubCategory, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shopDetailsSubCategory.f56632name;
        }
        if ((i11 & 2) != 0) {
            str2 = shopDetailsSubCategory.f56631id;
        }
        return shopDetailsSubCategory.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f56632name;
    }

    @NotNull
    public final String component2() {
        return this.f56631id;
    }

    @NotNull
    public final ShopDetailsSubCategory copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new ShopDetailsSubCategory(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDetailsSubCategory)) {
            return false;
        }
        ShopDetailsSubCategory shopDetailsSubCategory = (ShopDetailsSubCategory) obj;
        return Intrinsics.areEqual((Object) this.f56632name, (Object) shopDetailsSubCategory.f56632name) && Intrinsics.areEqual((Object) this.f56631id, (Object) shopDetailsSubCategory.f56631id);
    }

    @NotNull
    public final String getId() {
        return this.f56631id;
    }

    @NotNull
    public final String getName() {
        return this.f56632name;
    }

    public int hashCode() {
        return (this.f56632name.hashCode() * 31) + this.f56631id.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56632name;
        String str2 = this.f56631id;
        return "ShopDetailsSubCategory(name=" + str + ", id=" + str2 + ")";
    }
}
