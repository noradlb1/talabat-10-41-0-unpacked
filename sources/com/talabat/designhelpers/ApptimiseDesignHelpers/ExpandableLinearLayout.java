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
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.talabat.talabatcommon.R;
import java.util.ArrayList;
import java.util.List;

public class ExpandableLinearLayout extends LinearLayout implements ExpandableLayout {
    private List<Integer> childSizeList;
    /* access modifiers changed from: private */
    public int closePosition;
    private int defaultChildIndex;
    private boolean defaultExpanded;
    private int defaultPosition;
    private int duration;
    private boolean inRecyclerView;
    private TimeInterpolator interpolator;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private boolean isArranged;
    private boolean isCalculatedSize;
    /* access modifiers changed from: private */
    public boolean isExpanded;
    /* access modifiers changed from: private */
    public int layoutSize;
    /* access modifiers changed from: private */
    public ExpandableLayoutListener listener;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean recyclerExpanded;
    private ExpandableSavedState savedState;

    public ExpandableLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private ValueAnimator createExpandAnimator(int i11, final int i12, long j11, TimeInterpolator timeInterpolator) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setDuration(j11);
        ofInt.setInterpolator(timeInterpolator);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ExpandableLinearLayout.this.isVertical()) {
                    ExpandableLinearLayout.this.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                } else {
                    ExpandableLinearLayout.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                ExpandableLinearLayout.this.requestLayout();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean z11 = false;
                ExpandableLinearLayout.this.isAnimating = false;
                ExpandableLinearLayout expandableLinearLayout = ExpandableLinearLayout.this;
                if (i12 > expandableLinearLayout.closePosition) {
                    z11 = true;
                }
                expandableLinearLayout.isExpanded = z11;
                if (ExpandableLinearLayout.this.listener != null) {
                    ExpandableLinearLayout.this.listener.onAnimationEnd();
                    if (i12 == ExpandableLinearLayout.this.layoutSize) {
                        ExpandableLinearLayout.this.listener.onOpened();
                    } else if (i12 == ExpandableLinearLayout.this.closePosition) {
                        ExpandableLinearLayout.this.listener.onClosed();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                ExpandableLinearLayout.this.isAnimating = true;
                if (ExpandableLinearLayout.this.listener != null) {
                    ExpandableLinearLayout.this.listener.onAnimationStart();
                    if (ExpandableLinearLayout.this.layoutSize == i12) {
                        ExpandableLinearLayout.this.listener.onPreOpen();
                    } else if (ExpandableLinearLayout.this.closePosition == i12) {
                        ExpandableLinearLayout.this.listener.onPreClose();
                    }
                }
            }
        });
        return ofInt;
    }

    private void init(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.expandableLayout, i11, 0);
        this.duration = obtainStyledAttributes.getInteger(2, 300);
        this.defaultExpanded = obtainStyledAttributes.getBoolean(3, false);
        this.defaultChildIndex = obtainStyledAttributes.getInteger(0, Integer.MAX_VALUE);
        this.defaultPosition = obtainStyledAttributes.getDimensionPixelSize(1, Integer.MIN_VALUE);
        int integer = obtainStyledAttributes.getInteger(4, 8);
        obtainStyledAttributes.recycle();
        this.interpolator = Utils.createInterpolator(integer);
        this.isExpanded = this.defaultExpanded;
    }

    /* access modifiers changed from: private */
    public boolean isVertical() {
        return getOrientation() == 1;
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
                    ExpandableLinearLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(ExpandableLinearLayout.this.mGlobalLayoutListener);
                    ExpandableLinearLayout.this.listener.onAnimationEnd();
                    if (ExpandableLinearLayout.this.isExpanded) {
                        ExpandableLinearLayout.this.listener.onOpened();
                    } else {
                        ExpandableLinearLayout.this.listener.onClosed();
                    }
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
    }

    private void setLayoutSize(int i11) {
        if (isVertical()) {
            getLayoutParams().height = i11;
        } else {
            getLayoutParams().width = i11;
        }
    }

    public void collapse(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            if (j11 <= 0) {
                move(this.closePosition, j11, timeInterpolator);
                return;
            }
            createExpandAnimator(getCurrentPosition(), this.closePosition, j11, timeInterpolator).start();
        }
    }

    public void expand() {
        if (!this.isAnimating) {
            createExpandAnimator(getCurrentPosition(), this.layoutSize, (long) this.duration, this.interpolator).start();
        }
    }

    public int getChildPosition(int i11) {
        if (i11 >= 0 && this.childSizeList.size() > i11) {
            return this.childSizeList.get(i11).intValue();
        }
        throw new IllegalArgumentException("There aren't the view having this index.");
    }

    public int getClosePosition() {
        return this.closePosition;
    }

    public int getCurrentPosition() {
        return isVertical() ? getMeasuredHeight() : getMeasuredWidth();
    }

    public void initLayout() {
        this.closePosition = 0;
        this.layoutSize = 0;
        this.isArranged = false;
        this.isCalculatedSize = false;
        this.savedState = null;
        if (isVertical()) {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 0));
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 0), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        }
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void move(int i11) {
        move(i11, (long) this.duration, this.interpolator);
    }

    public void moveChild(int i11) {
        moveChild(i11, (long) this.duration, this.interpolator);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        super.onMeasure(i11, i12);
        if (!this.isCalculatedSize) {
            this.childSizeList.clear();
            int childCount = getChildCount();
            if (childCount > 0) {
                int i19 = 0;
                for (int i21 = 0; i21 < childCount; i21++) {
                    View childAt = getChildAt(i21);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (i21 > 0) {
                        i19 = this.childSizeList.get(i21 - 1).intValue();
                    }
                    List<Integer> list = this.childSizeList;
                    if (isVertical()) {
                        i18 = childAt.getMeasuredHeight() + layoutParams.topMargin;
                        i17 = layoutParams.bottomMargin;
                    } else {
                        i18 = childAt.getMeasuredWidth() + layoutParams.leftMargin;
                        i17 = layoutParams.rightMargin;
                    }
                    list.add(Integer.valueOf(i18 + i17 + i19));
                }
                int intValue = this.childSizeList.get(childCount - 1).intValue();
                if (isVertical()) {
                    i16 = getPaddingTop();
                    i15 = getPaddingBottom();
                } else {
                    i16 = getPaddingLeft();
                    i15 = getPaddingRight();
                }
                this.layoutSize = intValue + i16 + i15;
                this.isCalculatedSize = true;
            } else {
                throw new IllegalStateException("The expandableLinearLayout must have at least one child");
            }
        }
        if (!this.isArranged) {
            if (!this.defaultExpanded) {
                setLayoutSize(this.closePosition);
            }
            if (this.inRecyclerView) {
                if (this.recyclerExpanded) {
                    i14 = this.layoutSize;
                } else {
                    i14 = this.closePosition;
                }
                setLayoutSize(i14);
            }
            int size = this.childSizeList.size();
            int i22 = this.defaultChildIndex;
            if (size > i22 && size > 0) {
                moveChild(i22, 0, (TimeInterpolator) null);
            }
            int i23 = this.defaultPosition;
            if (i23 > 0 && (i13 = this.layoutSize) >= i23 && i13 > 0) {
                move(i23, 0, (TimeInterpolator) null);
            }
            this.isArranged = true;
            ExpandableSavedState expandableSavedState = this.savedState;
            if (expandableSavedState != null) {
                setLayoutSize(expandableSavedState.getSize());
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
        expandableSavedState.setSize(getCurrentPosition());
        return expandableSavedState;
    }

    public void setClosePosition(int i11) {
        this.closePosition = i11;
    }

    public void setClosePositionIndex(int i11) {
        this.closePosition = getChildPosition(i11);
    }

    public void setDuration(int i11) {
        if (i11 >= 0) {
            this.duration = i11;
            return;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + i11);
    }

    public void setExpanded(boolean z11) {
        int i11;
        if (this.inRecyclerView) {
            this.recyclerExpanded = z11;
        }
        int currentPosition = getCurrentPosition();
        if (z11 && currentPosition == this.layoutSize) {
            return;
        }
        if (z11 || currentPosition != this.closePosition) {
            this.isExpanded = z11;
            if (z11) {
                i11 = this.layoutSize;
            } else {
                i11 = this.closePosition;
            }
            setLayoutSize(i11);
            requestLayout();
        }
    }

    public void setInRecyclerView(boolean z11) {
        this.inRecyclerView = z11;
    }

    public void setInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.interpolator = timeInterpolator;
    }

    public void setListener(@NonNull ExpandableLayoutListener expandableLayoutListener) {
        this.listener = expandableLayoutListener;
    }

    public void setNonCollapsible() {
        setInterpolator((TimeInterpolator) null);
        setListener((ExpandableLayoutListener) null);
    }

    public void toggle() {
        toggle((long) this.duration, this.interpolator);
    }

    public ExpandableLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void move(int i11, long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating && i11 >= 0 && this.layoutSize >= i11) {
            if (j11 <= 0) {
                this.isExpanded = i11 > this.closePosition;
                setLayoutSize(i11);
                requestLayout();
                notifyListeners();
                return;
            }
            int currentPosition = getCurrentPosition();
            if (timeInterpolator == null) {
                timeInterpolator = this.interpolator;
            }
            createExpandAnimator(currentPosition, i11, j11, timeInterpolator).start();
        }
    }

    public void moveChild(int i11, long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            int childPosition = getChildPosition(i11) + (isVertical() ? getPaddingBottom() : getPaddingRight());
            if (j11 <= 0) {
                this.isExpanded = childPosition > this.closePosition;
                setLayoutSize(childPosition);
                requestLayout();
                notifyListeners();
                return;
            }
            int currentPosition = getCurrentPosition();
            if (timeInterpolator == null) {
                timeInterpolator = this.interpolator;
            }
            createExpandAnimator(currentPosition, childPosition, j11, timeInterpolator).start();
        }
    }

    public void toggle(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (this.closePosition < getCurrentPosition()) {
            collapse(j11, timeInterpolator);
        } else {
            expand(j11, timeInterpolator);
        }
    }

    public ExpandableLinearLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.interpolator = new LinearInterpolator();
        this.closePosition = 0;
        this.layoutSize = 0;
        this.inRecyclerView = false;
        this.isArranged = false;
        this.isCalculatedSize = false;
        this.isAnimating = false;
        this.recyclerExpanded = false;
        this.childSizeList = new ArrayList();
        init(context, attributeSet, i11);
    }

    public void expand(long j11, @Nullable TimeInterpolator timeInterpolator) {
        if (!this.isAnimating) {
            if (j11 <= 0) {
                move(this.layoutSize, j11, timeInterpolator);
                return;
            }
            createExpandAnimator(getCurrentPosition(), this.layoutSize, j11, timeInterpolator).start();
        }
    }

    @TargetApi(21)
    public ExpandableLinearLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.interpolator = new LinearInterpolator();
        this.closePosition = 0;
        this.layoutSize = 0;
        this.inRecyclerView = false;
        this.isArranged = false;
        this.isCalculatedSize = false;
        this.isAnimating = false;
        this.recyclerExpanded = false;
        this.childSizeList = new ArrayList();
        init(context, attributeSet, i11);
    }
}
