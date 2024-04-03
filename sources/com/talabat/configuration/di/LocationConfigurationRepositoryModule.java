package com.talabat.configuration.di;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.location.LegacyLocationConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\b"}, d2 = {"Lcom/talabat/configuration/di/LocationConfigurationRepositoryModule;", "", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "impl", "Lcom/talabat/configuration/location/LegacyLocationConfigurationRepository;", "mutableLocationConfigRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Areas2NetworkModule.class})
public interface LocationConfigurationRepositoryModule {
    @NotNull
    @Binds
    @Reusable
    LocationConfigurationRepository locationConfigRepository(@NotNull LegacyLocationConfigurationRepository legacyLocationConfigurationRepository);

    @NotNull
    @Binds
    @Reusable
    MutableLocationConfigurationRepository mutableLocationConfigRepository(@NotNull LegacyLocationConfigurationRepository legacyLocationConfigurationRepository);
}
