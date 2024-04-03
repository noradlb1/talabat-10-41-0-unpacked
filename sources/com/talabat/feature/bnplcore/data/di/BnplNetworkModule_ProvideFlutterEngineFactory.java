package com.talabat.feature.bnplcore.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.flutter.embedding.engine.FlutterEngine;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class BnplNetworkModule_ProvideFlutterEngineFactory implements Factory<FlutterEngine> {
    private final Provider<Context> contextProvider;

    public BnplNetworkModule_ProvideFlutterEngineFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static BnplNetworkModule_ProvideFlutterEngineFactory create(Provider<Context> provider) {
        return new BnplNetworkModule_ProvideFlutterEngineFactory(provider);
    }

    public static FlutterEngine provideFlutterEngine(Context context) {
        return (FlutterEngine) Preconditions.checkNotNullFromProvides(BnplNetworkModule.provideFlutterEngine(context));
    }

    public FlutterEngine get() {
        return provideFlutterEngine(this.contextProvider.get());
    }
}
