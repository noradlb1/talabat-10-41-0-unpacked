package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j11, int i11, float f11, float f12) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j11, i11, f11, f12, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    @UiThread
    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = (float) 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    public boolean endFakeDrag() {
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.mViewPager.snapToPage();
        return true;
    }

    @UiThread
    public boolean fakeDragBy(float f11) {
        boolean z11;
        int i11;
        float f12;
        int i12 = 0;
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        float f13 = this.mRequestedDragDistance - f11;
        this.mRequestedDragDistance = f13;
        int round = Math.round(f13 - ((float) this.mActualDraggedDistance));
        this.mActualDraggedDistance += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = round;
        } else {
            i11 = 0;
        }
        if (!z11) {
            i12 = round;
        }
        float f14 = 0.0f;
        if (z11) {
            f12 = this.mRequestedDragDistance;
        } else {
            f12 = 0.0f;
        }
        if (!z11) {
            f14 = this.mRequestedDragDistance;
        }
        this.mRecyclerView.scrollBy(i11, i12);
        addFakeMotionEvent(uptimeMillis, 2, f12, f14);
        return true;
    }

    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}
