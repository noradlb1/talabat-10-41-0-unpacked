package com.talabat.configuration.location;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.areas.Areas2Rest;
import com.talabat.configuration.areas.mapper.Area2Mapper;
import com.talabat.configuration.location.mapper.LocationConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.configuration.di.AreasRest"})
public final class RealLocationConfigurationRepository_Factory implements Factory<RealLocationConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<Area2Mapper> area2MapperProvider;
    private final Provider<Areas2Rest> areas2RestProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigMapper> mapperProvider;

    public RealLocationConfigurationRepository_Factory(Provider<AppInfoContainer> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigMapper> provider3, Provider<Areas2Rest> provider4, Provider<Area2Mapper> provider5) {
        this.appInfoContainerProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.mapperProvider = provider3;
        this.areas2RestProvider = provider4;
        this.area2MapperProvider = provider5;
    }

    public static RealLocationConfigurationRepository_Factory create(Provider<AppInfoContainer> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigMapper> provider3, Provider<Areas2Rest> provider4, Provider<Area2Mapper> provider5) {
        return new RealLocationConfigurationRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static RealLocationConfigurationRepository newInstance(AppInfoContainer appInfoContainer, ConfigurationLocalRepository configurationLocalRepository, LocationConfigMapper locationConfigMapper, Areas2Rest areas2Rest, Area2Mapper area2Mapper) {
        return new RealLocationConfigurationRepository(appInfoContainer, configurationLocalRepository, locationConfigMapper, areas2Rest, area2Mapper);
    }

    public RealLocationConfigurationRepository get() {
        return newInstance(this.appInfoContainerProvider.get(), this.configurationLocalRepositoryProvider.get(), this.mapperProvider.get(), this.areas2RestProvider.get(), this.area2MapperProvider.get());
    }
}
