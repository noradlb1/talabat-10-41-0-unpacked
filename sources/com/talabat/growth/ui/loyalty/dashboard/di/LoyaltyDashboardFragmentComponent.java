package com.talabat.growth.ui.loyalty.dashboard.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardFragmentComponent;", "", "inject", "", "loyaltyDashboardFragment", "Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment;", "Factory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeatureFlagCoreLibApi.class, RewardsFeatureApi.class, DispatcherCoreLibApi.class, NavigationCoreLibApi.class, DeepLinkCoreLibApi.class, HelpCenterFeatureApi.class})
public interface LoyaltyDashboardFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardFragmentComponent$Factory;", "", "create", "Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardFragmentComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "rewardsFeatureApi", "Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        LoyaltyDashboardFragmentComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull RewardsFeatureApi rewardsFeatureApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull HelpCenterFeatureApi helpCenterFeatureApi);
    }

    void inject(@NotNull LoyaltyDashboardFragment loyaltyDashboardFragment);
}
