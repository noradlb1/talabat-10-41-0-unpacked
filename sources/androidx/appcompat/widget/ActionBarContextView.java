package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initTitle() {
        int i11;
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleLayout = linearLayout;
            this.mTitleView = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean z11 = !TextUtils.isEmpty(this.mTitle);
        boolean z12 = !TextUtils.isEmpty(this.mSubtitle);
        TextView textView = this.mSubtitleView;
        int i12 = 0;
        if (z12) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        LinearLayout linearLayout2 = this.mTitleLayout;
        if (!z11 && !z12) {
            i12 = 8;
        }
        linearLayout2.setVisibility(i12);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    public /* bridge */ /* synthetic */ void animateToVisibility(int i11) {
        super.animateToVisibility(i11);
    }

    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose == null) {
            killMode();
        }
    }

    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(final ActionMode actionMode) {
        View view = this.mClose;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
            this.mClose = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.mClose);
        }
        View findViewById = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionMode.finish();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f741e = actionMenuPresenter2;
        actionMenuPresenter2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.f741e, this.f739c);
        ActionMenuView actionMenuView = (ActionMenuView) this.f741e.getMenuView(this);
        this.f740d = actionMenuView;
        ViewCompat.setBackground(actionMenuView, (Drawable) null);
        addView(this.f740d, layoutParams);
    }

    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.f740d = null;
        this.f741e = null;
        View view = this.mCloseButton;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            this.f741e.hideSubMenus();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            i15 = (i13 - i11) - getPaddingRight();
        } else {
            i15 = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i14 - i12) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            if (isLayoutRtl) {
                i17 = marginLayoutParams.rightMargin;
            } else {
                i17 = marginLayoutParams.leftMargin;
            }
            if (isLayoutRtl) {
                i18 = marginLayoutParams.leftMargin;
            } else {
                i18 = marginLayoutParams.rightMargin;
            }
            int d11 = AbsActionBarView.d(i15, i17, isLayoutRtl);
            i15 = AbsActionBarView.d(d11 + e(this.mClose, d11, paddingTop, paddingTop2, isLayoutRtl), i18, isLayoutRtl);
        }
        int i19 = i15;
        LinearLayout linearLayout = this.mTitleLayout;
        if (!(linearLayout == null || this.mCustomView != null || linearLayout.getVisibility() == 8)) {
            i19 += e(this.mTitleLayout, i19, paddingTop, paddingTop2, isLayoutRtl);
        }
        int i21 = i19;
        View view2 = this.mCustomView;
        if (view2 != null) {
            e(view2, i21, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (isLayoutRtl) {
            i16 = getPaddingLeft();
        } else {
            i16 = (i13 - i11) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f740d;
        if (actionMenuView != null) {
            e(actionMenuView, i16, paddingTop, paddingTop2, !isLayoutRtl);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        boolean z11;
        int i14;
        int i15 = 1073741824;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i12) != 0) {
            int size = View.MeasureSpec.getSize(i11);
            int i16 = this.f742f;
            if (i16 <= 0) {
                i16 = View.MeasureSpec.getSize(i12);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i17 = i16 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
            View view = this.mClose;
            if (view != null) {
                int c11 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                paddingLeft = c11 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f740d;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f740d, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.mTitleLayout;
            if (linearLayout != null && this.mCustomView == null) {
                if (this.mTitleOptional) {
                    this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                    if (measuredWidth <= paddingLeft) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        paddingLeft -= measuredWidth;
                    }
                    LinearLayout linearLayout2 = this.mTitleLayout;
                    if (z11) {
                        i14 = 0;
                    } else {
                        i14 = 8;
                    }
                    linearLayout2.setVisibility(i14);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.mCustomView;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i18 = layoutParams.width;
                if (i18 != -2) {
                    i13 = 1073741824;
                } else {
                    i13 = Integer.MIN_VALUE;
                }
                if (i18 >= 0) {
                    paddingLeft = Math.min(i18, paddingLeft);
                }
                int i19 = layoutParams.height;
                if (i19 == -2) {
                    i15 = Integer.MIN_VALUE;
                }
                if (i19 >= 0) {
                    i17 = Math.min(i19, i17);
                }
                this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(i17, i15));
            }
            if (this.f742f <= 0) {
                int childCount = getChildCount();
                int i21 = 0;
                for (int i22 = 0; i22 < childCount; i22++) {
                    int measuredHeight = getChildAt(i22).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i21) {
                        i21 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i21);
                return;
            }
            setMeasuredDimension(size, i16);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int i11) {
        this.f742f = i11;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (!(view == null || (linearLayout = this.mTitleLayout) == null)) {
            removeView(linearLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, charSequence);
    }

    public void setTitleOptional(boolean z11) {
        if (z11 != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z11;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i11) {
        super.setVisibility(i11);
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i11, long j11) {
        return super.setupAnimatorToVisibility(i11, j11);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i11, 0);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f742f = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
