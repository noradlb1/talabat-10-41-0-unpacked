package com.talabat.observabilityNew.performance;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FirebasePerformanceProviderInitializer_Factory implements Factory<FirebasePerformanceProviderInitializer> {
    private final Provider<Context> contextProvider;

    public FirebasePerformanceProviderInitializer_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static FirebasePerformanceProviderInitializer_Factory create(Provider<Context> provider) {
        return new FirebasePerformanceProviderInitializer_Factory(provider);
    }

    public static FirebasePerformanceProviderInitializer newInstance(Context context) {
        return new FirebasePerformanceProviderInitializer(context);
    }

    public FirebasePerformanceProviderInitializer get() {
        return newInstance(this.contextProvider.get());
    }
}
