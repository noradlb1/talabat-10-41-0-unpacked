package com.talabat.designhelpers.Grocery;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.designhelpers.Grocery.GravitySnapHelper;

class GravityDelegate {
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isRtlHorizontal;
    /* access modifiers changed from: private */
    public GravitySnapHelper.SnapListener listener;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 2) {
                GravityDelegate.this.snapping = false;
            }
            if (i11 == 0 && GravityDelegate.this.snapping && GravityDelegate.this.listener != null) {
                int d11 = GravityDelegate.this.d(recyclerView);
                if (d11 != -1) {
                    GravityDelegate.this.listener.onSnap(d11);
                }
                GravityDelegate.this.snapping = false;
            }
        }
    };
    private boolean snapLastItem;
    /* access modifiers changed from: private */
    public boolean snapping;
    private OrientationHelper verticalHelper;

    public GravityDelegate(int i11, boolean z11, GravitySnapHelper.SnapListener snapListener) {
        if (i11 == 8388611 || i11 == 8388613 || i11 == 80 || i11 == 48) {
            this.snapLastItem = z11;
            this.gravity = i11;
            this.listener = snapListener;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
    }

    private int distanceToEnd(View view, OrientationHelper orientationHelper, boolean z11) {
        if (!this.isRtlHorizontal || z11) {
            return orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding();
        }
        return distanceToStart(view, orientationHelper, true);
    }

    private int distanceToStart(View view, OrientationHelper orientationHelper, boolean z11) {
        if (!this.isRtlHorizontal || z11) {
            return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
        }
        return distanceToEnd(view, orientationHelper, true);
    }

    private View findEndView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i11;
        int i12;
        float f11;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        boolean z11 = true;
        if (layoutManager instanceof GridLayoutManager) {
            i11 = (((GridLayoutManager) layoutManager).getSpanCount() - 1) + 1;
        } else {
            i11 = 1;
        }
        if (findLastVisibleItemPosition == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        if (this.isRtlHorizontal) {
            f11 = (float) orientationHelper.getDecoratedEnd(findViewByPosition);
            i12 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f11 = (float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition));
            i12 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f12 = f11 / ((float) i12);
        if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() != 0) {
            z11 = false;
        }
        if (f12 > 0.5f && !z11) {
            return findViewByPosition;
        }
        if (this.snapLastItem && z11) {
            return findViewByPosition;
        }
        if (z11) {
            return null;
        }
        return layoutManager.findViewByPosition(findLastVisibleItemPosition - i11);
    }

    private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i11;
        int i12;
        float f11;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        boolean z11 = true;
        if (layoutManager instanceof GridLayoutManager) {
            i11 = (((GridLayoutManager) layoutManager).getSpanCount() - 1) + 1;
        } else {
            i11 = 1;
        }
        if (findFirstVisibleItemPosition == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (this.isRtlHorizontal) {
            f11 = (float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition));
            i12 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f11 = (float) orientationHelper.getDecoratedEnd(findViewByPosition);
            i12 = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f12 = f11 / ((float) i12);
        if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() != layoutManager.getItemCount() - 1) {
            z11 = false;
        }
        if (f12 > 0.5f && !z11) {
            return findViewByPosition;
        }
        if (this.snapLastItem && z11) {
            return findViewByPosition;
        }
        if (z11) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + i11);
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.horizontalHelper == null) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.verticalHelper == null) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setOnFlingListener((RecyclerView.OnFlingListener) null);
            int i11 = this.gravity;
            if (i11 == 8388611 || i11 == 8388613) {
                boolean z11 = true;
                if (recyclerView.getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
                    z11 = false;
                }
                this.isRtlHorizontal = z11;
            }
            if (this.listener != null) {
                recyclerView.addOnScrollListener(this.mScrollListener);
            }
        }
    }

    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (!layoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.gravity == 8388611) {
            iArr[0] = distanceToStart(view, getHorizontalHelper(layoutManager), false);
        } else {
            iArr[0] = distanceToEnd(view, getHorizontalHelper(layoutManager), false);
        }
        if (!layoutManager.canScrollVertically()) {
            iArr[1] = 0;
        } else if (this.gravity == 48) {
            iArr[1] = distanceToStart(view, getVerticalHelper(layoutManager), false);
        } else {
            iArr[1] = distanceToEnd(view, getVerticalHelper(layoutManager), false);
        }
        return iArr;
    }

    public int d(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        int i11 = this.gravity;
        if (i11 == 8388611 || i11 == 48) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (i11 == 8388613 || i11 == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto L_0x003d
            int r0 = r2.gravity
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
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L_0x003e
        L_0x0022:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L_0x003e
        L_0x002b:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L_0x003e
        L_0x0034:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
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
            r2.snapping = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.designhelpers.Grocery.GravityDelegate.findSnapView(androidx.recyclerview.widget.RecyclerView$LayoutManager):android.view.View");
    }
}
