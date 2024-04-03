package com.talabat.feature.address.data.remote.impl;

import com.talabat.feature.address.data.remote.AddressDtoMapper;
import com.talabat.feature.address.data.remote.api.AddressApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressRemoteDataSourceImpl_Factory implements Factory<AddressRemoteDataSourceImpl> {
    private final Provider<AddressApi> addressApiProvider;
    private final Provider<AddressDtoMapper> addressDtoMapperProvider;

    public AddressRemoteDataSourceImpl_Factory(Provider<AddressApi> provider, Provider<AddressDtoMapper> provider2) {
        this.addressApiProvider = provider;
        this.addressDtoMapperProvider = provider2;
    }

    public static AddressRemoteDataSourceImpl_Factory create(Provider<AddressApi> provider, Provider<AddressDtoMapper> provider2) {
        return new AddressRemoteDataSourceImpl_Factory(provider, provider2);
    }

    public static AddressRemoteDataSourceImpl newInstance(AddressApi addressApi, AddressDtoMapper addressDtoMapper) {
        return new AddressRemoteDataSourceImpl(addressApi, addressDtoMapper);
    }

    public AddressRemoteDataSourceImpl get() {
        return newInstance(this.addressApiProvider.get(), this.addressDtoMapperProvider.get());
    }
}
