package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TrackCartLoadedEventUseCaseImpl_Factory implements Factory<TrackCartLoadedEventUseCaseImpl> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public TrackCartLoadedEventUseCaseImpl_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static TrackCartLoadedEventUseCaseImpl_Factory create(Provider<TalabatTracker> provider) {
        return new TrackCartLoadedEventUseCaseImpl_Factory(provider);
    }

    public static TrackCartLoadedEventUseCaseImpl newInstance(TalabatTracker talabatTracker) {
        return new TrackCartLoadedEventUseCaseImpl(talabatTracker);
    }

    public TrackCartLoadedEventUseCaseImpl get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
