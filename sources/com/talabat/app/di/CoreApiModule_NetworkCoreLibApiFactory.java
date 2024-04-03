package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_NetworkCoreLibApiFactory implements Factory<Api> {
    private final Provider<NetworkCoreLibApi> networkCoreLibApiProvider;

    public CoreApiModule_NetworkCoreLibApiFactory(Provider<NetworkCoreLibApi> provider) {
        this.networkCoreLibApiProvider = provider;
    }

    public static CoreApiModule_NetworkCoreLibApiFactory create(Provider<NetworkCoreLibApi> provider) {
        return new CoreApiModule_NetworkCoreLibApiFactory(provider);
    }

    public static Api networkCoreLibApi(NetworkCoreLibApi networkCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.networkCoreLibApi(networkCoreLibApi));
    }

    public Api get() {
        return networkCoreLibApi(this.networkCoreLibApiProvider.get());
    }
}
