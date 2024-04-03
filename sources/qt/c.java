package qt;

import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FavouriteRestaurantsActivity f62843b;

    public /* synthetic */ c(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
        this.f62843b = favouriteRestaurantsActivity;
    }

    public final void accept(Object obj) {
        FavouriteRestaurantsActivity.m10754observeAndLoadFavouriteList$lambda2(this.f62843b, (Pair) obj);
    }
}
