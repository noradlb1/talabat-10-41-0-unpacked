package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.config.ConfigFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideConfigFlutterEngineBindingFactory implements Factory<ConfigFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;
    private final Provider<DeeplinkNavigationNativeDomain> deeplinkNavigationNativeDomainProvider;

    public FlutterBindingCoreLibModule_ProvideConfigFlutterEngineBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider, Provider<DeeplinkNavigationNativeDomain> provider2) {
        this.channelsProvider = provider;
        this.deeplinkNavigationNativeDomainProvider = provider2;
    }

    public static FlutterBindingCoreLibModule_ProvideConfigFlutterEngineBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider, Provider<DeeplinkNavigationNativeDomain> provider2) {
        return new FlutterBindingCoreLibModule_ProvideConfigFlutterEngineBindingFactory(provider, provider2);
    }

    public static ConfigFlutterEngineBinding provideConfigFlutterEngineBinding(Map<Class<?>, Provider<PlatformChannel>> map, DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain) {
        return (ConfigFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideConfigFlutterEngineBinding(map, deeplinkNavigationNativeDomain));
    }

    public ConfigFlutterEngineBinding get() {
        return provideConfigFlutterEngineBinding(this.channelsProvider.get(), this.deeplinkNavigationNativeDomainProvider.get());
    }
}
