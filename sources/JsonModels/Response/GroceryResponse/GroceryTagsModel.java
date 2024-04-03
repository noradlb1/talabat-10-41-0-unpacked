package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "", "tagId", "", "tagName", "", "tagCount", "(ILjava/lang/String;I)V", "getTagCount", "()I", "setTagCount", "(I)V", "getTagId", "setTagId", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryTagsModel {
    @SerializedName("tagCount")
    private int tagCount;
    @SerializedName("tagId")
    private int tagId;
    @SerializedName("tagName")
    @NotNull
    private String tagName;

    public GroceryTagsModel(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "tagName");
        this.tagId = i11;
        this.tagName = str;
        this.tagCount = i12;
    }

    public static /* synthetic */ GroceryTagsModel copy$default(GroceryTagsModel groceryTagsModel, int i11, String str, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = groceryTagsModel.tagId;
        }
        if ((i13 & 2) != 0) {
            str = groceryTagsModel.tagName;
        }
        if ((i13 & 4) != 0) {
            i12 = groceryTagsModel.tagCount;
        }
        return groceryTagsModel.copy(i11, str, i12);
    }

    public final int component1() {
        return this.tagId;
    }

    @NotNull
    public final String component2() {
        return this.tagName;
    }

    public final int component3() {
        return this.tagCount;
    }

    @NotNull
    public final GroceryTagsModel copy(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "tagName");
        return new GroceryTagsModel(i11, str, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroceryTagsModel)) {
            return false;
        }
        GroceryTagsModel groceryTagsModel = (GroceryTagsModel) obj;
        return this.tagId == groceryTagsModel.tagId && Intrinsics.areEqual((Object) this.tagName, (Object) groceryTagsModel.tagName) && this.tagCount == groceryTagsModel.tagCount;
    }

    public final int getTagCount() {
        return this.tagCount;
    }

    public final int getTagId() {
        return this.tagId;
    }

    @NotNull
    public final String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        return (((this.tagId * 31) + this.tagName.hashCode()) * 31) + this.tagCount;
    }

    public final void setTagCount(int i11) {
        this.tagCount = i11;
    }

    public final void setTagId(int i11) {
        this.tagId = i11;
    }

    public final void setTagName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.tagId;
        String str = this.tagName;
        int i12 = this.tagCount;
        return "GroceryTagsModel(tagId=" + i11 + ", tagName=" + str + ", tagCount=" + i12 + ")";
    }
}
