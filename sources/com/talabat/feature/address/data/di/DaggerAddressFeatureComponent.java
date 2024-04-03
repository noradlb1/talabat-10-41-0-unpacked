package com.talabat.feature.address.data.di;

import android.content.Context;
import com.google.gson.Gson;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.domain.address.CustomerAddressesRepository;
import com.talabat.feature.address.data.CustomerAddressesRepositoryImpl;
import com.talabat.feature.address.data.CustomerAddressesRepositoryImpl_Factory;
import com.talabat.feature.address.data.convert.AddressDtoToAddressMapper_Factory;
import com.talabat.feature.address.data.di.AddressFeatureComponent;
import com.talabat.feature.address.data.local.AddressSharedPreferences;
import com.talabat.feature.address.data.local.AddressSharedPreferences_Factory;
import com.talabat.feature.address.data.local.AddressesLocalDataSourceImpl;
import com.talabat.feature.address.data.local.AddressesLocalDataSourceImpl_Factory;
import com.talabat.feature.address.data.remote.AddressDtoMapper_Factory;
import com.talabat.feature.address.data.remote.impl.AddressRemoteDataSourceImpl;
import com.talabat.feature.address.data.remote.impl.AddressRemoteDataSourceImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerAddressFeatureComponent {

    public static final class AddressFeatureComponentImpl implements AddressFeatureComponent {
        private final AddressFeatureComponentImpl addressFeatureComponentImpl;
        private Provider<AddressRemoteDataSourceImpl> addressRemoteDataSourceImplProvider;
        private Provider<AddressSharedPreferences> addressSharedPreferencesProvider;
        private Provider<AddressesLocalDataSourceImpl> addressesLocalDataSourceImplProvider;
        private Provider<CustomerAddressesRepositoryImpl> customerAddressesRepositoryImplProvider;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TokenRepository> getTokenRepositoryProvider;
        private Provider<CustomerAddressesRepository> repositoryProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
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

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        public static final class GetTokenRepositoryProvider implements Provider<TokenRepository> {
            private final TokenCoreLibApi tokenCoreLibApi;

            public GetTokenRepositoryProvider(TokenCoreLibApi tokenCoreLibApi2) {
                this.tokenCoreLibApi = tokenCoreLibApi2;
            }

            public TokenRepository get() {
                return (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getTokenRepository());
            }
        }

        private AddressFeatureComponentImpl(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi, TokenCoreLibApi tokenCoreLibApi) {
            this.addressFeatureComponentImpl = this;
            initialize(contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi, tokenCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi, TokenCoreLibApi tokenCoreLibApi) {
            this.addressRemoteDataSourceImplProvider = AddressRemoteDataSourceImpl_Factory.create(AddressNetworkModule_RestFactory.create(), AddressDtoMapper_Factory.create());
            this.getTokenRepositoryProvider = new GetTokenRepositoryProvider(tokenCoreLibApi);
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            this.addressSharedPreferencesProvider = AddressSharedPreferences_Factory.create(getContextProvider2);
            GetGsonProvider getGsonProvider2 = new GetGsonProvider(parserCoreLibApi);
            this.getGsonProvider = getGsonProvider2;
            this.addressesLocalDataSourceImplProvider = AddressesLocalDataSourceImpl_Factory.create(this.addressSharedPreferencesProvider, getGsonProvider2);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            CustomerAddressesRepositoryImpl_Factory create = CustomerAddressesRepositoryImpl_Factory.create(AddressNetworkModule_RestFactory.create(), AddressNetworkModule_FallbackRestFactory.create(), this.addressRemoteDataSourceImplProvider, AddressDtoMapper_Factory.create(), AddressDtoToAddressMapper_Factory.create(), this.getTokenRepositoryProvider, this.addressesLocalDataSourceImplProvider, this.getCoroutineDispatchersFactoryProvider, this.getTalabatFeatureFlagProvider);
            this.customerAddressesRepositoryImplProvider = create;
            this.repositoryProvider = SingleCheck.provider(create);
        }

        public CustomerAddressesRepository getRepository() {
            return this.repositoryProvider.get();
        }
    }

    public static final class Factory implements AddressFeatureComponent.Factory {
        private Factory() {
        }

        public AddressFeatureComponent create(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi, TokenCoreLibApi tokenCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            return new AddressFeatureComponentImpl(contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi, tokenCoreLibApi);
        }
    }

    private DaggerAddressFeatureComponent() {
    }

    public static AddressFeatureComponent.Factory factory() {
        return new Factory();
    }
}
