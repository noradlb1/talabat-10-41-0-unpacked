package com.talabat.feature.fees.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class FeesTracker_Factory implements Factory<FeesTracker> {
    private final Provider<Integer> shopIdProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public FeesTracker_Factory(Provider<TalabatTracker> provider, Provider<Integer> provider2) {
        this.talabatTrackerProvider = provider;
        this.shopIdProvider = provider2;
    }

    public static FeesTracker_Factory create(Provider<TalabatTracker> provider, Provider<Integer> provider2) {
        return new FeesTracker_Factory(provider, provider2);
    }

    public static FeesTracker newInstance(TalabatTracker talabatTracker, int i11) {
        return new FeesTracker(talabatTracker, i11);
    }

    public FeesTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.shopIdProvider.get().intValue());
    }
}
