package com.talabat.talabatremoteconfiguration.datasource.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeRemoteConfigurationDataSource_Factory implements Factory<FakeRemoteConfigurationDataSource> {
    private final Provider<IFunWithFlags> fwfProvider;

    public FakeRemoteConfigurationDataSource_Factory(Provider<IFunWithFlags> provider) {
        this.fwfProvider = provider;
    }

    public static FakeRemoteConfigurationDataSource_Factory create(Provider<IFunWithFlags> provider) {
        return new FakeRemoteConfigurationDataSource_Factory(provider);
    }

    public static FakeRemoteConfigurationDataSource newInstance(IFunWithFlags iFunWithFlags) {
        return new FakeRemoteConfigurationDataSource(iFunWithFlags);
    }

    public FakeRemoteConfigurationDataSource get() {
        return newInstance(this.fwfProvider.get());
    }
}
