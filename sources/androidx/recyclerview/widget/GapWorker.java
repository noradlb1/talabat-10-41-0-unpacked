package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() {
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z11 = task.immediate;
            if (z11 == task2.immediate) {
                int i11 = task2.viewVelocity - task.viewVelocity;
                if (i11 != 0) {
                    return i11;
                }
                int i12 = task.distanceToItem - task2.distanceToItem;
                if (i12 != 0) {
                    return i12;
                }
                return 0;
            } else if (z11) {
                return -1;
            } else {
                return 1;
            }
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        public void addPosition(int i11, int i12) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i12 >= 0) {
                int i13 = this.mCount * 2;
                int[] iArr = this.mPrefetchArray;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.mPrefetchArray = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i13 >= iArr.length) {
                    int[] iArr3 = new int[(i13 * 2)];
                    this.mPrefetchArray = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.mPrefetchArray;
                iArr4[i13] = i11;
                iArr4[i13 + 1] = i12;
                this.mCount++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void clearPrefetchPositions() {
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }

        public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z11) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z11) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i11 = this.mCount;
                if (i11 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i11;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z11;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public boolean lastPrefetchIncludedPosition(int i11) {
            if (this.mPrefetchArray != null) {
                int i12 = this.mCount * 2;
                for (int i13 = 0; i13 < i12; i13 += 2) {
                    if (this.mPrefetchArray[i13] == i11) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void setPrefetchVector(int i11, int i12) {
            this.mPrefetchDx = i11;
            this.mPrefetchDy = i12;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    private void buildTaskList() {
        Task task;
        boolean z11;
        int size = this.mRecyclerViews.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i12);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i11 += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i14);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                for (int i15 = 0; i15 < layoutPrefetchRegistryImpl.mCount * 2; i15 += 2) {
                    if (i13 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i13);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int i16 = iArr[i15 + 1];
                    if (i16 <= abs) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    task.immediate = z11;
                    task.viewVelocity = abs;
                    task.distanceToItem = i16;
                    task.view = recyclerView2;
                    task.position = iArr[i15];
                    i13++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task task, long j11) {
        long j12;
        if (task.immediate) {
            j12 = Long.MAX_VALUE;
        } else {
            j12 = j11;
        }
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, j12);
        if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid()) {
            prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j11);
        }
    }

    private void flushTasksWithDeadline(long j11) {
        int i11 = 0;
        while (i11 < this.mTasks.size()) {
            Task task = this.mTasks.get(i11);
            if (task.view != null) {
                flushTaskWithDeadline(task, j11);
                task.clear();
                i11++;
            } else {
                return;
            }
        }
    }

    public static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i11) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i12 = 0; i12 < unfilteredChildCount; i12++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i12));
            if (childViewHolderInt.mPosition == i11 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j11) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
            if (layoutPrefetchRegistryImpl.mCount != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i11 = 0; i11 < layoutPrefetchRegistryImpl.mCount * 2; i11 += 2) {
                        prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i11], j11);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i11, long j11) {
        if (isPrefetchPositionAttached(recyclerView, i11)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i11, false, j11);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (!tryGetViewHolderForPositionByDeadline.isBound() || tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                } else {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public void postFromTraversal(RecyclerView recyclerView, int i11, int i12) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i11, i12);
    }

    public void prefetch(long j11) {
        buildTaskList();
        flushTasksWithDeadline(j11);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j11 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i11);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j11 = Math.max(recyclerView.getDrawingTime(), j11);
                    }
                }
                if (j11 != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j11) + this.mFrameIntervalNs);
                    this.mPostTimeNs = 0;
                    TraceCompat.endSection();
                }
            }
        } finally {
            this.mPostTimeNs = 0;
            TraceCompat.endSection();
        }
    }
}
