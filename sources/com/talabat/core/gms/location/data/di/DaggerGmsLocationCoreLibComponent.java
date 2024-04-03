package com.talabat.core.gms.location.data.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.SettingsClient;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.gms.location.data.DefaultGmsLocationRepository;
import com.talabat.core.gms.location.data.DefaultGmsLocationRepository_Factory;
import com.talabat.core.gms.location.data.GmsFusedLocationProviderClient;
import com.talabat.core.gms.location.data.GmsFusedLocationProviderClient_Factory;
import com.talabat.core.gms.location.data.GmsLocationRequest;
import com.talabat.core.gms.location.data.GmsLocationRequest_Factory;
import com.talabat.core.gms.location.data.GmsLocationSettingsRequestBuilderWrapper;
import com.talabat.core.gms.location.data.GmsLocationSettingsRequestBuilderWrapper_Factory;
import com.talabat.core.gms.location.data.GmsSettingsClientWrapper;
import com.talabat.core.gms.location.data.GmsSettingsClientWrapper_Factory;
import com.talabat.core.gms.location.data.di.GmsLocationCoreLibComponent;
import com.talabat.core.gms.location.domain.GmsLocationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerGmsLocationCoreLibComponent {

    public static final class Factory implements GmsLocationCoreLibComponent.Factory {
        private Factory() {
        }

        public GmsLocationCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new GmsLocationCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class GmsLocationCoreLibComponentImpl implements GmsLocationCoreLibComponent {
        private Provider<DefaultGmsLocationRepository> defaultGmsLocationRepositoryProvider;
        private Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;
        private Provider<Context> getContextProvider;
        private Provider<GmsFusedLocationProviderClient> gmsFusedLocationProviderClientProvider;
        private final GmsLocationCoreLibComponentImpl gmsLocationCoreLibComponentImpl;
        private Provider<GmsLocationRepository> gmsLocationRepositoryProvider;
        private Provider<GmsLocationRequest> gmsLocationRequestProvider;
        private Provider<GmsLocationSettingsRequestBuilderWrapper> gmsLocationSettingsRequestBuilderWrapperProvider;
        private Provider<GmsSettingsClientWrapper> gmsSettingsClientWrapperProvider;
        private Provider<SettingsClient> settingsClientProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private GmsLocationCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.gmsLocationCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.gmsLocationRequestProvider = GmsLocationRequest_Factory.create(GmsGoogleModule_GoogleLocationRequestFactory.create());
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            GmsGoogleModule_FusedLocationProviderClientFactory create = GmsGoogleModule_FusedLocationProviderClientFactory.create(getContextProvider2);
            this.fusedLocationProviderClientProvider = create;
            this.gmsFusedLocationProviderClientProvider = GmsFusedLocationProviderClient_Factory.create(create);
            GmsGoogleModule_SettingsClientFactory create2 = GmsGoogleModule_SettingsClientFactory.create(this.getContextProvider);
            this.settingsClientProvider = create2;
            this.gmsSettingsClientWrapperProvider = GmsSettingsClientWrapper_Factory.create(create2);
            GmsLocationSettingsRequestBuilderWrapper_Factory create3 = GmsLocationSettingsRequestBuilderWrapper_Factory.create(GmsGoogleModule_LocationSettingsRequestBuilderFactory.create());
            this.gmsLocationSettingsRequestBuilderWrapperProvider = create3;
            DefaultGmsLocationRepository_Factory create4 = DefaultGmsLocationRepository_Factory.create(this.gmsLocationRequestProvider, this.gmsFusedLocationProviderClientProvider, this.gmsSettingsClientWrapperProvider, create3);
            this.defaultGmsLocationRepositoryProvider = create4;
            this.gmsLocationRepositoryProvider = SingleCheck.provider(create4);
        }

        public GmsLocationRepository getGmsLocationRepository() {
            return this.gmsLocationRepositoryProvider.get();
        }
    }

    private DaggerGmsLocationCoreLibComponent() {
    }

    public static GmsLocationCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
