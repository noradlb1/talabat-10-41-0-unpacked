package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.apicallmocks.ApiCallMocksFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideApiMocksFlutterBindingFactory implements Factory<ApiCallMocksFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideApiMocksFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideApiMocksFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideApiMocksFlutterBindingFactory(provider);
    }

    public static ApiCallMocksFlutterEngineBinding provideApiMocksFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (ApiCallMocksFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideApiMocksFlutterBinding(map));
    }

    public ApiCallMocksFlutterEngineBinding get() {
        return provideApiMocksFlutterBinding(this.channelsProvider.get());
    }
}
