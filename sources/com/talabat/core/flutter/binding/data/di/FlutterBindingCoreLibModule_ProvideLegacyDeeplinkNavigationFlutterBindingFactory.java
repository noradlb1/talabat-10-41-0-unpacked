package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.legacydeeplink.LegacyDeeplinkNavigationFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideLegacyDeeplinkNavigationFlutterBindingFactory implements Factory<LegacyDeeplinkNavigationFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideLegacyDeeplinkNavigationFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideLegacyDeeplinkNavigationFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideLegacyDeeplinkNavigationFlutterBindingFactory(provider);
    }

    public static LegacyDeeplinkNavigationFlutterEngineBinding provideLegacyDeeplinkNavigationFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (LegacyDeeplinkNavigationFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideLegacyDeeplinkNavigationFlutterBinding(map));
    }

    public LegacyDeeplinkNavigationFlutterEngineBinding get() {
        return provideLegacyDeeplinkNavigationFlutterBinding(this.channelsProvider.get());
    }
}
