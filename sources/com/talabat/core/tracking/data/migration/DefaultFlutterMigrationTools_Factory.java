package com.talabat.core.tracking.data.migration;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultFlutterMigrationTools_Factory implements Factory<DefaultFlutterMigrationTools> {
    private final Provider<IObservabilityManager> observabilityProvider;
    private final Provider<IRemoteConfigurationDataSource> remoteConfigProvider;

    public DefaultFlutterMigrationTools_Factory(Provider<IObservabilityManager> provider, Provider<IRemoteConfigurationDataSource> provider2) {
        this.observabilityProvider = provider;
        this.remoteConfigProvider = provider2;
    }

    public static DefaultFlutterMigrationTools_Factory create(Provider<IObservabilityManager> provider, Provider<IRemoteConfigurationDataSource> provider2) {
        return new DefaultFlutterMigrationTools_Factory(provider, provider2);
    }

    public static DefaultFlutterMigrationTools newInstance(IObservabilityManager iObservabilityManager, IRemoteConfigurationDataSource iRemoteConfigurationDataSource) {
        return new DefaultFlutterMigrationTools(iObservabilityManager, iRemoteConfigurationDataSource);
    }

    public DefaultFlutterMigrationTools get() {
        return newInstance(this.observabilityProvider.get(), this.remoteConfigProvider.get());
    }
}
