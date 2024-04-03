package com.talabat.home.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.NfvFlutterNavigationModule;
import com.talabat.di.voucher.VoucherRepositoryModule;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule;
import com.talabat.home.HomeScreenActivity;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/home/di/HomeScreenActivityComponent;", "", "inject", "", "homeScreenActivity", "Lcom/talabat/home/HomeScreenActivity;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ActiveCartsApi.class, BnplCoreFeatureApi.class, ConfigurationLocalCoreLibApi.class, CustomerCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class, DarkstoresFeatureApi.class, DeepLinkCoreLibApi.class, ObservabilityCoreLibApi.class, TrackingCoreLibApi.class, ObservabilityCoreLibApi.class, FeatureFlagCoreLibApi.class, RatingFeatureApi.class, ExperimentCoreLibApi.class, CampaignMigratorFeatureApi.class, NavigationCoreLibApi.class, ContextCoreLibApi.class, DispatcherCoreLibApi.class, OnBoardingExperimentApi.class, WalletCobrandedCcFeatureApi.class}, modules = {FluidHomeScreenObservabilityModule.class, VoucherRepositoryModule.class, NfvFlutterNavigationModule.class})
public interface HomeScreenActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H&¨\u0006("}, d2 = {"Lcom/talabat/home/di/HomeScreenActivityComponent$Factory;", "", "create", "Lcom/talabat/home/di/HomeScreenActivityComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "activeCartsApi", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "bnplCoreFeatureApi", "Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "ratingFeatureApi", "Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "campaignMigratorFeatureApi", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "onBoardingExperimentApi", "Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "walletCobrandedCcFeatureApi", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcFeatureApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        HomeScreenActivityComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ActiveCartsApi activeCartsApi, @NotNull BnplCoreFeatureApi bnplCoreFeatureApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, @NotNull DarkstoresFeatureApi darkstoresFeatureApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull RatingFeatureApi ratingFeatureApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull CampaignMigratorFeatureApi campaignMigratorFeatureApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull OnBoardingExperimentApi onBoardingExperimentApi, @NotNull WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi);
    }

    void inject(@NotNull HomeScreenActivity homeScreenActivity);
}
