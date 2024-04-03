package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_TrackingCoreLibApiFactory implements Factory<Api> {
    private final Provider<TrackingCoreLibApi> trackingCoreLibApiProvider;

    public CoreApiModule_TrackingCoreLibApiFactory(Provider<TrackingCoreLibApi> provider) {
        this.trackingCoreLibApiProvider = provider;
    }

    public static CoreApiModule_TrackingCoreLibApiFactory create(Provider<TrackingCoreLibApi> provider) {
        return new CoreApiModule_TrackingCoreLibApiFactory(provider);
    }

    public static Api trackingCoreLibApi(TrackingCoreLibApi trackingCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.trackingCoreLibApi(trackingCoreLibApi));
    }

    public Api get() {
        return trackingCoreLibApi(this.trackingCoreLibApiProvider.get());
    }
}
