package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ*\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;", "", "pagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "groceryTags", "", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "(LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;[LJsonModels/Response/GroceryResponse/GroceryTagsModel;)V", "getGroceryTags", "()[LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "setGroceryTags", "([LJsonModels/Response/GroceryResponse/GroceryTagsModel;)V", "[LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "getPagingInfo", "()LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "setPagingInfo", "(LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;)V", "component1", "component2", "copy", "(LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;[LJsonModels/Response/GroceryResponse/GroceryTagsModel;)LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrocerySearchResponseSummary {
    @SerializedName("tags")
    @Nullable
    private GroceryTagsModel[] groceryTags;
    @SerializedName("paginationDetails")
    @NotNull
    private GroceryItemsForSectionPagingInfo pagingInfo;

    public GrocerySearchResponseSummary(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, @Nullable GroceryTagsModel[] groceryTagsModelArr) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "pagingInfo");
        this.pagingInfo = groceryItemsForSectionPagingInfo;
        this.groceryTags = groceryTagsModelArr;
    }

    public static /* synthetic */ GrocerySearchResponseSummary copy$default(GrocerySearchResponseSummary grocerySearchResponseSummary, GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, GroceryTagsModel[] groceryTagsModelArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            groceryItemsForSectionPagingInfo = grocerySearchResponseSummary.pagingInfo;
        }
        if ((i11 & 2) != 0) {
            groceryTagsModelArr = grocerySearchResponseSummary.groceryTags;
        }
        return grocerySearchResponseSummary.copy(groceryItemsForSectionPagingInfo, groceryTagsModelArr);
    }

    @NotNull
    public final GroceryItemsForSectionPagingInfo component1() {
        return this.pagingInfo;
    }

    @Nullable
    public final GroceryTagsModel[] component2() {
        return this.groceryTags;
    }

    @NotNull
    public final GrocerySearchResponseSummary copy(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, @Nullable GroceryTagsModel[] groceryTagsModelArr) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "pagingInfo");
        return new GrocerySearchResponseSummary(groceryItemsForSectionPagingInfo, groceryTagsModelArr);
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<GrocerySearchResponseSummary> cls2 = GrocerySearchResponseSummary.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj != null) {
            GrocerySearchResponseSummary grocerySearchResponseSummary = (GrocerySearchResponseSummary) obj;
            if (!Intrinsics.areEqual((Object) this.pagingInfo, (Object) grocerySearchResponseSummary.pagingInfo)) {
                return false;
            }
            GroceryTagsModel[] groceryTagsModelArr = this.groceryTags;
            if (groceryTagsModelArr != null) {
                if (grocerySearchResponseSummary.groceryTags == null) {
                    return false;
                }
                Intrinsics.checkNotNull(groceryTagsModelArr);
                GroceryTagsModel[] groceryTagsModelArr2 = grocerySearchResponseSummary.groceryTags;
                Intrinsics.checkNotNull(groceryTagsModelArr2);
                if (!Arrays.equals(groceryTagsModelArr, groceryTagsModelArr2)) {
                    return false;
                }
            } else if (grocerySearchResponseSummary.groceryTags != null) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type JsonModels.Response.GroceryResponse.GrocerySearchResponseSummary");
    }

    @Nullable
    public final GroceryTagsModel[] getGroceryTags() {
        return this.groceryTags;
    }

    @NotNull
    public final GroceryItemsForSectionPagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.pagingInfo.hashCode() * 31;
        GroceryTagsModel[] groceryTagsModelArr = this.groceryTags;
        if (groceryTagsModelArr != null) {
            i11 = Arrays.hashCode(groceryTagsModelArr);
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    public final void setGroceryTags(@Nullable GroceryTagsModel[] groceryTagsModelArr) {
        this.groceryTags = groceryTagsModelArr;
    }

    public final void setPagingInfo(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "<set-?>");
        this.pagingInfo = groceryItemsForSectionPagingInfo;
    }

    @NotNull
    public String toString() {
        GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo = this.pagingInfo;
        String arrays = Arrays.toString(this.groceryTags);
        return "GrocerySearchResponseSummary(pagingInfo=" + groceryItemsForSectionPagingInfo + ", groceryTags=" + arrays + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GrocerySearchResponseSummary(GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, GroceryTagsModel[] groceryTagsModelArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(groceryItemsForSectionPagingInfo, (i11 & 2) != 0 ? null : groceryTagsModelArr);
    }
}
