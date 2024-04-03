package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.qcommerce.QCommerceFlutterEngineBinding;
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
public final class FlutterBindingFeatureLibModule_ProvideQCommerceFlutterEngineBindingFactory implements Factory<QCommerceFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingFeatureLibModule_ProvideQCommerceFlutterEngineBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingFeatureLibModule_ProvideQCommerceFlutterEngineBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingFeatureLibModule_ProvideQCommerceFlutterEngineBindingFactory(provider);
    }

    public static QCommerceFlutterEngineBinding provideQCommerceFlutterEngineBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (QCommerceFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingFeatureLibModule.INSTANCE.provideQCommerceFlutterEngineBinding(map));
    }

    public QCommerceFlutterEngineBinding get() {
        return provideQCommerceFlutterEngineBinding(this.channelsProvider.get());
    }
}
