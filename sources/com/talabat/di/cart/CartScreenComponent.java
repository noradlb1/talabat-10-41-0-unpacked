package com.talabat.di.cart;

import com.talabat.CartScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.di.PricingPresentationModule;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.Component;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeesFeatureApi.class, FeatureFlagCoreLibApi.class, ExperimentCoreLibApi.class, IncentiveAutoApplyDiscountsFeatureApi.class, FoodCartFeatureApi.class, SubscriptionsFeatureApi.class, CustomerCoreLibApi.class, ObservabilityCoreLibApi.class, NavigationCoreLibApi.class, DeepLinkCoreLibApi.class}, modules = {PricingPresentationModule.class, CartUtilityModule.class})
public interface CartScreenComponent {

    @Component.Factory
    public interface Factory {
        CartScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeesFeatureApi feesFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi, FoodCartFeatureApi foodCartFeatureApi, SubscriptionsFeatureApi subscriptionsFeatureApi, CustomerCoreLibApi customerCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(CartScreen cartScreen);
}
