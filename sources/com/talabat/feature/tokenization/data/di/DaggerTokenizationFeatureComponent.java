package com.talabat.feature.tokenization.data.di;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.tokenization.data.TokenizationRepositoryImpl;
import com.talabat.feature.tokenization.data.TokenizationRepositoryImpl_Factory;
import com.talabat.feature.tokenization.data.baseurl.TokenizationBaseUrl;
import com.talabat.feature.tokenization.data.baseurl.TokenizationBaseUrl_Factory;
import com.talabat.feature.tokenization.data.datasource.CheckoutTokenizationDataSource;
import com.talabat.feature.tokenization.data.datasource.CheckoutTokenizationDataSource_Factory;
import com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource;
import com.talabat.feature.tokenization.data.di.TokenizationFeatureComponent;
import com.talabat.feature.tokenization.data.mapper.NonEnglishNumbersMapper_Factory;
import com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper_Factory;
import com.talabat.feature.tokenization.data.provider.CheckoutApiClientProvider;
import com.talabat.feature.tokenization.data.provider.CheckoutApiClientProvider_Factory;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerTokenizationFeatureComponent {

    public static final class Factory implements TokenizationFeatureComponent.Factory {
        private Factory() {
        }

        public TokenizationFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            return new TokenizationFeatureComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi);
        }
    }

    public static final class TokenizationFeatureComponentImpl implements TokenizationFeatureComponent {
        private Provider<CheckoutApiClientProvider> checkoutApiClientProvider;
        private Provider<CheckoutTokenizationDataSource> checkoutTokenizationDataSourceProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<PaymentConfigurationRepository> getPaymentConfigurationRepositoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<RemoteTokenizationDataSource> remoteTokenizationDataSourceProvider;
        private Provider<TokenizationBaseUrl> tokenizationBaseUrlProvider;
        private final TokenizationFeatureComponentImpl tokenizationFeatureComponentImpl;
        private Provider<TokenizationRepositoryImpl> tokenizationRepositoryImplProvider;
        private Provider<TokenizationRepository> tokenizationRepositoryProvider;

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

        public static final class GetPaymentConfigurationRepositoryProvider implements Provider<PaymentConfigurationRepository> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetPaymentConfigurationRepositoryProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public PaymentConfigurationRepository get() {
                return (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository());
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

        private TokenizationFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.tokenizationFeatureComponentImpl = this;
            initialize(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            GetPaymentConfigurationRepositoryProvider getPaymentConfigurationRepositoryProvider2 = new GetPaymentConfigurationRepositoryProvider(configurationRemoteCoreLibApi);
            this.getPaymentConfigurationRepositoryProvider = getPaymentConfigurationRepositoryProvider2;
            this.tokenizationBaseUrlProvider = TokenizationBaseUrl_Factory.create(getPaymentConfigurationRepositoryProvider2);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.remoteTokenizationDataSourceProvider = SingleCheck.provider(TokenizationDataSourceModule_RemoteTokenizationDataSourceFactory.create(this.getRetrofitWithMoshiProvider, this.tokenizationBaseUrlProvider, getBaseUrlFactoryProvider2));
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            Provider<CheckoutApiClientProvider> provider = SingleCheck.provider(CheckoutApiClientProvider_Factory.create(getContextProvider2));
            this.checkoutApiClientProvider = provider;
            Provider<CheckoutTokenizationDataSource> provider2 = SingleCheck.provider(CheckoutTokenizationDataSource_Factory.create(provider, NonEnglishNumbersMapper_Factory.create(), this.getContextProvider));
            this.checkoutTokenizationDataSourceProvider = provider2;
            TokenizationRepositoryImpl_Factory create = TokenizationRepositoryImpl_Factory.create(this.remoteTokenizationDataSourceProvider, provider2, TokenizationPublicKeyMapper_Factory.create());
            this.tokenizationRepositoryImplProvider = create;
            this.tokenizationRepositoryProvider = SingleCheck.provider(create);
        }

        public TokenizationRepository getRepository() {
            return this.tokenizationRepositoryProvider.get();
        }
    }

    private DaggerTokenizationFeatureComponent() {
    }

    public static TokenizationFeatureComponent.Factory factory() {
        return new Factory();
    }
}
