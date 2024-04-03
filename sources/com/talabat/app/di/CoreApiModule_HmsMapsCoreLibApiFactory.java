package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_HmsMapsCoreLibApiFactory implements Factory<Api> {
    private final Provider<HmsMapsCoreLibApi> hmsMapsCoreLibApiProvider;

    public CoreApiModule_HmsMapsCoreLibApiFactory(Provider<HmsMapsCoreLibApi> provider) {
        this.hmsMapsCoreLibApiProvider = provider;
    }

    public static CoreApiModule_HmsMapsCoreLibApiFactory create(Provider<HmsMapsCoreLibApi> provider) {
        return new CoreApiModule_HmsMapsCoreLibApiFactory(provider);
    }

    public static Api hmsMapsCoreLibApi(HmsMapsCoreLibApi hmsMapsCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.hmsMapsCoreLibApi(hmsMapsCoreLibApi));
    }

    public Api get() {
        return hmsMapsCoreLibApi(this.hmsMapsCoreLibApiProvider.get());
    }
}
