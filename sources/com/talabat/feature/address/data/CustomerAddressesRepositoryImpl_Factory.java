package com.talabat.feature.address.data;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.address.data.convert.AddressDtoToAddressMapper;
import com.talabat.feature.address.data.local.AddressesLocalDataSource;
import com.talabat.feature.address.data.remote.AddressDtoMapper;
import com.talabat.feature.address.data.remote.AddressRemoteDataSource;
import com.talabat.feature.address.data.remote.api.AddressApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.address.data.di.FallbackApi"})
public final class CustomerAddressesRepositoryImpl_Factory implements Factory<CustomerAddressesRepositoryImpl> {
    private final Provider<AddressApi> addressApiProvider;
    private final Provider<AddressDtoMapper> addressDtoMapperProvider;
    private final Provider<AddressDtoToAddressMapper> addressDtoToAddressMapperProvider;
    private final Provider<AddressRemoteDataSource> addressRemoteDataSourceProvider;
    private final Provider<AddressesLocalDataSource> addressesLocalDataSourceProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<AddressApi> fallBackAddressApiProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public CustomerAddressesRepositoryImpl_Factory(Provider<AddressApi> provider, Provider<AddressApi> provider2, Provider<AddressRemoteDataSource> provider3, Provider<AddressDtoMapper> provider4, Provider<AddressDtoToAddressMapper> provider5, Provider<TokenRepository> provider6, Provider<AddressesLocalDataSource> provider7, Provider<CoroutineDispatchersFactory> provider8, Provider<ITalabatFeatureFlag> provider9) {
        this.addressApiProvider = provider;
        this.fallBackAddressApiProvider = provider2;
        this.addressRemoteDataSourceProvider = provider3;
        this.addressDtoMapperProvider = provider4;
        this.addressDtoToAddressMapperProvider = provider5;
        this.tokenRepositoryProvider = provider6;
        this.addressesLocalDataSourceProvider = provider7;
        this.coroutineDispatchersFactoryProvider = provider8;
        this.talabatFeatureFlagProvider = provider9;
    }

    public static CustomerAddressesRepositoryImpl_Factory create(Provider<AddressApi> provider, Provider<AddressApi> provider2, Provider<AddressRemoteDataSource> provider3, Provider<AddressDtoMapper> provider4, Provider<AddressDtoToAddressMapper> provider5, Provider<TokenRepository> provider6, Provider<AddressesLocalDataSource> provider7, Provider<CoroutineDispatchersFactory> provider8, Provider<ITalabatFeatureFlag> provider9) {
        return new CustomerAddressesRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static CustomerAddressesRepositoryImpl newInstance(AddressApi addressApi, AddressApi addressApi2, AddressRemoteDataSource addressRemoteDataSource, AddressDtoMapper addressDtoMapper, AddressDtoToAddressMapper addressDtoToAddressMapper, TokenRepository tokenRepository, AddressesLocalDataSource addressesLocalDataSource, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new CustomerAddressesRepositoryImpl(addressApi, addressApi2, addressRemoteDataSource, addressDtoMapper, addressDtoToAddressMapper, tokenRepository, addressesLocalDataSource, coroutineDispatchersFactory, iTalabatFeatureFlag);
    }

    public CustomerAddressesRepositoryImpl get() {
        return newInstance(this.addressApiProvider.get(), this.fallBackAddressApiProvider.get(), this.addressRemoteDataSourceProvider.get(), this.addressDtoMapperProvider.get(), this.addressDtoToAddressMapperProvider.get(), this.tokenRepositoryProvider.get(), this.addressesLocalDataSourceProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
