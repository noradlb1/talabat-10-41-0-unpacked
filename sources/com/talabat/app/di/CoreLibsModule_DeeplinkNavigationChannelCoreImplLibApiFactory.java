package com.talabat.app.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_DeeplinkNavigationChannelCoreImplLibApiFactory implements Factory<DeeplinkNavigationChannelCoreImplLibApi> {
    private final Provider<DeepLinkCoreLibApi> deepLinkCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_DeeplinkNavigationChannelCoreImplLibApiFactory(CoreLibsModule coreLibsModule, Provider<DeepLinkCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.deepLinkCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_DeeplinkNavigationChannelCoreImplLibApiFactory create(CoreLibsModule coreLibsModule, Provider<DeepLinkCoreLibApi> provider) {
        return new CoreLibsModule_DeeplinkNavigationChannelCoreImplLibApiFactory(coreLibsModule, provider);
    }

    public static DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi(CoreLibsModule coreLibsModule, DeepLinkCoreLibApi deepLinkCoreLibApi) {
        return (DeeplinkNavigationChannelCoreImplLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.deeplinkNavigationChannelCoreImplLibApi(deepLinkCoreLibApi));
    }

    public DeeplinkNavigationChannelCoreImplLibApi get() {
        return deeplinkNavigationChannelCoreImplLibApi(this.module, this.deepLinkCoreLibApiProvider.get());
    }
}
