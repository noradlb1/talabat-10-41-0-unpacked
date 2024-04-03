package com.talabat.fluid.homescreen.ui.fragment.di;

import com.google.gson.Gson;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment_MembersInjector;
import com.talabat.fluid.homescreen.ui.fragment.di.FluidHomeScreenFragmentComponent;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFluidHomeScreenFragmentComponent {

    public static final class Factory implements FluidHomeScreenFragmentComponent.Factory {
        private Factory() {
        }

        public FluidHomeScreenFragmentComponent create(CampaignMigratorFeatureApi campaignMigratorFeatureApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, CustomerCoreLibApi customerCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ParserCoreLibApi parserCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(campaignMigratorFeatureApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new FluidHomeScreenFragmentComponentImpl(new FluidHomeScreenObservabilityModule(), campaignMigratorFeatureApi, configurationLocalCoreLibApi, customerCoreLibApi, deepLinkCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, parserCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class FluidHomeScreenFragmentComponentImpl implements FluidHomeScreenFragmentComponent {
        private final CampaignMigratorFeatureApi campaignMigratorFeatureApi;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FluidHomeScreenFragmentComponentImpl fluidHomeScreenFragmentComponentImpl;
        private final FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private FluidHomeScreenFragmentComponentImpl(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule2, CampaignMigratorFeatureApi campaignMigratorFeatureApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2) {
            this.fluidHomeScreenFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.campaignMigratorFeatureApi = campaignMigratorFeatureApi2;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.fluidHomeScreenObservabilityModule = fluidHomeScreenObservabilityModule2;
        }

        private HomeScreenPerformanceObservability homeScreenPerformanceObservability() {
            return FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory.provideHomeScreenPerformanceObservability(this.fluidHomeScreenObservabilityModule, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private FluidHomeScreenFragment injectFluidHomeScreenFragment(FluidHomeScreenFragment fluidHomeScreenFragment) {
            FluidHomeScreenFragment_MembersInjector.injectConfigurationLocalRepository(fluidHomeScreenFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            FluidHomeScreenFragment_MembersInjector.injectObservabilityManager(fluidHomeScreenFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            FluidHomeScreenFragment_MembersInjector.injectTalabatFeatureFlag(fluidHomeScreenFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            FluidHomeScreenFragment_MembersInjector.injectTalabatTracker(fluidHomeScreenFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            FluidHomeScreenFragment_MembersInjector.injectCampaignCacheUseCase(fluidHomeScreenFragment, (VoucherCampaignCacheUseCase) Preconditions.checkNotNullFromComponent(this.campaignMigratorFeatureApi.getVoucherCampaignCacheUseCase()));
            FluidHomeScreenFragment_MembersInjector.injectCampaignMigratorSharedPreferences(fluidHomeScreenFragment, (CampaignMigratorSharedPreferences) Preconditions.checkNotNullFromComponent(this.campaignMigratorFeatureApi.getCampaignMigratorSharedPreferences()));
            FluidHomeScreenFragment_MembersInjector.injectGson(fluidHomeScreenFragment, (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson()));
            FluidHomeScreenFragment_MembersInjector.injectScreenTracker(fluidHomeScreenFragment, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            FluidHomeScreenFragment_MembersInjector.injectCustomerRepository(fluidHomeScreenFragment, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            FluidHomeScreenFragment_MembersInjector.injectDeepLinkNavigator(fluidHomeScreenFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            FluidHomeScreenFragment_MembersInjector.injectHomeScreenPerformanceObservability(fluidHomeScreenFragment, homeScreenPerformanceObservability());
            return fluidHomeScreenFragment;
        }

        public void inject(FluidHomeScreenFragment fluidHomeScreenFragment) {
            injectFluidHomeScreenFragment(fluidHomeScreenFragment);
        }
    }

    private DaggerFluidHomeScreenFragmentComponent() {
    }

    public static FluidHomeScreenFragmentComponent.Factory factory() {
        return new Factory();
    }
}
