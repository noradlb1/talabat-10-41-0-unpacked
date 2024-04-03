package com.talabat.restaurants.v2.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.restaurants.v2.di.FavouritesRestaurantActivityComponent;
import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity;
import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFavouritesRestaurantActivityComponent {

    public static final class Factory implements FavouritesRestaurantActivityComponent.Factory {
        private Factory() {
        }

        public FavouritesRestaurantActivityComponent create(TrackingCoreLibApi trackingCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new FavouritesRestaurantActivityComponentImpl(trackingCoreLibApi, dispatcherCoreLibApi);
        }
    }

    public static final class FavouritesRestaurantActivityComponentImpl implements FavouritesRestaurantActivityComponent {
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FavouritesRestaurantActivityComponentImpl favouritesRestaurantActivityComponentImpl;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private FavouritesRestaurantActivityComponentImpl(TrackingCoreLibApi trackingCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2) {
            this.favouritesRestaurantActivityComponentImpl = this;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private FavouriteRestaurantsActivity injectFavouriteRestaurantsActivity(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
            FavouriteRestaurantsActivity_MembersInjector.injectTracker(favouriteRestaurantsActivity, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            FavouriteRestaurantsActivity_MembersInjector.injectRxSchedulersFactory(favouriteRestaurantsActivity, (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
            return favouriteRestaurantsActivity;
        }

        public void inject(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
            injectFavouriteRestaurantsActivity(favouriteRestaurantsActivity);
        }
    }

    private DaggerFavouritesRestaurantActivityComponent() {
    }

    public static FavouritesRestaurantActivityComponent.Factory factory() {
        return new Factory();
    }
}
