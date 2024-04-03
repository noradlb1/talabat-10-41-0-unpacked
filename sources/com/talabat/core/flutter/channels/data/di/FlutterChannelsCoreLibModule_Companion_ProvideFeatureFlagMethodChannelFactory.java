package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideFeatureFlagMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<FeatureFlagChannelCallback> featureFlagChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideFeatureFlagMethodChannelFactory(Provider<FeatureFlagChannelCallback> provider) {
        this.featureFlagChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideFeatureFlagMethodChannelFactory create(Provider<FeatureFlagChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideFeatureFlagMethodChannelFactory(provider);
    }

    public static PlatformChannel provideFeatureFlagMethodChannel(FeatureFlagChannelCallback featureFlagChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideFeatureFlagMethodChannel(featureFlagChannelCallback));
    }

    public PlatformChannel get() {
        return provideFeatureFlagMethodChannel(this.featureFlagChannelCallbackProvider.get());
    }
}
