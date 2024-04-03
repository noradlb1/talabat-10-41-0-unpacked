package com.talabat.darkstores.data.tracking.impression;

import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProductImpressionTracker_Factory implements Factory<ProductImpressionTracker> {
    private final Provider<BannerImpressionMapper> bannerImpressionMapperProvider;
    private final Provider<LocationTrackingProvider> locationTrackingProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatImpressionTracker> talabatImpressionTrackerProvider;

    public ProductImpressionTracker_Factory(Provider<BannerImpressionMapper> provider, Provider<TalabatImpressionTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        this.bannerImpressionMapperProvider = provider;
        this.talabatImpressionTrackerProvider = provider2;
        this.storeInfoTrackingProvider = provider3;
        this.locationTrackingProvider = provider4;
    }

    public static ProductImpressionTracker_Factory create(Provider<BannerImpressionMapper> provider, Provider<TalabatImpressionTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        return new ProductImpressionTracker_Factory(provider, provider2, provider3, provider4);
    }

    public static ProductImpressionTracker newInstance(BannerImpressionMapper bannerImpressionMapper, TalabatImpressionTracker talabatImpressionTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, LocationTrackingProvider locationTrackingProvider2) {
        return new ProductImpressionTracker(bannerImpressionMapper, talabatImpressionTracker, storeInfoTrackingProvider2, locationTrackingProvider2);
    }

    public ProductImpressionTracker get() {
        return newInstance(this.bannerImpressionMapperProvider.get(), this.talabatImpressionTrackerProvider.get(), this.storeInfoTrackingProvider.get(), this.locationTrackingProvider.get());
    }
}
