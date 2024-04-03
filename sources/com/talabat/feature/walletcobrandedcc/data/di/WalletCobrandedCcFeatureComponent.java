package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/di/WalletCobrandedCcFeatureComponent;", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcFeatureApi;", "Factory", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationRemoteCoreLibApi.class, ObservabilityCoreLibApi.class, NetworkCoreLibApi.class, CustomerCoreLibApi.class}, modules = {WalletCobrandedCcFeatureModule.class})
public interface WalletCobrandedCcFeatureComponent extends WalletCobrandedCcFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/di/WalletCobrandedCcFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/walletcobrandedcc/data/di/WalletCobrandedCcFeatureComponent;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        WalletCobrandedCcFeatureComponent create(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi);
    }
}
