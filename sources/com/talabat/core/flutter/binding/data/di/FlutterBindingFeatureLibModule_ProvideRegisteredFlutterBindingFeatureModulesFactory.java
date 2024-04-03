package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.qcommerce.QCommerceFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.tpro.TproFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingFeatureLibModule_ProvideRegisteredFlutterBindingFeatureModulesFactory implements Factory<Set<EngineBinding>> {
    private final Provider<QCommerceFlutterEngineBinding> qCommerceFlutterEngineBindingProvider;
    private final Provider<TproFlutterEngineBinding> tProFlutterEngineBindingProvider;

    public FlutterBindingFeatureLibModule_ProvideRegisteredFlutterBindingFeatureModulesFactory(Provider<TproFlutterEngineBinding> provider, Provider<QCommerceFlutterEngineBinding> provider2) {
        this.tProFlutterEngineBindingProvider = provider;
        this.qCommerceFlutterEngineBindingProvider = provider2;
    }

    public static FlutterBindingFeatureLibModule_ProvideRegisteredFlutterBindingFeatureModulesFactory create(Provider<TproFlutterEngineBinding> provider, Provider<QCommerceFlutterEngineBinding> provider2) {
        return new FlutterBindingFeatureLibModule_ProvideRegisteredFlutterBindingFeatureModulesFactory(provider, provider2);
    }

    public static Set<EngineBinding> provideRegisteredFlutterBindingFeatureModules(TproFlutterEngineBinding tproFlutterEngineBinding, QCommerceFlutterEngineBinding qCommerceFlutterEngineBinding) {
        return (Set) Preconditions.checkNotNullFromProvides(FlutterBindingFeatureLibModule.INSTANCE.provideRegisteredFlutterBindingFeatureModules(tproFlutterEngineBinding, qCommerceFlutterEngineBinding));
    }

    public Set<EngineBinding> get() {
        return provideRegisteredFlutterBindingFeatureModules(this.tProFlutterEngineBindingProvider.get(), this.qCommerceFlutterEngineBindingProvider.get());
    }
}
