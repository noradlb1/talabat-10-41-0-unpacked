package com.talabat.feature.darkstorescartlist.data.repository;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.darkstorescartlist.data.local.CartListLocalDataSource;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.data.remote.CartListApi;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCartListRepositoryImpl_Factory implements Factory<DarkstoresCartListRepositoryImpl> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ModelMapper<CartInfoResponse, CartInfo>> cartInfoResponseMapperProvider;
    private final Provider<CartListApi> cartListApiProvider;
    private final Provider<CartListLocalDataSource> cartListLocalDataSourceProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> integrationDataModelProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DarkstoresCartListRepositoryImpl_Factory(Provider<IntegrationGlobalDataModel.Companion> provider, Provider<CartListApi> provider2, Provider<CartListLocalDataSource> provider3, Provider<ModelMapper<CartInfoResponse, CartInfo>> provider4, Provider<IObservabilityManager> provider5, Provider<AppVersionProvider> provider6) {
        this.integrationDataModelProvider = provider;
        this.cartListApiProvider = provider2;
        this.cartListLocalDataSourceProvider = provider3;
        this.cartInfoResponseMapperProvider = provider4;
        this.observabilityManagerProvider = provider5;
        this.appVersionProvider = provider6;
    }

    public static DarkstoresCartListRepositoryImpl_Factory create(Provider<IntegrationGlobalDataModel.Companion> provider, Provider<CartListApi> provider2, Provider<CartListLocalDataSource> provider3, Provider<ModelMapper<CartInfoResponse, CartInfo>> provider4, Provider<IObservabilityManager> provider5, Provider<AppVersionProvider> provider6) {
        return new DarkstoresCartListRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DarkstoresCartListRepositoryImpl newInstance(IntegrationGlobalDataModel.Companion companion, CartListApi cartListApi, CartListLocalDataSource cartListLocalDataSource, ModelMapper<CartInfoResponse, CartInfo> modelMapper, IObservabilityManager iObservabilityManager, AppVersionProvider appVersionProvider2) {
        return new DarkstoresCartListRepositoryImpl(companion, cartListApi, cartListLocalDataSource, modelMapper, iObservabilityManager, appVersionProvider2);
    }

    public DarkstoresCartListRepositoryImpl get() {
        return newInstance(this.integrationDataModelProvider.get(), this.cartListApiProvider.get(), this.cartListLocalDataSourceProvider.get(), this.cartInfoResponseMapperProvider.get(), this.observabilityManagerProvider.get(), this.appVersionProvider.get());
    }
}
