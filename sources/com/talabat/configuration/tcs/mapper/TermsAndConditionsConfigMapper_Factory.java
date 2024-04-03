package com.talabat.configuration.tcs.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TermsAndConditionsConfigMapper_Factory implements Factory<TermsAndConditionsConfigMapper> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public TermsAndConditionsConfigMapper_Factory(Provider<BaseUrlFactory> provider, Provider<LocationConfigurationRepository> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static TermsAndConditionsConfigMapper_Factory create(Provider<BaseUrlFactory> provider, Provider<LocationConfigurationRepository> provider2) {
        return new TermsAndConditionsConfigMapper_Factory(provider, provider2);
    }

    public static TermsAndConditionsConfigMapper newInstance(BaseUrlFactory baseUrlFactory, LocationConfigurationRepository locationConfigurationRepository) {
        return new TermsAndConditionsConfigMapper(baseUrlFactory, locationConfigurationRepository);
    }

    public TermsAndConditionsConfigMapper get() {
        return newInstance(this.baseUrlFactoryProvider.get(), this.locationConfigurationRepositoryProvider.get());
    }
}
