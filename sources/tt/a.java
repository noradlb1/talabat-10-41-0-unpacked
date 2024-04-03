package tt;

import com.talabat.restaurants.v2.ui.viewmodels.FavouriteRestaurantsViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FavouriteRestaurantsViewModel f62923b;

    public /* synthetic */ a(FavouriteRestaurantsViewModel favouriteRestaurantsViewModel) {
        this.f62923b = favouriteRestaurantsViewModel;
    }

    public final void accept(Object obj) {
        FavouriteRestaurantsViewModel.m10758loadFavouriteList$lambda0(this.f62923b, (List) obj);
    }
}
