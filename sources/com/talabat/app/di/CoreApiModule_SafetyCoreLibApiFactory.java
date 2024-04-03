package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_SafetyCoreLibApiFactory implements Factory<Api> {
    private final Provider<SafetyCoreLibApi> safetyCoreLibApiProvider;

    public CoreApiModule_SafetyCoreLibApiFactory(Provider<SafetyCoreLibApi> provider) {
        this.safetyCoreLibApiProvider = provider;
    }

    public static CoreApiModule_SafetyCoreLibApiFactory create(Provider<SafetyCoreLibApi> provider) {
        return new CoreApiModule_SafetyCoreLibApiFactory(provider);
    }

    public static Api safetyCoreLibApi(SafetyCoreLibApi safetyCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.safetyCoreLibApi(safetyCoreLibApi));
    }

    public Api get() {
        return safetyCoreLibApi(this.safetyCoreLibApiProvider.get());
    }
}
