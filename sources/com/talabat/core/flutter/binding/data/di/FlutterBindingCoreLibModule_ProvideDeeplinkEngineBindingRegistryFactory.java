package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideDeeplinkEngineBindingRegistryFactory implements Factory<DeeplinkEngineBindingRegistry> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;
    private final Provider<IFlutterEngineProvider> flutterEngineProvider;
    private final Provider<Set<EngineBinding>> registeredFlutterBindingModulesProvider;

    public FlutterBindingCoreLibModule_ProvideDeeplinkEngineBindingRegistryFactory(Provider<IFlutterEngineProvider> provider, Provider<Set<EngineBinding>> provider2, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider3) {
        this.flutterEngineProvider = provider;
        this.registeredFlutterBindingModulesProvider = provider2;
        this.channelsProvider = provider3;
    }

    public static FlutterBindingCoreLibModule_ProvideDeeplinkEngineBindingRegistryFactory create(Provider<IFlutterEngineProvider> provider, Provider<Set<EngineBinding>> provider2, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider3) {
        return new FlutterBindingCoreLibModule_ProvideDeeplinkEngineBindingRegistryFactory(provider, provider2, provider3);
    }

    public static DeeplinkEngineBindingRegistry provideDeeplinkEngineBindingRegistry(IFlutterEngineProvider iFlutterEngineProvider, Set<EngineBinding> set, Map<Class<?>, Provider<PlatformChannel>> map) {
        return (DeeplinkEngineBindingRegistry) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideDeeplinkEngineBindingRegistry(iFlutterEngineProvider, set, map));
    }

    public DeeplinkEngineBindingRegistry get() {
        return provideDeeplinkEngineBindingRegistry(this.flutterEngineProvider.get(), this.registeredFlutterBindingModulesProvider.get(), this.channelsProvider.get());
    }
}
