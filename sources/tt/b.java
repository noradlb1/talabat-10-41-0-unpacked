package tt;

import com.talabat.restaurants.v2.ui.viewmodels.FavouriteRestaurantsViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FavouriteRestaurantsViewModel f62924b;

    public /* synthetic */ b(FavouriteRestaurantsViewModel favouriteRestaurantsViewModel) {
        this.f62924b = favouriteRestaurantsViewModel;
    }

    public final void accept(Object obj) {
        FavouriteRestaurantsViewModel.m10759loadFavouriteList$lambda1(this.f62924b, (Throwable) obj);
    }
}
