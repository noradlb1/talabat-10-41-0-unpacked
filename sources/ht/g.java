package ht;

import com.talabat.restaurants.v1.RestaurantListListenerRefactor;
import com.talabat.restaurants.v1.RestaurantsListInteractorRefactor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListListenerRefactor f62138b;

    public /* synthetic */ g(RestaurantListListenerRefactor restaurantListListenerRefactor) {
        this.f62138b = restaurantListListenerRefactor;
    }

    public final void accept(Object obj) {
        RestaurantsListInteractorRefactor.lambda$getRestaurantsAndRecommendation$2(this.f62138b, (Throwable) obj);
    }
}
