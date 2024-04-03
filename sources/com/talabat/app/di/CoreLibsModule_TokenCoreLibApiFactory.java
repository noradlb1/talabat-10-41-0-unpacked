package com.talabat.app.di;

import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_TokenCoreLibApiFactory implements Factory<TokenCoreLibApi> {
    private final CoreLibsModule module;
    private final Provider<TokenCoreLibDataApi> tokenCoreLibDataApiProvider;

    public CoreLibsModule_TokenCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<TokenCoreLibDataApi> provider) {
        this.module = coreLibsModule;
        this.tokenCoreLibDataApiProvider = provider;
    }

    public static CoreLibsModule_TokenCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<TokenCoreLibDataApi> provider) {
        return new CoreLibsModule_TokenCoreLibApiFactory(coreLibsModule, provider);
    }

    public static TokenCoreLibApi tokenCoreLibApi(CoreLibsModule coreLibsModule, TokenCoreLibDataApi tokenCoreLibDataApi) {
        return (TokenCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.tokenCoreLibApi(tokenCoreLibDataApi));
    }

    public TokenCoreLibApi get() {
        return tokenCoreLibApi(this.module, this.tokenCoreLibDataApiProvider.get());
    }
}
