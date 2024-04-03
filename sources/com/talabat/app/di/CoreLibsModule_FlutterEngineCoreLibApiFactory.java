package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FlutterEngineCoreLibApiFactory implements Factory<FlutterEngineCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_FlutterEngineCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_FlutterEngineCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_FlutterEngineCoreLibApiFactory(coreLibsModule, provider);
    }

    public static FlutterEngineCoreLibApi flutterEngineCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (FlutterEngineCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.flutterEngineCoreLibApi(contextCoreLibApi));
    }

    public FlutterEngineCoreLibApi get() {
        return flutterEngineCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
