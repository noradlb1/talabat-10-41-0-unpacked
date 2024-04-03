package com.talabat.app.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_DeepLinkCoreLibApiFactory implements Factory<DeepLinkCoreLibApi> {
    private final Provider<CustomerCoreLibApi> customerCoreLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<ExperimentCoreLibApi> experimentCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final Provider<FlutterChannelsCoreLibApi> flutterChannelsCoreLibApiProvider;
    private final Provider<FlutterEngineCoreLibApi> flutterEngineCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<NavigationCoreLibApi> navigationCoreLibApiProvider;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;

    public CoreLibsModule_DeepLinkCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<FeatureFlagCoreLibApi> provider, Provider<ExperimentCoreLibApi> provider2, Provider<NavigationCoreLibApi> provider3, Provider<ObservabilityCoreLibApi> provider4, Provider<FlutterChannelsCoreLibApi> provider5, Provider<FlutterEngineCoreLibApi> provider6, Provider<DispatcherCoreLibApi> provider7, Provider<CustomerCoreLibApi> provider8) {
        this.module = coreLibsModule;
        this.featureFlagCoreLibApiProvider = provider;
        this.experimentCoreLibApiProvider = provider2;
        this.navigationCoreLibApiProvider = provider3;
        this.observabilityCoreLibApiProvider = provider4;
        this.flutterChannelsCoreLibApiProvider = provider5;
        this.flutterEngineCoreLibApiProvider = provider6;
        this.dispatcherCoreLibApiProvider = provider7;
        this.customerCoreLibApiProvider = provider8;
    }

    public static CoreLibsModule_DeepLinkCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<FeatureFlagCoreLibApi> provider, Provider<ExperimentCoreLibApi> provider2, Provider<NavigationCoreLibApi> provider3, Provider<ObservabilityCoreLibApi> provider4, Provider<FlutterChannelsCoreLibApi> provider5, Provider<FlutterEngineCoreLibApi> provider6, Provider<DispatcherCoreLibApi> provider7, Provider<CustomerCoreLibApi> provider8) {
        return new CoreLibsModule_DeepLinkCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DeepLinkCoreLibApi deepLinkCoreLibApi(CoreLibsModule coreLibsModule, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
        return (DeepLinkCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.deepLinkCoreLibApi(featureFlagCoreLibApi, experimentCoreLibApi, navigationCoreLibApi, observabilityCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi, dispatcherCoreLibApi, customerCoreLibApi));
    }

    public DeepLinkCoreLibApi get() {
        return deepLinkCoreLibApi(this.module, this.featureFlagCoreLibApiProvider.get(), this.experimentCoreLibApiProvider.get(), this.navigationCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get(), this.flutterChannelsCoreLibApiProvider.get(), this.flutterEngineCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get(), this.customerCoreLibApiProvider.get());
    }
}
