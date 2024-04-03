package com.talabat.core.flutter.channels.impl.data.featureflags;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FeatureFlagChannelCallbackImpl_Factory implements Factory<FeatureFlagChannelCallbackImpl> {
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<RemoteConfiguration> remoteConfigProvider;
    private final Provider<IObservabilityManager> talabatObservabilityProvider;

    public FeatureFlagChannelCallbackImpl_Factory(Provider<IObservabilityManager> provider, Provider<ITalabatFeatureFlag> provider2, Provider<RemoteConfiguration> provider3) {
        this.talabatObservabilityProvider = provider;
        this.featureFlagsProvider = provider2;
        this.remoteConfigProvider = provider3;
    }

    public static FeatureFlagChannelCallbackImpl_Factory create(Provider<IObservabilityManager> provider, Provider<ITalabatFeatureFlag> provider2, Provider<RemoteConfiguration> provider3) {
        return new FeatureFlagChannelCallbackImpl_Factory(provider, provider2, provider3);
    }

    public static FeatureFlagChannelCallbackImpl newInstance(IObservabilityManager iObservabilityManager, ITalabatFeatureFlag iTalabatFeatureFlag, RemoteConfiguration remoteConfiguration) {
        return new FeatureFlagChannelCallbackImpl(iObservabilityManager, iTalabatFeatureFlag, remoteConfiguration);
    }

    public FeatureFlagChannelCallbackImpl get() {
        return newInstance(this.talabatObservabilityProvider.get(), this.featureFlagsProvider.get(), this.remoteConfigProvider.get());
    }
}
