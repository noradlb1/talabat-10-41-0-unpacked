package com.talabat.configuration.payment.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PaymentConfigMapper_Factory implements Factory<PaymentConfigMapper> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public PaymentConfigMapper_Factory(Provider<BaseUrlFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3) {
        this.baseUrlFactoryProvider = provider;
        this.featureFlagsProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
    }

    public static PaymentConfigMapper_Factory create(Provider<BaseUrlFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3) {
        return new PaymentConfigMapper_Factory(provider, provider2, provider3);
    }

    public static PaymentConfigMapper newInstance(BaseUrlFactory baseUrlFactory, ITalabatFeatureFlag iTalabatFeatureFlag, LocationConfigurationRepository locationConfigurationRepository) {
        return new PaymentConfigMapper(baseUrlFactory, iTalabatFeatureFlag, locationConfigurationRepository);
    }

    public PaymentConfigMapper get() {
        return newInstance(this.baseUrlFactoryProvider.get(), this.featureFlagsProvider.get(), this.locationConfigurationRepositoryProvider.get());
    }
}
