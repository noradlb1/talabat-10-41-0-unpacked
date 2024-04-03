package com.talabat.app.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.di.Api;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_DeepLinkCoreLibApiFactory implements Factory<Api> {
    private final Provider<DeepLinkCoreLibApi> deepLinkCoreLibApiProvider;

    public CoreApiModule_DeepLinkCoreLibApiFactory(Provider<DeepLinkCoreLibApi> provider) {
        this.deepLinkCoreLibApiProvider = provider;
    }

    public static CoreApiModule_DeepLinkCoreLibApiFactory create(Provider<DeepLinkCoreLibApi> provider) {
        return new CoreApiModule_DeepLinkCoreLibApiFactory(provider);
    }

    public static Api deepLinkCoreLibApi(DeepLinkCoreLibApi deepLinkCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.deepLinkCoreLibApi(deepLinkCoreLibApi));
    }

    public Api get() {
        return deepLinkCoreLibApi(this.deepLinkCoreLibApiProvider.get());
    }
}
