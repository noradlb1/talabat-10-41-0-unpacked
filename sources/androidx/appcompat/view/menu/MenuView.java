package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i11);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z11);

        void setChecked(boolean z11);

        void setEnabled(boolean z11);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z11, char c11);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
