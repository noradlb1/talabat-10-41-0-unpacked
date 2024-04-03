package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl;
import com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl_Factory;
import com.talabat.feature.walletcobrandedcc.data.di.WalletCobrandedCcFeatureComponent;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcApi;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcBaseUrl_Factory;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource_Factory;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.GetWalletStatusUseCaseImpl;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.GetWalletStatusUseCaseImpl_Factory;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.ShowCobrandedNotificationUseCaseImpl;
import com.talabat.feature.walletcobrandedcc.domain.usecase.impl.ShowCobrandedNotificationUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerWalletCobrandedCcFeatureComponent {

    public static final class Factory implements WalletCobrandedCcFeatureComponent.Factory {
        private Factory() {
        }

        public WalletCobrandedCcFeatureComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NetworkCoreLibApi networkCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            return new WalletCobrandedCcFeatureComponentImpl(configurationRemoteCoreLibApi, observabilityCoreLibApi, networkCoreLibApi, customerCoreLibApi);
        }
    }

    public static final class WalletCobrandedCcFeatureComponentImpl implements WalletCobrandedCcFeatureComponent {
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<LocationConfigurationRepository> getLocationConfigurationRepositoryProvider;
        private Provider<CustomerRepository> getRepositoryProvider;
        private Provider<GetWalletStatusUseCaseImpl> getWalletStatusUseCaseImplProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<GetWalletStatusUseCase> provideGetWalletStatusUseCaseProvider;
        private Provider<ShowCobrandedNotificationUseCase> provideShowCobrandedNotificationUseCaseProvider;
        private Provider<WalletCobrandedCcApi> provideWalletCobrandedCcApiProvider;
        private Provider<ShowCobrandedNotificationUseCaseImpl> showCobrandedNotificationUseCaseImplProvider;
        private final WalletCobrandedCcFeatureComponentImpl walletCobrandedCcFeatureComponentImpl;
        private Provider<WalletCobrandedCcRemoteDataSource> walletCobrandedCcRemoteDataSourceProvider;
        private Provider<WalletCobrandedCcRepositoryImpl> walletCobrandedCcRepositoryImplProvider;
        private Provider<WalletCobrandedCcRepository> walletCobrandedCcRepositoryProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetLocationConfigurationRepositoryProvider implements Provider<LocationConfigurationRepository> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetLocationConfigurationRepositoryProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public LocationConfigurationRepository get() {
                return (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository());
            }
        }

        public static final class GetRepositoryProvider implements Provider<CustomerRepository> {
            private final CustomerCoreLibApi customerCoreLibApi;

            public GetRepositoryProvider(CustomerCoreLibApi customerCoreLibApi2) {
                this.customerCoreLibApi = customerCoreLibApi2;
            }

            public CustomerRepository get() {
                return (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository());
            }
        }

        private WalletCobrandedCcFeatureComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NetworkCoreLibApi networkCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            this.walletCobrandedCcFeatureComponentImpl = this;
            initialize(configurationRemoteCoreLibApi, observabilityCoreLibApi, networkCoreLibApi, customerCoreLibApi);
        }

        private void initialize(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NetworkCoreLibApi networkCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            this.getLocationConfigurationRepositoryProvider = new GetLocationConfigurationRepositoryProvider(configurationRemoteCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory create = WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory.create(getBaseUrlFactoryProvider2, WalletCobrandedCcBaseUrl_Factory.create());
            this.provideBaseUrlProvider = create;
            WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory create2 = WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory.create(create);
            this.provideWalletCobrandedCcApiProvider = create2;
            WalletCobrandedCcRemoteDataSource_Factory create3 = WalletCobrandedCcRemoteDataSource_Factory.create(create2);
            this.walletCobrandedCcRemoteDataSourceProvider = create3;
            WalletCobrandedCcRepositoryImpl_Factory create4 = WalletCobrandedCcRepositoryImpl_Factory.create(this.getLocationConfigurationRepositoryProvider, create3);
            this.walletCobrandedCcRepositoryImplProvider = create4;
            this.walletCobrandedCcRepositoryProvider = SingleCheck.provider(create4);
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(customerCoreLibApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            ShowCobrandedNotificationUseCaseImpl_Factory create5 = ShowCobrandedNotificationUseCaseImpl_Factory.create(this.walletCobrandedCcRepositoryProvider, getRepositoryProvider2);
            this.showCobrandedNotificationUseCaseImplProvider = create5;
            this.provideShowCobrandedNotificationUseCaseProvider = SingleCheck.provider(create5);
            GetWalletStatusUseCaseImpl_Factory create6 = GetWalletStatusUseCaseImpl_Factory.create(this.walletCobrandedCcRepositoryProvider);
            this.getWalletStatusUseCaseImplProvider = create6;
            this.provideGetWalletStatusUseCaseProvider = SingleCheck.provider(create6);
        }

        public GetWalletStatusUseCase getWalletStatusUseCase() {
            return this.provideGetWalletStatusUseCaseProvider.get();
        }

        public ShowCobrandedNotificationUseCase showCobrandedNotificationUseCase() {
            return this.provideShowCobrandedNotificationUseCaseProvider.get();
        }

        public WalletCobrandedCcRepository walletCobrandedCcRepository() {
            return this.walletCobrandedCcRepositoryProvider.get();
        }
    }

    private DaggerWalletCobrandedCcFeatureComponent() {
    }

    public static WalletCobrandedCcFeatureComponent.Factory factory() {
        return new Factory();
    }
}
