package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_MapsCoreLibApiFactory implements Factory<Api> {
    private final Provider<MapsCoreLibApi> mapsCoreLibApiProvider;

    public CoreApiModule_MapsCoreLibApiFactory(Provider<MapsCoreLibApi> provider) {
        this.mapsCoreLibApiProvider = provider;
    }

    public static CoreApiModule_MapsCoreLibApiFactory create(Provider<MapsCoreLibApi> provider) {
        return new CoreApiModule_MapsCoreLibApiFactory(provider);
    }

    public static Api mapsCoreLibApi(MapsCoreLibApi mapsCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.mapsCoreLibApi(mapsCoreLibApi));
    }

    public Api get() {
        return mapsCoreLibApi(this.mapsCoreLibApiProvider.get());
    }
}
