package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_ObservabilityCoreLibApiFactory implements Factory<Api> {
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;

    public CoreApiModule_ObservabilityCoreLibApiFactory(Provider<ObservabilityCoreLibApi> provider) {
        this.observabilityCoreLibApiProvider = provider;
    }

    public static CoreApiModule_ObservabilityCoreLibApiFactory create(Provider<ObservabilityCoreLibApi> provider) {
        return new CoreApiModule_ObservabilityCoreLibApiFactory(provider);
    }

    public static Api observabilityCoreLibApi(ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.observabilityCoreLibApi(observabilityCoreLibApi));
    }

    public Api get() {
        return observabilityCoreLibApi(this.observabilityCoreLibApiProvider.get());
    }
}
