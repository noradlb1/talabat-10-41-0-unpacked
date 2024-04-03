package com.talabat.splash.core.di;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideTalabatRemoteConfigurationFactory implements Factory<RemoteConfiguration> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideTalabatRemoteConfigurationFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideTalabatRemoteConfigurationFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideTalabatRemoteConfigurationFactory(applicationModule);
    }

    public static RemoteConfiguration provideTalabatRemoteConfiguration(ApplicationModule applicationModule) {
        return (RemoteConfiguration) Preconditions.checkNotNullFromProvides(applicationModule.provideTalabatRemoteConfiguration());
    }

    public RemoteConfiguration get() {
        return provideTalabatRemoteConfiguration(this.module);
    }
}
