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
public final class GetLocationPermissionStatusUseCase_Factory implements Factory<GetLocationPermissionStatusUseCase> {
    private final Provider<CLInfrastrcture> clInfrastructureProvider;

    public GetLocationPermissionStatusUseCase_Factory(Provider<CLInfrastrcture> provider) {
        this.clInfrastructureProvider = provider;
    }

    public static GetLocationPermissionStatusUseCase_Factory create(Provider<CLInfrastrcture> provider) {
        return new GetLocationPermissionStatusUseCase_Factory(provider);
    }

    public static GetLocationPermissionStatusUseCase newInstance(CLInfrastrcture cLInfrastrcture) {
        return new GetLocationPermissionStatusUseCase(cLInfrastrcture);
    }

    public GetLocationPermissionStatusUseCase get() {
        return newInstance(this.clInfrastructureProvider.get());
    }
}
