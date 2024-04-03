package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstoresscheduleddelivery.data.di.DarkstoresScheduledDeliveryComponent;
import com.talabat.feature.darkstoresscheduleddelivery.data.mapper.DeliveryDateResponseMapper;
import com.talabat.feature.darkstoresscheduleddelivery.data.mapper.DeliveryDateResponseMapper_Factory;
import com.talabat.feature.darkstoresscheduleddelivery.data.mapper.DeliverySlotResponseMapper_Factory;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduleDeliveryBaseUrl_Factory;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduledDeliveryApi;
import com.talabat.feature.darkstoresscheduleddelivery.data.repository.DarkstoresScheduledDeliveryRepositoryImpl;
import com.talabat.feature.darkstoresscheduleddelivery.data.repository.DarkstoresScheduledDeliveryRepositoryImpl_Factory;
import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerDarkstoresScheduledDeliveryComponent {

    public static final class DarkstoresScheduledDeliveryComponentImpl implements DarkstoresScheduledDeliveryComponent {
        private Provider<IsDarkstoresScheduledDeliveryDiscountEnabledUseCase> bindIsDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider;
        private final DarkstoresScheduledDeliveryComponentImpl darkstoresScheduledDeliveryComponentImpl;
        private Provider<DarkstoresScheduledDeliveryRepositoryImpl> darkstoresScheduledDeliveryRepositoryImplProvider;
        private Provider<DeliveryDateResponseMapper> deliveryDateResponseMapperProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl> isDarkstoresScheduledDeliveryDiscountEnabledUseCaseImplProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<DarkstoresScheduledDeliveryApi> provideDarkstoresScheduledDeliveryApiProvider;
        private Provider<DarkstoresScheduledDeliveryRepository> provideDarkstoresScheduledDeliveryRepositoryProvider;
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

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
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

        private DarkstoresScheduledDeliveryComponentImpl(DarkstoresScheduledDeliveryDataModule darkstoresScheduledDeliveryDataModule, DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.darkstoresScheduledDeliveryComponentImpl = this;
            initialize(darkstoresScheduledDeliveryDataModule, darkstoresScheduledDeliveryNetworkModule, configurationLocalCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, networkCoreLibApi);
        }

        private void initialize(DarkstoresScheduledDeliveryDataModule darkstoresScheduledDeliveryDataModule, DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory create = DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory.create(darkstoresScheduledDeliveryNetworkModule, getBaseUrlFactoryProvider2, DarkstoresScheduleDeliveryBaseUrl_Factory.create());
            this.provideBaseUrlProvider = create;
            DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory create2 = DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory.create(darkstoresScheduledDeliveryNetworkModule, this.getRetrofitWithMoshiProvider, this.getOkHttpClientProvider, create);
            this.provideRetrofitProvider = create2;
            this.provideDarkstoresScheduledDeliveryApiProvider = DarkstoresScheduledDeliveryNetworkModule_ProvideDarkstoresScheduledDeliveryApiFactory.create(darkstoresScheduledDeliveryNetworkModule, create2);
            this.getRxSchedulersFactoryProvider = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi);
            DeliveryDateResponseMapper_Factory create3 = DeliveryDateResponseMapper_Factory.create(DeliverySlotResponseMapper_Factory.create());
            this.deliveryDateResponseMapperProvider = create3;
            DarkstoresScheduledDeliveryRepositoryImpl_Factory create4 = DarkstoresScheduledDeliveryRepositoryImpl_Factory.create(this.provideDarkstoresScheduledDeliveryApiProvider, this.getRxSchedulersFactoryProvider, create3);
            this.darkstoresScheduledDeliveryRepositoryImplProvider = create4;
            this.provideDarkstoresScheduledDeliveryRepositoryProvider = SingleCheck.provider(DarkstoresScheduledDeliveryDataModule_ProvideDarkstoresScheduledDeliveryRepositoryFactory.create(darkstoresScheduledDeliveryDataModule, create4));
            GetExperimentProviderProvider getExperimentProviderProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            this.getExperimentProvider = getExperimentProviderProvider;
            IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory create5 = IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory.create(getExperimentProviderProvider);
            this.isDarkstoresScheduledDeliveryDiscountEnabledUseCaseImplProvider = create5;
            this.bindIsDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider = SingleCheck.provider(create5);
        }

        public DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase() {
            return new DarkstoresScheduledDeliveryUseCase(this.provideDarkstoresScheduledDeliveryRepositoryProvider.get());
        }

        public IsDarkstoresScheduledDeliveryDiscountEnabledUseCase isDarkstoresScheduledDeliveryDiscountEnabledUseCase() {
            return this.bindIsDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider.get();
        }
    }

    public static final class Factory implements DarkstoresScheduledDeliveryComponent.Factory {
        private Factory() {
        }

        public DarkstoresScheduledDeliveryComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            return new DarkstoresScheduledDeliveryComponentImpl(new DarkstoresScheduledDeliveryDataModule(), new DarkstoresScheduledDeliveryNetworkModule(), configurationLocalCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, networkCoreLibApi);
        }
    }

    private DaggerDarkstoresScheduledDeliveryComponent() {
    }

    public static DarkstoresScheduledDeliveryComponent.Factory factory() {
        return new Factory();
    }
}
