package com.talabat.talabatremoteconfiguration.di;

import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory implements Factory<IRemoteConfigurationDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory INSTANCE = new RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory();

        private InstanceHolder() {
        }
    }

    public static RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IRemoteConfigurationDataSource remoteConfigurationDataSource() {
        return (IRemoteConfigurationDataSource) Preconditions.checkNotNullFromProvides(RemoteConfigCoreLibModule.INSTANCE.remoteConfigurationDataSource());
    }

    public IRemoteConfigurationDataSource get() {
        return remoteConfigurationDataSource();
    }
}
