package com.talabat.configuration.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.LegacyConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\b"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationLocalCoreLibModule;", "", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "real", "Lcom/talabat/configuration/LegacyConfigurationLocalRepository;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "com_talabat_core_configuration_local_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface ConfigurationLocalCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    ConfigurationLocalRepository configurationLocalRepository(@NotNull LegacyConfigurationLocalRepository legacyConfigurationLocalRepository);

    @NotNull
    @Binds
    @Reusable
    MutableConfigurationLocalRepository mutableConfigurationLocalRepository(@NotNull LegacyConfigurationLocalRepository legacyConfigurationLocalRepository);
}
