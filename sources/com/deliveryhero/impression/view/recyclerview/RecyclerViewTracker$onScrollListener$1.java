package com.deliveryhero.impression.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.impression.view.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecyclerViewTracker$onScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewTracker f30337a;

    public RecyclerViewTracker$onScrollListener$1(RecyclerViewTracker recyclerViewTracker) {
        this.f30337a = recyclerViewTracker;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 == 0) {
            this.f30337a.processUpdate(Tracker.ListState.SCROLL_STOPPED);
        }
    }
}
