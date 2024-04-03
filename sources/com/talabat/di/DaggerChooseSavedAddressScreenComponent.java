package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.squareup.moshi.Moshi;
import com.talabat.ChooseSavedAddressScreen;
import com.talabat.ChooseSavedAddressScreen_MembersInjector;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.ChooseSavedAddressScreenComponent;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerChooseSavedAddressScreenComponent {

    public static final class ChooseSavedAddressScreenComponentImpl implements ChooseSavedAddressScreenComponent {
        private final ChooseSavedAddressScreenComponentImpl chooseSavedAddressScreenComponentImpl;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private ChooseSavedAddressScreenComponentImpl(CustomerCoreLibApi customerCoreLibApi2, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2) {
            this.chooseSavedAddressScreenComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ChooseSavedAddressScreen injectChooseSavedAddressScreen(ChooseSavedAddressScreen chooseSavedAddressScreen) {
            ChooseSavedAddressScreen_MembersInjector.injectAppVersionProvider(chooseSavedAddressScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            ChooseSavedAddressScreen_MembersInjector.injectLocationConfigurationRepository(chooseSavedAddressScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            ChooseSavedAddressScreen_MembersInjector.injectMutableConfigurationLocalCoreLibApi(chooseSavedAddressScreen, this.mutableConfigurationLocalCoreLibApi);
            ChooseSavedAddressScreen_MembersInjector.injectMutableConfigurationRemoteCoreLibApi(chooseSavedAddressScreen, this.mutableConfigurationRemoteCoreLibApi);
            ChooseSavedAddressScreen_MembersInjector.injectPaymentConfigurationRepository(chooseSavedAddressScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            ChooseSavedAddressScreen_MembersInjector.injectMoshi(chooseSavedAddressScreen, (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()));
            ChooseSavedAddressScreen_MembersInjector.injectSubscriptionsFeatureApi(chooseSavedAddressScreen, this.subscriptionsFeatureApi);
            ChooseSavedAddressScreen_MembersInjector.injectTalabatFeatureFlag(chooseSavedAddressScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            ChooseSavedAddressScreen_MembersInjector.injectCustomerRepository(chooseSavedAddressScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            ChooseSavedAddressScreen_MembersInjector.injectDeepLinkNavigator(chooseSavedAddressScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            ChooseSavedAddressScreen_MembersInjector.injectNavigator(chooseSavedAddressScreen, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return chooseSavedAddressScreen;
        }

        public void inject(ChooseSavedAddressScreen chooseSavedAddressScreen) {
            injectChooseSavedAddressScreen(chooseSavedAddressScreen);
        }
    }

    public static final class Factory implements ChooseSavedAddressScreenComponent.Factory {
        private Factory() {
        }

        public ChooseSavedAddressScreenComponent create(CustomerCoreLibApi customerCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi) {
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            return new ChooseSavedAddressScreenComponentImpl(customerCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, parserCoreLibApi, subscriptionsFeatureApi, featureFlagCoreLibApi, deepLinkCoreLibApi, navigationCoreLibApi);
        }
    }

    private DaggerChooseSavedAddressScreenComponent() {
    }

    public static ChooseSavedAddressScreenComponent.Factory factory() {
        return new Factory();
    }
}
