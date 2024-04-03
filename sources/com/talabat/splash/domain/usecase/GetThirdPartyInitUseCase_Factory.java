package com.talabat.splash.domain.usecase;

import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructure;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetThirdPartyInitUseCase_Factory implements Factory<GetThirdPartyInitUseCase> {
    private final Provider<ThirdPartyLibraryInfrastructure> thirdPartyLibraryInfrastructureProvider;

    public GetThirdPartyInitUseCase_Factory(Provider<ThirdPartyLibraryInfrastructure> provider) {
        this.thirdPartyLibraryInfrastructureProvider = provider;
    }

    public static GetThirdPartyInitUseCase_Factory create(Provider<ThirdPartyLibraryInfrastructure> provider) {
        return new GetThirdPartyInitUseCase_Factory(provider);
    }

    public static GetThirdPartyInitUseCase newInstance(ThirdPartyLibraryInfrastructure thirdPartyLibraryInfrastructure) {
        return new GetThirdPartyInitUseCase(thirdPartyLibraryInfrastructure);
    }

    public GetThirdPartyInitUseCase get() {
        return newInstance(this.thirdPartyLibraryInfrastructureProvider.get());
    }
}
