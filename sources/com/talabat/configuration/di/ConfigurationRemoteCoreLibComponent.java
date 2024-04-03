package com.talabat.configuration.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibComponent;", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "Factory", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ContextCoreLibApi.class, FeatureFlagCoreLibApi.class, NetworkCoreLibApi.class, ParserCoreLibApi.class}, modules = {ConfigurationRemoteCoreLibModule.class})
public interface ConfigurationRemoteCoreLibComponent extends MutableConfigurationRemoteCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibComponent$Factory;", "", "create", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ConfigurationRemoteCoreLibComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi);
    }
}
