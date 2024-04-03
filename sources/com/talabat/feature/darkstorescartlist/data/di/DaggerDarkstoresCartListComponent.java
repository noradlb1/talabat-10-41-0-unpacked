package com.talabat.feature.darkstorescartlist.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.darkstorescartlist.data.di.DarkstoresCartListComponent;
import com.talabat.feature.darkstorescartlist.data.local.CartListLocalDataSource;
import com.talabat.feature.darkstorescartlist.data.local.CartListLocalDataSource_Factory;
import com.talabat.feature.darkstorescartlist.data.mapper.CartInfoResponseMapper_Factory;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.data.remote.CartListApi;
import com.talabat.feature.darkstorescartlist.data.remote.CartListBaseUrl_Factory;
import com.talabat.feature.darkstorescartlist.data.remote.RestaurantJsonAdapter;
import com.talabat.feature.darkstorescartlist.data.remote.RestaurantJsonAdapter_Factory;
import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl_Factory;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketCommunicationExperimentEnabledUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCaseImpl;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerDarkstoresCartListComponent {

    public static final class DarkstoresCartListComponentImpl implements DarkstoresCartListComponent {
        private Provider<CartListLocalDataSource> cartListLocalDataSourceProvider;
        private Provider<Set<Interceptor>> cartListSetOfInterceptorProvider;
        private final DarkstoresCartListComponentImpl darkstoresCartListComponentImpl;
        private Provider<DarkstoresCartListRepositoryImpl> darkstoresCartListRepositoryImplProvider;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private Provider<AppVersionProvider> getAppVersionProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<Moshi> getMoshiProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<Interceptor> provideAuthInterceptorProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<ModelMapper<CartInfoResponse, CartInfo>> provideCartInfoResponseMapperProvider;
        private Provider<CartListApi> provideCartListApiProvider;
        private Provider<DarkstoresCartListRepository> provideCartListRepositoryProvider;
        private Provider<IntegrationGlobalDataModel.Companion> provideIntegrationGlobalDataModelProvider;
        private Provider<Moshi> provideMoshiProvider;
        private Provider<OkHttpClient> provideOkHttpClientProvider;
        private Provider<Retrofit> provideRetrofitProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<RestaurantJsonAdapter> restaurantJsonAdapterProvider;

        public static final class GetAppVersionProviderProvider implements Provider<AppVersionProvider> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetAppVersionProviderProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public AppVersionProvider get() {
                return (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider());
            }
        }

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        public static final class GetGsonProvider implements Provider<Gson> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetGsonProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson());
            }
        }

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
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

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
            }
        }

        private DarkstoresCartListComponentImpl(CartListDataModule cartListDataModule, CartListNetworkModule cartListNetworkModule, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.darkstoresCartListComponentImpl = this;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            initialize(cartListDataModule, cartListNetworkModule, configurationRemoteCoreLibApi, contextCoreLibApi, experimentCoreLibApi2, networkCoreLibApi, observabilityCoreLibApi, parserCoreLibApi, secretCoreLibApi);
        }

        private GetCartListToastUseCaseImpl getCartListToastUseCaseImpl() {
            return new GetCartListToastUseCaseImpl(isMultiBasketEnabledUseCaseImpl(), this.provideCartListRepositoryProvider.get(), isMultiBasketCommunicationExperimentEnabledUseCaseImpl());
        }

        private void initialize(CartListDataModule cartListDataModule, CartListNetworkModule cartListNetworkModule, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.provideIntegrationGlobalDataModelProvider = CartListDataModule_ProvideIntegrationGlobalDataModelFactory.create(cartListDataModule);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            this.provideAuthInterceptorProvider = CartListNetworkModule_ProvideAuthInterceptorFactory.create(cartListNetworkModule, getSecretProviderProvider);
            SetFactory<Interceptor> build = SetFactory.builder(1, 0).addProvider(this.provideAuthInterceptorProvider).build();
            this.cartListSetOfInterceptorProvider = build;
            this.provideOkHttpClientProvider = CartListNetworkModule_ProvideOkHttpClientFactory.create(cartListNetworkModule, this.getOkHttpClientProvider, build);
            this.getMoshiProvider = new GetMoshiProvider(parserCoreLibApi);
            GetGsonProvider getGsonProvider2 = new GetGsonProvider(parserCoreLibApi);
            this.getGsonProvider = getGsonProvider2;
            RestaurantJsonAdapter_Factory create = RestaurantJsonAdapter_Factory.create(getGsonProvider2);
            this.restaurantJsonAdapterProvider = create;
            this.provideMoshiProvider = CartListNetworkModule_ProvideMoshiFactory.create(cartListNetworkModule, this.getMoshiProvider, create);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            CartListNetworkModule_ProvideBaseUrlFactory create2 = CartListNetworkModule_ProvideBaseUrlFactory.create(cartListNetworkModule, getBaseUrlFactoryProvider2, CartListBaseUrl_Factory.create());
            this.provideBaseUrlProvider = create2;
            CartListNetworkModule_ProvideRetrofitFactory create3 = CartListNetworkModule_ProvideRetrofitFactory.create(cartListNetworkModule, this.provideOkHttpClientProvider, this.provideMoshiProvider, create2);
            this.provideRetrofitProvider = create3;
            this.provideCartListApiProvider = CartListNetworkModule_ProvideCartListApiFactory.create(cartListNetworkModule, create3);
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            CartListDataModule_ProvideSharedPreferencesFactory create4 = CartListDataModule_ProvideSharedPreferencesFactory.create(cartListDataModule, getContextProvider2);
            this.provideSharedPreferencesProvider = create4;
            this.cartListLocalDataSourceProvider = CartListLocalDataSource_Factory.create(create4);
            this.provideCartInfoResponseMapperProvider = CartListDataModule_ProvideCartInfoResponseMapperFactory.create(cartListDataModule, CartInfoResponseMapper_Factory.create());
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            GetAppVersionProviderProvider getAppVersionProviderProvider = new GetAppVersionProviderProvider(configurationRemoteCoreLibApi);
            this.getAppVersionProvider = getAppVersionProviderProvider;
            DarkstoresCartListRepositoryImpl_Factory create5 = DarkstoresCartListRepositoryImpl_Factory.create(this.provideIntegrationGlobalDataModelProvider, this.provideCartListApiProvider, this.cartListLocalDataSourceProvider, this.provideCartInfoResponseMapperProvider, this.getObservabilityManagerProvider, getAppVersionProviderProvider);
            this.darkstoresCartListRepositoryImplProvider = create5;
            this.provideCartListRepositoryProvider = SingleCheck.provider(CartListDataModule_ProvideCartListRepositoryFactory.create(cartListDataModule, create5));
        }

        private InvalidateCartListCacheUseCaseImpl invalidateCartListCacheUseCaseImpl() {
            return new InvalidateCartListCacheUseCaseImpl(this.provideCartListRepositoryProvider.get());
        }

        private IsMultiBasketCommunicationExperimentEnabledUseCaseImpl isMultiBasketCommunicationExperimentEnabledUseCaseImpl() {
            return new IsMultiBasketCommunicationExperimentEnabledUseCaseImpl((ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
        }

        private IsMultiBasketEnabledUseCaseImpl isMultiBasketEnabledUseCaseImpl() {
            return new IsMultiBasketEnabledUseCaseImpl((ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
        }

        public DarkstoresCartListRepository cartListRepository() {
            return this.provideCartListRepositoryProvider.get();
        }

        public GetCartListToastUseCase getCartListToastUseCase() {
            return getCartListToastUseCaseImpl();
        }

        public InvalidateCartListCacheUseCase invalidateCartListCacheUseCase() {
            return invalidateCartListCacheUseCaseImpl();
        }

        public IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase() {
            return isMultiBasketEnabledUseCaseImpl();
        }
    }

    public static final class Factory implements DarkstoresCartListComponent.Factory {
        private Factory() {
        }

        public DarkstoresCartListComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new DarkstoresCartListComponentImpl(new CartListDataModule(), new CartListNetworkModule(), configurationRemoteCoreLibApi, contextCoreLibApi, experimentCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, parserCoreLibApi, secretCoreLibApi);
        }
    }

    private DaggerDarkstoresCartListComponent() {
    }

    public static DarkstoresCartListComponent.Factory factory() {
        return new Factory();
    }
}
