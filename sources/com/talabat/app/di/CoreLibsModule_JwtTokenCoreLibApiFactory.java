package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.natives.di.JwtTokenCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_JwtTokenCoreLibApiFactory implements Factory<JwtTokenCoreLibApi> {
    private final Provider<AaaCoreLibApi> aaaCoreLibApiProvider;
    private final Provider<AuthenticationCoreLibApi> authenticationCoreLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<ExperimentCoreLibApi> experimentCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<RemoteConfigCoreLibApi> remoteConfigCoreLibApiProvider;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;
    private final Provider<TokenCoreLibDataApi> tokenCoreLibDataApiProvider;

    public CoreLibsModule_JwtTokenCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<AuthenticationCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<ExperimentCoreLibApi> provider4, Provider<FeatureFlagCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6, Provider<RemoteConfigCoreLibApi> provider7, Provider<SecretCoreLibApi> provider8, Provider<TokenCoreLibDataApi> provider9) {
        this.module = coreLibsModule;
        this.aaaCoreLibApiProvider = provider;
        this.authenticationCoreLibApiProvider = provider2;
        this.dispatcherCoreLibApiProvider = provider3;
        this.experimentCoreLibApiProvider = provider4;
        this.featureFlagCoreLibApiProvider = provider5;
        this.observabilityCoreLibApiProvider = provider6;
        this.remoteConfigCoreLibApiProvider = provider7;
        this.secretCoreLibApiProvider = provider8;
        this.tokenCoreLibDataApiProvider = provider9;
    }

    public static CoreLibsModule_JwtTokenCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<AaaCoreLibApi> provider, Provider<AuthenticationCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<ExperimentCoreLibApi> provider4, Provider<FeatureFlagCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6, Provider<RemoteConfigCoreLibApi> provider7, Provider<SecretCoreLibApi> provider8, Provider<TokenCoreLibDataApi> provider9) {
        return new CoreLibsModule_JwtTokenCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static JwtTokenCoreLibApi jwtTokenCoreLibApi(CoreLibsModule coreLibsModule, AaaCoreLibApi aaaCoreLibApi, AuthenticationCoreLibApi authenticationCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi) {
        return (JwtTokenCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.jwtTokenCoreLibApi(aaaCoreLibApi, authenticationCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, remoteConfigCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi));
    }

    public JwtTokenCoreLibApi get() {
        return jwtTokenCoreLibApi(this.module, this.aaaCoreLibApiProvider.get(), this.authenticationCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get(), this.experimentCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get(), this.remoteConfigCoreLibApiProvider.get(), this.secretCoreLibApiProvider.get(), this.tokenCoreLibDataApiProvider.get());
    }
}
