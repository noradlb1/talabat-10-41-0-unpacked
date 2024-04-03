package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.domain.dynamictrackingcache.IDynamicTrackingCacheFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideDynamicTrackingCacheFlutterEngineBindingFactory implements Factory<IDynamicTrackingCacheFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideDynamicTrackingCacheFlutterEngineBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideDynamicTrackingCacheFlutterEngineBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideDynamicTrackingCacheFlutterEngineBindingFactory(provider);
    }

    public static IDynamicTrackingCacheFlutterEngineBinding provideDynamicTrackingCacheFlutterEngineBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (IDynamicTrackingCacheFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideDynamicTrackingCacheFlutterEngineBinding(map));
    }

    public IDynamicTrackingCacheFlutterEngineBinding get() {
        return provideDynamicTrackingCacheFlutterEngineBinding(this.channelsProvider.get());
    }
}
