package com.talabat.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.talabat.talabatcommon.R;

public class ExpandableTextView extends TextView {
    private static final int MAXMODE_LINES = 1;
    /* access modifiers changed from: private */
    public boolean animating;
    private long animationDuration;
    private TimeInterpolator collapseInterpolator;
    private TimeInterpolator expandInterpolator;
    /* access modifiers changed from: private */
    public boolean expanded;
    /* access modifiers changed from: private */
    public final int maxLines;
    private OnExpandListener onExpandListener;
    private int originalHeight;

    public interface OnExpandListener {
        void onCollapse(ExpandableTextView expandableTextView);

        void onExpand(ExpandableTextView expandableTextView);
    }

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean collapse() {
        if (!this.expanded || this.animating || this.maxLines < 0) {
            return false;
        }
        this.animating = true;
        OnExpandListener onExpandListener2 = this.onExpandListener;
        if (onExpandListener2 != null) {
            onExpandListener2.onCollapse(this);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getMeasuredHeight(), this.originalHeight});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = ExpandableTextView.this.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ExpandableTextView.this.setLayoutParams(layoutParams);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                expandableTextView.setMaxLines(expandableTextView.maxLines);
                ExpandableTextView.this.expanded = false;
                ExpandableTextView.this.animating = false;
            }
        });
        ofInt.setInterpolator(this.collapseInterpolator);
        ofInt.setDuration(this.animationDuration).start();
        return true;
    }

    public boolean expand() {
        if (this.expanded || this.animating || this.maxLines < 0) {
            return false;
        }
        this.animating = true;
        OnExpandListener onExpandListener2 = this.onExpandListener;
        if (onExpandListener2 != null) {
            onExpandListener2.onExpand(this);
        }
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.originalHeight = getMeasuredHeight();
        setMaxLines(Integer.MAX_VALUE);
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.originalHeight, getMeasuredHeight()});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = ExpandableTextView.this.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ExpandableTextView.this.setLayoutParams(layoutParams);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ExpandableTextView.this.expanded = true;
                ExpandableTextView.this.animating = false;
            }
        });
        ofInt.setInterpolator(this.expandInterpolator);
        ofInt.setDuration(this.animationDuration).start();
        return true;
    }

    public TimeInterpolator getCollapseInterpolator() {
        return this.collapseInterpolator;
    }

    public TimeInterpolator getExpandInterpolator() {
        return this.expandInterpolator;
    }

    public int getMaxLines() {
        return super.getMaxLines();
    }

    public OnExpandListener getOnExpandListener() {
        return this.onExpandListener;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void setAnimationDuration(long j11) {
        this.animationDuration = j11;
    }

    public void setCollapseInterpolator(TimeInterpolator timeInterpolator) {
        this.collapseInterpolator = timeInterpolator;
    }

    public void setExpandInterpolator(TimeInterpolator timeInterpolator) {
        this.expandInterpolator = timeInterpolator;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.expandInterpolator = timeInterpolator;
        this.collapseInterpolator = timeInterpolator;
    }

    public void setOnExpandListener(OnExpandListener onExpandListener2) {
        this.onExpandListener = onExpandListener2;
    }

    public boolean toggle() {
        if (this.expanded) {
            return collapse();
        }
        return expand();
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView, i11, 0);
        this.animationDuration = 100;
        obtainStyledAttributes.recycle();
        this.maxLines = getMaxLines();
        this.expandInterpolator = new AccelerateDecelerateInterpolator();
        this.collapseInterpolator = new AccelerateDecelerateInterpolator();
    }
}
