package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_DeeplinkNavigationChannelCoreImplLibApiFactory implements Factory<Api> {
    private final Provider<DeeplinkNavigationChannelCoreImplLibApi> deeplinkNavigationChannelCoreImplLibApiProvider;

    public CoreApiModule_DeeplinkNavigationChannelCoreImplLibApiFactory(Provider<DeeplinkNavigationChannelCoreImplLibApi> provider) {
        this.deeplinkNavigationChannelCoreImplLibApiProvider = provider;
    }

    public static CoreApiModule_DeeplinkNavigationChannelCoreImplLibApiFactory create(Provider<DeeplinkNavigationChannelCoreImplLibApi> provider) {
        return new CoreApiModule_DeeplinkNavigationChannelCoreImplLibApiFactory(provider);
    }

    public static Api deeplinkNavigationChannelCoreImplLibApi(DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.deeplinkNavigationChannelCoreImplLibApi(deeplinkNavigationChannelCoreImplLibApi));
    }

    public Api get() {
        return deeplinkNavigationChannelCoreImplLibApi(this.deeplinkNavigationChannelCoreImplLibApiProvider.get());
    }
}
