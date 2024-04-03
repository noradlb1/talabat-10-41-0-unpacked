package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    public final DecorToolbar f606a;

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f607b;

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatDelegateImpl.ActionBarMenuCallback f608c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f609d;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator = new Runnable() {
        public void run() {
            ToolbarActionBar.this.b();
        }
    };
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;

        public ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z11) {
            if (!this.mClosingActionMenu) {
                this.mClosingActionMenu = true;
                ToolbarActionBar.this.f606a.dismissPopupMenus();
                ToolbarActionBar.this.f607b.onPanelClosed(108, menuBuilder);
                this.mClosingActionMenu = false;
            }
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f607b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f606a.isOverflowMenuShowing()) {
                ToolbarActionBar.this.f607b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f607b.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.f607b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    public class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        public ToolbarMenuCallback() {
        }

        public View onCreatePanelView(int i11) {
            if (i11 == 0) {
                return new View(ToolbarActionBar.this.f606a.getContext());
            }
            return null;
        }

        public boolean onPreparePanel(int i11) {
            if (i11 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f609d) {
                return false;
            }
            toolbarActionBar.f606a.setMenuPrepared();
            ToolbarActionBar.this.f609d = true;
            return false;
        }
    }

    public ToolbarActionBar(@NonNull Toolbar toolbar, @Nullable CharSequence charSequence, @NonNull Window.Callback callback) {
        AnonymousClass2 r02 = new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f607b.onMenuItemSelected(0, menuItem);
            }
        };
        this.mMenuClicker = r02;
        Preconditions.checkNotNull(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f606a = toolbarWidgetWrapper;
        this.f607b = (Window.Callback) Preconditions.checkNotNull(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(r02);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f608c = new ToolbarMenuCallback();
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.f606a.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.mMenuCallbackSet = true;
        }
        return this.f606a.getMenu();
    }

    public void a() {
        this.f606a.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void b() {
        MenuBuilder menuBuilder;
        Menu menu = getMenu();
        if (menu instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder) menu;
        } else {
            menuBuilder = null;
        }
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.f607b.onCreatePanelMenu(0, menu) || !this.f607b.onPreparePanel(0, (View) null, menu)) {
                menu.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    public boolean closeOptionsMenu() {
        return this.f606a.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if (!this.f606a.hasExpandedActionView()) {
            return false;
        }
        this.f606a.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z11) {
        if (z11 != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z11;
            int size = this.mMenuVisibilityListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mMenuVisibilityListeners.get(i11).onMenuVisibilityChanged(z11);
            }
        }
    }

    public View getCustomView() {
        return this.f606a.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f606a.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f606a.getViewGroup());
    }

    public int getHeight() {
        return this.f606a.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.f606a.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.f606a.getContext();
    }

    public CharSequence getTitle() {
        return this.f606a.getTitle();
    }

    public void hide() {
        this.f606a.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.f606a.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.f606a.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    public boolean isShowing() {
        return this.f606a.getVisibility() == 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public boolean onKeyShortcut(int i11, KeyEvent keyEvent) {
        int i12;
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        if (keyEvent != null) {
            i12 = keyEvent.getDeviceId();
        } else {
            i12 = -1;
        }
        boolean z11 = true;
        if (KeyCharacterMap.load(i12).getKeyboardType() == 1) {
            z11 = false;
        }
        menu.setQwertyMode(z11);
        return menu.performShortcut(i11, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.f606a.showOverflowMenu();
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f606a.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f606a.setBackgroundDrawable(drawable);
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z11) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z11) {
        setDisplayOptions(z11 ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i11) {
        setDisplayOptions(i11, -1);
    }

    public void setDisplayShowCustomEnabled(boolean z11) {
        setDisplayOptions(z11 ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z11) {
        setDisplayOptions(z11 ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z11) {
        setDisplayOptions(z11 ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z11) {
        setDisplayOptions(z11 ? 1 : 0, 1);
    }

    public void setElevation(float f11) {
        ViewCompat.setElevation(this.f606a.getViewGroup(), f11);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f606a.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f606a.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z11) {
    }

    public void setIcon(int i11) {
        this.f606a.setIcon(i11);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f606a.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i11) {
        this.f606a.setLogo(i11);
    }

    public void setNavigationMode(int i11) {
        if (i11 != 2) {
            this.f606a.setNavigationMode(i11);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int i11) {
        if (this.f606a.getNavigationMode() == 1) {
            this.f606a.setDropdownSelectedPosition(i11);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean z11) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f606a.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f606a.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f606a.setWindowTitle(charSequence);
    }

    public void show() {
        this.f606a.setVisibility(0);
    }

    public void addTab(ActionBar.Tab tab, boolean z11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f606a.setCustomView(view);
    }

    public void setDisplayOptions(int i11, int i12) {
        this.f606a.setDisplayOptions((i11 & i12) | ((~i12) & this.f606a.getDisplayOptions()));
    }

    public void setHomeActionContentDescription(int i11) {
        this.f606a.setNavigationContentDescription(i11);
    }

    public void setHomeAsUpIndicator(int i11) {
        this.f606a.setNavigationIcon(i11);
    }

    public void setIcon(Drawable drawable) {
        this.f606a.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.f606a.setLogo(drawable);
    }

    public void setSubtitle(int i11) {
        DecorToolbar decorToolbar = this.f606a;
        decorToolbar.setSubtitle(i11 != 0 ? decorToolbar.getContext().getText(i11) : null);
    }

    public void setTitle(int i11) {
        DecorToolbar decorToolbar = this.f606a;
        decorToolbar.setTitle(i11 != 0 ? decorToolbar.getContext().getText(i11) : null);
    }

    public void addTab(ActionBar.Tab tab, int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i11, boolean z11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(int i11) {
        setCustomView(LayoutInflater.from(this.f606a.getContext()).inflate(i11, this.f606a.getViewGroup(), false));
    }
}
