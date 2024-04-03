package JsonModels.Response.LoyaltyVoucherResponse;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJP\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, d2 = {"LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherBounds;", "", "categoryIds", "", "", "productIds", "skuIds", "excludeCategories", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getCategoryIds", "()Ljava/util/List;", "getExcludeCategories", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProductIds", "getSkuIds", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherBounds;", "equals", "other", "hasBounds", "hasCategoryIds", "hasProductIds", "hasSkuIds", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyVoucherBounds {
    @SerializedName("categoryIds")
    @Nullable
    private final List<String> categoryIds;
    @SerializedName("excludeCategories")
    @Nullable
    private final Boolean excludeCategories;
    @SerializedName("productIds")
    @Nullable
    private final List<String> productIds;
    @SerializedName("skuIds")
    @Nullable
    private final List<String> skuIds;

    public LoyaltyVoucherBounds() {
        this((List) null, (List) null, (List) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
    }

    public LoyaltyVoucherBounds(@Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Boolean bool) {
        this.categoryIds = list;
        this.productIds = list2;
        this.skuIds = list3;
        this.excludeCategories = bool;
    }

    public static /* synthetic */ LoyaltyVoucherBounds copy$default(LoyaltyVoucherBounds loyaltyVoucherBounds, List<String> list, List<String> list2, List<String> list3, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = loyaltyVoucherBounds.categoryIds;
        }
        if ((i11 & 2) != 0) {
            list2 = loyaltyVoucherBounds.productIds;
        }
        if ((i11 & 4) != 0) {
            list3 = loyaltyVoucherBounds.skuIds;
        }
        if ((i11 & 8) != 0) {
            bool = loyaltyVoucherBounds.excludeCategories;
        }
        return loyaltyVoucherBounds.copy(list, list2, list3, bool);
    }

    @Nullable
    public final List<String> component1() {
        return this.categoryIds;
    }

    @Nullable
    public final List<String> component2() {
        return this.productIds;
    }

    @Nullable
    public final List<String> component3() {
        return this.skuIds;
    }

    @Nullable
    public final Boolean component4() {
        return this.excludeCategories;
    }

    @NotNull
    public final LoyaltyVoucherBounds copy(@Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Boolean bool) {
        return new LoyaltyVoucherBounds(list, list2, list3, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoyaltyVoucherBounds)) {
            return false;
        }
        LoyaltyVoucherBounds loyaltyVoucherBounds = (LoyaltyVoucherBounds) obj;
        return Intrinsics.areEqual((Object) this.categoryIds, (Object) loyaltyVoucherBounds.categoryIds) && Intrinsics.areEqual((Object) this.productIds, (Object) loyaltyVoucherBounds.productIds) && Intrinsics.areEqual((Object) this.skuIds, (Object) loyaltyVoucherBounds.skuIds) && Intrinsics.areEqual((Object) this.excludeCategories, (Object) loyaltyVoucherBounds.excludeCategories);
    }

    @Nullable
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    @Nullable
    public final Boolean getExcludeCategories() {
        return this.excludeCategories;
    }

    @Nullable
    public final List<String> getProductIds() {
        return this.productIds;
    }

    @Nullable
    public final List<String> getSkuIds() {
        return this.skuIds;
    }

    public final boolean hasBounds() {
        return hasCategoryIds() || hasProductIds() || hasSkuIds();
    }

    public final boolean hasCategoryIds() {
        Collection collection = this.categoryIds;
        return !(collection == null || collection.isEmpty());
    }

    public final boolean hasProductIds() {
        Collection collection = this.productIds;
        return !(collection == null || collection.isEmpty());
    }

    public final boolean hasSkuIds() {
        Collection collection = this.skuIds;
        return !(collection == null || collection.isEmpty());
    }

    public int hashCode() {
        List<String> list = this.categoryIds;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.productIds;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.skuIds;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.excludeCategories;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        List<String> list = this.categoryIds;
        List<String> list2 = this.productIds;
        List<String> list3 = this.skuIds;
        Boolean bool = this.excludeCategories;
        return "LoyaltyVoucherBounds(categoryIds=" + list + ", productIds=" + list2 + ", skuIds=" + list3 + ", excludeCategories=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoyaltyVoucherBounds(List list, List list2, List list3, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : list2, (i11 & 4) != 0 ? null : list3, (i11 & 8) != 0 ? Boolean.FALSE : bool);
    }
}
