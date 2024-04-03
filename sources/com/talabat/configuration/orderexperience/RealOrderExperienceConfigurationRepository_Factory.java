package com.talabat.configuration.orderexperience;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.orderexperience.mapper.OrderExperienceConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealOrderExperienceConfigurationRepository_Factory implements Factory<RealOrderExperienceConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<OrderExperienceConfigMapper> mapperProvider;

    public RealOrderExperienceConfigurationRepository_Factory(Provider<AppInfoContainer> provider, Provider<OrderExperienceConfigMapper> provider2) {
        this.appInfoContainerProvider = provider;
        this.mapperProvider = provider2;
    }

    public static RealOrderExperienceConfigurationRepository_Factory create(Provider<AppInfoContainer> provider, Provider<OrderExperienceConfigMapper> provider2) {
        return new RealOrderExperienceConfigurationRepository_Factory(provider, provider2);
    }

    public static RealOrderExperienceConfigurationRepository newInstance(AppInfoContainer appInfoContainer, OrderExperienceConfigMapper orderExperienceConfigMapper) {
        return new RealOrderExperienceConfigurationRepository(appInfoContainer, orderExperienceConfigMapper);
    }

    public RealOrderExperienceConfigurationRepository get() {
        return newInstance(this.appInfoContainerProvider.get(), this.mapperProvider.get());
    }
}
