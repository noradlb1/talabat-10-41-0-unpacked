package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
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
public final class CoreLibsModule_FlutterBindingCoreLibApiFactory implements Factory<FlutterBindingCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<DeeplinkNavigationChannelCoreLibApi> deeplinkNavigationChannelCoreLibApiProvider;
    private final Provider<FlutterChannelsCoreLibApi> flutterChannelsCoreLibApiProvider;
    private final Provider<FlutterEngineCoreLibApi> flutterEngineCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_FlutterBindingCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<DeeplinkNavigationChannelCoreLibApi> provider2, Provider<FlutterChannelsCoreLibApi> provider3, Provider<FlutterEngineCoreLibApi> provider4) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.deeplinkNavigationChannelCoreLibApiProvider = provider2;
        this.flutterChannelsCoreLibApiProvider = provider3;
        this.flutterEngineCoreLibApiProvider = provider4;
    }

    public static CoreLibsModule_FlutterBindingCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<DeeplinkNavigationChannelCoreLibApi> provider2, Provider<FlutterChannelsCoreLibApi> provider3, Provider<FlutterEngineCoreLibApi> provider4) {
        return new CoreLibsModule_FlutterBindingCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4);
    }

    public static FlutterBindingCoreLibApi flutterBindingCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi) {
        return (FlutterBindingCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.flutterBindingCoreLibApi(contextCoreLibApi, deeplinkNavigationChannelCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi));
    }

    public FlutterBindingCoreLibApi get() {
        return flutterBindingCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.deeplinkNavigationChannelCoreLibApiProvider.get(), this.flutterChannelsCoreLibApiProvider.get(), this.flutterEngineCoreLibApiProvider.get());
    }
}
