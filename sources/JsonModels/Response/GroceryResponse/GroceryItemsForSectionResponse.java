package JsonModels.Response.GroceryResponse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"LJsonModels/Response/GroceryResponse/GroceryItemsForSectionResponse;", "", "result", "LJsonModels/Response/GroceryResponse/MenuItemsForSection;", "(LJsonModels/Response/GroceryResponse/MenuItemsForSection;)V", "getResult", "()LJsonModels/Response/GroceryResponse/MenuItemsForSection;", "setResult", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryItemsForSectionResponse {
    @Nullable
    private MenuItemsForSection result;

    public GroceryItemsForSectionResponse(@Nullable MenuItemsForSection menuItemsForSection) {
        this.result = menuItemsForSection;
    }

    public static /* synthetic */ GroceryItemsForSectionResponse copy$default(GroceryItemsForSectionResponse groceryItemsForSectionResponse, MenuItemsForSection menuItemsForSection, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            menuItemsForSection = groceryItemsForSectionResponse.result;
        }
        return groceryItemsForSectionResponse.copy(menuItemsForSection);
    }

    @Nullable
    public final MenuItemsForSection component1() {
        return this.result;
    }

    @NotNull
    public final GroceryItemsForSectionResponse copy(@Nullable MenuItemsForSection menuItemsForSection) {
        return new GroceryItemsForSectionResponse(menuItemsForSection);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GroceryItemsForSectionResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((GroceryItemsForSectionResponse) obj).result);
    }

    @Nullable
    public final MenuItemsForSection getResult() {
        return this.result;
    }

    public int hashCode() {
        MenuItemsForSection menuItemsForSection = this.result;
        if (menuItemsForSection == null) {
            return 0;
        }
        return menuItemsForSection.hashCode();
    }

    public final void setResult(@Nullable MenuItemsForSection menuItemsForSection) {
        this.result = menuItemsForSection;
    }

    @NotNull
    public String toString() {
        MenuItemsForSection menuItemsForSection = this.result;
        return "GroceryItemsForSectionResponse(result=" + menuItemsForSection + ")";
    }
}
