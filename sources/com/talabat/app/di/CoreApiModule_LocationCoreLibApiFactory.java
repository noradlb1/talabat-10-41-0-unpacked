package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.location.domain.di.LocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_LocationCoreLibApiFactory implements Factory<Api> {
    private final Provider<LocationCoreLibApi> locationCoreLibApiProvider;

    public CoreApiModule_LocationCoreLibApiFactory(Provider<LocationCoreLibApi> provider) {
        this.locationCoreLibApiProvider = provider;
    }

    public static CoreApiModule_LocationCoreLibApiFactory create(Provider<LocationCoreLibApi> provider) {
        return new CoreApiModule_LocationCoreLibApiFactory(provider);
    }

    public static Api locationCoreLibApi(LocationCoreLibApi locationCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.locationCoreLibApi(locationCoreLibApi));
    }

    public Api get() {
        return locationCoreLibApi(this.locationCoreLibApiProvider.get());
    }
}
