package com.talabat.darkstores.feature.searchResults;

import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
public final class SearchResultsFragmentViewModel_Factory_Impl implements SearchResultsFragmentViewModel.Factory {
    private final C0478SearchResultsFragmentViewModel_Factory delegateFactory;

    public SearchResultsFragmentViewModel_Factory_Impl(C0478SearchResultsFragmentViewModel_Factory searchResultsFragmentViewModel_Factory) {
        this.delegateFactory = searchResultsFragmentViewModel_Factory;
    }

    public SearchResultsFragmentViewModel create(SearchResultsFragmentViewModel.Arguments arguments) {
        return this.delegateFactory.get(arguments);
    }

    public static Provider<SearchResultsFragmentViewModel.Factory> create(C0478SearchResultsFragmentViewModel_Factory searchResultsFragmentViewModel_Factory) {
        return InstanceFactory.create(new SearchResultsFragmentViewModel_Factory_Impl(searchResultsFragmentViewModel_Factory));
    }
}
