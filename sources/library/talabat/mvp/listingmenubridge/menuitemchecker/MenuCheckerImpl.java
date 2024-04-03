package library.talabat.mvp.listingmenubridge.menuitemchecker;

import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.MenuItem;
import datamodels.MenuSection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/MenuCheckerImpl;", "Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/IMenuItemChecker;", "menuSections", "", "Ldatamodels/MenuSection;", "([Ldatamodels/MenuSection;)V", "getMenuSections", "()[Ldatamodels/MenuSection;", "[Ldatamodels/MenuSection;", "isItemAvailableInMenu", "", "itemId", "", "catogoryId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuCheckerImpl implements IMenuItemChecker {
    @NotNull
    private final MenuSection[] menuSections;

    public MenuCheckerImpl(@NotNull MenuSection[] menuSectionArr) {
        Intrinsics.checkNotNullParameter(menuSectionArr, "menuSections");
        this.menuSections = menuSectionArr;
    }

    @NotNull
    public final MenuSection[] getMenuSections() {
        return this.menuSections;
    }

    public boolean isItemAvailableInMenu(int i11, int i12) {
        MenuItem menuItem;
        MenuItem[] menuItemArr;
        MenuSection[] menuSectionArr = this.menuSections;
        if (menuSectionArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int length = menuSectionArr.length;
        int i13 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 >= length) {
                break;
            }
            MenuSection menuSection = menuSectionArr[i13];
            if (menuSection.f13863id != i11) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(menuSection);
            }
            i13++;
        }
        MenuSection menuSection2 = (MenuSection) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
        if (menuSection2 == null || (menuItemArr = menuSection2.items) == null) {
            menuItem = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (MenuItem menuItem2 : menuItemArr) {
                if (menuItem2.f13861id == i12) {
                    arrayList2.add(menuItem2);
                }
            }
            menuItem = (MenuItem) CollectionsKt___CollectionsKt.firstOrNull(arrayList2);
        }
        if (menuItem != null) {
            return true;
        }
        return false;
    }

    public boolean isItemAvailableInMenu(int i11) {
        MenuItem menuItem;
        for (MenuSection menuSection : this.menuSections) {
            MenuItem[] menuItemArr = menuSection.items;
            if (menuItemArr != null) {
                Intrinsics.checkNotNullExpressionValue(menuItemArr, FirebaseAnalytics.Param.ITEMS);
                ArrayList arrayList = new ArrayList();
                for (MenuItem menuItem2 : menuItemArr) {
                    if (menuItem2.f13861id == i11) {
                        arrayList.add(menuItem2);
                    }
                }
                menuItem = (MenuItem) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
            } else {
                menuItem = null;
            }
            if (menuItem != null) {
                return true;
            }
        }
        return false;
    }
}
