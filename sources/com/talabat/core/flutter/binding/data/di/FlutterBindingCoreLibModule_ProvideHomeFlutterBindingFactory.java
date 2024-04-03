package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.domain.home.IHomeFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideHomeFlutterBindingFactory implements Factory<IHomeFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideHomeFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideHomeFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideHomeFlutterBindingFactory(provider);
    }

    public static IHomeFlutterEngineBinding provideHomeFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (IHomeFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideHomeFlutterBinding(map));
    }

    public IHomeFlutterEngineBinding get() {
        return provideHomeFlutterBinding(this.channelsProvider.get());
    }
}
