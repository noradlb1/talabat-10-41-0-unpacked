package com.talabat.core.deeplink.data.registry;

import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DeepLinkHandlerRegistry_Factory implements Factory<DeepLinkHandlerRegistry> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<UiLessFlutterEngineBinding> uiLessFlutterEngineBindingProvider;

    public DeepLinkHandlerRegistry_Factory(Provider<Navigator> provider, Provider<UiLessFlutterEngineBinding> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<ITalabatExperiment> provider4, Provider<CustomerRepository> provider5, Provider<IObservabilityManager> provider6) {
        this.navigatorProvider = provider;
        this.uiLessFlutterEngineBindingProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.talabatExperimentProvider = provider4;
        this.customerRepositoryProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static DeepLinkHandlerRegistry_Factory create(Provider<Navigator> provider, Provider<UiLessFlutterEngineBinding> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<ITalabatExperiment> provider4, Provider<CustomerRepository> provider5, Provider<IObservabilityManager> provider6) {
        return new DeepLinkHandlerRegistry_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DeepLinkHandlerRegistry newInstance(Navigator navigator, UiLessFlutterEngineBinding uiLessFlutterEngineBinding, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment, CustomerRepository customerRepository, IObservabilityManager iObservabilityManager) {
        return new DeepLinkHandlerRegistry(navigator, uiLessFlutterEngineBinding, iTalabatFeatureFlag, iTalabatExperiment, customerRepository, iObservabilityManager);
    }

    public DeepLinkHandlerRegistry get() {
        return newInstance(this.navigatorProvider.get(), this.uiLessFlutterEngineBindingProvider.get(), this.talabatFeatureFlagProvider.get(), this.talabatExperimentProvider.get(), this.customerRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
