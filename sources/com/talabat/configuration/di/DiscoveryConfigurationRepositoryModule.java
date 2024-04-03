package com.talabat.configuration.di;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.discovery.RealAppVersionProvider;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/configuration/di/DiscoveryConfigurationRepositoryModule;", "", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "real", "Lcom/talabat/configuration/discovery/RealAppVersionProvider;", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "Lcom/talabat/configuration/discovery/RealDiscoveryConfigurationRepository;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DiscoveryConfigurationRepositoryModule {
    @NotNull
    @Binds
    @Reusable
    AppVersionProvider appVersionProvider(@NotNull RealAppVersionProvider realAppVersionProvider);

    @NotNull
    @Binds
    @Reusable
    DiscoveryConfigurationRepository discoveryConfigurationRepository(@NotNull RealDiscoveryConfigurationRepository realDiscoveryConfigurationRepository);
}
