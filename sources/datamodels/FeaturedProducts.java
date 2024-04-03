package datamodels;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006#"}, d2 = {"Ldatamodels/FeaturedProducts;", "", "title", "", "slug", "position", "", "items", "", "Ldatamodels/FeaturedProductItem;", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getPosition", "()I", "setPosition", "(I)V", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedProducts {
    @SerializedName("items")
    @NotNull
    private List<FeaturedProductItem> items;
    @SerializedName("position")
    private int position;
    @SerializedName("slug")
    @NotNull
    private String slug;
    @SerializedName("title")
    @NotNull
    private String title;

    public FeaturedProducts() {
        this((String) null, (String) null, 0, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public FeaturedProducts(@NotNull String str, @NotNull String str2, int i11, @NotNull List<FeaturedProductItem> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "slug");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.title = str;
        this.slug = str2;
        this.position = i11;
        this.items = list;
    }

    public static /* synthetic */ FeaturedProducts copy$default(FeaturedProducts featuredProducts, String str, String str2, int i11, List<FeaturedProductItem> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = featuredProducts.title;
        }
        if ((i12 & 2) != 0) {
            str2 = featuredProducts.slug;
        }
        if ((i12 & 4) != 0) {
            i11 = featuredProducts.position;
        }
        if ((i12 & 8) != 0) {
            list = featuredProducts.items;
        }
        return featuredProducts.copy(str, str2, i11, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.slug;
    }

    public final int component3() {
        return this.position;
    }

    @NotNull
    public final List<FeaturedProductItem> component4() {
        return this.items;
    }

    @NotNull
    public final FeaturedProducts copy(@NotNull String str, @NotNull String str2, int i11, @NotNull List<FeaturedProductItem> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "slug");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new FeaturedProducts(str, str2, i11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeaturedProducts)) {
            return false;
        }
        FeaturedProducts featuredProducts = (FeaturedProducts) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) featuredProducts.title) && Intrinsics.areEqual((Object) this.slug, (Object) featuredProducts.slug) && this.position == featuredProducts.position && Intrinsics.areEqual((Object) this.items, (Object) featuredProducts.items);
    }

    @NotNull
    public final List<FeaturedProductItem> getItems() {
        return this.items;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.slug.hashCode()) * 31) + this.position) * 31) + this.items.hashCode();
    }

    public final void setItems(@NotNull List<FeaturedProductItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    public final void setSlug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.slug = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.slug;
        int i11 = this.position;
        List<FeaturedProductItem> list = this.items;
        return "FeaturedProducts(title=" + str + ", slug=" + str2 + ", position=" + i11 + ", items=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeaturedProducts(String str, String str2, int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
