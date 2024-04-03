package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* renamed from: com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew_Factory  reason: case insensitive filesystem */
public final class C0476SubcategoriesFragmentViewModelNew_Factory {
    private final Provider<BasketLifeTimeTooltipUseCase> basketLifeTimeTooltipUseCaseProvider;
    private final Provider<BuildCartNavigationActionUseCase> buildCartNavigationActionUseCaseProvider;
    private final Provider<BuildSearchNavigationActionUseCase> buildSearchNavigationActionProvider;
    private final Provider<DarkstoresEventTracker> darkStoreEventTrackerProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<GetSortOnPLPEnabledUseCase> getSortOnPLPEnabledUseCaseProvider;
    private final Provider<ProductImpressionTracker> impressionTrackerProvider;
    private final Provider<ProductTracker> productTrackerProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<SortAndFilterOptionTracker> sortAndFilterOptionTrackerProvider;

    public C0476SubcategoriesFragmentViewModelNew_Factory(Provider<DiscoveryRepo> provider, Provider<DarkstoresEventTracker> provider2, Provider<ProductTracker> provider3, Provider<IScreenTracker> provider4, Provider<ProductImpressionTracker> provider5, Provider<BuildSearchNavigationActionUseCase> provider6, Provider<BasketLifeTimeTooltipUseCase> provider7, Provider<RxSchedulersFactory> provider8, Provider<BuildCartNavigationActionUseCase> provider9, Provider<GetSortOnPLPEnabledUseCase> provider10, Provider<SortAndFilterOptionTracker> provider11) {
        this.discoveryRepoProvider = provider;
        this.darkStoreEventTrackerProvider = provider2;
        this.productTrackerProvider = provider3;
        this.screenTrackerProvider = provider4;
        this.impressionTrackerProvider = provider5;
        this.buildSearchNavigationActionProvider = provider6;
        this.basketLifeTimeTooltipUseCaseProvider = provider7;
        this.rxSchedulersFactoryProvider = provider8;
        this.buildCartNavigationActionUseCaseProvider = provider9;
        this.getSortOnPLPEnabledUseCaseProvider = provider10;
        this.sortAndFilterOptionTrackerProvider = provider11;
    }

    public static C0476SubcategoriesFragmentViewModelNew_Factory create(Provider<DiscoveryRepo> provider, Provider<DarkstoresEventTracker> provider2, Provider<ProductTracker> provider3, Provider<IScreenTracker> provider4, Provider<ProductImpressionTracker> provider5, Provider<BuildSearchNavigationActionUseCase> provider6, Provider<BasketLifeTimeTooltipUseCase> provider7, Provider<RxSchedulersFactory> provider8, Provider<BuildCartNavigationActionUseCase> provider9, Provider<GetSortOnPLPEnabledUseCase> provider10, Provider<SortAndFilterOptionTracker> provider11) {
        return new C0476SubcategoriesFragmentViewModelNew_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SubcategoriesFragmentViewModelNew newInstance(DiscoveryRepo discoveryRepo, String str, String str2, EventOrigin eventOrigin, DarkstoresEventTracker darkstoresEventTracker, ProductTracker productTracker, IScreenTracker iScreenTracker, ProductImpressionTracker productImpressionTracker, BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase, BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase, RxSchedulersFactory rxSchedulersFactory, BuildCartNavigationActionUseCase buildCartNavigationActionUseCase, GetSortOnPLPEnabledUseCase getSortOnPLPEnabledUseCase, SortAndFilterOptionTracker sortAndFilterOptionTracker) {
        return new SubcategoriesFragmentViewModelNew(discoveryRepo, str, str2, eventOrigin, darkstoresEventTracker, productTracker, iScreenTracker, productImpressionTracker, buildSearchNavigationActionUseCase, basketLifeTimeTooltipUseCase, rxSchedulersFactory, buildCartNavigationActionUseCase, getSortOnPLPEnabledUseCase, sortAndFilterOptionTracker);
    }

    public SubcategoriesFragmentViewModelNew get(String str, String str2, EventOrigin eventOrigin) {
        return newInstance(this.discoveryRepoProvider.get(), str, str2, eventOrigin, this.darkStoreEventTrackerProvider.get(), this.productTrackerProvider.get(), this.screenTrackerProvider.get(), this.impressionTrackerProvider.get(), this.buildSearchNavigationActionProvider.get(), this.basketLifeTimeTooltipUseCaseProvider.get(), this.rxSchedulersFactoryProvider.get(), this.buildCartNavigationActionUseCaseProvider.get(), this.getSortOnPLPEnabledUseCaseProvider.get(), this.sortAndFilterOptionTrackerProvider.get());
    }
}
