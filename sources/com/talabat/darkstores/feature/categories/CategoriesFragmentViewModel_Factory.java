package com.talabat.darkstores.feature.categories;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
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
public final class CategoriesFragmentViewModel_Factory implements Factory<CategoriesFragmentViewModel> {
    private final Provider<BuildSearchNavigationActionUseCase> buildSearchNavigationActionProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;

    public CategoriesFragmentViewModel_Factory(Provider<DiscoveryRepo> provider, Provider<CompositeDisposable> provider2, Provider<DarkstoresEventTracker> provider3, Provider<BuildSearchNavigationActionUseCase> provider4) {
        this.discoveryRepoProvider = provider;
        this.compositeDisposableProvider = provider2;
        this.trackerProvider = provider3;
        this.buildSearchNavigationActionProvider = provider4;
    }

    public static CategoriesFragmentViewModel_Factory create(Provider<DiscoveryRepo> provider, Provider<CompositeDisposable> provider2, Provider<DarkstoresEventTracker> provider3, Provider<BuildSearchNavigationActionUseCase> provider4) {
        return new CategoriesFragmentViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static CategoriesFragmentViewModel newInstance(DiscoveryRepo discoveryRepo, CompositeDisposable compositeDisposable, DarkstoresEventTracker darkstoresEventTracker, BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase) {
        return new CategoriesFragmentViewModel(discoveryRepo, compositeDisposable, darkstoresEventTracker, buildSearchNavigationActionUseCase);
    }

    public CategoriesFragmentViewModel get() {
        return newInstance(this.discoveryRepoProvider.get(), this.compositeDisposableProvider.get(), this.trackerProvider.get(), this.buildSearchNavigationActionProvider.get());
    }
}
