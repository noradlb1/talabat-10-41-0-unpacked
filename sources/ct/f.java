package ct;

import com.talabat.restaurants.RestaurantsListScreenRefactor;
import datamodels.Restaurant;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f61820b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61821c;

    public /* synthetic */ f(RestaurantsListScreenRefactor restaurantsListScreenRefactor, int i11) {
        this.f61820b = restaurantsListScreenRefactor;
        this.f61821c = i11;
    }

    public final void accept(Object obj) {
        this.f61820b.lambda$onInlineAdsAppeard$2(this.f61821c, (Restaurant) obj);
    }
}
