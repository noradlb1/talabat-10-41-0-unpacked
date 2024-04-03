package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideGlobalMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<GlobalChannelCallback> globalChannelCallbackProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideGlobalMethodChannelFactory(Provider<GlobalChannelCallback> provider, Provider<IObservabilityManager> provider2) {
        this.globalChannelCallbackProvider = provider;
        this.observabilityManagerProvider = provider2;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideGlobalMethodChannelFactory create(Provider<GlobalChannelCallback> provider, Provider<IObservabilityManager> provider2) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideGlobalMethodChannelFactory(provider, provider2);
    }

    public static PlatformChannel provideGlobalMethodChannel(GlobalChannelCallback globalChannelCallback, IObservabilityManager iObservabilityManager) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideGlobalMethodChannel(globalChannelCallback, iObservabilityManager));
    }

    public PlatformChannel get() {
        return provideGlobalMethodChannel(this.globalChannelCallbackProvider.get(), this.observabilityManagerProvider.get());
    }
}
