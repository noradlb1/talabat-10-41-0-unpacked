package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.domain.address.IAddressInfoFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideAddressInfoFlutterBindingFactory implements Factory<IAddressInfoFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideAddressInfoFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideAddressInfoFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideAddressInfoFlutterBindingFactory(provider);
    }

    public static IAddressInfoFlutterEngineBinding provideAddressInfoFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (IAddressInfoFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideAddressInfoFlutterBinding(map));
    }

    public IAddressInfoFlutterEngineBinding get() {
        return provideAddressInfoFlutterBinding(this.channelsProvider.get());
    }
}
