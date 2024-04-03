package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_GmsLocationCoreLibApiFactory implements Factory<Api> {
    private final Provider<GmsLocationCoreLibApi> gmsLocationCoreLibApiProvider;

    public CoreApiModule_GmsLocationCoreLibApiFactory(Provider<GmsLocationCoreLibApi> provider) {
        this.gmsLocationCoreLibApiProvider = provider;
    }

    public static CoreApiModule_GmsLocationCoreLibApiFactory create(Provider<GmsLocationCoreLibApi> provider) {
        return new CoreApiModule_GmsLocationCoreLibApiFactory(provider);
    }

    public static Api gmsLocationCoreLibApi(GmsLocationCoreLibApi gmsLocationCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.gmsLocationCoreLibApi(gmsLocationCoreLibApi));
    }

    public Api get() {
        return gmsLocationCoreLibApi(this.gmsLocationCoreLibApiProvider.get());
    }
}
