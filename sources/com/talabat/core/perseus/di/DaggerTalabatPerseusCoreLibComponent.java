package com.talabat.core.perseus.di;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.perseus.DefaultTalabatPerseusRepository;
import com.talabat.core.perseus.DefaultTalabatPerseusRepository_Factory;
import com.talabat.core.perseus.di.TalabatPerseusCoreLibComponent;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerTalabatPerseusCoreLibComponent {

    public static final class Factory implements TalabatPerseusCoreLibComponent.Factory {
        private Factory() {
        }

        public TalabatPerseusCoreLibComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new TalabatPerseusCoreLibComponentImpl(configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi);
        }
    }

    public static final class TalabatPerseusCoreLibComponentImpl implements TalabatPerseusCoreLibComponent {
        private Provider<DefaultTalabatPerseusRepository> defaultTalabatPerseusRepositoryProvider;
        private Provider<AppVersionProvider> getAppVersionProvider;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private final TalabatPerseusCoreLibComponentImpl talabatPerseusCoreLibComponentImpl;
        private Provider<TalabatPerseusRepository> talabatPerseusRepositoryProvider;

        public static final class GetAppVersionProviderProvider implements Provider<AppVersionProvider> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetAppVersionProviderProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public AppVersionProvider get() {
                return (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider());
            }
        }

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        private TalabatPerseusCoreLibComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.talabatPerseusCoreLibComponentImpl = this;
            initialize(configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi);
        }

        private void initialize(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            this.getAppVersionProvider = new GetAppVersionProviderProvider(configurationRemoteCoreLibApi);
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            DefaultTalabatPerseusRepository_Factory create = DefaultTalabatPerseusRepository_Factory.create(this.getContextProvider, this.getAppVersionProvider, getCoroutineDispatchersFactoryProvider2);
            this.defaultTalabatPerseusRepositoryProvider = create;
            this.talabatPerseusRepositoryProvider = SingleCheck.provider(create);
        }

        public TalabatPerseusRepository getTalabatPerseusRepository() {
            return this.talabatPerseusRepositoryProvider.get();
        }
    }

    private DaggerTalabatPerseusCoreLibComponent() {
    }

    public static TalabatPerseusCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
