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
public final class GetCurrentLocationUseCase_Factory implements Factory<GetCurrentLocationUseCase> {
    private final Provider<CLInfrastrcture> clInfrastructureProvider;

    public GetCurrentLocationUseCase_Factory(Provider<CLInfrastrcture> provider) {
        this.clInfrastructureProvider = provider;
    }

    public static GetCurrentLocationUseCase_Factory create(Provider<CLInfrastrcture> provider) {
        return new GetCurrentLocationUseCase_Factory(provider);
    }

    public static GetCurrentLocationUseCase newInstance(CLInfrastrcture cLInfrastrcture) {
        return new GetCurrentLocationUseCase(cLInfrastrcture);
    }

    public GetCurrentLocationUseCase get() {
        return newInstance(this.clInfrastructureProvider.get());
    }
}
