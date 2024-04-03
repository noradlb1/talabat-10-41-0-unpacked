package com.talabat.configuration.discovery;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.discovery.mapper.DiscoveryConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealDiscoveryConfigurationRepository_Factory implements Factory<RealDiscoveryConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<DiscoveryConfigMapper> mapperProvider;

    public RealDiscoveryConfigurationRepository_Factory(Provider<AppInfoContainer> provider, Provider<AppVersionProvider> provider2, Provider<DiscoveryConfigMapper> provider3) {
        this.appInfoContainerProvider = provider;
        this.appVersionProvider = provider2;
        this.mapperProvider = provider3;
    }

    public static RealDiscoveryConfigurationRepository_Factory create(Provider<AppInfoContainer> provider, Provider<AppVersionProvider> provider2, Provider<DiscoveryConfigMapper> provider3) {
        return new RealDiscoveryConfigurationRepository_Factory(provider, provider2, provider3);
    }

    public static RealDiscoveryConfigurationRepository newInstance(AppInfoContainer appInfoContainer, AppVersionProvider appVersionProvider2, DiscoveryConfigMapper discoveryConfigMapper) {
        return new RealDiscoveryConfigurationRepository(appInfoContainer, appVersionProvider2, discoveryConfigMapper);
    }

    public RealDiscoveryConfigurationRepository get() {
        return newInstance(this.appInfoContainerProvider.get(), this.appVersionProvider.get(), this.mapperProvider.get());
    }
}
