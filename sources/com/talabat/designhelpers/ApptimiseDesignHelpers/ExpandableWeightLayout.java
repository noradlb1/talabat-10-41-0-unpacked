package com.talabat.designhelpers.ApptimiseDesignHelpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.talabat.talabatcommon.R;

public class ExpandableWeightLayout extends RelativeLayout implements ExpandableLayout {
    private boolean defaultExpanded;
    private int duration;
    private TimeInterpolator interpolator;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private boolean isArranged;
    private boolean isCalculatedSize;
    /* access modifiers changed from: private */
    public boolean isExpanded;
    /* access modifiers changed from: private */
    public float layoutWeight;
    /* access modifiers changed from: private */
    public ExpandableLayoutListener listener;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private ExpandableSavedState savedState;

    public ExpandableWeightLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private ValueAnimator createExpandAnimator(float f11, final float f12, long j11, @Nullable TimeInterpolator timeInterpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f12});
        ofFloat.setDuration(j11);
        if (timeInterpolator == null) {
            timeInterpolator = this.interpolator;
        }
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandableWeightLayout.this.setWeight(((Float) valueAnimator.getAnimatedValue()).floatValue());
                ExpandableWeightLayout.this.requestLayout();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean z11;
                boolean z12;
                boolean z13 = false;
                ExpandableWeightLayout.this.isAnimating = false;
                ExpandableWeightLayout expandableWeightLayout = ExpandableWeightLayout.this;
                if (f12 > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                expandableWeightLayout.isExpanded = z11;
                if (ExpandableWeightLayout.this.listener != null) {
                    ExpandableWeightLayout.this.listener.onAnimationEnd();
                    if (f12 == ExpandableWeightLayout.this.layoutWeight) {
                        ExpandableWeightLayout.this.listener.onOpened();
                        return;
                    }
                    float f11 = f12;
                    if (f11 > 0.0f) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (f11 <= ExpandableWeightLayout.this.layoutWeight * 0.0f) {
                        z13 = true;
                    }
                    if (z12 && z13) {
                        ExpandableWeightLayout.this.listener.closing();
                    } else if (f12 == 0.0f) {
                        ExpandableWeightLayout.this.listener.onClosed();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                ExpandableWeightLayout.this.isAnimating = true;
                if (ExpandableWeightLayout.this.listener != null) {
                    ExpandableWeightLayout.this.listener.onAnimationStart();
                    float b11 = ExpandableWeightLayout.this.layoutWeight;
                    float f11 = f12;
                    if (b11 == f11) {
                        ExpandableWeightLayout.this.listener.onPreOpen();
                    } else if (0.0f == f11) {
                        ExpandableWeightLayout.this.listener.onPreClose();
                    }
                }
            }
        });
        return ofFloat;
    }

    private void init(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.expandableLayout, i11, 0);
        this.duration = obtainStyledAttributes.getInteger(2, 300);
        this.defaultExpanded = obtainStyledAttributes.getBoolean(3, false);
        int integer = obtainStyledAttributes.getInteger(4, 8);
        obtainStyledAttributes.recycle();
        this.interpolator = Utils.createInterpolator(integer);
        this.isExpanded = this.defaultExpanded;
    }

    private void notifyListeners() {
        ExpandableLayoutListener expandableLayoutListener = this.listener;
        if (expandableLayoutListener != null) {
            expandableLayoutListener.onAnimationStart();
            if (this.isExpanded) {
                this.listener.onPreOpen();
            } else {
                this.listener.onPreClose();
            }
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ExpandableWeightLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(ExpandableWeightLayout.this.mGlobalLayoutListener);
                    ExpandableWeightLayout.this.listener.onAnimationEnd();
                    if (ExpandableWeightLayout.this.isExpanded) {
                        ExpandableWeightLayout.this.listener.onOpened();
                    } else {
                        ExpandableWeightLayout.this.listener.onClosed();
                    }
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
    }

    /* access modifiers changed from: private */
    public void setWeight(float f11) {
        ((LinearLayout.LayoutParams) getLayoutParams()).weight = f11;
    }

    public void collapse(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            if (j11 <= 0) {
                this.isExpanded = false;
                setWeight(0.0f);
                requestLayout();
                notifyListeners();
                return;
            }
            createExpandAnimator(getCurrentWeight(), 0.0f, j11, timeInterpolator).start();
        }
    }

    public void expand() {
        if (!this.isAnimating) {
            createExpandAnimator(0.0f, this.layoutWeight, (long) this.duration, this.interpolator).start();
        }
    }

    public float getCurrentWeight() {
        return ((LinearLayout.LayoutParams) getLayoutParams()).weight;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void move(float f11) {
        move(f11, (long) this.duration, this.interpolator);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!(getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            throw new AssertionError("You must arrange in LinearLayout.");
        } else if (0.0f >= getCurrentWeight()) {
            throw new AssertionError("You must set a weight than 0.");
        }
    }

    public void onMeasure(int i11, int i12) {
        float f11;
        super.onMeasure(i11, i12);
        if (!this.isCalculatedSize) {
            this.layoutWeight = getCurrentWeight();
            this.isCalculatedSize = true;
        }
        if (!this.isArranged) {
            if (this.defaultExpanded) {
                f11 = this.layoutWeight;
            } else {
                f11 = 0.0f;
            }
            setWeight(f11);
            this.isArranged = true;
            ExpandableSavedState expandableSavedState = this.savedState;
            if (expandableSavedState != null) {
                setWeight(expandableSavedState.getWeight());
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExpandableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExpandableSavedState expandableSavedState = (ExpandableSavedState) parcelable;
        super.onRestoreInstanceState(expandableSavedState.getSuperState());
        this.savedState = expandableSavedState;
    }

    public Parcelable onSaveInstanceState() {
        ExpandableSavedState expandableSavedState = new ExpandableSavedState(super.onSaveInstanceState());
        expandableSavedState.setWeight(getCurrentWeight());
        return expandableSavedState;
    }

    public void setDuration(@NonNull int i11) {
        if (i11 >= 0) {
            this.duration = i11;
            return;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + i11);
    }

    public void setExpandWeight(float f11) {
        this.layoutWeight = f11;
    }

    public void setExpanded(boolean z11) {
        float currentWeight = getCurrentWeight();
        if (!z11 || currentWeight != this.layoutWeight) {
            float f11 = 0.0f;
            if (z11 || currentWeight != 0.0f) {
                this.isExpanded = z11;
                if (z11) {
                    f11 = this.layoutWeight;
                }
                setWeight(f11);
                requestLayout();
            }
        }
    }

    public void setInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.interpolator = timeInterpolator;
    }

    public void setListener(@NonNull ExpandableLayoutListener expandableLayoutListener) {
        this.listener = expandableLayoutListener;
    }

    public void setNonCollapsible() {
    }

    public void toggle() {
        toggle((long) this.duration, this.interpolator);
    }

    public ExpandableWeightLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void move(float f11, long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            if (j11 <= 0) {
                this.isExpanded = f11 > 0.0f;
                setWeight(f11);
                requestLayout();
                notifyListeners();
                return;
            }
            createExpandAnimator(getCurrentWeight(), f11, j11, timeInterpolator).start();
        }
    }

    public void toggle(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (0.0f < getCurrentWeight()) {
            collapse(j11, timeInterpolator);
        } else {
            expand(j11, timeInterpolator);
        }
    }

    public ExpandableWeightLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.interpolator = new LinearInterpolator();
        this.layoutWeight = 0.0f;
        this.isArranged = false;
        this.isCalculatedSize = false;
        this.isAnimating = false;
        init(context, attributeSet, i11);
    }

    public void expand(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            if (j11 <= 0) {
                this.isExpanded = true;
                setWeight(this.layoutWeight);
                requestLayout();
                notifyListeners();
                return;
            }
            createExpandAnimator(getCurrentWeight(), this.layoutWeight, j11, timeInterpolator).start();
        }
    }

    @TargetApi(21)
    public ExpandableWeightLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.interpolator = new LinearInterpolator();
        this.layoutWeight = 0.0f;
        this.isArranged = false;
        this.isCalculatedSize = false;
        this.isAnimating = false;
        init(context, attributeSet, i11);
    }
}
