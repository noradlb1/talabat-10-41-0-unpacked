package com.talabat.core.observabilityNew.data.di;

import com.deliveryhero.performance.firebase.FirebasePerformanceTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTrackerModule_PerformanceProviderFactory implements Factory<FirebasePerformanceTracker> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PerformanceTrackerModule_PerformanceProviderFactory INSTANCE = new PerformanceTrackerModule_PerformanceProviderFactory();

        private InstanceHolder() {
        }
    }

    public static PerformanceTrackerModule_PerformanceProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FirebasePerformanceTracker performanceProvider() {
        return (FirebasePerformanceTracker) Preconditions.checkNotNullFromProvides(PerformanceTrackerModule.INSTANCE.performanceProvider());
    }

    public FirebasePerformanceTracker get() {
        return performanceProvider();
    }
}
