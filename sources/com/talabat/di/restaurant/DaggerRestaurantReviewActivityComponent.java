package com.talabat.di.restaurant;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RestaurantReviewActivity;
import com.talabat.RestaurantReviewActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.restaurant.RestaurantReviewActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRestaurantReviewActivityComponent {

    public static final class Factory implements RestaurantReviewActivityComponent.Factory {
        private Factory() {
        }

        public RestaurantReviewActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new RestaurantReviewActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class RestaurantReviewActivityComponentImpl implements RestaurantReviewActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final RestaurantReviewActivityComponentImpl restaurantReviewActivityComponentImpl;

        private RestaurantReviewActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.restaurantReviewActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RestaurantReviewActivity injectRestaurantReviewActivity(RestaurantReviewActivity restaurantReviewActivity) {
            RestaurantReviewActivity_MembersInjector.injectAppVersionProvider(restaurantReviewActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return restaurantReviewActivity;
        }

        public void inject(RestaurantReviewActivity restaurantReviewActivity) {
            injectRestaurantReviewActivity(restaurantReviewActivity);
        }
    }

    private DaggerRestaurantReviewActivityComponent() {
    }

    public static RestaurantReviewActivityComponent.Factory factory() {
        return new Factory();
    }
}
