package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FwfCoreLibApiFactory implements Factory<Api> {
    private final Provider<FWFCoreLibApi> fwfCoreLibApiProvider;

    public CoreApiModule_FwfCoreLibApiFactory(Provider<FWFCoreLibApi> provider) {
        this.fwfCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FwfCoreLibApiFactory create(Provider<FWFCoreLibApi> provider) {
        return new CoreApiModule_FwfCoreLibApiFactory(provider);
    }

    public static Api fwfCoreLibApi(FWFCoreLibApi fWFCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.fwfCoreLibApi(fWFCoreLibApi));
    }

    public Api get() {
        return fwfCoreLibApi(this.fwfCoreLibApiProvider.get());
    }
}
