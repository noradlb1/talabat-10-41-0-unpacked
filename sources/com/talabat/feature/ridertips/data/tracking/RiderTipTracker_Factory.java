package com.talabat.feature.ridertips.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipTracker_Factory implements Factory<RiderTipTracker> {
    private final Provider<Integer> shopIdProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public RiderTipTracker_Factory(Provider<TalabatTracker> provider, Provider<Integer> provider2) {
        this.talabatTrackerProvider = provider;
        this.shopIdProvider = provider2;
    }

    public static RiderTipTracker_Factory create(Provider<TalabatTracker> provider, Provider<Integer> provider2) {
        return new RiderTipTracker_Factory(provider, provider2);
    }

    public static RiderTipTracker newInstance(TalabatTracker talabatTracker, int i11) {
        return new RiderTipTracker(talabatTracker, i11);
    }

    public RiderTipTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.shopIdProvider.get().intValue());
    }
}
