package JsonModels.Request.GroceryRequest;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"LJsonModels/Request/GroceryRequest/SearchApiTagNamesArray;", "", "()V", "jsonArray", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "getJsonArray", "()Lcom/google/gson/JsonObject;", "setJsonArray", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchApiTagNamesArray {
    @SerializedName("")
    @NotNull
    private JsonObject jsonArray;

    public SearchApiTagNamesArray(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonArray");
        this.jsonArray = jsonObject;
    }

    public static /* synthetic */ SearchApiTagNamesArray copy$default(SearchApiTagNamesArray searchApiTagNamesArray, JsonObject jsonObject, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            jsonObject = searchApiTagNamesArray.jsonArray;
        }
        return searchApiTagNamesArray.copy(jsonObject);
    }

    @NotNull
    public final JsonObject component1() {
        return this.jsonArray;
    }

    @NotNull
    public final SearchApiTagNamesArray copy(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonArray");
        return new SearchApiTagNamesArray(jsonObject);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchApiTagNamesArray) && Intrinsics.areEqual((Object) this.jsonArray, (Object) ((SearchApiTagNamesArray) obj).jsonArray);
    }

    @NotNull
    public final JsonObject getJsonArray() {
        return this.jsonArray;
    }

    public int hashCode() {
        return this.jsonArray.hashCode();
    }

    public final void setJsonArray(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.jsonArray = jsonObject;
    }

    @NotNull
    public String toString() {
        JsonObject jsonObject = this.jsonArray;
        return "SearchApiTagNamesArray(jsonArray=" + jsonObject + ")";
    }

    public SearchApiTagNamesArray() {
        this(new JsonObject());
    }
}
