package com.talabat.core.observabilityNew.data.di;

import com.talabat.observabilityNew.performance.FirebasePerformanceProviderInitializer;
import com.talabat.observabilityNew.performance.PerformanceTrackingInitializer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTrackerModule_FirebasePerformanceInitializerFactory implements Factory<PerformanceTrackingInitializer> {
    private final Provider<FirebasePerformanceProviderInitializer> firebasePerformanceProviderInitializerProvider;

    public PerformanceTrackerModule_FirebasePerformanceInitializerFactory(Provider<FirebasePerformanceProviderInitializer> provider) {
        this.firebasePerformanceProviderInitializerProvider = provider;
    }

    public static PerformanceTrackerModule_FirebasePerformanceInitializerFactory create(Provider<FirebasePerformanceProviderInitializer> provider) {
        return new PerformanceTrackerModule_FirebasePerformanceInitializerFactory(provider);
    }

    public static PerformanceTrackingInitializer firebasePerformanceInitializer(FirebasePerformanceProviderInitializer firebasePerformanceProviderInitializer) {
        return (PerformanceTrackingInitializer) Preconditions.checkNotNullFromProvides(PerformanceTrackerModule.INSTANCE.firebasePerformanceInitializer(firebasePerformanceProviderInitializer));
    }

    public PerformanceTrackingInitializer get() {
        return firebasePerformanceInitializer(this.firebasePerformanceProviderInitializerProvider.get());
    }
}
