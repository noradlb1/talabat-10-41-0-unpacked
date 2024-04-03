package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideExperimentMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<ExperimentChannelCallback> experimentChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideExperimentMethodChannelFactory(Provider<ExperimentChannelCallback> provider) {
        this.experimentChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideExperimentMethodChannelFactory create(Provider<ExperimentChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideExperimentMethodChannelFactory(provider);
    }

    public static PlatformChannel provideExperimentMethodChannel(ExperimentChannelCallback experimentChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideExperimentMethodChannel(experimentChannelCallback));
    }

    public PlatformChannel get() {
        return provideExperimentMethodChannel(this.experimentChannelCallbackProvider.get());
    }
}
