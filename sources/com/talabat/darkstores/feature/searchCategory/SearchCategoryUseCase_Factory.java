package com.talabat.darkstores.feature.searchCategory;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.tracking.SearchTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SearchCategoryUseCase_Factory implements Factory<SearchCategoryUseCase> {
    private final Provider<SearchRepository> searchRepositoryProvider;
    private final Provider<SearchTracker> searchTrackerProvider;

    public SearchCategoryUseCase_Factory(Provider<SearchRepository> provider, Provider<SearchTracker> provider2) {
        this.searchRepositoryProvider = provider;
        this.searchTrackerProvider = provider2;
    }

    public static SearchCategoryUseCase_Factory create(Provider<SearchRepository> provider, Provider<SearchTracker> provider2) {
        return new SearchCategoryUseCase_Factory(provider, provider2);
    }

    public static SearchCategoryUseCase newInstance(SearchRepository searchRepository, SearchTracker searchTracker) {
        return new SearchCategoryUseCase(searchRepository, searchTracker);
    }

    public SearchCategoryUseCase get() {
        return newInstance(this.searchRepositoryProvider.get(), this.searchTrackerProvider.get());
    }
}
