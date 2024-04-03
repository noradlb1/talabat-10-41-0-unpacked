package ht;

import com.talabat.restaurants.v1.RestaurantListListenerRefactor;
import com.talabat.restaurants.v1.RestaurantsListInteractorRefactor;
import datamodels.WrapperRestaurantRecommendation;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListInteractorRefactor f62135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RestaurantListListenerRefactor f62136c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62137d;

    public /* synthetic */ f(RestaurantsListInteractorRefactor restaurantsListInteractorRefactor, RestaurantListListenerRefactor restaurantListListenerRefactor, int i11) {
        this.f62135b = restaurantsListInteractorRefactor;
        this.f62136c = restaurantListListenerRefactor;
        this.f62137d = i11;
    }

    public final void accept(Object obj) {
        this.f62135b.lambda$getRestaurantsAndRecommendation$1(this.f62136c, this.f62137d, (WrapperRestaurantRecommendation) obj);
    }
}
