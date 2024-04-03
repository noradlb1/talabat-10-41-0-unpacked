package ht;

import com.talabat.restaurants.v1.RestaurantListInteractorPaginated;
import com.talabat.restaurants.v1.RestaurantListListenerRefactor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListListenerRefactor f62134b;

    public /* synthetic */ c(RestaurantListListenerRefactor restaurantListListenerRefactor) {
        this.f62134b = restaurantListListenerRefactor;
    }

    public final void accept(Object obj) {
        RestaurantListInteractorPaginated.m10731getRestaurantsAndRecommendation$lambda2(this.f62134b, (Throwable) obj);
    }
}
