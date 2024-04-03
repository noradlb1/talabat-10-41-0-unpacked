package com.talabat.feature.pickup.presentation.adapters;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.presentation.PickupViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "viewModel", "Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "(Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;Lcom/talabat/feature/pickup/presentation/PickupViewModel;)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "tilesDisplayed", "lastDisplayed", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesScrollListener extends RecyclerView.OnScrollListener {
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTracking f58670tracking;
    @NotNull
    private final PickupViewModel viewModel;

    public SwimlanesScrollListener(@NotNull SwimlanesTracking swimlanesTracking, @NotNull PickupViewModel pickupViewModel) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        Intrinsics.checkNotNullParameter(pickupViewModel, "viewModel");
        this.f58670tracking = swimlanesTracking;
        this.viewModel = pickupViewModel;
    }

    private final int tilesDisplayed(int i11, RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() + 1;
            if (findLastVisibleItemPosition > i11) {
                return findLastVisibleItemPosition;
            }
            return i11;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 == 0) {
            SwimlanesTracking swimlanesTracking = this.f58670tracking;
            swimlanesTracking.setTilesDisplayed(tilesDisplayed(swimlanesTracking.getTilesDisplayed(), recyclerView));
            this.viewModel.trackSwimlanesSwiped(this.f58670tracking);
        }
    }
}
