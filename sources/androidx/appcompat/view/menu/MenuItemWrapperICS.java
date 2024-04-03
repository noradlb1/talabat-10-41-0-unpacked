package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    public class ActionProviderWrapper extends ActionProvider {

        /* renamed from: a  reason: collision with root package name */
        public final android.view.ActionProvider f725a;

        public ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f725a = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f725a.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f725a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f725a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f725a.onPrepareSubMenu(MenuItemWrapperICS.this.b(subMenu));
        }
    }

    @RequiresApi(16)
    public class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;

        public ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean isVisible() {
            return this.f725a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z11) {
            ActionProvider.VisibilityListener visibilityListener = this.mListener;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z11);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f725a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f725a.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.f725a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            ActionProviderWrapperJB actionProviderWrapperJB;
            this.mListener = visibilityListener;
            android.view.ActionProvider actionProvider = this.f725a;
            if (visibilityListener != null) {
                actionProviderWrapperJB = this;
            } else {
                actionProviderWrapperJB = null;
            }
            actionProvider.setVisibilityListener(actionProviderWrapperJB);
        }
    }

    public static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* renamed from: b  reason: collision with root package name */
        public final android.view.CollapsibleActionView f728b;

        public CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f728b = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f728b;
        }

        public void onActionViewCollapsed() {
            this.f728b.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f728b.onActionViewExpanded();
        }
    }

    public class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;

        public OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.mObject = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.mObject.onMenuItemActionCollapse(MenuItemWrapperICS.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.mObject.onMenuItemActionExpand(MenuItemWrapperICS.this.a(menuItem));
        }
    }

    public class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;

        public OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.mObject = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.mObject.onMenuItemClick(MenuItemWrapperICS.this.a(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.mWrappedObject = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.mWrappedObject.getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).f725a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).a();
        }
        return actionView;
    }

    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    public SubMenu getSubMenu() {
        return b(this.mWrappedObject.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderWrapperJB actionProviderWrapperJB = new ActionProviderWrapperJB(this.f698a, actionProvider);
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (actionProvider == null) {
            actionProviderWrapperJB = null;
        }
        supportMenuItem.setSupportActionProvider(actionProviderWrapperJB);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mWrappedObject.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c11) {
        this.mWrappedObject.setAlphabeticShortcut(c11);
        return this;
    }

    public MenuItem setCheckable(boolean z11) {
        this.mWrappedObject.setCheckable(z11);
        return this;
    }

    public MenuItem setChecked(boolean z11) {
        this.mWrappedObject.setChecked(z11);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mWrappedObject.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z11) {
        this.mWrappedObject.setEnabled(z11);
        return this;
    }

    public void setExclusiveCheckable(boolean z11) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(z11)});
        } catch (Exception e11) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
        }
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mWrappedObject.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mWrappedObject.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mWrappedObject.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mWrappedObject.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c11) {
        this.mWrappedObject.setNumericShortcut(c11);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        OnActionExpandListenerWrapper onActionExpandListenerWrapper;
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (onActionExpandListener != null) {
            onActionExpandListenerWrapper = new OnActionExpandListenerWrapper(onActionExpandListener);
        } else {
            onActionExpandListenerWrapper = null;
        }
        supportMenuItem.setOnActionExpandListener(onActionExpandListenerWrapper);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        OnMenuItemClickListenerWrapper onMenuItemClickListenerWrapper;
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListenerWrapper = new OnMenuItemClickListenerWrapper(onMenuItemClickListener);
        } else {
            onMenuItemClickListenerWrapper = null;
        }
        supportMenuItem.setOnMenuItemClickListener(onMenuItemClickListenerWrapper);
        return this;
    }

    public MenuItem setShortcut(char c11, char c12) {
        this.mWrappedObject.setShortcut(c11, c12);
        return this;
    }

    public void setShowAsAction(int i11) {
        this.mWrappedObject.setShowAsAction(i11);
    }

    public MenuItem setShowAsActionFlags(int i11) {
        this.mWrappedObject.setShowAsActionFlags(i11);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mWrappedObject.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mWrappedObject.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z11) {
        return this.mWrappedObject.setVisible(z11);
    }

    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.mWrappedObject.setAlphabeticShortcut(c11, i11);
        return this;
    }

    public MenuItem setIcon(int i11) {
        this.mWrappedObject.setIcon(i11);
        return this;
    }

    public MenuItem setNumericShortcut(char c11, int i11) {
        this.mWrappedObject.setNumericShortcut(c11, i11);
        return this;
    }

    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.mWrappedObject.setShortcut(c11, c12, i11, i12);
        return this;
    }

    public MenuItem setTitle(int i11) {
        this.mWrappedObject.setTitle(i11);
        return this;
    }

    public MenuItem setActionView(int i11) {
        this.mWrappedObject.setActionView(i11);
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.mWrappedObject.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
