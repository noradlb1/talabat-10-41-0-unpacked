package com.talabat.core.flutter.binding.data.config;

import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ConfigFlutterEngineBinding_Factory implements Factory<ConfigFlutterEngineBinding> {
    private final Provider<AuthenticationChannelFlutterDomain> authenticationChannelFlutterDomainProvider;
    private final Provider<DeeplinkNavigationNativeDomain> deepLinkChannelProvider;
    private final Provider<ExperimentChannelFlutterDomain> experimentChannelFlutterDomainProvider;
    private final Provider<FeatureFlagChannelFlutterDomain> featureFlagChannelFlutterDomainProvider;
    private final Provider<GlobalChannelFlutterDomain> globalChannelProvider;
    private final Provider<ObservabilityChannelFlutterDomain> observabilityChannelFlutterDomainProvider;

    public ConfigFlutterEngineBinding_Factory(Provider<DeeplinkNavigationNativeDomain> provider, Provider<GlobalChannelFlutterDomain> provider2, Provider<FeatureFlagChannelFlutterDomain> provider3, Provider<ExperimentChannelFlutterDomain> provider4, Provider<ObservabilityChannelFlutterDomain> provider5, Provider<AuthenticationChannelFlutterDomain> provider6) {
        this.deepLinkChannelProvider = provider;
        this.globalChannelProvider = provider2;
        this.featureFlagChannelFlutterDomainProvider = provider3;
        this.experimentChannelFlutterDomainProvider = provider4;
        this.observabilityChannelFlutterDomainProvider = provider5;
        this.authenticationChannelFlutterDomainProvider = provider6;
    }

    public static ConfigFlutterEngineBinding_Factory create(Provider<DeeplinkNavigationNativeDomain> provider, Provider<GlobalChannelFlutterDomain> provider2, Provider<FeatureFlagChannelFlutterDomain> provider3, Provider<ExperimentChannelFlutterDomain> provider4, Provider<ObservabilityChannelFlutterDomain> provider5, Provider<AuthenticationChannelFlutterDomain> provider6) {
        return new ConfigFlutterEngineBinding_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ConfigFlutterEngineBinding newInstance(DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain, GlobalChannelFlutterDomain globalChannelFlutterDomain, FeatureFlagChannelFlutterDomain featureFlagChannelFlutterDomain, ExperimentChannelFlutterDomain experimentChannelFlutterDomain, ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, AuthenticationChannelFlutterDomain authenticationChannelFlutterDomain) {
        return new ConfigFlutterEngineBinding(deeplinkNavigationNativeDomain, globalChannelFlutterDomain, featureFlagChannelFlutterDomain, experimentChannelFlutterDomain, observabilityChannelFlutterDomain, authenticationChannelFlutterDomain);
    }

    public ConfigFlutterEngineBinding get() {
        return newInstance(this.deepLinkChannelProvider.get(), this.globalChannelProvider.get(), this.featureFlagChannelFlutterDomainProvider.get(), this.experimentChannelFlutterDomainProvider.get(), this.observabilityChannelFlutterDomainProvider.get(), this.authenticationChannelFlutterDomainProvider.get());
    }
}
