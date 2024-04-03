package com.talabat.configuration.di;

import android.content.Context;
import buisnessmodels.mappers.OldTokenizedBankCardToTokenizedBankCardMapper;
import buisnessmodels.mappers.OldTokenizedBankCardToTokenizedBankCardMapper_Factory;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.RealConfigurationRemoteRepository;
import com.talabat.configuration.RealConfigurationRemoteRepository_Factory;
import com.talabat.configuration.areas.Areas2Rest;
import com.talabat.configuration.areas.endpoint.Areas2BaseUrl_Factory;
import com.talabat.configuration.areas.mapper.Area2Mapper_Factory;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibComponent;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.discovery.RealAppVersionProvider;
import com.talabat.configuration.discovery.RealAppVersionProvider_Factory;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository_Factory;
import com.talabat.configuration.discovery.mapper.DiscoveryConfigMapper_Factory;
import com.talabat.configuration.location.LegacyLocationConfigurationRepository;
import com.talabat.configuration.location.LegacyLocationConfigurationRepository_Factory;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.location.RealLocationConfigurationRepository;
import com.talabat.configuration.location.RealLocationConfigurationRepository_Factory;
import com.talabat.configuration.location.mapper.AreaMapper_Factory;
import com.talabat.configuration.location.mapper.CityMapper_Factory;
import com.talabat.configuration.location.mapper.CountryMapper;
import com.talabat.configuration.location.mapper.CountryMapper_Factory;
import com.talabat.configuration.location.mapper.LocationConfigMapper;
import com.talabat.configuration.location.mapper.LocationConfigMapper_Factory;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.orderexperience.RealOrderExperienceConfigurationRepository;
import com.talabat.configuration.orderexperience.RealOrderExperienceConfigurationRepository_Factory;
import com.talabat.configuration.orderexperience.mapper.OrderExperienceConfigMapper;
import com.talabat.configuration.orderexperience.mapper.OrderExperienceConfigMapper_Factory;
import com.talabat.configuration.payment.LegacyPaymentConfigurationRepository;
import com.talabat.configuration.payment.LegacyPaymentConfigurationRepository_Factory;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.payment.RealPaymentConfigurationRepository;
import com.talabat.configuration.payment.RealPaymentConfigurationRepository_Factory;
import com.talabat.configuration.payment.mapper.PaymentConfigMapper;
import com.talabat.configuration.payment.mapper.PaymentConfigMapper_Factory;
import com.talabat.configuration.payment.mapper.TokenizedBankCardMapper;
import com.talabat.configuration.payment.mapper.TokenizedBankCardMapper_Factory;
import com.talabat.configuration.payment.mapper.WalletConfigMapper;
import com.talabat.configuration.payment.mapper.WalletConfigMapper_Factory;
import com.talabat.configuration.remote.ConfigurationRemoteRest;
import com.talabat.configuration.remote.endpoint.AppInfoBaseUrl_Factory;
import com.talabat.configuration.remote.mapper.AppRemoteConfigMapper_Factory;
import com.talabat.configuration.tcs.RealTermsAndConditionsConfigurationRepository;
import com.talabat.configuration.tcs.RealTermsAndConditionsConfigurationRepository_Factory;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.configuration.tcs.mapper.TermsAndConditionsConfigMapper;
import com.talabat.configuration.tcs.mapper.TermsAndConditionsConfigMapper_Factory;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldAreaToAreaMapper_Factory;
import datamodels.mappers.OldCityToCityMapper;
import datamodels.mappers.OldCityToCityMapper_Factory;
import datamodels.mappers.OldCountryToCountryMapper;
import datamodels.mappers.OldCountryToCountryMapper_Factory;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerConfigurationRemoteCoreLibComponent {

    public static final class ConfigurationRemoteCoreLibComponentImpl implements ConfigurationRemoteCoreLibComponent {
        private Provider<AppVersionProvider> appVersionProvider;
        private Provider<Areas2Rest> areasRestProvider;
        private final ConfigurationRemoteCoreLibComponentImpl configurationRemoteCoreLibComponentImpl;
        private Provider<CountryMapper> countryMapperProvider;
        private Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<Moshi> getMoshiProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<LegacyLocationConfigurationRepository> legacyLocationConfigurationRepositoryProvider;
        private Provider<LegacyPaymentConfigurationRepository> legacyPaymentConfigurationRepositoryProvider;
        private Provider<LocationConfigMapper> locationConfigMapperProvider;
        private Provider<OldAreaToAreaMapper> oldAreaToAreaMapperProvider;
        private Provider<OldCityToCityMapper> oldCityToCityMapperProvider;
        private Provider<OldCountryToCountryMapper> oldCountryToCountryMapperProvider;
        private Provider<OldTokenizedBankCardToTokenizedBankCardMapper> oldTokenizedBankCardToTokenizedBankCardMapperProvider;
        private Provider<OrderExperienceConfigMapper> orderExperienceConfigMapperProvider;
        private Provider<OrderExperienceConfigurationRepository> orderExperienceConfigurationRepositoryProvider;
        private Provider<PaymentConfigMapper> paymentConfigMapperProvider;
        private Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
        private Provider<RealAppVersionProvider> realAppVersionProvider;
        private Provider<RealConfigurationRemoteRepository> realConfigurationRemoteRepositoryProvider;
        private Provider<RealDiscoveryConfigurationRepository> realDiscoveryConfigurationRepositoryProvider;
        private Provider<RealLocationConfigurationRepository> realLocationConfigurationRepositoryProvider;
        private Provider<RealOrderExperienceConfigurationRepository> realOrderExperienceConfigurationRepositoryProvider;
        private Provider<RealPaymentConfigurationRepository> realPaymentConfigurationRepositoryProvider;
        private Provider<RealTermsAndConditionsConfigurationRepository> realTermsAndConditionsConfigurationRepositoryProvider;
        private Provider<ConfigurationRemoteRest> restProvider;
        private Provider<TermsAndConditionsConfigMapper> termsAndConditionsConfigMapperProvider;
        private Provider<TokenizedBankCardMapper> tokenizedBankCardMapperProvider;
        private Provider<WalletConfigMapper> walletConfigMapperProvider;

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

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
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

        private ConfigurationRemoteCoreLibComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            this.configurationRemoteCoreLibComponentImpl = this;
            initialize(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.restProvider = ConfigurationRemoteNetworkModule_RestFactory.create(this.getBaseUrlFactoryProvider, AppInfoBaseUrl_Factory.create(), this.getRetrofitWithMoshiProvider);
            this.getMoshiProvider = new GetMoshiProvider(parserCoreLibApi);
            this.realConfigurationRemoteRepositoryProvider = SingleCheck.provider(RealConfigurationRemoteRepository_Factory.create(this.restProvider, AppRemoteConfigMapper_Factory.create(), this.getMoshiProvider));
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            RealAppVersionProvider_Factory create = RealAppVersionProvider_Factory.create(getContextProvider2);
            this.realAppVersionProvider = create;
            Provider<AppVersionProvider> provider = SingleCheck.provider(create);
            this.appVersionProvider = provider;
            RealDiscoveryConfigurationRepository_Factory create2 = RealDiscoveryConfigurationRepository_Factory.create(this.realConfigurationRemoteRepositoryProvider, provider, DiscoveryConfigMapper_Factory.create());
            this.realDiscoveryConfigurationRepositoryProvider = create2;
            this.discoveryConfigurationRepositoryProvider = SingleCheck.provider(create2);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.countryMapperProvider = CountryMapper_Factory.create(CityMapper_Factory.create());
            this.locationConfigMapperProvider = LocationConfigMapper_Factory.create(AreaMapper_Factory.create(), this.countryMapperProvider);
            Areas2NetworkModule_AreasRestFactory create3 = Areas2NetworkModule_AreasRestFactory.create(this.getBaseUrlFactoryProvider, Areas2BaseUrl_Factory.create(), this.getRetrofitWithMoshiProvider);
            this.areasRestProvider = create3;
            this.realLocationConfigurationRepositoryProvider = SingleCheck.provider(RealLocationConfigurationRepository_Factory.create(this.realConfigurationRemoteRepositoryProvider, this.getRepositoryProvider, this.locationConfigMapperProvider, create3, Area2Mapper_Factory.create()));
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.oldAreaToAreaMapperProvider = SingleCheck.provider(OldAreaToAreaMapper_Factory.create());
            Provider<OldCityToCityMapper> provider2 = SingleCheck.provider(OldCityToCityMapper_Factory.create());
            this.oldCityToCityMapperProvider = provider2;
            Provider<OldCountryToCountryMapper> provider3 = SingleCheck.provider(OldCountryToCountryMapper_Factory.create(provider2));
            this.oldCountryToCountryMapperProvider = provider3;
            Provider<LegacyLocationConfigurationRepository> provider4 = SingleCheck.provider(LegacyLocationConfigurationRepository_Factory.create(this.realLocationConfigurationRepositoryProvider, this.getRepositoryProvider, this.getTalabatFeatureFlagProvider, this.oldAreaToAreaMapperProvider, provider3));
            this.legacyLocationConfigurationRepositoryProvider = provider4;
            OrderExperienceConfigMapper_Factory create4 = OrderExperienceConfigMapper_Factory.create(this.getTalabatFeatureFlagProvider, provider4);
            this.orderExperienceConfigMapperProvider = create4;
            RealOrderExperienceConfigurationRepository_Factory create5 = RealOrderExperienceConfigurationRepository_Factory.create(this.realConfigurationRemoteRepositoryProvider, create4);
            this.realOrderExperienceConfigurationRepositoryProvider = create5;
            this.orderExperienceConfigurationRepositoryProvider = SingleCheck.provider(create5);
            this.paymentConfigMapperProvider = PaymentConfigMapper_Factory.create(this.getBaseUrlFactoryProvider, this.getTalabatFeatureFlagProvider, this.legacyLocationConfigurationRepositoryProvider);
            Provider<TokenizedBankCardMapper> provider5 = SingleCheck.provider(TokenizedBankCardMapper_Factory.create());
            this.tokenizedBankCardMapperProvider = provider5;
            Provider<WalletConfigMapper> provider6 = SingleCheck.provider(WalletConfigMapper_Factory.create(this.getTalabatFeatureFlagProvider, this.legacyLocationConfigurationRepositoryProvider, provider5));
            this.walletConfigMapperProvider = provider6;
            this.realPaymentConfigurationRepositoryProvider = SingleCheck.provider(RealPaymentConfigurationRepository_Factory.create(this.realConfigurationRemoteRepositoryProvider, this.paymentConfigMapperProvider, provider6));
            Provider<OldTokenizedBankCardToTokenizedBankCardMapper> provider7 = SingleCheck.provider(OldTokenizedBankCardToTokenizedBankCardMapper_Factory.create());
            this.oldTokenizedBankCardToTokenizedBankCardMapperProvider = provider7;
            LegacyPaymentConfigurationRepository_Factory create6 = LegacyPaymentConfigurationRepository_Factory.create(this.realPaymentConfigurationRepositoryProvider, this.realConfigurationRemoteRepositoryProvider, this.getTalabatFeatureFlagProvider, this.getBaseUrlFactoryProvider, provider7);
            this.legacyPaymentConfigurationRepositoryProvider = create6;
            this.paymentConfigurationRepositoryProvider = SingleCheck.provider(create6);
            TermsAndConditionsConfigMapper_Factory create7 = TermsAndConditionsConfigMapper_Factory.create(this.getBaseUrlFactoryProvider, this.legacyLocationConfigurationRepositoryProvider);
            this.termsAndConditionsConfigMapperProvider = create7;
            this.realTermsAndConditionsConfigurationRepositoryProvider = SingleCheck.provider(RealTermsAndConditionsConfigurationRepository_Factory.create(this.realConfigurationRemoteRepositoryProvider, create7));
        }

        public AppVersionProvider getAppVersionProvider() {
            return this.appVersionProvider.get();
        }

        public DiscoveryConfigurationRepository getDiscoveryConfigurationRepository() {
            return this.discoveryConfigurationRepositoryProvider.get();
        }

        public LocationConfigurationRepository getLocationConfigurationRepository() {
            return this.legacyLocationConfigurationRepositoryProvider.get();
        }

        public MutableLocationConfigurationRepository getMutableLocationConfigurationRepository() {
            return this.legacyLocationConfigurationRepositoryProvider.get();
        }

        public MutableConfigurationRemoteRepository getMutableRepository() {
            return this.realConfigurationRemoteRepositoryProvider.get();
        }

        public OrderExperienceConfigurationRepository getOrderExperienceConfigurationRepository() {
            return this.orderExperienceConfigurationRepositoryProvider.get();
        }

        public PaymentConfigurationRepository getPaymentConfigurationRepository() {
            return this.paymentConfigurationRepositoryProvider.get();
        }

        public ConfigurationRemoteRepository getRepository() {
            return this.realConfigurationRemoteRepositoryProvider.get();
        }

        public TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository() {
            return this.realTermsAndConditionsConfigurationRepositoryProvider.get();
        }
    }

    public static final class Factory implements ConfigurationRemoteCoreLibComponent.Factory {
        private Factory() {
        }

        public ConfigurationRemoteCoreLibComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            return new ConfigurationRemoteCoreLibComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi);
        }
    }

    private DaggerConfigurationRemoteCoreLibComponent() {
    }

    public static ConfigurationRemoteCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
