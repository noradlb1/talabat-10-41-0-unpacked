package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RequestAreasToCacheUseCaseImpl_Factory implements Factory<RequestAreasToCacheUseCaseImpl> {
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RequestAreasToCacheUseCaseImpl_Factory(Provider<MutableLocationConfigurationRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.mutableLocationConfigurationRepositoryProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static RequestAreasToCacheUseCaseImpl_Factory create(Provider<MutableLocationConfigurationRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new RequestAreasToCacheUseCaseImpl_Factory(provider, provider2);
    }

    public static RequestAreasToCacheUseCaseImpl newInstance(MutableLocationConfigurationRepository mutableLocationConfigurationRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new RequestAreasToCacheUseCaseImpl(mutableLocationConfigurationRepository, iTalabatFeatureFlag);
    }

    public RequestAreasToCacheUseCaseImpl get() {
        return newInstance(this.mutableLocationConfigurationRepositoryProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
