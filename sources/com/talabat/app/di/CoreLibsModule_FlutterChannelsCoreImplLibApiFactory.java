package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FlutterChannelsCoreImplLibApiFactory implements Factory<FlutterChannelsCoreImplLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<ExperimentCoreLibApi> experimentCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<MutableConfigurationLocalCoreLibApi> mutableConfigurationLocalCoreLibApiProvider;
    private final Provider<MutableConfigurationRemoteCoreLibApi> mutableConfigurationRemoteCoreLibApiProvider;
    private final Provider<NavigationCoreLibApi> navigationCoreLibApiProvider;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;
    private final Provider<PinlessCheckoutCoreLibApi> pinlessCheckoutCoreLibApiProvider;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;
    private final Provider<TokenCoreLibDataApi> tokenCoreLibDataApiProvider;
    private final Provider<TrackingCoreLibApi> trackingCoreLibApiProvider;

    public CoreLibsModule_FlutterChannelsCoreImplLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<FeatureFlagCoreLibApi> provider2, Provider<ObservabilityCoreLibApi> provider3, Provider<ExperimentCoreLibApi> provider4, Provider<SecretCoreLibApi> provider5, Provider<TokenCoreLibDataApi> provider6, Provider<PinlessCheckoutCoreLibApi> provider7, Provider<NavigationCoreLibApi> provider8, Provider<TrackingCoreLibApi> provider9, Provider<ParserCoreLibApi> provider10, Provider<MutableConfigurationLocalCoreLibApi> provider11, Provider<MutableConfigurationRemoteCoreLibApi> provider12) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.featureFlagCoreLibApiProvider = provider2;
        this.observabilityCoreLibApiProvider = provider3;
        this.experimentCoreLibApiProvider = provider4;
        this.secretCoreLibApiProvider = provider5;
        this.tokenCoreLibDataApiProvider = provider6;
        this.pinlessCheckoutCoreLibApiProvider = provider7;
        this.navigationCoreLibApiProvider = provider8;
        this.trackingCoreLibApiProvider = provider9;
        this.parserCoreLibApiProvider = provider10;
        this.mutableConfigurationLocalCoreLibApiProvider = provider11;
        this.mutableConfigurationRemoteCoreLibApiProvider = provider12;
    }

    public static CoreLibsModule_FlutterChannelsCoreImplLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<FeatureFlagCoreLibApi> provider2, Provider<ObservabilityCoreLibApi> provider3, Provider<ExperimentCoreLibApi> provider4, Provider<SecretCoreLibApi> provider5, Provider<TokenCoreLibDataApi> provider6, Provider<PinlessCheckoutCoreLibApi> provider7, Provider<NavigationCoreLibApi> provider8, Provider<TrackingCoreLibApi> provider9, Provider<ParserCoreLibApi> provider10, Provider<MutableConfigurationLocalCoreLibApi> provider11, Provider<MutableConfigurationRemoteCoreLibApi> provider12) {
        return new CoreLibsModule_FlutterChannelsCoreImplLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ParserCoreLibApi parserCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        return (FlutterChannelsCoreImplLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.flutterChannelsCoreImplLibApi(contextCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, experimentCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi, pinlessCheckoutCoreLibApi, navigationCoreLibApi, trackingCoreLibApi, parserCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi));
    }

    public FlutterChannelsCoreImplLibApi get() {
        return flutterChannelsCoreImplLibApi(this.module, this.contextCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get(), this.experimentCoreLibApiProvider.get(), this.secretCoreLibApiProvider.get(), this.tokenCoreLibDataApiProvider.get(), this.pinlessCheckoutCoreLibApiProvider.get(), this.navigationCoreLibApiProvider.get(), this.trackingCoreLibApiProvider.get(), this.parserCoreLibApiProvider.get(), this.mutableConfigurationLocalCoreLibApiProvider.get(), this.mutableConfigurationRemoteCoreLibApiProvider.get());
    }
}
