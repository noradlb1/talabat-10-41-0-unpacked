package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.ordertrackingdependencies.OrderTrackingDependenciesFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideOrderTrackingDependenciesFlutterBindingFactory implements Factory<OrderTrackingDependenciesFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideOrderTrackingDependenciesFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideOrderTrackingDependenciesFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideOrderTrackingDependenciesFlutterBindingFactory(provider);
    }

    public static OrderTrackingDependenciesFlutterEngineBinding provideOrderTrackingDependenciesFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (OrderTrackingDependenciesFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideOrderTrackingDependenciesFlutterBinding(map));
    }

    public OrderTrackingDependenciesFlutterEngineBinding get() {
        return provideOrderTrackingDependenciesFlutterBinding(this.channelsProvider.get());
    }
}
