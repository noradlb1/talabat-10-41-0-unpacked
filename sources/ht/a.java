package ht;

import com.talabat.restaurants.v1.RestaurantListInteractorPaginated;
import io.reactivex.functions.BiFunction;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import library.talabat.com.talabatlib.VendorTagsResponse;

public final /* synthetic */ class a implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return RestaurantListInteractorPaginated.m10729getRestaurantsAndRecommendation$lambda0((RestaurantListResponsePaginated) obj, (VendorTagsResponse) obj2);
    }
}
