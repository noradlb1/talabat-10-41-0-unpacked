package com.talabat.feature.swimlanevoucherslist.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository;
import com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository_Factory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.mapper.CustomerVoucherMapper_Factory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource_Factory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersBaseUrl_Factory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi;
import com.talabat.feature.swimlanevoucherslist.data.di.CustomerVouchersSwimLaneComponent;
import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerCustomerVouchersSwimLaneComponent {

    public static final class CustomerVouchersSwimLaneComponentImpl implements CustomerVouchersSwimLaneComponent {
        private final CustomerVouchersSwimLaneComponentImpl customerVouchersSwimLaneComponentImpl;
        private Provider<CustomerVouchersSwimLaneRealRepository> customerVouchersSwimLaneRealRepositoryProvider;
        private Provider<CustomerVouchersSwimLaneRepository> customerVouchersSwimLaneRepositoryProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<VouchersSwimLaneApi> provideCustomerVouchersSwimLaneApiProvider;
        private Provider<SwimLaneVouchersRemoteDataSource> swimLaneVouchersRemoteDataSourceProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        private CustomerVouchersSwimLaneComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.customerVouchersSwimLaneComponentImpl = this;
            initialize(configurationLocalCoreLibApi, experimentCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory create = CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory.create(this.getBaseUrlFactoryProvider, VouchersBaseUrl_Factory.create(), this.getRetrofitWithMoshiProvider);
            this.provideCustomerVouchersSwimLaneApiProvider = create;
            SwimLaneVouchersRemoteDataSource_Factory create2 = SwimLaneVouchersRemoteDataSource_Factory.create(create);
            this.swimLaneVouchersRemoteDataSourceProvider = create2;
            CustomerVouchersSwimLaneRealRepository_Factory create3 = CustomerVouchersSwimLaneRealRepository_Factory.create(create2, CustomerVoucherMapper_Factory.create());
            this.customerVouchersSwimLaneRealRepositoryProvider = create3;
            this.customerVouchersSwimLaneRepositoryProvider = SingleCheck.provider(create3);
        }

        public CustomerVouchersSwimLaneRepository getVouchersSwimLaneRepository() {
            return this.customerVouchersSwimLaneRepositoryProvider.get();
        }
    }

    public static final class Factory implements CustomerVouchersSwimLaneComponent.Factory {
        private Factory() {
        }

        public CustomerVouchersSwimLaneComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new CustomerVouchersSwimLaneComponentImpl(configurationLocalCoreLibApi, experimentCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }
    }

    private DaggerCustomerVouchersSwimLaneComponent() {
    }

    public static CustomerVouchersSwimLaneComponent.Factory factory() {
        return new Factory();
    }
}
