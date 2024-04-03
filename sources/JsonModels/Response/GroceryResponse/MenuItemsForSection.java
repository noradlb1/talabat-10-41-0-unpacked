package JsonModels.Response.GroceryResponse;

import com.google.gson.annotations.SerializedName;
import datamodels.MenuSection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"LJsonModels/Response/GroceryResponse/MenuItemsForSection;", "", "menuSection", "Ldatamodels/MenuSection;", "pagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "(Ldatamodels/MenuSection;LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;)V", "getMenuSection", "()Ldatamodels/MenuSection;", "setMenuSection", "(Ldatamodels/MenuSection;)V", "getPagingInfo", "()LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "setPagingInfo", "(LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuItemsForSection {
    @NotNull
    private MenuSection menuSection;
    @SerializedName("pagingInfo")
    @NotNull
    private GroceryItemsForSectionPagingInfo pagingInfo;

    public MenuItemsForSection(@NotNull MenuSection menuSection2, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(menuSection2, "menuSection");
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "pagingInfo");
        this.menuSection = menuSection2;
        this.pagingInfo = groceryItemsForSectionPagingInfo;
    }

    public static /* synthetic */ MenuItemsForSection copy$default(MenuItemsForSection menuItemsForSection, MenuSection menuSection2, GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            menuSection2 = menuItemsForSection.menuSection;
        }
        if ((i11 & 2) != 0) {
            groceryItemsForSectionPagingInfo = menuItemsForSection.pagingInfo;
        }
        return menuItemsForSection.copy(menuSection2, groceryItemsForSectionPagingInfo);
    }

    @NotNull
    public final MenuSection component1() {
        return this.menuSection;
    }

    @NotNull
    public final GroceryItemsForSectionPagingInfo component2() {
        return this.pagingInfo;
    }

    @NotNull
    public final MenuItemsForSection copy(@NotNull MenuSection menuSection2, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(menuSection2, "menuSection");
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "pagingInfo");
        return new MenuItemsForSection(menuSection2, groceryItemsForSectionPagingInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuItemsForSection)) {
            return false;
        }
        MenuItemsForSection menuItemsForSection = (MenuItemsForSection) obj;
        return Intrinsics.areEqual((Object) this.menuSection, (Object) menuItemsForSection.menuSection) && Intrinsics.areEqual((Object) this.pagingInfo, (Object) menuItemsForSection.pagingInfo);
    }

    @NotNull
    public final MenuSection getMenuSection() {
        return this.menuSection;
    }

    @NotNull
    public final GroceryItemsForSectionPagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public int hashCode() {
        return (this.menuSection.hashCode() * 31) + this.pagingInfo.hashCode();
    }

    public final void setMenuSection(@NotNull MenuSection menuSection2) {
        Intrinsics.checkNotNullParameter(menuSection2, "<set-?>");
        this.menuSection = menuSection2;
    }

    public final void setPagingInfo(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "<set-?>");
        this.pagingInfo = groceryItemsForSectionPagingInfo;
    }

    @NotNull
    public String toString() {
        MenuSection menuSection2 = this.menuSection;
        GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo = this.pagingInfo;
        return "MenuItemsForSection(menuSection=" + menuSection2 + ", pagingInfo=" + groceryItemsForSectionPagingInfo + ")";
    }
}
