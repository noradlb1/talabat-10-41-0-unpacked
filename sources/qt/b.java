package qt;

import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FavouriteRestaurantsActivity f62842b;

    public /* synthetic */ b(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
        this.f62842b = favouriteRestaurantsActivity;
    }

    public final void accept(Object obj) {
        FavouriteRestaurantsActivity.m10753observeAndLoadFavouriteList$lambda1(this.f62842b, (Unit) obj);
    }
}
