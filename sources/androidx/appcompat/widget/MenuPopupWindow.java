package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @DoNotInline
        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void a(PopupWindow popupWindow, boolean z11) {
            popupWindow.setTouchModal(z11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: c  reason: collision with root package name */
        public final int f844c;

        /* renamed from: d  reason: collision with root package name */
        public final int f845d;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;

        @RequiresApi(17)
        public static class Api17Impl {
            private Api17Impl() {
            }

            @DoNotInline
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z11) {
            super(context, z11);
            if (1 == Api17Impl.a(context.getResources().getConfiguration())) {
                this.f844c = 21;
                this.f845d = 22;
                return;
            }
            this.f844c = 22;
            this.f845d = 21;
        }

        public void clearSelection() {
            setSelection(-1);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i11, boolean z11) {
            return super.lookForSelectablePosition(i11, z11);
        }

        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
            return super.measureHeightOfChildrenCompat(i11, i12, i13, i14, i15);
        }

        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i11) {
            return super.onForwardedEvent(motionEvent, i11);
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i11;
            MenuAdapter menuAdapter;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i12;
            if (this.mHoverListener != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i11 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i11 = 0;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i12 = pointToPosition - i11) < 0 || i12 >= menuAdapter.getCount()) {
                    menuItemImpl = null;
                } else {
                    menuItemImpl = menuAdapter.getItem(i12);
                }
                MenuItem menuItem = this.mHoveredMenuItem;
                if (menuItem != menuItemImpl) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.mHoverListener.onItemHoverExit(adapterMenu, menuItem);
                    }
                    this.mHoveredMenuItem = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.mHoverListener.onItemHoverEnter(adapterMenu, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i11, KeyEvent keyEvent) {
            MenuAdapter menuAdapter;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i11 == this.f844c) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i11 != this.f845d) {
                return super.onKeyDown(i11, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                }
                menuAdapter.getAdapterMenu().close(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.mHoverListener = menuItemHoverListener;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i(TAG, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    @NonNull
    public DropDownListView a(Context context, boolean z11) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z11);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    public void setEnterTransition(Object obj) {
        Api23Impl.a(this.f835f, (Transition) obj);
    }

    public void setExitTransition(Object obj) {
        Api23Impl.b(this.f835f, (Transition) obj);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    public void setTouchModal(boolean z11) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetTouchModalMethod;
            if (method != null) {
                try {
                    method.invoke(this.f835f, new Object[]{Boolean.valueOf(z11)});
                } catch (Exception unused) {
                    Log.i(TAG, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.a(this.f835f, z11);
        }
    }
}
