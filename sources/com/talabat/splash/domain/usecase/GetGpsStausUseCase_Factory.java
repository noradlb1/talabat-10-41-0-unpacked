package com.talabat.splash.domain.usecase;

import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetGpsStausUseCase_Factory implements Factory<GetGpsStausUseCase> {
    private final Provider<CLInfrastrcture> clInfrastructureProvider;

    public GetGpsStausUseCase_Factory(Provider<CLInfrastrcture> provider) {
        this.clInfrastructureProvider = provider;
    }

    public static GetGpsStausUseCase_Factory create(Provider<CLInfrastrcture> provider) {
        return new GetGpsStausUseCase_Factory(provider);
    }

    public static GetGpsStausUseCase newInstance(CLInfrastrcture cLInfrastrcture) {
        return new GetGpsStausUseCase(cLInfrastrcture);
    }

    public GetGpsStausUseCase get() {
        return newInstance(this.clInfrastructureProvider.get());
    }
}
