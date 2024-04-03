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
public final class UpdateOverdueAcknowledgeStateUseCaseImpl_Factory implements Factory<UpdateOverdueAcknowledgeStateUseCaseImpl> {
    private final Provider<BnplRepository> bnplRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public UpdateOverdueAcknowledgeStateUseCaseImpl_Factory(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.bnplRepositoryProvider = provider;
        this.featureFlagProvider = provider2;
    }

    public static UpdateOverdueAcknowledgeStateUseCaseImpl_Factory create(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new UpdateOverdueAcknowledgeStateUseCaseImpl_Factory(provider, provider2);
    }

    public static UpdateOverdueAcknowledgeStateUseCaseImpl newInstance(BnplRepository bnplRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new UpdateOverdueAcknowledgeStateUseCaseImpl(bnplRepository, iTalabatFeatureFlag);
    }

    public UpdateOverdueAcknowledgeStateUseCaseImpl get() {
        return newInstance(this.bnplRepositoryProvider.get(), this.featureFlagProvider.get());
    }
}
