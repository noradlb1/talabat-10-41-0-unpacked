package com.talabat.feature.incentiveautoapplydiscounts.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository;
import com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository_Factory;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper.IncentiveAutoApplyDiscountsMapper_Factory;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsApi;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource_Factory;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.LoyaltyBaseUrl_Factory;
import com.talabat.feature.incentiveautoapplydiscounts.data.di.IncentiveAutoApplyDiscountsComponent;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerIncentiveAutoApplyDiscountsComponent {

    public static final class Factory implements IncentiveAutoApplyDiscountsComponent.Factory {
        private Factory() {
        }

        public IncentiveAutoApplyDiscountsComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            return new IncentiveAutoApplyDiscountsComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi);
        }
    }

    public static final class IncentiveAutoApplyDiscountsComponentImpl implements IncentiveAutoApplyDiscountsComponent {
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private final IncentiveAutoApplyDiscountsComponentImpl incentiveAutoApplyDiscountsComponentImpl;
        private Provider<IncentiveAutoApplyDiscountsRealRepository> incentiveAutoApplyDiscountsRealRepositoryProvider;
        private Provider<IncentiveAutoApplyDiscountsRemoteDataSource> incentiveAutoApplyDiscountsRemoteDataSourceProvider;
        private Provider<IncentiveAutoApplyDiscountsRepository> incentiveAutoApplyDiscountsRepositoryProvider;
        private Provider<IncentiveAutoApplyDiscountsApi> provideIncentiveAutoApplyDiscountsApiProvider;

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

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private IncentiveAutoApplyDiscountsComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.incentiveAutoApplyDiscountsComponentImpl = this;
            initialize(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory create = IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory.create(this.getBaseUrlFactoryProvider, LoyaltyBaseUrl_Factory.create(), this.getRetrofitWithMoshiProvider);
            this.provideIncentiveAutoApplyDiscountsApiProvider = create;
            IncentiveAutoApplyDiscountsRemoteDataSource_Factory create2 = IncentiveAutoApplyDiscountsRemoteDataSource_Factory.create(create);
            this.incentiveAutoApplyDiscountsRemoteDataSourceProvider = create2;
            IncentiveAutoApplyDiscountsRealRepository_Factory create3 = IncentiveAutoApplyDiscountsRealRepository_Factory.create(this.getTalabatFeatureFlagProvider, create2, IncentiveAutoApplyDiscountsMapper_Factory.create());
            this.incentiveAutoApplyDiscountsRealRepositoryProvider = create3;
            this.incentiveAutoApplyDiscountsRepositoryProvider = SingleCheck.provider(create3);
        }

        public IncentiveAutoApplyDiscountsRepository getRepository() {
            return this.incentiveAutoApplyDiscountsRepositoryProvider.get();
        }
    }

    private DaggerIncentiveAutoApplyDiscountsComponent() {
    }

    public static IncentiveAutoApplyDiscountsComponent.Factory factory() {
        return new Factory();
    }
}
