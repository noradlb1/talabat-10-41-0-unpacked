package com.talabat.splash.core.di;

import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastructureImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideCLRepositoryFactory implements Factory<CLInfrastrcture> {
    private final Provider<CLInfrastructureImpl> clRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideCLRepositoryFactory(ApplicationModule applicationModule, Provider<CLInfrastructureImpl> provider) {
        this.module = applicationModule;
        this.clRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvideCLRepositoryFactory create(ApplicationModule applicationModule, Provider<CLInfrastructureImpl> provider) {
        return new ApplicationModule_ProvideCLRepositoryFactory(applicationModule, provider);
    }

    public static CLInfrastrcture provideCLRepository(ApplicationModule applicationModule, CLInfrastructureImpl cLInfrastructureImpl) {
        return (CLInfrastrcture) Preconditions.checkNotNullFromProvides(applicationModule.provideCLRepository(cLInfrastructureImpl));
    }

    public CLInfrastrcture get() {
        return provideCLRepository(this.module, this.clRepositoryProvider.get());
    }
}
