package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_HmsLocationCoreLibApiFactory implements Factory<Api> {
    private final Provider<HmsLocationCoreLibApi> hmsLocationCoreLibApiProvider;

    public CoreApiModule_HmsLocationCoreLibApiFactory(Provider<HmsLocationCoreLibApi> provider) {
        this.hmsLocationCoreLibApiProvider = provider;
    }

    public static CoreApiModule_HmsLocationCoreLibApiFactory create(Provider<HmsLocationCoreLibApi> provider) {
        return new CoreApiModule_HmsLocationCoreLibApiFactory(provider);
    }

    public static Api hmsLocationCoreLibApi(HmsLocationCoreLibApi hmsLocationCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.hmsLocationCoreLibApi(hmsLocationCoreLibApi));
    }

    public Api get() {
        return hmsLocationCoreLibApi(this.hmsLocationCoreLibApiProvider.get());
    }
}
