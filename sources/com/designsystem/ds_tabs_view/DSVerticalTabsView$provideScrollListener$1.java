package com.designsystem.ds_tabs_view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/designsystem/ds_tabs_view/DSVerticalTabsView$provideScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSVerticalTabsView$provideScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DSVerticalTabsView f33068a;

    public DSVerticalTabsView$provideScrollListener$1(DSVerticalTabsView dSVerticalTabsView) {
        this.f33068a = dSVerticalTabsView;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        LinearLayoutManager access$getLayoutManager$p = this.f33068a.layoutManager;
        LinearLayoutManager linearLayoutManager = null;
        if (access$getLayoutManager$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            access$getLayoutManager$p = null;
        }
        int findFirstCompletelyVisibleItemPosition = access$getLayoutManager$p.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == -1) {
            LinearLayoutManager access$getLayoutManager$p2 = this.f33068a.layoutManager;
            if (access$getLayoutManager$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            } else {
                linearLayoutManager = access$getLayoutManager$p2;
            }
            findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        }
        if (findFirstCompletelyVisibleItemPosition == this.f33068a.getSelectedTabIndex()) {
            this.f33068a.isScrollingProgrammatically = false;
        } else if (!this.f33068a.isScrollingProgrammatically) {
            this.f33068a.getTabBar().selectTab(findFirstCompletelyVisibleItemPosition, false);
        }
    }
}
