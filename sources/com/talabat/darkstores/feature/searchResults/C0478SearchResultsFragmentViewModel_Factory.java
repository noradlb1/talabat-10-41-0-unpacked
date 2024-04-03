package com.talabat.darkstores.feature.searchResults;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* renamed from: com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel_Factory  reason: case insensitive filesystem */
public final class C0478SearchResultsFragmentViewModel_Factory {
    private final Provider<BuildSearchNavigationActionUseCase> buildSearchNavigationActionProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ProductImpressionTracker> impressionTrackerProvider;
    private final Provider<PagingSourceFactory> pagingSourceFactoryProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<SearchTracker> searchTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public C0478SearchResultsFragmentViewModel_Factory(Provider<DiscoveryRepo> provider, Provider<PagingSourceFactory> provider2, Provider<SearchTracker> provider3, Provider<ProductImpressionTracker> provider4, Provider<IScreenTracker> provider5, Provider<CompositeDisposable> provider6, Provider<BuildSearchNavigationActionUseCase> provider7, Provider<ITalabatFeatureFlag> provider8, Provider<ITalabatExperiment> provider9) {
        this.discoveryRepoProvider = provider;
        this.pagingSourceFactoryProvider = provider2;
        this.searchTrackerProvider = provider3;
        this.impressionTrackerProvider = provider4;
        this.screenTrackerProvider = provider5;
        this.compositeDisposableProvider = provider6;
        this.buildSearchNavigationActionProvider = provider7;
        this.talabatFeatureFlagProvider = provider8;
        this.talabatExperimentProvider = provider9;
    }

    public static C0478SearchResultsFragmentViewModel_Factory create(Provider<DiscoveryRepo> provider, Provider<PagingSourceFactory> provider2, Provider<SearchTracker> provider3, Provider<ProductImpressionTracker> provider4, Provider<IScreenTracker> provider5, Provider<CompositeDisposable> provider6, Provider<BuildSearchNavigationActionUseCase> provider7, Provider<ITalabatFeatureFlag> provider8, Provider<ITalabatExperiment> provider9) {
        return new C0478SearchResultsFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SearchResultsFragmentViewModel newInstance(DiscoveryRepo discoveryRepo, PagingSourceFactory pagingSourceFactory, SearchTracker searchTracker, ProductImpressionTracker productImpressionTracker, IScreenTracker iScreenTracker, CompositeDisposable compositeDisposable, SearchResultsFragmentViewModel.Arguments arguments, BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment) {
        return new SearchResultsFragmentViewModel(discoveryRepo, pagingSourceFactory, searchTracker, productImpressionTracker, iScreenTracker, compositeDisposable, arguments, buildSearchNavigationActionUseCase, iTalabatFeatureFlag, iTalabatExperiment);
    }

    public SearchResultsFragmentViewModel get(SearchResultsFragmentViewModel.Arguments arguments) {
        return newInstance(this.discoveryRepoProvider.get(), this.pagingSourceFactoryProvider.get(), this.searchTrackerProvider.get(), this.impressionTrackerProvider.get(), this.screenTrackerProvider.get(), this.compositeDisposableProvider.get(), arguments, this.buildSearchNavigationActionProvider.get(), this.talabatFeatureFlagProvider.get(), this.talabatExperimentProvider.get());
    }
}
