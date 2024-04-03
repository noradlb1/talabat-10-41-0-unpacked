package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public MenuBuilder f721b;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z11, int i11) {
        this.mOverflowOnly = z11;
        this.mInflater = layoutInflater;
        this.f721b = menuBuilder;
        this.mItemLayoutRes = i11;
        a();
    }

    public void a() {
        MenuItemImpl expandedItem = this.f721b.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f721b.getNonActionItems();
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

    public MenuBuilder getAdapterMenu() {
        return this.f721b;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> arrayList;
        if (this.mOverflowOnly) {
            arrayList = this.f721b.getNonActionItems();
        } else {
            arrayList = this.f721b.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        int i12;
        boolean z11;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int groupId = getItem(i11).getGroupId();
        int i13 = i11 - 1;
        if (i13 >= 0) {
            i12 = getItem(i13).getGroupId();
        } else {
            i12 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.f721b.isGroupDividerEnabled() || groupId == i12) {
            z11 = false;
        } else {
            z11 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z11);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i11), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z11) {
        this.mForceShowIcon = z11;
    }

    public MenuItemImpl getItem(int i11) {
        ArrayList<MenuItemImpl> nonActionItems = this.mOverflowOnly ? this.f721b.getNonActionItems() : this.f721b.getVisibleItems();
        int i12 = this.mExpandedIndex;
        if (i12 >= 0 && i11 >= i12) {
            i11++;
        }
        return nonActionItems.get(i11);
    }
}
