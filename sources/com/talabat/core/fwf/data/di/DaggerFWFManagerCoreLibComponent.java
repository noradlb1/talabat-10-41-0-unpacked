package com.talabat.core.fwf.data.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.fwf.data.config.FWFManagerImpl;
import com.talabat.core.fwf.data.config.FWFManagerImpl_Factory;
import com.talabat.core.fwf.data.di.FWFManagerCoreLibComponent;
import com.talabat.core.fwf.domain.config.IFWFManager;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFWFManagerCoreLibComponent {

    public static final class FWFManagerCoreLibComponentImpl implements FWFManagerCoreLibComponent {
        private final FWFManagerCoreLibComponentImpl fWFManagerCoreLibComponentImpl;
        private Provider<FWFManagerImpl> fWFManagerImplProvider;
        private Provider<IFWFManager> fwfManagerProvider;
        private Provider<Context> getContextProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<Boolean> isGmsAvailableProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class IsGmsAvailableProvider implements Provider<Boolean> {
            private final GmsBaseCoreLibApi gmsBaseCoreLibApi;

            public IsGmsAvailableProvider(GmsBaseCoreLibApi gmsBaseCoreLibApi2) {
                this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.gmsBaseCoreLibApi.isGmsAvailable());
            }
        }

        private FWFManagerCoreLibComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi) {
            this.fWFManagerCoreLibComponentImpl = this;
            initialize(configurationLocalCoreLibApi, contextCoreLibApi, gmsBaseCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            IsGmsAvailableProvider isGmsAvailableProvider2 = new IsGmsAvailableProvider(gmsBaseCoreLibApi);
            this.isGmsAvailableProvider = isGmsAvailableProvider2;
            FWFManagerImpl_Factory create = FWFManagerImpl_Factory.create(this.getContextProvider, this.getRepositoryProvider, isGmsAvailableProvider2);
            this.fWFManagerImplProvider = create;
            this.fwfManagerProvider = SingleCheck.provider(create);
        }

        public IFWFManager getFwfManager() {
            return this.fwfManagerProvider.get();
        }
    }

    public static final class Factory implements FWFManagerCoreLibComponent.Factory {
        private Factory() {
        }

        public FWFManagerCoreLibComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            return new FWFManagerCoreLibComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, gmsBaseCoreLibApi);
        }
    }

    private DaggerFWFManagerCoreLibComponent() {
    }

    public static FWFManagerCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
