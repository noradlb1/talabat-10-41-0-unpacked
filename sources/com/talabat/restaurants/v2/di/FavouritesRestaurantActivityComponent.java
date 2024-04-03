package com.talabat.restaurants.v2.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/v2/di/FavouritesRestaurantActivityComponent;", "", "inject", "", "target", "Lcom/talabat/restaurants/v2/ui/activities/FavouriteRestaurantsActivity;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {TrackingCoreLibApi.class, DispatcherCoreLibApi.class})
public interface FavouritesRestaurantActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/restaurants/v2/di/FavouritesRestaurantActivityComponent$Factory;", "", "create", "Lcom/talabat/restaurants/v2/di/FavouritesRestaurantActivityComponent;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FavouritesRestaurantActivityComponent create(@NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }

    void inject(@NotNull FavouriteRestaurantsActivity favouriteRestaurantsActivity);
}
