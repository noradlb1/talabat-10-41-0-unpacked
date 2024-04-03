package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "", "()V", "pageSize", "", "totalPages", "totalItems", "(III)V", "getPageSize", "()I", "setPageSize", "(I)V", "getTotalItems", "setTotalItems", "getTotalPages", "setTotalPages", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryItemsForSectionPagingInfo {
    @SerializedName("pageSize")
    private int pageSize;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("totalPages")
    private int totalPages;

    public GroceryItemsForSectionPagingInfo(int i11, int i12, int i13) {
        this.pageSize = i11;
        this.totalPages = i12;
        this.totalItems = i13;
    }

    public static /* synthetic */ GroceryItemsForSectionPagingInfo copy$default(GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = groceryItemsForSectionPagingInfo.pageSize;
        }
        if ((i14 & 2) != 0) {
            i12 = groceryItemsForSectionPagingInfo.totalPages;
        }
        if ((i14 & 4) != 0) {
            i13 = groceryItemsForSectionPagingInfo.totalItems;
        }
        return groceryItemsForSectionPagingInfo.copy(i11, i12, i13);
    }

    public final int component1() {
        return this.pageSize;
    }

    public final int component2() {
        return this.totalPages;
    }

    public final int component3() {
        return this.totalItems;
    }

    @NotNull
    public final GroceryItemsForSectionPagingInfo copy(int i11, int i12, int i13) {
        return new GroceryItemsForSectionPagingInfo(i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroceryItemsForSectionPagingInfo)) {
            return false;
        }
        GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo = (GroceryItemsForSectionPagingInfo) obj;
        return this.pageSize == groceryItemsForSectionPagingInfo.pageSize && this.totalPages == groceryItemsForSectionPagingInfo.totalPages && this.totalItems == groceryItemsForSectionPagingInfo.totalItems;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotalItems() {
        return this.totalItems;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public int hashCode() {
        return (((this.pageSize * 31) + this.totalPages) * 31) + this.totalItems;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setTotalItems(int i11) {
        this.totalItems = i11;
    }

    public final void setTotalPages(int i11) {
        this.totalPages = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.pageSize;
        int i12 = this.totalPages;
        int i13 = this.totalItems;
        return "GroceryItemsForSectionPagingInfo(pageSize=" + i11 + ", totalPages=" + i12 + ", totalItems=" + i13 + ")";
    }

    public GroceryItemsForSectionPagingInfo() {
        this(0, 0, 0);
    }
}
