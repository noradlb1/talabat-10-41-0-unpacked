package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    };
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable = new Runnable() {
        public void run() {
            ViewDragHelper.this.a(0);
        }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i11, int i12) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i11, int i12) {
            return 0;
        }

        public int getOrderedChildIndex(int i11) {
            return i11;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i11, int i12) {
        }

        public boolean onEdgeLock(int i11) {
            return false;
        }

        public void onEdgeTouched(int i11, int i12) {
        }

        public void onViewCaptured(@NonNull View view, int i11) {
        }

        public void onViewDragStateChanged(int i11) {
        }

        public void onViewPositionChanged(@NonNull View view, int i11, int i12, @Px int i13, @Px int i14) {
        }

        public void onViewReleased(@NonNull View view, float f11, float f12) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i11);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i11 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mDefaultEdgeSize = i11;
            this.mEdgeSize = i11;
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean checkNewEdgeDrag(float f11, float f12, int i11, int i12) {
        float abs = Math.abs(f11);
        float abs2 = Math.abs(f12);
        if ((this.mInitialEdgesTouched[i11] & i12) != i12 || (this.mTrackingEdges & i12) == 0 || (this.mEdgeDragsLocked[i11] & i12) == i12 || (this.mEdgeDragsInProgress[i11] & i12) == i12) {
            return false;
        }
        int i13 = this.mTouchSlop;
        if (abs <= ((float) i13) && abs2 <= ((float) i13)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i12)) {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i11] = iArr[i11] | i12;
            return false;
        } else if ((this.mEdgeDragsInProgress[i11] & i12) != 0 || abs <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkTouchSlop(View view, float f11, float f12) {
        if (view == null) {
            return false;
        }
        boolean z11 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z12 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (z11 && z12) {
            int i11 = this.mTouchSlop;
            if ((f11 * f11) + (f12 * f12) > ((float) (i11 * i11))) {
                return true;
            }
            return false;
        } else if (z11) {
            if (Math.abs(f11) > ((float) this.mTouchSlop)) {
                return true;
            }
            return false;
        } else if (!z12 || Math.abs(f12) <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private int clampMag(int i11, int i12, int i13) {
        int abs = Math.abs(i11);
        if (abs < i12) {
            return 0;
        }
        if (abs > i13) {
            return i11 > 0 ? i13 : -i13;
        }
        return i11;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private int computeAxisDuration(int i11, int i12, int i13) {
        int i14;
        if (i11 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f11 = (float) (width / 2);
        float distanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i11)) / ((float) width))) * f11);
        int abs = Math.abs(i12);
        if (abs > 0) {
            i14 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i14 = (int) (((((float) Math.abs(i11)) / ((float) i13)) + 1.0f) * 256.0f);
        }
        return Math.min(i14, 600);
    }

    private int computeSettleDuration(View view, int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float f13;
        float f14;
        int clampMag = clampMag(i13, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i14, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i11);
        int abs2 = Math.abs(i12);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i15 = abs3 + abs4;
        int i16 = abs + abs2;
        if (clampMag != 0) {
            f12 = (float) abs3;
            f11 = (float) i15;
        } else {
            f12 = (float) abs;
            f11 = (float) i16;
        }
        float f15 = f12 / f11;
        if (clampMag2 != 0) {
            f14 = (float) abs4;
            f13 = (float) i15;
        } else {
            f14 = (float) abs2;
            f13 = (float) i16;
        }
        float f16 = f14 / f13;
        return (int) ((((float) computeAxisDuration(i11, clampMag, this.mCallback.getViewHorizontalDragRange(view))) * f15) + (((float) computeAxisDuration(i12, clampMag2, this.mCallback.getViewVerticalDragRange(view))) * f16));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f11, float f12) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f11, f12);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            a(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f11) {
        return (float) Math.sin((double) ((f11 - 0.5f) * 0.47123894f));
    }

    private void dragTo(int i11, int i12, int i13, int i14) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i13 != 0) {
            i11 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i11, i13);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i11 - left);
        }
        int i15 = i11;
        if (i14 != 0) {
            i12 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i12, i14);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i12 - top);
        }
        int i16 = i12;
        if (i13 != 0 || i14 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i15, i16, i15 - left, i16 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i11) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i11) {
            int i12 = i11 + 1;
            float[] fArr2 = new float[i12];
            float[] fArr3 = new float[i12];
            float[] fArr4 = new float[i12];
            float[] fArr5 = new float[i12];
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int[] iArr3 = new int[i12];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i11, int i12, int i13, int i14) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i15 = i11 - left;
        int i16 = i12 - top;
        if (i15 == 0 && i16 == 0) {
            this.mScroller.abortAnimation();
            a(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i15, i16, computeSettleDuration(this.mCapturedView, i15, i16, i13, i14));
        a(2);
        return true;
    }

    private int getEdgesTouched(int i11, int i12) {
        int i13;
        if (i11 < this.mParentView.getLeft() + this.mEdgeSize) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        if (i12 < this.mParentView.getTop() + this.mEdgeSize) {
            i13 |= 4;
        }
        if (i11 > this.mParentView.getRight() - this.mEdgeSize) {
            i13 |= 2;
        }
        if (i12 > this.mParentView.getBottom() - this.mEdgeSize) {
            return i13 | 8;
        }
        return i13;
    }

    private boolean isValidPointerForActionMove(int i11) {
        if (isPointerDown(i11)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i11 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f11, float f12, int i11) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f11, f12, i11, 1);
        if (checkNewEdgeDrag(f12, f11, i11, 4)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f11, f12, i11, 2)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f12, f11, i11, 8)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i11] = iArr[i11] | checkNewEdgeDrag;
            this.mCallback.onEdgeDragStarted(checkNewEdgeDrag ? 1 : 0, i11);
        }
    }

    private void saveInitialMotion(float f11, float f12, int i11) {
        ensureMotionHistorySizeForId(i11);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i11] = f11;
        fArr[i11] = f11;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i11] = f12;
        fArr2[i11] = f12;
        this.mInitialEdgesTouched[i11] = getEdgesTouched((int) f11, (int) f12);
        this.mPointersDown |= 1 << i11;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i11 = 0; i11 < pointerCount; i11++) {
            int pointerId = motionEvent.getPointerId(i11);
            if (isValidPointerForActionMove(pointerId)) {
                float x11 = motionEvent.getX(i11);
                float y11 = motionEvent.getY(i11);
                this.mLastMotionX[pointerId] = x11;
                this.mLastMotionY[pointerId] = y11;
            }
        }
    }

    public void a(int i11) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i11) {
            this.mDragState = i11;
            this.mCallback.onViewDragStateChanged(i11);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        a(0);
    }

    public boolean b(View view, int i11) {
        if (view == this.mCapturedView && this.mActivePointerId == i11) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i11)) {
            return false;
        }
        this.mActivePointerId = i11;
        captureChildView(view, i11);
        return true;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i11) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i11;
            this.mCallback.onViewCaptured(view, i11);
            a(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z11) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z11) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    a(0);
                }
            }
        }
        if (this.mDragState == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public View findTopChildUnder(int i11, int i12) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && i12 >= childAt.getTop() && i12 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i11, int i12, int i13, int i14) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i11, i13, i12, i14);
            a(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i11, int i12) {
        return isViewUnder(this.mCapturedView, i11, i12);
    }

    public boolean isEdgeTouched(int i11) {
        int length = this.mInitialEdgesTouched.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (isEdgeTouched(i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i11) {
        return ((1 << i11) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i11, int i12) {
        if (view != null && i11 >= view.getLeft() && i11 < view.getRight() && i12 >= view.getTop() && i12 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i11;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i12 = 0;
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x11, (int) y11);
            saveInitialMotion(x11, y11, pointerId);
            b(findTopChildUnder, pointerId);
            int i13 = this.mInitialEdgesTouched[pointerId];
            int i14 = this.mTrackingEdges;
            if ((i13 & i14) != 0) {
                this.mCallback.onEdgeTouched(i13 & i14, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x12 = motionEvent.getX(actionIndex);
                float y12 = motionEvent.getY(actionIndex);
                saveInitialMotion(x12, y12, pointerId2);
                if (this.mDragState == 0) {
                    b(findTopChildUnder((int) x12, (int) y12), pointerId2);
                    int i15 = this.mInitialEdgesTouched[pointerId2];
                    int i16 = this.mTrackingEdges;
                    if ((i15 & i16) != 0) {
                        this.mCallback.onEdgeTouched(i15 & i16, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x12, (int) y12)) {
                    b(this.mCapturedView, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId3 == this.mActivePointerId) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i12 >= pointerCount) {
                            i11 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i12);
                        if (pointerId4 != this.mActivePointerId) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i12), (int) motionEvent.getY(i12));
                            View view = this.mCapturedView;
                            if (findTopChildUnder2 == view && b(view, pointerId4)) {
                                i11 = this.mActivePointerId;
                                break;
                            }
                        }
                        i12++;
                    }
                    if (i11 == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId3);
            }
        } else if (this.mDragState != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i12 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i12);
                if (isValidPointerForActionMove(pointerId5)) {
                    float x13 = motionEvent.getX(i12);
                    float y13 = motionEvent.getY(i12);
                    float f11 = x13 - this.mInitialMotionX[pointerId5];
                    float f12 = y13 - this.mInitialMotionY[pointerId5];
                    reportNewEdgeDrags(f11, f12, pointerId5);
                    if (this.mDragState != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x13, (int) y13);
                        if (checkTouchSlop(findTopChildUnder3, f11, f12) && b(findTopChildUnder3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i12++;
            }
            saveLastMotion(motionEvent);
        } else if (isValidPointerForActionMove(this.mActivePointerId)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            float x14 = motionEvent.getX(findPointerIndex);
            float y14 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.mLastMotionX;
            int i17 = this.mActivePointerId;
            int i18 = (int) (x14 - fArr[i17]);
            int i19 = (int) (y14 - this.mLastMotionY[i17]);
            dragTo(this.mCapturedView.getLeft() + i18, this.mCapturedView.getTop() + i19, i18, i19);
            saveLastMotion(motionEvent);
        }
    }

    public void setEdgeSize(@Px @IntRange(from = 0) int i11) {
        this.mEdgeSize = i11;
    }

    public void setEdgeTrackingEnabled(int i11) {
        this.mTrackingEdges = i11;
    }

    public void setMinVelocity(float f11) {
        this.mMinVelocity = f11;
    }

    public boolean settleCapturedViewAt(int i11, int i12) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i11, i12, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.cancel()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.mVelocityTracker = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.clearMotionHistory(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.saveInitialMotion(r7, r1, r2)
            int r3 = r0.mDragState
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.mInitialEdgesTouched
            r1 = r1[r2]
            int r3 = r0.mTrackingEdges
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.findTopChildUnder(r3, r1)
            android.view.View r3 = r0.mCapturedView
            if (r1 != r3) goto L_0x0031
            r0.b(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.mInitialMotionX
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.mInitialMotionY
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.isValidPointerForActionMove(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.mInitialMotionX
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.mInitialMotionY
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.findTopChildUnder(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.checkTouchSlop(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.mCallback
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.mCallback
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.reportNewEdgeDrags(r9, r10, r4)
            int r5 = r0.mDragState
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.b(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.saveLastMotion(r17)
            goto L_0x0031
        L_0x00ff:
            r16.cancel()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.saveInitialMotion(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.findTopChildUnder(r2, r3)
            android.view.View r3 = r0.mCapturedView
            if (r2 != r3) goto L_0x0125
            int r3 = r0.mDragState
            if (r3 != r4) goto L_0x0125
            r0.b(r2, r1)
        L_0x0125:
            int[] r2 = r0.mInitialEdgesTouched
            r2 = r2[r1]
            int r3 = r0.mTrackingEdges
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r1 = r0.mDragState
            if (r1 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i11, int i12) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i11, i12, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    private float clampMag(float f11, float f12, float f13) {
        float abs = Math.abs(f11);
        if (abs < f12) {
            return 0.0f;
        }
        if (abs > f13) {
            return f11 > 0.0f ? f13 : -f13;
        }
        return f11;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f11, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f11));
        return create;
    }

    public boolean isEdgeTouched(int i11, int i12) {
        return isPointerDown(i12) && (i11 & this.mInitialEdgesTouched[i12]) != 0;
    }

    public boolean checkTouchSlop(int i11) {
        int length = this.mInitialMotionX.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (checkTouchSlop(i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i11, int i12) {
        if (!isPointerDown(i12)) {
            return false;
        }
        boolean z11 = (i11 & 1) == 1;
        boolean z12 = (i11 & 2) == 2;
        float f11 = this.mLastMotionX[i12] - this.mInitialMotionX[i12];
        float f12 = this.mLastMotionY[i12] - this.mInitialMotionY[i12];
        if (z11 && z12) {
            int i13 = this.mTouchSlop;
            if ((f11 * f11) + (f12 * f12) > ((float) (i13 * i13))) {
                return true;
            }
            return false;
        } else if (z11) {
            if (Math.abs(f11) > ((float) this.mTouchSlop)) {
                return true;
            }
            return false;
        } else if (!z12 || Math.abs(f12) <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private void clearMotionHistory(int i11) {
        if (this.mInitialMotionX != null && isPointerDown(i11)) {
            this.mInitialMotionX[i11] = 0.0f;
            this.mInitialMotionY[i11] = 0.0f;
            this.mLastMotionX[i11] = 0.0f;
            this.mLastMotionY[i11] = 0.0f;
            this.mInitialEdgesTouched[i11] = 0;
            this.mEdgeDragsInProgress[i11] = 0;
            this.mEdgeDragsLocked[i11] = 0;
            this.mPointersDown = (~(1 << i11)) & this.mPointersDown;
        }
    }
}
