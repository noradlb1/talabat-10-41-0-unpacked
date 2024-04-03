package JsonModels.Request.GroceryRequest;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006."}, d2 = {"LJsonModels/Request/GroceryRequest/GrocerySearchRequest;", "", "searchQuery", "", "pageNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "sectionId", "pageSize", "sortBy", "sortOrder", "brandIds", "tagIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandIds", "()Ljava/lang/String;", "setBrandIds", "(Ljava/lang/String;)V", "getPageNumber", "setPageNumber", "getPageSize", "setPageSize", "getSearchQuery", "setSearchQuery", "getSectionId", "setSectionId", "getSortBy", "setSortBy", "getSortOrder", "setSortOrder", "getTagIds", "setTagIds", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrocerySearchRequest {
    @SerializedName("BrandIds")
    @Nullable
    private String brandIds;
    @SerializedName("pageno")
    @NotNull
    private String pageNumber;
    @SerializedName("PageSize")
    @Nullable
    private String pageSize;
    @SerializedName("term")
    @NotNull
    private String searchQuery;
    @SerializedName("sectionid")
    @Nullable
    private String sectionId;
    @SerializedName("SortBy")
    @Nullable
    private String sortBy;
    @SerializedName("SortOrder")
    @Nullable
    private String sortOrder;
    @SerializedName("Tags")
    @Nullable
    private String tagIds;

    public GrocerySearchRequest(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(str2, "pageNumber");
        this.searchQuery = str;
        this.pageNumber = str2;
        this.sectionId = str3;
        this.pageSize = str4;
        this.sortBy = str5;
        this.sortOrder = str6;
        this.brandIds = str7;
        this.tagIds = str8;
    }

    public static /* synthetic */ GrocerySearchRequest copy$default(GrocerySearchRequest grocerySearchRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        GrocerySearchRequest grocerySearchRequest2 = grocerySearchRequest;
        int i12 = i11;
        return grocerySearchRequest.copy((i12 & 1) != 0 ? grocerySearchRequest2.searchQuery : str, (i12 & 2) != 0 ? grocerySearchRequest2.pageNumber : str2, (i12 & 4) != 0 ? grocerySearchRequest2.sectionId : str3, (i12 & 8) != 0 ? grocerySearchRequest2.pageSize : str4, (i12 & 16) != 0 ? grocerySearchRequest2.sortBy : str5, (i12 & 32) != 0 ? grocerySearchRequest2.sortOrder : str6, (i12 & 64) != 0 ? grocerySearchRequest2.brandIds : str7, (i12 & 128) != 0 ? grocerySearchRequest2.tagIds : str8);
    }

    @NotNull
    public final String component1() {
        return this.searchQuery;
    }

    @NotNull
    public final String component2() {
        return this.pageNumber;
    }

    @Nullable
    public final String component3() {
        return this.sectionId;
    }

    @Nullable
    public final String component4() {
        return this.pageSize;
    }

    @Nullable
    public final String component5() {
        return this.sortBy;
    }

    @Nullable
    public final String component6() {
        return this.sortOrder;
    }

    @Nullable
    public final String component7() {
        return this.brandIds;
    }

    @Nullable
    public final String component8() {
        return this.tagIds;
    }

    @NotNull
    public final GrocerySearchRequest copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(str2, "pageNumber");
        return new GrocerySearchRequest(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GrocerySearchRequest)) {
            return false;
        }
        GrocerySearchRequest grocerySearchRequest = (GrocerySearchRequest) obj;
        return Intrinsics.areEqual((Object) this.searchQuery, (Object) grocerySearchRequest.searchQuery) && Intrinsics.areEqual((Object) this.pageNumber, (Object) grocerySearchRequest.pageNumber) && Intrinsics.areEqual((Object) this.sectionId, (Object) grocerySearchRequest.sectionId) && Intrinsics.areEqual((Object) this.pageSize, (Object) grocerySearchRequest.pageSize) && Intrinsics.areEqual((Object) this.sortBy, (Object) grocerySearchRequest.sortBy) && Intrinsics.areEqual((Object) this.sortOrder, (Object) grocerySearchRequest.sortOrder) && Intrinsics.areEqual((Object) this.brandIds, (Object) grocerySearchRequest.brandIds) && Intrinsics.areEqual((Object) this.tagIds, (Object) grocerySearchRequest.tagIds);
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

    @NotNull
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    @Nullable
    public final String getSectionId() {
        return this.sectionId;
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
        int hashCode = ((this.searchQuery.hashCode() * 31) + this.pageNumber.hashCode()) * 31;
        String str = this.sectionId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pageSize;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sortBy;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sortOrder;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.brandIds;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tagIds;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode6 + i11;
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

    public final void setSearchQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchQuery = str;
    }

    public final void setSectionId(@Nullable String str) {
        this.sectionId = str;
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
        String str = this.searchQuery;
        String str2 = this.pageNumber;
        String str3 = this.sectionId;
        String str4 = this.pageSize;
        String str5 = this.sortBy;
        String str6 = this.sortOrder;
        String str7 = this.brandIds;
        String str8 = this.tagIds;
        return "GrocerySearchRequest(searchQuery=" + str + ", pageNumber=" + str2 + ", sectionId=" + str3 + ", pageSize=" + str4 + ", sortBy=" + str5 + ", sortOrder=" + str6 + ", brandIds=" + str7 + ", tagIds=" + str8 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GrocerySearchRequest(@NotNull String str, @NotNull String str2) {
        this(str, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(str2, "pageNumber");
    }
}
