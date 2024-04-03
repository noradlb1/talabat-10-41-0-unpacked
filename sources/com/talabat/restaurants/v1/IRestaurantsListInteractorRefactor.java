package com.talabat.restaurants.v1;

import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v1/IRestaurantsListInteractorRefactor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getRestaurantsAndRecommendation", "", "listener", "Lcom/talabat/restaurants/v1/RestaurantListListenerRefactor;", "areaId", "", "cityId", "latitude", "", "longitude", "countryId", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRestaurantsListInteractorRefactor extends IGlobalInteractor {
    void getRestaurantsAndRecommendation(@NotNull RestaurantListListenerRefactor restaurantListListenerRefactor, int i11, int i12, @NotNull String str, @NotNull String str2, int i13, int i14);
}
