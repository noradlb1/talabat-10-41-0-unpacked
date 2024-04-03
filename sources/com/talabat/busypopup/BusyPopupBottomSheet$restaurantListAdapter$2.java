package com.talabat.busypopup;

import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BusyPopupBottomSheet$restaurantListAdapter$2 extends Lambda implements Function0<RestaurantsListAdapterRefactor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BusyPopupBottomSheet f55525g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusyPopupBottomSheet$restaurantListAdapter$2(BusyPopupBottomSheet busyPopupBottomSheet) {
        super(0);
        this.f55525g = busyPopupBottomSheet;
    }

    @NotNull
    public final RestaurantsListAdapterRefactor invoke() {
        return new RestaurantsListAdapterRefactor(this.f55525g.requireContext(), this.f55525g.getVerticalType(), true, this.f55525g.getTalabatFeatureFlag());
    }
}
