package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideObservabilityMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<ObservabilityChannelCallback> observabilityChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideObservabilityMethodChannelFactory(Provider<ObservabilityChannelCallback> provider) {
        this.observabilityChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideObservabilityMethodChannelFactory create(Provider<ObservabilityChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideObservabilityMethodChannelFactory(provider);
    }

    public static PlatformChannel provideObservabilityMethodChannel(ObservabilityChannelCallback observabilityChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideObservabilityMethodChannel(observabilityChannelCallback));
    }

    public PlatformChannel get() {
        return provideObservabilityMethodChannel(this.observabilityChannelCallbackProvider.get());
    }
}
