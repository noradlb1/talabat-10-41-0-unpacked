package com.talabat.talabatremoteconfiguration.di.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.di.fake.FakeRemoteConfigCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFakeRemoteConfigCoreLibComponent {

    public static final class Factory implements FakeRemoteConfigCoreLibComponent.Factory {
        private Factory() {
        }

        public FakeRemoteConfigCoreLibComponent create(IFunWithFlags iFunWithFlags) {
            Preconditions.checkNotNull(iFunWithFlags);
            return new FakeRemoteConfigCoreLibComponentImpl(iFunWithFlags);
        }
    }

    public static final class FakeRemoteConfigCoreLibComponentImpl implements FakeRemoteConfigCoreLibComponent {
        private final FakeRemoteConfigCoreLibComponentImpl fakeRemoteConfigCoreLibComponentImpl;
        private Provider<IFunWithFlags> fwfProvider;
        private Provider<IRemoteConfigurationDataSource> remoteConfigurationDataSourceProvider;

        private FakeRemoteConfigCoreLibComponentImpl(IFunWithFlags iFunWithFlags) {
            this.fakeRemoteConfigCoreLibComponentImpl = this;
            initialize(iFunWithFlags);
        }

        private void initialize(IFunWithFlags iFunWithFlags) {
            dagger.internal.Factory create = InstanceFactory.create(iFunWithFlags);
            this.fwfProvider = create;
            this.remoteConfigurationDataSourceProvider = SingleCheck.provider(FakeRemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory.create(create));
        }

        public IRemoteConfigurationDataSource getRemoteConfigurationDataSource() {
            return this.remoteConfigurationDataSourceProvider.get();
        }
    }

    private DaggerFakeRemoteConfigCoreLibComponent() {
    }

    public static FakeRemoteConfigCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
