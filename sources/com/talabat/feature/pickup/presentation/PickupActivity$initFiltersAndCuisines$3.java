package com.talabat.feature.pickup.presentation;

import com.talabat.cuisines.navigation.CuisineView;
import com.talabat.feature.pickup.data.events.ClearFiltersClicked;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$initFiltersAndCuisines$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58643g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$initFiltersAndCuisines$3(PickupActivity pickupActivity) {
        super(0);
        this.f58643g = pickupActivity;
    }

    public final void invoke() {
        ((CuisineView) this.f58643g._$_findCachedViewById(R.id.cuisineViewLayout)).clearFilters();
        this.f58643g.loadPickupVendors();
        this.f58643g.getTracker().track(ClearFiltersClicked.INSTANCE);
    }
}
