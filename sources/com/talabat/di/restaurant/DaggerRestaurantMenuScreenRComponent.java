package com.talabat.di.restaurant;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RestaurantMenuScreenR;
import com.talabat.RestaurantMenuScreenR_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.restaurant.RestaurantMenuScreenRComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRestaurantMenuScreenRComponent {

    public static final class Factory implements RestaurantMenuScreenRComponent.Factory {
        private Factory() {
        }

        public RestaurantMenuScreenRComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, CustomerCoreLibApi customerCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            return new RestaurantMenuScreenRComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, customerCoreLibApi, subscriptionsFeatureApi);
        }
    }

    public static final class RestaurantMenuScreenRComponentImpl implements RestaurantMenuScreenRComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final RestaurantMenuScreenRComponentImpl restaurantMenuScreenRComponentImpl;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private RestaurantMenuScreenRComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2) {
            this.restaurantMenuScreenRComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
        }

        @CanIgnoreReturnValue
        private RestaurantMenuScreenR injectRestaurantMenuScreenR(RestaurantMenuScreenR restaurantMenuScreenR) {
            RestaurantMenuScreenR_MembersInjector.injectAppVersionProvider(restaurantMenuScreenR, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            RestaurantMenuScreenR_MembersInjector.injectConfigurationLocalRepository(restaurantMenuScreenR, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            RestaurantMenuScreenR_MembersInjector.injectLocationConfigurationRepository(restaurantMenuScreenR, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            RestaurantMenuScreenR_MembersInjector.injectPaymentConfigurationRepository(restaurantMenuScreenR, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            RestaurantMenuScreenR_MembersInjector.injectTalabatFeatureFlag(restaurantMenuScreenR, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            RestaurantMenuScreenR_MembersInjector.injectCustomerRepository(restaurantMenuScreenR, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            RestaurantMenuScreenR_MembersInjector.injectSubscriptionsFeatureFlagRepo(restaurantMenuScreenR, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            return restaurantMenuScreenR;
        }

        public void inject(RestaurantMenuScreenR restaurantMenuScreenR) {
            injectRestaurantMenuScreenR(restaurantMenuScreenR);
        }
    }

    private DaggerRestaurantMenuScreenRComponent() {
    }

    public static RestaurantMenuScreenRComponent.Factory factory() {
        return new Factory();
    }
}
