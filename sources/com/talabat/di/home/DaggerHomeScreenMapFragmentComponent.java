package com.talabat.di.home;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.squareup.moshi.Moshi;
import com.talabat.HomeScreenMap;
import com.talabat.HomeScreenMap_MembersInjector;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.pinless.checkout.domain.SetHasUserPinnedLocationInOnboardingMapUseCase;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.home.HomeScreenMapFragmentComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerHomeScreenMapFragmentComponent {

    public static final class Factory implements HomeScreenMapFragmentComponent.Factory {
        private Factory() {
        }

        public HomeScreenMapFragmentComponent create(CustomerCoreLibApi customerCoreLibApi, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, ParserCoreLibApi parserCoreLibApi, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, SecretCoreLibApi secretCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi) {
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(locationCoreLibApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(pinlessCheckoutCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            return new HomeScreenMapFragmentComponentImpl(customerCoreLibApi, locationCoreLibApi, mapsCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, parserCoreLibApi, pinlessCheckoutCoreLibApi, secretCoreLibApi, subscriptionsFeatureApi, featureFlagCoreLibApi, deepLinkCoreLibApi, navigationCoreLibApi);
        }
    }

    public static final class HomeScreenMapFragmentComponentImpl implements HomeScreenMapFragmentComponent {
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HomeScreenMapFragmentComponentImpl homeScreenMapFragmentComponentImpl;
        private final MapsCoreLibApi mapsCoreLibApi;
        private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi;
        private final SecretCoreLibApi secretCoreLibApi;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private HomeScreenMapFragmentComponentImpl(CustomerCoreLibApi customerCoreLibApi2, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi2, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2, SecretCoreLibApi secretCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2) {
            this.homeScreenMapFragmentComponentImpl = this;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            this.pinlessCheckoutCoreLibApi = pinlessCheckoutCoreLibApi2;
            this.secretCoreLibApi = secretCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.mapsCoreLibApi = mapsCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private HomeScreenMap injectHomeScreenMap(HomeScreenMap homeScreenMap) {
            HomeScreenMap_MembersInjector.injectMoshi(homeScreenMap, (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()));
            HomeScreenMap_MembersInjector.injectAppVersionProvider(homeScreenMap, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            HomeScreenMap_MembersInjector.injectConfigurationRemoteRepository(homeScreenMap, (ConfigurationRemoteRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getRepository()));
            HomeScreenMap_MembersInjector.injectMutableConfigurationLocalRepository(homeScreenMap, (MutableConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getMutableRepository()));
            HomeScreenMap_MembersInjector.injectMutableLocationConfigurationRepository(homeScreenMap, (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()));
            HomeScreenMap_MembersInjector.injectMutableConfigurationRemoteRepository(homeScreenMap, (MutableConfigurationRemoteRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableRepository()));
            HomeScreenMap_MembersInjector.injectPaymentConfigurationRepository(homeScreenMap, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            HomeScreenMap_MembersInjector.injectSetHasUserPinnedLocationInOnboardingMapUseCase(homeScreenMap, (SetHasUserPinnedLocationInOnboardingMapUseCase) Preconditions.checkNotNullFromComponent(this.pinlessCheckoutCoreLibApi.getSetHasUserPinnedLocationInOnboardingMapUseCase()));
            HomeScreenMap_MembersInjector.injectSecretProvider(homeScreenMap, (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()));
            HomeScreenMap_MembersInjector.injectSubscriptionsCustomerRepository(homeScreenMap, (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
            HomeScreenMap_MembersInjector.injectGetProCentralizationStatusUseCase(homeScreenMap, (GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()));
            HomeScreenMap_MembersInjector.injectTalabatFeatureFlag(homeScreenMap, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            HomeScreenMap_MembersInjector.injectCameraUpdateFactory(homeScreenMap, (CameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getCameraUpdateFactory()));
            HomeScreenMap_MembersInjector.injectModelsRepository(homeScreenMap, (ModelsRepository) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getModelsRepository()));
            HomeScreenMap_MembersInjector.injectLatLngFactory(homeScreenMap, (LatLngFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getLatLngFactory()));
            HomeScreenMap_MembersInjector.injectMapsInitializer(homeScreenMap, (MapsInitializer) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapsInitializer()));
            HomeScreenMap_MembersInjector.injectCustomerRepository(homeScreenMap, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            HomeScreenMap_MembersInjector.injectDeepLinkNavigator(homeScreenMap, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            HomeScreenMap_MembersInjector.injectNavigator(homeScreenMap, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return homeScreenMap;
        }

        public void inject(HomeScreenMap homeScreenMap) {
            injectHomeScreenMap(homeScreenMap);
        }
    }

    private DaggerHomeScreenMapFragmentComponent() {
    }

    public static HomeScreenMapFragmentComponent.Factory factory() {
        return new Factory();
    }
}
