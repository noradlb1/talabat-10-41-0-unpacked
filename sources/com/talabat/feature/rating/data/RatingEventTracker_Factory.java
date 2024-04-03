package com.talabat.feature.rating.data;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingEventTracker_Factory implements Factory<RatingEventTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public RatingEventTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static RatingEventTracker_Factory create(Provider<TalabatTracker> provider) {
        return new RatingEventTracker_Factory(provider);
    }

    public static RatingEventTracker newInstance(TalabatTracker talabatTracker) {
        return new RatingEventTracker(talabatTracker);
    }

    public RatingEventTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
