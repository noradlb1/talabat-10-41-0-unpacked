package com.talabat.restaurants.v2.ui.activities;

import com.talabat.restaurants.v2.domain.vendors.GetFavouriteRestaurantsUseCase;
import com.talabat.restaurants.v2.ui.viewmodels.FavouriteRestaurantsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/restaurants/v2/ui/viewmodels/FavouriteRestaurantsViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FavouriteRestaurantsActivity$viewModel$2 extends Lambda implements Function0<FavouriteRestaurantsViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FavouriteRestaurantsActivity f61252g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavouriteRestaurantsActivity$viewModel$2(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
        super(0);
        this.f61252g = favouriteRestaurantsActivity;
    }

    @NotNull
    public final FavouriteRestaurantsViewModel invoke() {
        return new FavouriteRestaurantsViewModel(false, this.f61252g.getRxSchedulersFactory().io(), this.f61252g.getRxSchedulersFactory().main(), this.f61252g.getTracker(), (GetFavouriteRestaurantsUseCase) null, 17, (DefaultConstructorMarker) null);
    }
}
