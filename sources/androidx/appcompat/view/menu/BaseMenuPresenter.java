package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: b  reason: collision with root package name */
    public Context f692b;

    /* renamed from: c  reason: collision with root package name */
    public Context f693c;

    /* renamed from: d  reason: collision with root package name */
    public MenuBuilder f694d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f695e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f696f;

    /* renamed from: g  reason: collision with root package name */
    public MenuView f697g;
    private MenuPresenter.Callback mCallback;
    private int mId;
    private int mItemLayoutRes;
    private int mMenuLayoutRes;

    public BaseMenuPresenter(Context context, int i11, int i12) {
        this.f692b = context;
        this.f695e = LayoutInflater.from(context);
        this.mMenuLayoutRes = i11;
        this.mItemLayoutRes = i12;
    }

    public void a(View view, int i11) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f697g).addView(view, i11);
    }

    public abstract void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f695e.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i11) {
        viewGroup.removeViewAt(i11);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        if (view instanceof MenuView.ItemView) {
            itemView = (MenuView.ItemView) view;
        } else {
            itemView = createItemView(viewGroup);
        }
        bindItemView(menuItemImpl, itemView);
        return (View) itemView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f697g == null) {
            MenuView menuView = (MenuView) this.f695e.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.f697g = menuView;
            menuView.initialize(this.f694d);
            updateMenuView(true);
        }
        return this.f697g;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f693c = context;
        this.f696f = LayoutInflater.from(context);
        this.f694d = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r1.mCallback
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.f694d
        L_0x0009:
            boolean r2 = r0.onOpenSubMenu(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.BaseMenuPresenter.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i11) {
        this.mId = i11;
    }

    public boolean shouldIncludeItem(int i11, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void updateMenuView(boolean z11) {
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.f697g;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.f694d;
            int i11 = 0;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.f694d.getVisibleItems();
                int size = visibleItems.size();
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    MenuItemImpl menuItemImpl2 = visibleItems.get(i13);
                    if (shouldIncludeItem(i12, menuItemImpl2)) {
                        View childAt = viewGroup.getChildAt(i12);
                        if (childAt instanceof MenuView.ItemView) {
                            menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View itemView = getItemView(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            a(itemView, i12);
                        }
                        i12++;
                    }
                }
                i11 = i12;
            }
            while (i11 < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i11)) {
                    i11++;
                }
            }
        }
    }
}
