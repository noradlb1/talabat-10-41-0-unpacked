package com.talabat.restaurants.v2.ui.fragments;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/restaurants/v2/ui/fragments/VendorsListFragment$recyclerScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$recyclerScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61265a;

    public VendorsListFragment$recyclerScrollListener$1(VendorsListFragment vendorsListFragment) {
        this.f61265a = vendorsListFragment;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.computeVerticalScrollOffset() > 0) {
            RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) this.f61265a.getActivity();
            if (restaurantsListScreenRefactor != null) {
                restaurantsListScreenRefactor.onListScrolled(false, i12);
            }
        } else {
            RestaurantsListScreenRefactor restaurantsListScreenRefactor2 = (RestaurantsListScreenRefactor) this.f61265a.getActivity();
            if (restaurantsListScreenRefactor2 != null) {
                restaurantsListScreenRefactor2.onListScrolled(true, i12);
            }
        }
        Pair access$getFeatureProductsSwimlane$p = this.f61265a.featureProductsSwimlane;
        if (access$getFeatureProductsSwimlane$p != null) {
            VendorsListFragment vendorsListFragment = this.f61265a;
            if (vendorsListFragment.isFPSwimlaneVisible(recyclerView)) {
                RestaurantsListAdapterRefactor access$getVendorsListAdapter = vendorsListFragment.getVendorsListAdapter();
                int intValue = ((Number) access$getFeatureProductsSwimlane$p.getFirst()).intValue();
                Object obj = ((RestaurantListItemModel) access$getFeatureProductsSwimlane$p.getSecond()).data;
                if (obj != null) {
                    access$getVendorsListAdapter.sendFeatureProductAppearedEvent(intValue, (FeatureProductListDisplayModel) obj);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel");
            }
        }
    }
}
