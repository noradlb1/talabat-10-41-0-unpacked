package com.talabat.wallet.ui.walletCardManagement.view.walletCardList.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di.AddCardCustomViewModule;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/di/WalletCardManagementFragmentComponent;", "", "inject", "", "walletCardManagementFragment", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/WalletCardManagementFragment;", "Factory", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, DeepLinkCoreLibApi.class, DispatcherCoreLibApi.class, FeatureFlagCoreLibApi.class, ObservabilityCoreLibApi.class, NetworkCoreLibApi.class, NavigationCoreLibApi.class, TrackingCoreLibApi.class, TokenizationFeatureApi.class}, modules = {AddCardCustomViewModule.class})
public interface WalletCardManagementFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/di/WalletCardManagementFragmentComponent$Factory;", "", "create", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/di/WalletCardManagementFragmentComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "tokenizationFeatureApi", "Lcom/talabat/feature/tokenization/domain/TokenizationFeatureApi;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        WalletCardManagementFragmentComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull TokenizationFeatureApi tokenizationFeatureApi);
    }

    void inject(@NotNull WalletCardManagementFragment walletCardManagementFragment);
}
