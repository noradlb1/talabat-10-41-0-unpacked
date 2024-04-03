package com.talabat.wallet.ui.subscriptionManagement.view.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/di/SubscriptionComponent;", "", "inject", "", "subscriptionManagementFragment", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementFragment;", "subscriptionPlanFragment", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionPlanFragment;", "subscriptionCancellationFragment", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment;", "subscriptionDetailFragment", "Lcom/talabat/wallet/ui/subscriptionManagement/view/fragment/SubscriptionDetailFragment;", "Factory", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeatureFlagCoreLibApi.class, SubscriptionsFeatureApi.class})
public interface SubscriptionComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/di/SubscriptionComponent$Factory;", "", "create", "Lcom/talabat/wallet/ui/subscriptionManagement/view/di/SubscriptionComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SubscriptionComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi);
    }

    void inject(@NotNull SubscriptionManagementFragment subscriptionManagementFragment);

    void inject(@NotNull SubscriptionPlanFragment subscriptionPlanFragment);

    void inject(@NotNull SubscriptionCancellationFragment subscriptionCancellationFragment);

    void inject(@NotNull SubscriptionDetailFragment subscriptionDetailFragment);
}
