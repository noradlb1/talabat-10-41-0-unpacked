package com.talabat.darkstores.data.search;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class SearchRepository_Factory implements Factory<SearchRepository> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<QCommerceSearchApi> qCommerceSearchApiProvider;
    private final Provider<QCommerceGroceryApi> qcGroceryCategorySearchApiProvider;
    private final Provider<IRemoteConfigurationDataSource> remoteConfigDataSourceProvider;
    private final Provider<SearchApi> searchApiProvider;

    public SearchRepository_Factory(Provider<ConfigurationParameters> provider, Provider<IRemoteConfigurationDataSource> provider2, Provider<DarkstoresRepo> provider3, Provider<SearchApi> provider4, Provider<QCommerceGroceryApi> provider5, Provider<QCommerceSearchApi> provider6, Provider<Scheduler> provider7) {
        this.configurationParametersProvider = provider;
        this.remoteConfigDataSourceProvider = provider2;
        this.darkstoresRepoProvider = provider3;
        this.searchApiProvider = provider4;
        this.qcGroceryCategorySearchApiProvider = provider5;
        this.qCommerceSearchApiProvider = provider6;
        this.ioSchedulerProvider = provider7;
    }

    public static SearchRepository_Factory create(Provider<ConfigurationParameters> provider, Provider<IRemoteConfigurationDataSource> provider2, Provider<DarkstoresRepo> provider3, Provider<SearchApi> provider4, Provider<QCommerceGroceryApi> provider5, Provider<QCommerceSearchApi> provider6, Provider<Scheduler> provider7) {
        return new SearchRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SearchRepository newInstance(ConfigurationParameters configurationParameters, IRemoteConfigurationDataSource iRemoteConfigurationDataSource, DarkstoresRepo darkstoresRepo, SearchApi searchApi, QCommerceGroceryApi qCommerceGroceryApi, QCommerceSearchApi qCommerceSearchApi, Scheduler scheduler) {
        return new SearchRepository(configurationParameters, iRemoteConfigurationDataSource, darkstoresRepo, searchApi, qCommerceGroceryApi, qCommerceSearchApi, scheduler);
    }

    public SearchRepository get() {
        return newInstance(this.configurationParametersProvider.get(), this.remoteConfigDataSourceProvider.get(), this.darkstoresRepoProvider.get(), this.searchApiProvider.get(), this.qcGroceryCategorySearchApiProvider.get(), this.qCommerceSearchApiProvider.get(), this.ioSchedulerProvider.get());
    }
}
