package com.talabat.feature.pickup.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.pickup.data.local.InMemoryDataSource;
import com.talabat.talabatcommon.feature.vendorTags.domain.RequestVendorTagsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupRepositoryImpl_Factory implements Factory<PickupRepositoryImpl> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<InMemoryDataSource> localDataSourceProvider;
    private final Provider<PickupApi> pickupApiProvider;
    private final Provider<PickupSharedPreferences> prefsProvider;
    private final Provider<RxSchedulersFactory> schedulersFactoryProvider;
    private final Provider<RequestVendorTagsUseCase> vendorTagsUseCaseProvider;

    public PickupRepositoryImpl_Factory(Provider<PickupApi> provider, Provider<RxSchedulersFactory> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<RequestVendorTagsUseCase> provider4, Provider<PickupSharedPreferences> provider5, Provider<InMemoryDataSource> provider6) {
        this.pickupApiProvider = provider;
        this.schedulersFactoryProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.vendorTagsUseCaseProvider = provider4;
        this.prefsProvider = provider5;
        this.localDataSourceProvider = provider6;
    }

    public static PickupRepositoryImpl_Factory create(Provider<PickupApi> provider, Provider<RxSchedulersFactory> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<RequestVendorTagsUseCase> provider4, Provider<PickupSharedPreferences> provider5, Provider<InMemoryDataSource> provider6) {
        return new PickupRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PickupRepositoryImpl newInstance(PickupApi pickupApi, RxSchedulersFactory rxSchedulersFactory, ConfigurationLocalRepository configurationLocalRepository, RequestVendorTagsUseCase requestVendorTagsUseCase, PickupSharedPreferences pickupSharedPreferences, InMemoryDataSource inMemoryDataSource) {
        return new PickupRepositoryImpl(pickupApi, rxSchedulersFactory, configurationLocalRepository, requestVendorTagsUseCase, pickupSharedPreferences, inMemoryDataSource);
    }

    public PickupRepositoryImpl get() {
        return newInstance(this.pickupApiProvider.get(), this.schedulersFactoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.vendorTagsUseCaseProvider.get(), this.prefsProvider.get(), this.localDataSourceProvider.get());
    }
}
