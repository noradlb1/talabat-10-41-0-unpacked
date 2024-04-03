package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_DispatcherApiFactory implements Factory<Api> {
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;

    public CoreApiModule_DispatcherApiFactory(Provider<DispatcherCoreLibApi> provider) {
        this.dispatcherCoreLibApiProvider = provider;
    }

    public static CoreApiModule_DispatcherApiFactory create(Provider<DispatcherCoreLibApi> provider) {
        return new CoreApiModule_DispatcherApiFactory(provider);
    }

    public static Api dispatcherApi(DispatcherCoreLibApi dispatcherCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.dispatcherApi(dispatcherCoreLibApi));
    }

    public Api get() {
        return dispatcherApi(this.dispatcherCoreLibApiProvider.get());
    }
}
