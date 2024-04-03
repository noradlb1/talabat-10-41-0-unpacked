package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_GmsMapsCoreLibApiFactory implements Factory<Api> {
    private final Provider<GmsMapsCoreLibApi> gmsMapsCoreLibApiProvider;

    public CoreApiModule_GmsMapsCoreLibApiFactory(Provider<GmsMapsCoreLibApi> provider) {
        this.gmsMapsCoreLibApiProvider = provider;
    }

    public static CoreApiModule_GmsMapsCoreLibApiFactory create(Provider<GmsMapsCoreLibApi> provider) {
        return new CoreApiModule_GmsMapsCoreLibApiFactory(provider);
    }

    public static Api gmsMapsCoreLibApi(GmsMapsCoreLibApi gmsMapsCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.gmsMapsCoreLibApi(gmsMapsCoreLibApi));
    }

    public Api get() {
        return gmsMapsCoreLibApi(this.gmsMapsCoreLibApiProvider.get());
    }
}
