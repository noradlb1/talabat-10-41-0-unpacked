package com.talabat.app.di;

import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
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
public final class CoreApiModule_AuthenticationCoreLibApiFactory implements Factory<Api> {
    private final Provider<AuthenticationCoreLibApi> authenticationCoreLibApiProvider;

    public CoreApiModule_AuthenticationCoreLibApiFactory(Provider<AuthenticationCoreLibApi> provider) {
        this.authenticationCoreLibApiProvider = provider;
    }

    public static Api authenticationCoreLibApi(AuthenticationCoreLibApi authenticationCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.authenticationCoreLibApi(authenticationCoreLibApi));
    }

    public static CoreApiModule_AuthenticationCoreLibApiFactory create(Provider<AuthenticationCoreLibApi> provider) {
        return new CoreApiModule_AuthenticationCoreLibApiFactory(provider);
    }

    public Api get() {
        return authenticationCoreLibApi(this.authenticationCoreLibApiProvider.get());
    }
}
