package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    @VisibleForTesting
    static final int CIRCLE_DIAMETER = 40;
    @VisibleForTesting
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {16842766};
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateOffsetToCorrectPosition(int i11, Animation.AnimationListener animationListener) {
        this.mFrom = i11;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i11, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i11, animationListener);
            return;
        }
        this.mFrom = i11;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext());
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f11) {
        AnonymousClass5 r02;
        if (f11 > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        if (!this.mScale) {
            r02 = new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    if (!swipeRefreshLayout.mScale) {
                        swipeRefreshLayout.startScaleDownAnimation((Animation.AnimationListener) null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        } else {
            r02 = null;
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r02);
        this.mProgress.setArrowEnabled(false);
    }

    private boolean isAnimationRunning(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void moveSpinner(float f11) {
        this.mProgress.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f11 / this.mTotalDragDistance));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f11) - this.mTotalDragDistance;
        int i11 = this.mCustomSlingshotDistance;
        if (i11 <= 0) {
            if (this.mUsingCustomStart) {
                i11 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
            } else {
                i11 = this.mSpinnerOffsetEnd;
            }
        }
        float f12 = (float) i11;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f12 * 2.0f) / f12) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i12 = this.mOriginalOffsetTop + ((int) ((f12 * min) + (f12 * pow * 2.0f)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f11 / this.mTotalDragDistance));
        }
        if (f11 < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.mProgress.setArrowScale(Math.min(1.0f, max));
        this.mProgress.setProgressRotation((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i12 - this.mCurrentTargetOffsetTop);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i11;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            this.mActivePointerId = motionEvent.getPointerId(i11);
        }
    }

    private void setColorViewAlpha(int i11) {
        this.mCircleView.getBackground().setAlpha(i11);
        this.mProgress.setAlpha(i11);
    }

    private Animation startAlphaAnimation(final int i11, final int i12) {
        AnonymousClass4 r02 = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.mProgress;
                int i11 = i11;
                circularProgressDrawable.setAlpha((int) (((float) i11) + (((float) (i12 - i11)) * f11)));
            }
        };
        r02.setDuration(300);
        this.mCircleView.setAnimationListener((Animation.AnimationListener) null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r02);
        return r02;
    }

    private void startDragging(float f11) {
        float f12 = this.mInitialDownY;
        int i11 = this.mTouchSlop;
        if (f11 - f12 > ((float) i11) && !this.mIsBeingDragged) {
            this.mInitialMotionY = f12 + ((float) i11);
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startScaleDownReturnToStartAnimation(int i11, Animation.AnimationListener animationListener) {
        this.mFrom = i11;
        this.mStartingScale = this.mCircleView.getScaleX();
        AnonymousClass8 r32 = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f12 = swipeRefreshLayout.mStartingScale;
                swipeRefreshLayout.setAnimationProgress(f12 + ((-f12) * f11));
                SwipeRefreshLayout.this.moveToStart(f11);
            }
        };
        this.mScaleDownToStartAnimation = r32;
        r32.setDuration(150);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        AnonymousClass2 r02 = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f11);
            }
        };
        this.mScaleAnimation = r02;
        r02.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return i13 == 0 && dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @NonNull int[] iArr2) {
        if (i15 == 0) {
            this.mNestedScrollingChildHelper.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
        }
    }

    public int getChildDrawingOrder(int i11, int i12) {
        int i13 = this.mCircleViewIndex;
        return i13 < 0 ? i12 : i12 == i11 + -1 ? i13 : i12 >= i13 ? i12 + 1 : i12;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent(int i11) {
        return i11 == 0 && hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float f11) {
        int i11 = this.mFrom;
        setTargetOffsetTopAndBottom((i11 + ((int) (((float) (this.mOriginalOffsetTop - i11)) * f11))) - this.mCircleView.getTop());
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i11 = this.mActivePointerId;
                    if (i11 == -1) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    startDragging(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(findPointerIndex2);
        }
        return this.mIsBeingDragged;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            View view = this.mTarget;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.mCircleView.getMeasuredWidth();
                int measuredHeight2 = this.mCircleView.getMeasuredHeight();
                int i15 = measuredWidth / 2;
                int i16 = measuredWidth2 / 2;
                int i17 = this.mCurrentTargetOffsetTop;
                this.mCircleView.layout(i15 - i16, i17, i15 + i16, measuredHeight2 + i17);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                if (getChildAt(i13) == this.mCircleView) {
                    this.mCircleViewIndex = i13;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        return dispatchNestedFling(f11, f12, z11);
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        if (i15 == 0) {
            int i16 = iArr[1];
            dispatchNestedScroll(i11, i12, i13, i14, this.mParentOffsetInWindow, i15, iArr);
            int i17 = i14 - (iArr[1] - i16);
            int i18 = i17 == 0 ? i14 + this.mParentOffsetInWindow[1] : i17;
            if (i18 < 0 && !canChildScrollUp()) {
                float abs = this.mTotalUnconsumed + ((float) Math.abs(i18));
                this.mTotalUnconsumed = abs;
                moveSpinner(abs);
                iArr[1] = iArr[1] + i17;
            }
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f37668b);
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mRefreshing);
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            return onStartNestedScroll(view, view2, i11);
        }
        return false;
    }

    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex < 0) {
                Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.mIsBeingDragged) {
                this.mIsBeingDragged = false;
                finishSpinner((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f);
            }
            this.mActivePointerId = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex2 < 0) {
                Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y11 = motionEvent.getY(findPointerIndex2);
            startDragging(y11);
            if (this.mIsBeingDragged) {
                float f11 = (y11 - this.mInitialMotionY) * 0.5f;
                if (f11 <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                moveSpinner(f11);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        ViewParent parent;
        View view = this.mTarget;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z11);
        } else if (!this.mEnableLegacyRequestDisallowInterceptTouch && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f11) {
        this.mCircleView.setScaleX(f11);
        this.mCircleView.setScaleY(f11);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr2[i11] = ContextCompat.getColor(context, iArr[i11]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i11) {
        this.mTotalDragDistance = (float) i11;
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (!z11) {
            reset();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z11) {
        this.mEnableLegacyRequestDisallowInterceptTouch = z11;
    }

    public void setNestedScrollingEnabled(boolean z11) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z11);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i11) {
        setProgressBackgroundColorSchemeResource(i11);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i11) {
        this.mCircleView.setBackgroundColor(i11);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i11) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setProgressViewEndTarget(boolean z11, int i11) {
        this.mSpinnerOffsetEnd = i11;
        this.mScale = z11;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z11, int i11, int i12) {
        this.mScale = z11;
        this.mOriginalOffsetTop = i11;
        this.mSpinnerOffsetEnd = i12;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z11) {
        int i11;
        if (!z11 || this.mRefreshing == z11) {
            setRefreshing(z11, false);
            return;
        }
        this.mRefreshing = z11;
        if (!this.mUsingCustomStart) {
            i11 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
        } else {
            i11 = this.mSpinnerOffsetEnd;
        }
        setTargetOffsetTopAndBottom(i11 - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i11) {
        if (i11 == 0 || i11 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i11 == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable((Drawable) null);
            this.mProgress.setStyle(i11);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public void setSlingshotDistance(@Px int i11) {
        this.mCustomSlingshotDistance = i11;
    }

    public void setTargetOffsetTopAndBottom(int i11) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, i11);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public boolean startNestedScroll(int i11, int i12) {
        return i12 == 0 && startNestedScroll(i11);
    }

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        AnonymousClass3 r02 = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f11);
            }
        };
        this.mScaleDownAnimation = r02;
        r02.setDuration(150);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public void stopNestedScroll(int i11) {
        if (i11 == 0) {
            stopNestedScroll();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37668b;

        public SavedState(Parcelable parcelable, boolean z11) {
            super(parcelable);
            this.f37668b = z11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeByte(this.f37668b ? (byte) 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f37668b = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.mRefreshing) {
                    swipeRefreshLayout.mProgress.setAlpha(255);
                    SwipeRefreshLayout.this.mProgress.start();
                    SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                    if (swipeRefreshLayout2.mNotify && (onRefreshListener = swipeRefreshLayout2.mListener) != null) {
                        onRefreshListener.onRefresh();
                    }
                    SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                    swipeRefreshLayout3.mCurrentTargetOffsetTop = swipeRefreshLayout3.mCircleView.getTop();
                    return;
                }
                swipeRefreshLayout.reset();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mAnimateToCorrectPosition = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                int i11;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.mUsingCustomStart) {
                    i11 = swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop);
                } else {
                    i11 = swipeRefreshLayout.mSpinnerOffsetEnd;
                }
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                int i12 = swipeRefreshLayout2.mFrom;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i12 + ((int) (((float) (i11 - i12)) * f11))) - swipeRefreshLayout2.mCircleView.getTop());
                SwipeRefreshLayout.this.mProgress.setArrowScale(1.0f - f11);
            }
        };
        this.mAnimateToStartPosition = new Animation() {
            public void applyTransformation(float f11, Transformation transformation) {
                SwipeRefreshLayout.this.moveToStart(f11);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int i11 = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i11;
        this.mTotalDragDistance = (float) i11;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i12 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i12;
        this.mOriginalOffsetTop = i12;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return i15 == 0 && this.mNestedScrollingChildHelper.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        if (i12 > 0) {
            float f11 = this.mTotalUnconsumed;
            if (f11 > 0.0f) {
                float f12 = (float) i12;
                if (f12 > f11) {
                    iArr[1] = (int) f11;
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f11 - f12;
                    iArr[1] = i12;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i12 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i12 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i11 - iArr[0], i12 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i11);
        startNestedScroll(i11 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return isEnabled() && !this.mReturningToStart && !this.mRefreshing && (i11 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        float f11 = this.mTotalUnconsumed;
        if (f11 > 0.0f) {
            finishSpinner(f11);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean startNestedScroll(int i11) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i11);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, i15, this.mNestedScrollingV2ConsumedCompat);
    }

    private void setRefreshing(boolean z11, boolean z12) {
        if (this.mRefreshing != z11) {
            this.mNotify = z12;
            ensureTarget();
            this.mRefreshing = z11;
            if (z11) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.mNestedScrollingV2ConsumedCompat);
    }
}
