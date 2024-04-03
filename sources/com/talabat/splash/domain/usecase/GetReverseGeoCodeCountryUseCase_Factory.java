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
public final class GetReverseGeoCodeCountryUseCase_Factory implements Factory<GetReverseGeoCodeCountryUseCase> {
    private final Provider<ThirdPartyLibraryInfrastructure> thirdPartyLibraryInfrastructureProvider;

    public GetReverseGeoCodeCountryUseCase_Factory(Provider<ThirdPartyLibraryInfrastructure> provider) {
        this.thirdPartyLibraryInfrastructureProvider = provider;
    }

    public static GetReverseGeoCodeCountryUseCase_Factory create(Provider<ThirdPartyLibraryInfrastructure> provider) {
        return new GetReverseGeoCodeCountryUseCase_Factory(provider);
    }

    public static GetReverseGeoCodeCountryUseCase newInstance(ThirdPartyLibraryInfrastructure thirdPartyLibraryInfrastructure) {
        return new GetReverseGeoCodeCountryUseCase(thirdPartyLibraryInfrastructure);
    }

    public GetReverseGeoCodeCountryUseCase get() {
        return newInstance(this.thirdPartyLibraryInfrastructureProvider.get());
    }
}
