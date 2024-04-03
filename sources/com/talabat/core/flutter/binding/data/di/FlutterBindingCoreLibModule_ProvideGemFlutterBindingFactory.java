package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.gem.GemFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
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
public final class FlutterBindingCoreLibModule_ProvideGemFlutterBindingFactory implements Factory<GemFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideGemFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideGemFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideGemFlutterBindingFactory(provider);
    }

    public static GemFlutterEngineBinding provideGemFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (GemFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideGemFlutterBinding(map));
    }

    public GemFlutterEngineBinding get() {
        return provideGemFlutterBinding(this.channelsProvider.get());
    }
}
