package com.talabat.core.flutter.engine.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.flutter.embedding.engine.FlutterEngineGroup;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory implements Factory<FlutterEngineGroup> {
    private final Provider<Context> contextProvider;

    public FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory create(Provider<Context> provider) {
        return new FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory(provider);
    }

    public static FlutterEngineGroup flutterEngineGroup(Context context) {
        return (FlutterEngineGroup) Preconditions.checkNotNullFromProvides(FlutterEngineCoreLibModule.Companion.flutterEngineGroup(context));
    }

    public FlutterEngineGroup get() {
        return flutterEngineGroup(this.contextProvider.get());
    }
}
