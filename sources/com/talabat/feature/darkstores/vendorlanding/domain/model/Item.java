package com.talabat.feature.darkstores.vendorlanding.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "", "id", "", "name", "products", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "tracking", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Tracking;", "layoutType", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LayoutType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Tracking;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LayoutType;)V", "getId", "()Ljava/lang/String;", "getLayoutType", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LayoutType;", "getName", "getProducts", "()Ljava/util/List;", "getTracking", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Tracking;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Item {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58420id;
    @NotNull
    private final LayoutType layoutType;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58421name;
    @NotNull
    private final List<SwimlaneProduct> products;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f58422tracking;

    public Item(@NotNull String str, @NotNull String str2, @NotNull List<SwimlaneProduct> list, @Nullable Tracking tracking2, @NotNull LayoutType layoutType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(layoutType2, "layoutType");
        this.f58420id = str;
        this.f58421name = str2;
        this.products = list;
        this.f58422tracking = tracking2;
        this.layoutType = layoutType2;
    }

    public static /* synthetic */ Item copy$default(Item item, String str, String str2, List<SwimlaneProduct> list, Tracking tracking2, LayoutType layoutType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = item.f58420id;
        }
        if ((i11 & 2) != 0) {
            str2 = item.f58421name;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            list = item.products;
        }
        List<SwimlaneProduct> list2 = list;
        if ((i11 & 8) != 0) {
            tracking2 = item.f58422tracking;
        }
        Tracking tracking3 = tracking2;
        if ((i11 & 16) != 0) {
            layoutType2 = item.layoutType;
        }
        return item.copy(str, str3, list2, tracking3, layoutType2);
    }

    @NotNull
    public final String component1() {
        return this.f58420id;
    }

    @NotNull
    public final String component2() {
        return this.f58421name;
    }

    @NotNull
    public final List<SwimlaneProduct> component3() {
        return this.products;
    }

    @Nullable
    public final Tracking component4() {
        return this.f58422tracking;
    }

    @NotNull
    public final LayoutType component5() {
        return this.layoutType;
    }

    @NotNull
    public final Item copy(@NotNull String str, @NotNull String str2, @NotNull List<SwimlaneProduct> list, @Nullable Tracking tracking2, @NotNull LayoutType layoutType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(layoutType2, "layoutType");
        return new Item(str, str2, list, tracking2, layoutType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        return Intrinsics.areEqual((Object) this.f58420id, (Object) item.f58420id) && Intrinsics.areEqual((Object) this.f58421name, (Object) item.f58421name) && Intrinsics.areEqual((Object) this.products, (Object) item.products) && Intrinsics.areEqual((Object) this.f58422tracking, (Object) item.f58422tracking) && this.layoutType == item.layoutType;
    }

    @NotNull
    public final String getId() {
        return this.f58420id;
    }

    @NotNull
    public final LayoutType getLayoutType() {
        return this.layoutType;
    }

    @NotNull
    public final String getName() {
        return this.f58421name;
    }

    @NotNull
    public final List<SwimlaneProduct> getProducts() {
        return this.products;
    }

    @Nullable
    public final Tracking getTracking() {
        return this.f58422tracking;
    }

    public int hashCode() {
        int hashCode = ((((this.f58420id.hashCode() * 31) + this.f58421name.hashCode()) * 31) + this.products.hashCode()) * 31;
        Tracking tracking2 = this.f58422tracking;
        return ((hashCode + (tracking2 == null ? 0 : tracking2.hashCode())) * 31) + this.layoutType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f58420id;
        String str2 = this.f58421name;
        List<SwimlaneProduct> list = this.products;
        Tracking tracking2 = this.f58422tracking;
        LayoutType layoutType2 = this.layoutType;
        return "Item(id=" + str + ", name=" + str2 + ", products=" + list + ", tracking=" + tracking2 + ", layoutType=" + layoutType2 + ")";
    }
}
