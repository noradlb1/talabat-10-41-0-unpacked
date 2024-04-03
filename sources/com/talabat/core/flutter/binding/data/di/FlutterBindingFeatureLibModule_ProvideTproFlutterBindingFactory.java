package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.tpro.TproFlutterEngineBinding;
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
public final class FlutterBindingFeatureLibModule_ProvideTproFlutterBindingFactory implements Factory<TproFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingFeatureLibModule_ProvideTproFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingFeatureLibModule_ProvideTproFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingFeatureLibModule_ProvideTproFlutterBindingFactory(provider);
    }

    public static TproFlutterEngineBinding provideTproFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (TproFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingFeatureLibModule.INSTANCE.provideTproFlutterBinding(map));
    }

    public TproFlutterEngineBinding get() {
        return provideTproFlutterBinding(this.channelsProvider.get());
    }
}
