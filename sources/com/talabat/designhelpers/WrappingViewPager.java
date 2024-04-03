package com.talabat.designhelpers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.viewpager.widget.ViewPager;
import com.talabat.helpers.TalabatApplication;

public class WrappingViewPager extends ViewPager implements Animation.AnimationListener {
    private long mAnimDuration = 150;
    private boolean mAnimStarted = false;
    private PagerAnimation mAnimation;
    private View mCurrentView;

    public class PagerAnimation extends Animation {
        private int currentHeight;
        private int heightChange;
        private int targetHeight;

        private PagerAnimation() {
        }

        public void a(int i11, int i12) {
            this.targetHeight = i11;
            this.currentHeight = i12;
            this.heightChange = i11 - i12;
        }

        public void applyTransformation(float f11, Transformation transformation) {
            if (f11 >= 1.0f) {
                WrappingViewPager.this.getLayoutParams().height = this.targetHeight;
            } else {
                int i11 = (int) (((float) this.heightChange) * f11);
                WrappingViewPager.this.getLayoutParams().height = this.currentHeight + i11;
            }
            WrappingViewPager.this.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    public WrappingViewPager(Context context) {
        super(context);
        PagerAnimation pagerAnimation = new PagerAnimation();
        this.mAnimation = pagerAnimation;
        pagerAnimation.setAnimationListener(this);
    }

    private boolean isProdApplication() {
        return !TalabatApplication.sIsInstrumentation;
    }

    public void onAnimationEnd(Animation animation) {
        this.mAnimStarted = false;
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.mAnimStarted = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onMeasure(int i11, int i12) {
        View view;
        super.onMeasure(i11, i12);
        if (isProdApplication() && !this.mAnimStarted && (view = this.mCurrentView) != null) {
            view.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = this.mCurrentView.getMeasuredHeight();
            if (measuredHeight < getMinimumHeight()) {
                measuredHeight = getMinimumHeight();
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            if (getLayoutParams().height == 0 || i12 == makeMeasureSpec) {
                i12 = makeMeasureSpec;
            } else {
                this.mAnimation.a(measuredHeight, getLayoutParams().height);
                this.mAnimation.setDuration(this.mAnimDuration);
                startAnimation(this.mAnimation);
                this.mAnimStarted = true;
            }
        }
        super.onMeasure(i11, i12);
    }

    public void onPageChanged(View view) {
        this.mCurrentView = view;
        requestLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public WrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PagerAnimation pagerAnimation = new PagerAnimation();
        this.mAnimation = pagerAnimation;
        pagerAnimation.setAnimationListener(this);
    }
}
