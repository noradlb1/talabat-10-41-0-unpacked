package library.talabat.mvp.listingmenubridge.menuitemchecker;

import datamodels.MenuItem;
import datamodels.MenuSection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000e"}, d2 = {"Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/MenuItemInjector;", "Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/IMenuItemInjector;", "menuSections", "", "Ldatamodels/MenuSection;", "([Ldatamodels/MenuSection;)V", "getMenuSections", "()[Ldatamodels/MenuSection;", "setMenuSections", "[Ldatamodels/MenuSection;", "injectMenuItem", "", "menuItem", "Ldatamodels/MenuItem;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuItemInjector implements IMenuItemInjector {
    @NotNull
    private MenuSection[] menuSections;

    public MenuItemInjector(@NotNull MenuSection[] menuSectionArr) {
        Intrinsics.checkNotNullParameter(menuSectionArr, "menuSections");
        this.menuSections = menuSectionArr;
    }

    @NotNull
    public final MenuSection[] getMenuSections() {
        return this.menuSections;
    }

    public void injectMenuItem(@NotNull MenuItem menuItem) {
        boolean z11;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        MenuSection[] menuSectionArr = this.menuSections;
        if (menuSectionArr != null) {
            ArrayList arrayList = new ArrayList();
            for (MenuSection menuSection : menuSectionArr) {
                if (menuSection.f13863id == menuItem.menuSectionId) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(menuSection);
                }
            }
            MenuSection menuSection2 = (MenuSection) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
            if (menuSection2 != null) {
                MenuItem[] menuItemArr = menuSection2.items;
                Intrinsics.checkNotNullExpressionValue(menuItemArr, "menuSection.items");
                List mutableList = ArraysKt___ArraysKt.toMutableList((T[]) menuItemArr);
                mutableList.add(menuItem);
                Object[] array = mutableList.toArray(new MenuItem[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                menuSection2.items = (MenuItem[]) array;
            }
        }
    }

    public final void setMenuSections(@NotNull MenuSection[] menuSectionArr) {
        Intrinsics.checkNotNullParameter(menuSectionArr, "<set-?>");
        this.menuSections = menuSectionArr;
    }
}
