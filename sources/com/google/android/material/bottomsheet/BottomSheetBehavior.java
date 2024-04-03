package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private long viewCapturedMillis;

        private boolean releasedLow(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i11, int i12) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(@NonNull View view, int i11, int i12) {
            int i13;
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                i13 = bottomSheetBehavior.parentHeight;
            } else {
                i13 = bottomSheetBehavior.collapsedOffset;
            }
            return MathUtils.clamp(i11, expandedOffset, i13);
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        public void onViewDragStateChanged(int i11) {
            if (i11 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i11, int i12, int i13, int i14) {
            BottomSheetBehavior.this.dispatchOnSlide(i12);
        }

        public void onViewReleased(@NonNull View view, float f11, float f12) {
            int i11;
            int i12;
            int i13 = 6;
            if (f12 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.hideable || !bottomSheetBehavior.shouldHide(view, f12)) {
                    if (f12 == 0.0f || Math.abs(f11) > Math.abs(f12)) {
                        int top = view.getTop();
                        if (!BottomSheetBehavior.this.fitToContents) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i14 = bottomSheetBehavior2.halfExpandedOffset;
                            if (top >= i14) {
                                if (Math.abs(top - i14) >= Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                                    i12 = BottomSheetBehavior.this.collapsedOffset;
                                } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i12 = BottomSheetBehavior.this.collapsedOffset;
                                } else {
                                    i11 = BottomSheetBehavior.this.halfExpandedOffset;
                                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                                    bottomSheetBehavior3.startSettlingAnimation(view, i13, i11, bottomSheetBehavior3.shouldSkipSmoothAnimation());
                                }
                                i13 = 4;
                                BottomSheetBehavior bottomSheetBehavior32 = BottomSheetBehavior.this;
                                bottomSheetBehavior32.startSettlingAnimation(view, i13, i11, bottomSheetBehavior32.shouldSkipSmoothAnimation());
                            } else if (top < Math.abs(top - bottomSheetBehavior2.collapsedOffset)) {
                                i11 = BottomSheetBehavior.this.getExpandedOffset();
                            } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i12 = BottomSheetBehavior.this.collapsedOffset;
                                i13 = 4;
                                BottomSheetBehavior bottomSheetBehavior322 = BottomSheetBehavior.this;
                                bottomSheetBehavior322.startSettlingAnimation(view, i13, i11, bottomSheetBehavior322.shouldSkipSmoothAnimation());
                            } else {
                                i11 = BottomSheetBehavior.this.halfExpandedOffset;
                                BottomSheetBehavior bottomSheetBehavior3222 = BottomSheetBehavior.this;
                                bottomSheetBehavior3222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior3222.shouldSkipSmoothAnimation());
                            }
                        } else if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i11 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else {
                            i12 = BottomSheetBehavior.this.collapsedOffset;
                            i13 = 4;
                            BottomSheetBehavior bottomSheetBehavior32222 = BottomSheetBehavior.this;
                            bottomSheetBehavior32222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior32222.shouldSkipSmoothAnimation());
                        }
                    } else {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i12 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) >= Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                i12 = BottomSheetBehavior.this.collapsedOffset;
                            } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i12 = BottomSheetBehavior.this.collapsedOffset;
                            } else {
                                i11 = BottomSheetBehavior.this.halfExpandedOffset;
                                BottomSheetBehavior bottomSheetBehavior322222 = BottomSheetBehavior.this;
                                bottomSheetBehavior322222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior322222.shouldSkipSmoothAnimation());
                            }
                        }
                        i13 = 4;
                        BottomSheetBehavior bottomSheetBehavior3222222 = BottomSheetBehavior.this;
                        bottomSheetBehavior3222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior3222222.shouldSkipSmoothAnimation());
                    }
                } else if ((Math.abs(f11) < Math.abs(f12) && f12 > 500.0f) || releasedLow(view)) {
                    i11 = BottomSheetBehavior.this.parentHeight;
                    i13 = 5;
                    BottomSheetBehavior bottomSheetBehavior32222222 = BottomSheetBehavior.this;
                    bottomSheetBehavior32222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior32222222.shouldSkipSmoothAnimation());
                } else if (BottomSheetBehavior.this.fitToContents) {
                    i11 = BottomSheetBehavior.this.fitToContentsOffset;
                } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                    i11 = BottomSheetBehavior.this.getExpandedOffset();
                } else {
                    i11 = BottomSheetBehavior.this.halfExpandedOffset;
                    BottomSheetBehavior bottomSheetBehavior322222222 = BottomSheetBehavior.this;
                    bottomSheetBehavior322222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior322222222.shouldSkipSmoothAnimation());
                }
            } else if (BottomSheetBehavior.this.fitToContents) {
                i11 = BottomSheetBehavior.this.fitToContentsOffset;
            } else {
                int top3 = view.getTop();
                long currentTimeMillis = System.currentTimeMillis() - this.viewCapturedMillis;
                if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                    BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior4.shouldExpandOnUpwardDrag(currentTimeMillis, (((float) top3) * 100.0f) / ((float) bottomSheetBehavior4.parentHeight))) {
                        i11 = BottomSheetBehavior.this.expandedOffset;
                    } else {
                        i12 = BottomSheetBehavior.this.collapsedOffset;
                        i13 = 4;
                        BottomSheetBehavior bottomSheetBehavior3222222222 = BottomSheetBehavior.this;
                        bottomSheetBehavior3222222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior3222222222.shouldSkipSmoothAnimation());
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                    int i15 = bottomSheetBehavior5.halfExpandedOffset;
                    if (top3 > i15) {
                        i11 = i15;
                        BottomSheetBehavior bottomSheetBehavior32222222222 = BottomSheetBehavior.this;
                        bottomSheetBehavior32222222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior32222222222.shouldSkipSmoothAnimation());
                    }
                    i11 = bottomSheetBehavior5.getExpandedOffset();
                }
            }
            i13 = 3;
            BottomSheetBehavior bottomSheetBehavior322222222222 = BottomSheetBehavior.this;
            bottomSheetBehavior322222222222.startSettlingAnimation(view, i13, i11, bottomSheetBehavior322222222222.shouldSkipSmoothAnimation());
        }

        public boolean tryCaptureView(@NonNull View view, int i11) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i12 = bottomSheetBehavior.state;
            if (i12 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i12 == 3 && bottomSheetBehavior.activePointerId == i11) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.viewCapturedMillis = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    float elevation = -1.0f;
    private int expandHalfwayActionId = -1;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = 0.5f;
    boolean hideable;
    private boolean ignoreEvents;
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    /* access modifiers changed from: private */
    public int insetBottom;
    /* access modifiers changed from: private */
    public int insetTop;
    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState = 4;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private float maximumVelocity;
    private boolean nestedScrolled;
    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    /* access modifiers changed from: private */
    public boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable = null;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    @Nullable
    private VelocityTracker velocityTracker;
    @Nullable
    ViewDragHelper viewDragHelper;
    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f11);

        public abstract void onStateChanged(@NonNull View view, int i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
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
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z11 = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z11;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i11) {
            super(parcelable);
            this.state = i11;
        }
    }

    public class SettleRunnable implements Runnable {
        /* access modifiers changed from: private */
        public boolean isPosted;
        int targetState;
        private final View view;

        public SettleRunnable(View view2, int i11) {
            this.view = view2;
            this.targetState = i11;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                ViewCompat.postOnAnimation(this.view, this);
            }
            this.isPosted = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
    }

    private int addAccessibilityActionForState(V v11, @StringRes int i11, int i12) {
        return ViewCompat.addAccessibilityAction(v11, v11.getResources().getString(i11), createAccessibilityViewCommandForState(i12));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i11;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i11 = this.gestureInsetBottom) <= 0) {
            return this.peekHeight + this.insetBottom;
        }
        return Math.max(this.peekHeight, i11 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i11) {
        return new AccessibilityViewCommand() {
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i11);
                return true;
            }
        };
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z11) {
        createMaterialShapeDrawable(context, attributeSet, z11, (ColorStateList) null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v11) {
        ViewGroup.LayoutParams layoutParams = v11.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i11, int i12, int i13, int i14) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, i12, i14);
        if (i13 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i13), 1073741824);
        }
        if (size != 0) {
            i13 = Math.min(size, i13);
        }
        return View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V v11, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i11) {
        ViewCompat.replaceAccessibilityAction(v11, accessibilityActionCompat, (CharSequence) null, createAccessibilityViewCommandForState(i11));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i11 = this.saveFlags;
        if (i11 != 0) {
            if (i11 == -1 || (i11 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i11 == -1 || (i11 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i11 == -1 || (i11 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i11 == -1 || (i11 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void setWindowInsetsListener(@NonNull View view) {
        final boolean z11;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || z11) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    int i11;
                    int i12;
                    int unused = BottomSheetBehavior.this.insetTop = windowInsetsCompat.getSystemWindowInsetTop();
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                        int unused2 = BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                        paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                    }
                    if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                        if (isLayoutRtl) {
                            i12 = relativePadding.end;
                        } else {
                            i12 = relativePadding.start;
                        }
                        paddingLeft = i12 + windowInsetsCompat.getSystemWindowInsetLeft();
                    }
                    if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                        if (isLayoutRtl) {
                            i11 = relativePadding.start;
                        } else {
                            i11 = relativePadding.end;
                        }
                        paddingRight = i11 + windowInsetsCompat.getSystemWindowInsetRight();
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z11) {
                        int unused3 = BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                    }
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || z11) {
                        BottomSheetBehavior.this.updatePeekHeight(false);
                    }
                    return windowInsetsCompat;
                }
            });
        }
    }

    private void settleToStatePendingLayout(final int i11) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(view)) {
                settleToState(view, i11);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.settleToState(view, i11);
                    }
                });
            }
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        return this.viewDragHelper != null && (this.draggable || this.state == 1);
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(view, 524288);
            ViewCompat.removeAccessibilityAction(view, 262144);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            int i11 = this.expandHalfwayActionId;
            if (i11 != -1) {
                ViewCompat.removeAccessibilityAction(view, i11);
            }
            int i12 = 6;
            if (!this.fitToContents && this.state != 6) {
                this.expandHalfwayActionId = addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6);
            }
            if (this.hideable && this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            int i13 = this.state;
            if (i13 == 3) {
                if (this.fitToContents) {
                    i12 = 4;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i12);
            } else if (i13 == 4) {
                if (this.fitToContents) {
                    i12 = 3;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i12);
            } else if (i13 == 6) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    private void updateDrawableForTargetState(int i11) {
        boolean z11;
        ValueAnimator valueAnimator;
        float f11;
        if (i11 != 2) {
            if (i11 == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.isShapeExpanded != z11) {
                this.isShapeExpanded = z11;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    if (z11) {
                        f11 = 0.0f;
                    } else {
                        f11 = 1.0f;
                    }
                    this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f11, f11});
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private void updateImportantForAccessibility(boolean z11) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z11) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i11 = 0; i11 < childCount; i11++) {
                    V childAt = coordinatorLayout.getChildAt(i11);
                    if (childAt != this.viewRef.get()) {
                        if (z11) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                ViewCompat.setImportantForAccessibility(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z11) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z11) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z11) {
                    settleToStatePendingLayout(this.state);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i11) {
        float f11;
        float f12;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i12 = this.collapsedOffset;
            if (i11 > i12 || i12 == getExpandedOffset()) {
                int i13 = this.collapsedOffset;
                f11 = (float) (i13 - i11);
                f12 = (float) (this.parentHeight - i13);
            } else {
                int i14 = this.collapsedOffset;
                f11 = (float) (i14 - i11);
                f12 = (float) (i14 - getExpandedOffset());
            }
            float f13 = f11 / f12;
            for (int i15 = 0; i15 < this.callbacks.size(); i15++) {
                this.callbacks.get(i15).onSlide(view, f13);
            }
        }
    }

    @VisibleForTesting
    @Nullable
    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i11));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public int getExpandedOffset() {
        int i11;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i12 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i11 = 0;
        } else {
            i11 = this.insetTop;
        }
        return Math.max(i12, i11);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2;
        boolean z11;
        View view;
        if (!v11.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x11 = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x11, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            if (this.activePointerId != -1 || coordinatorLayout.isPointInChildBounds(v11, x11, this.initialY)) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.ignoreEvents = z11;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper2 = this.viewDragHelper) != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        boolean z11;
        float f11;
        MaterialShapeDrawable materialShapeDrawable2;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v11)) {
            v11.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v11);
            this.viewRef = new WeakReference<>(v11);
            if (this.shapeThemingEnabled && (materialShapeDrawable2 = this.materialShapeDrawable) != null) {
                ViewCompat.setBackground(v11, materialShapeDrawable2);
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
            if (materialShapeDrawable3 != null) {
                float f12 = this.elevation;
                if (f12 == -1.0f) {
                    f12 = ViewCompat.getElevation(v11);
                }
                materialShapeDrawable3.setElevation(f12);
                if (this.state == 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.isShapeExpanded = z11;
                MaterialShapeDrawable materialShapeDrawable4 = this.materialShapeDrawable;
                if (z11) {
                    f11 = 0.0f;
                } else {
                    f11 = 1.0f;
                }
                materialShapeDrawable4.setInterpolation(f11);
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v11) == 0) {
                ViewCompat.setImportantForAccessibility(v11, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v11.getTop();
        coordinatorLayout.onLayoutChild(v11, i11);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v11.getHeight();
        this.childHeight = height;
        int i12 = this.parentHeight;
        int i13 = i12 - height;
        int i14 = this.insetTop;
        if (i13 < i14) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i12;
            } else {
                this.childHeight = i12 - i14;
            }
        }
        this.fitToContentsOffset = Math.max(0, i12 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i15 = this.state;
        if (i15 == 3) {
            ViewCompat.offsetTopAndBottom(v11, getExpandedOffset());
        } else if (i15 == 6) {
            ViewCompat.offsetTopAndBottom(v11, this.halfExpandedOffset);
        } else if (this.hideable && i15 == 5) {
            ViewCompat.offsetTopAndBottom(v11, this.parentHeight);
        } else if (i15 == 4) {
            ViewCompat.offsetTopAndBottom(v11, this.collapsedOffset);
        } else if (i15 == 1 || i15 == 2) {
            ViewCompat.offsetTopAndBottom(v11, top - v11.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v11));
        return true;
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v11.getLayoutParams();
        v11.measure(getChildMeasureSpec(i11, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i13, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, float f11, float f12) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        if (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v11, view, f11, f12)) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        View view2;
        if (i13 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (!isNestedScrollingCheckEnabled() || view == view2) {
                int top = v11.getTop();
                int i14 = top - i12;
                if (i12 > 0) {
                    if (i14 < getExpandedOffset()) {
                        int expandedOffset2 = top - getExpandedOffset();
                        iArr[1] = expandedOffset2;
                        ViewCompat.offsetTopAndBottom(v11, -expandedOffset2);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i12;
                        ViewCompat.offsetTopAndBottom(v11, -i12);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i12 < 0 && !view.canScrollVertically(-1)) {
                    int i15 = this.collapsedOffset;
                    if (i14 > i15 && !this.hideable) {
                        int i16 = top - i15;
                        iArr[1] = i16;
                        ViewCompat.offsetTopAndBottom(v11, -i16);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i12;
                        ViewCompat.offsetTopAndBottom(v11, -i12);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v11.getTop());
                this.lastNestedScrollDy = i12;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v11, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            this.state = 4;
            this.lastStableState = 4;
            return;
        }
        this.state = i11;
        this.lastStableState = i11;
    }

    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v11), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i11 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11) {
        int i12;
        int i13;
        WeakReference<View> weakReference;
        int i14 = 3;
        if (v11.getTop() == getExpandedOffset()) {
            setStateInternal(3);
        } else if (!isNestedScrollingCheckEnabled() || ((weakReference = this.nestedScrollingChildRef) != null && view == weakReference.get() && this.nestedScrolled)) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i12 = this.fitToContentsOffset;
                } else {
                    int top = v11.getTop();
                    int i15 = this.halfExpandedOffset;
                    if (top > i15) {
                        i14 = 6;
                        i12 = i15;
                    } else {
                        i12 = getExpandedOffset();
                    }
                }
            } else if (!this.hideable || !shouldHide(v11, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top2 = v11.getTop();
                    if (!this.fitToContents) {
                        int i16 = this.halfExpandedOffset;
                        if (top2 < i16) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i12 = getExpandedOffset();
                            } else if (shouldSkipHalfExpandedStateWhenDragging()) {
                                i13 = this.collapsedOffset;
                            } else {
                                i12 = this.halfExpandedOffset;
                                i14 = 6;
                            }
                        } else if (Math.abs(top2 - i16) < Math.abs(top2 - this.collapsedOffset)) {
                            i12 = this.halfExpandedOffset;
                            i14 = 6;
                        } else {
                            i13 = this.collapsedOffset;
                        }
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i12 = this.fitToContentsOffset;
                    } else {
                        i13 = this.collapsedOffset;
                    }
                } else if (this.fitToContents) {
                    i13 = this.collapsedOffset;
                } else {
                    int top3 = v11.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i12 = this.halfExpandedOffset;
                        i14 = 6;
                    } else {
                        i13 = this.collapsedOffset;
                    }
                }
                i14 = 4;
            } else {
                i12 = this.parentHeight;
                i14 = 5;
            }
            startSettlingAnimation(v11, i14, i12, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        if (!v11.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.getTouchSlop())) {
            this.viewDragHelper.captureChildView(v11, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z11) {
        this.draggable = z11;
    }

    public void setExpandedOffset(int i11) {
        if (i11 >= 0) {
            this.expandedOffset = i11;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z11) {
        int i11;
        if (this.fitToContents != z11) {
            this.fitToContents = z11;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            if (!this.fitToContents || this.state != 6) {
                i11 = this.state;
            } else {
                i11 = 3;
            }
            setStateInternal(i11);
            updateAccessibilityActions();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z11) {
        this.gestureInsetBottomIgnored = z11;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f11;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideable(boolean z11) {
        if (this.hideable != z11) {
            this.hideable = z11;
            if (!z11 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean z11) {
        this.hideable = z11;
    }

    public void setMaxHeight(@Px int i11) {
        this.maxHeight = i11;
    }

    public void setMaxWidth(@Px int i11) {
        this.maxWidth = i11;
    }

    public void setPeekHeight(int i11) {
        setPeekHeight(i11, false);
    }

    public void setSaveFlags(int i11) {
        this.saveFlags = i11;
    }

    public void setSkipCollapsed(boolean z11) {
        this.skipCollapsed = z11;
    }

    public void setState(int i11) {
        if (i11 != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i11);
            } else if (i11 == 4 || i11 == 3 || i11 == 6 || (this.hideable && i11 == 5)) {
                this.state = i11;
                this.lastStableState = i11;
            }
        }
    }

    public void setStateInternal(int i11) {
        View view;
        if (this.state != i11) {
            this.state = i11;
            if (i11 == 4 || i11 == 3 || i11 == 6 || (this.hideable && i11 == 5)) {
                this.lastStableState = i11;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i11 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i11 == 6 || i11 == 5 || i11 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i11);
                for (int i12 = 0; i12 < this.callbacks.size(); i12++) {
                    this.callbacks.get(i12).onStateChanged(view, i11);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z11) {
        this.updateImportantForAccessibilityOnSiblings = z11;
    }

    public void settleToState(@NonNull View view, int i11) {
        int i12;
        int i13;
        if (i11 == 4) {
            i12 = this.collapsedOffset;
        } else if (i11 == 6) {
            i12 = this.halfExpandedOffset;
            if (this.fitToContents && i12 <= (i13 = this.fitToContentsOffset)) {
                i11 = 3;
                i12 = i13;
            }
        } else if (i11 == 3) {
            i12 = getExpandedOffset();
        } else if (!this.hideable || i11 != 5) {
            Log.w(TAG, "The bottom sheet may be in an invalid state. Ensure `hideable` is true when using `STATE_HIDDEN`.");
            return;
        } else {
            i12 = this.parentHeight;
        }
        startSettlingAnimation(view, i11, i12, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long j11, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        return false;
    }

    public boolean shouldHide(@NonNull View view, float f11) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f11 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public void startSettlingAnimation(View view, int i11, int i12, boolean z11) {
        boolean z12;
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null || (!z11 ? !viewDragHelper2.smoothSlideViewTo(view, view.getLeft(), i12) : !viewDragHelper2.settleCapturedViewAt(view.getLeft(), i12))) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            setStateInternal(2);
            updateDrawableForTargetState(i11);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i11);
            }
            if (!this.settleRunnable.isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable2 = this.settleRunnable;
                settleRunnable2.targetState = i11;
                ViewCompat.postOnAnimation(view, settleRunnable2);
                boolean unused = this.settleRunnable.isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i11;
            return;
        }
        setStateInternal(i11);
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z11, @Nullable ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            if (!z11 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r1
            goto L_0x001f
        L_0x000c:
            boolean r0 = r3.peekHeightAuto
            if (r0 != 0) goto L_0x0017
            int r0 = r3.peekHeight
            if (r0 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = r2
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r3.updatePeekHeight(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i11;
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i12 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i12);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i12));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i13 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i13)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i14)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        int i15 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i15);
        if (peekValue == null || (i11 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i15, -1));
        } else {
            setPeekHeight(i11);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i16 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i16);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i16, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
