package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f699b;

    /* renamed from: c  reason: collision with root package name */
    public final List<CascadingMenuInfo> f700c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f701d = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.f700c.size() > 0 && !CascadingMenuPopup.this.f700c.get(0).window.isModal()) {
                View view = CascadingMenuPopup.this.f702e;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.f700c) {
                    cascadingMenuInfo.window.show();
                }
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public View f702e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f703f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f704g;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f703f;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f703f = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f703f.removeGlobalOnLayoutListener(cascadingMenuPopup.f701d);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final Context mContext;
    private int mDropDownGravity = 0;
    private boolean mForceShowIcon;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener() {
        public void onItemHoverEnter(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.f699b.removeCallbacksAndMessages((Object) null);
            int size = CascadingMenuPopup.this.f700c.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.f700c.get(i11).menu) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 != -1) {
                int i12 = i11 + 1;
                if (i12 < CascadingMenuPopup.this.f700c.size()) {
                    cascadingMenuInfo = CascadingMenuPopup.this.f700c.get(i12);
                }
                CascadingMenuPopup.this.f699b.postAtTime(new Runnable() {
                    public void run() {
                        CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.f704g = true;
                            cascadingMenuInfo.menu.close(false);
                            CascadingMenuPopup.this.f704g = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f699b.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus = new ArrayList();
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity = 0;
    private boolean mShowTitle;
    private int mXOffset;
    private int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i11) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i11;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i11, @StyleRes int i12, boolean z11) {
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i11;
        this.mPopupStyleRes = i12;
        this.mOverflowOnly = z11;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f699b = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, (AttributeSet) null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.mAnchorView);
        menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(@NonNull MenuBuilder menuBuilder) {
        int size = this.f700c.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (menuBuilder == this.f700c.get(i11).menu) {
                return i11;
            }
        }
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = menuBuilder.getItem(i11);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View findParentViewForSubmenu(@NonNull CascadingMenuInfo cascadingMenuInfo, @NonNull MenuBuilder menuBuilder) {
        int i11;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem findMenuItemForSubmenu = findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder);
        if (findMenuItemForSubmenu == null) {
            return null;
        }
        ListView listView = cascadingMenuInfo.getListView();
        ListAdapter adapter = listView.getAdapter();
        int i12 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i11 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i11 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i12 >= count) {
                i12 = -1;
                break;
            } else if (findMenuItemForSubmenu == menuAdapter.getItem(i12)) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 != -1 && (firstVisiblePosition = (i12 + i11) - listView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listView.getChildCount()) {
            return listView.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int getInitialMenuPosition() {
        return ViewCompat.getLayoutDirection(this.mAnchorView) == 1 ? 0 : 1;
    }

    private int getNextMenuPosition(int i11) {
        List<CascadingMenuInfo> list = this.f700c;
        ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f702e.getWindowVisibleDisplayFrame(rect);
        if (this.mLastPosition == 1) {
            if (iArr[0] + listView.getWidth() + i11 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i11 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void showMenu(@NonNull MenuBuilder menuBuilder) {
        View view;
        CascadingMenuInfo cascadingMenuInfo;
        boolean z11;
        int i11;
        int i12;
        int i13;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.mOverflowOnly, ITEM_LAYOUT);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(MenuPopup.c(menuBuilder));
        }
        int b11 = MenuPopup.b(menuAdapter, (ViewGroup) null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow createPopupWindow = createPopupWindow();
        createPopupWindow.setAdapter(menuAdapter);
        createPopupWindow.setContentWidth(b11);
        createPopupWindow.setDropDownGravity(this.mDropDownGravity);
        if (this.f700c.size() > 0) {
            List<CascadingMenuInfo> list = this.f700c;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = findParentViewForSubmenu(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            createPopupWindow.setTouchModal(false);
            createPopupWindow.setEnterTransition((Object) null);
            int nextMenuPosition = getNextMenuPosition(b11);
            if (nextMenuPosition == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mLastPosition = nextMenuPosition;
            if (Build.VERSION.SDK_INT >= 26) {
                createPopupWindow.setAnchorView(view);
                i12 = 0;
                i11 = 0;
            } else {
                int[] iArr = new int[2];
                this.mAnchorView.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.mDropDownGravity & 7) == 5) {
                    iArr[0] = iArr[0] + this.mAnchorView.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i11 = iArr2[0] - iArr[0];
                i12 = iArr2[1] - iArr[1];
            }
            if ((this.mDropDownGravity & 5) != 5) {
                if (z11) {
                    b11 = view.getWidth();
                }
                i13 = i11 - b11;
                createPopupWindow.setHorizontalOffset(i13);
                createPopupWindow.setOverlapAnchor(true);
                createPopupWindow.setVerticalOffset(i12);
            } else if (!z11) {
                b11 = view.getWidth();
                i13 = i11 - b11;
                createPopupWindow.setHorizontalOffset(i13);
                createPopupWindow.setOverlapAnchor(true);
                createPopupWindow.setVerticalOffset(i12);
            }
            i13 = i11 + b11;
            createPopupWindow.setHorizontalOffset(i13);
            createPopupWindow.setOverlapAnchor(true);
            createPopupWindow.setVerticalOffset(i12);
        } else {
            if (this.mHasXOffset) {
                createPopupWindow.setHorizontalOffset(this.mXOffset);
            }
            if (this.mHasYOffset) {
                createPopupWindow.setVerticalOffset(this.mYOffset);
            }
            createPopupWindow.setEpicenterBounds(getEpicenterBounds());
        }
        this.f700c.add(new CascadingMenuInfo(createPopupWindow, menuBuilder, this.mLastPosition));
        createPopupWindow.show();
        ListView listView = createPopupWindow.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, (Object) null, false);
            createPopupWindow.show();
        }
    }

    public boolean a() {
        return false;
    }

    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    public void dismiss() {
        int size = this.f700c.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f700c.toArray(new CascadingMenuInfo[size]);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i11];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        if (this.f700c.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.f700c;
        return list.get(list.size() - 1).getListView();
    }

    public boolean isShowing() {
        return this.f700c.size() > 0 && this.f700c.get(0).window.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        int findIndexOfAddedMenu = findIndexOfAddedMenu(menuBuilder);
        if (findIndexOfAddedMenu >= 0) {
            int i11 = findIndexOfAddedMenu + 1;
            if (i11 < this.f700c.size()) {
                this.f700c.get(i11).menu.close(false);
            }
            CascadingMenuInfo remove = this.f700c.remove(findIndexOfAddedMenu);
            remove.menu.removeMenuPresenter(this);
            if (this.f704g) {
                remove.window.setExitTransition((Object) null);
                remove.window.setAnimationStyle(0);
            }
            remove.window.dismiss();
            int size = this.f700c.size();
            if (size > 0) {
                this.mLastPosition = this.f700c.get(size - 1).position;
            } else {
                this.mLastPosition = getInitialMenuPosition();
            }
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.f703f;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f703f.removeGlobalOnLayoutListener(this.f701d);
                    }
                    this.f703f = null;
                }
                this.f702e.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mOnDismissListener.onDismiss();
            } else if (z11) {
                this.f700c.get(0).menu.close(false);
            }
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f700c.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.f700c.get(i11);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            }
            i11++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo next : this.f700c) {
            if (subMenuBuilder == next.menu) {
                next.getListView().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void setAnchorView(@NonNull View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(view));
        }
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z11) {
        this.mForceShowIcon = z11;
    }

    public void setGravity(int i11) {
        if (this.mRawDropDownGravity != i11) {
            this.mRawDropDownGravity = i11;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    public void setHorizontalOffset(int i11) {
        this.mHasXOffset = true;
        this.mXOffset = i11;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean z11) {
        this.mShowTitle = z11;
    }

    public void setVerticalOffset(int i11) {
        this.mHasYOffset = true;
        this.mYOffset = i11;
    }

    public void show() {
        boolean z11;
        if (!isShowing()) {
            for (MenuBuilder showMenu : this.mPendingMenus) {
                showMenu(showMenu);
            }
            this.mPendingMenus.clear();
            View view = this.mAnchorView;
            this.f702e = view;
            if (view != null) {
                if (this.f703f == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f703f = viewTreeObserver;
                if (z11) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f701d);
                }
                this.f702e.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
            }
        }
    }

    public void updateMenuView(boolean z11) {
        for (CascadingMenuInfo listView : this.f700c) {
            MenuPopup.d(listView.getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
