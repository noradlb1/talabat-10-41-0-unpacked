package com.talabat.di.order;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.OrderListScreen;
import com.talabat.OrderListScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.cart.CartUtilityModule_ProvideCartUtilityFactory;
import com.talabat.di.order.OrderListScreenComponent;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import library.talabat.mvp.cart.CartUtility;

@DaggerGenerated
public final class DaggerOrderListScreenComponent {

    public static final class Factory implements OrderListScreenComponent.Factory {
        private Factory() {
        }

        public OrderListScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FoodCartFeatureApi foodCartFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(foodCartFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new OrderListScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, foodCartFeatureApi, deepLinkCoreLibApi);
        }
    }

    public static final class OrderListScreenComponentImpl implements OrderListScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FoodCartFeatureApi foodCartFeatureApi;
        private final OrderListScreenComponentImpl orderListScreenComponentImpl;

        private OrderListScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FoodCartFeatureApi foodCartFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.orderListScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.foodCartFeatureApi = foodCartFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private CartUtility cartUtility() {
            return CartUtilityModule_ProvideCartUtilityFactory.provideCartUtility((IFoodCartRepository) Preconditions.checkNotNullFromComponent(this.foodCartFeatureApi.getRepository()));
        }

        @CanIgnoreReturnValue
        private OrderListScreen injectOrderListScreen(OrderListScreen orderListScreen) {
            OrderListScreen_MembersInjector.injectAppVersionProvider(orderListScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            OrderListScreen_MembersInjector.injectConfigurationLocalRepository(orderListScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            OrderListScreen_MembersInjector.injectLocationConfigurationRepository(orderListScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            OrderListScreen_MembersInjector.injectTalabatFeatureFlag(orderListScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            OrderListScreen_MembersInjector.injectTalabatExperiment(orderListScreen, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            OrderListScreen_MembersInjector.injectCartUtility(orderListScreen, cartUtility());
            OrderListScreen_MembersInjector.injectNavigator(orderListScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return orderListScreen;
        }

        public void inject(OrderListScreen orderListScreen) {
            injectOrderListScreen(orderListScreen);
        }
    }

    private DaggerOrderListScreenComponent() {
    }

    public static OrderListScreenComponent.Factory factory() {
        return new Factory();
    }
}
