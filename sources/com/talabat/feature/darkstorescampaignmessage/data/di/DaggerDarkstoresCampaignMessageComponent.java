package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.talabat.feature.darkstorescampaignmessage.data.di.DarkstoresCampaignMessageComponent;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper_Factory;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressSourceMapper_Factory;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressStateMapper_Factory;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.data.remote.CampaignMessageApi;
import com.talabat.feature.darkstorescampaignmessage.data.repository.CampaignMessageRepositoryImpl;
import com.talabat.feature.darkstorescampaignmessage.data.repository.CampaignMessageRepositoryImpl_Factory;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.feature.darkstorescampaignmessage.domain.repository.CampaignMessageRepository;
import com.talabat.feature.darkstorescampaignmessage.domain.usecase.GetCampaignMessageUseCase;
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
public final class DaggerDarkstoresCampaignMessageComponent {

    public static final class DarkstoresCampaignMessageComponentImpl implements DarkstoresCampaignMessageComponent {
        private Provider<CampaignMessageRepository> bindCampaignMessageRepositoryProvider;
        private Provider<ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse>> bindsCampaignProgressResponseMapperProvider;
        private Provider<ModelMapper<String, CampaignSource>> bindsCampaignProgressSourceMapperProvider;
        private Provider<ModelMapper<NetworkCampaignProgressState, CampaignState>> bindsCampaignProgressStateMapperProvider;
        private Provider<CampaignMessageRepositoryImpl> campaignMessageRepositoryImplProvider;
        private Provider<Set<Interceptor>> campaignMessageSetOfInterceptorProvider;
        private Provider<CampaignProgressResponseMapper> campaignProgressResponseMapperProvider;
        private final DarkstoresCampaignMessageComponentImpl darkstoresCampaignMessageComponentImpl;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<Interceptor> provideAuthInterceptorProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<CampaignMessageApi> provideCampaignMessageApiApiProvider;
        private Provider<IBaseUrl> provideCampaignMessageBaseUrlProvider;
        private Provider<OkHttpClient> provideOkHttpClientProvider;
        private Provider<Retrofit> provideRetrofitProvider;

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

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
            }
        }

        private DarkstoresCampaignMessageComponentImpl(CampaignMessageNetworkModule campaignMessageNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.darkstoresCampaignMessageComponentImpl = this;
            initialize(campaignMessageNetworkModule, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }

        private void initialize(CampaignMessageNetworkModule campaignMessageNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            this.provideAuthInterceptorProvider = CampaignMessageNetworkModule_ProvideAuthInterceptorFactory.create(campaignMessageNetworkModule, getSecretProviderProvider);
            SetFactory<Interceptor> build = SetFactory.builder(1, 0).addProvider(this.provideAuthInterceptorProvider).build();
            this.campaignMessageSetOfInterceptorProvider = build;
            this.provideOkHttpClientProvider = CampaignMessageNetworkModule_ProvideOkHttpClientFactory.create(campaignMessageNetworkModule, this.getOkHttpClientProvider, build);
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory create = CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory.create(campaignMessageNetworkModule);
            this.provideCampaignMessageBaseUrlProvider = create;
            CampaignMessageNetworkModule_ProvideBaseUrlFactory create2 = CampaignMessageNetworkModule_ProvideBaseUrlFactory.create(campaignMessageNetworkModule, this.getBaseUrlFactoryProvider, create);
            this.provideBaseUrlProvider = create2;
            CampaignMessageNetworkModule_ProvideRetrofitFactory create3 = CampaignMessageNetworkModule_ProvideRetrofitFactory.create(campaignMessageNetworkModule, this.getRetrofitWithMoshiProvider, this.provideOkHttpClientProvider, create2);
            this.provideRetrofitProvider = create3;
            this.provideCampaignMessageApiApiProvider = CampaignMessageNetworkModule_ProvideCampaignMessageApiApiFactory.create(campaignMessageNetworkModule, create3);
            this.bindsCampaignProgressStateMapperProvider = SingleCheck.provider(CampaignProgressStateMapper_Factory.create());
            Provider<ModelMapper<String, CampaignSource>> provider = SingleCheck.provider(CampaignProgressSourceMapper_Factory.create());
            this.bindsCampaignProgressSourceMapperProvider = provider;
            CampaignProgressResponseMapper_Factory create4 = CampaignProgressResponseMapper_Factory.create(this.bindsCampaignProgressStateMapperProvider, provider);
            this.campaignProgressResponseMapperProvider = create4;
            Provider<ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse>> provider2 = SingleCheck.provider(create4);
            this.bindsCampaignProgressResponseMapperProvider = provider2;
            CampaignMessageRepositoryImpl_Factory create5 = CampaignMessageRepositoryImpl_Factory.create(this.provideCampaignMessageApiApiProvider, provider2);
            this.campaignMessageRepositoryImplProvider = create5;
            this.bindCampaignMessageRepositoryProvider = SingleCheck.provider(create5);
        }

        public GetCampaignMessageUseCase getVendorUseCase() {
            return new GetCampaignMessageUseCase(this.bindCampaignMessageRepositoryProvider.get());
        }
    }

    public static final class Factory implements DarkstoresCampaignMessageComponent.Factory {
        private Factory() {
        }

        public DarkstoresCampaignMessageComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new DarkstoresCampaignMessageComponentImpl(new CampaignMessageNetworkModule(), dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }
    }

    private DaggerDarkstoresCampaignMessageComponent() {
    }

    public static DarkstoresCampaignMessageComponent.Factory factory() {
        return new Factory();
    }
}
