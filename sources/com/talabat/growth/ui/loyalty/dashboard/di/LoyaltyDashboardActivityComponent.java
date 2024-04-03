package com.talabat.growth.ui.loyalty.dashboard.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardActivityComponent;", "", "inject", "", "target", "Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardActivity;", "Factory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {FeatureFlagCoreLibApi.class, DeepLinkCoreLibApi.class})
public interface LoyaltyDashboardActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardActivityComponent$Factory;", "", "create", "Lcom/talabat/growth/ui/loyalty/dashboard/di/LoyaltyDashboardActivityComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        LoyaltyDashboardActivityComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(@NotNull LoyaltyDashboardActivity loyaltyDashboardActivity);
}
