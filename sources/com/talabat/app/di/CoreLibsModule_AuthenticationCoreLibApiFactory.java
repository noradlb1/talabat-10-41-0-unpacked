package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_AuthenticationCoreLibApiFactory implements Factory<AuthenticationCoreLibApi> {
    private final Provider<AaaCoreLibApi> aaaCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final Provider<GdmOwinTokenApi> gdmOwinTokenApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;
    private final Provider<TokenCoreLibDataApi> tokenCoreLibDataApiProvider;

    public CoreLibsModule_AuthenticationCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<FeatureFlagCoreLibApi> provider4, Provider<GdmOwinTokenApi> provider5, Provider<ParserCoreLibApi> provider6, Provider<SecretCoreLibApi> provider7, Provider<TokenCoreLibDataApi> provider8, Provider<ObservabilityCoreLibApi> provider9) {
        this.module = coreLibsModule;
        this.aaaCoreLibApiProvider = provider;
        this.contextCoreLibApiProvider = provider2;
        this.dispatcherCoreLibApiProvider = provider3;
        this.featureFlagCoreLibApiProvider = provider4;
        this.gdmOwinTokenApiProvider = provider5;
        this.parserCoreLibApiProvider = provider6;
        this.secretCoreLibApiProvider = provider7;
        this.tokenCoreLibDataApiProvider = provider8;
        this.observabilityCoreLibApiProvider = provider9;
    }

    public static AuthenticationCoreLibApi authenticationCoreLibApi(CoreLibsModule coreLibsModule, AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GdmOwinTokenApi gdmOwinTokenApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (AuthenticationCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.authenticationCoreLibApi(aaaCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, gdmOwinTokenApi, parserCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi, observabilityCoreLibApi));
    }

    public static CoreLibsModule_AuthenticationCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<FeatureFlagCoreLibApi> provider4, Provider<GdmOwinTokenApi> provider5, Provider<ParserCoreLibApi> provider6, Provider<SecretCoreLibApi> provider7, Provider<TokenCoreLibDataApi> provider8, Provider<ObservabilityCoreLibApi> provider9) {
        return new CoreLibsModule_AuthenticationCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public AuthenticationCoreLibApi get() {
        return authenticationCoreLibApi(this.module, this.aaaCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.gdmOwinTokenApiProvider.get(), this.parserCoreLibApiProvider.get(), this.secretCoreLibApiProvider.get(), this.tokenCoreLibDataApiProvider.get(), this.observabilityCoreLibApiProvider.get());
    }
}
