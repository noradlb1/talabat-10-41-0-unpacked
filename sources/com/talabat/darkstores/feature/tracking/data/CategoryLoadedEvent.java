package com.talabat.darkstores.feature.tracking.data;

import com.models.ProductTrackingModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/CategoryLoadedEvent;", "", "name", "", "categoryId", "subcategories", "", "products", "Lcom/models/ProductTrackingModel;", "expanded", "", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getEventOrigin", "getExpanded", "()Z", "getName", "getProducts", "()Ljava/util/List;", "getSubcategories", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryLoadedEvent {
    @Nullable
    private final String categoryId;
    @Nullable
    private final String eventOrigin;
    private final boolean expanded;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56626name;
    @NotNull
    private final List<ProductTrackingModel> products;
    @NotNull
    private final List<String> subcategories;

    public CategoryLoadedEvent(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull List<ProductTrackingModel> list2, boolean z11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "subcategories");
        Intrinsics.checkNotNullParameter(list2, "products");
        this.f56626name = str;
        this.categoryId = str2;
        this.subcategories = list;
        this.products = list2;
        this.expanded = z11;
        this.eventOrigin = str3;
    }

    public static /* synthetic */ CategoryLoadedEvent copy$default(CategoryLoadedEvent categoryLoadedEvent, String str, String str2, List<String> list, List<ProductTrackingModel> list2, boolean z11, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = categoryLoadedEvent.f56626name;
        }
        if ((i11 & 2) != 0) {
            str2 = categoryLoadedEvent.categoryId;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            list = categoryLoadedEvent.subcategories;
        }
        List<String> list3 = list;
        if ((i11 & 8) != 0) {
            list2 = categoryLoadedEvent.products;
        }
        List<ProductTrackingModel> list4 = list2;
        if ((i11 & 16) != 0) {
            z11 = categoryLoadedEvent.expanded;
        }
        boolean z12 = z11;
        if ((i11 & 32) != 0) {
            str3 = categoryLoadedEvent.eventOrigin;
        }
        return categoryLoadedEvent.copy(str, str4, list3, list4, z12, str3);
    }

    @NotNull
    public final String component1() {
        return this.f56626name;
    }

    @Nullable
    public final String component2() {
        return this.categoryId;
    }

    @NotNull
    public final List<String> component3() {
        return this.subcategories;
    }

    @NotNull
    public final List<ProductTrackingModel> component4() {
        return this.products;
    }

    public final boolean component5() {
        return this.expanded;
    }

    @Nullable
    public final String component6() {
        return this.eventOrigin;
    }

    @NotNull
    public final CategoryLoadedEvent copy(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull List<ProductTrackingModel> list2, boolean z11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "subcategories");
        Intrinsics.checkNotNullParameter(list2, "products");
        return new CategoryLoadedEvent(str, str2, list, list2, z11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryLoadedEvent)) {
            return false;
        }
        CategoryLoadedEvent categoryLoadedEvent = (CategoryLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.f56626name, (Object) categoryLoadedEvent.f56626name) && Intrinsics.areEqual((Object) this.categoryId, (Object) categoryLoadedEvent.categoryId) && Intrinsics.areEqual((Object) this.subcategories, (Object) categoryLoadedEvent.subcategories) && Intrinsics.areEqual((Object) this.products, (Object) categoryLoadedEvent.products) && this.expanded == categoryLoadedEvent.expanded && Intrinsics.areEqual((Object) this.eventOrigin, (Object) categoryLoadedEvent.eventOrigin);
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    @NotNull
    public final String getName() {
        return this.f56626name;
    }

    @NotNull
    public final List<ProductTrackingModel> getProducts() {
        return this.products;
    }

    @NotNull
    public final List<String> getSubcategories() {
        return this.subcategories;
    }

    public int hashCode() {
        int hashCode = this.f56626name.hashCode() * 31;
        String str = this.categoryId;
        int i11 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.subcategories.hashCode()) * 31) + this.products.hashCode()) * 31;
        boolean z11 = this.expanded;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
        String str2 = this.eventOrigin;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f56626name;
        String str2 = this.categoryId;
        List<String> list = this.subcategories;
        List<ProductTrackingModel> list2 = this.products;
        boolean z11 = this.expanded;
        String str3 = this.eventOrigin;
        return "CategoryLoadedEvent(name=" + str + ", categoryId=" + str2 + ", subcategories=" + list + ", products=" + list2 + ", expanded=" + z11 + ", eventOrigin=" + str3 + ")";
    }
}
