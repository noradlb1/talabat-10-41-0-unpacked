package com.talabat.impressions;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/impressions/RecyclerViewImpressionTracker$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewImpressionTracker$onScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewImpressionTracker<T> f60986a;

    public RecyclerViewImpressionTracker$onScrollListener$1(RecyclerViewImpressionTracker<T> recyclerViewImpressionTracker) {
        this.f60986a = recyclerViewImpressionTracker;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 == 1) {
            Pair<Integer, Integer> firstAndLastViewedPosition = ImpressionTrackerKt.getFirstAndLastViewedPosition(recyclerView);
            int intValue = firstAndLastViewedPosition.component1().intValue();
            int intValue2 = firstAndLastViewedPosition.component2().intValue();
            int size = this.f60986a.viewsViewed.size();
            for (int i12 = 0; i12 < size; i12++) {
                if (i12 < intValue && i12 > intValue2) {
                    this.f60986a.clearViewViewed(i12);
                }
            }
        }
        if (i11 == 0) {
            this.f60986a.analyseView(recyclerView);
        }
    }
}
