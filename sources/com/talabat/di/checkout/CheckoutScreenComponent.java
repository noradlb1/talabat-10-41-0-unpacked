package com.talabat.di.checkout;

import com.talabat.CheckOutScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.di.PricingPresentationModule;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.wallet.bnplmanager.di.module.BnplManagerDaggerModule;
import dagger.Component;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeatureFlagCoreLibApi.class, FeesFeatureApi.class, HelpCenterFeatureApi.class, MapsCoreLibApi.class, ObservabilityCoreLibApi.class, SubscriptionsFeatureApi.class, DarkstoresScheduledDeliveryFeatureApi.class, CustomerCoreLibApi.class, PickupFeatureApi.class}, modules = {PricingPresentationModule.class, BnplManagerDaggerModule.class})
public interface CheckoutScreenComponent {

    @Component.Factory
    public interface Factory {
        CheckoutScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FeesFeatureApi feesFeatureApi, HelpCenterFeatureApi helpCenterFeatureApi, MapsCoreLibApi mapsCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi, CustomerCoreLibApi customerCoreLibApi, PickupFeatureApi pickupFeatureApi);
    }

    void inject(CheckOutScreen checkOutScreen);
}
