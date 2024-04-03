package com.talabat.core.flutter.channels.impl.data.tracking;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AnalyticsMethodChannelCallbackImpl_Factory implements Factory<AnalyticsMethodChannelCallbackImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public AnalyticsMethodChannelCallbackImpl_Factory(Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2, Provider<TalabatTracker> provider3) {
        this.contextProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
        this.talabatTrackerProvider = provider3;
    }

    public static AnalyticsMethodChannelCallbackImpl_Factory create(Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2, Provider<TalabatTracker> provider3) {
        return new AnalyticsMethodChannelCallbackImpl_Factory(provider, provider2, provider3);
    }

    public static AnalyticsMethodChannelCallbackImpl newInstance(Context context, ITalabatFeatureFlag iTalabatFeatureFlag, TalabatTracker talabatTracker) {
        return new AnalyticsMethodChannelCallbackImpl(context, iTalabatFeatureFlag, talabatTracker);
    }

    public AnalyticsMethodChannelCallbackImpl get() {
        return newInstance(this.contextProvider.get(), this.talabatFeatureFlagProvider.get(), this.talabatTrackerProvider.get());
    }
}
