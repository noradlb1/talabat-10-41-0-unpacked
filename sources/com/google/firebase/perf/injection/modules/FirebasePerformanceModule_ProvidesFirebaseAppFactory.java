package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesFirebaseAppFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule);
    }

    public static FirebaseApp providesFirebaseApp(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseApp) Preconditions.checkNotNull(firebasePerformanceModule.providesFirebaseApp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public FirebaseApp get() {
        return providesFirebaseApp(this.module);
    }
}
