package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled = false;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    private ArrayList<MenuItemImpl> mVisibleItems;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        return new MenuItemImpl(this, i11, i12, i13, i14, charSequence, i15);
    }

    private void dispatchPresenterUpdate(boolean z11) {
        if (!this.mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    menuPresenter.updateMenuView(z11);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id2 = menuPresenter.getId();
                    if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.mPresenters.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id2 = menuPresenter.getId();
                    if (id2 > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id2, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
        }
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z11 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z11 = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.mPresenters.remove(next);
            } else if (!z11) {
                z11 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return z11;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int i11) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i11) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i11) {
        int i12 = (-65536 & i11) >> 16;
        if (i12 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i12 < iArr.length) {
                return (i11 & 65535) | (iArr[i12] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i11, boolean z11) {
        if (i11 >= 0 && i11 < this.mItems.size()) {
            this.mItems.remove(i11);
            if (z11) {
                onItemsChanged(true);
            }
        }
    }

    private void setHeaderInternal(int i11, CharSequence charSequence, int i12, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i11 > 0) {
                this.mHeaderTitle = resources.getText(i11);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i12 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(getContext(), i12);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration.get(r2.mContext), r2.mContext) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setShortcutsVisibleInner(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x001c
            android.content.res.Resources r3 = r2.mResources
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L_0x001c
            android.content.Context r3 = r2.mContext
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.mContext
            boolean r3 = androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r2.mShortcutsVisible = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.setShortcutsVisibleInner(boolean):void");
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        int i15;
        Intent intent2;
        int i16;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i15 = queryIntentActivityOptions.size();
        } else {
            i15 = 0;
        }
        if ((i14 & 1) == 0) {
            removeGroup(i11);
        }
        for (int i17 = 0; i17 < i15; i17++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i17);
            int i18 = resolveInfo.specificIndex;
            if (i18 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i18];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i11, i12, i13, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i16 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i16] = intent4;
            }
        }
        return i15;
    }

    public MenuItem addInternal(int i11, int i12, int i13, CharSequence charSequence) {
        int ordering = getOrdering(i13);
        MenuItemImpl createNewMenuItem = createNewMenuItem(i11, i12, i13, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.e(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.mContext);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z11) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z11);
                }
            }
            this.mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z11 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z11 = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z11) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z11) {
                this.mExpandedItem = null;
            }
        }
        return z11;
    }

    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.mCallback;
        return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z11 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter = (MenuPresenter) next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                z11 = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z11) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z11) {
            this.mExpandedItem = menuItemImpl;
        }
        return z11;
    }

    public int findGroupIndex(int i11) {
        return findGroupIndex(i11, 0);
    }

    public MenuItem findItem(int i11) {
        MenuItem findItem;
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i12);
            if (menuItemImpl.getItemId() == i11) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i11)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.mItems.get(i12).getItemId() == i11) {
                return i12;
            }
        }
        return -1;
    }

    public MenuItemImpl findItemWithShortcutForKey(int i11, KeyEvent keyEvent) {
        char c11;
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i11, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItemImpl menuItemImpl = arrayList.get(i12);
            if (isQwertyMode) {
                c11 = menuItemImpl.getAlphabeticShortcut();
            } else {
                c11 = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c11 == cArr[0] && (metaState & 2) == 0) || ((c11 == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c11 == 8 && i11 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public void findItemsWithShortcutForKey(List<MenuItemImpl> list, int i11, KeyEvent keyEvent) {
        char c11;
        int i12;
        boolean z11;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i11 == 67) {
            int size = this.mItems.size();
            for (int i13 = 0; i13 < size; i13++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i13);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, i11, keyEvent);
                }
                if (isQwertyMode) {
                    c11 = menuItemImpl.getAlphabeticShortcut();
                } else {
                    c11 = menuItemImpl.getNumericShortcut();
                }
                if (isQwertyMode) {
                    i12 = menuItemImpl.getAlphabeticModifiers();
                } else {
                    i12 = menuItemImpl.getNumericModifiers();
                }
                if ((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == (i12 & SupportMenu.SUPPORTED_MODIFIERS_MASK)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && c11 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c11 == cArr[0] || c11 == cArr[2] || (isQwertyMode && c11 == 8 && i11 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z11 |= menuPresenter.flagActionItems();
                }
            }
            if (z11) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i11 = 0; i11 < size; i11++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i11);
                    if (menuItemImpl.isActionButton()) {
                        this.mActionItems.add(menuItemImpl);
                    } else {
                        this.mNonActionItems.add(menuItemImpl);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int i11) {
        return this.mItems.get(i11);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i11);
            if (menuItemImpl.isVisible()) {
                this.mVisibleItems.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.mItems.get(i11).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i11, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z11) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z11) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z11);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z11) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int i11, int i12) {
        return performItemAction(findItem(i11), i12);
    }

    public boolean performItemAction(MenuItem menuItem, int i11) {
        return performItemAction(menuItem, (MenuPresenter) null, i11);
    }

    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        boolean z11;
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i11, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z11 = performItemAction(findItemWithShortcutForKey, i12);
        } else {
            z11 = false;
        }
        if ((i12 & 2) != 0) {
            close(true);
        }
        return z11;
    }

    public void removeGroup(int i11) {
        int findGroupIndex = findGroupIndex(i11);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (i12 >= size || this.mItems.get(findGroupIndex).getGroupId() != i11) {
                    onItemsChanged(true);
                } else {
                    removeItemAtInt(findGroupIndex, false);
                    i12 = i13;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i11) {
        removeItemAtInt(findItemIndex(i11), true);
    }

    public void removeItemAt(int i11) {
        removeItemAtInt(i11, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i11 = 0; i11 < size; i11++) {
                MenuItem item = getItem(i11);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i12 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
            if (i12 > 0 && (findItem = findItem(i12)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i11) {
        this.mDefaultShowAsAction = i11;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        boolean z11;
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i11);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                if (menuItemImpl == menuItem) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                menuItemImpl.d(z11);
            }
        }
        startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int i11, boolean z11, boolean z12) {
        int size = this.mItems.size();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i12);
            if (menuItemImpl.getGroupId() == i11) {
                menuItemImpl.setExclusiveCheckable(z12);
                menuItemImpl.setCheckable(z11);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z11) {
        this.mGroupDividerEnabled = z11;
    }

    public void setGroupEnabled(int i11, boolean z11) {
        int size = this.mItems.size();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i12);
            if (menuItemImpl.getGroupId() == i11) {
                menuItemImpl.setEnabled(z11);
            }
        }
    }

    public void setGroupVisible(int i11, boolean z11) {
        int size = this.mItems.size();
        boolean z12 = false;
        for (int i12 = 0; i12 < size; i12++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i12);
            if (menuItemImpl.getGroupId() == i11 && menuItemImpl.f(z11)) {
                z12 = true;
            }
        }
        if (z12) {
            onItemsChanged(true);
        }
    }

    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z11) {
        this.mOptionalIconsVisible = z11;
    }

    public void setOverrideVisibleItems(boolean z11) {
        this.mOverrideVisibleItems = z11;
    }

    public void setQwertyMode(boolean z11) {
        this.mQwertyMode = z11;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z11) {
        if (this.mShortcutsVisible != z11) {
            setShortcutsVisibleInner(z11);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    public MenuItem add(int i11) {
        return addInternal(0, 0, 0, this.mResources.getString(i11));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int i11) {
        return addSubMenu(0, 0, 0, (CharSequence) this.mResources.getString(i11));
    }

    public int findGroupIndex(int i11, int i12) {
        int size = size();
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < size) {
            if (this.mItems.get(i12).getGroupId() == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i11) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z11 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z11) {
            if ((i11 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z11) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            invoke |= dispatchSubMenuSelected(subMenuBuilder, menuPresenter);
            if (!invoke) {
                close(true);
            }
        } else if ((i11 & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    public MenuBuilder setHeaderIconInt(int i11) {
        setHeaderInternal(0, (CharSequence) null, i11, (Drawable) null, (View) null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int i11) {
        setHeaderInternal(i11, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return addInternal(i11, i12, i13, charSequence);
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i11, i12, i13, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public MenuItem add(int i11, int i12, int i13, int i14) {
        return addInternal(i11, i12, i13, this.mResources.getString(i14));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return addSubMenu(i11, i12, i13, (CharSequence) this.mResources.getString(i14));
    }

    public void close() {
        close(true);
    }
}
