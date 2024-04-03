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
public final class GetOverdueNotificationAcknowledgeUseCaseImpl_Factory implements Factory<GetOverdueNotificationAcknowledgeUseCaseImpl> {
    private final Provider<BnplRepository> bnplRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public GetOverdueNotificationAcknowledgeUseCaseImpl_Factory(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.bnplRepositoryProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static GetOverdueNotificationAcknowledgeUseCaseImpl_Factory create(Provider<BnplRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new GetOverdueNotificationAcknowledgeUseCaseImpl_Factory(provider, provider2);
    }

    public static GetOverdueNotificationAcknowledgeUseCaseImpl newInstance(BnplRepository bnplRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetOverdueNotificationAcknowledgeUseCaseImpl(bnplRepository, iTalabatFeatureFlag);
    }

    public GetOverdueNotificationAcknowledgeUseCaseImpl get() {
        return newInstance(this.bnplRepositoryProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
