package com.talabat.darkstores.data.tracking.bottomsheet.tracker;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkStoreBottomSheetTrackerImpl_Factory implements Factory<DarkStoreBottomSheetTrackerImpl> {
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public DarkStoreBottomSheetTrackerImpl_Factory(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2) {
        this.talabatTrackerProvider = provider;
        this.storeInfoTrackingProvider = provider2;
    }

    public static DarkStoreBottomSheetTrackerImpl_Factory create(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2) {
        return new DarkStoreBottomSheetTrackerImpl_Factory(provider, provider2);
    }

    public static DarkStoreBottomSheetTrackerImpl newInstance(TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2) {
        return new DarkStoreBottomSheetTrackerImpl(talabatTracker, storeInfoTrackingProvider2);
    }

    public DarkStoreBottomSheetTrackerImpl get() {
        return newInstance(this.talabatTrackerProvider.get(), this.storeInfoTrackingProvider.get());
    }
}
