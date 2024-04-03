package com.talabat.darkstores.feature.categories.subcategories.experiment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.FlowableSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/ProductItemsRvScrollListenerNew;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollHeadlineSubscriber", "Lio/reactivex/FlowableSubscriber;", "", "(Lio/reactivex/FlowableSubscriber;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductItemsRvScrollListenerNew extends RecyclerView.OnScrollListener {
    @NotNull
    private final FlowableSubscriber<Integer> scrollHeadlineSubscriber;

    public ProductItemsRvScrollListenerNew(@NotNull FlowableSubscriber<Integer> flowableSubscriber) {
        Intrinsics.checkNotNullParameter(flowableSubscriber, "scrollHeadlineSubscriber");
        this.scrollHeadlineSubscriber = flowableSubscriber;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        int i13;
        GridLayoutManager gridLayoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        FlowableSubscriber<Integer> flowableSubscriber = this.scrollHeadlineSubscriber;
        if (!recyclerView.canScrollVertically(1)) {
            i13 = -1;
        } else {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                gridLayoutManager = (GridLayoutManager) layoutManager;
            } else {
                gridLayoutManager = null;
            }
            if (gridLayoutManager != null) {
                i13 = Integer.valueOf(gridLayoutManager.findFirstVisibleItemPosition());
            } else {
                i13 = null;
            }
        }
        flowableSubscriber.onNext(i13);
    }
}
