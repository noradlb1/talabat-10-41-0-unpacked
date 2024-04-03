package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private int height = 0;

    public HideBottomViewOnScrollBehavior() {
    }

    private void animateChildTo(@NonNull V v11, int i11, long j11, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v11.animate().translationY((float) i11).setInterpolator(timeInterpolator).setDuration(j11).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }

    public boolean isScrolledDown() {
        return this.currentState == 1;
    }

    public boolean isScrolledUp() {
        return this.currentState == 2;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        this.height = v11.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v11.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v11, i11);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        if (i12 > 0) {
            slideDown(v11);
        } else if (i12 < 0) {
            slideUp(v11);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
        return i11 == 2;
    }

    public void setAdditionalHiddenOffsetY(@NonNull V v11, @Dimension int i11) {
        this.additionalHiddenOffsetY = i11;
        if (this.currentState == 1) {
            v11.setTranslationY((float) (this.height + i11));
        }
    }

    public void slideDown(@NonNull V v11) {
        slideDown(v11, true);
    }

    public void slideUp(@NonNull V v11) {
        slideUp(v11, true);
    }

    public void slideDown(@NonNull V v11, boolean z11) {
        if (!isScrolledDown()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v11.clearAnimation();
            }
            this.currentState = 1;
            int i11 = this.height + this.additionalHiddenOffsetY;
            if (z11) {
                animateChildTo(v11, i11, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
                return;
            }
            v11.setTranslationY((float) i11);
        }
    }

    public void slideUp(@NonNull V v11, boolean z11) {
        if (!isScrolledUp()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v11.clearAnimation();
            }
            this.currentState = 2;
            if (z11) {
                animateChildTo(v11, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                return;
            }
            v11.setTranslationY((float) 0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
