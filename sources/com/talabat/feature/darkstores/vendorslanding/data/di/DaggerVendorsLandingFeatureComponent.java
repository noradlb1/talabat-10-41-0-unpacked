package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMetadata;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.darkstores.vendorlanding.domain.model.MetadataError;
import com.talabat.feature.darkstores.vendorlanding.domain.model.PageInfo;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.feature.darkstores.vendorslanding.data.di.VendorsLandingFeatureComponent;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.BannerResponseMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.CategoryTreeMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.CategoryTreeMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.ImageUrlMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.ItemMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.ItemMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.LifestyleMissionItemMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.LifestyleMissionMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.LifestyleMissionMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.MetadataErrorMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.MetadataMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.MetadataMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.PageInfoMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.SwimlaneProductMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.SwimlaneProductMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorInfoResponseMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapperV2;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapperV2_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapper_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ImageUrlResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataErrorResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.PageInfoResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstores.vendorslanding.data.remote.GroceryBaseUrl_Factory;
import com.talabat.feature.darkstores.vendorslanding.data.remote.VendorLandingApi;
import com.talabat.feature.darkstores.vendorslanding.data.repository.VendorLandingRepositoryImpl;
import com.talabat.feature.darkstores.vendorslanding.data.repository.VendorLandingRepositoryImpl_Factory;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
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
public final class DaggerVendorsLandingFeatureComponent {

    public static final class Factory implements VendorsLandingFeatureComponent.Factory {
        private Factory() {
        }

        public VendorsLandingFeatureComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new VendorsLandingFeatureComponentImpl(new VendorLandingNetworkModule(), dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }
    }

    public static final class VendorsLandingFeatureComponentImpl implements VendorsLandingFeatureComponent {
        private Provider<ModelMapper<BannerResponse, Banner>> bindBannerResponseMapperProvider;
        private Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> bindCategoryTreeMapperProvider;
        private Provider<ModelMapper<ImageUrlResponse, ImageUrl>> bindImageUrlsMapperProvider;
        private Provider<ModelMapper<ItemResponse, Item>> bindItemMapperProvider;
        private Provider<ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem>> bindLifestyleMissionItemMapperProvider;
        private Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> bindLifestyleMissionMapperProvider;
        private Provider<ModelMapper<MetadataErrorResponse, MetadataError>> bindMetadataErrorMapperProvider;
        private Provider<ModelMapper<MetadataResponse, LifestyleMetadata>> bindMetadataMapperProvider;
        private Provider<ModelMapper<PageInfoResponse, PageInfo>> bindPageInfoMapperProvider;
        private Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> bindSwimlandProductMapperProvider;
        private Provider<ModelMapper<VendorLandingResponse, VendorLanding>> bindVendorLandingMapperProvider;
        private Provider<ModelMapper<VendorLandingResponseV2, VendorLanding>> bindVendorLandingMapperV2Provider;
        private Provider<VendorLandingRepository> bindVendorLandingRepositoryProvider;
        private Provider<ModelMapper<VendorInfoResponse, Vendor>> bindVendorResponseMapperProvider;
        private Provider<CategoryTreeMapper> categoryTreeMapperProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<ItemMapper> itemMapperProvider;
        private Provider<LifestyleMissionMapper> lifestyleMissionMapperProvider;
        private Provider<MetadataMapper> metadataMapperProvider;
        private Provider<Interceptor> provideAuthInterceptorProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<OkHttpClient> provideOkHttpClientProvider;
        private Provider<Retrofit> provideRetrofitProvider;
        private Provider<VendorLandingApi> provideVendorApiProvider;
        private Provider<SwimlaneProductMapper> swimlaneProductMapperProvider;
        private Provider<VendorLandingMapper> vendorLandingMapperProvider;
        private Provider<VendorLandingMapperV2> vendorLandingMapperV2Provider;
        private Provider<VendorLandingRepositoryImpl> vendorLandingRepositoryImplProvider;
        private Provider<Set<Interceptor>> vendorLandingSetOfInterceptorProvider;
        private final VendorsLandingFeatureComponentImpl vendorsLandingFeatureComponentImpl;

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

        private VendorsLandingFeatureComponentImpl(VendorLandingNetworkModule vendorLandingNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.vendorsLandingFeatureComponentImpl = this;
            initialize(vendorLandingNetworkModule, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, secretCoreLibApi);
        }

        private void initialize(VendorLandingNetworkModule vendorLandingNetworkModule, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            this.provideAuthInterceptorProvider = VendorLandingNetworkModule_ProvideAuthInterceptorFactory.create(vendorLandingNetworkModule, getSecretProviderProvider);
            SetFactory<Interceptor> build = SetFactory.builder(1, 0).addProvider(this.provideAuthInterceptorProvider).build();
            this.vendorLandingSetOfInterceptorProvider = build;
            this.provideOkHttpClientProvider = VendorLandingNetworkModule_ProvideOkHttpClientFactory.create(vendorLandingNetworkModule, this.getOkHttpClientProvider, build);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            VendorLandingNetworkModule_ProvideBaseUrlFactory create = VendorLandingNetworkModule_ProvideBaseUrlFactory.create(vendorLandingNetworkModule, getBaseUrlFactoryProvider2, GroceryBaseUrl_Factory.create());
            this.provideBaseUrlProvider = create;
            VendorLandingNetworkModule_ProvideRetrofitFactory create2 = VendorLandingNetworkModule_ProvideRetrofitFactory.create(vendorLandingNetworkModule, this.getRetrofitWithMoshiProvider, this.provideOkHttpClientProvider, create);
            this.provideRetrofitProvider = create2;
            this.provideVendorApiProvider = VendorLandingNetworkModule_ProvideVendorApiFactory.create(vendorLandingNetworkModule, create2);
            Provider<ModelMapper<ImageUrlResponse, ImageUrl>> provider = SingleCheck.provider(ImageUrlMapper_Factory.create());
            this.bindImageUrlsMapperProvider = provider;
            CategoryTreeMapper_Factory create3 = CategoryTreeMapper_Factory.create(provider);
            this.categoryTreeMapperProvider = create3;
            this.bindCategoryTreeMapperProvider = SingleCheck.provider(create3);
            this.bindLifestyleMissionItemMapperProvider = SingleCheck.provider(LifestyleMissionItemMapper_Factory.create());
            Provider<ModelMapper<MetadataErrorResponse, MetadataError>> provider2 = SingleCheck.provider(MetadataErrorMapper_Factory.create());
            this.bindMetadataErrorMapperProvider = provider2;
            MetadataMapper_Factory create4 = MetadataMapper_Factory.create(provider2);
            this.metadataMapperProvider = create4;
            this.bindMetadataMapperProvider = SingleCheck.provider(create4);
            Provider<ModelMapper<PageInfoResponse, PageInfo>> provider3 = SingleCheck.provider(PageInfoMapper_Factory.create());
            this.bindPageInfoMapperProvider = provider3;
            LifestyleMissionMapper_Factory create5 = LifestyleMissionMapper_Factory.create(this.bindLifestyleMissionItemMapperProvider, this.bindMetadataMapperProvider, provider3);
            this.lifestyleMissionMapperProvider = create5;
            this.bindLifestyleMissionMapperProvider = SingleCheck.provider(create5);
            SwimlaneProductMapper_Factory create6 = SwimlaneProductMapper_Factory.create(this.bindImageUrlsMapperProvider);
            this.swimlaneProductMapperProvider = create6;
            Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> provider4 = SingleCheck.provider(create6);
            this.bindSwimlandProductMapperProvider = provider4;
            VendorLandingMapper_Factory create7 = VendorLandingMapper_Factory.create(this.bindCategoryTreeMapperProvider, this.bindLifestyleMissionMapperProvider, provider4);
            this.vendorLandingMapperProvider = create7;
            this.bindVendorLandingMapperProvider = SingleCheck.provider(create7);
            this.bindBannerResponseMapperProvider = SingleCheck.provider(BannerResponseMapper_Factory.create());
            this.bindVendorResponseMapperProvider = SingleCheck.provider(VendorInfoResponseMapper_Factory.create());
            ItemMapper_Factory create8 = ItemMapper_Factory.create(this.bindSwimlandProductMapperProvider);
            this.itemMapperProvider = create8;
            Provider<ModelMapper<ItemResponse, Item>> provider5 = SingleCheck.provider(create8);
            this.bindItemMapperProvider = provider5;
            VendorLandingMapperV2_Factory create9 = VendorLandingMapperV2_Factory.create(this.bindCategoryTreeMapperProvider, this.bindLifestyleMissionMapperProvider, this.bindBannerResponseMapperProvider, this.bindVendorResponseMapperProvider, provider5);
            this.vendorLandingMapperV2Provider = create9;
            Provider<ModelMapper<VendorLandingResponseV2, VendorLanding>> provider6 = SingleCheck.provider(create9);
            this.bindVendorLandingMapperV2Provider = provider6;
            VendorLandingRepositoryImpl_Factory create10 = VendorLandingRepositoryImpl_Factory.create(this.provideVendorApiProvider, this.bindVendorLandingMapperProvider, provider6);
            this.vendorLandingRepositoryImplProvider = create10;
            this.bindVendorLandingRepositoryProvider = SingleCheck.provider(create10);
        }

        public VendorLandingRepository getRepository() {
            return this.bindVendorLandingRepositoryProvider.get();
        }
    }

    private DaggerVendorsLandingFeatureComponent() {
    }

    public static VendorsLandingFeatureComponent.Factory factory() {
        return new Factory();
    }
}
