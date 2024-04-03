package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.talabat.feature.darkstoresvendor.data.di.DarkstoresVendorComponent;
import com.talabat.feature.darkstoresvendor.data.local.VendorCache_Factory;
import com.talabat.feature.darkstoresvendor.data.mapper.VendorResponseMapper_Factory;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityApi;
import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl;
import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl_Factory;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.feature.darkstoresvendor.domain.usecase.GetVendorUseCase;
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
public final class DaggerDarkstoresVendorComponent {

    public static final class DarkstoresVendorComponentImpl implements DarkstoresVendorComponent {
        private Provider<VendorRepository> bindsVendorRepositoryProvider;
        private Provider<ModelMapper<VendorResponse, Vendor>> bindsVendorResponseMapperProvider;
        private final DarkstoresVendorComponentImpl darkstoresVendorComponentImpl;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<Set<Interceptor>> groceryAffordabilitySetOfInterceptorProvider;
        private Provider<Interceptor> provideAuthInterceptorProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<GroceryAffordabilityApi> provideGroceryAffordabilityApiProvider;
        private Provider<IBaseUrl> provideGroceryAffordabilityBaseUrlProvider;
        private Provider<OkHttpClient> provideOkHttpClientProvider;
        private Provider<Retrofit> provideRetrofitProvider;
        private Provider<VendorRepositoryImpl> vendorRepositoryImplProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
            }
        }

        private DarkstoresVendorComponentImpl(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.darkstoresVendorComponentImpl = this;
            initialize(groceryAffordabilityNetworkModule, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }

        private void initialize(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.bindsVendorResponseMapperProvider = SingleCheck.provider(VendorResponseMapper_Factory.create());
            this.getRxSchedulersFactoryProvider = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi);
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            this.provideAuthInterceptorProvider = GroceryAffordabilityNetworkModule_ProvideAuthInterceptorFactory.create(groceryAffordabilityNetworkModule, getSecretProviderProvider);
            SetFactory<Interceptor> build = SetFactory.builder(1, 0).addProvider(this.provideAuthInterceptorProvider).build();
            this.groceryAffordabilitySetOfInterceptorProvider = build;
            this.provideOkHttpClientProvider = GroceryAffordabilityNetworkModule_ProvideOkHttpClientFactory.create(groceryAffordabilityNetworkModule, this.getOkHttpClientProvider, build);
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory create = GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory.create(groceryAffordabilityNetworkModule);
            this.provideGroceryAffordabilityBaseUrlProvider = create;
            GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory create2 = GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory.create(groceryAffordabilityNetworkModule, this.getBaseUrlFactoryProvider, create);
            this.provideBaseUrlProvider = create2;
            GroceryAffordabilityNetworkModule_ProvideRetrofitFactory create3 = GroceryAffordabilityNetworkModule_ProvideRetrofitFactory.create(groceryAffordabilityNetworkModule, this.getRetrofitWithMoshiProvider, this.provideOkHttpClientProvider, create2);
            this.provideRetrofitProvider = create3;
            this.provideGroceryAffordabilityApiProvider = GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityApiFactory.create(groceryAffordabilityNetworkModule, create3);
            VendorRepositoryImpl_Factory create4 = VendorRepositoryImpl_Factory.create(VendorCache_Factory.create(), this.bindsVendorResponseMapperProvider, this.getRxSchedulersFactoryProvider, this.provideGroceryAffordabilityApiProvider);
            this.vendorRepositoryImplProvider = create4;
            this.bindsVendorRepositoryProvider = SingleCheck.provider(create4);
        }

        public GetVendorUseCase getVendorUseCase() {
            return new GetVendorUseCase(this.bindsVendorRepositoryProvider.get());
        }

        public VendorRepository vendorRepository() {
            return this.bindsVendorRepositoryProvider.get();
        }
    }

    public static final class Factory implements DarkstoresVendorComponent.Factory {
        private Factory() {
        }

        public DarkstoresVendorComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new DarkstoresVendorComponentImpl(new GroceryAffordabilityNetworkModule(), dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }
    }

    private DaggerDarkstoresVendorComponent() {
    }

    public static DarkstoresVendorComponent.Factory factory() {
        return new Factory();
    }
}
