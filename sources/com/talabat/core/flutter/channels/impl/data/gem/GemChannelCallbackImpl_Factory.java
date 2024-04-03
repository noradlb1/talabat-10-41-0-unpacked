package com.talabat.core.flutter.channels.impl.data.gem;

import android.content.Context;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GemChannelCallbackImpl_Factory implements Factory<GemChannelCallbackImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public GemChannelCallbackImpl_Factory(Provider<Context> provider, Provider<ITalabatExperiment> provider2) {
        this.contextProvider = provider;
        this.talabatExperimentProvider = provider2;
    }

    public static GemChannelCallbackImpl_Factory create(Provider<Context> provider, Provider<ITalabatExperiment> provider2) {
        return new GemChannelCallbackImpl_Factory(provider, provider2);
    }

    public static GemChannelCallbackImpl newInstance(Context context, ITalabatExperiment iTalabatExperiment) {
        return new GemChannelCallbackImpl(context, iTalabatExperiment);
    }

    public GemChannelCallbackImpl get() {
        return newInstance(this.contextProvider.get(), this.talabatExperimentProvider.get());
    }
}
