package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_GoogleLoginCoreLibApiFactory implements Factory<Api> {
    private final Provider<GoogleLoginCoreLibApi> googleLoginCoreLibApiProvider;

    public CoreApiModule_GoogleLoginCoreLibApiFactory(Provider<GoogleLoginCoreLibApi> provider) {
        this.googleLoginCoreLibApiProvider = provider;
    }

    public static CoreApiModule_GoogleLoginCoreLibApiFactory create(Provider<GoogleLoginCoreLibApi> provider) {
        return new CoreApiModule_GoogleLoginCoreLibApiFactory(provider);
    }

    public static Api googleLoginCoreLibApi(GoogleLoginCoreLibApi googleLoginCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.googleLoginCoreLibApi(googleLoginCoreLibApi));
    }

    public Api get() {
        return googleLoginCoreLibApi(this.googleLoginCoreLibApiProvider.get());
    }
}
