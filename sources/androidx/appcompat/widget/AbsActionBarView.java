package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;

    /* renamed from: b  reason: collision with root package name */
    public final VisibilityAnimListener f738b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f739c;

    /* renamed from: d  reason: collision with root package name */
    public ActionMenuView f740d;

    /* renamed from: e  reason: collision with root package name */
    public ActionMenuPresenter f741e;

    /* renamed from: f  reason: collision with root package name */
    public int f742f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPropertyAnimatorCompat f743g;
    private boolean mEatingHover;
    private boolean mEatingTouch;

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public int f745a;
        private boolean mCanceled = false;

        public VisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                AbsActionBarView absActionBarView = AbsActionBarView.this;
                absActionBarView.f743g = null;
                AbsActionBarView.super.setVisibility(this.f745a);
            }
        }

        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i11) {
            AbsActionBarView.this.f743g = viewPropertyAnimatorCompat;
            this.f745a = i11;
            return this;
        }
    }

    public AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int d(int i11, int i12, boolean z11) {
        return z11 ? i11 - i12 : i11 + i12;
    }

    public void animateToVisibility(int i11) {
        setupAnimatorToVisibility(i11, 200).start();
    }

    public int c(View view, int i11, int i12, int i13) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), i12);
        return Math.max(0, (i11 - view.getMeasuredWidth()) - i13);
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public int e(View view, int i11, int i12, int i13, boolean z11) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i14 = i12 + ((i13 - measuredHeight) / 2);
        if (z11) {
            view.layout(i11 - measuredWidth, i14, i11, measuredHeight + i14);
        } else {
            view.layout(i11, i14, i11 + measuredWidth, measuredHeight + i14);
        }
        if (z11) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public int getAnimatedVisibility() {
        if (this.f743g != null) {
            return this.f738b.f745a;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f742f;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowPending();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowReserved();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.onConfigurationChanged(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() {
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int i11) {
        this.f742f = i11;
        requestLayout();
    }

    public void setVisibility(int i11) {
        if (i11 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f743g;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            super.setVisibility(i11);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i11, long j11) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f743g;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        if (i11 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(j11);
            alpha.setListener(this.f738b.withFinalVisibility(alpha, i11));
            return alpha;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(0.0f);
        alpha2.setDuration(j11);
        alpha2.setListener(this.f738b.withFinalVisibility(alpha2, i11));
        return alpha2;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f741e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f738b = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f739c = context;
        } else {
            this.f739c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
