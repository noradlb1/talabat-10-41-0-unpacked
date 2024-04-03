package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";

    /* renamed from: a  reason: collision with root package name */
    public MenuBuilder f723a;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded = false;
    private Runnable mItemCallback;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint = false;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public MenuItemImpl(MenuBuilder menuBuilder, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        this.f723a = menuBuilder;
        this.mId = i12;
        this.mGroup = i11;
        this.mCategoryOrder = i13;
        this.mOrdering = i14;
        this.mTitle = charSequence;
        this.mShowAsAction = i15;
    }

    private static void appendModifier(StringBuilder sb2, int i11, int i12, String str) {
        if ((i11 & i12) == i12) {
            sb2.append(str);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.mHasIconTint) {
                DrawableCompat.setTintList(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat.setTintMode(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    public char a() {
        return this.f723a.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
    }

    public void actionFormatChanged() {
        this.f723a.onItemActionRequestChanged(this);
    }

    public String b() {
        int i11;
        char a11 = a();
        if (a11 == 0) {
            return "";
        }
        Resources resources = this.f723a.getContext().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f723a.getContext()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        if (this.f723a.isQwertyMode()) {
            i11 = this.mShortcutAlphabeticModifiers;
        } else {
            i11 = this.mShortcutNumericModifiers;
        }
        appendModifier(sb2, i11, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        appendModifier(sb2, i11, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        appendModifier(sb2, i11, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        appendModifier(sb2, i11, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        appendModifier(sb2, i11, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        appendModifier(sb2, i11, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (a11 == 8) {
            sb2.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (a11 == 10) {
            sb2.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (a11 != ' ') {
            sb2.append(a11);
        } else {
            sb2.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    public CharSequence c(MenuView.ItemView itemView) {
        if (itemView == null || !itemView.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f723a.collapseItemActionView(this);
        }
        return false;
    }

    public void d(boolean z11) {
        int i11;
        int i12 = this.mFlags;
        int i13 = i12 & -3;
        if (z11) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int i14 = i11 | i13;
        this.mFlags = i14;
        if (i12 != i14) {
            this.f723a.onItemsChanged(false);
        }
    }

    public void e(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f723a.expandItemActionView(this);
        }
        return false;
    }

    public boolean f(boolean z11) {
        int i11;
        int i12 = this.mFlags;
        int i13 = i12 & -9;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        int i14 = i11 | i13;
        this.mFlags = i14;
        if (i12 != i14) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.f723a.isShortcutsVisible() && a() != 0;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.mActionView;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.mActionView = onCreateActionView;
        return onCreateActionView;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return applyIconTintIfNecessary(drawable);
        }
        if (this.mIconResId == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.f723a.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = drawable2;
        return applyIconTintIfNecessary(drawable2);
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        return charSequence != null ? charSequence : this.mTitle;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null && (actionProvider = this.mActionProvider) != null) {
            this.mActionView = actionProvider.onCreateActionView(this);
        }
        if (this.mActionView != null) {
            return true;
        }
        return false;
    }

    public boolean hasSubMenu() {
        return this.mSubMenu != null;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f723a;
        if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.mItemCallback;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.f723a.getContext().startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e11) {
                Log.e(TAG, "Can't find activity to handle intent; ignoring", e11);
            }
        }
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null || !actionProvider.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isActionButton() {
        return (this.mFlags & 32) == 32;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.mFlags & 4) != 0;
    }

    public boolean isVisible() {
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null || !actionProvider.overridesItemVisibility()) {
            if ((this.mFlags & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.mFlags & 8) != 0 || !this.mActionProvider.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean requestsActionButton() {
        return (this.mShowAsAction & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.mShowAsAction & 2) == 2;
    }

    public boolean requiresOverflow() {
        return !requiresActionButton() && !requestsActionButton();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z11) {
        this.mIsActionViewExpanded = z11;
        this.f723a.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c11) {
        if (this.mShortcutAlphabeticChar == c11) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean z11) {
        int i11 = this.mFlags;
        boolean z12 = z11 | (i11 & true);
        this.mFlags = z12 ? 1 : 0;
        if (i11 != z12) {
            this.f723a.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z11) {
        if ((this.mFlags & 4) != 0) {
            this.f723a.setExclusiveItemChecked(this);
        } else {
            d(z11);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z11) {
        if (z11) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.f723a.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z11) {
        this.mFlags = (z11 ? 4 : 0) | (this.mFlags & -5);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean z11) {
        if (z11) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public MenuItem setNumericShortcut(char c11) {
        if (this.mShortcutNumericChar == c11) {
            return this;
        }
        this.mShortcutNumericChar = c11;
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c11, char c12) {
        this.mShortcutNumericChar = c11;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c12);
        this.f723a.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i11) {
        int i12 = i11 & 3;
        if (i12 == 0 || i12 == 1 || i12 == 2) {
            this.mShowAsAction = i11;
            this.f723a.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @NonNull
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.mActionProvider;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.f723a.onItemsChanged(true);
        ActionProvider actionProvider3 = this.mActionProvider;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z11) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.f723a.onItemVisibleChanged(menuItemImpl);
                }
            });
        }
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.f723a.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z11) {
        if (f(z11)) {
            this.f723a.onItemVisibleChanged(this);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.f723a.getOptionalIconsVisible();
    }

    public boolean showsTextAsAction() {
        return (this.mShowAsAction & 4) == 4;
    }

    public String toString() {
        CharSequence charSequence = this.mTitle;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public SupportMenuItem setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public SupportMenuItem setActionView(View view) {
        int i11;
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && (i11 = this.mId) > 0) {
            view.setId(i11);
        }
        this.f723a.onItemActionRequestChanged(this);
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        if (this.mShortcutAlphabeticChar == c11 && this.mShortcutAlphabeticModifiers == i11) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i11);
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c11, int i11) {
        if (this.mShortcutNumericChar == c11 && this.mShortcutNumericModifiers == i11) {
            return this;
        }
        this.mShortcutNumericChar = c11;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i11);
        this.f723a.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.mShortcutNumericChar = c11;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i11);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c12);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i12);
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i11) {
        this.mIconDrawable = null;
        this.mIconResId = i11;
        this.mNeedToApplyIconTint = true;
        this.f723a.onItemsChanged(false);
        return this;
    }

    public MenuItem setTitle(int i11) {
        return setTitle((CharSequence) this.f723a.getContext().getString(i11));
    }

    @NonNull
    public SupportMenuItem setActionView(int i11) {
        Context context = this.f723a.getContext();
        setActionView(LayoutInflater.from(context).inflate(i11, new LinearLayout(context), false));
        return this;
    }
}
