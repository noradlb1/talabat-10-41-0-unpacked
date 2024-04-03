package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;
    @Px
    int dividerInsetEnd;
    @Px
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;

    /* renamed from: id  reason: collision with root package name */
    private int f44532id;
    boolean isBehindStatusBar = true;
    Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    /* access modifiers changed from: private */
    public int itemMaxLines;
    @Px
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z11 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z11 = false;
            } else {
                NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z11) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };
    private int overScrollMode = -1;
    int paddingSeparator;
    private int paddingTopDefault;
    @Nullable
    ColorStateList subheaderColor;
    @Px
    int subheaderInsetEnd;
    @Px
    int subheaderInsetStart;
    int subheaderTextAppearance = 0;
    int textAppearance = 0;
    ColorStateList textColor;

    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<NavigationMenuItem> items = new ArrayList<>();
        private boolean updateSuspended;

        public NavigationMenuAdapter() {
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int i11, int i12) {
            while (i11 < i12) {
                ((NavigationMenuTextItem) this.items.get(i11)).needsEmptyIcon = true;
                i11++;
            }
        }

        private void prepareMenuItems() {
            if (!this.updateSuspended) {
                boolean z11 = true;
                this.updateSuspended = true;
                this.items.clear();
                this.items.add(new NavigationMenuHeaderItem());
                int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
                int i11 = -1;
                int i12 = 0;
                boolean z12 = false;
                int i13 = 0;
                while (i12 < size) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i12);
                    if (menuItemImpl.isChecked()) {
                        setCheckedItem(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i12 != 0) {
                                this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
                            }
                            this.items.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = this.items.size();
                            int size3 = subMenu.size();
                            int i14 = 0;
                            boolean z13 = false;
                            while (i14 < size3) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i14);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z13 && menuItemImpl2.getIcon() != null) {
                                        z13 = z11;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        setCheckedItem(menuItemImpl);
                                    }
                                    this.items.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                                i14++;
                                z11 = true;
                            }
                            if (z13) {
                                appendTransparentIconIfMissing(size2, this.items.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i11) {
                            i13 = this.items.size();
                            if (menuItemImpl.getIcon() != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (i12 != 0) {
                                i13++;
                                ArrayList<NavigationMenuItem> arrayList = this.items;
                                int i15 = NavigationMenuPresenter.this.paddingSeparator;
                                arrayList.add(new NavigationMenuSeparatorItem(i15, i15));
                            }
                        } else if (!z12 && menuItemImpl.getIcon() != null) {
                            appendTransparentIconIfMissing(i13, this.items.size());
                            z12 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.needsEmptyIcon = z12;
                        this.items.add(navigationMenuTextItem);
                        i11 = groupId;
                    }
                    i12++;
                    z11 = true;
                }
                this.updateSuspended = false;
            }
        }

        @NonNull
        public Bundle createInstanceState() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.checkedItem;
            if (menuItemImpl != null) {
                bundle.putInt(STATE_CHECKED_ITEM, menuItemImpl.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.items.size();
            for (int i11 = 0; i11 < size; i11++) {
                NavigationMenuItem navigationMenuItem = this.items.get(i11);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItem = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    if (menuItem != null) {
                        view = menuItem.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
            return bundle;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        public int getItemCount() {
            return this.items.size();
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public int getItemViewType(int i11) {
            NavigationMenuItem navigationMenuItem = this.items.get(i11);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (!(navigationMenuItem instanceof NavigationMenuTextItem)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        public int getRowCount() {
            int i11;
            if (NavigationMenuPresenter.this.headerLayout.getChildCount() == 0) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            for (int i12 = 0; i12 < NavigationMenuPresenter.this.adapter.getItemCount(); i12++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i12) == 0) {
                    i11++;
                }
            }
            return i11;
        }

        public void restoreInstanceState(@NonNull Bundle bundle) {
            MenuItemImpl menuItem;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItem2;
            int i11 = bundle.getInt(STATE_CHECKED_ITEM, 0);
            if (i11 != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.items.get(i12);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItem2 = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i11) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i12++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    NavigationMenuItem navigationMenuItem2 = this.items.get(i13);
                    if (!(!(navigationMenuItem2 instanceof NavigationMenuTextItem) || (menuItem = ((NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) == null || (actionView = menuItem.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
            if (this.checkedItem != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.checkedItem;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.checkedItem = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void setUpdateSuspended(boolean z11) {
            this.updateSuspended = z11;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }

        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
                int i12 = NavigationMenuPresenter.this.textAppearance;
                if (i12 != 0) {
                    navigationMenuItemView.setTextAppearance(i12);
                }
                ColorStateList colorStateList = NavigationMenuPresenter.this.textColor;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = NavigationMenuPresenter.this.itemBackground;
                ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i11);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                int i13 = navigationMenuPresenter.itemHorizontalPadding;
                int i14 = navigationMenuPresenter.itemVerticalPadding;
                navigationMenuItemView.setPadding(i13, i14, i13, i14);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
                navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
            } else if (itemViewType == 1) {
                TextView textView = (TextView) viewHolder.itemView;
                textView.setText(((NavigationMenuTextItem) this.items.get(i11)).getMenuItem().getTitle());
                int i15 = NavigationMenuPresenter.this.subheaderTextAppearance;
                if (i15 != 0) {
                    TextViewCompat.setTextAppearance(textView, i15);
                }
                textView.setPadding(NavigationMenuPresenter.this.subheaderInsetStart, textView.getPaddingTop(), NavigationMenuPresenter.this.subheaderInsetEnd, textView.getPaddingBottom());
                ColorStateList colorStateList2 = NavigationMenuPresenter.this.subheaderColor;
                if (colorStateList2 != null) {
                    textView.setTextColor(colorStateList2);
                }
            } else if (itemViewType == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i11);
                viewHolder.itemView.setPadding(NavigationMenuPresenter.this.dividerInsetStart, navigationMenuSeparatorItem.getPaddingTop(), NavigationMenuPresenter.this.dividerInsetEnd, navigationMenuSeparatorItem.getPaddingBottom());
            }
        }

        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            } else if (i11 == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else {
                if (i11 == 2) {
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
                }
                if (i11 != 3) {
                    return null;
                }
                return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
            }
        }

        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }
    }

    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
    }

    public interface NavigationMenuItem {
    }

    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i11, int i12) {
            this.paddingTop = i11;
            this.paddingBottom = i12;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    public static class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        public NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.menuItem = menuItemImpl;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        public NavigationMenuViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(NavigationMenuPresenter.this.adapter.getRowCount(), 0, false));
        }
    }

    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private void updateTopPadding() {
        int i11;
        if (this.headerLayout.getChildCount() != 0 || !this.isBehindStatusBar) {
            i11 = 0;
        } else {
            i11 = this.paddingTopDefault;
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i11, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != systemWindowInsetTop) {
            this.paddingTopDefault = systemWindowInsetTop;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i11) {
        return this.headerLayout.getChildAt(i11);
    }

    public int getId() {
        return this.f44532id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.menuView));
            if (this.adapter == null) {
                this.adapter = new NavigationMenuAdapter();
            }
            int i11 = this.overScrollMode;
            if (i11 != -1) {
                this.menuView.setOverScrollMode(i11);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(@LayoutRes int i11) {
        View inflate = this.layoutInflater.inflate(i11, this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        MenuPresenter.Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onCloseMenu(menuBuilder, z11);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray sparseArray = new SparseArray();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z11) {
        if (this.isBehindStatusBar != z11) {
            this.isBehindStatusBar = z11;
            updateTopPadding();
        }
    }

    public void setCallback(MenuPresenter.Callback callback2) {
        this.callback = callback2;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setDividerInsetEnd(@Px int i11) {
        this.dividerInsetEnd = i11;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int i11) {
        this.dividerInsetStart = i11;
        updateMenuView(false);
    }

    public void setId(int i11) {
        this.f44532id = i11;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i11) {
        this.itemHorizontalPadding = i11;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i11) {
        this.itemIconPadding = i11;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i11) {
        if (this.itemIconSize != i11) {
            this.itemIconSize = i11;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i11) {
        this.itemMaxLines = i11;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i11) {
        this.textAppearance = i11;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int i11) {
        this.itemVerticalPadding = i11;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i11) {
        this.overScrollMode = i11;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i11);
        }
    }

    public void setSubheaderColor(@Nullable ColorStateList colorStateList) {
        this.subheaderColor = colorStateList;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int i11) {
        this.subheaderInsetEnd = i11;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int i11) {
        this.subheaderInsetStart = i11;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int i11) {
        this.subheaderTextAppearance = i11;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z11) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z11);
        }
    }

    public void updateMenuView(boolean z11) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }
}
