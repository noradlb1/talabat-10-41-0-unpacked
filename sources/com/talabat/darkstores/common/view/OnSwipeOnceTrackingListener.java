package com.talabat.darkstores.common.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/common/view/OnSwipeOnceTrackingListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onSwiped", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "lastVisiblePosition", "", "(Lkotlin/jvm/functions/Function1;)V", "swipeTracked", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnSwipeOnceTrackingListener extends RecyclerView.OnScrollListener {
    @NotNull
    private final Function1<Integer, Unit> onSwiped;
    private boolean swipeTracked;

    public OnSwipeOnceTrackingListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onSwiped");
        this.onSwiped = function1;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        LinearLayoutManager linearLayoutManager;
        int i12;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (!this.swipeTracked && i11 == 0) {
            this.swipeTracked = true;
            Function1<Integer, Unit> function1 = this.onSwiped;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null) {
                i12 = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            } else {
                i12 = 0;
            }
            function1.invoke(Integer.valueOf(i12));
        }
    }
}
