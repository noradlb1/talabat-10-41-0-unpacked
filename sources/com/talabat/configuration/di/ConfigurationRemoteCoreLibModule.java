package com.talabat.configuration.di;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.RealConfigurationRemoteRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibModule;", "", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "repository", "Lcom/talabat/configuration/RealConfigurationRemoteRepository;", "configurationRemoteRepository", "Lcom/talabat/configuration/ConfigurationRemoteRepository;", "real", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {ConfigurationRemoteNetworkModule.class, DiscoveryConfigurationRepositoryModule.class, LocationConfigurationRepositoryModule.class, OrderExperienceConfigurationRepositoryModule.class, PaymentConfigurationRepositoryModule.class, TermsAndConditionsConfigurationRepositoryModule.class})
public interface ConfigurationRemoteCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    AppInfoContainer appInfoContainer(@NotNull RealConfigurationRemoteRepository realConfigurationRemoteRepository);

    @NotNull
    @Binds
    @Reusable
    ConfigurationRemoteRepository configurationRemoteRepository(@NotNull RealConfigurationRemoteRepository realConfigurationRemoteRepository);

    @NotNull
    @Binds
    @Reusable
    MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository(@NotNull RealConfigurationRemoteRepository realConfigurationRemoteRepository);
}
