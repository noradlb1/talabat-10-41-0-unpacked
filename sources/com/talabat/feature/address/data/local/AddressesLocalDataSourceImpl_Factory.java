package com.talabat.feature.address.data.local;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressesLocalDataSourceImpl_Factory implements Factory<AddressesLocalDataSourceImpl> {
    private final Provider<Gson> gsonProvider;
    private final Provider<AddressSharedPreferences> prefsProvider;

    public AddressesLocalDataSourceImpl_Factory(Provider<AddressSharedPreferences> provider, Provider<Gson> provider2) {
        this.prefsProvider = provider;
        this.gsonProvider = provider2;
    }

    public static AddressesLocalDataSourceImpl_Factory create(Provider<AddressSharedPreferences> provider, Provider<Gson> provider2) {
        return new AddressesLocalDataSourceImpl_Factory(provider, provider2);
    }

    public static AddressesLocalDataSourceImpl newInstance(AddressSharedPreferences addressSharedPreferences, Gson gson) {
        return new AddressesLocalDataSourceImpl(addressSharedPreferences, gson);
    }

    public AddressesLocalDataSourceImpl get() {
        return newInstance(this.prefsProvider.get(), this.gsonProvider.get());
    }
}
