package com.talabat.designhelpers;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class GravitySnapHelper extends LinearSnapHelper {

    /* renamed from: a  reason: collision with root package name */
    public SnapListener f58249a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58250b;
    private int mGravity;
    private OrientationHelper mHorizontalHelper;
    private boolean mIsRtlHorizontal;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 2) {
                GravitySnapHelper.this.f58250b = false;
            }
            if (i11 == 0) {
                GravitySnapHelper gravitySnapHelper = GravitySnapHelper.this;
                if (gravitySnapHelper.f58250b && gravitySnapHelper.f58249a != null) {
                    int a11 = gravitySnapHelper.a(recyclerView);
                    if (a11 != -1) {
                        GravitySnapHelper.this.f58249a.onSnap(a11);
                    }
                    GravitySnapHelper.this.f58250b = false;
                }
            }
        }
    };
    private boolean mSnapLastItemEnabled;
    private OrientationHelper mVerticalHelper;

    public interface SnapListener {
        void onSnap(int i11);
    }

    public GravitySnapHelper(int i11, boolean z11, SnapListener snapListener) {
        if (i11 == 8388611 || i11 == 8388613 || i11 == 80 || i11 == 48) {
            this.f58249a = snapListener;
            this.mGravity = i11;
            this.mSnapLastItemEnabled = z11;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
    }

    private int distanceToEnd(View view, OrientationHelper orientationHelper, boolean z11) {
        if (!this.mIsRtlHorizontal || z11) {
            return orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding();
        }
        return distanceToStart(view, orientationHelper, true);
    }

    private int distanceToStart(View view, OrientationHelper orientationHelper, boolean z11) {
        if (!this.mIsRtlHorizontal || z11) {
            return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
        }
        return distanceToEnd(view, orientationHelper, true);
    }

    private OrientationHelper fetchHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    private OrientationHelper fetchVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private View findEndView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findLastVisibleItemPosition;
        int i11;
        float f11;
        boolean z11;
        if (!(layoutManager instanceof LinearLayoutManager) || (findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        if (this.mIsRtlHorizontal) {
            f11 = (float) orientationHelper.getDecoratedEnd(findViewByPosition);
            i11 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f11 = (float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition));
            i11 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f12 = f11 / ((float) i11);
        if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (f12 > 0.5f && !z11) {
            return findViewByPosition;
        }
        if (this.mSnapLastItemEnabled && z11) {
            return findViewByPosition;
        }
        if (z11) {
            return null;
        }
        return layoutManager.findViewByPosition(findLastVisibleItemPosition - 1);
    }

    private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findFirstVisibleItemPosition;
        int i11;
        float f11;
        boolean z11;
        if (!(layoutManager instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (this.mIsRtlHorizontal) {
            f11 = (float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition));
            i11 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f11 = (float) orientationHelper.getDecoratedEnd(findViewByPosition);
            i11 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f12 = f11 / ((float) i11);
        if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (f12 > 0.5f && !z11) {
            return findViewByPosition;
        }
        if (this.mSnapLastItemEnabled && z11) {
            return findViewByPosition;
        }
        if (z11) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    public int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        int i11 = this.mGravity;
        if (i11 == 8388611 || i11 == 48) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (i11 == 8388613 || i11 == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            int i11 = this.mGravity;
            if (i11 == 8388611 || i11 == 8388613) {
                this.mIsRtlHorizontal = recyclerView.getContext().getResources().getBoolean(R.bool.is_rtl);
            }
            if (this.f58249a != null) {
                recyclerView.addOnScrollListener(this.mScrollListener);
            }
        }
        super.attachToRecyclerView(recyclerView);
    }

    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (!layoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.mGravity == 8388611) {
            iArr[0] = distanceToStart(view, fetchHorizontalHelper(layoutManager), false);
        } else {
            iArr[0] = distanceToEnd(view, fetchHorizontalHelper(layoutManager), false);
        }
        if (!layoutManager.canScrollVertically()) {
            iArr[1] = 0;
        } else if (this.mGravity == 48) {
            iArr[1] = distanceToStart(view, fetchVerticalHelper(layoutManager), false);
        } else {
            iArr[1] = distanceToEnd(view, fetchVerticalHelper(layoutManager), false);
        }
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto L_0x003d
            int r0 = r2.mGravity
            r1 = 48
            if (r0 == r1) goto L_0x0034
            r1 = 80
            if (r0 == r1) goto L_0x002b
            r1 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L_0x0022
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L_0x0019
            goto L_0x003d
        L_0x0019:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.fetchHorizontalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L_0x003e
        L_0x0022:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.fetchHorizontalHelper(r3)
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L_0x003e
        L_0x002b:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.fetchVerticalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L_0x003e
        L_0x0034:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.fetchVerticalHelper(r3)
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            if (r3 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            r2.f58250b = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.designhelpers.GravitySnapHelper.findSnapView(androidx.recyclerview.widget.RecyclerView$LayoutManager):android.view.View");
    }
}
