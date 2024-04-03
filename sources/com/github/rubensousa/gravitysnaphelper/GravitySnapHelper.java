package com.github.rubensousa.gravitysnaphelper;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

public class GravitySnapHelper extends LinearSnapHelper {
    public static final int FLING_DISTANCE_DISABLE = -1;
    public static final float FLING_SIZE_FRACTION_DISABLE = -1.0f;
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isRtl;
    private boolean isScrolling;
    private SnapListener listener;
    private int maxFlingDistance;
    private float maxFlingSizeFraction;
    private int nextSnapPosition;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    private RecyclerView.OnScrollListener scrollListener;
    /* access modifiers changed from: private */
    public float scrollMsPerInch;
    private boolean snapLastItem;
    private boolean snapToPadding;
    private OrientationHelper verticalHelper;

    public interface SnapListener {
        void onSnap(int i11);
    }

    public GravitySnapHelper(int i11) {
        this(i11, false, (SnapListener) null);
    }

    private void dispatchSnapChangeWhenPositionIsUnknown() {
        View findSnapView;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager != null && (findSnapView = findSnapView(layoutManager, false)) != null && (childAdapterPosition = this.recyclerView.getChildAdapterPosition(findSnapView)) != -1) {
            this.listener.onSnap(childAdapterPosition);
        }
    }

    @Nullable
    private View findView(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull OrientationHelper orientationHelper, int i11, boolean z11) {
        int i12;
        boolean z12;
        int i13;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z11 && isAtEdgeOfList(linearLayoutManager) && !this.snapLastItem) {
                return null;
            }
            if (layoutManager.getClipToPadding()) {
                i12 = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                i12 = orientationHelper.getEnd() / 2;
            }
            boolean z13 = true;
            if ((i11 != 8388611 || this.isRtl) && (i11 != 8388613 || !this.isRtl)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if ((i11 != 8388611 || !this.isRtl) && (i11 != 8388613 || this.isRtl)) {
                z13 = false;
            }
            int i14 = Integer.MAX_VALUE;
            for (int i15 = 0; i15 < linearLayoutManager.getChildCount(); i15++) {
                View childAt = linearLayoutManager.getChildAt(i15);
                if (z12) {
                    if (!this.snapToPadding) {
                        i13 = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        i13 = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (!z13) {
                    i13 = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - i12);
                } else if (!this.snapToPadding) {
                    i13 = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                } else {
                    i13 = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                }
                if (i13 < i14) {
                    view = childAt;
                    i14 = i13;
                }
            }
        }
        return view;
    }

    private int getDistanceToEnd(View view, @NonNull OrientationHelper orientationHelper) {
        int i11;
        int i12;
        if (!this.snapToPadding) {
            int decoratedEnd = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd < orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                return decoratedEnd - orientationHelper.getEndAfterPadding();
            }
            i12 = orientationHelper.getDecoratedEnd(view);
            i11 = orientationHelper.getEnd();
        } else {
            i12 = orientationHelper.getDecoratedEnd(view);
            i11 = orientationHelper.getEndAfterPadding();
        }
        return i12 - i11;
    }

    private int getDistanceToStart(View view, @NonNull OrientationHelper orientationHelper) {
        int i11;
        int i12;
        if (!this.snapToPadding) {
            i12 = orientationHelper.getDecoratedStart(view);
            if (i12 < orientationHelper.getStartAfterPadding() / 2) {
                return i12;
            }
            i11 = orientationHelper.getStartAfterPadding();
        } else {
            i12 = orientationHelper.getDecoratedStart(view);
            i11 = orientationHelper.getStartAfterPadding();
        }
        return i12 - i11;
    }

    private int getFlingDistance() {
        float width;
        float f11;
        if (this.maxFlingSizeFraction != -1.0f) {
            if (this.verticalHelper != null) {
                width = (float) this.recyclerView.getHeight();
                f11 = this.maxFlingSizeFraction;
            } else if (this.horizontalHelper == null) {
                return Integer.MAX_VALUE;
            } else {
                width = (float) this.recyclerView.getWidth();
                f11 = this.maxFlingSizeFraction;
            }
            return (int) (width * f11);
        }
        int i11 = this.maxFlingDistance;
        if (i11 != -1) {
            return i11;
        }
        return Integer.MAX_VALUE;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.horizontalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.verticalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    private boolean isAtEdgeOfList(LinearLayoutManager linearLayoutManager) {
        if ((linearLayoutManager.getReverseLayout() || this.gravity != 8388611) && ((!linearLayoutManager.getReverseLayout() || this.gravity != 8388613) && ((linearLayoutManager.getReverseLayout() || this.gravity != 48) && (!linearLayoutManager.getReverseLayout() || this.gravity != 80)))) {
            if (this.gravity == 17) {
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    return true;
                }
                return false;
            } else if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void onScrollStateChanged(int i11) {
        boolean z11;
        SnapListener snapListener;
        if (i11 == 0 && (snapListener = this.listener) != null && this.isScrolling) {
            int i12 = this.nextSnapPosition;
            if (i12 != -1) {
                snapListener.onSnap(i12);
            } else {
                dispatchSnapChangeWhenPositionIsUnknown();
            }
        }
        if (i11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isScrolling = z11;
    }

    private boolean scrollTo(int i11, boolean z11) {
        if (this.recyclerView.getLayoutManager() != null) {
            if (z11) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.recyclerView.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i11);
                    this.recyclerView.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(i11);
                if (findViewHolderForAdapterPosition != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.recyclerView.getLayoutManager(), findViewHolderForAdapterPosition.itemView);
                    this.recyclerView.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView2) throws IllegalStateException {
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.removeOnScrollListener(this.scrollListener);
        }
        if (recyclerView2 != null) {
            recyclerView2.setOnFlingListener((RecyclerView.OnFlingListener) null);
            int i11 = this.gravity;
            if (i11 == 8388611 || i11 == 8388613) {
                boolean z11 = true;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                    z11 = false;
                }
                this.isRtl = z11;
            }
            recyclerView2.addOnScrollListener(this.scrollListener);
            this.recyclerView = recyclerView2;
        } else {
            this.recyclerView = null;
        }
        super.attachToRecyclerView(recyclerView2);
    }

    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (this.gravity == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z11 = this.isRtl;
            if ((!z11 || this.gravity != 8388613) && (z11 || this.gravity != 8388611)) {
                iArr[0] = getDistanceToEnd(view, getHorizontalHelper(linearLayoutManager));
            } else {
                iArr[0] = getDistanceToStart(view, getHorizontalHelper(linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.gravity == 48) {
                iArr[1] = getDistanceToStart(view, getVerticalHelper(linearLayoutManager));
            } else {
                iArr[1] = getDistanceToEnd(view, getVerticalHelper(linearLayoutManager));
            }
        }
        return iArr;
    }

    @NonNull
    public int[] calculateScrollDistance(int i11, int i12) {
        if (this.recyclerView == null || ((this.verticalHelper == null && this.horizontalHelper == null) || (this.maxFlingDistance == -1 && this.maxFlingSizeFraction == -1.0f))) {
            return super.calculateScrollDistance(i11, i12);
        }
        Scroller scroller = new Scroller(this.recyclerView.getContext(), new DecelerateInterpolator());
        int flingDistance = getFlingDistance();
        int i13 = -flingDistance;
        scroller.fling(0, 0, i11, i12, i13, flingDistance, i13, flingDistance);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView2;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView2 = this.recyclerView) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView2.getContext()) {
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return GravitySnapHelper.this.scrollMsPerInch / ((float) displayMetrics.densityDpi);
            }

            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (GravitySnapHelper.this.recyclerView != null && GravitySnapHelper.this.recyclerView.getLayoutManager() != null) {
                    GravitySnapHelper gravitySnapHelper = GravitySnapHelper.this;
                    int[] calculateDistanceToFinalSnap = gravitySnapHelper.calculateDistanceToFinalSnap(gravitySnapHelper.recyclerView.getLayoutManager(), view);
                    int i11 = calculateDistanceToFinalSnap[0];
                    int i12 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i11), Math.abs(i12)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i11, i12, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }
        };
    }

    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager) {
        return findSnapView(layoutManager, true);
    }

    public int getCurrentSnappedPosition() {
        View findSnapView;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null || recyclerView2.getLayoutManager() == null || (findSnapView = findSnapView(this.recyclerView.getLayoutManager())) == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findSnapView);
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getMaxFlingDistance() {
        return this.maxFlingDistance;
    }

    public float getMaxFlingSizeFraction() {
        return this.maxFlingSizeFraction;
    }

    public float getScrollMsPerInch() {
        return this.scrollMsPerInch;
    }

    public boolean getSnapLastItem() {
        return this.snapLastItem;
    }

    public boolean getSnapToPadding() {
        return this.snapToPadding;
    }

    public boolean scrollToPosition(int i11) {
        if (i11 == -1) {
            return false;
        }
        return scrollTo(i11, false);
    }

    public void setGravity(int i11, Boolean bool) {
        if (this.gravity != i11) {
            this.gravity = i11;
            updateSnap(bool, Boolean.FALSE);
        }
    }

    public void setMaxFlingDistance(@Px int i11) {
        this.maxFlingDistance = i11;
        this.maxFlingSizeFraction = -1.0f;
    }

    public void setMaxFlingSizeFraction(float f11) {
        this.maxFlingDistance = -1;
        this.maxFlingSizeFraction = f11;
    }

    public void setScrollMsPerInch(float f11) {
        this.scrollMsPerInch = f11;
    }

    public void setSnapLastItem(boolean z11) {
        this.snapLastItem = z11;
    }

    public void setSnapListener(@Nullable SnapListener snapListener) {
        this.listener = snapListener;
    }

    public void setSnapToPadding(boolean z11) {
        this.snapToPadding = z11;
    }

    public boolean smoothScrollToPosition(int i11) {
        if (i11 == -1) {
            return false;
        }
        return scrollTo(i11, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r2.recyclerView.getLayoutManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSnap(java.lang.Boolean r3, java.lang.Boolean r4) {
        /*
            r2 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r2.recyclerView
            if (r0 == 0) goto L_0x003a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 != 0) goto L_0x000b
            goto L_0x003a
        L_0x000b:
            androidx.recyclerview.widget.RecyclerView r0 = r2.recyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r4 = r4.booleanValue()
            android.view.View r4 = r2.findSnapView(r0, r4)
            if (r4 == 0) goto L_0x003a
            int[] r4 = r2.calculateDistanceToFinalSnap(r0, r4)
            boolean r3 = r3.booleanValue()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0031
            androidx.recyclerview.widget.RecyclerView r3 = r2.recyclerView
            r1 = r4[r1]
            r4 = r4[r0]
            r3.smoothScrollBy(r1, r4)
            goto L_0x003a
        L_0x0031:
            androidx.recyclerview.widget.RecyclerView r3 = r2.recyclerView
            r1 = r4[r1]
            r4 = r4[r0]
            r3.scrollBy(r1, r4)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.rubensousa.gravitysnaphelper.GravitySnapHelper.updateSnap(java.lang.Boolean, java.lang.Boolean):void");
    }

    public GravitySnapHelper(int i11, @NonNull SnapListener snapListener) {
        this(i11, false, snapListener);
    }

    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager, boolean z11) {
        View view;
        int i11 = this.gravity;
        if (i11 != 17) {
            if (i11 == 48) {
                view = findView(layoutManager, getVerticalHelper(layoutManager), GravityCompat.START, z11);
            } else if (i11 == 80) {
                view = findView(layoutManager, getVerticalHelper(layoutManager), GravityCompat.END, z11);
            } else if (i11 == 8388611) {
                view = findView(layoutManager, getHorizontalHelper(layoutManager), GravityCompat.START, z11);
            } else if (i11 != 8388613) {
                view = null;
            } else {
                view = findView(layoutManager, getHorizontalHelper(layoutManager), GravityCompat.END, z11);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            view = findView(layoutManager, getHorizontalHelper(layoutManager), 17, z11);
        } else {
            view = findView(layoutManager, getVerticalHelper(layoutManager), 17, z11);
        }
        if (view != null) {
            this.nextSnapPosition = this.recyclerView.getChildAdapterPosition(view);
        } else {
            this.nextSnapPosition = -1;
        }
        return view;
    }

    public GravitySnapHelper(int i11, boolean z11) {
        this(i11, z11, (SnapListener) null);
    }

    public GravitySnapHelper(int i11, boolean z11, @Nullable SnapListener snapListener) {
        this.isScrolling = false;
        this.snapToPadding = false;
        this.scrollMsPerInch = 100.0f;
        this.maxFlingDistance = -1;
        this.maxFlingSizeFraction = -1.0f;
        this.scrollListener = new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i11) {
                super.onScrollStateChanged(recyclerView, i11);
                GravitySnapHelper.this.onScrollStateChanged(i11);
            }
        };
        if (i11 == 8388611 || i11 == 8388613 || i11 == 80 || i11 == 48 || i11 == 17) {
            this.snapLastItem = z11;
            this.gravity = i11;
            this.listener = snapListener;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }

    public void setGravity(int i11) {
        setGravity(i11, Boolean.TRUE);
    }
}
