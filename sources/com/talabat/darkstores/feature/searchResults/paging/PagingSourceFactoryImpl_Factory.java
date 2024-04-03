package com.talabat.darkstores.feature.searchResults.paging;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import com.talabat.darkstores.feature.mission.control.GetPrimaryMissionControlProductsUseCase;
import com.talabat.darkstores.feature.product.usecase.GetSwimlaneProductUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class PagingSourceFactoryImpl_Factory implements Factory<PagingSourceFactoryImpl> {
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<GetLifestyleMissionControlProductsUseCase> getLifestyleMissionControlProductsUseCaseProvider;
    private final Provider<GetPrimaryMissionControlProductsUseCase> getPrimaryMissionControlProductsProvider;
    private final Provider<GetSwimlaneProductUseCase> getSwimlaneProductsProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<SearchResultsUseCase> searchUseCaseProvider;

    public PagingSourceFactoryImpl_Factory(Provider<DiscoveryRepo> provider, Provider<SearchResultsUseCase> provider2, Provider<GetLifestyleMissionControlProductsUseCase> provider3, Provider<GetPrimaryMissionControlProductsUseCase> provider4, Provider<GetSwimlaneProductUseCase> provider5, Provider<Scheduler> provider6) {
        this.discoveryRepoProvider = provider;
        this.searchUseCaseProvider = provider2;
        this.getLifestyleMissionControlProductsUseCaseProvider = provider3;
        this.getPrimaryMissionControlProductsProvider = provider4;
        this.getSwimlaneProductsProvider = provider5;
        this.ioSchedulerProvider = provider6;
    }

    public static PagingSourceFactoryImpl_Factory create(Provider<DiscoveryRepo> provider, Provider<SearchResultsUseCase> provider2, Provider<GetLifestyleMissionControlProductsUseCase> provider3, Provider<GetPrimaryMissionControlProductsUseCase> provider4, Provider<GetSwimlaneProductUseCase> provider5, Provider<Scheduler> provider6) {
        return new PagingSourceFactoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PagingSourceFactoryImpl newInstance(DiscoveryRepo discoveryRepo, SearchResultsUseCase searchResultsUseCase, GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase, GetPrimaryMissionControlProductsUseCase getPrimaryMissionControlProductsUseCase, GetSwimlaneProductUseCase getSwimlaneProductUseCase, Scheduler scheduler) {
        return new PagingSourceFactoryImpl(discoveryRepo, searchResultsUseCase, getLifestyleMissionControlProductsUseCase, getPrimaryMissionControlProductsUseCase, getSwimlaneProductUseCase, scheduler);
    }

    public PagingSourceFactoryImpl get() {
        return newInstance(this.discoveryRepoProvider.get(), this.searchUseCaseProvider.get(), this.getLifestyleMissionControlProductsUseCaseProvider.get(), this.getPrimaryMissionControlProductsProvider.get(), this.getSwimlaneProductsProvider.get(), this.ioSchedulerProvider.get());
    }
}
