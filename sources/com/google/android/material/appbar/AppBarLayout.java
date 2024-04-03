package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    @Nullable
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    /* access modifiers changed from: private */
    public final List<LiftOnScrollListener> liftOnScrollListeners;
    @Nullable
    private WeakReference<View> liftOnScrollTargetView;
    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    /* access modifiers changed from: private */
    @Nullable
    public Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        /* access modifiers changed from: private */
        public int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(@NonNull T t11);
        }

        public BaseBehavior() {
        }

        private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, @NonNull T t11, @NonNull View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t11.getTotalScrollRange()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (getTopBottomOffsetForScrollingSibling() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                final int i11 = -t11.getDownNestedPreScrollRange();
                if (i11 != 0) {
                    final CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                    final T t12 = t11;
                    final View view2 = view;
                    ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, (CharSequence) null, new AccessibilityViewCommand() {
                        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                            BaseBehavior.this.onNestedPreScroll(coordinatorLayout2, t12, view2, 0, i11, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            addActionToExpand(coordinatorLayout, t11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, @NonNull final T t11, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final boolean z11) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    t11.setExpanded(z11);
                    return true;
                }
            });
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, float f11) {
            int i12;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i11);
            float abs2 = Math.abs(f11);
            if (abs2 > 0.0f) {
                i12 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i12 = (int) (((((float) abs) / ((float) t11.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t11, i11, i12);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t11, int i11, int i12) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i11) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t11, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration((long) Math.min(i12, 600));
            this.offsetAnimator.setIntValues(new int[]{topBottomOffsetForScrollingSibling, i11});
            this.offsetAnimator.start();
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, @NonNull View view) {
            if (!t11.hasScrollableChildren() || coordinatorLayout.getHeight() - view.getHeight() > t11.getHeight()) {
                return false;
            }
            return true;
        }

        private static boolean checkFlag(int i11, int i12) {
            return (i11 & i12) == i12;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i11) {
            int abs = Math.abs(i11);
            int childCount = appBarLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = appBarLayout.getChildAt(i12);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T t11, int i11) {
            int childCount = t11.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = t11.getChildAt(i12);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i13 = -i11;
                if (top <= i13 && bottom >= i13) {
                    return i12;
                }
            }
            return -1;
        }

        private int interpolateOffset(@NonNull T t11, int i11) {
            int abs = Math.abs(i11);
            int childCount = t11.getChildCount();
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                View childAt = t11.getChildAt(i13);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i13++;
                } else if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        i12 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((scrollFlags & 2) != 0) {
                            i12 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i12 -= t11.getTopInset();
                    }
                    if (i12 > 0) {
                        float f11 = (float) i12;
                        return Integer.signum(i11) * (childAt.getTop() + Math.round(f11 * scrollInterpolator.getInterpolation(((float) (abs - childAt.getTop())) / f11)));
                    }
                }
            }
            return i11;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            List<View> dependents = coordinatorLayout.getDependents(t11);
            int size = dependents.size();
            int i11 = 0;
            while (i11 < size) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i11).getLayoutParams()).getBehavior();
                if (!(behavior instanceof ScrollingViewBehavior)) {
                    i11++;
                } else if (((ScrollingViewBehavior) behavior).getOverlayTop() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(t11, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t11.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i11 = -childAt.getTop();
                    int i12 = -childAt.getBottom();
                    if (childIndexOnOffset == t11.getChildCount() - 1) {
                        i12 += t11.getTopInset() + t11.getPaddingTop();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i12 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i12;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i11 = minimumHeight;
                        } else {
                            i12 = minimumHeight;
                        }
                    }
                    if (checkFlag(scrollFlags, 32)) {
                        i11 += layoutParams.topMargin;
                        i12 -= layoutParams.bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (i12 + i11) / 2) {
                        i11 = i12;
                    }
                    animateOffsetTo(coordinatorLayout, t11, MathUtils.clamp(i11, -t11.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild != null && t11.getTotalScrollRange() != 0 && (((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                addAccessibilityScrollActions(coordinatorLayout, t11, findFirstScrollingChild);
            }
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, boolean z11) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t11, i11);
            boolean z12 = false;
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i12 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i11) < (appBarChildOnOffset.getBottom() - minimumHeight) - t11.getTopInset()) : (-i11) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t11.getTopInset()) {
                        z12 = true;
                    }
                }
            }
            if (t11.isLiftOnScroll()) {
                z12 = t11.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t11.setLiftedState(z12);
            if (z11 || (liftedState && shouldJumpElevationState(coordinatorLayout, t11))) {
                t11.jumpDrawablesToCurrentState();
            }
        }

        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean canDragView(T t11) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t11);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        public int getMaxDragOffset(@NonNull T t11) {
            return -t11.getDownNestedScrollRange();
        }

        public int getScrollRangeForDragFling(@NonNull T t11) {
            return t11.getTotalScrollRange();
        }

        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            snapToChildIfNeeded(coordinatorLayout, t11);
            if (t11.isLiftOnScroll()) {
                t11.setLiftedState(t11.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11) {
            int i12;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t11, i11);
            int pendingAction = t11.getPendingAction();
            SavedState savedState2 = this.savedState;
            if (savedState2 == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z11 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i13 = -t11.getUpNestedPreScrollRange();
                        if (z11) {
                            animateOffsetTo(coordinatorLayout, t11, i13, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t11, i13);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z11) {
                            animateOffsetTo(coordinatorLayout, t11, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t11, 0);
                        }
                    }
                }
            } else if (savedState2.fullyScrolled) {
                setHeaderTopBottomOffset(coordinatorLayout, t11, -t11.getTotalScrollRange());
            } else {
                View childAt = t11.getChildAt(savedState2.firstVisibleChildIndex);
                int i14 = -childAt.getBottom();
                if (this.savedState.firstVisibleChildAtMinimumHeight) {
                    i12 = ViewCompat.getMinimumHeight(childAt) + t11.getTopInset();
                } else {
                    i12 = Math.round(((float) childAt.getHeight()) * this.savedState.firstVisibleChildPercentageShown);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t11, i14 + i12);
            }
            t11.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t11.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t11, getTopAndBottomOffset(), 0, true);
            t11.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t11);
            return onLayoutChild;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, int i13, int i14) {
            if (((CoordinatorLayout.LayoutParams) t11.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t11, i11, i12, i13, i14);
            }
            coordinatorLayout.onMeasureChild(t11, i11, i12, View.MeasureSpec.makeMeasureSpec(0, 0), i14);
            return true;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11, int i12, int[] iArr, int i13) {
            int i14;
            int i15;
            if (i12 != 0) {
                if (i12 < 0) {
                    i15 = -t11.getTotalScrollRange();
                    i14 = t11.getDownNestedPreScrollRange() + i15;
                } else {
                    i15 = -t11.getUpNestedPreScrollRange();
                    i14 = 0;
                }
                int i16 = i15;
                int i17 = i14;
                if (i16 != i17) {
                    iArr[1] = scroll(coordinatorLayout, t11, i12, i16, i17);
                }
            }
            if (t11.isLiftOnScroll()) {
                t11.setLiftedState(t11.shouldLift(view));
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            if (i14 < 0) {
                iArr[1] = scroll(coordinatorLayout, t11, i14, -t11.getDownNestedScrollRange(), 0);
            }
            if (i14 == 0) {
                updateAccessibilityActions(coordinatorLayout, t11);
            }
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState2 = (SavedState) parcelable;
                this.savedState = savedState2;
                super.onRestoreInstanceState(coordinatorLayout, t11, savedState2.getSuperState());
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t11, parcelable);
            this.savedState = null;
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t11);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t11.getChildCount();
            boolean z11 = false;
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = t11.getChildAt(i11);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i11++;
                } else {
                    SavedState savedState2 = new SavedState(onSaveInstanceState);
                    savedState2.fullyScrolled = (-getTopAndBottomOffset()) >= t11.getTotalScrollRange();
                    savedState2.firstVisibleChildIndex = i11;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t11.getTopInset()) {
                        z11 = true;
                    }
                    savedState2.firstVisibleChildAtMinimumHeight = z11;
                    savedState2.firstVisibleChildPercentageShown = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState2;
                }
            }
            return onSaveInstanceState;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, @NonNull View view, View view2, int i11, int i12) {
            ValueAnimator valueAnimator;
            boolean z11 = (i11 & 2) != 0 && (t11.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t11, view));
            if (z11 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i12;
            return z11;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11) {
            if (this.lastStartedType == 0 || i11 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t11);
                if (t11.isLiftOnScroll()) {
                    t11.setLiftedState(t11.shouldLift(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, int i13) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i14 = 0;
            if (i12 == 0 || topBottomOffsetForScrollingSibling < i12 || topBottomOffsetForScrollingSibling > i13) {
                this.offsetDelta = 0;
            } else {
                int clamp = MathUtils.clamp(i11, i12, i13);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    int interpolateOffset = t11.hasChildWithInterpolator() ? interpolateOffset(t11, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i15 = topBottomOffsetForScrollingSibling - clamp;
                    this.offsetDelta = clamp - interpolateOffset;
                    int i16 = 1;
                    if (topAndBottomOffset) {
                        while (i14 < t11.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t11.getChildAt(i14).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (!(scrollEffect == null || (layoutParams.getScrollFlags() & 1) == 0)) {
                                scrollEffect.onOffsetChanged(t11, t11.getChildAt(i14), (float) getTopAndBottomOffset());
                            }
                            i14++;
                        }
                    }
                    if (!topAndBottomOffset && t11.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t11);
                    }
                    t11.onOffsetChanged(getTopAndBottomOffset());
                    if (clamp < topBottomOffsetForScrollingSibling) {
                        i16 = -1;
                    }
                    updateAppBarLayoutDrawableState(coordinatorLayout, t11, clamp, i16, false);
                    i14 = i15;
                }
            }
            updateAccessibilityActions(coordinatorLayout, t11);
            return i14;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                @NonNull
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }

                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, (ClassLoader) null);
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyScrolled;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                boolean z11 = true;
                this.fullyScrolled = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() == 0 ? false : z11;
            }

            public void writeToParcel(@NonNull Parcel parcel, int i11) {
                super.writeToParcel(parcel, i11);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t11, int i11);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i11) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i11);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i11, int i12, int i13, int i14) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i11, i12, i13, i14);
        }

        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        }

        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15, iArr);
        }

        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i11, int i12) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i11, i12);
        }

        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i11);
        }

        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z11) {
            super.setHorizontalOffsetEnabled(z11);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i11) {
            return super.setLeftAndRightOffset(i11);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i11) {
            return super.setTopAndBottomOffset(i11);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z11) {
            super.setVerticalOffsetEnabled(z11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f11);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect = new Rect();
        private final Rect relativeRect = new Rect();

        private static void updateRelativeRect(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f11) {
            updateRelativeRect(this.relativeRect, appBarLayout, view);
            float abs = ((float) this.relativeRect.top) - Math.abs(f11);
            if (abs <= 0.0f) {
                float clamp = 1.0f - MathUtils.clamp(Math.abs(abs / ((float) this.relativeRect.height())), 0.0f, 1.0f);
                float height = (-abs) - ((((float) this.relativeRect.height()) * 0.3f) * (1.0f - (clamp * clamp)));
                view.setTranslationY(height);
                view.getDrawingRect(this.ghostRect);
                this.ghostRect.offset(0, (int) (-height));
                ViewCompat.setClipBounds(view, this.ghostRect);
                return;
            }
            ViewCompat.setClipBounds(view, (Rect) null);
            view.setTranslationY(0.0f);
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float f11, @ColorInt int i11);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        void onOffsetChanged(AppBarLayout appBarLayout, int i11);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public float getOverlapRatioForOffset(View view) {
            int i11;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i11 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) appBarLayoutOffset) / ((float) i11)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11) {
            return super.onLayoutChild(coordinatorLayout, view, i11);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11, int i12, int i13, int i14) {
            return super.onMeasureChild(coordinatorLayout, view, i11, i12, i13, i14);
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z11) {
            AppBarLayout findFirstDependency = findFirstDependency((List) coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z11);
                    return true;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z11) {
            super.setHorizontalOffsetEnabled(z11);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i11) {
            return super.setLeftAndRightOffset(i11);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i11) {
            return super.setTopAndBottomOffset(i11);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z11) {
            super.setVerticalOffsetEnabled(z11);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = list.get(i11);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View view) {
        int i11;
        View view2;
        if (this.liftOnScrollTargetView == null && (i11 = this.liftOnScrollTargetViewId) != -1) {
            if (view != null) {
                view2 = view.findViewById(i11);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (view2 != null) {
                this.liftOnScrollTargetView = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((LayoutParams) getChildAt(i11).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    private boolean setLiftableState(boolean z11) {
        if (this.liftable == z11) {
            return false;
        }
        this.liftable = z11;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) {
            return false;
        }
        return true;
    }

    private void startLiftOnScrollElevationOverlayAnimation(@NonNull final MaterialShapeDrawable materialShapeDrawable, boolean z11) {
        float f11;
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = dimension;
        }
        if (!z11) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, dimension});
        this.elevationOverlayAnimator = ofFloat;
        ofFloat.setDuration((long) getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                materialShapeDrawable.setElevation(floatValue);
                if (AppBarLayout.this.statusBarForeground instanceof MaterialShapeDrawable) {
                    ((MaterialShapeDrawable) AppBarLayout.this.statusBarForeground).setElevation(floatValue);
                }
                for (LiftOnScrollListener onUpdate : AppBarLayout.this.liftOnScrollListeners) {
                    onUpdate.onUpdate(floatValue, materialShapeDrawable.getResolvedTintColor());
                }
            }
        });
        this.elevationOverlayAnimator.start();
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.liftOnScrollListeners.add(liftOnScrollListener);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.listeners.contains(baseOnOffsetChangedListener)) {
            this.listeners.add(baseOnOffsetChangedListener);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.currentOffset));
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i11;
        int minimumHeight;
        int i12 = this.downPreScrollRange;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i14 = layoutParams.scrollFlags;
            if ((i14 & 5) == 5) {
                int i15 = layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i14 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i14 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i11 = i15 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i11 = Math.min(i11, measuredHeight - getTopInset());
                    }
                    i13 += i11;
                }
                i11 = i15 + minimumHeight;
                i11 = Math.min(i11, measuredHeight - getTopInset());
                i13 += i11;
            } else if (i13 > 0) {
                break;
            }
        }
        int max = Math.max(0, i13);
        this.downPreScrollRange = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i11 = this.downScrollRange;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i14 = layoutParams.scrollFlags;
            if ((i14 & 1) == 0) {
                break;
            }
            i13 += measuredHeight;
            if ((i14 & 2) != 0) {
                i13 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i12++;
        }
        int max = Math.max(0, i13);
        this.downScrollRange = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                minimumHeight = ViewCompat.getMinimumHeight(getChildAt(childCount - 1));
            } else {
                minimumHeight = 0;
            }
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i11 = this.totalScrollRange;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i14 = layoutParams.scrollFlags;
            if ((i14 & 1) == 0) {
                break;
            }
            i13 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if (i12 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i13 -= getTopInset();
            }
            if ((i14 & 2) != 0) {
                i13 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i12++;
        }
        int max = Math.max(0, i13);
        this.totalScrollRange = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public int[] onCreateDrawableState(int i11) {
        int i12;
        int i13;
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + iArr.length);
        boolean z11 = this.liftable;
        int i14 = R.attr.state_liftable;
        if (!z11) {
            i14 = -i14;
        }
        iArr[0] = i14;
        if (!z11 || !this.lifted) {
            i12 = -R.attr.state_lifted;
        } else {
            i12 = R.attr.state_lifted;
        }
        iArr[1] = i12;
        int i15 = R.attr.state_collapsible;
        if (!z11) {
            i15 = -i15;
        }
        iArr[2] = i15;
        if (!z11 || !this.lifted) {
            i13 = -R.attr.state_collapsed;
        } else {
            i13 = R.attr.state_collapsed;
        }
        iArr[3] = i13;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        boolean z12 = true;
        if (ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i15 = 0;
        while (true) {
            if (i15 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i15).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            } else {
                i15++;
            }
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.liftableOverride) {
            if (!this.liftOnScroll && !hasCollapsibleChild()) {
                z12 = false;
            }
            setLiftableState(z12);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i12));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    public void onOffsetChanged(int i11) {
        this.currentOffset = i11;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i12);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i11);
                }
            }
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            updateWillNotDraw();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.liftOnScrollListeners.remove(liftOnScrollListener);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        MaterialShapeUtils.setElevation(this, f11);
    }

    public void setExpanded(boolean z11) {
        setExpanded(z11, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z11) {
        this.liftOnScroll = z11;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i11) {
        this.liftOnScrollTargetViewId = i11;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean z11) {
        this.liftableOverride = true;
        return setLiftableState(z11);
    }

    public void setLiftableOverrideEnabled(boolean z11) {
        this.liftableOverride = z11;
    }

    public boolean setLifted(boolean z11) {
        return setLiftedState(z11, true);
    }

    public boolean setLiftedState(boolean z11) {
        return setLiftedState(z11, !this.liftableOverride);
    }

    public void setOrientation(int i11) {
        if (i11 == 1) {
            super.setOrientation(i11);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z11;
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarForeground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.statusBarForeground;
                if (getVisibility() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                drawable4.setVisible(z11, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i11) {
        setStatusBarForeground(new ColorDrawable(i11));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i11) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i11));
    }

    @Deprecated
    public void setTargetElevation(float f11) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f11);
    }

    public void setVisibility(int i11) {
        boolean z11;
        super.setVisibility(i11);
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z11, false);
        }
    }

    public boolean shouldLift(@Nullable View view) {
        View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (findLiftOnScrollTargetView != null) {
            view = findLiftOnScrollTargetView;
        }
        if (view == null || (!view.canScrollVertically(-1) && view.getScrollY() <= 0)) {
            return false;
        }
        return true;
    }

    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z11, boolean z12) {
        setExpanded(z11, z12, true);
    }

    public boolean setLiftedState(boolean z11, boolean z12) {
        if (!z12 || this.lifted == z11) {
            return false;
        }
        this.lifted = z11;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), z11);
        return true;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r10 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.totalScrollRange = r10
            r9.downPreScrollRange = r10
            r9.downScrollRange = r10
            r6 = 0
            r9.pendingAction = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.liftOnScrollListeners = r0
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r0 = r9.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L_0x002f
            com.google.android.material.appbar.ViewUtilsLollipop.setBoundsViewOutlineProvider(r9)
        L_0x002f:
            com.google.android.material.appbar.ViewUtilsLollipop.setStateListAnimatorFromAttrs(r9, r11, r12, r4)
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            androidx.core.view.ViewCompat.setBackground(r9, r12)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            boolean r12 = r12 instanceof android.graphics.drawable.ColorDrawable
            if (r12 == 0) goto L_0x006a
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r12 = (android.graphics.drawable.ColorDrawable) r12
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            int r12 = r12.getColor()
            android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r12)
            r0.setFillColor(r12)
            r0.initializeElevationOverlay(r7)
            androidx.core.view.ViewCompat.setBackground(r9, r0)
        L_0x006a:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x0079
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setExpanded(r12, r6, r6)
        L_0x0079:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x0089
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(r9, r12)
        L_0x0089:
            r12 = 26
            if (r8 < r12) goto L_0x00ab
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x009c
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        L_0x009c:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x00ab
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        L_0x00ab:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r12 = r11.getBoolean(r12, r6)
            r9.liftOnScroll = r12
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r10 = r11.getResourceId(r12, r10)
            r9.liftOnScrollTargetViewId = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r10 = new com.google.android.material.appbar.AppBarLayout$1
            r10.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setExpanded(boolean z11, boolean z12, boolean z13) {
        int i11 = 0;
        int i12 = (z11 ? 1 : 2) | (z12 ? 4 : 0);
        if (z13) {
            i11 = 8;
        }
        this.pendingAction = i12 | i11;
        requestLayout();
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        private static final int SCROLL_EFFECT_COMPRESS = 1;
        private static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags = 1;
        Interpolator scrollInterpolator;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(createScrollEffectFromInt(obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int i11 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i11)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i11, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int i11) {
            if (i11 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        public boolean isCollapsible() {
            int i11 = this.scrollFlags;
            return (i11 & 1) == 1 && (i11 & 10) != 0;
        }

        public void setScrollEffect(@Nullable ChildScrollEffect childScrollEffect) {
            this.scrollEffect = childScrollEffect;
        }

        public void setScrollFlags(int i11) {
            this.scrollFlags = i11;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(int i11, int i12, float f11) {
            super(i11, i12, f11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }
}
