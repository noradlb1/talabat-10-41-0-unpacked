package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
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
public final class CoreApiModule_AaaCoreLibApiFactory implements Factory<Api> {
    private final Provider<AaaCoreLibApi> aaaCoreLibApiProvider;

    public CoreApiModule_AaaCoreLibApiFactory(Provider<AaaCoreLibApi> provider) {
        this.aaaCoreLibApiProvider = provider;
    }

    public static Api aaaCoreLibApi(AaaCoreLibApi aaaCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.aaaCoreLibApi(aaaCoreLibApi));
    }

    public static CoreApiModule_AaaCoreLibApiFactory create(Provider<AaaCoreLibApi> provider) {
        return new CoreApiModule_AaaCoreLibApiFactory(provider);
    }

    public Api get() {
        return aaaCoreLibApi(this.aaaCoreLibApiProvider.get());
    }
}
