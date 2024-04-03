package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_TokenCoreLibDataApiFactory implements Factory<TokenCoreLibDataApi> {
    private final Provider<AaaCoreLibApi> aaaCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;

    public CoreLibsModule_TokenCoreLibDataApiFactory(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<ParserCoreLibApi> provider4, Provider<SecretCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6) {
        this.module = coreLibsModule;
        this.aaaCoreLibApiProvider = provider;
        this.contextCoreLibApiProvider = provider2;
        this.featureFlagCoreLibApiProvider = provider3;
        this.parserCoreLibApiProvider = provider4;
        this.secretCoreLibApiProvider = provider5;
        this.observabilityCoreLibApiProvider = provider6;
    }

    public static CoreLibsModule_TokenCoreLibDataApiFactory create(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<ParserCoreLibApi> provider4, Provider<SecretCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6) {
        return new CoreLibsModule_TokenCoreLibDataApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TokenCoreLibDataApi tokenCoreLibDataApi(CoreLibsModule coreLibsModule, AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (TokenCoreLibDataApi) Preconditions.checkNotNullFromProvides(coreLibsModule.tokenCoreLibDataApi(aaaCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, parserCoreLibApi, secretCoreLibApi, observabilityCoreLibApi));
    }

    public TokenCoreLibDataApi get() {
        return tokenCoreLibDataApi(this.module, this.aaaCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.parserCoreLibApiProvider.get(), this.secretCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get());
    }
}
