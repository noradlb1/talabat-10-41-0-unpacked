package com.talabat.di.checkout;

import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.di.PricingPresentationModule;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitModule;
import dagger.Component;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, ContextCoreLibApi.class, FeatureFlagCoreLibApi.class, FeesFeatureApi.class, ObservabilityCoreLibApi.class, TokenizationFeatureApi.class, DeepLinkCoreLibApi.class}, modules = {PricingPresentationModule.class, CheckoutKitModule.class})
public interface CheckoutTokenScreenComponent {

    @Component.Factory
    public interface Factory {
        CheckoutTokenScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FeesFeatureApi feesFeatureApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(CheckoutTokenScreen checkoutTokenScreen);
}
