package com.talabat.talabatremoteconfiguration.di.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class FakeRemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory implements Factory<IRemoteConfigurationDataSource> {
    private final Provider<IFunWithFlags> fwfProvider;

    public FakeRemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory(Provider<IFunWithFlags> provider) {
        this.fwfProvider = provider;
    }

    public static FakeRemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory create(Provider<IFunWithFlags> provider) {
        return new FakeRemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory(provider);
    }

    public static IRemoteConfigurationDataSource remoteConfigurationDataSource(IFunWithFlags iFunWithFlags) {
        return (IRemoteConfigurationDataSource) Preconditions.checkNotNullFromProvides(FakeRemoteConfigCoreLibModule.INSTANCE.remoteConfigurationDataSource(iFunWithFlags));
    }

    public IRemoteConfigurationDataSource get() {
        return remoteConfigurationDataSource(this.fwfProvider.get());
    }
}
