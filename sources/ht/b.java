package ht;

import com.talabat.restaurants.v1.RestaurantListInteractorPaginated;
import com.talabat.restaurants.v1.RestaurantListListenerRefactor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListInteractorPaginated f62132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RestaurantListListenerRefactor f62133c;

    public /* synthetic */ b(RestaurantListInteractorPaginated restaurantListInteractorPaginated, RestaurantListListenerRefactor restaurantListListenerRefactor) {
        this.f62132b = restaurantListInteractorPaginated;
        this.f62133c = restaurantListListenerRefactor;
    }

    public final void accept(Object obj) {
        RestaurantListInteractorPaginated.m10730getRestaurantsAndRecommendation$lambda1(this.f62132b, this.f62133c, (Pair) obj);
    }
}
