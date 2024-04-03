package com.talabat.app.di;

import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
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
public final class CoreApiModule_GoogleAdvertisementCoreLibApiFactory implements Factory<Api> {
    private final Provider<GoogleAdvertisementCoreLibApi> googleAdvertisementCoreLibApiProvider;

    public CoreApiModule_GoogleAdvertisementCoreLibApiFactory(Provider<GoogleAdvertisementCoreLibApi> provider) {
        this.googleAdvertisementCoreLibApiProvider = provider;
    }

    public static CoreApiModule_GoogleAdvertisementCoreLibApiFactory create(Provider<GoogleAdvertisementCoreLibApi> provider) {
        return new CoreApiModule_GoogleAdvertisementCoreLibApiFactory(provider);
    }

    public static Api googleAdvertisementCoreLibApi(GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.googleAdvertisementCoreLibApi(googleAdvertisementCoreLibApi));
    }

    public Api get() {
        return googleAdvertisementCoreLibApi(this.googleAdvertisementCoreLibApiProvider.get());
    }
}
