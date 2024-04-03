package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements Factory<Provider<TransportFactory>> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule);
    }

    public static Provider<TransportFactory> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) Preconditions.checkNotNull(firebasePerformanceModule.providesTransportFactoryProvider(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Provider<TransportFactory> get() {
        return providesTransportFactoryProvider(this.module);
    }
}
