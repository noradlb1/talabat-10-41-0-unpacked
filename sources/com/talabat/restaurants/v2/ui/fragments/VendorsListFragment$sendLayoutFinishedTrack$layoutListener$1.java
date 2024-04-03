package com.talabat.restaurants.v2.ui.fragments;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/restaurants/v2/ui/fragments/VendorsListFragment$sendLayoutFinishedTrack$layoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$sendLayoutFinishedTrack$layoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61266b;

    public VendorsListFragment$sendLayoutFinishedTrack$layoutListener$1(VendorsListFragment vendorsListFragment) {
        this.f61266b = vendorsListFragment;
    }

    public void onGlobalLayout() {
        ViewTreeObserver viewTreeObserver;
        TimeTrackerImplementation timeTracker = this.f61266b.getTimeTracker();
        int verticalId = this.f61266b.getVerticalId();
        TimeTrackerImplementation.stopTracking$default(timeTracker, RestaurantsListScreenRefactor.TIME_EVENT_RESTAURANT_LIST + verticalId, 0, 2, (Object) null);
        RecyclerView recyclerView = (RecyclerView) this.f61266b._$_findCachedViewById(R.id.recyclerView_restaurantsList);
        if (recyclerView != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }
}
