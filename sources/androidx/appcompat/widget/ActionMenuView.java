package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private static final String TAG = "ActionMenuView";

    /* renamed from: b  reason: collision with root package name */
    public MenuBuilder.Callback f776b;

    /* renamed from: c  reason: collision with root package name */
    public OnMenuItemClickListener f777c;
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z11) {
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f778a;
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.isOverflowButton = false;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.f777c;
            if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.f776b;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static int d(View view, int i11, int i12, int i13, int i14) {
        ActionMenuItemView actionMenuItemView;
        boolean z11;
        int i15;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i13) - i14, View.MeasureSpec.getMode(i13));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z12 = true;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i12 > 0) {
            i15 = 2;
            if (!z11 || i12 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i12 * i11, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i16 = measuredWidth / i11;
                if (measuredWidth % i11 != 0) {
                    i16++;
                }
                if (!z11 || i16 >= 2) {
                    i15 = i16;
                }
                if (layoutParams.isOverflowButton || !z11) {
                    z12 = false;
                }
                layoutParams.expandable = z12;
                layoutParams.cellsUsed = i15;
                view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), makeMeasureSpec);
                return i15;
            }
        }
        i15 = 0;
        z12 = false;
        layoutParams.expandable = z12;
        layoutParams.cellsUsed = i15;
        view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), makeMeasureSpec);
        return i15;
    }

    private void onMeasureExactFormat(int i11, int i12) {
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        int i16;
        boolean z14;
        int i17;
        int i18;
        boolean z15;
        int i19;
        boolean z16;
        boolean z17;
        int i21;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int i22 = size - paddingLeft;
        int i23 = this.mMinCellSize;
        int i24 = i22 / i23;
        int i25 = i22 % i23;
        if (i24 == 0) {
            setMeasuredDimension(i22, 0);
            return;
        }
        int i26 = i23 + (i25 / i24);
        int childCount = getChildCount();
        int i27 = 0;
        int i28 = 0;
        boolean z18 = false;
        int i29 = 0;
        int i31 = 0;
        int i32 = 0;
        long j11 = 0;
        while (i28 < childCount) {
            View childAt = getChildAt(i28);
            int i33 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z19 = childAt instanceof ActionMenuItemView;
                int i34 = i29 + 1;
                if (z19) {
                    int i35 = this.mGeneratedItemPadding;
                    i19 = i34;
                    z16 = false;
                    childAt.setPadding(i35, 0, i35, 0);
                } else {
                    i19 = i34;
                    z16 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f778a = z16;
                layoutParams.extraPixels = z16 ? 1 : 0;
                layoutParams.cellsUsed = z16;
                layoutParams.expandable = z16;
                layoutParams.leftMargin = z16;
                layoutParams.rightMargin = z16;
                if (!z19 || !((ActionMenuItemView) childAt).hasText()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                layoutParams.preventEdgeOffset = z17;
                if (layoutParams.isOverflowButton) {
                    i21 = 1;
                } else {
                    i21 = i24;
                }
                int d11 = d(childAt, i26, i21, childMeasureSpec, paddingTop);
                i31 = Math.max(i31, d11);
                if (layoutParams.expandable) {
                    i32++;
                }
                if (layoutParams.isOverflowButton) {
                    z18 = true;
                }
                i24 -= d11;
                i27 = Math.max(i27, childAt.getMeasuredHeight());
                if (d11 == 1) {
                    j11 |= (long) (1 << i28);
                    i27 = i27;
                } else {
                    int i36 = i27;
                }
                i29 = i19;
            }
            i28++;
            size2 = i33;
        }
        int i37 = size2;
        if (!z18 || i29 != 2) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean z21 = false;
        while (true) {
            if (i32 <= 0 || i24 <= 0) {
                i15 = mode;
                i13 = i22;
                z12 = z21;
                i14 = i27;
            } else {
                int i38 = Integer.MAX_VALUE;
                int i39 = 0;
                int i41 = 0;
                long j12 = 0;
                while (i41 < childCount) {
                    boolean z22 = z21;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i41).getLayoutParams();
                    int i42 = i27;
                    if (layoutParams2.expandable) {
                        int i43 = layoutParams2.cellsUsed;
                        if (i43 < i38) {
                            j12 = 1 << i41;
                            i38 = i43;
                            i39 = 1;
                        } else if (i43 == i38) {
                            i39++;
                            j12 |= 1 << i41;
                        }
                    }
                    i41++;
                    i27 = i42;
                    z21 = z22;
                }
                z12 = z21;
                i14 = i27;
                j11 |= j12;
                if (i39 > i24) {
                    i15 = mode;
                    i13 = i22;
                    break;
                }
                int i44 = i38 + 1;
                int i45 = 0;
                while (i45 < childCount) {
                    View childAt2 = getChildAt(i45);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i46 = i22;
                    int i47 = mode;
                    long j13 = (long) (1 << i45);
                    if ((j12 & j13) == 0) {
                        if (layoutParams3.cellsUsed == i44) {
                            j11 |= j13;
                        }
                        z15 = z11;
                    } else {
                        if (!z11 || !layoutParams3.preventEdgeOffset || i24 != 1) {
                            z15 = z11;
                        } else {
                            int i48 = this.mGeneratedItemPadding;
                            z15 = z11;
                            childAt2.setPadding(i48 + i26, 0, i48, 0);
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.f778a = true;
                        i24--;
                    }
                    i45++;
                    mode = i47;
                    i22 = i46;
                    z11 = z15;
                }
                i27 = i14;
                z21 = true;
            }
        }
        if (z18 || i29 != 1) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (i24 <= 0 || j11 == 0 || (i24 >= i29 - 1 && !z13 && i31 <= 1)) {
            i16 = 0;
            z14 = z12;
        } else {
            float bitCount = (float) Long.bitCount(j11);
            if (!z13) {
                i16 = 0;
                if ((j11 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
                int i49 = childCount - 1;
                if ((j11 & ((long) (1 << i49))) != 0 && !((LayoutParams) getChildAt(i49).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i16 = 0;
            }
            if (bitCount > 0.0f) {
                i18 = (int) (((float) (i24 * i26)) / bitCount);
            } else {
                i18 = i16;
            }
            z14 = z12;
            for (int i50 = i16; i50 < childCount; i50++) {
                if ((j11 & ((long) (1 << i50))) != 0) {
                    View childAt3 = getChildAt(i50);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i18;
                        layoutParams4.f778a = true;
                        if (i50 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i18) / 2;
                        }
                        z14 = true;
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i18;
                        layoutParams4.f778a = true;
                        layoutParams4.rightMargin = (-i18) / 2;
                        z14 = true;
                    } else {
                        if (i50 != 0) {
                            layoutParams4.leftMargin = i18 / 2;
                        }
                        if (i50 != childCount - 1) {
                            layoutParams4.rightMargin = i18 / 2;
                        }
                    }
                }
            }
        }
        if (z14) {
            for (int i51 = i16; i51 < childCount; i51++) {
                View childAt4 = getChildAt(i51);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f778a) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i26) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i15 != 1073741824) {
            i17 = i14;
        } else {
            i17 = i37;
        }
        setMeasuredDimension(i13, i17);
    }

    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean c(int i11) {
        boolean z11 = false;
        if (i11 == 0) {
            return false;
        }
        View childAt = getChildAt(i11 - 1);
        View childAt2 = getChildAt(i11);
        if (i11 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z11 = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i11 <= 0 || !(childAt2 instanceof ActionMenuChildView)) {
            return z11;
        }
        return z11 | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams a11 = generateDefaultLayoutParams();
        a11.isOverflowButton = true;
        return a11;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        if (!this.mFormatItems) {
            super.onLayout(z11, i11, i12, i13, i14);
            return;
        }
        int childCount = getChildCount();
        int i18 = (i14 - i12) / 2;
        int dividerWidth = getDividerWidth();
        int i19 = i13 - i11;
        int paddingRight = (i19 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i21 = 0;
        int i22 = 0;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (c(i23)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i16 = getPaddingLeft() + layoutParams.leftMargin;
                        i17 = i16 + measuredWidth;
                    } else {
                        i17 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i16 = i17 - measuredWidth;
                    }
                    int i24 = i18 - (measuredHeight / 2);
                    childAt.layout(i16, i24, i17, measuredHeight + i24);
                    paddingRight -= measuredWidth;
                    i21 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    c(i23);
                    i22++;
                }
            }
        }
        if (childCount == 1 && i21 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i25 = (i19 / 2) - (measuredWidth2 / 2);
            int i26 = i18 - (measuredHeight2 / 2);
            childAt2.layout(i25, i26, measuredWidth2 + i25, measuredHeight2 + i26);
            return;
        }
        int i27 = i22 - (i21 ^ 1);
        if (i27 > 0) {
            i15 = paddingRight / i27;
        } else {
            i15 = 0;
        }
        int max = Math.max(0, i15);
        if (isLayoutRtl) {
            int width = getWidth() - getPaddingRight();
            for (int i28 = 0; i28 < childCount; i28++) {
                View childAt3 = getChildAt(i28);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i29 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i31 = i18 - (measuredHeight3 / 2);
                    childAt3.layout(i29 - measuredWidth3, i31, i29, measuredHeight3 + i31);
                    width = i29 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i32 = 0; i32 < childCount; i32++) {
            View childAt4 = getChildAt(i32);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i33 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i34 = i18 - (measuredHeight4 / 2);
                childAt4.layout(i33, i34, i33 + measuredWidth4, measuredHeight4 + i34);
                paddingLeft = i33 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        MenuBuilder menuBuilder;
        boolean z12 = this.mFormatItems;
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mFormatItems = z11;
        if (z12 != z11) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (!(!this.mFormatItems || (menuBuilder = this.mMenu) == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i13 = 0; i13 < childCount; i13++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i13).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i11, i12);
            return;
        }
        onMeasureExactFormat(i11, i12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z11) {
        this.mPresenter.setExpandedActionViewsExclusive(z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.f776b = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f777c = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z11) {
        this.mReserveOverflow = z11;
    }

    public void setPopupTheme(@StyleRes int i11) {
        if (this.mPopupTheme != i11) {
            this.mPopupTheme = i11;
            if (i11 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f11);
        this.mGeneratedItemPadding = (int) (f11 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
