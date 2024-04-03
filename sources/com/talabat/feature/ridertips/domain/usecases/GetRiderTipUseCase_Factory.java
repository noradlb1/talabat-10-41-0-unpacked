package com.talabat.feature.ridertips.domain.usecases;

import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetRiderTipUseCase_Factory implements Factory<GetRiderTipUseCase> {
    private final Provider<IRiderTipRepository> repositoryProvider;

    public GetRiderTipUseCase_Factory(Provider<IRiderTipRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetRiderTipUseCase_Factory create(Provider<IRiderTipRepository> provider) {
        return new GetRiderTipUseCase_Factory(provider);
    }

    public static GetRiderTipUseCase newInstance(IRiderTipRepository iRiderTipRepository) {
        return new GetRiderTipUseCase(iRiderTipRepository);
    }

    public GetRiderTipUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
