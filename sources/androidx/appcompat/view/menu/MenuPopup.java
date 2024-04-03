package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    public static int b(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i12 = 0;
        int i13 = 0;
        View view = null;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = listAdapter.getItemViewType(i14);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i14, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i11) {
                return i11;
            }
            if (measuredWidth > i12) {
                i12 = measuredWidth;
            }
        }
        return i12;
    }

    public static boolean c(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = menuBuilder.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static MenuAdapter d(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    public boolean a() {
        return true;
    }

    public abstract void addMenu(MenuBuilder menuBuilder);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        int i12;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        MenuBuilder menuBuilder = d(listAdapter).f721b;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i11);
        if (a()) {
            i12 = 0;
        } else {
            i12 = 4;
        }
        menuBuilder.performItemAction(menuItem, this, i12);
    }

    public abstract void setAnchorView(View view);

    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public abstract void setForceShowIcon(boolean z11);

    public abstract void setGravity(int i11);

    public abstract void setHorizontalOffset(int i11);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z11);

    public abstract void setVerticalOffset(int i11);
}
