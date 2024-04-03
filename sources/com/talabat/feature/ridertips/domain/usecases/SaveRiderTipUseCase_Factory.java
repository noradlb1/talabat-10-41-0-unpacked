package com.talabat.feature.ridertips.domain.usecases;

import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SaveRiderTipUseCase_Factory implements Factory<SaveRiderTipUseCase> {
    private final Provider<IRiderTipRepository> repositoryProvider;
    private final Provider<IRiderTipObservability> riderTipObservabilityProvider;

    public SaveRiderTipUseCase_Factory(Provider<IRiderTipRepository> provider, Provider<IRiderTipObservability> provider2) {
        this.repositoryProvider = provider;
        this.riderTipObservabilityProvider = provider2;
    }

    public static SaveRiderTipUseCase_Factory create(Provider<IRiderTipRepository> provider, Provider<IRiderTipObservability> provider2) {
        return new SaveRiderTipUseCase_Factory(provider, provider2);
    }

    public static SaveRiderTipUseCase newInstance(IRiderTipRepository iRiderTipRepository, IRiderTipObservability iRiderTipObservability) {
        return new SaveRiderTipUseCase(iRiderTipRepository, iRiderTipObservability);
    }

    public SaveRiderTipUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.riderTipObservabilityProvider.get());
    }
}
