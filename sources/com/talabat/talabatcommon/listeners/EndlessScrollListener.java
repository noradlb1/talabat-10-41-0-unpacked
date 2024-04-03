package com.talabat.talabatcommon.listeners;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H&J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0006\u0010$\u001a\u00020\u001dJ\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/talabatcommon/listeners/EndlessScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "firstVisibleItem", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loading", "", "previousTotal", "scrollPosition", "spanArray", "", "staggeredGridLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "startPageNumber", "totalItemCount", "visibleItemCount", "visibleThreshold", "onLoadMore", "", "onScroll", "dy", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "reset", "setStartPageNumber", "restart", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String TAG = EndlessScrollListener.class.getSimpleName();
    private int currentPage;
    private int firstVisibleItem;
    @Nullable
    private GridLayoutManager gridLayoutManager;
    @Nullable
    private LinearLayoutManager linearLayoutManager;
    private boolean loading = true;
    private int previousTotal;
    private int scrollPosition;
    @Nullable
    private int[] spanArray;
    @Nullable
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private int startPageNumber;
    private int totalItemCount;
    private int visibleItemCount;
    private final int visibleThreshold = 5;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/listeners/EndlessScrollListener$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return EndlessScrollListener.TAG;
        }

        public final void setTAG(String str) {
            EndlessScrollListener.TAG = str;
        }
    }

    public EndlessScrollListener(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (layoutManager instanceof GridLayoutManager) {
            this.gridLayoutManager = (GridLayoutManager) layoutManager;
        } else if (layoutManager instanceof LinearLayoutManager) {
            this.linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) layoutManager;
            this.staggeredGridLayoutManager = staggeredGridLayoutManager2;
            Intrinsics.checkNotNull(staggeredGridLayoutManager2);
            this.spanArray = new int[staggeredGridLayoutManager2.getSpanCount()];
        } else {
            throw new IllegalArgumentException("Selected LayoutManager has not supported");
        }
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public abstract void onLoadMore(int i11, int i12);

    public abstract void onScroll(int i11, int i12, int i13);

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        this.visibleItemCount = recyclerView.getChildCount();
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 != null) {
            Intrinsics.checkNotNull(linearLayoutManager2);
            this.totalItemCount = linearLayoutManager2.getItemCount();
            LinearLayoutManager linearLayoutManager3 = this.linearLayoutManager;
            Intrinsics.checkNotNull(linearLayoutManager3);
            this.firstVisibleItem = linearLayoutManager3.findFirstVisibleItemPosition();
        } else {
            GridLayoutManager gridLayoutManager2 = this.gridLayoutManager;
            if (gridLayoutManager2 != null) {
                Intrinsics.checkNotNull(gridLayoutManager2);
                this.totalItemCount = gridLayoutManager2.getItemCount();
                GridLayoutManager gridLayoutManager3 = this.gridLayoutManager;
                Intrinsics.checkNotNull(gridLayoutManager3);
                this.firstVisibleItem = gridLayoutManager3.findFirstVisibleItemPosition();
            } else {
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.staggeredGridLayoutManager;
                if (staggeredGridLayoutManager2 != null) {
                    Intrinsics.checkNotNull(staggeredGridLayoutManager2);
                    this.totalItemCount = staggeredGridLayoutManager2.getItemCount();
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = this.staggeredGridLayoutManager;
                    Intrinsics.checkNotNull(staggeredGridLayoutManager3);
                    this.firstVisibleItem = staggeredGridLayoutManager3.findFirstVisibleItemPositions(this.spanArray)[0];
                }
            }
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        this.scrollPosition = computeVerticalScrollOffset;
        onScroll(this.firstVisibleItem, i12, computeVerticalScrollOffset);
        if (this.loading && (i13 = this.totalItemCount) > this.previousTotal) {
            this.loading = false;
            this.previousTotal = i13;
        }
        if (!this.loading) {
            int i14 = this.totalItemCount;
            if (i14 - this.visibleItemCount <= this.firstVisibleItem + this.visibleThreshold) {
                int i15 = this.currentPage + 1;
                this.currentPage = i15;
                onLoadMore(i15, i14);
                this.loading = true;
            }
        }
    }

    public final void reset() {
        this.currentPage = this.startPageNumber;
        this.previousTotal = 0;
        this.loading = true;
    }

    public final void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public final void setStartPageNumber(int i11, boolean z11) {
        this.startPageNumber = i11;
        if (z11) {
            reset();
        }
    }
}
