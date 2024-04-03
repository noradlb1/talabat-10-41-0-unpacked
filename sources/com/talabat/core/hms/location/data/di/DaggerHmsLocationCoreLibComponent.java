package com.talabat.core.hms.location.data.di;

import android.content.Context;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.SettingsClient;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.hms.location.data.DefaultHmsLocationRepository;
import com.talabat.core.hms.location.data.DefaultHmsLocationRepository_Factory;
import com.talabat.core.hms.location.data.HmsFusedLocationProviderClient;
import com.talabat.core.hms.location.data.HmsFusedLocationProviderClient_Factory;
import com.talabat.core.hms.location.data.HmsLocationRequest;
import com.talabat.core.hms.location.data.HmsLocationRequest_Factory;
import com.talabat.core.hms.location.data.HmsLocationSettingsRequestBuilderWrapper;
import com.talabat.core.hms.location.data.HmsLocationSettingsRequestBuilderWrapper_Factory;
import com.talabat.core.hms.location.data.HmsSettingsClientWrapper;
import com.talabat.core.hms.location.data.HmsSettingsClientWrapper_Factory;
import com.talabat.core.hms.location.data.di.HmsLocationCoreLibComponent;
import com.talabat.core.hms.location.domain.HmsLocationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerHmsLocationCoreLibComponent {

    public static final class Factory implements HmsLocationCoreLibComponent.Factory {
        private Factory() {
        }

        public HmsLocationCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new HmsLocationCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class HmsLocationCoreLibComponentImpl implements HmsLocationCoreLibComponent {
        private Provider<DefaultHmsLocationRepository> defaultHmsLocationRepositoryProvider;
        private Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;
        private Provider<Context> getContextProvider;
        private Provider<HmsFusedLocationProviderClient> hmsFusedLocationProviderClientProvider;
        private final HmsLocationCoreLibComponentImpl hmsLocationCoreLibComponentImpl;
        private Provider<HmsLocationRepository> hmsLocationRepositoryProvider;
        private Provider<HmsLocationRequest> hmsLocationRequestProvider;
        private Provider<HmsLocationSettingsRequestBuilderWrapper> hmsLocationSettingsRequestBuilderWrapperProvider;
        private Provider<HmsSettingsClientWrapper> hmsSettingsClientWrapperProvider;
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

        private HmsLocationCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.hmsLocationCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.hmsLocationRequestProvider = HmsLocationRequest_Factory.create(HuaweiModule_HuaweiLocationRequestFactory.create());
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            HuaweiModule_FusedLocationProviderClientFactory create = HuaweiModule_FusedLocationProviderClientFactory.create(getContextProvider2);
            this.fusedLocationProviderClientProvider = create;
            this.hmsFusedLocationProviderClientProvider = HmsFusedLocationProviderClient_Factory.create(create);
            HuaweiModule_SettingsClientFactory create2 = HuaweiModule_SettingsClientFactory.create(this.getContextProvider);
            this.settingsClientProvider = create2;
            this.hmsSettingsClientWrapperProvider = HmsSettingsClientWrapper_Factory.create(create2);
            HmsLocationSettingsRequestBuilderWrapper_Factory create3 = HmsLocationSettingsRequestBuilderWrapper_Factory.create(HuaweiModule_LocationSettingsRequestBuilderFactory.create());
            this.hmsLocationSettingsRequestBuilderWrapperProvider = create3;
            DefaultHmsLocationRepository_Factory create4 = DefaultHmsLocationRepository_Factory.create(this.hmsLocationRequestProvider, this.hmsFusedLocationProviderClientProvider, this.hmsSettingsClientWrapperProvider, create3);
            this.defaultHmsLocationRepositoryProvider = create4;
            this.hmsLocationRepositoryProvider = SingleCheck.provider(create4);
        }

        public HmsLocationRepository getHmsLocationRepository() {
            return this.hmsLocationRepositoryProvider.get();
        }
    }

    private DaggerHmsLocationCoreLibComponent() {
    }

    public static HmsLocationCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
