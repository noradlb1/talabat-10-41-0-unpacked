package com.talabat.darkstores.feature.product;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstorescart.data.model.Product;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* renamed from: com.talabat.darkstores.feature.product.ProductFragmentViewModel_Factory  reason: case insensitive filesystem */
public final class C0477ProductFragmentViewModel_Factory {
    private final Provider<BasketLifeTimeTooltipUseCase> basketLifeTimeTooltipUseCaseProvider;
    private final Provider<BuildCartNavigationActionUseCase> buildCartNavigationActionProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ITalabatFeatureFlag> iTalabatFeatureFlagProvider;
    private final Provider<ProductSwimlanesUseCase> productSwimlanesUseCaseProvider;
    private final Provider<ProductTracker> productTrackerProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<SwimlanesTracker> swimlanesTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;

    public C0477ProductFragmentViewModel_Factory(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<CompositeDisposable> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<SwimlanesTracker> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<BasketLifeTimeTooltipUseCase> provider8, Provider<ProductSwimlanesUseCase> provider9, Provider<RxSchedulersFactory> provider10, Provider<ITalabatExperiment> provider11, Provider<ConfigurationLocalRepository> provider12, Provider<BuildCartNavigationActionUseCase> provider13) {
        this.discoveryRepoProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.compositeDisposableProvider = provider3;
        this.trackerProvider = provider4;
        this.productTrackerProvider = provider5;
        this.swimlanesTrackerProvider = provider6;
        this.iTalabatFeatureFlagProvider = provider7;
        this.basketLifeTimeTooltipUseCaseProvider = provider8;
        this.productSwimlanesUseCaseProvider = provider9;
        this.rxSchedulersFactoryProvider = provider10;
        this.talabatExperimentProvider = provider11;
        this.configurationLocalRepositoryProvider = provider12;
        this.buildCartNavigationActionProvider = provider13;
    }

    public static C0477ProductFragmentViewModel_Factory create(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<CompositeDisposable> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<SwimlanesTracker> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<BasketLifeTimeTooltipUseCase> provider8, Provider<ProductSwimlanesUseCase> provider9, Provider<RxSchedulersFactory> provider10, Provider<ITalabatExperiment> provider11, Provider<ConfigurationLocalRepository> provider12, Provider<BuildCartNavigationActionUseCase> provider13) {
        return new C0477ProductFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static ProductFragmentViewModel newInstance(DiscoveryRepo discoveryRepo, DarkstoresRepo darkstoresRepo, Product product, CompositeDisposable compositeDisposable, DarkstoresEventTracker darkstoresEventTracker, ProductTracker productTracker, SwimlanesTracker swimlanesTracker, ITalabatFeatureFlag iTalabatFeatureFlag, BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase, ProductSwimlanesUseCase productSwimlanesUseCase, RxSchedulersFactory rxSchedulersFactory, ITalabatExperiment iTalabatExperiment, ConfigurationLocalRepository configurationLocalRepository, BuildCartNavigationActionUseCase buildCartNavigationActionUseCase) {
        return new ProductFragmentViewModel(discoveryRepo, darkstoresRepo, product, compositeDisposable, darkstoresEventTracker, productTracker, swimlanesTracker, iTalabatFeatureFlag, basketLifeTimeTooltipUseCase, productSwimlanesUseCase, rxSchedulersFactory, iTalabatExperiment, configurationLocalRepository, buildCartNavigationActionUseCase);
    }

    public ProductFragmentViewModel get(Product product) {
        return newInstance(this.discoveryRepoProvider.get(), this.darkstoresRepoProvider.get(), product, this.compositeDisposableProvider.get(), this.trackerProvider.get(), this.productTrackerProvider.get(), this.swimlanesTrackerProvider.get(), this.iTalabatFeatureFlagProvider.get(), this.basketLifeTimeTooltipUseCaseProvider.get(), this.productSwimlanesUseCaseProvider.get(), this.rxSchedulersFactoryProvider.get(), this.talabatExperimentProvider.get(), this.configurationLocalRepositoryProvider.get(), this.buildCartNavigationActionProvider.get());
    }
}
