package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.sharedprefs.SharedPreferencesFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideSharedPreferencesFlutterBindingFactory implements Factory<SharedPreferencesFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideSharedPreferencesFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideSharedPreferencesFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideSharedPreferencesFlutterBindingFactory(provider);
    }

    public static SharedPreferencesFlutterEngineBinding provideSharedPreferencesFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (SharedPreferencesFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideSharedPreferencesFlutterBinding(map));
    }

    public SharedPreferencesFlutterEngineBinding get() {
        return provideSharedPreferencesFlutterBinding(this.channelsProvider.get());
    }
}
