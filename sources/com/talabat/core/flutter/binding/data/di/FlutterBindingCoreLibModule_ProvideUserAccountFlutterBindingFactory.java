package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.domain.useraccount.IUserAccountFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideUserAccountFlutterBindingFactory implements Factory<IUserAccountFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideUserAccountFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideUserAccountFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideUserAccountFlutterBindingFactory(provider);
    }

    public static IUserAccountFlutterEngineBinding provideUserAccountFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (IUserAccountFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideUserAccountFlutterBinding(map));
    }

    public IUserAccountFlutterEngineBinding get() {
        return provideUserAccountFlutterBinding(this.channelsProvider.get());
    }
}
