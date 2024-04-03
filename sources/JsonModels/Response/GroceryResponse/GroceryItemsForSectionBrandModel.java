package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "", "brandId", "", "brandName", "", "itemCount", "(ILjava/lang/String;I)V", "getBrandId", "()I", "setBrandId", "(I)V", "getBrandName", "()Ljava/lang/String;", "setBrandName", "(Ljava/lang/String;)V", "getItemCount", "setItemCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryItemsForSectionBrandModel {
    @SerializedName("brandId")
    private int brandId;
    @SerializedName("brandName")
    @NotNull
    private String brandName;
    @SerializedName("itemCount")
    private int itemCount;

    public GroceryItemsForSectionBrandModel(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "brandName");
        this.brandId = i11;
        this.brandName = str;
        this.itemCount = i12;
    }

    public static /* synthetic */ GroceryItemsForSectionBrandModel copy$default(GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel, int i11, String str, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = groceryItemsForSectionBrandModel.brandId;
        }
        if ((i13 & 2) != 0) {
            str = groceryItemsForSectionBrandModel.brandName;
        }
        if ((i13 & 4) != 0) {
            i12 = groceryItemsForSectionBrandModel.itemCount;
        }
        return groceryItemsForSectionBrandModel.copy(i11, str, i12);
    }

    public final int component1() {
        return this.brandId;
    }

    @NotNull
    public final String component2() {
        return this.brandName;
    }

    public final int component3() {
        return this.itemCount;
    }

    @NotNull
    public final GroceryItemsForSectionBrandModel copy(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "brandName");
        return new GroceryItemsForSectionBrandModel(i11, str, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroceryItemsForSectionBrandModel)) {
            return false;
        }
        GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel = (GroceryItemsForSectionBrandModel) obj;
        return this.brandId == groceryItemsForSectionBrandModel.brandId && Intrinsics.areEqual((Object) this.brandName, (Object) groceryItemsForSectionBrandModel.brandName) && this.itemCount == groceryItemsForSectionBrandModel.itemCount;
    }

    public final int getBrandId() {
        return this.brandId;
    }

    @NotNull
    public final String getBrandName() {
        return this.brandName;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public int hashCode() {
        return (((this.brandId * 31) + this.brandName.hashCode()) * 31) + this.itemCount;
    }

    public final void setBrandId(int i11) {
        this.brandId = i11;
    }

    public final void setBrandName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brandName = str;
    }

    public final void setItemCount(int i11) {
        this.itemCount = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.brandId;
        String str = this.brandName;
        int i12 = this.itemCount;
        return "GroceryItemsForSectionBrandModel(brandId=" + i11 + ", brandName=" + str + ", itemCount=" + i12 + ")";
    }
}
