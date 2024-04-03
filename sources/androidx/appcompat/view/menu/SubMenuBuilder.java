package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import com.facebook.internal.security.CertificateUtil;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.mParentMenu = menuBuilder;
        this.mItem = menuItemImpl;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.collapseItemActionView(menuItemImpl);
    }

    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (super.dispatchMenuItemSelected(menuBuilder, menuItem) || this.mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int i11;
        MenuItemImpl menuItemImpl = this.mItem;
        if (menuItemImpl != null) {
            i11 = menuItemImpl.getItemId();
        } else {
            i11 = 0;
        }
        if (i11 == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + CertificateUtil.DELIMITER + i11;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.mParentMenu.setCallback(callback);
    }

    public void setGroupDividerEnabled(boolean z11) {
        this.mParentMenu.setGroupDividerEnabled(z11);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z11) {
        this.mParentMenu.setQwertyMode(z11);
    }

    public void setShortcutsVisible(boolean z11) {
        this.mParentMenu.setShortcutsVisible(z11);
    }

    public SubMenu setHeaderIcon(int i11) {
        return (SubMenu) super.setHeaderIconInt(i11);
    }

    public SubMenu setHeaderTitle(int i11) {
        return (SubMenu) super.setHeaderTitleInt(i11);
    }

    public SubMenu setIcon(int i11) {
        this.mItem.setIcon(i11);
        return this;
    }
}
