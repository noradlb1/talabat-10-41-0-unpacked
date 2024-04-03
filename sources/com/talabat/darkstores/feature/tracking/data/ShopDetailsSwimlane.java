package com.talabat.darkstores.feature.tracking.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/ShopDetailsSwimlane;", "", "headline", "", "tag", "categoryId", "products", "", "Lcom/talabat/darkstores/feature/tracking/data/ProductDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCategoryId", "()Ljava/lang/String;", "getHeadline", "getProducts", "()Ljava/util/List;", "getTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopDetailsSwimlane {
    @Nullable
    private final String categoryId;
    @NotNull
    private final String headline;
    @NotNull
    private final List<ProductDetails> products;
    @Nullable
    private final String tag;

    public ShopDetailsSwimlane(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull List<ProductDetails> list) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "products");
        this.headline = str;
        this.tag = str2;
        this.categoryId = str3;
        this.products = list;
    }

    public static /* synthetic */ ShopDetailsSwimlane copy$default(ShopDetailsSwimlane shopDetailsSwimlane, String str, String str2, String str3, List<ProductDetails> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shopDetailsSwimlane.headline;
        }
        if ((i11 & 2) != 0) {
            str2 = shopDetailsSwimlane.tag;
        }
        if ((i11 & 4) != 0) {
            str3 = shopDetailsSwimlane.categoryId;
        }
        if ((i11 & 8) != 0) {
            list = shopDetailsSwimlane.products;
        }
        return shopDetailsSwimlane.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.headline;
    }

    @Nullable
    public final String component2() {
        return this.tag;
    }

    @Nullable
    public final String component3() {
        return this.categoryId;
    }

    @NotNull
    public final List<ProductDetails> component4() {
        return this.products;
    }

    @NotNull
    public final ShopDetailsSwimlane copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull List<ProductDetails> list) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "products");
        return new ShopDetailsSwimlane(str, str2, str3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDetailsSwimlane)) {
            return false;
        }
        ShopDetailsSwimlane shopDetailsSwimlane = (ShopDetailsSwimlane) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) shopDetailsSwimlane.headline) && Intrinsics.areEqual((Object) this.tag, (Object) shopDetailsSwimlane.tag) && Intrinsics.areEqual((Object) this.categoryId, (Object) shopDetailsSwimlane.categoryId) && Intrinsics.areEqual((Object) this.products, (Object) shopDetailsSwimlane.products);
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final List<ProductDetails> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int hashCode = this.headline.hashCode() * 31;
        String str = this.tag;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.categoryId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.products.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        String str2 = this.tag;
        String str3 = this.categoryId;
        List<ProductDetails> list = this.products;
        return "ShopDetailsSwimlane(headline=" + str + ", tag=" + str2 + ", categoryId=" + str3 + ", products=" + list + ")";
    }
}
