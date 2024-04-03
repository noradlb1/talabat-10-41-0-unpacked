package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
@DaggerGenerated
/* renamed from: com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel_Factory  reason: case insensitive filesystem */
public final class C0475SubcategoriesFragmentViewModel_Factory {
    private final Provider<DarkstoresCartRepository> cartRepositoryProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ProductImpressionTracker> impressionTrackerProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<ProductTracker> productTrackerProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;

    public C0475SubcategoriesFragmentViewModel_Factory(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<DarkstoresCartRepository> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<ProductImpressionTracker> provider6, Provider<Scheduler> provider7) {
        this.discoveryRepoProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.cartRepositoryProvider = provider3;
        this.trackerProvider = provider4;
        this.productTrackerProvider = provider5;
        this.impressionTrackerProvider = provider6;
        this.ioSchedulerProvider = provider7;
    }

    public static C0475SubcategoriesFragmentViewModel_Factory create(Provider<DiscoveryRepo> provider, Provider<DarkstoresRepo> provider2, Provider<DarkstoresCartRepository> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<ProductImpressionTracker> provider6, Provider<Scheduler> provider7) {
        return new C0475SubcategoriesFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SubcategoriesFragmentViewModel newInstance(DiscoveryRepo discoveryRepo, DarkstoresRepo darkstoresRepo, DarkstoresCartRepository darkstoresCartRepository, String str, String str2, EventOrigin eventOrigin, DarkstoresEventTracker darkstoresEventTracker, ProductTracker productTracker, ProductImpressionTracker productImpressionTracker, Scheduler scheduler) {
        return new SubcategoriesFragmentViewModel(discoveryRepo, darkstoresRepo, darkstoresCartRepository, str, str2, eventOrigin, darkstoresEventTracker, productTracker, productImpressionTracker, scheduler);
    }

    public SubcategoriesFragmentViewModel get(String str, String str2, EventOrigin eventOrigin) {
        return newInstance(this.discoveryRepoProvider.get(), this.darkstoresRepoProvider.get(), this.cartRepositoryProvider.get(), str, str2, eventOrigin, this.trackerProvider.get(), this.productTrackerProvider.get(), this.impressionTrackerProvider.get(), this.ioSchedulerProvider.get());
    }
}
