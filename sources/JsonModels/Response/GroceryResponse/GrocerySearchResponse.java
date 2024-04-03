package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import datamodels.MenuItem;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J*\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R(\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "", "items", "", "Ldatamodels/MenuItem;", "pagingSummary", "LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;", "([Ldatamodels/MenuItem;LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;)V", "getItems", "()[Ldatamodels/MenuItem;", "setItems", "([Ldatamodels/MenuItem;)V", "[Ldatamodels/MenuItem;", "getPagingSummary", "()LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;", "setPagingSummary", "(LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;)V", "component1", "component2", "copy", "([Ldatamodels/MenuItem;LJsonModels/Response/GroceryResponse/GrocerySearchResponseSummary;)LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrocerySearchResponse {
    @SerializedName("result")
    @Nullable
    private MenuItem[] items;
    @SerializedName("summary")
    @NotNull
    private GrocerySearchResponseSummary pagingSummary;

    public GrocerySearchResponse(@Nullable MenuItem[] menuItemArr, @NotNull GrocerySearchResponseSummary grocerySearchResponseSummary) {
        Intrinsics.checkNotNullParameter(grocerySearchResponseSummary, "pagingSummary");
        this.items = menuItemArr;
        this.pagingSummary = grocerySearchResponseSummary;
    }

    public static /* synthetic */ GrocerySearchResponse copy$default(GrocerySearchResponse grocerySearchResponse, MenuItem[] menuItemArr, GrocerySearchResponseSummary grocerySearchResponseSummary, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            menuItemArr = grocerySearchResponse.items;
        }
        if ((i11 & 2) != 0) {
            grocerySearchResponseSummary = grocerySearchResponse.pagingSummary;
        }
        return grocerySearchResponse.copy(menuItemArr, grocerySearchResponseSummary);
    }

    @Nullable
    public final MenuItem[] component1() {
        return this.items;
    }

    @NotNull
    public final GrocerySearchResponseSummary component2() {
        return this.pagingSummary;
    }

    @NotNull
    public final GrocerySearchResponse copy(@Nullable MenuItem[] menuItemArr, @NotNull GrocerySearchResponseSummary grocerySearchResponseSummary) {
        Intrinsics.checkNotNullParameter(grocerySearchResponseSummary, "pagingSummary");
        return new GrocerySearchResponse(menuItemArr, grocerySearchResponseSummary);
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<GrocerySearchResponse> cls2 = GrocerySearchResponse.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj != null) {
            GrocerySearchResponse grocerySearchResponse = (GrocerySearchResponse) obj;
            MenuItem[] menuItemArr = this.items;
            if (menuItemArr != null) {
                if (grocerySearchResponse.items == null) {
                    return false;
                }
                Intrinsics.checkNotNull(menuItemArr);
                MenuItem[] menuItemArr2 = grocerySearchResponse.items;
                Intrinsics.checkNotNull(menuItemArr2);
                if (!Arrays.equals(menuItemArr, menuItemArr2)) {
                    return false;
                }
            } else if (grocerySearchResponse.items != null) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type JsonModels.Response.GroceryResponse.GrocerySearchResponse");
    }

    @Nullable
    public final MenuItem[] getItems() {
        return this.items;
    }

    @NotNull
    public final GrocerySearchResponseSummary getPagingSummary() {
        return this.pagingSummary;
    }

    public int hashCode() {
        MenuItem[] menuItemArr = this.items;
        if (menuItemArr != null) {
            return Arrays.hashCode(menuItemArr);
        }
        return 0;
    }

    public final void setItems(@Nullable MenuItem[] menuItemArr) {
        this.items = menuItemArr;
    }

    public final void setPagingSummary(@NotNull GrocerySearchResponseSummary grocerySearchResponseSummary) {
        Intrinsics.checkNotNullParameter(grocerySearchResponseSummary, "<set-?>");
        this.pagingSummary = grocerySearchResponseSummary;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.items);
        GrocerySearchResponseSummary grocerySearchResponseSummary = this.pagingSummary;
        return "GrocerySearchResponse(items=" + arrays + ", pagingSummary=" + grocerySearchResponseSummary + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GrocerySearchResponse(MenuItem[] menuItemArr, GrocerySearchResponseSummary grocerySearchResponseSummary, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : menuItemArr, grocerySearchResponseSummary);
    }
}
