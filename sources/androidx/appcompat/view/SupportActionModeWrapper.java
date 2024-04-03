package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f671a;

    /* renamed from: b  reason: collision with root package name */
    public final ActionMode f672b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f673a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f674b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<SupportActionModeWrapper> f675c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final SimpleArrayMap<Menu, Menu> f676d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f674b = context;
            this.f673a = callback;
        }

        private Menu getMenuWrapper(Menu menu) {
            Menu menu2 = this.f676d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f674b, (SupportMenu) menu);
            this.f676d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f675c.size();
            for (int i11 = 0; i11 < size; i11++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f675c.get(i11);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f672b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f674b, actionMode);
            this.f675c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f673a.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.f674b, (SupportMenuItem) menuItem));
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f673a.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f673a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f673a.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f671a = context;
        this.f672b = actionMode;
    }

    public void finish() {
        this.f672b.finish();
    }

    public View getCustomView() {
        return this.f672b.getCustomView();
    }

    public Menu getMenu() {
        return new MenuWrapperICS(this.f671a, (SupportMenu) this.f672b.getMenu());
    }

    public MenuInflater getMenuInflater() {
        return this.f672b.getMenuInflater();
    }

    public CharSequence getSubtitle() {
        return this.f672b.getSubtitle();
    }

    public Object getTag() {
        return this.f672b.getTag();
    }

    public CharSequence getTitle() {
        return this.f672b.getTitle();
    }

    public boolean getTitleOptionalHint() {
        return this.f672b.getTitleOptionalHint();
    }

    public void invalidate() {
        this.f672b.invalidate();
    }

    public boolean isTitleOptional() {
        return this.f672b.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.f672b.setCustomView(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f672b.setSubtitle(charSequence);
    }

    public void setTag(Object obj) {
        this.f672b.setTag(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f672b.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z11) {
        this.f672b.setTitleOptionalHint(z11);
    }

    public void setSubtitle(int i11) {
        this.f672b.setSubtitle(i11);
    }

    public void setTitle(int i11) {
        this.f672b.setTitle(i11);
    }
}
