package com.talabat.darkstores.feature.search;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.domain.presearch.GetPreSearchSwimlaneUseCase;
import com.talabat.darkstores.feature.model.mapper.PreSearchSwimlaneToListItemsMapper;
import com.talabat.darkstores.feature.model.mapper.RecentSearchesToListItemsMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class SearchFragmentViewModel_Factory implements Factory<SearchFragmentViewModel> {
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<GetPreSearchSwimlaneUseCase> getPreSearchSwimlaneProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<PreSearchSwimlaneToListItemsMapper> mapPreSearchSwimlaneToItemsProvider;
    private final Provider<RecentSearchesToListItemsMapper> mapRecentSearchesToItemsProvider;
    private final Provider<SearchTracker> searchTrackerProvider;

    public SearchFragmentViewModel_Factory(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<SearchTracker> provider3, Provider<CompositeDisposable> provider4, Provider<Scheduler> provider5, Provider<RecentSearchesToListItemsMapper> provider6, Provider<PreSearchSwimlaneToListItemsMapper> provider7, Provider<GetPreSearchSwimlaneUseCase> provider8) {
        this.discoveryRepoProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.searchTrackerProvider = provider3;
        this.compositeDisposableProvider = provider4;
        this.ioSchedulerProvider = provider5;
        this.mapRecentSearchesToItemsProvider = provider6;
        this.mapPreSearchSwimlaneToItemsProvider = provider7;
        this.getPreSearchSwimlaneProvider = provider8;
    }

    public static SearchFragmentViewModel_Factory create(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<SearchTracker> provider3, Provider<CompositeDisposable> provider4, Provider<Scheduler> provider5, Provider<RecentSearchesToListItemsMapper> provider6, Provider<PreSearchSwimlaneToListItemsMapper> provider7, Provider<GetPreSearchSwimlaneUseCase> provider8) {
        return new SearchFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static SearchFragmentViewModel newInstance(DiscoveryRepo discoveryRepo, DarkstoresRepo darkstoresRepo, SearchTracker searchTracker, CompositeDisposable compositeDisposable, Scheduler scheduler, RecentSearchesToListItemsMapper recentSearchesToListItemsMapper, PreSearchSwimlaneToListItemsMapper preSearchSwimlaneToListItemsMapper, GetPreSearchSwimlaneUseCase getPreSearchSwimlaneUseCase) {
        return new SearchFragmentViewModel(discoveryRepo, darkstoresRepo, searchTracker, compositeDisposable, scheduler, recentSearchesToListItemsMapper, preSearchSwimlaneToListItemsMapper, getPreSearchSwimlaneUseCase);
    }

    public SearchFragmentViewModel get() {
        return newInstance(this.discoveryRepoProvider.get(), this.darkstoresRepoProvider.get(), this.searchTrackerProvider.get(), this.compositeDisposableProvider.get(), this.ioSchedulerProvider.get(), this.mapRecentSearchesToItemsProvider.get(), this.mapPreSearchSwimlaneToItemsProvider.get(), this.getPreSearchSwimlaneProvider.get());
    }
}
