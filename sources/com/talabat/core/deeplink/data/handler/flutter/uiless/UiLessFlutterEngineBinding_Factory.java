package com.talabat.core.deeplink.data.handler.flutter.uiless;

import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.flutter.embedding.engine.FlutterEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class UiLessFlutterEngineBinding_Factory implements Factory<UiLessFlutterEngineBinding> {
    private final Provider<DeepLinkFlutterNavigationChannel> deepLinkChannelProvider;
    private final Provider<FlutterEngine> flutterEngineProvider;
    private final Provider<GlobalChannelFlutterDomain> globalChannelProvider;
    private final Provider<ObservabilityChannelFlutterDomain> observabilityChannelProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<SecretsChannelFlutterDomain> secretsMethodCallHandlerProvider;
    private final Provider<TrackingChannelFlutterDomain> trackingChannelFlutterDomainProvider;

    public UiLessFlutterEngineBinding_Factory(Provider<FlutterEngine> provider, Provider<DeepLinkFlutterNavigationChannel> provider2, Provider<GlobalChannelFlutterDomain> provider3, Provider<ObservabilityChannelFlutterDomain> provider4, Provider<SecretsChannelFlutterDomain> provider5, Provider<TrackingChannelFlutterDomain> provider6, Provider<IObservabilityManager> provider7) {
        this.flutterEngineProvider = provider;
        this.deepLinkChannelProvider = provider2;
        this.globalChannelProvider = provider3;
        this.observabilityChannelProvider = provider4;
        this.secretsMethodCallHandlerProvider = provider5;
        this.trackingChannelFlutterDomainProvider = provider6;
        this.observabilityManagerProvider = provider7;
    }

    public static UiLessFlutterEngineBinding_Factory create(Provider<FlutterEngine> provider, Provider<DeepLinkFlutterNavigationChannel> provider2, Provider<GlobalChannelFlutterDomain> provider3, Provider<ObservabilityChannelFlutterDomain> provider4, Provider<SecretsChannelFlutterDomain> provider5, Provider<TrackingChannelFlutterDomain> provider6, Provider<IObservabilityManager> provider7) {
        return new UiLessFlutterEngineBinding_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static UiLessFlutterEngineBinding newInstance(FlutterEngine flutterEngine, DeepLinkFlutterNavigationChannel deepLinkFlutterNavigationChannel, GlobalChannelFlutterDomain globalChannelFlutterDomain, ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain, SecretsChannelFlutterDomain secretsChannelFlutterDomain, TrackingChannelFlutterDomain trackingChannelFlutterDomain, IObservabilityManager iObservabilityManager) {
        return new UiLessFlutterEngineBinding(flutterEngine, deepLinkFlutterNavigationChannel, globalChannelFlutterDomain, observabilityChannelFlutterDomain, secretsChannelFlutterDomain, trackingChannelFlutterDomain, iObservabilityManager);
    }

    public UiLessFlutterEngineBinding get() {
        return newInstance(this.flutterEngineProvider.get(), this.deepLinkChannelProvider.get(), this.globalChannelProvider.get(), this.observabilityChannelProvider.get(), this.secretsMethodCallHandlerProvider.get(), this.trackingChannelFlutterDomainProvider.get(), this.observabilityManagerProvider.get());
    }
}
