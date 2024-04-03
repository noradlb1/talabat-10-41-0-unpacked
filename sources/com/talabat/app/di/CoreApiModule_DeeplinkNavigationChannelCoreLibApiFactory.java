package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_DeeplinkNavigationChannelCoreLibApiFactory implements Factory<Api> {
    private final Provider<DeeplinkNavigationChannelCoreLibApi> deeplinkNavigationChannelCoreLibApiProvider;

    public CoreApiModule_DeeplinkNavigationChannelCoreLibApiFactory(Provider<DeeplinkNavigationChannelCoreLibApi> provider) {
        this.deeplinkNavigationChannelCoreLibApiProvider = provider;
    }

    public static CoreApiModule_DeeplinkNavigationChannelCoreLibApiFactory create(Provider<DeeplinkNavigationChannelCoreLibApi> provider) {
        return new CoreApiModule_DeeplinkNavigationChannelCoreLibApiFactory(provider);
    }

    public static Api deeplinkNavigationChannelCoreLibApi(DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.deeplinkNavigationChannelCoreLibApi(deeplinkNavigationChannelCoreLibApi));
    }

    public Api get() {
        return deeplinkNavigationChannelCoreLibApi(this.deeplinkNavigationChannelCoreLibApiProvider.get());
    }
}
