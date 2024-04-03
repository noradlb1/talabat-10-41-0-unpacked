package com.talabat.darkstores.data.tracking.fees.tracker;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresFeesTracker_Factory implements Factory<DarkstoresFeesTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public DarkstoresFeesTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static DarkstoresFeesTracker_Factory create(Provider<TalabatTracker> provider) {
        return new DarkstoresFeesTracker_Factory(provider);
    }

    public static DarkstoresFeesTracker newInstance(TalabatTracker talabatTracker) {
        return new DarkstoresFeesTracker(talabatTracker);
    }

    public DarkstoresFeesTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
