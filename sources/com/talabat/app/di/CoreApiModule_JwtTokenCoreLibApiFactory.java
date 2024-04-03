package com.talabat.app.di;

import com.talabat.authentication.natives.di.JwtTokenCoreLibApi;
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
public final class CoreApiModule_JwtTokenCoreLibApiFactory implements Factory<Api> {
    private final Provider<JwtTokenCoreLibApi> jwtTokenCoreLibApiProvider;

    public CoreApiModule_JwtTokenCoreLibApiFactory(Provider<JwtTokenCoreLibApi> provider) {
        this.jwtTokenCoreLibApiProvider = provider;
    }

    public static CoreApiModule_JwtTokenCoreLibApiFactory create(Provider<JwtTokenCoreLibApi> provider) {
        return new CoreApiModule_JwtTokenCoreLibApiFactory(provider);
    }

    public static Api jwtTokenCoreLibApi(JwtTokenCoreLibApi jwtTokenCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.jwtTokenCoreLibApi(jwtTokenCoreLibApi));
    }

    public Api get() {
        return jwtTokenCoreLibApi(this.jwtTokenCoreLibApiProvider.get());
    }
}
