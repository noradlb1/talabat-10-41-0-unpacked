package com.talabat.di.restaurant;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RestaurantInfoActivity;
import com.talabat.RestaurantInfoActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.di.restaurant.RestaurantInfoActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRestaurantInfoActivityComponent {

    public static final class Factory implements RestaurantInfoActivityComponent.Factory {
        private Factory() {
        }

        public RestaurantInfoActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new RestaurantInfoActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class RestaurantInfoActivityComponentImpl implements RestaurantInfoActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final RestaurantInfoActivityComponentImpl restaurantInfoActivityComponentImpl;

        private RestaurantInfoActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.restaurantInfoActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RestaurantInfoActivity injectRestaurantInfoActivity(RestaurantInfoActivity restaurantInfoActivity) {
            RestaurantInfoActivity_MembersInjector.injectPaymentConfigurationRepository(restaurantInfoActivity, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            return restaurantInfoActivity;
        }

        public void inject(RestaurantInfoActivity restaurantInfoActivity) {
            injectRestaurantInfoActivity(restaurantInfoActivity);
        }
    }

    private DaggerRestaurantInfoActivityComponent() {
    }

    public static RestaurantInfoActivityComponent.Factory factory() {
        return new Factory();
    }
}
