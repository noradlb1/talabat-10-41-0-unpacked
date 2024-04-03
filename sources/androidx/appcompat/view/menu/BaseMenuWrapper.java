package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final Context f698a;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    public BaseMenuWrapper(Context context) {
        this.f698a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.mMenuItems.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f698a, supportMenuItem);
        this.mMenuItems.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu b(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.mSubMenus.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f698a, supportSubMenu);
        this.mSubMenus.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    public final void c() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.mSubMenus;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    public final void d(int i11) {
        if (this.mMenuItems != null) {
            int i12 = 0;
            while (i12 < this.mMenuItems.size()) {
                if (this.mMenuItems.keyAt(i12).getGroupId() == i11) {
                    this.mMenuItems.removeAt(i12);
                    i12--;
                }
                i12++;
            }
        }
    }

    public final void e(int i11) {
        if (this.mMenuItems != null) {
            for (int i12 = 0; i12 < this.mMenuItems.size(); i12++) {
                if (this.mMenuItems.keyAt(i12).getItemId() == i11) {
                    this.mMenuItems.removeAt(i12);
                    return;
                }
            }
        }
    }
}
