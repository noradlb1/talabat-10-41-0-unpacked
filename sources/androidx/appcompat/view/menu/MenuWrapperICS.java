package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return a(this.mWrappedObject.add(charSequence));
    }

    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i11, i12, i13, componentName, intentArr, intent, i14, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i15 = 0; i15 < length; i15++) {
                menuItemArr3[i15] = a(menuItemArr2[i15]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return b(this.mWrappedObject.addSubMenu(charSequence));
    }

    public void clear() {
        c();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int i11) {
        return a(this.mWrappedObject.findItem(i11));
    }

    public MenuItem getItem(int i11) {
        return a(this.mWrappedObject.getItem(i11));
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i11, keyEvent);
    }

    public boolean performIdentifierAction(int i11, int i12) {
        return this.mWrappedObject.performIdentifierAction(i11, i12);
    }

    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        return this.mWrappedObject.performShortcut(i11, keyEvent, i12);
    }

    public void removeGroup(int i11) {
        d(i11);
        this.mWrappedObject.removeGroup(i11);
    }

    public void removeItem(int i11) {
        e(i11);
        this.mWrappedObject.removeItem(i11);
    }

    public void setGroupCheckable(int i11, boolean z11, boolean z12) {
        this.mWrappedObject.setGroupCheckable(i11, z11, z12);
    }

    public void setGroupEnabled(int i11, boolean z11) {
        this.mWrappedObject.setGroupEnabled(i11, z11);
    }

    public void setGroupVisible(int i11, boolean z11) {
        this.mWrappedObject.setGroupVisible(i11, z11);
    }

    public void setQwertyMode(boolean z11) {
        this.mWrappedObject.setQwertyMode(z11);
    }

    public int size() {
        return this.mWrappedObject.size();
    }

    public MenuItem add(int i11) {
        return a(this.mWrappedObject.add(i11));
    }

    public SubMenu addSubMenu(int i11) {
        return b(this.mWrappedObject.addSubMenu(i11));
    }

    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return a(this.mWrappedObject.add(i11, i12, i13, charSequence));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        return b(this.mWrappedObject.addSubMenu(i11, i12, i13, charSequence));
    }

    public MenuItem add(int i11, int i12, int i13, int i14) {
        return a(this.mWrappedObject.add(i11, i12, i13, i14));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return b(this.mWrappedObject.addSubMenu(i11, i12, i13, i14));
    }
}
