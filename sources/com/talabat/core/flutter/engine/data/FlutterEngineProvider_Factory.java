package com.talabat.core.flutter.engine.data;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.flutter.embedding.engine.FlutterEngineGroup;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterEngineProvider_Factory implements Factory<FlutterEngineProvider> {
    private final Provider<Context> contextProvider;
    private final Provider<FlutterEngineGroup> enginesProvider;

    public FlutterEngineProvider_Factory(Provider<Context> provider, Provider<FlutterEngineGroup> provider2) {
        this.contextProvider = provider;
        this.enginesProvider = provider2;
    }

    public static FlutterEngineProvider_Factory create(Provider<Context> provider, Provider<FlutterEngineGroup> provider2) {
        return new FlutterEngineProvider_Factory(provider, provider2);
    }

    public static FlutterEngineProvider newInstance(Context context, FlutterEngineGroup flutterEngineGroup) {
        return new FlutterEngineProvider(context, flutterEngineGroup);
    }

    public FlutterEngineProvider get() {
        return newInstance(this.contextProvider.get(), this.enginesProvider.get());
    }
}
