package com.talabat.talabatremoteconfiguration.di;

import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerRemoteConfigCoreLibComponent {

    public static final class Factory implements RemoteConfigCoreLibComponent.Factory {
        private Factory() {
        }

        public RemoteConfigCoreLibComponent create() {
            return new RemoteConfigCoreLibComponentImpl();
        }
    }

    public static final class RemoteConfigCoreLibComponentImpl implements RemoteConfigCoreLibComponent {
        private final RemoteConfigCoreLibComponentImpl remoteConfigCoreLibComponentImpl;
        private Provider<IRemoteConfigurationDataSource> remoteConfigurationDataSourceProvider;

        private RemoteConfigCoreLibComponentImpl() {
            this.remoteConfigCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.remoteConfigurationDataSourceProvider = SingleCheck.provider(RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory.create());
        }

        public IRemoteConfigurationDataSource getRemoteConfigurationDataSource() {
            return this.remoteConfigurationDataSourceProvider.get();
        }
    }

    private DaggerRemoteConfigCoreLibComponent() {
    }

    public static RemoteConfigCoreLibComponent create() {
        return new Factory().create();
    }

    public static RemoteConfigCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
