package com.talabat.feature.tmart.growth.data;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TMartGrowthRepository_Factory implements Factory<TMartGrowthRepository> {
    private final Provider<String> countryCodeProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;
    private final Provider<TMartGrowthApi> growthApiProvider;

    public TMartGrowthRepository_Factory(Provider<String> provider, Provider<TMartGrowthApi> provider2, Provider<IntegrationGlobalDataModel.Companion> provider3, Provider<CoroutineDispatchersFactory> provider4) {
        this.countryCodeProvider = provider;
        this.growthApiProvider = provider2;
        this.globalDataModelProvider = provider3;
        this.dispatchersFactoryProvider = provider4;
    }

    public static TMartGrowthRepository_Factory create(Provider<String> provider, Provider<TMartGrowthApi> provider2, Provider<IntegrationGlobalDataModel.Companion> provider3, Provider<CoroutineDispatchersFactory> provider4) {
        return new TMartGrowthRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static TMartGrowthRepository newInstance(String str, TMartGrowthApi tMartGrowthApi, IntegrationGlobalDataModel.Companion companion, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new TMartGrowthRepository(str, tMartGrowthApi, companion, coroutineDispatchersFactory);
    }

    public TMartGrowthRepository get() {
        return newInstance(this.countryCodeProvider.get(), this.growthApiProvider.get(), this.globalDataModelProvider.get(), this.dispatchersFactoryProvider.get());
    }
}
