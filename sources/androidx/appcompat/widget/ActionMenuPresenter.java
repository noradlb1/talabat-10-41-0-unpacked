package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";

    /* renamed from: h  reason: collision with root package name */
    public OverflowMenuButton f763h;

    /* renamed from: i  reason: collision with root package name */
    public OverflowPopup f764i;

    /* renamed from: j  reason: collision with root package name */
    public ActionButtonSubmenu f765j;

    /* renamed from: k  reason: collision with root package name */
    public OpenOverflowRunnable f766k;

    /* renamed from: l  reason: collision with root package name */
    public final PopupPresenterCallback f767l = new PopupPresenterCallback();

    /* renamed from: m  reason: collision with root package name */
    public int f768m;
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.f763h;
                setAnchorView(view2 == null ? (View) ActionMenuPresenter.this.f697g : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.f767l);
        }

        public void a() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f765j = null;
            actionMenuPresenter.f768m = 0;
            super.a();
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }

        public ShowableListMenu getPopup() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.f765j;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            if (ActionMenuPresenter.this.f694d != null) {
                ActionMenuPresenter.this.f694d.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f697g;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.f764i = this.mPopup;
            }
            ActionMenuPresenter.this.f766k = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ShowableListMenu getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.f764i;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.getPopup();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.f766k != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        public boolean setFrame(int i11, int i12, int i13, int i14) {
            boolean frame = super.setFrame(i11, i12, i13, i14);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z11) {
            super(context, menuBuilder, view, z11, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.f767l);
        }

        public void a() {
            if (ActionMenuPresenter.this.f694d != null) {
                ActionMenuPresenter.this.f694d.close();
            }
            ActionMenuPresenter.this.f764i = null;
            super.a();
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z11) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z11);
            }
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.f694d) {
                return false;
            }
            ActionMenuPresenter.this.f768m = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        public int openSubMenuId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f697g;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f697g);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i11) {
        if (viewGroup.getChildAt(i11) == this.f763h) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i11);
    }

    public boolean flagActionItems() {
        int i11;
        ArrayList<MenuItemImpl> arrayList;
        int i12;
        int i13;
        int i14;
        boolean z11;
        boolean z12;
        boolean z13;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f694d;
        View view = null;
        boolean z14 = false;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i11 = arrayList.size();
        } else {
            arrayList = null;
            i11 = 0;
        }
        int i15 = actionMenuPresenter.mMaxItems;
        int i16 = actionMenuPresenter.mActionItemWidthLimit;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f697g;
        boolean z15 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i11; i19++) {
            MenuItemImpl menuItemImpl = arrayList.get(i19);
            if (menuItemImpl.requiresActionButton()) {
                i17++;
            } else if (menuItemImpl.requestsActionButton()) {
                i18++;
            } else {
                z15 = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (actionMenuPresenter.mReserveOverflow && (z15 || i18 + i17 > i15)) {
            i15--;
        }
        int i21 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.mStrictWidthLimit) {
            int i22 = actionMenuPresenter.mMinCellSize;
            i12 = i16 / i22;
            i13 = i22 + ((i16 % i22) / i12);
        } else {
            i13 = 0;
            i12 = 0;
        }
        int i23 = 0;
        int i24 = 0;
        while (i23 < i11) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i23);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.mStrictWidthLimit) {
                    i12 -= ActionMenuView.d(itemView, i13, i12, makeMeasureSpec, z14 ? 1 : 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i24 == 0) {
                    i24 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                z11 = z14;
                i14 = i11;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z16 = sparseBooleanArray.get(groupId2);
                if ((i21 > 0 || z16) && i16 > 0 && (!actionMenuPresenter.mStrictWidthLimit || i12 > 0)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z17 = z12;
                i14 = i11;
                if (z12) {
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.mStrictWidthLimit) {
                        int d11 = ActionMenuView.d(itemView2, i13, i12, makeMeasureSpec, 0);
                        i12 -= d11;
                        if (d11 == 0) {
                            z17 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z18 = z17;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i24 == 0) {
                        i24 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.mStrictWidthLimit ? i16 + i24 <= 0 : i16 < 0) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    z12 = z18 & z13;
                }
                if (z12 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z16) {
                    sparseBooleanArray.put(groupId2, false);
                    int i25 = 0;
                    while (i25 < i23) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i25);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i21++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                        i25++;
                    }
                }
                if (z12) {
                    i21--;
                }
                menuItemImpl2.setIsActionButton(z12);
                z11 = false;
            } else {
                z11 = z14;
                i14 = i11;
                menuItemImpl2.setIsActionButton(z11);
            }
            i23++;
            z14 = z11;
            i11 = i14;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i11;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        actionView.setVisibility(i11);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.f697g;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.f763h;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.f766k;
        if (openOverflowRunnable == null || (menuView = this.f697g) == null) {
            OverflowPopup overflowPopup = this.f764i;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.dismiss();
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.f766k = null;
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.f765j;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int i11 = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.f763h == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f692b);
                this.f763h = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f763h.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i11 -= this.f763h.getMeasuredWidth();
        } else {
            this.f763h = null;
        }
        this.mActionItemWidthLimit = i11;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.f766k != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.f764i;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z11);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get(this.f693c).getMaxActionButtons();
        }
        MenuBuilder menuBuilder = this.f694d;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i11 = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.f694d.findItem(i11)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.f768m;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z11 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.f694d) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View findViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (findViewForItem == null) {
            return false;
        }
        this.f768m = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                z11 = true;
                break;
            }
            i11++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.f693c, subMenuBuilder, findViewForItem);
        this.f765j = actionButtonSubmenu;
        actionButtonSubmenu.setForceShowIcon(z11);
        this.f765j.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z11) {
        if (z11) {
            super.onSubMenuSelected((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.f694d;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z11) {
        this.mExpandedActionViewsExclusive = z11;
    }

    public void setItemLimit(int i11) {
        this.mMaxItems = i11;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.f697g = actionMenuView;
        actionMenuView.initialize(this.f694d);
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f763h;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = drawable;
    }

    public void setReserveOverflow(boolean z11) {
        this.mReserveOverflow = z11;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i11, boolean z11) {
        this.mWidthLimit = i11;
        this.mStrictWidthLimit = z11;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i11, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (menuBuilder = this.f694d) == null || this.f697g == null || this.f766k != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.f693c, this.f694d, this.f763h, true));
        this.f766k = openOverflowRunnable;
        ((View) this.f697g).post(openOverflowRunnable);
        return true;
    }

    public void updateMenuView(boolean z11) {
        ArrayList<MenuItemImpl> arrayList;
        MenuView menuView;
        super.updateMenuView(z11);
        ((View) this.f697g).requestLayout();
        MenuBuilder menuBuilder = this.f694d;
        boolean z12 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i11 = 0; i11 < size; i11++) {
                ActionProvider supportActionProvider = actionItems.get(i11).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f694d;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.getNonActionItems();
        } else {
            arrayList = null;
        }
        if (this.mReserveOverflow && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z12 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z12 = true;
            }
        }
        if (z12) {
            if (this.f763h == null) {
                this.f763h = new OverflowMenuButton(this.f692b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f763h.getParent();
            if (viewGroup != this.f697g) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f763h);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f697g;
                actionMenuView.addView(this.f763h, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f763h;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (menuView = this.f697g)) {
                ((ViewGroup) menuView).removeView(this.f763h);
            }
        }
        ((ActionMenuView) this.f697g).setOverflowReserved(this.mReserveOverflow);
    }
}
