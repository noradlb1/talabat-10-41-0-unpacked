package JsonModels.Request.GroceryRequest;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"LJsonModels/Request/GroceryRequest/GrocerySortAndFilterRequest;", "", "pageNumber", "", "pageSize", "sortBy", "sortOrder", "brandIds", "tagIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandIds", "()Ljava/lang/String;", "setBrandIds", "(Ljava/lang/String;)V", "getPageNumber", "setPageNumber", "getPageSize", "setPageSize", "getSortBy", "setSortBy", "getSortOrder", "setSortOrder", "getTagIds", "setTagIds", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrocerySortAndFilterRequest {
    @SerializedName("BrandIds")
    @Nullable
    private String brandIds;
    @SerializedName("pageno")
    @NotNull
    private String pageNumber;
    @SerializedName("PageSize")
    @Nullable
    private String pageSize;
    @SerializedName("SortBy")
    @Nullable
    private String sortBy;
    @SerializedName("SortOrder")
    @Nullable
    private String sortOrder;
    @SerializedName("Tags")
    @Nullable
    private String tagIds;

    public GrocerySortAndFilterRequest(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "pageNumber");
        this.pageNumber = str;
        this.pageSize = str2;
        this.sortBy = str3;
        this.sortOrder = str4;
        this.brandIds = str5;
        this.tagIds = str6;
    }

    public static /* synthetic */ GrocerySortAndFilterRequest copy$default(GrocerySortAndFilterRequest grocerySortAndFilterRequest, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = grocerySortAndFilterRequest.pageNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = grocerySortAndFilterRequest.pageSize;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = grocerySortAndFilterRequest.sortBy;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = grocerySortAndFilterRequest.sortOrder;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = grocerySortAndFilterRequest.brandIds;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = grocerySortAndFilterRequest.tagIds;
        }
        return grocerySortAndFilterRequest.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.pageNumber;
    }

    @Nullable
    public final String component2() {
        return this.pageSize;
    }

    @Nullable
    public final String component3() {
        return this.sortBy;
    }

    @Nullable
    public final String component4() {
        return this.sortOrder;
    }

    @Nullable
    public final String component5() {
        return this.brandIds;
    }

    @Nullable
    public final String component6() {
        return this.tagIds;
    }

    @NotNull
    public final GrocerySortAndFilterRequest copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "pageNumber");
        return new GrocerySortAndFilterRequest(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GrocerySortAndFilterRequest)) {
            return false;
        }
        GrocerySortAndFilterRequest grocerySortAndFilterRequest = (GrocerySortAndFilterRequest) obj;
        return Intrinsics.areEqual((Object) this.pageNumber, (Object) grocerySortAndFilterRequest.pageNumber) && Intrinsics.areEqual((Object) this.pageSize, (Object) grocerySortAndFilterRequest.pageSize) && Intrinsics.areEqual((Object) this.sortBy, (Object) grocerySortAndFilterRequest.sortBy) && Intrinsics.areEqual((Object) this.sortOrder, (Object) grocerySortAndFilterRequest.sortOrder) && Intrinsics.areEqual((Object) this.brandIds, (Object) grocerySortAndFilterRequest.brandIds) && Intrinsics.areEqual((Object) this.tagIds, (Object) grocerySortAndFilterRequest.tagIds);
    }

    @Nullable
    public final String getBrandIds() {
        return this.brandIds;
    }

    @NotNull
    public final String getPageNumber() {
        return this.pageNumber;
    }

    @Nullable
    public final String getPageSize() {
        return this.pageSize;
    }

    @Nullable
    public final String getSortBy() {
        return this.sortBy;
    }

    @Nullable
    public final String getSortOrder() {
        return this.sortOrder;
    }

    @Nullable
    public final String getTagIds() {
        return this.tagIds;
    }

    public int hashCode() {
        int hashCode = this.pageNumber.hashCode() * 31;
        String str = this.pageSize;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sortBy;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sortOrder;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.brandIds;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tagIds;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setBrandIds(@Nullable String str) {
        this.brandIds = str;
    }

    public final void setPageNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageNumber = str;
    }

    public final void setPageSize(@Nullable String str) {
        this.pageSize = str;
    }

    public final void setSortBy(@Nullable String str) {
        this.sortBy = str;
    }

    public final void setSortOrder(@Nullable String str) {
        this.sortOrder = str;
    }

    public final void setTagIds(@Nullable String str) {
        this.tagIds = str;
    }

    @NotNull
    public String toString() {
        String str = this.pageNumber;
        String str2 = this.pageSize;
        String str3 = this.sortBy;
        String str4 = this.sortOrder;
        String str5 = this.brandIds;
        String str6 = this.tagIds;
        return "GrocerySortAndFilterRequest(pageNumber=" + str + ", pageSize=" + str2 + ", sortBy=" + str3 + ", sortOrder=" + str4 + ", brandIds=" + str5 + ", tagIds=" + str6 + ")";
    }
}
