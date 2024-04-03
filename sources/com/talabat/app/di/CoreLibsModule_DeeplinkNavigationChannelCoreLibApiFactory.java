package com.talabat.app.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_DeeplinkNavigationChannelCoreLibApiFactory implements Factory<DeeplinkNavigationChannelCoreLibApi> {
    private final Provider<DeeplinkNavigationChannelCoreImplLibApi> deeplinkNavigationChannelCoreImplLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_DeeplinkNavigationChannelCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<DeeplinkNavigationChannelCoreImplLibApi> provider, Provider<DispatcherCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.deeplinkNavigationChannelCoreImplLibApiProvider = provider;
        this.dispatcherCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_DeeplinkNavigationChannelCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<DeeplinkNavigationChannelCoreImplLibApi> provider, Provider<DispatcherCoreLibApi> provider2) {
        return new CoreLibsModule_DeeplinkNavigationChannelCoreLibApiFactory(coreLibsModule, provider, provider2);
    }

    public static DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi(CoreLibsModule coreLibsModule, DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
        return (DeeplinkNavigationChannelCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.deeplinkNavigationChannelCoreLibApi(deeplinkNavigationChannelCoreImplLibApi, dispatcherCoreLibApi));
    }

    public DeeplinkNavigationChannelCoreLibApi get() {
        return deeplinkNavigationChannelCoreLibApi(this.module, this.deeplinkNavigationChannelCoreImplLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get());
    }
}
