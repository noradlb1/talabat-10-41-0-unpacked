package com.talabat.configuration.orderexperience.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class OrderExperienceConfigMapper_Factory implements Factory<OrderExperienceConfigMapper> {
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public OrderExperienceConfigMapper_Factory(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        this.featureFlagsProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static OrderExperienceConfigMapper_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        return new OrderExperienceConfigMapper_Factory(provider, provider2);
    }

    public static OrderExperienceConfigMapper newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, LocationConfigurationRepository locationConfigurationRepository) {
        return new OrderExperienceConfigMapper(iTalabatFeatureFlag, locationConfigurationRepository);
    }

    public OrderExperienceConfigMapper get() {
        return newInstance(this.featureFlagsProvider.get(), this.locationConfigurationRepositoryProvider.get());
    }
}
