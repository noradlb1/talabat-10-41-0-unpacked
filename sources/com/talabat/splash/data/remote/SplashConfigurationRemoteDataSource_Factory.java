package com.talabat.splash.data.remote;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SplashConfigurationRemoteDataSource_Factory implements Factory<SplashConfigurationRemoteDataSource> {
    private final Provider<RemoteConfiguration> configurationProvider;

    public SplashConfigurationRemoteDataSource_Factory(Provider<RemoteConfiguration> provider) {
        this.configurationProvider = provider;
    }

    public static SplashConfigurationRemoteDataSource_Factory create(Provider<RemoteConfiguration> provider) {
        return new SplashConfigurationRemoteDataSource_Factory(provider);
    }

    public static SplashConfigurationRemoteDataSource newInstance(RemoteConfiguration remoteConfiguration) {
        return new SplashConfigurationRemoteDataSource(remoteConfiguration);
    }

    public SplashConfigurationRemoteDataSource get() {
        return newInstance(this.configurationProvider.get());
    }
}
