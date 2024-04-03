package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideHelpCenterMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<OrderTrackingDependenciesChannelCallback> orderTrackingDependenciesChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideHelpCenterMethodChannelFactory(Provider<OrderTrackingDependenciesChannelCallback> provider) {
        this.orderTrackingDependenciesChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideHelpCenterMethodChannelFactory create(Provider<OrderTrackingDependenciesChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideHelpCenterMethodChannelFactory(provider);
    }

    public static PlatformChannel provideHelpCenterMethodChannel(OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideHelpCenterMethodChannel(orderTrackingDependenciesChannelCallback));
    }

    public PlatformChannel get() {
        return provideHelpCenterMethodChannel(this.orderTrackingDependenciesChannelCallbackProvider.get());
    }
}
