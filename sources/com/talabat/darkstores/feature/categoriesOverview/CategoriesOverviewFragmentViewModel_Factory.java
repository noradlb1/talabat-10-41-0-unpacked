package com.talabat.darkstores.feature.categoriesOverview;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.feature.searchCategory.SearchCategoryUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CategoriesOverviewFragmentViewModel_Factory implements Factory<CategoriesOverviewFragmentViewModel> {
    private final Provider<BuildCategoryProductsNavigationActionUseCase> buildCategoryProductsNavigationActionProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<SearchTracker> searchTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;
    private final Provider<SearchCategoryUseCase> usecaseProvider;

    public CategoriesOverviewFragmentViewModel_Factory(Provider<CompositeDisposable> provider, Provider<SearchCategoryUseCase> provider2, Provider<DarkstoresEventTracker> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<SearchTracker> provider6, Provider<BuildCategoryProductsNavigationActionUseCase> provider7) {
        this.compositeDisposableProvider = provider;
        this.usecaseProvider = provider2;
        this.trackerProvider = provider3;
        this.talabatExperimentProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.searchTrackerProvider = provider6;
        this.buildCategoryProductsNavigationActionProvider = provider7;
    }

    public static CategoriesOverviewFragmentViewModel_Factory create(Provider<CompositeDisposable> provider, Provider<SearchCategoryUseCase> provider2, Provider<DarkstoresEventTracker> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<SearchTracker> provider6, Provider<BuildCategoryProductsNavigationActionUseCase> provider7) {
        return new CategoriesOverviewFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CategoriesOverviewFragmentViewModel newInstance(CompositeDisposable compositeDisposable, SearchCategoryUseCase searchCategoryUseCase, DarkstoresEventTracker darkstoresEventTracker, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, SearchTracker searchTracker, BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase) {
        return new CategoriesOverviewFragmentViewModel(compositeDisposable, searchCategoryUseCase, darkstoresEventTracker, iTalabatExperiment, iTalabatFeatureFlag, searchTracker, buildCategoryProductsNavigationActionUseCase);
    }

    public CategoriesOverviewFragmentViewModel get() {
        return newInstance(this.compositeDisposableProvider.get(), this.usecaseProvider.get(), this.trackerProvider.get(), this.talabatExperimentProvider.get(), this.talabatFeatureFlagProvider.get(), this.searchTrackerProvider.get(), this.buildCategoryProductsNavigationActionProvider.get());
    }
}
