package com.talabat.darkstores.data.tracking.sort.tracker;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SortAndFilterOptionTrackerImpl_Factory implements Factory<SortAndFilterOptionTrackerImpl> {
    private final Provider<LocationTrackingProvider> locationTrackingProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public SortAndFilterOptionTrackerImpl_Factory(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<LocationTrackingProvider> provider3) {
        this.talabatTrackerProvider = provider;
        this.storeInfoTrackingProvider = provider2;
        this.locationTrackingProvider = provider3;
    }

    public static SortAndFilterOptionTrackerImpl_Factory create(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<LocationTrackingProvider> provider3) {
        return new SortAndFilterOptionTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static SortAndFilterOptionTrackerImpl newInstance(TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, LocationTrackingProvider locationTrackingProvider2) {
        return new SortAndFilterOptionTrackerImpl(talabatTracker, storeInfoTrackingProvider2, locationTrackingProvider2);
    }

    public SortAndFilterOptionTrackerImpl get() {
        return newInstance(this.talabatTrackerProvider.get(), this.storeInfoTrackingProvider.get(), this.locationTrackingProvider.get());
    }
}
