package com.talabat.darkstores.di;

import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.impression.BannerImpressionMapper;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.HeroBannerImpressionTracker"})
public final class DarkstoresApplicationModule_ProvideHeroBannerProductImpressionTrackerFactory implements Factory<ProductImpressionTracker> {
    private final Provider<BannerImpressionMapper> bannerImpressionMapperProvider;
    private final Provider<TalabatImpressionTracker> impressionTrackerProvider;
    private final Provider<LocationTrackingProvider> locationTrackingProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;

    public DarkstoresApplicationModule_ProvideHeroBannerProductImpressionTrackerFactory(Provider<BannerImpressionMapper> provider, Provider<TalabatImpressionTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        this.bannerImpressionMapperProvider = provider;
        this.impressionTrackerProvider = provider2;
        this.storeInfoTrackingProvider = provider3;
        this.locationTrackingProvider = provider4;
    }

    public static DarkstoresApplicationModule_ProvideHeroBannerProductImpressionTrackerFactory create(Provider<BannerImpressionMapper> provider, Provider<TalabatImpressionTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        return new DarkstoresApplicationModule_ProvideHeroBannerProductImpressionTrackerFactory(provider, provider2, provider3, provider4);
    }

    public static ProductImpressionTracker provideHeroBannerProductImpressionTracker(BannerImpressionMapper bannerImpressionMapper, TalabatImpressionTracker talabatImpressionTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, LocationTrackingProvider locationTrackingProvider2) {
        return (ProductImpressionTracker) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideHeroBannerProductImpressionTracker(bannerImpressionMapper, talabatImpressionTracker, storeInfoTrackingProvider2, locationTrackingProvider2));
    }

    public ProductImpressionTracker get() {
        return provideHeroBannerProductImpressionTracker(this.bannerImpressionMapperProvider.get(), this.impressionTrackerProvider.get(), this.storeInfoTrackingProvider.get(), this.locationTrackingProvider.get());
    }
}
