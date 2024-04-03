package com.talabat.app.di;

import com.talabat.authentication.token.domain.TokenCoreLibApi;
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
public final class CoreApiModule_TokenCoreLibApiFactory implements Factory<Api> {
    private final Provider<TokenCoreLibApi> tokenCoreLibApiProvider;

    public CoreApiModule_TokenCoreLibApiFactory(Provider<TokenCoreLibApi> provider) {
        this.tokenCoreLibApiProvider = provider;
    }

    public static CoreApiModule_TokenCoreLibApiFactory create(Provider<TokenCoreLibApi> provider) {
        return new CoreApiModule_TokenCoreLibApiFactory(provider);
    }

    public static Api tokenCoreLibApi(TokenCoreLibApi tokenCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.tokenCoreLibApi(tokenCoreLibApi));
    }

    public Api get() {
        return tokenCoreLibApi(this.tokenCoreLibApiProvider.get());
    }
}
