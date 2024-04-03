package com.talabat.fluid.homescreen.ui.fragment.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/di/FluidHomeScreenFragmentComponent;", "", "inject", "", "fluidHomeScreenFragment", "Lcom/talabat/fluid/homescreen/ui/fragment/FluidHomeScreenFragment;", "Factory", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {CampaignMigratorFeatureApi.class, ConfigurationLocalCoreLibApi.class, CustomerCoreLibApi.class, DeepLinkCoreLibApi.class, FeatureFlagCoreLibApi.class, ObservabilityCoreLibApi.class, ParserCoreLibApi.class, TrackingCoreLibApi.class}, modules = {FluidHomeScreenObservabilityModule.class})
public interface FluidHomeScreenFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/di/FluidHomeScreenFragmentComponent$Factory;", "", "create", "Lcom/talabat/fluid/homescreen/ui/fragment/di/FluidHomeScreenFragmentComponent;", "campaignMigratorFeatureApi", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FluidHomeScreenFragmentComponent create(@NotNull CampaignMigratorFeatureApi campaignMigratorFeatureApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }

    void inject(@NotNull FluidHomeScreenFragment fluidHomeScreenFragment);
}
