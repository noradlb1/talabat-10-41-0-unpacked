package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetOverdueUseCaseImpl_Factory implements Factory<GetOverdueUseCaseImpl> {
    private final Provider<BnplRepository> bnplRepoProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public GetOverdueUseCaseImpl_Factory(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.bnplRepoProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static GetOverdueUseCaseImpl_Factory create(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new GetOverdueUseCaseImpl_Factory(provider, provider2);
    }

    public static GetOverdueUseCaseImpl newInstance(BnplRepository bnplRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetOverdueUseCaseImpl(bnplRepository, iTalabatFeatureFlag);
    }

    public GetOverdueUseCaseImpl get() {
        return newInstance(this.bnplRepoProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
