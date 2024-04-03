package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.darkstores.swimlanes.data.RealSwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.data.RealSwimlanesRepository_Factory;
import com.talabat.feature.darkstores.swimlanes.data.di.SwimlanesFeatureComponent;
import com.talabat.feature.darkstores.swimlanes.data.remote.GroceryBaseUrl_Factory;
import com.talabat.feature.darkstores.swimlanes.data.remote.SwimlanesApi;
import com.talabat.feature.darkstores.swimlanes.data.remote.mapper.SwimlanesMapper_Factory;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerSwimlanesFeatureComponent {

    public static final class Factory implements SwimlanesFeatureComponent.Factory {
        private Factory() {
        }

        public SwimlanesFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new SwimlanesFeatureComponentImpl(configurationLocalCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class SwimlanesFeatureComponentImpl implements SwimlanesFeatureComponent {
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<SwimlanesApi> provideSiwmlanesApiProvider;
        private Provider<Country> provideSleectedCountryProvider;
        private Provider<RealSwimlanesRepository> realSwimlanesRepositoryProvider;
        private final SwimlanesFeatureComponentImpl swimlanesFeatureComponentImpl;
        private Provider<SwimlanesRepository> swimlanesRepositoryProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetOkHttpClientProvider implements Provider<OkHttpClient> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetOkHttpClientProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public OkHttpClient get() {
                return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient());
            }
        }

        public static final class GetRetrofitWithMoshiProvider implements Provider<Retrofit.Builder> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetRetrofitWithMoshiProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public Retrofit.Builder get() {
                return (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi());
            }
        }

        public static final class GetRxSchedulersFactoryProvider implements Provider<RxSchedulersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetRxSchedulersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public RxSchedulersFactory get() {
                return (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private SwimlanesFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.swimlanesFeatureComponentImpl = this;
            initialize(configurationLocalCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            dagger.internal.Factory create = InstanceFactory.create(configurationLocalCoreLibApi);
            this.configurationLocalCoreLibApiProvider = create;
            this.provideSleectedCountryProvider = SwimlanesUserDataModule_ProvideSleectedCountryFactory.create(create);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideBaseUrlProvider = SwimlanesNetworkModule_ProvideBaseUrlFactory.create(getBaseUrlFactoryProvider2, GroceryBaseUrl_Factory.create());
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetRetrofitWithMoshiProvider getRetrofitWithMoshiProvider2 = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = getRetrofitWithMoshiProvider2;
            this.provideSiwmlanesApiProvider = SwimlanesNetworkModule_ProvideSiwmlanesApiFactory.create(this.provideBaseUrlProvider, this.getOkHttpClientProvider, getRetrofitWithMoshiProvider2);
            this.getRxSchedulersFactoryProvider = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            RealSwimlanesRepository_Factory create2 = RealSwimlanesRepository_Factory.create(this.provideSleectedCountryProvider, this.provideSiwmlanesApiProvider, this.getRxSchedulersFactoryProvider, SwimlanesMapper_Factory.create(), this.getTalabatFeatureFlagProvider, this.getObservabilityManagerProvider);
            this.realSwimlanesRepositoryProvider = create2;
            this.swimlanesRepositoryProvider = SingleCheck.provider(create2);
        }

        public SwimlanesRepository getRepository() {
            return this.swimlanesRepositoryProvider.get();
        }
    }

    private DaggerSwimlanesFeatureComponent() {
    }

    public static SwimlanesFeatureComponent.Factory factory() {
        return new Factory();
    }
}
