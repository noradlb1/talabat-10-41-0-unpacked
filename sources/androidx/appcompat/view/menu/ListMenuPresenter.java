package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: b  reason: collision with root package name */
    public Context f712b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f713c;

    /* renamed from: d  reason: collision with root package name */
    public MenuBuilder f714d;

    /* renamed from: e  reason: collision with root package name */
    public ExpandedMenuView f715e;

    /* renamed from: f  reason: collision with root package name */
    public int f716f;

    /* renamed from: g  reason: collision with root package name */
    public int f717g;

    /* renamed from: h  reason: collision with root package name */
    public int f718h;

    /* renamed from: i  reason: collision with root package name */
    public MenuAdapter f719i;
    private MenuPresenter.Callback mCallback;
    private int mId;

    public class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex = -1;

        public MenuAdapter() {
            a();
        }

        public void a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f714d.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f714d.getNonActionItems();
                int size = nonActionItems.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (nonActionItems.get(i11) == expandedItem) {
                        this.mExpandedIndex = i11;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f714d.getNonActionItems().size() - ListMenuPresenter.this.f716f;
            if (this.mExpandedIndex < 0) {
                return size;
            }
            return size - 1;
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f713c.inflate(listMenuPresenter.f718h, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i11), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        public MenuItemImpl getItem(int i11) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f714d.getNonActionItems();
            int i12 = i11 + ListMenuPresenter.this.f716f;
            int i13 = this.mExpandedIndex;
            if (i13 >= 0 && i12 >= i13) {
                i12++;
            }
            return nonActionItems.get(i12);
        }
    }

    public ListMenuPresenter(Context context, int i11) {
        this(i11, 0);
        this.f712b = context;
        this.f713c = LayoutInflater.from(context);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f719i == null) {
            this.f719i = new MenuAdapter();
        }
        return this.f719i;
    }

    public int getId() {
        return this.mId;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f715e == null) {
            this.f715e = (ExpandedMenuView) this.f713c.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f719i == null) {
                this.f719i = new MenuAdapter();
            }
            this.f715e.setAdapter(this.f719i);
            this.f715e.setOnItemClickListener(this);
        }
        return this.f715e;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f717g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f717g);
            this.f712b = contextThemeWrapper;
            this.f713c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f712b != null) {
            this.f712b = context;
            if (this.f713c == null) {
                this.f713c = LayoutInflater.from(context);
            }
        }
        this.f714d = menuBuilder;
        MenuAdapter menuAdapter = this.f719i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z11);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        this.f714d.performItemAction(this.f719i.getItem(i11), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f715e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).show((IBinder) null);
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f715e.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f715e;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i11) {
        this.mId = i11;
    }

    public void setItemIndexOffset(int i11) {
        this.f716f = i11;
        if (this.f715e != null) {
            updateMenuView(false);
        }
    }

    public void updateMenuView(boolean z11) {
        MenuAdapter menuAdapter = this.f719i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i11, int i12) {
        this.f718h = i11;
        this.f717g = i12;
    }
}
