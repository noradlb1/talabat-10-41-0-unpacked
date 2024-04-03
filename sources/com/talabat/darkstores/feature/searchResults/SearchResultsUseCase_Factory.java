package com.talabat.darkstores.feature.searchResults;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.tracking.SearchTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class SearchResultsUseCase_Factory implements Factory<SearchResultsUseCase> {
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<SearchRepository> searchRepositoryProvider;
    private final Provider<SearchTracker> searchTrackerProvider;

    public SearchResultsUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<SearchRepository> provider4, Provider<SearchTracker> provider5) {
        this.darkstoresRepoProvider = provider;
        this.discoveryRepoProvider = provider2;
        this.featureFlagsProvider = provider3;
        this.searchRepositoryProvider = provider4;
        this.searchTrackerProvider = provider5;
    }

    public static SearchResultsUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<SearchRepository> provider4, Provider<SearchTracker> provider5) {
        return new SearchResultsUseCase_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SearchResultsUseCase newInstance(DarkstoresRepo darkstoresRepo, DiscoveryRepo discoveryRepo, ITalabatFeatureFlag iTalabatFeatureFlag, SearchRepository searchRepository, SearchTracker searchTracker) {
        return new SearchResultsUseCase(darkstoresRepo, discoveryRepo, iTalabatFeatureFlag, searchRepository, searchTracker);
    }

    public SearchResultsUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.discoveryRepoProvider.get(), this.featureFlagsProvider.get(), this.searchRepositoryProvider.get(), this.searchTrackerProvider.get());
    }
}
