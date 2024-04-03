package com.talabat.splash.core.di;

import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructure;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideThirdPartyLibraryInfrastructureFactory implements Factory<ThirdPartyLibraryInfrastructure> {
    private final ApplicationModule module;
    private final Provider<ThirdPartyLibraryInfrastructureImpl> thirdPartyLibraryInfrastructureProvider;

    public ApplicationModule_ProvideThirdPartyLibraryInfrastructureFactory(ApplicationModule applicationModule, Provider<ThirdPartyLibraryInfrastructureImpl> provider) {
        this.module = applicationModule;
        this.thirdPartyLibraryInfrastructureProvider = provider;
    }

    public static ApplicationModule_ProvideThirdPartyLibraryInfrastructureFactory create(ApplicationModule applicationModule, Provider<ThirdPartyLibraryInfrastructureImpl> provider) {
        return new ApplicationModule_ProvideThirdPartyLibraryInfrastructureFactory(applicationModule, provider);
    }

    public static ThirdPartyLibraryInfrastructure provideThirdPartyLibraryInfrastructure(ApplicationModule applicationModule, ThirdPartyLibraryInfrastructureImpl thirdPartyLibraryInfrastructureImpl) {
        return (ThirdPartyLibraryInfrastructure) Preconditions.checkNotNullFromProvides(applicationModule.provideThirdPartyLibraryInfrastructure(thirdPartyLibraryInfrastructureImpl));
    }

    public ThirdPartyLibraryInfrastructure get() {
        return provideThirdPartyLibraryInfrastructure(this.module, this.thirdPartyLibraryInfrastructureProvider.get());
    }
}
