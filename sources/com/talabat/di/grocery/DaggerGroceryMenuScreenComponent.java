package com.talabat.di.grocery;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.GroceryMenuScreen;
import com.talabat.GroceryMenuScreen_MembersInjector;
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
import com.talabat.di.grocery.GroceryMenuScreenComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGroceryMenuScreenComponent {

    public static final class Factory implements GroceryMenuScreenComponent.Factory {
        private Factory() {
        }

        public GroceryMenuScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, CustomerCoreLibApi customerCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            return new GroceryMenuScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, customerCoreLibApi, subscriptionsFeatureApi);
        }
    }

    public static final class GroceryMenuScreenComponentImpl implements GroceryMenuScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final GroceryMenuScreenComponentImpl groceryMenuScreenComponentImpl;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private GroceryMenuScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2) {
            this.groceryMenuScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
        }

        @CanIgnoreReturnValue
        private GroceryMenuScreen injectGroceryMenuScreen(GroceryMenuScreen groceryMenuScreen) {
            GroceryMenuScreen_MembersInjector.injectAppVersionProvider(groceryMenuScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            GroceryMenuScreen_MembersInjector.injectConfigurationLocalRepository(groceryMenuScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            GroceryMenuScreen_MembersInjector.injectLocationConfigurationRepository(groceryMenuScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            GroceryMenuScreen_MembersInjector.injectPaymentConfigurationRepository(groceryMenuScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            GroceryMenuScreen_MembersInjector.injectTalabatFeatureFlag(groceryMenuScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            GroceryMenuScreen_MembersInjector.injectCustomerRepository(groceryMenuScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            GroceryMenuScreen_MembersInjector.injectSubscriptionsFeatureFlagRepo(groceryMenuScreen, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            return groceryMenuScreen;
        }

        public void inject(GroceryMenuScreen groceryMenuScreen) {
            injectGroceryMenuScreen(groceryMenuScreen);
        }
    }

    private DaggerGroceryMenuScreenComponent() {
    }

    public static GroceryMenuScreenComponent.Factory factory() {
        return new Factory();
    }
}
