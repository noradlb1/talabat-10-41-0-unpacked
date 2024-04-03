package com.talabat.app.di;

import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
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
public final class CoreApiModule_TokenCoreLibDataApiFactory implements Factory<Api> {
    private final Provider<TokenCoreLibDataApi> tokenCoreLibDataApiProvider;

    public CoreApiModule_TokenCoreLibDataApiFactory(Provider<TokenCoreLibDataApi> provider) {
        this.tokenCoreLibDataApiProvider = provider;
    }

    public static CoreApiModule_TokenCoreLibDataApiFactory create(Provider<TokenCoreLibDataApi> provider) {
        return new CoreApiModule_TokenCoreLibDataApiFactory(provider);
    }

    public static Api tokenCoreLibDataApi(TokenCoreLibDataApi tokenCoreLibDataApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.tokenCoreLibDataApi(tokenCoreLibDataApi));
    }

    public Api get() {
        return tokenCoreLibDataApi(this.tokenCoreLibDataApiProvider.get());
    }
}
