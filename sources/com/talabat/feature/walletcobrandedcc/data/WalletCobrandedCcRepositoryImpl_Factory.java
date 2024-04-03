package com.talabat.feature.walletcobrandedcc.data;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletCobrandedCcRepositoryImpl_Factory implements Factory<WalletCobrandedCcRepositoryImpl> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<WalletCobrandedCcRemoteDataSource> walletCobrandedCcRemoteDataSourceProvider;

    public WalletCobrandedCcRepositoryImpl_Factory(Provider<LocationConfigurationRepository> provider, Provider<WalletCobrandedCcRemoteDataSource> provider2) {
        this.locationConfigurationRepositoryProvider = provider;
        this.walletCobrandedCcRemoteDataSourceProvider = provider2;
    }

    public static WalletCobrandedCcRepositoryImpl_Factory create(Provider<LocationConfigurationRepository> provider, Provider<WalletCobrandedCcRemoteDataSource> provider2) {
        return new WalletCobrandedCcRepositoryImpl_Factory(provider, provider2);
    }

    public static WalletCobrandedCcRepositoryImpl newInstance(LocationConfigurationRepository locationConfigurationRepository, WalletCobrandedCcRemoteDataSource walletCobrandedCcRemoteDataSource) {
        return new WalletCobrandedCcRepositoryImpl(locationConfigurationRepository, walletCobrandedCcRemoteDataSource);
    }

    public WalletCobrandedCcRepositoryImpl get() {
        return newInstance(this.locationConfigurationRepositoryProvider.get(), this.walletCobrandedCcRemoteDataSourceProvider.get());
    }
}
