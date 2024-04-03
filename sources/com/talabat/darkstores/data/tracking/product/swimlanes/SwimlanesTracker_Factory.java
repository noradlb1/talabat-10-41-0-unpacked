package com.talabat.darkstores.data.tracking.product.swimlanes;

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
public final class SwimlanesTracker_Factory implements Factory<SwimlanesTracker> {
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public SwimlanesTracker_Factory(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2) {
        this.talabatTrackerProvider = provider;
        this.storeInfoTrackingProvider = provider2;
    }

    public static SwimlanesTracker_Factory create(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2) {
        return new SwimlanesTracker_Factory(provider, provider2);
    }

    public static SwimlanesTracker newInstance(TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2) {
        return new SwimlanesTracker(talabatTracker, storeInfoTrackingProvider2);
    }

    public SwimlanesTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.storeInfoTrackingProvider.get());
    }
}
