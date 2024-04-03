package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.cart.CartFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideCartFlutterBindingFactory implements Factory<CartFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideCartFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideCartFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideCartFlutterBindingFactory(provider);
    }

    public static CartFlutterEngineBinding provideCartFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (CartFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideCartFlutterBinding(map));
    }

    public CartFlutterEngineBinding get() {
        return provideCartFlutterBinding(this.channelsProvider.get());
    }
}
